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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "onlineteaching")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String realName;
	private Integer userType;
	private Integer userStatus;
	private Administrator administrator;
	private Set<Reply> replies = new HashSet<Reply>(0);
	private Set<CourseStudent> courseStudents = new HashSet<CourseStudent>(0);
	private Teacher teacher;
	private Set<Question> questions = new HashSet<Question>(0);
	private Set<Announcement> announcements = new HashSet<Announcement>(0);
	private Set<Resource> resources = new HashSet<Resource>(0);
	private Set<CourseTA> courseTAs = new HashSet<CourseTA>(0);
	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);
	private Set<Delivery> deliveries = new HashSet<Delivery>(0);
	private Student student;
	private Set<Assignment> assignments = new HashSet<Assignment>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String password, String realName,
			Integer userType, Integer userStatus, Administrator administrator,
			Set<Reply> replies, Set<CourseStudent> courseStudents,
			Teacher teacher, Set<Question> questions,
			Set<Announcement> announcements, Set<Resource> resources,
			Set<CourseTA> courseTAs, Set<CourseTeacher> courseTeachers,
			Set<Delivery> deliveries, Student student,
			Set<Assignment> assignments) {
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.userType = userType;
		this.userStatus = userStatus;
		this.administrator = administrator;
		this.replies = replies;
		this.courseStudents = courseStudents;
		this.teacher = teacher;
		this.questions = questions;
		this.announcements = announcements;
		this.resources = resources;
		this.courseTAs = courseTAs;
		this.courseTeachers = courseTeachers;
		this.deliveries = deliveries;
		this.student = student;
		this.assignments = assignments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "UserID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", length = 15)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", length = 10)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "RealName", length = 10)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "UserType")
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Column(name = "UserStatus")
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CourseStudent> getCourseStudents() {
		return this.courseStudents;
	}

	public void setCourseStudents(Set<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CourseTA> getCourseTAs() {
		return this.courseTAs;
	}

	public void setCourseTAs(Set<CourseTA> courseTAs) {
		this.courseTAs = courseTAs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CourseTeacher> getCourseTeachers() {
		return this.courseTeachers;
	}

	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
		this.courseTeachers = courseTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Assignment> getAssignments() {
		return this.assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

}