<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<%
    String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>

    <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css"/>

    <script language="javascript">
    </script>
</head>

<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
<form action="<%=path %>/pinglunAdd.action" name="formAdd" method="post">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
           style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span></span></td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">
                评论：
            </td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <FCK:editor instanceName="content" basePath="/fckeditor" width="600" height="300" value="请输入内容"
                            toolbarSet="Basic">
                </FCK:editor>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="10" bgcolor="#FFFFFF" align="right">
                star
            </td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="star">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">1</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="10" bgcolor="#FFFFFF" align="right">
                &nbsp;
            </td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" name="kefangId" value="<%=request.getParameter("newsId") %>"/>
                <input type="submit" value="提交"/>&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
