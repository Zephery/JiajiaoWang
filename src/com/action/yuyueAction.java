package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TJiaoyuanDAO;
import com.dao.TXueyuanDAO;
import com.dao.TYuyueDAO;
import com.model.TGonggao;
import com.model.TYuyue;
import com.opensymphony.xwork2.ActionSupport;

public class yuyueAction extends ActionSupport {
    private int id;
    private int jiaoyuan_id;
    private int xueyuan_id;
    private String yuyuezhe_tel;
    private String beizhu;

    private TYuyueDAO yuyueDAO;
    private TXueyuanDAO xueyuanDAO;
    private TJiaoyuanDAO jiaoyuanDAO;

    private String message;
    private String path;


    public String yuyue_jiaoyuan_add() {
        Map request = (Map) ServletActionContext.getContext().get("request");

        TYuyue yuyue = new TYuyue();
        yuyue.setXueyuan_id(xueyuan_id);
        yuyue.setJiaoyuan_id(jiaoyuan_id);
        yuyue.setYuyuezhe_tel(yuyuezhe_tel);
        yuyue.setShijian(new Date().toLocaleString());
        yuyue.setBeizhu(beizhu);
        yuyue.setType("tojiaoyuan");//ѧԱԤԼ��Ա

        yuyueDAO.save(yuyue);
        request.put("msg", "ԤԼ�ɹ�");
        return "msg";
    }

    public String yuyue_xueyuan_add() {
        Map request = (Map) ServletActionContext.getContext().get("request");

        TYuyue yuyue = new TYuyue();
        yuyue.setJiaoyuan_id(jiaoyuan_id);
        yuyue.setXueyuan_id(xueyuan_id);
        yuyue.setYuyuezhe_tel(yuyuezhe_tel);
        yuyue.setShijian(new Date().toLocaleString());
        yuyue.setBeizhu(beizhu);
        yuyue.setType("toxueyuan");//��ԱԤԼѧԱ

        yuyueDAO.save(yuyue);
        request.put("msg", "ԤԼ�ɹ�");
        return "msg";
    }


    public String wodeyuyue_jiaoyuan()//�Խ�Ա��˵�ҵ�ԤԼ
    {
        HttpServletRequest req = ServletActionContext.getRequest();

        String sql = "from TYuyue where jiaoyuan_id=? and type=?";
        Object[] c = {Integer.parseInt(req.getParameter("jiaoyuan_id")), req.getParameter("type")};
        List yuyueList = yuyueDAO.getHibernateTemplate().find(sql, c);
        for (int i = 0; i < yuyueList.size(); i++) {
            TYuyue yuyue = (TYuyue) yuyueList.get(i);
            yuyue.setJiaoyuan(jiaoyuanDAO.findById(yuyue.getJiaoyuan_id()));
            yuyue.setXueyuan(xueyuanDAO.findById(yuyue.getXueyuan_id()));
        }
        req.setAttribute("yuyueList", yuyueList);
        return SUCCESS;
    }

    public String wodeyuyue_xueyuan()//��ѧԱ��˵�ҵ�ԤԼ
    {
        HttpServletRequest req = ServletActionContext.getRequest();

        String sql = "from TYuyue where xueyuan_id=? and type=?";
        Object[] c = {Integer.parseInt(req.getParameter("xueyuan_id")), req.getParameter("type")};
        List yuyueList = yuyueDAO.getHibernateTemplate().find(sql, c);
        for (int i = 0; i < yuyueList.size(); i++) {
            TYuyue yuyue = (TYuyue) yuyueList.get(i);
            yuyue.setJiaoyuan(jiaoyuanDAO.findById(yuyue.getJiaoyuan_id()));
            yuyue.setXueyuan(xueyuanDAO.findById(yuyue.getXueyuan_id()));
        }
        System.out.println(yuyueList.size() + "%%%");
        req.setAttribute("yuyueList", yuyueList);
        return SUCCESS;
    }


    public String yuyuewode_jiaoyuan()//�Խ�Ա��˵ԤԼ�ҵ�
    {
        HttpServletRequest req = ServletActionContext.getRequest();

        String sql = "from TYuyue where jiaoyuan_id=? and type=?";
        Object[] c = {Integer.parseInt(req.getParameter("jiaoyuan_id")), req.getParameter("type")};
        List yuyueList = yuyueDAO.getHibernateTemplate().find(sql, c);
        for (int i = 0; i < yuyueList.size(); i++) {
            TYuyue yuyue = (TYuyue) yuyueList.get(i);
            yuyue.setJiaoyuan(jiaoyuanDAO.findById(yuyue.getJiaoyuan_id()));
            yuyue.setXueyuan(xueyuanDAO.findById(yuyue.getXueyuan_id()));
        }
        req.setAttribute("yuyueList", yuyueList);
        return SUCCESS;
    }

    public String yuyuewode_xueyuan()//��ѧԱ��˵ԤԼ�ҵ�
    {
        HttpServletRequest req = ServletActionContext.getRequest();

        String sql = "from TYuyue where jiaoyuan_id=? and type=?";
        Object[] c = {Integer.parseInt(req.getParameter("xueyuan_id")), req.getParameter("type")};
        List yuyueList = yuyueDAO.getHibernateTemplate().find(sql, c);
        for (int i = 0; i < yuyueList.size(); i++) {
            TYuyue yuyue = (TYuyue) yuyueList.get(i);
            yuyue.setJiaoyuan(jiaoyuanDAO.findById(yuyue.getJiaoyuan_id()));
            yuyue.setXueyuan(xueyuanDAO.findById(yuyue.getXueyuan_id()));
        }
        req.setAttribute("yuyueList", yuyueList);
        return SUCCESS;
    }


    public String yuyuemana()//
    {
        HttpServletRequest req = ServletActionContext.getRequest();
        List yuyueList = yuyueDAO.findAll();
        for (int i = 0; i < yuyueList.size(); i++) {
            TYuyue yuyue = (TYuyue) yuyueList.get(i);
            yuyue.setJiaoyuan(jiaoyuanDAO.findById(yuyue.getJiaoyuan_id()));
            yuyue.setXueyuan(xueyuanDAO.findById(yuyue.getXueyuan_id()));
        }
        req.setAttribute("yuyueList", yuyueList);
        return SUCCESS;
    }


    public String getBeizhu() {
        return beizhu;
    }


    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
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

    public int getJiaoyuan_id() {
        return jiaoyuan_id;
    }


    public void setJiaoyuan_id(int jiaoyuan_id) {
        this.jiaoyuan_id = jiaoyuan_id;
    }


    public int getXueyuan_id() {
        return xueyuan_id;
    }


    public void setXueyuan_id(int xueyuan_id) {
        this.xueyuan_id = xueyuan_id;
    }


    public TYuyueDAO getYuyueDAO() {
        return yuyueDAO;
    }


    public void setYuyueDAO(TYuyueDAO yuyueDAO) {
        this.yuyueDAO = yuyueDAO;
    }


    public String getYuyuezhe_tel() {
        return yuyuezhe_tel;
    }


    public void setYuyuezhe_tel(String yuyuezhe_tel) {
        this.yuyuezhe_tel = yuyuezhe_tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
