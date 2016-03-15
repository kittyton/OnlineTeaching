package com.teaching.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Assignment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "assignmentinfo", catalog = "onlineteaching")
public class Assignment implements java.io.Serializable {

	// Fields

	private Integer assignmentId;
	private User user;
	private Course course;
	private String assignmentContent;
	private String assignmentTime;
	private String assignmentDeadline;
	private Set<Delivery> deliveries = new HashSet<Delivery>(0);

	// Constructors

	/** default constructor */
	public Assignment() {
	}

	/** full constructor */
	public Assignment(User user, Course course, String assignmentContent,
			String assignmentTime, String assignmentDeadline,
			Set<Delivery> deliveries) {
		this.user = user;
		this.course = course;
		this.assignmentContent = assignmentContent;
		this.assignmentTime = assignmentTime;
		this.assignmentDeadline = assignmentDeadline;
		this.deliveries = deliveries;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AssignmentID", unique = true, nullable = false)
	public Integer getAssignmentId() {
		return this.assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AssignmentSetter")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AssignmentCourse")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "AssignmentContent", length = 5000)
	public String getAssignmentContent() {
		return this.assignmentContent;
	}

	public void setAssignmentContent(String assignmentContent) {
		this.assignmentContent = assignmentContent;
	}

	@Column(name = "AssignmentTime", length = 20)
	public String getAssignmentTime() {
		return this.assignmentTime;
	}

	public void setAssignmentTime(String assignmentTime) {
		this.assignmentTime = assignmentTime;
	}

	@Column(name = "AssignmentDeadline", length = 20)
	public String getAssignmentDeadline() {
		return this.assignmentDeadline;
	}

	public void setAssignmentDeadline(String assignmentDeadline) {
		this.assignmentDeadline = assignmentDeadline;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "assignment")
	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

}