package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXueyuanDAO;
import com.model.TJiaoyuan;
import com.model.TXueyuan;
import com.opensymphony.xwork2.ActionSupport;

public class xueyuanAction extends ActionSupport
{
	private int id;
	private String loginname;
	private String loginpw;
	private String name;
	private String sex;
	private String age;
	private String tel;
	private String address;
	private String fudaokemu;
	private String xueyuanqingkuang;
	private String jiaoyuanyaoqiu;
	
	private String message;
	private String path;
	
	private TXueyuanDAO xueyuanDAO;
	
	
	public String xueyuanLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("jiaoyuan");
		session.remove("userType");
		return ActionSupport.SUCCESS;
	}
	
	public String xueyuanAdd()
	{
		TXueyuan xueyuan=new TXueyuan();
		xueyuan.setLoginname(loginname);
		xueyuan.setLoginpw(loginpw);
		xueyuan.setName(name);
		xueyuan.setSex(sex);
		xueyuan.setAge(age);
		xueyuan.setTel(tel);
		xueyuan.setAddress(address);
		xueyuan.setFudaokemu(fudaokemu);
		xueyuan.setXueyuanqingkuang(xueyuanqingkuang);
		xueyuan.setJiaoyuanyaoqiu(jiaoyuanyaoqiu);
		xueyuan.setDel("shenhezhong");
		xueyuanDAO.save(xueyuan);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "注册成功。等待管理员审核");
		return "successAdd";
	}
	
	
	
	public String xueyuanMana()
	{
		String sql="from TXueyuan where del !='yes'";
		List xueyuanList=xueyuanDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueyuanList", xueyuanList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xueyuanDel()
	{
		String sql="update TXueyuan set del='yes' where id="+id;
		xueyuanDAO.getHibernateTemplate().bulkUpdate(sql);
		this.setMessage("删除完毕");
		this.setPath("xueyuanMana.action");
		return "succeed";
	}
	
	public String xueyuanDetail()
	{
		TXueyuan xueyuan=xueyuanDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueyuan", xueyuan);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xueyuanShenhe()
	{
		String sql="update TXueyuan set del='no' where id="+id;
		xueyuanDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "审核成功");
		return "msg";
	}
	
	public String xueyuanDetail_qian()
	{
		TXueyuan xueyuan=xueyuanDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueyuan", xueyuan);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xueyuanAll()
	{
		String sql="from TXueyuan where del='no'";
		List xueyuanList=xueyuanDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueyuanList", xueyuanList);
		return ActionSupport.SUCCESS;
	}
	
	public String xueyuanEdit()
	{
		TXueyuan xueyuan=xueyuanDAO.findById(id);
		xueyuan.setLoginname(loginname);
		xueyuan.setLoginpw(loginpw);
		xueyuan.setName(name);
		xueyuan.setSex(sex);
		xueyuan.setAge(age);
		xueyuan.setTel(tel);
		xueyuan.setAddress(address);
		xueyuan.setFudaokemu(fudaokemu);
		xueyuan.setXueyuanqingkuang(xueyuanqingkuang);
		xueyuan.setJiaoyuanyaoqiu(jiaoyuanyaoqiu);
		xueyuanDAO.getHibernateTemplate().update(xueyuan);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功");
		return "successAdd";
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getFudaokemu()
	{
		return fudaokemu;
	}

	public void setFudaokemu(String fudaokemu)
	{
		this.fudaokemu = fudaokemu;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getJiaoyuanyaoqiu()
	{
		return jiaoyuanyaoqiu;
	}

	public void setJiaoyuanyaoqiu(String jiaoyuanyaoqiu)
	{
		this.jiaoyuanyaoqiu = jiaoyuanyaoqiu;
	}

	public String getLoginname()
	{
		return loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public TXueyuanDAO getXueyuanDAO()
	{
		return xueyuanDAO;
	}

	public void setXueyuanDAO(TXueyuanDAO xueyuanDAO)
	{
		this.xueyuanDAO = xueyuanDAO;
	}

	public String getXueyuanqingkuang()
	{
		return xueyuanqingkuang;
	}

	public void setXueyuanqingkuang(String xueyuanqingkuang)
	{
		this.xueyuanqingkuang = xueyuanqingkuang;
	}
	
	
	
}
