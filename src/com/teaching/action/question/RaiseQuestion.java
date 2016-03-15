package com.teaching.action.question;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import HibernateManager.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.teaching.model.User;
import com.teaching.model.UserDAO;

public class RaiseQuestion extends ActionSupport {

	/**功能：提问
	 * 开发人员：李晨曦
	 * 开发日期：2013/5/10
	 * 修改人员：
	 * 修改日期：
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub

		UserDAO dao = new UserDAO();
		System.out.println(dao.findById(1).getUserName());
		//Query query = session.createQuery("from userinfo");
//		Transaction tx = session.beginTransaction();
//		tx.begin();
//		List list = new ArrayList();
//		list = query.list();
//		tx.commit();
//		System.out.println("number" + list.size());
		
		return null;
	}
}