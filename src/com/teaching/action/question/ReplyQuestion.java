package com.teaching.action.question;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.global.UnReadManager;
import com.teaching.model.Question;
import com.teaching.model.QuestionDAO;
import com.teaching.model.Reply;
import com.teaching.model.ReplyDAO;
import com.teaching.model.User;
import com.teaching.model.UserDAO;

public class ReplyQuestion extends ActionSupport {

	private int questionID;
	private String replyContent;
	/**功能：回复问题
	 * 开发人员：李晨曦
	 * 开发日期：2013/5/11
	 * 修改人员：
	 * 修改日期：
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(1);
		if(user == null){
			return ERROR;
		}
		UnReadManager unReadManager = UnReadManager.getInstance();
		QuestionDAO questionDAO = new QuestionDAO();
		Question question = questionDAO.findById(questionID);
		ReplyDAO replyDAO = new ReplyDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
		Reply reply = new Reply(user, question, replyContent,format.format(new Date()));
		Transaction tx = replyDAO.getSession().beginTransaction();
		tx.begin();
		replyDAO.save(reply);
		tx.commit();
		unReadManager.put(user.getUserId(), question.getQuestionId());
		System.out.println(user.getUserId());
		System.out.println(question.getQuestionId());
		return SUCCESS;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}