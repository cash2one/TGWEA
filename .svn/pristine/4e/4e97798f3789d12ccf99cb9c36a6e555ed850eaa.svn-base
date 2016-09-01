<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>系统异常</title>
<style type="text/css">
body {
	background-color: #f7f7f7;
	font-family: "微软雅黑";
	margin:auto;
	width: 50rem;
}
.fleft{float:left;}
.fright{float:right;}
.tcenter{text-align:center;font-size:1.5rem;}
.bradius{border-radius:0.5rem;}
.nborder{border:none;}



.context{margin-top:12rem;margin-left:10rem;}
.crightdiv{margin-left:1rem;width:19rem;white-space:normal;word-wrap:break-word;}
.crightdiv input{height:2.5rem;width:12rem;font-size:1.5rem;background-color: #aec7d4;color:#FFF;}
</style>
</head>
<body class="tcenter">
<div class="context">
<div class="fleft"> <img src='${ctx}/images/error/error.png' alt='' title='请联系系统管理员' width="214" height="259"/></div>
<div class="fleft crightdiv tcenter">
<div style="font-size:1.3rem;">出错了，请联系系统管理员！</div>

<div style="font-size:14px;padding-top:1.5rem;padding-bottom:1.5rem;">
<s:property value="weaResponse.message" />
</div>

<div style="clear:both;"></div>
<input type="button" id="returnbtn" value="返&nbsp;&nbsp;回" class="bradius nborder tcenter" onclick="javascript:history.back(-1);"/></div>

</div>
</body>
</html>