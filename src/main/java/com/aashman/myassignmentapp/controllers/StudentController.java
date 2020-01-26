package com.aashman.myassignmentapp.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashman.myassignmentapp.models.McQuestion;
import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.models.NotificationOfStudent;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.McAssignmentRepository;
import com.aashman.myassignmentapp.repos.StudentRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.aashman.myassignmentapp.service.NotificationOfStudentService;
import com.aashman.myassignmentapp.service.NotificationOfTeacherService;
import com.aashman.myassignmentapp.service.StudentRequestService;
import com.aashman.myassignmentapp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRequestService studentRequestService;

	@Autowired
	NotificationOfStudentService nosService;

	@Autowired
	McAssignmentRepository mcaRepository;

	@Autowired
	NotificationOfTeacherService notService;

	@RequestMapping("/studentLogIn")
	public String showStudentLogIn() {
		return "login/studentLogIn";
	}

	@RequestMapping("/signUpStudent")
	public String signUpStudent() {
		return "login/studentSignUp";
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	@Transactional
	public String registerStudent(@ModelAttribute Student student, Model model) {
		if (studentService.addStudent(student)) {
			model.addAttribute("message", "Sign Up Sucessfully, Go back and Do Log In.");
			return "login/studentSignUp";
		} else {
			model.addAttribute("msg", "Please fill the boxes.");
			return "login/studentSignUp";
		}
	}

	@RequestMapping(value = "/enterStudentHome", method = RequestMethod.POST)
	public String logInStudent(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		if (studentService.enterStudentHomePage(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("student", studentService.findStudentByUserName(userName));
			return "StudentHome";
		} else {
			model.addAttribute("msg", "username or password is incorrect, please try again");
			return "index";
		}
	}

	@RequestMapping("/showStudentAccountPage")
	public String showStudentAccount(HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		return "student/account";
	}

	@RequestMapping("/showStudentTeachersPage")
	public String showStudentTeachers(Model model, HttpServletRequest studentRequest) {

		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}

		model.addAttribute("teacher", teacherRepository.findAll());

		Student student = (Student) studentRequest.getSession().getAttribute("student");
		List<StudentRequest> srs = studentRequestService.findSentRequestsOfAStudent(student.getStudentId());
		List<Teacher> sentSr = studentRequestService.findSentTeachersOfAStudent(srs);
		Student s = (Student) studentRequest.getSession().getAttribute("student");
		List<Teacher> availableTeachers = studentService
				.findAvailableTeachersOfStudent(studentService.findStudentByIntegerId(s.getStudentId()));
		model.addAttribute("teacher", availableTeachers);
		model.addAttribute("sentSr", sentSr);
		Set<Teacher> ownTeachers = s.getTeachers();
		model.addAttribute("ownTeachers", ownTeachers);
		return "student/teachers";
	}

	@RequestMapping("/showStudentAssignmentsPage")
	public String showStudentAssignments(HttpServletRequest studentRequest, Model model) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		List<MultipleChoiceAssignment> assignmentsOfStudent = studentService
				.findMcAssignmentsOfStudent((Student) studentRequest.getSession().getAttribute("student"));
		model.addAttribute("assignmentsOfStudent", assignmentsOfStudent);
		return "student/assignments";
	}

	@RequestMapping("/showStudentHome")
	public String showStudentHome(HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		return "StudentHome";
	}

	@RequestMapping("/showNotificationsPage")
	public String showNotifications(HttpServletRequest request, @RequestParam("studentId") int studentId, Model model) {
		List<NotificationOfStudent> nos = nosService.getNotificationsOfAStudent(studentId);
		if (request.getSession().getAttribute("student") == null) {
			return "index";
		}
		if (nos.equals(null)) {
			model.addAttribute("noNos", "You donot have any notifications yet!");
		} else {
			model.addAttribute("nos", nos);
		}
		return "student/notifications";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	@RequestMapping("/sendRequest")
	public String sendRequestToTeacher(@RequestParam("studentId") int studentId,
			@RequestParam("teacherId") int teacherId, Model model, HttpServletRequest request) {
		Teacher teacher = teacherRepository.findById(teacherId).get();

		if (studentRequestService.addStudentRequest((Integer) studentId, (Integer) teacherId)) {
			model.addAttribute("requestSentMsg", "request sent! wait to get response back !");
			model.addAttribute("beStudent", "Be" + teacher.getFirstName() + "'s Student");
		} else {
			model.addAttribute("errorsendingrequest",
					"Sorry request failed ! May be you have already clicked the link and sent the request!");
		}
		List<Teacher> availableTeachers = studentService
				.findAvailableTeachersOfStudent(studentService.findStudentByIntegerId(studentId));
		model.addAttribute("teacher", availableTeachers);
		Student student = (Student) request.getSession().getAttribute("student");
		List<StudentRequest> srs = studentRequestService.findSentRequestsOfAStudent(student.getStudentId());
		List<Teacher> sentSr = studentRequestService.findSentTeachersOfAStudent(srs);
		model.addAttribute("sentSr", sentSr);
		Set<Teacher> ownTeachers = student.getTeachers();
		model.addAttribute("ownTeachers", ownTeachers);
		return "student/teachers";
	}

	@RequestMapping("/submitAssignment")
	public String submitAssignment(@RequestParam(value = "1option", required = false) String option1,
			@RequestParam(value = "2option", required = false) String option2,
			@RequestParam(value = "3option", required = false) String option3,
			@RequestParam(value = "4option", required = false) String option4,
			@RequestParam(value = "5option", required = false) String option5,
			@RequestParam(value = "6option", required = false) String option6,
			@RequestParam(value = "7option", required = false) String option7,
			@RequestParam(value = "8option", required = false) String option8,
			@RequestParam(value = "9option", required = false) String option9,
			@RequestParam(value = "10option", required = false) String option10, HttpServletRequest studentRequest,
			Model model, @RequestParam("assignmentId") int assignmentId, HttpSession session) {

		MultipleChoiceAssignment mcAssignment = mcaRepository.findById(assignmentId).get();
		List<McQuestion> questions = mcAssignment.getQuestion();

		int mark = studentService.submitAssignment(questions, option1, option2, option3, option4, option5, option6,
				option7, option8, option9, option10);

		model.addAttribute("markInPercent", "You got " + mark + " out of " + questions.size());

		Student student = (Student) session.getAttribute("student");

		notService.addStudentDidAssignmentNotification(student.getStudentId(), mcAssignment,
				mcAssignment.getTeacher().getTeacherId(),
				" and got " + mark + " out of " + mcAssignment.getQuestion().size());
		List<MultipleChoiceAssignment> assignmentsOfStudent = studentService
				.findMcAssignmentsOfStudent((Student) studentRequest.getSession().getAttribute("student"));
		model.addAttribute("assignmentsOfStudent", assignmentsOfStudent);

		return "student/assignments";
	}

	@RequestMapping("/editStudent")
	public String editStudent() {
		return "student/studentAccountEditForm";
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute Student student, Model model) {
		studentService.updateStudent(student);
		model.addAttribute("studentUpdated" + "Student updated successfully!");
		return "student/studentAccountEditForm";
	}

}
