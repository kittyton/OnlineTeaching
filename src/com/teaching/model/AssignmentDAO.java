package com.teaching.model;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Assignment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.teaching.model.Assignment
 * @author MyEclipse Persistence Tools
 */

public class AssignmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AssignmentDAO.class);
	// property constants
	public static final String ASSIGNMENT_CONTENT = "assignmentContent";
	public static final String ASSIGNMENT_TIME = "assignmentTime";
	public static final String ASSIGNMENT_DEADLINE = "assignmentDeadline";

	public void save(Assignment transientInstance) {
		log.debug("saving Assignment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Assignment persistentInstance) {
		log.debug("deleting Assignment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Assignment findById(java.lang.Integer id) {
		log.debug("getting Assignment instance with id: " + id);
		try {
			Assignment instance = (Assignment) getSession().get(
					"com.teaching.model.Assignment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Assignment> findByExample(Assignment instance) {
		log.debug("finding Assignment instance by example");
		try {
			List<Assignment> results = (List<Assignment>) getSession()
					.createCriteria("com.teaching.model.Assignment")
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
		log.debug("finding Assignment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Assignment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Assignment> findByAssignmentContent(Object assignmentContent) {
		return findByProperty(ASSIGNMENT_CONTENT, assignmentContent);
	}

	public List<Assignment> findByAssignmentTime(Object assignmentTime) {
		return findByProperty(ASSIGNMENT_TIME, assignmentTime);
	}

	public List<Assignment> findByAssignmentDeadline(Object assignmentDeadline) {
		return findByProperty(ASSIGNMENT_DEADLINE, assignmentDeadline);
	}

	public List findAll() {
		log.debug("finding all Assignment instances");
		try {
			String queryString = "from Assignment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Assignment merge(Assignment detachedInstance) {
		log.debug("merging Assignment instance");
		try {
			Assignment result = (Assignment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Assignment instance) {
		log.debug("attaching dirty Assignment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Assignment instance) {
		log.debug("attaching clean Assignment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}