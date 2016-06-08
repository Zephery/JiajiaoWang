package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TJiaoyuanDAO;
import com.dao.TXueyuanDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TJiaoyuanDAO jiaoyuanDAO;
	private TXueyuanDAO xueyuanDAO;
	public TJiaoyuanDAO getJiaoyuanDAO()
	{
		return jiaoyuanDAO;
	}
	public void setJiaoyuanDAO(TJiaoyuanDAO jiaoyuanDAO)
	{
		this.jiaoyuanDAO = jiaoyuanDAO;
	}
	public TXueyuanDAO getXueyuanDAO()
	{
		return xueyuanDAO;
	}

	public void setXueyuanDAO(TXueyuanDAO xueyuanDAO)
	{
		this.xueyuanDAO = xueyuanDAO;
	}

	
	
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TJiaoyuan where del ='no' order by del";
		List jiaoyuanList=jiaoyuanDAO.getHibernateTemplate().find(sql);
		if(jiaoyuanList.size()>8)
		{
			jiaoyuanList=jiaoyuanList.subList(0, 8);
		}
		
		String sql1="from TXueyuan where del ='no'";
		List xueyuanList=xueyuanDAO.getHibernateTemplate().find(sql1);
		if(xueyuanList.size()>8)
		{
			xueyuanList=xueyuanList.subList(0, 8);
		}
		
		request.put("jiaoyuanList", jiaoyuanList);
		request.put("xueyuanList", xueyuanList);
		return ActionSupport.SUCCESS;
	}

}
