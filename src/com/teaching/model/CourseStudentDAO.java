package com.teaching.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseStudent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.teaching.model.CourseStudent
 * @author MyEclipse Persistence Tools
 */

public class CourseStudentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CourseStudentDAO.class);

	// property constants

	public void save(CourseStudent transientInstance) {
		log.debug("saving CourseStudent instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CourseStudent persistentInstance) {
		log.debug("deleting CourseStudent instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CourseStudent findById(java.lang.Integer id) {
		log.debug("getting CourseStudent instance with id: " + id);
		try {
			CourseStudent instance = (CourseStudent) getSession().get(
					"com.teaching.model.CourseStudent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CourseStudent> findByExample(CourseStudent instance) {
		log.debug("finding CourseStudent instance by example");
		try {
			List<CourseStudent> results = (List<CourseStudent>) getSession()
					.createCriteria("com.teaching.model.CourseStudent")
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
		log.debug("finding CourseStudent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CourseStudent as model where model."
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
		log.debug("finding all CourseStudent instances");
		try {
			String queryString = "from CourseStudent";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CourseStudent merge(CourseStudent detachedInstance) {
		log.debug("merging CourseStudent instance");
		try {
			CourseStudent result = (CourseStudent) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CourseStudent instance) {
		log.debug("attaching dirty CourseStudent instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CourseStudent instance) {
		log.debug("attaching clean CourseStudent instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}