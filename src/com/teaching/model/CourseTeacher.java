package com.teaching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * CourseTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "courseteacher", catalog = "onlineteaching")
public class CourseTeacher implements java.io.Serializable {

	// Fields

	private Integer couTeacherId;
	private Course course;
	private User user;

	// Constructors

	/** default constructor */
	public CourseTeacher() {
	}

	/** full constructor */
	public CourseTeacher(Course course, User user) {
		this.course = course;
		this.user = user;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "couTeacherID", unique = true, nullable = false)
	public Integer getCouTeacherId() {
		return this.couTeacherId;
	}

	public void setCouTeacherId(Integer couTeacherId) {
		this.couTeacherId = couTeacherId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tCourse")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tTeacherID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}