package com.model;

import java.sql.Timestamp;

/**
 * TProblem entity. @author MyEclipse Persistence Tools
 */

public class TProblem implements java.io.Serializable {

	// Fields

	private Integer questionid;
	private String question;
	private String answer;
	private String datetime;

	// Constructors

	/** default constructor */
	public TProblem() {
	}

	/** full constructor */
	public TProblem(String question, String answer, String datetime) {
		this.question = question;
		this.answer = answer;
		this.datetime = datetime;
	}

	// Property accessors

	public Integer getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
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

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}