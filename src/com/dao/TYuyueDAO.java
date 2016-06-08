package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYuyue;

/**
 * Data access object (DAO) for domain model class TYuyue.
 * 
 * @see com.model.TYuyue
 * @author MyEclipse Persistence Tools
 */

public class TYuyueDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TYuyueDAO.class);

	// property constants
	public static final String XUEYUAN_ID = "xueyuanId";

	public static final String JIAOYUAN_ID = "jiaoyuanId";

	public static final String LIANXIFANGSHI = "lianxifangshi";

	public static final String BEIZHU = "beizhu";

	public static final String TYPE = "type";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TYuyue transientInstance)
	{
		log.debug("saving TYuyue instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYuyue persistentInstance)
	{
		log.debug("deleting TYuyue instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYuyue findById(java.lang.Integer id)
	{
		log.debug("getting TYuyue instance with id: " + id);
		try
		{
			TYuyue instance = (TYuyue) getHibernateTemplate().get(
					"com.model.TYuyue", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYuyue instance)
	{
		log.debug("finding TYuyue instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TYuyue instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TYuyue as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXueyuanId(Object xueyuanId)
	{
		return findByProperty(XUEYUAN_ID, xueyuanId);
	}

	public List findByJiaoyuanId(Object jiaoyuanId)
	{
		return findByProperty(JIAOYUAN_ID, jiaoyuanId);
	}

	public List findByLianxifangshi(Object lianxifangshi)
	{
		return findByProperty(LIANXIFANGSHI, lianxifangshi);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByType(Object type)
	{
		return findByProperty(TYPE, type);
	}

	public List findAll()
	{
		log.debug("finding all TYuyue instances");
		try
		{
			String queryString = "from TYuyue";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYuyue merge(TYuyue detachedInstance)
	{
		log.debug("merging TYuyue instance");
		try
		{
			TYuyue result = (TYuyue) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYuyue instance)
	{
		log.debug("attaching dirty TYuyue instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYuyue instance)
	{
		log.debug("attaching clean TYuyue instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TYuyueDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TYuyueDAO) ctx.getBean("TYuyueDAO");
	}
}