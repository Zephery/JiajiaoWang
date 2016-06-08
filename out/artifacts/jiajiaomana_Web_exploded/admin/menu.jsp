<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'menu.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="<%=path%>/css/base.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path%>/css/menu.css" type="text/css"/>
    <style type="text/css">
        div {
            padding: 0px;
            margin: 0px;
        }

        body {
            scrollbar-base-color: #207697;
            scrollbar-arrow-color: #FFFFFF;
            scrollbar-shadow-color: #c1ea8b;
            padding: 0px;
            margin: auto;
            text-align: center;
            background-color: #207697;
        }

        dl.bitem {
            width: 148px;
            margin: 0px 0px 5px 4px;
        }

        dl.bitem dt {
            background: url(<%=path%>/img/menubg.gif);
            height: 26px;
            line-height: 26px;
            text-align: center;
            cursor: pointer;
        }

        dl.bitem dd {
            padding: 3px 3px 3px 3px;
            background-color: #fff;
        }

        .fllct {
            float: left;
            width: 90px;
        }

        .flrct {
            padding-top: 3px;
            float: left;
        }

        div.items {
            line-height: 22px;
            background: url(<%=path%>/img/arr4.gif) no-repeat 10px 9px;
        }

        span.items {
            padding: 10px 0px 10px 22px;
            background: url(<%=path%>/img/arr4.gif) no-repeat 10px 12px;
        }

        ul {
            padding-top: 3px;
        }

        li {
            height: 22px;
        }

        .sitemu li {
            padding: 0px 0px 0px 22px;
            line-height: 24px;
            background: url(<%=path%>/img/arr4.gif) no-repeat 10px 9px;
        }
    </style>
    <script language='javascript'>
        var curopenItem = '1';
    </script>
    <script language="javascript" type="text/javascript"
            src="<%=path%>/js/menu.js"></script>
    <base target="main"/>
</head>

<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0'
       cellpadding='0'>
    <tr>
        <td style='padding-left: 3px; padding-top: 8px' valign="top">
            <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items1_1")'>
                    <b>修改个人密码</b>
                </dt>
                <dd style='display: block' class='sitem' id='items1_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/admin/index/userinfo.jsp'
                               target='main'>修改个人密码</a></li>
                    </ul>
                </dd>
            </dl> <!-- 1 --> <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items1_1")'>
                    <b>管理员管理</b>
                </dt>
                <dd style='display: block' class='sitem' id='items1_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/adminManage.action' target='main'>管理员管理</a>
                        </li>
                    </ul>
                </dd>
            </dl> <!-- 1 --> <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items2_1")'>
                    <b>教员学员管理</b>
                </dt>
                <dd style='display: block' class='sitem' id='items2_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/jiaoyuanMana.action' target='main'>教员信息管理</a>
                        </li>
                        <li><a href='<%=path%>/xueyuanMana.action' target='main'>学员信息管理</a>
                        </li>
                    </ul>
                </dd>
            </dl> <!-- 1 --> <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items3_1")'>
                    <b>公告信息管理</b>
                </dt>
                <dd style='display: block' class='sitem' id='items3_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/gonggaoMana.action' target='main'>公告信息管理</a>
                        </li>
                        <li><a href='<%=path%>/admin/gonggao/gonggaoAdd.jsp'
                               target='main'>公告信息录入</a></li>
                    </ul>
                </dd>
            </dl> <!-- 1 --> <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items3_1")'>
                    <b>预订统计管理</b>
                </dt>
                <dd style='display: block' class='sitem' id='items3_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/yuyuemana.action' target='main'>预订统计管理</a>
                        </li>
                    </ul>
                </dd>
            </dl> <!-- 1 --> <!-- 1 -->

            <dl class='bitem'>
                <dt onClick='showHide("items99_1")'>
                    <b>常见问题</b>
                </dt>
                <dd style='display: block' class='sitem' id='items3_1'>
                    <ul class='sitemu'>
                        <li><a href='<%=path%>/getallproblem.action' target='main'>增删修</a>
                        </li>
                    </ul>
                </dd>
            </dl> <!-- 1 -->
            <dl class='bitem'>
                <dt onClick='showHide("items99_1")'>
                    <b>安全退出系统</b>
                </dt>
                <dd style='display: block' class='sitem' id='items99_1'>
                    <ul class='sitemu'>
                        <li><a href='#'
                               onclick='javascript:window.parent.location="<%=path%>/login.jsp"'>安全退出系统</a></li>
                    </ul>
                </dd>
            </dl> <!-- 1 -->

        </td>
    </tr>
</table>
</body>
</html>
