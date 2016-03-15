package com.teaching.action.question;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.global.UnReadManager;

public class UnReadReply extends ActionSupport {

	private int userID;
	private int questionID;
	private static UnReadManager unReadManager = UnReadManager.getInstance();
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		userID = 1;
		questionID = unReadManager.get(userID);
		System.out.println(questionID);
		return SUCCESS;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
}