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
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publicreplyinfo", catalog = "onlineteaching")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private User user;
	private Question question;
	private String replyContent;
	private String replyTime;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(User user, Question question, String replyContent,
			String replyTime) {
		this.user = user;
		this.question = question;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ReplyID", unique = true, nullable = false)
	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Replier")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ForQuestion")
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "ReplyContent", length = 1000)
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "ReplyTime", length = 20)
	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

}