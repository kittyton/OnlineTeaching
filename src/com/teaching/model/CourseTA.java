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
 * CourseTA entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tainfo", catalog = "onlineteaching")
public class CourseTA implements java.io.Serializable {

	// Fields

	private Integer tainforId;
	private User user;
	private Course course;

	// Constructors

	/** default constructor */
	public CourseTA() {
	}

	/** full constructor */
	public CourseTA(User user, Course course) {
		this.user = user;
		this.course = course;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "TAInforID", unique = true, nullable = false)
	public Integer getTainforId() {
		return this.tainforId;
	}

	public void setTainforId(Integer tainforId) {
		this.tainforId = tainforId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ForCourse", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}