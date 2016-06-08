package com.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.functors.ExceptionPredicate;
import org.apache.struts2.ServletActionContext;

import com.dao.TJiaoyuanDAO;
import com.dao.TPinglunDAO;
import com.model.TJiaoyuan;
import com.model.TPinglun;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.*;
import org.springframework.validation.ObjectError;

public class jiaoyuanAction extends ActionSupport {
    private int id;
    private String loginname;
    private String loginpw;
    private String name;
    private String sex;
    private String age;
    private String tel;
    private String address;

    private String shenfen;
    private String xueli;
    private String kefudaokemu;
    private String ziwojieshao;
    private String fujian;

    private String message;
    private String path;

    private TJiaoyuanDAO jiaoyuanDAO;
    private TPinglunDAO pinglunDAO;
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String jiaoyuanLogout() {
        Map session = ServletActionContext.getContext().getSession();
        session.remove("jiaoyuan");
        session.remove("userType");
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanAdd() {
        TJiaoyuan jiaoyuan = new TJiaoyuan();
        jiaoyuan.setLoginname(loginname);
        jiaoyuan.setLoginpw(loginpw);
        jiaoyuan.setName(name);
        jiaoyuan.setSex(sex);
        jiaoyuan.setAge(age);
        jiaoyuan.setTel(tel);
        jiaoyuan.setAddress(address);
        jiaoyuan.setShenfen(shenfen);
        jiaoyuan.setXueli(xueli);
        jiaoyuan.setKefudaokemu(kefudaokemu);
        jiaoyuan.setZiwojieshao(ziwojieshao);
        jiaoyuan.setDel("shenhezhong");
        jiaoyuan.setFujian(fujian.equals("") == true ? "/img/none.gif" : fujian);
        jiaoyuanDAO.save(jiaoyuan);

        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("msg", "注册成功。等待管理员审核");
        return "successAdd";

    }


    public String jiaoyuanMana() {
        String sql = "from TJiaoyuan where del !='yes' order by del";
        List jiaoyuanList = jiaoyuanDAO.getHibernateTemplate().find(sql);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuanList", jiaoyuanList);
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanDel() {
        String sql = "update TJiaoyuan set del='yes' where id=" + id;
        jiaoyuanDAO.getHibernateTemplate().bulkUpdate(sql);
        this.setMessage("删除完毕");
        this.setPath("jiaoyuanMana.action");
        return "succeed";
    }

    public String jiaoyuanDetail() {
        TJiaoyuan jiaoyuan = jiaoyuanDAO.findById(id);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuan", jiaoyuan);
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanShenhe() {
        String sql = "update TJiaoyuan set del='no' where id=" + id;
        jiaoyuanDAO.getHibernateTemplate().bulkUpdate(sql);

        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("msg", "审核成功");
        return "msg";
    }

    public String pinglunAdd() {
        HttpServletRequest request = ServletActionContext.getRequest();

        TPinglun pinglun = new TPinglun();
        pinglun.setStar(Integer.parseInt(request.getParameter("star")));
        pinglun.setContent(request.getParameter("content"));
        pinglun.setShijian(new Date().toLocaleString());
        pinglun.setKefangId(Integer.parseInt(request.getParameter("kefangId")));
        pinglunDAO.save(pinglun);
        request.setAttribute("msg", "评论成功");
        return "msg";
    }

    public String pinglunAll() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String s = "from TPinglun where kefangId="
                + Integer.parseInt(request.getParameter("newsId"));
        List pinglunList = pinglunDAO.getHibernateTemplate().find(s);
        request.setAttribute("pinglunList", pinglunList);
        return ActionSupport.SUCCESS;
    }

    public String pinglunMana() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String s = "from TPinglun where kefangId="
                + Integer.parseInt(request.getParameter("newsId"));
        List pinglunList = pinglunDAO.getHibernateTemplate().find(s);
        request.setAttribute("pinglunList", pinglunList);
        return ActionSupport.SUCCESS;
    }

    public String pinglunDel() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String s = "delete from TPinglun where id="
                + Integer.parseInt(request.getParameter("id"));
        pinglunDAO.getHibernateTemplate().bulkUpdate(s);
        request.setAttribute("msg", "删除成功");
        return "msg";
    }


