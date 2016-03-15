package com.teaching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "studentinfo", catalog = "onlineteaching")
public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private User user;
	private String studentGrade;
	private String studentGpa;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(User user) {
		this.user = user;
	}

	/** full constructor */
	public Student(User user, String studentGrade, String studentGpa) {
		this.user = user;
		this.studentGrade = studentGrade;
		this.studentGpa = studentGpa;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "StudentID", unique = true, nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "StudentGrade", length = 20)
	public String getStudentGrade() {
		return this.studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	@Column(name = "StudentGPA", length = 10)
	public String getStudentGpa() {
		return this.studentGpa;
	}

	public void setStudentGpa(String studentGpa) {
		this.studentGpa = studentGpa;
	}

}