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
 * UnReadReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "unreadreply", catalog = "onlineteaching")
public class UnReadReply implements java.io.Serializable {

	// Fields

	private Integer unReadReplyId;
	private Reply reply;
	private User user;

	// Constructors

	/** default constructor */
	public UnReadReply() {
	}

	/** full constructor */
	public UnReadReply(Reply reply, User user) {
		this.reply = reply;
		this.user = user;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "UnReadReplyID", unique = true, nullable = false)
	public Integer getUnReadReplyId() {
		return this.unReadReplyId;
	}

	public void setUnReadReplyId(Integer unReadReplyId) {
		this.unReadReplyId = unReadReplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unReplyID")
	public Reply getReply() {
		return this.reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unUserID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}