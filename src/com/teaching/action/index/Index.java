package com.teaching.action.index;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.model.Course;

public class Index extends ActionSupport {

	/**功能：获取所有课程信息（如课程名字，任课老师），会由struts2传到首页index.jsp
	 * 开发人员：李晨曦
	 * 开发日期：2013/5/9
	 * 修改人员：
	 * 修改日期：
	 */
	private String message;
	public String getMessage(){
		return message;
	}
	private ArrayList<Course> courses;
	private ArrayList<Course> getCourses(){
		return courses;
	}
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		message = "the first";
		return SUCCESS;
	}
}