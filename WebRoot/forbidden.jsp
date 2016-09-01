<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>禁止访问</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
    <div align="center" style="margin:0 auto"><h3>您没有相应操作的权限，请联系系统管理员！</h3></div>
    <br/>
    <div align="center" style="margin:0 auto"><a href="javascript:history.back(-1);">返回</a></div>
</body>
</html>
