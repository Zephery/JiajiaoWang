<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="/jiajiaomana/css/base.css" />
		
		<script language="JavaScript" src="/jiajiaomana/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='/jiajiaomana/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="/jiajiaomana/img/tbg.gif">&nbsp;我的预约&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">学员</td>
					<td width="20%">所留联系方式</td>
					<td width="20%">预约说明</td>
					<td width="20%">时间</td>
		        </tr>	
				<s:iterator value="#request.yuyueList" id="yuyue">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yuyue.xueyuan.name"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuyue.yuyuezhe_tel"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuyue.beizhu" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuyue.shijian"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