    public String getFujian() {
        return fujian;
    }


    public void setFujian(String fujian) {
        this.fujian = fujian;
    }


    public String jiaoyuanDetail_qian() {
        TJiaoyuan jiaoyuan = jiaoyuanDAO.findById(id);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuan", jiaoyuan);
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanAll() {
        String sql = "from TJiaoyuan where del='no'";
        List jiaoyuanList = jiaoyuanDAO.getHibernateTemplate().find(sql);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuanList", jiaoyuanList);
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanSearch() {
        String sql = "from TJiaoyuan where del='no' and kefudaokemu like '%" + kefudaokemu.trim() + "%'";

        List jiaoyuanList = jiaoyuanDAO.getHibernateTemplate().find(sql);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuanList", jiaoyuanList);
        return ActionSupport.SUCCESS;
    }


    public String jiaoyuanEdit() {
        TJiaoyuan jiaoyuan = jiaoyuanDAO.findById(id);
        jiaoyuan.setLoginname(loginname);
        jiaoyuan.setLoginpw(loginpw);
        jiaoyuan.setName(name);
        jiaoyuan.setSex(sex);
        jiaoyuan.setAge(age);
        jiaoyuan.setTel(tel);
        jiaoyuan.setAddress(address);
        jiaoyuan.setShenfen(shenfen);
        jiaoyuan.setXueli(xueli);
        jiaoyuan.setKefudaokemu(kefudaokemu);
        jiaoyuan.setZiwojieshao(ziwojieshao);
        jiaoyuan.setFujian(fujian);
        jiaoyuanDAO.getHibernateTemplate().update(jiaoyuan);

        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("msg", "修改成功");
        return "successAdd";

    }

    public String toshowyouxiujiaoyuan() throws Exception {     //展示优秀教师
        String sql = "select kefangId FROM TPinglun group by kefangId order by avg(star) desc";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(sql);
        List pinglunlist = query.list();
        List<TJiaoyuan> jiaoyuanList = new ArrayList<>();
        int count = 0;
        for (Object object : pinglunlist) {
            jiaoyuanList.add(jiaoyuanDAO.findById(Integer.parseInt(object.toString())));
            if (count == 2) {
                break;
            }
            count += 1;
        }
        session.close();
        //for(TPinglun pinglun:pinglunlist){
        // }
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("jiaoyuanlist", jiaoyuanList);
        return SUCCESS;
    }

    public String toshowpingjia() throws Exception {        //评价
        Integer id = getId();
        String sql2 = "select avg(star) from TPinglun where kefangId=" + id;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(sql2);
        List list = query.list();
        Map request = (Map) ServletActionContext.getContext().get("request");
        String sql3 = "select content from TPinglun where kefangId=" + id;
        Query query1 = session.createQuery(sql3);
        List list1 = query1.list();
        session.close();
        request.put("pinglunlist", list.toString());
        request.put("content", list1.toString());
        return SUCCESS;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKefudaokemu() {
        return kefudaokemu;
    }

    public void setKefudaokemu(String kefudaokemu) {
        this.kefudaokemu = kefudaokemu;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpw() {
        return loginpw;
    }

    public void setLoginpw(String loginpw) {
        this.loginpw = loginpw;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getShenfen() {
        return shenfen;
    }

    public void setShenfen(String shenfen) {
        this.shenfen = shenfen;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }


    public TJiaoyuanDAO getJiaoyuanDAO() {
        return jiaoyuanDAO;
    }

    public void setJiaoyuanDAO(TJiaoyuanDAO jiaoyuanDAO) {
        this.jiaoyuanDAO = jiaoyuanDAO;
    }

    public String getZiwojieshao() {
        return ziwojieshao;
    }

    public void setZiwojieshao(String ziwojieshao) {
        this.ziwojieshao = ziwojieshao;
    }


    public TPinglunDAO getPinglunDAO() {
        return pinglunDAO;
    }


    public void setPinglunDAO(TPinglunDAO pinglunDAO) {
        this.pinglunDAO = pinglunDAO;
    }

}
