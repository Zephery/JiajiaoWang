<%--
  Created by IntelliJ IDEA.
  User: Zephery
  Date: 2016/5/26
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<s:iterator value="#request['content']" id="content">
    <td><s:property value="#content"/></td>
</s:iterator>
<s:iterator value="#request['pinglunlist']" id="pinglunlist">
    <td>
        <s:property value="#pinglunlist"/>
    </td>
</s:iterator>
<td>more</td>