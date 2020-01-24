package com.aashman.myassignmentapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mcassignment")
public class MultipleChoiceAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mcassignment_id")
	private int id;
	private String topic;

	@OneToMany(mappedBy = "mcAssignment")
	private List<McQuestion> question;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<McQuestion> getQuestion() {
		return question;
	}

	public void setQuestion(List<McQuestion> question) {
		this.question = question;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "MultipleChoiceAssignment [id=" + id + ", topic=" + topic + ", question=" + question + ", teacher="
				+ teacher + "]";
	}
	
}
