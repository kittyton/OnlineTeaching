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
 * CourseStudent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "coursestudent", catalog = "onlineteaching")
public class CourseStudent implements java.io.Serializable {

	// Fields

	private Integer couStudentId;
	private User user;
	private Course course;

	// Constructors

	/** default constructor */
	public CourseStudent() {
	}

	/** full constructor */
	public CourseStudent(User user, Course course) {
		this.user = user;
		this.course = course;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "couStudentID", unique = true, nullable = false)
	public Integer getCouStudentId() {
		return this.couStudentId;
	}

	public void setCouStudentId(Integer couStudentId) {
		this.couStudentId = couStudentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sStudentID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sCourse", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}