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
 * Administrator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admininfo", catalog = "onlineteaching")
public class Administrator implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private User user;
	private String adminWorkLength;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(User user) {
		this.user = user;
	}

	/** full constructor */
	public Administrator(User user, String adminWorkLength) {
		this.user = user;
		this.adminWorkLength = adminWorkLength;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AdminID", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "AdminWorkLength", length = 30)
	public String getAdminWorkLength() {
		return this.adminWorkLength;
	}

	public void setAdminWorkLength(String adminWorkLength) {
		this.adminWorkLength = adminWorkLength;
	}

}