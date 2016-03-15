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
 * Announcement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "announcementinfo", catalog = "onlineteaching")
public class Announcement implements java.io.Serializable {

	// Fields

	private Integer announcementId;
	private Course course;
	private User user;
	private String announcementContent;
	private String announcementTime;

	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** full constructor */
	public Announcement(Course course, User user, String announcementContent,
			String announcementTime) {
		this.course = course;
		this.user = user;
		this.announcementContent = announcementContent;
		this.announcementTime = announcementTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AnnouncementID", unique = true, nullable = false)
	public Integer getAnnouncementId() {
		return this.announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AnnouncementCourse")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AnnouncementPublisher")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "AnnouncementContent", length = 1000)
	public String getAnnouncementContent() {
		return this.announcementContent;
	}

	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}

	@Column(name = "AnnouncementTime", length = 20)
	public String getAnnouncementTime() {
		return this.announcementTime;
	}

	public void setAnnouncementTime(String announcementTime) {
		this.announcementTime = announcementTime;
	}

}