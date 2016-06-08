<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
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
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
	    <script type="text/javascript">
	        function yuyue_xueyuan(xueyuan_id)
	        {
	 
	            <c:if test="${sessionScope.userType==null}">
	               alert("请先登录");
	            </c:if>
	            <c:if test="${sessionScope.userType==2}">
	               alert("很抱歉，您是学员，不能预约学员~");
	            </c:if>
	            <c:if test="${sessionScope.userType==1}">
	                var url="/jiajiaomana/qiantai/yuyue/yuyue_xueyuan.jsp?xueyuan_id="+xueyuan_id;
		            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:450,height:440});
		            pop.setContent("contentUrl",url);
		            pop.setContent("title","预约学员");
		            pop.build();
		            pop.show();
	            </c:if>
	        } 
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">
			    <div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							<span style="float:left">学员详细信息</span>
						</div>
						<div id="tw" class="list_content" style="height: 500px;">
							<table width="100%" border="0" cellpadding="9" cellspacing="9">
							    <tr>
							       <td align="left">姓名：${requestScope.xueyuan.name }</td>
							    </tr>
							    <tr>
							       <td align="left">性别：${requestScope.xueyuan.sex }</td>
							    </tr>
							    <tr>
							       <td align="left">年龄：${requestScope.xueyuan.age }</td>
							    </tr>
							    <tr>
							       <td align="left">联系方式：***********</td>
							    </tr>
							    <tr>
							       <td align="left">住址：${requestScope.xueyuan.address }</td>
							    </tr>
							    <tr>
							       <td align="left">辅导科目：${requestScope.xueyuan.fudaokemu }</td>
							    </tr>
							    <tr>
							       <td align="left">学员情况：${requestScope.xueyuan.xueyuanqingkuang }</td>
							    </tr>
							    <tr>
							       <td align="left">教员要求：${requestScope.xueyuan.jiaoyuanyaoqiu }</td>
							    </tr>
							    <tr>
							       <td align="center">
							           <a href="#" onclick="yuyue_xueyuan(${requestScope.xueyuan.id })"><img src="<%=path %>/img/yuyue1.jpg"/></a>
                                   </td>
							    </tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">用户登录</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
								<s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">日历表</div>
				        <div class="list_content">
				            <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
					    </div>
				    </div>
			    </div>
			</div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
