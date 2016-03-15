package com.teaching.action.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.teaching.model.Course;
import com.teaching.model.CourseDAO;
import com.teaching.model.Question;
import com.teaching.model.QuestionDAO;

public class QuestionByCourseID extends ActionSupport {
	private int courseID;
	private List<QuestionInfo> questions = new ArrayList<QuestionInfo>();
	public List<QuestionInfo> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionInfo> questions) {
		this.questions = questions;
	}
	public int getCourseID(){
		return courseID;
	}
	public void setCourseID(int courseID){
		this.courseID = courseID;
	}
	/**功能：某个课程的所有问题
	 * 开发人员：
	 * 开发日期：2013/5/?
	 * 修改人员：
	 * 修改日期：
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		CourseDAO courseDAO = new CourseDAO();
		
		Course course = courseDAO.findById(courseID);
		courseDAO.getSession().refresh(course);
		if(course != null){
			Set<Question> qs =  course.getQuestions();
			Iterator<Question> it = qs.iterator();
			while(it.hasNext()){
				Question q = it.next();
				QuestionInfo question = new QuestionInfo(q.getQuestionId(),q.getUser().getRealName(),q.getQuestionContent(),
						q.getQuestionContent(),q.getAskTime(),q.getReplyNum(),q.getViewNum());
				questions.add(question);
			}
		}
		return SUCCESS;
	}
}

class QuestionInfo{
	private int questionID;
	private String asker;
	private String title;
	private String content;
	private String askTime;
	private String replyNum;
	private String viewNum;
	public QuestionInfo(int questionID, String asker, String title, String content, String askTime, String replyNum, String viewNum){
		this.questionID = questionID;
		this.setAsker(asker);
		this.setTitle(title);
		this.setContent(content);
		this.setAskTime(askTime);
		this.setReplyNum(replyNum);
		this.setViewNum(viewNum);
	}
	public String getAsker() {
		return asker;
	}
	public void setAsker(String asker) {
		this.asker = asker;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAskTime() {
		return askTime;
	}
	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}
	public String getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}
	public String getViewNum() {
		return viewNum;
	}
	public void setViewNum(String viewNum) {
		this.viewNum = viewNum;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
}