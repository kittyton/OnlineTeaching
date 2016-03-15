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
 * Delivery entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "deliveryinfo", catalog = "onlineteaching")
public class Delivery implements java.io.Serializable {

	// Fields

	private Integer deliveryId;
	private User user;
	private Assignment assignment;
	private String deliveryAddress;
	private String deliveryTime;
	private String assignmentReply;
	private String assignmentGrrade;
	private String correctTime;

	// Constructors

	/** default constructor */
	public Delivery() {
	}

	/** full constructor */
	public Delivery(User user, Assignment assignment, String deliveryAddress,
			String deliveryTime, String assignmentReply,
			String assignmentGrrade, String correctTime) {
		this.user = user;
		this.assignment = assignment;
		this.deliveryAddress = deliveryAddress;
		this.deliveryTime = deliveryTime;
		this.assignmentReply = assignmentReply;
		this.assignmentGrrade = assignmentGrrade;
		this.correctTime = correctTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DeliveryID", unique = true, nullable = false)
	public Integer getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Deliverier")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeliveryAssignment")
	public Assignment getAssignment() {
		return this.assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Column(name = "DeliveryAddress", length = 300)
	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Column(name = "DeliveryTime", length = 20)
	public String getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Column(name = "AssignmentReply", length = 1000)
	public String getAssignmentReply() {
		return this.assignmentReply;
	}

	public void setAssignmentReply(String assignmentReply) {
		this.assignmentReply = assignmentReply;
	}

	@Column(name = "AssignmentGrrade", length = 10)
	public String getAssignmentGrrade() {
		return this.assignmentGrrade;
	}

	public void setAssignmentGrrade(String assignmentGrrade) {
		this.assignmentGrrade = assignmentGrrade;
	}

	@Column(name = "CorrectTime", length = 20)
	public String getCorrectTime() {
		return this.correctTime;
	}

	public void setCorrectTime(String correctTime) {
		this.correctTime = correctTime;
	}

}