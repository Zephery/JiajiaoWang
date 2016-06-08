<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/popup_shuaxin.js"></script>
		
        <script language="javascript">
           function jiaoyuanDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/jiaoyuanDel.action?id="+id;
               }
           }
           
           function jiaoyuanDetail(id)
           {
                var url="<%=path %>/jiaoyuanDetail.action?id="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:480});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","教员详细信息");
	            pop.build();
	            pop.show();
           }
           
           function jiaoyuanShenhe(id)
           {
                var url="<%=path %>/jiaoyuanShenhe.action?id="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:200,height:100});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","教员审核");
	            pop.build();
	            pop.show();
           }
           
                      function newsPiZhun(id)
           {
                var url="<%=path %>/newsPiZhun.action?id="+id;
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:200,height:120});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","操作窗口");
	            pop.build();
	            pop.show();
           } 
           
           
           
           function newsEditPre(id)
           {
                var url="<%=path %>/newsEditPre.action?id="+id;
                window.location.href=url;
           }
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }	
		   
           function newsPinglun(id)
	       {
	            var url="<%=path %>/pinglunMana.action?newsId="+id;
	            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:650,height:450});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","评论管理");
	            pop.build();
	            pop.show();
	       }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="12" background="<%=path %>/img/tbg.gif">&nbsp;教员管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">用户名</td>
					<td width="10%">密码</td>
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					
					<td width="10%">年龄</td>
					<td width="10%">联系方式</td>
					<td width="20%">身份</td>
					<td width="10%">状态</td>
					
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.jiaoyuanList" id="jiaoyuan">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiaoyuan.loginname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#jiaoyuan.loginpw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiaoyuan.name"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiaoyuan.sex"/>
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#jiaoyuan.age"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiaoyuan.tel"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:if test="#jiaoyuan.shenfen=='daxuesheng'">在校大学生(研究生)</s:if>
					    <s:if test="#jiaoyuan.shenfen=='laoshi'">教师(在职/进修/离职/退休)</s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:if test="#jiaoyuan.del=='shenhezhong'">
					         <a style="color: red" href="#" onclick="jiaoyuanShenhe(<s:property value="#jiaoyuan.id"/>)">待审核</a>
					    </s:if>
					    <s:if test="#jiaoyuan.del=='no'">
					        正常
					    </s:if>
					</td>
					
					<td  bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="jiaoyuanDetail(<s:property value="#jiaoyuan.id"/>)" class="pn-loperator">详细信息</a>
						<a href="#" onclick="jiaoyuanDel(<s:property value="#jiaoyuan.id"/>)" class="pn-loperator">删除</a>
						<a style="color: red" href="#" onclick="newsPinglun(<s:property value="#jiaoyuan.id"/>)" class="pn-loperator">评论管理</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
