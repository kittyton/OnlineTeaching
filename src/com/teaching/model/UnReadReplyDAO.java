package com.teaching.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * UnReadReply entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.teaching.model.UnReadReply
 * @author MyEclipse Persistence Tools
 */

public class UnReadReplyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UnReadReplyDAO.class);

	// property constants

	public void save(UnReadReply transientInstance) {
		log.debug("saving UnReadReply instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UnReadReply persistentInstance) {
		log.debug("deleting UnReadReply instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UnReadReply findById(java.lang.Integer id) {
		log.debug("getting UnReadReply instance with id: " + id);
		try {
			UnReadReply instance = (UnReadReply) getSession().get(
					"com.teaching.model.UnReadReply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<UnReadReply> findByExample(UnReadReply instance) {
		log.debug("finding UnReadReply instance by example");
		try {
			List<UnReadReply> results = (List<UnReadReply>) getSession()
					.createCriteria("com.teaching.model.UnReadReply")
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
		log.debug("finding UnReadReply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UnReadReply as model where model."
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
		log.debug("finding all UnReadReply instances");
		try {
			String queryString = "from UnReadReply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UnReadReply merge(UnReadReply detachedInstance) {
		log.debug("merging UnReadReply instance");
		try {
			UnReadReply result = (UnReadReply) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UnReadReply instance) {
		log.debug("attaching dirty UnReadReply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UnReadReply instance) {
		log.debug("attaching clean UnReadReply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}