<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>家教资讯网系统</title>
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>

    <script src="<%=path%>/js/h.js" type="text/javascript"></script>
    <script language="javascript">
        function stuReg() {
            var url = "<%=path %>/stuReg.jsp";
            var n = "";
            var w = "480px";
            var h = "500px";
            var s = "resizable:no;help:no;status:no;scroll:yes";
            openWin(url, n, w, h, s);
        }
        function check1() {
            if (document.ThisForm.userName.value == "") {
                alert("请输入客户名");
                document.ThisForm.userName.focus();
                return false;
            }
            if (document.ThisForm.userPw.value == "") {
                alert("请输入密码");
                document.ThisForm.userPw.focus();
                return false;
            }
            document.getElementById("indicator").style.display = "block";
            loginService.login(document.ThisForm.userName.value, document.ThisForm.userPw.value, 0, callback);
        }

        function callback(data) {
            document.getElementById("indicator").style.display = "none";
            if (data == "no") {
                alert("客户名或密码错误");
            }
            if (data == "yes") {
                alert("通过验证,系统登录成功");
                window.location.href = "<%=path%>/loginSuccess.jsp";
            }

        }
    </script>
    <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="signup_container">
    <h1 class="signup_title">
        <center>家教资讯网系统</center>
    </h1>
    <img src="images/people.png" id="admin">
    <FORM name="ThisForm" action="<%=path %>/adminLogin.action" method=post>
        <div id="signup_forms" class="signup_forms clearfix">
            <div class="form_row first_row">
                <label for="signup_email">请输入客户名</label>
                <input name="userName" placeholder="请输入客户名" class="user" value="">
            </div>
            <div class="form_row">
                <label for="signup_password">请输入密码</label> <input name="userPw"
                                                                  placeholder="请输入密码" class="pwd" type="password">
            </div>
        </div>
        <div class="login-btn-set">
            <img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
            <input name="button" type="button" class="login-btn" id="Submit" onclick="check1()">
        </div>
        <div class="rem">版权所有</div>
    </form>
</div>
</body>
</html>