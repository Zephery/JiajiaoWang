package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TJiaoyuanDAO;
import com.dao.TXueyuanDAO;
import com.model.TAdmin;
import com.model.TJiaoyuan;
import com.model.TXueyuan;

public class loginService {
    private TAdminDAO adminDAO;
    private TJiaoyuanDAO jiaoyuanDAO;
    private TXueyuanDAO xueyuanDAO;

    public TAdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(TAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public TJiaoyuanDAO getJiaoyuanDAO() {
        return jiaoyuanDAO;
    }

    public void setJiaoyuanDAO(TJiaoyuanDAO jiaoyuanDAO) {
        this.jiaoyuanDAO = jiaoyuanDAO;
    }

    public TXueyuanDAO getXueyuanDAO() {
        return xueyuanDAO;
    }

    public void setXueyuanDAO(TXueyuanDAO xueyuanDAO) {
        this.xueyuanDAO = xueyuanDAO;
    }


    public String login(String userName, String userPw, int userType) {
        System.out.println("userType" + userType);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String result = "no";

        if (userType == 0)//系统管理员登陆
        {
            String sql = "from TAdmin where userName=? and userPw=?";
            Object[] con = {userName, userPw};
            List adminList = adminDAO.getHibernateTemplate().find(sql, con);
            if (adminList.size() == 0) {
                result = "no";
            } else {
                WebContext ctx = WebContextFactory.get();
                HttpSession session = ctx.getSession();
                TAdmin admin = (TAdmin) adminList.get(0);
                session.setAttribute("userType", 0);
                session.setAttribute("admin", admin);
                result = "yes";
            }
        }
        if (userType == 1)//教员登陆
        {
            String sql = "from TJiaoyuan where del ='no' and loginname=? and loginpw=?";
            Object[] con = {userName, userPw};
            List jiaoyuanList = jiaoyuanDAO.getHibernateTemplate().find(sql, con);
            if (jiaoyuanList.size() == 0) {
                result = "no";
            } else {
                WebContext ctx = WebContextFactory.get();
                HttpSession session = ctx.getSession();
                TJiaoyuan jiaoyuan = (TJiaoyuan) jiaoyuanList.get(0);
                session.setAttribute("userType", 1);
                session.setAttribute("jiaoyuan", jiaoyuan);
                result = "yes";
            }
        }
        if (userType == 2)//学员登陆
        {
            String sql = "from TXueyuan where del ='no' and loginname=? and loginpw=?";
            Object[] con = {userName, userPw};
            List xueyuanList = xueyuanDAO.getHibernateTemplate().find(sql, con);
            if (xueyuanList.size() == 0) {
                result = "no";
            } else {
                WebContext ctx = WebContextFactory.get();
                HttpSession session = ctx.getSession();
                TXueyuan xueyuan = (TXueyuan) xueyuanList.get(0);
                session.setAttribute("userType", 2);
                session.setAttribute("xueyuan", xueyuan);
                result = "yes";
            }
        }
        return result;
    }

    public String adminPwEdit(String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebContext ctx = WebContextFactory.get();
        HttpSession session = ctx.getSession();

        TAdmin admin = (TAdmin) session.getAttribute("admin");
        admin.setUserPw(userPwNew);

        adminDAO.getHibernateTemplate().update(admin);
        session.setAttribute("admin", admin);

        return "yes";
    }


}
