package com.dao;

import com.model.TProblem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Zephery on 2016/5/27.
 */
public class TProblemDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(TProblem.class);

    public List getAllProblem() {
        log.debug("get all");
        try {
            String sql = "from TProblem";
            return getHibernateTemplate().find(sql);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public void save(TProblem tProblem) {
        log.debug("saving TGonggao instance");
        try {
            getHibernateTemplate().save(tProblem);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public TProblem findById(Integer questionid) {
        log.debug("getting TGonggao instance with id: " + questionid);
        try {
            TProblem tProblem0 = (TProblem) getHibernateTemplate().get(
                    "com.model.TProblem", questionid);
            return tProblem0;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public void delete(TProblem tProblem) {
        log.debug("deleting TGonggao instance");
        try {
            getHibernateTemplate().delete(tProblem);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    public TProblem update(TProblem tProblem){
        log.debug("merging TGonggao instance");
        try
        {
            TProblem result = (TProblem) getHibernateTemplate().merge(
                    tProblem);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }
}
