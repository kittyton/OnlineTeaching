package com.teaching.action.index;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.model.Course;

public class Index extends ActionSupport {

	/**���ܣ���ȡ���пγ���Ϣ����γ����֣��ο���ʦ��������struts2������ҳindex.jsp
	 * ������Ա�����
	 * �������ڣ�2013/5/9
	 * �޸���Ա��
	 * �޸����ڣ�
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