package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJiaoyuan;

/**
 * Data access object (DAO) for domain model class TJiaoyuan.
 * 
 * @see com.model.TJiaoyuan
 * @author MyEclipse Persistence Tools
 */

public class TJiaoyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TJiaoyuanDAO.class);

	// property constants
	public static final String LOGINNAME = "loginname";

	public static final String LOGINPW = "loginpw";

	public static final String NAME = "name";

	public static final String SEX = "sex";

	public static final String AGE = "age";

	public static final String TEL = "tel";

	public static final String ADDRESS = "address";

	public static final String SHENFEN = "shenfen";

	public static final String XUELI = "xueli";

	public static final String KEFUDAOKEMU = "kefudaokemu";

	public static final String ZIWOJIESHAO = "ziwojieshao";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TJiaoyuan transientInstance)
	{
		log.debug("saving TJiaoyuan instance");
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

	public void delete(TJiaoyuan persistentInstance)
	{
		log.debug("deleting TJiaoyuan instance");
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

	public TJiaoyuan findById(java.lang.Integer id)
	{
		log.debug("getting TJiaoyuan instance with id: " + id);
		try
		{
			TJiaoyuan instance = (TJiaoyuan) getHibernateTemplate().get(
					"com.model.TJiaoyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJiaoyuan instance)
	{
		log.debug("finding TJiaoyuan instance by example");
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
		log.debug("finding TJiaoyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TJiaoyuan as model where model."
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

	public List findByShenfen(Object shenfen)
	{
		return findByProperty(SHENFEN, shenfen);
	}

	public List findByXueli(Object xueli)
	{
		return findByProperty(XUELI, xueli);
	}

	public List findByKefudaokemu(Object kefudaokemu)
	{
		return findByProperty(KEFUDAOKEMU, kefudaokemu);
	}

	public List findByZiwojieshao(Object ziwojieshao)
	{
		return findByProperty(ZIWOJIESHAO, ziwojieshao);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TJiaoyuan instances");
		try
		{
			String queryString = "from TJiaoyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJiaoyuan merge(TJiaoyuan detachedInstance)
	{
		log.debug("merging TJiaoyuan instance");
		try
		{
			TJiaoyuan result = (TJiaoyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJiaoyuan instance)
	{
		log.debug("attaching dirty TJiaoyuan instance");
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

	public void attachClean(TJiaoyuan instance)
	{
		log.debug("attaching clean TJiaoyuan instance");
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

	public static TJiaoyuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TJiaoyuanDAO) ctx.getBean("TJiaoyuanDAO");
	}
}