package com.teaching.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Delivery entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.teaching.model.Delivery
 * @author MyEclipse Persistence Tools
 */

public class DeliveryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DeliveryDAO.class);
	// property constants
	public static final String DELIVERY_ADDRESS = "deliveryAddress";
	public static final String DELIVERY_TIME = "deliveryTime";
	public static final String ASSIGNMENT_REPLY = "assignmentReply";
	public static final String ASSIGNMENT_GRRADE = "assignmentGrrade";
	public static final String CORRECT_TIME = "correctTime";

	public void save(Delivery transientInstance) {
		log.debug("saving Delivery instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Delivery persistentInstance) {
		log.debug("deleting Delivery instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Delivery findById(java.lang.Integer id) {
		log.debug("getting Delivery instance with id: " + id);
		try {
			Delivery instance = (Delivery) getSession().get(
					"com.teaching.model.Delivery", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Delivery> findByExample(Delivery instance) {
		log.debug("finding Delivery instance by example");
		try {
			List<Delivery> results = (List<Delivery>) getSession()
					.createCriteria("com.teaching.model.Delivery")
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
		log.debug("finding Delivery instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Delivery as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Delivery> findByDeliveryAddress(Object deliveryAddress) {
		return findByProperty(DELIVERY_ADDRESS, deliveryAddress);
	}

	public List<Delivery> findByDeliveryTime(Object deliveryTime) {
		return findByProperty(DELIVERY_TIME, deliveryTime);
	}

	public List<Delivery> findByAssignmentReply(Object assignmentReply) {
		return findByProperty(ASSIGNMENT_REPLY, assignmentReply);
	}

	public List<Delivery> findByAssignmentGrrade(Object assignmentGrrade) {
		return findByProperty(ASSIGNMENT_GRRADE, assignmentGrrade);
	}

	public List<Delivery> findByCorrectTime(Object correctTime) {
		return findByProperty(CORRECT_TIME, correctTime);
	}

	public List findAll() {
		log.debug("finding all Delivery instances");
		try {
			String queryString = "from Delivery";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Delivery merge(Delivery detachedInstance) {
		log.debug("merging Delivery instance");
		try {
			Delivery result = (Delivery) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Delivery instance) {
		log.debug("attaching dirty Delivery instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Delivery instance) {
		log.debug("attaching clean Delivery instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}