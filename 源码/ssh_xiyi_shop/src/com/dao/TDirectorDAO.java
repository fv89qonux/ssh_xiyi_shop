package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TDirector;

/**
 * Data access object (DAO) for domain model class TDirector.
 * 
 * @see com.model.TDirector
 * @author MyEclipse Persistence Tools
 */

public class TDirectorDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TDirectorDAO.class);

	// property constants
	public static final String USER_NAME = "userName";

	public static final String USER_PW = "userPw";

	protected void initDao() {
		// do nothing
	}

	public void save(TDirector transientInstance) {
		log.debug("saving TDirector instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDirector persistentInstance) {
		log.debug("deleting TDirector instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDirector findById(java.lang.Integer id) {
		log.debug("getting TDirector instance with id: " + id);
		try {
			TDirector instance = (TDirector) getHibernateTemplate().get(
					"com.model.TDirector", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDirector instance) {
		log.debug("finding TDirector instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TDirector instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDirector as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPw(Object userPw) {
		return findByProperty(USER_PW, userPw);
	}

	public List findAll() {
		log.debug("finding all TDirector instances");
		try {
			String queryString = "from TDirector";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDirector merge(TDirector detachedInstance) {
		log.debug("merging TDirector instance");
		try {
			TDirector result = (TDirector) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDirector instance) {
		log.debug("attaching dirty TDirector instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDirector instance) {
		log.debug("attaching clean TDirector instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDirectorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDirectorDAO) ctx.getBean("TDirectorDAO");
	}
}