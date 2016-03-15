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
 * Question entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publicquestioninfo", catalog = "onlineteaching")
public class Question implements java.io.Serializable {

	// Fields

	private Integer questionId;
	private Course course;
	private User user;
	private String questionContent;
	private String askTime;
	private String replyNum;
	private String viewNum;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** full constructor */
	public Question(Course course, User user, String questionContent,
			String askTime, String replyNum, String viewNum, Set<Reply> replies) {
		this.course = course;
		this.user = user;
		this.questionContent = questionContent;
		this.askTime = askTime;
		this.replyNum = replyNum;
		this.viewNum = viewNum;
		this.replies = replies;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "QuestionID", unique = true, nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QuestionCourse")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QuestionAsker")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "QuestionContent", length = 1000)
	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Column(name = "AskTime", length = 20)
	public String getAskTime() {
		return this.askTime;
	}

	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}

	@Column(name = "ReplyNum", length = 20)
	public String getReplyNum() {
		return this.replyNum;
	}

	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}

	@Column(name = "ViewNum", length = 20)
	public String getViewNum() {
		return this.viewNum;
	}

	public void setViewNum(String viewNum) {
		this.viewNum = viewNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}