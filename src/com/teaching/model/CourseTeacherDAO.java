package com.teaching.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseTeacher entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.teaching.model.CourseTeacher
 * @author MyEclipse Persistence Tools
 */

public class CourseTeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CourseTeacherDAO.class);

	// property constants

	public void save(CourseTeacher transientInstance) {
		log.debug("saving CourseTeacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CourseTeacher persistentInstance) {
		log.debug("deleting CourseTeacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CourseTeacher findById(java.lang.Integer id) {
		log.debug("getting CourseTeacher instance with id: " + id);
		try {
			CourseTeacher instance = (CourseTeacher) getSession().get(
					"com.teaching.model.CourseTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CourseTeacher> findByExample(CourseTeacher instance) {
		log.debug("finding CourseTeacher instance by example");
		try {
			List<CourseTeacher> results = (List<CourseTeacher>) getSession()
					.createCriteria("com.teaching.model.CourseTeacher")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CourseTeacher instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CourseTeacher as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CourseTeacher instances");
		try {
			String queryString = "from CourseTeacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CourseTeacher merge(CourseTeacher detachedInstance) {
		log.debug("merging CourseTeacher instance");
		try {
			CourseTeacher result = (CourseTeacher) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CourseTeacher instance) {
		log.debug("attaching dirty CourseTeacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CourseTeacher instance) {
		log.debug("attaching clean CourseTeacher instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}