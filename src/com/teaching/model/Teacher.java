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
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacherinfo", catalog = "onlineteaching")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private User user;
	private String teacherTitle;
	private String teacherWorkLength;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(User user) {
		this.user = user;
	}

	/** full constructor */
	public Teacher(User user, String teacherTitle, String teacherWorkLength) {
		this.user = user;
		this.teacherTitle = teacherTitle;
		this.teacherWorkLength = teacherWorkLength;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "TeacherID", unique = true, nullable = false)
	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "TeacherTitle", length = 30)
	public String getTeacherTitle() {
		return this.teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	@Column(name = "TeacherWorkLength", length = 30)
	public String getTeacherWorkLength() {
		return this.teacherWorkLength;
	}

	public void setTeacherWorkLength(String teacherWorkLength) {
		this.teacherWorkLength = teacherWorkLength;
	}

}