<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet"/>

    <script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path %>/js/popup_shuaxin_no.js"></script>
    <script type="text/javascript">
        function yuyue_jiaoyuan(jiaoyuan_id) {
            <c:if test="${sessionScope.userType==null}">
            alert("请先登录");
            </c:if>
            <c:if test="${sessionScope.userType==1}">
            alert("很抱歉，您是教员，不能预约教员~");
            </c:if>
            <c:if test="${sessionScope.userType==2}">
            var url = "/jiajiaomana/qiantai/yuyue/yuyue_jiaoyuan.jsp?jiaoyuan_id=" + jiaoyuan_id;
            var pop = new Popup({contentType: 1, isReloadOnClose: false, width: 450, height: 440});
            pop.setContent("contentUrl", url);
            pop.setContent("title", "预约教员");
            pop.build();
            pop.show();
            </c:if>
        }

        function pinglunAll(id) {
            var url = "<%=path %>/pinglunAll.action?newsId=" + id;
            var pop = new Popup({contentType: 1, isReloadOnClose: false, width: 650, height: 450});
            pop.setContent("contentUrl", url);
            pop.setContent("title", "评论");
            pop.build();
            pop.show();
        }

        function pinglunAdd(id) {
            var url = "<%=path %>/qiantai/jiaoyuan/pinglunAdd.jsp?newsId=" + id;
            var pop = new Popup({contentType: 1, isReloadOnClose: false, width: 700, height: 400});
            pop.setContent("contentUrl", url);
            pop.setContent("title", "写评论");
            pop.build();
            pop.show();
        }
    </script>
</head>

<body>
<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"/>
<div class="page_row">
    <div class="page_main_msg left">
        <div class="left_row">
            <div class="list pic_news">
                <div class="list_bar">
                    <span style="float:left">教员详细信息</span>
                </div>
                <div id="tw" class="list_content" style="height: 800px;">
                    <table width="100%" border="0" cellpadding="9" cellspacing="9">
                        <tr>
                            <td align="left">照片：<img src="<%=path %>/${requestScope.jiaoyuan.fujian }" width="120"
                                                     height="150"/></td>
                        </tr>
                        <tr>
                            <td align="left">姓名：${requestScope.jiaoyuan.name }</td>
                        </tr>
                        <tr>
                            <td align="left">性别：${requestScope.jiaoyuan.sex }</td>
                        </tr>
                        <tr>
                            <td align="left">年龄：${requestScope.jiaoyuan.age }</td>
                        </tr>
                        <tr>
                            <td align="left">联系方式：***********</td>
                        </tr>
                        <tr>
                            <td align="left">住址：${requestScope.jiaoyuan.address }</td>
                        </tr>
                        <tr>
                            <td align="left">
                                身份：
                                <c:if test="${requestScope.jiaoyuan.shenfen=='daxuesheng'}"><font
                                        size="2">在校大学生(研究生)</font></c:if>
                                <c:if test="${requestScope.jiaoyuan.shenfen=='laoshi'}"><font
                                        size="2">教师(在职/进修/离职/退休)</font></c:if>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">学历：${requestScope.jiaoyuan.xueli }</td>
                        </tr>
                        <tr>
                            <td align="left">可辅导科目：${requestScope.jiaoyuan.kefudaokemu }</td>
                        </tr>
                        <tr>
                            <td align="left">自我介绍：${requestScope.jiaoyuan.ziwojieshao }</td>
                        </tr>
                        <tr>
                            <td align="left">
                                <a href="#" style="color: red"
                                   onclick="pinglunAll(${requestScope.jiaoyuan.id })">老师信息评论</a>
                                &nbsp;
                                <a href="#" style="color: red"
                                   onclick="pinglunAdd(${requestScope.jiaoyuan.id })">我要评论</a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <a href="#" onclick="yuyue_jiaoyuan(${requestScope.jiaoyuan.id })"><img
                                        src="<%=path %>/img/yuyue.jpg"/></a>
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
