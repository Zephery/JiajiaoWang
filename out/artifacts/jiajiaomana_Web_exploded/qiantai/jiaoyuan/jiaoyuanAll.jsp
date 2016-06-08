<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	        
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"/>
		<div class="page_row">
			<div class="page_main_msg left">
			    <div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							<span style="float:left">教员</span>
						</div>
						<div id="tw" class="list_content" style="height: 500px;">
							<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
								  <tr align="center" bgcolor="#FAFAF1" height="22">
								      <td width="10%">姓名</td>
									  <td width="10%">性别</td>
									  <td width="10%">年龄</td>
									  <td width="10%">学历</td>
									  <td width="30%">可辅导科目</td>
									  <td width="10%">详细信息</td>
								  </tr>
								  <s:iterator value="#request.jiaoyuanList" id="jiaoyuan">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td><s:property value="#jiaoyuan.name"/></td>
									  <td><s:property value="#jiaoyuan.sex"/></td>
									  <td><s:property value="#jiaoyuan.age"/></td>
									  <td><s:property value="#jiaoyuan.xueli"/></td>
									  <td><s:property value="#jiaoyuan.kefudaokemu"/></td>
									  <td><a href="<%=path %>/jiaoyuanDetail_qian.action?id=<s:property value="#jiaoyuan.id"/>">详细信息</a></td>
								  </tr>
								  </s:iterator>
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
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"/>
							</div>
						</div>
					</div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
								<s:action name="gonggaoQian5" executeResult="true" flush="true"/>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">日历表</div>
				        <div class="list_content">
				            <jsp:include flush="true" page="/qiantai/rili/rili.jsp"/>
					    </div>
				    </div>
			    </div>
			</div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"/>
	    </div>
	</body>
</html>
