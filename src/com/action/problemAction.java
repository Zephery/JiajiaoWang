package com.action;

import com.dao.TProblemDAO;

import com.model.TProblem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Zephery on 2016/5/26.
 */
public class problemAction extends ActionSupport {
    private Integer id;
    private String question;

    private SessionFactory sessionFactory;
    private TProblemDAO tProblemDAO;
    private String answer;
    private String datetime;
    private String message;
    private String path;
    private Integer questionid;

    public Integer getQuestionid() {
        return this.questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TProblemDAO gettProblemDAO() {
        return this.tProblemDAO;
    }

    public void settProblemDAO(TProblemDAO tProblemDAO) {
        this.tProblemDAO = tProblemDAO;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAllProblem() {         //get all problems
        String sql = "from TProblem";
        List problems = tProblemDAO.getHibernateTemplate().find(sql);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("problems", problems);
        return SUCCESS;
    }

    public String searchproblem() {
        String sql = "from TProblem where question like '%" + getQuestion() + "%'";
        List problems = tProblemDAO.getHibernateTemplate().find(sql);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("problems", problems);
        return SUCCESS;
    }

    public String problemadd() {
        TProblem tProblem = new TProblem();
        tProblem.setQuestion(question);
        tProblem.setAnswer(answer);
        tProblem.setDatetime(new Date().toLocaleString());
        tProblemDAO.save(tProblem);
        this.setMessage("信息发布完毕");
        this.setPath("getallproblem.action");
        return "succeed";
    }

    public String toproblemupdate() {                  //redirect to problemupdate page
        TProblem tProblem = tProblemDAO.findById(questionid);
        Map request = (Map) ServletActionContext.getContext().get("request");
        request.put("problem", tProblem);
        return ActionSupport.SUCCESS;
    }

    public String problemupdate() {
        TProblem tProblem = tProblemDAO.findById(questionid);
        tProblem.setQuestion(question);
        tProblem.setAnswer(answer);
        tProblemDAO.update(tProblem);
        this.setMessage("修改完毕");
        this.setPath("getallproblem.action");
        return "succeed";
    }

    public String problemdelete() {
        TProblem tProblem = tProblemDAO.findById(questionid);        //delete problem
        tProblemDAO.delete(tProblem);
        this.setMessage("删除完毕");
        this.setPath("getallproblem.action");
        return "succeed";
    }

}
