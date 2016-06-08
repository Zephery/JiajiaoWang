package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXueyuan;

/**
 * Data access object (DAO) for domain model class TXueyuan.
 * 
 * @see com.model.TXueyuan
 * @author MyEclipse Persistence Tools
 */

public class TXueyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXueyuanDAO.class);

	// property constants
	public static final String LOGINNAME = "loginname";

	public static final String LOGINPW = "loginpw";

	public static final String NAME = "name";

	public static final String SEX = "sex";

	public static final String AGE = "age";

	public static final String TEL = "tel";

	public static final String ADDRESS = "address";

	public static final String FUDAOKEMU = "fudaokemu";

	public static final String XUEYUANQINGKUANG = "xueyuanqingkuang";

	public static final String JIAOYUANYAOQIU = "jiaoyuanyaoqiu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXueyuan transientInstance)
	{
		log.debug("saving TXueyuan instance");
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

	public void delete(TXueyuan persistentInstance)
	{
		log.debug("deleting TXueyuan instance");
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

	public TXueyuan findById(java.lang.Integer id)
	{
		log.debug("getting TXueyuan instance with id: " + id);
		try
		{
			TXueyuan instance = (TXueyuan) getHibernateTemplate().get(
					"com.model.TXueyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXueyuan instance)
	{
		log.debug("finding TXueyuan instance by example");
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
		log.debug("finding TXueyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXueyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age)
	{
		return findByProperty(AGE, age);
	}

	public List findByTel(Object tel)
	{
		return findByProperty(TEL, tel);
	}

	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}

	public List findByFudaokemu(Object fudaokemu)
	{
		return findByProperty(FUDAOKEMU, fudaokemu);
	}

	public List findByXueyuanqingkuang(Object xueyuanqingkuang)
	{
		return findByProperty(XUEYUANQINGKUANG, xueyuanqingkuang);
	}

	public List findByJiaoyuanyaoqiu(Object jiaoyuanyaoqiu)
	{
		return findByProperty(JIAOYUANYAOQIU, jiaoyuanyaoqiu);
	}

	public List findAll()
	{
		log.debug("finding all TXueyuan instances");
		try
		{
			String queryString = "from TXueyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXueyuan merge(TXueyuan detachedInstance)
	{
		log.debug("merging TXueyuan instance");
		try
		{
			TXueyuan result = (TXueyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXueyuan instance)
	{
		log.debug("attaching dirty TXueyuan instance");
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

	public void attachClean(TXueyuan instance)
	{
		log.debug("attaching clean TXueyuan instance");
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

	public static TXueyuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXueyuanDAO) ctx.getBean("TXueyuanDAO");
	}
}