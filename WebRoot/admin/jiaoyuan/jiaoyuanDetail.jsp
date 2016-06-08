<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script language="javascript">
        </script>
	</head>
	<body>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							照片：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<img src="<%=path %>${requestScope.jiaoyuan.fujian }" width="120" height="150"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							用户名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="loginname" value="${requestScope.jiaoyuan.loginname }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							密 码：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="password" name="loginpw" value="${requestScope.jiaoyuan.loginpw }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							姓名：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="name" value="${requestScope.jiaoyuan.name }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							${requestScope.jiaoyuan.sex }
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							年龄：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="age" value="${requestScope.jiaoyuan.age }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							联系方式：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="tel" value="${requestScope.jiaoyuan.tel }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							住址：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="address" value="${requestScope.jiaoyuan.address }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							身份：
						</td>
						<td bgcolor="#FFFFFF">
						    &nbsp;
					        <c:if test="${requestScope.jiaoyuan.shenfen=='daxuesheng'}"><font size="2">在校大学生(研究生)</font></c:if>
					        <c:if test="${requestScope.jiaoyuan.shenfen=='laoshi'}"><font size="2">教师(在职/进修/离职/退休)</font></c:if>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							学历：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="xueli" value="${requestScope.jiaoyuan.xueli }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							可辅导科目：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="kefudaokemu" value="${requestScope.jiaoyuan.kefudaokemu }"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							自我介绍：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<FCK:editor instanceName="ziwojieshao"  basePath="/fckeditor" width="300" height="100" value="${requestScope.jiaoyuan.ziwojieshao }" toolbarSet="Basic">
	                        </FCK:editor>
						</td>
					</tr>
				</table>
	</body>
</html>
