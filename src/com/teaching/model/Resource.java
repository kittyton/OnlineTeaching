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
 * Resource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resourseinfo", catalog = "onlineteaching")
public class Resource implements java.io.Serializable {

	// Fields

	private Integer resourseId;
	private User user;
	private Course course;
	private String resourseName;
	private String resourseType;
	private String resourseSize;
	private String resourseAddress;
	private String resourseUploadTime;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(User user, Course course, String resourseName,
			String resourseType, String resourseSize, String resourseAddress,
			String resourseUploadTime) {
		this.user = user;
		this.course = course;
		this.resourseName = resourseName;
		this.resourseType = resourseType;
		this.resourseSize = resourseSize;
		this.resourseAddress = resourseAddress;
		this.resourseUploadTime = resourseUploadTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ResourseID", unique = true, nullable = false)
	public Integer getResourseId() {
		return this.resourseId;
	}

	public void setResourseId(Integer resourseId) {
		this.resourseId = resourseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OwnedUser")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OwnedCourse")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "ResourseName", length = 100)
	public String getResourseName() {
		return this.resourseName;
	}

	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}

	@Column(name = "ResourseType", length = 15)
	public String getResourseType() {
		return this.resourseType;
	}

	public void setResourseType(String resourseType) {
		this.resourseType = resourseType;
	}

	@Column(name = "ResourseSize", length = 50)
	public String getResourseSize() {
		return this.resourseSize;
	}

	public void setResourseSize(String resourseSize) {
		this.resourseSize = resourseSize;
	}

	@Column(name = "ResourseAddress", length = 200)
	public String getResourseAddress() {
		return this.resourseAddress;
	}

	public void setResourseAddress(String resourseAddress) {
		this.resourseAddress = resourseAddress;
	}

	@Column(name = "ResourseUploadTime", length = 20)
	public String getResourseUploadTime() {
		return this.resourseUploadTime;
	}

	public void setResourseUploadTime(String resourseUploadTime) {
		this.resourseUploadTime = resourseUploadTime;
	}

}