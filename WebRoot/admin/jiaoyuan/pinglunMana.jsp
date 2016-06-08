<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="<%=path %>/css/css.css" type=text/css rel=stylesheet>
  </head>
  
  <body>
       <c:forEach items="${requestScope.pinglunList}" var="pinglun">
			<TABLE cellpadding="8" cellspacing="8">
				<TR>
					<td><c:out value="${pinglun.content }" escapeXml="false"/></td>
				</TR>
				<TR>
					<td align="right"><c:out value="${pinglun.shijian }" escapeXml="false"/>&nbsp;&nbsp;<a href="<%=path %>/pinglunDel.action?id=${pinglun.id }">[删除]</a></td>
				</TR>
				<tr>
				    <td>
				       <hr style="BORDER-BOTTOM-STYLE: dotted; BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted; BORDER-TOP-STYLE: dotted" color=blue size=1 width="560">
				    </td>
				</tr>
			</TABLE>
		</c:forEach>
  </body>
</html>
