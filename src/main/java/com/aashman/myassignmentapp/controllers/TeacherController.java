package com.aashman.myassignmentapp.controllers;

import java.util.ArrayList;
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
import com.aashman.myassignmentapp.models.NotificationOfTeacher;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.McAssignmentRepository;
import com.aashman.myassignmentapp.repos.McQuestionsRepository;
import com.aashman.myassignmentapp.repos.NotificationOfTeacherRepository;
import com.aashman.myassignmentapp.repos.StudentRequestRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.aashman.myassignmentapp.service.McAssignmentService;
import com.aashman.myassignmentapp.service.StudentRequestService;
import com.aashman.myassignmentapp.service.StudentService;
import com.aashman.myassignmentapp.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	TeacherService teacherService;

	@Autowired
	StudentRequestRepository srRepository;

	@Autowired
	StudentRequestService srService;

	@Autowired
	StudentService studentService;

	@Autowired
	McAssignmentRepository mcAssignmentRepository;

	@Autowired
	McQuestionsRepository mcqRepository;

	@Autowired
	McAssignmentService mcAService;

	@Autowired
	NotificationOfTeacherRepository notRepository;

	@RequestMapping("/teacherLogIn")
	public String showTeacherLogIn() {
		return "login/teacherLogIn";
	}

	@RequestMapping("/signUpTeacher")
	public String signUpTeacher() {
		return "login/teacherSignUp";
	}

	@RequestMapping(value = "/registerTeacher", method = RequestMethod.POST)
	@Transactional
	public String registerStudent(@ModelAttribute Teacher teacher, Model model) {
		if (teacherService.addTeacher(teacher)) {
			model.addAttribute("message", "Sign Up Sucessfully,Click Log In To Log In.");
			return "login/teacherSignUp";
		} else {
			model.addAttribute("msg", "Please try again something went wrong");
			return "login/teacherSignUp";
		}
	}

	@RequestMapping(value = "/enterTeacherHome", method = RequestMethod.POST)
	public String enterTeacherHome(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("activeTeacher", username);
		if (teacherService.enterTeacherHomePage(username, password)) {
			return "TeacherHome";
		} else {
			model.addAttribute("msg", "Username or password is incorrect please try again");
			return "index";
		}
	}

	@RequestMapping("/showTeacherHome")
	public String showTeacherHome(HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher") == null) {
			return "index";
		}
		return "TeacherHome";
	}

	@RequestMapping("/showTeacherAccount")
	public String showTeacherAccount(HttpServletRequest request, Model model) {
		String userName = (String) request.getSession().getAttribute("activeTeacher");
		if (userName == null) {
			return "index";
		}
		model.addAttribute("LoggedInTeacher", teacherService.findTeacherByUserName(userName));
		return "teacher/account";
	}

	@RequestMapping("/showTeacherAssignments")
	public String showTeacherAssignments(HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher") == null) {
			return "index";
		}
		return "teacher/assignments";
	}

	@RequestMapping("/showTeacherNotifications")
	public String showTeacherStudentRequests(HttpServletRequest request, Model model, HttpSession session) {
		if (request.getSession().getAttribute("activeTeacher") == null) {
			return "index";
		}
		List<NotificationOfTeacher> allNotifications = notRepository.findAll();
		List<NotificationOfTeacher> notifications = new ArrayList<NotificationOfTeacher>();
		Teacher teacher = teacherService.findTeacherByUserName((String) session.getAttribute("activeTeacher"));
		for (NotificationOfTeacher not : allNotifications) {
			if (not.getTeacherId() == teacher.getTeacherId()) {
				notifications.add(not);
			}
		}
		model.addAttribute("notificationsOfTeacher", notifications);
		return "teacher/notifications";
	}

	@RequestMapping("/showTeacherStudents")
	public String showTeacherStudents(HttpServletRequest request, Model model) {
		String teacherUserName = (String) request.getSession().getAttribute("activeTeacher");
		if (teacherUserName == null) {
			return "index";
		}
		Teacher teacher = teacherService.findTeacherByUserName(teacherUserName);
		Set<Student> students = teacher.getStudent();
		model.addAttribute("studentsOfActiveTeacher", students);
		return "teacher/students";
	}

	@RequestMapping("/showTeacherStudentRequests")
	public String showTeacherNotifications(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("activeTeacher");
		if (username == null) {
			return "index";
		} else {
			List<Student> allStudentRequests = srService
					.findSrOfActiveTeacher(teacherService.findTeacherByUserName(username));
			model.addAttribute("allStudentRequests", allStudentRequests);
			return "teacher/studentrequests";
		}
	}

	@RequestMapping("/addStudentToList")
	@Transactional
	public String addStudentToList(@RequestParam("studentId") int studentId,
			@RequestParam("activeTeacher") String teacherUserName, Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher") == null) {
			return "index";
		}
		Teacher teacher = teacherService.findTeacherByUserName(teacherUserName);
		Student student = studentService.findStudentByIntegerId(studentId);
		List<Student> allStudentRequests = srService.findSrOfActiveTeacher(teacher);
		if (teacherService.addStudentToList(student, teacherUserName, teacher) && student.getTeachers().add(teacher)) {
			allStudentRequests = srService.findSrOfActiveTeacher(teacher);
			model.addAttribute("allStudentRequests", allStudentRequests);
			model.addAttribute("studentAddedMessage", "Student added!");
			return "teacher/studentrequests";
		}
		model.addAttribute("allStudentRequests", allStudentRequests);
		return "teacher/studentrequests";
	}

	@RequestMapping("/logOutTeacher")
	public String logOutTeacher(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	@RequestMapping(value = "/addMcAssignment", method = RequestMethod.POST)
	@Transactional
	public String addMcAssignment(@ModelAttribute MultipleChoiceAssignment mcAssignment, HttpSession session,
			Model model) {
		if (session.getAttribute("activeTeacher") == null) {
			return "index";
		}
		mcAssignment.setTeacher(teacherService.findTeacherByUserName((String) session.getAttribute("activeTeacher")));
		MultipleChoiceAssignment mcA = mcAssignmentRepository.save(mcAssignment);
		model.addAttribute("assignmentcreatedmessage",
				"Assignment created. Please remember your assignment id to insert questions in it. Your Assignment Id: "
						+ mcA.getId());
		return "teacher/assignments";
	}

	@RequestMapping("/insertQuestionsToMc")
	@Transactional
	public String insertQuestionsToMc(@RequestParam("assignmentId") int assignmentId, HttpSession session, Model model,
			@ModelAttribute McQuestion mcq) {
		MultipleChoiceAssignment mcA = mcAssignmentRepository.findById(assignmentId).get();
		if (mcA == null) {
			model.addAttribute("doesNotExist", "Assignment does not exist.");
			return "teacher/assignments";
		}
		Teacher t1 = mcA.getTeacher();
		Teacher t2 = teacherService.findTeacherByUserName((String) session.getAttribute("activeTeacher"));
		if (t1 != t2) {
			model.addAttribute("notBelong", "Assignment with id:" + assignmentId + " does not belong to you");
			return "teacher/assignments";
		}
		if (mcA.getQuestion().size() >= 10) {
			model.addAttribute("maximumNumberError",
					"You can not add more than 10 questions in a assignment! Please create part 2.");
			return "teacher/assignments";
		}
		mcq.setMcAssignment(mcA);
		mcqRepository.save(mcq);
		mcA.getQuestion().add(mcq);
		mcAssignmentRepository.save(mcA);
		model.addAttribute("questionAdded", "Question added. You can add more.");
		return "teacher/assignments";
	}

	@RequestMapping("/editTeacher")
	public String editStudent(HttpSession session, Model model) {
		Teacher teacher = teacherService.findTeacherByUserName((String) session.getAttribute("activeTeacher"));
		model.addAttribute("teacherForUpdate", teacher);
		return "teacher/teacherAccountEditForm";
	}

	@RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
	public String editTeacher(@ModelAttribute Teacher updatedTeacher, Model model, HttpSession session) {
		Teacher teacher = teacherService.findTeacherByUserName((String) session.getAttribute("activeTeacher"));
		updatedTeacher.setTeacherId(teacher.getTeacherId());
		teacherService.updateTeacher(teacher, updatedTeacher);
		model.addAttribute("msg", "updated succesfully");
		return "teacher/teacherAccountEditForm";
	}
}
