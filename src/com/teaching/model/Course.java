package com.teaching.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "courseinfo", catalog = "onlineteaching")
public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private String courseName;
	private String courseContent;
	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);
	private Set<CourseTA> courseTAs = new HashSet<CourseTA>(0);
	private Set<Resource> resources = new HashSet<Resource>(0);
	private Set<Assignment> assignments = new HashSet<Assignment>(0);
	private Set<Question> questions = new HashSet<Question>(0);
	private Set<CourseStudent> courseStudents = new HashSet<CourseStudent>(0);
	private Set<Announcement> announcements = new HashSet<Announcement>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String courseName, String courseContent,
			Set<CourseTeacher> courseTeachers, Set<CourseTA> courseTAs,
			Set<Resource> resources, Set<Assignment> assignments,
			Set<Question> questions, Set<CourseStudent> courseStudents,
			Set<Announcement> announcements) {
		this.courseName = courseName;
		this.courseContent = courseContent;
		this.courseTeachers = courseTeachers;
		this.courseTAs = courseTAs;
		this.resources = resources;
		this.assignments = assignments;
		this.questions = questions;
		this.courseStudents = courseStudents;
		this.announcements = announcements;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CourseID", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "CourseName", length = 100)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "CourseContent", length = 1000)
	public String getCourseContent() {
		return this.courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<CourseTeacher> getCourseTeachers() {
		return this.courseTeachers;
	}

	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
		this.courseTeachers = courseTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<CourseTA> getCourseTAs() {
		return this.courseTAs;
	}

	public void setCourseTAs(Set<CourseTA> courseTAs) {
		this.courseTAs = courseTAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Assignment> getAssignments() {
		return this.assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<CourseStudent> getCourseStudents() {
		return this.courseStudents;
	}

	public void setCourseStudents(Set<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}

}