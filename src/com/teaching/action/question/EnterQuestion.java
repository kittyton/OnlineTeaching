package com.teaching.action.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.model.Question;
import com.teaching.model.QuestionDAO;
import com.teaching.model.Reply;

public class EnterQuestion extends ActionSupport {

	private int questionID;
	List<Reply> replies = new ArrayList<Reply>();
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	/**功能：进入问题， 问题详细信息及回复
	 * 开发人员：
	 * 开发日期：2013/5/?
	 * 修改人员：
	 * 修改日期：
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		
		QuestionDAO questionDAO = new QuestionDAO();
		
		Question question = questionDAO.findById(questionID);
		questionDAO.getSession().refresh(question);
		if(question != null){
			Set<Reply>res = question.getReplies();
			Iterator<Reply> it = res.iterator();
			while(it.hasNext()){
				Reply reply = it.next();
				replies.add(reply);
			}
		}
		return SUCCESS;
	}
}