<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>生成邀请码</title>
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style>
#invitecode {
	width: 20rem;
	margin: auto;
	line-height: 5rem;
	text-align: center;
}

#checkradio ul li {
	list-style: none;
	float: left;
	width: 5rem;
	text-align: center;
	font-size: 16px;
}

#substyle {
	text-align: center;padding-top: 3rem;
}

#substyle ul li {
	list-style: none;
	float: left;
}

.subbtn {
	width: 16rem;
	height: 2.5rem;
	font-size:16px;
}


#codetext{
font-size:16px;color:blue;
}
</style>
</head>
<body>
	<div id="main">

		<div id="maincontent" position="center" title=" ">
               <div id="beautiful" style="padding-left:0rem;">
                <div id="etitle" style="margin-bottom:12rem;">
               <div id="whereimg"><img src="../images/adminBP/create_invite_code.webp"/></div>
               <div id="whatfont">生成邀请码</div>
                <div class="both"></div>
               </div>
			<div id="invitecode">

				<div id="codetext">
				</div>
				<div id="checkradio">
					<ul>
						<li><input type="radio" name="codedate" id="codedate1"
							value="1" checked="checked"/><label for="codedate1">1天</label></li>
						<li><input type="radio" name="codedate" id="codedate7"
							value="7" /><label for="codedate7">7天</label></li>
						<li><input type="radio" name="codedate" id="codedate15"
							value="15" /><label for="codedate15">15天</label></li>
						<li><input type="radio" name="codedate" id="codedate30"
							value="30" /><label for="codedate30">30天</label></li>
					</ul>
				</div>
				<div style="clear:both;"></div>
				<div id="substyle">
					<input type="button" value="生&nbsp;&nbsp;&nbsp;成" onclick="createcode()" class="subbtn" />
				</div>
			</div>
			<!-- <div id="maingrid">
            </div> -->
		</div>
		</div>
		<div position="top">
			<%@ include file="/admin/top.jsp"%>
		</div>
		<div position="left" title="主菜单">
			<%@ include file="/admin/left.jsp"%>
		</div>
	</div>
	<br />
	<div style="display:none;"></div>
</body>
<script type="text/javascript">
	$(function() {
		$.expandAccordionMenu("othermenu");
		$("#codetext").hide();
	});

	function createcode() {

		var param = {
			"codedate" : $('input[name="codedate"]:checked').val()
		};

		j4tg.ajaxPost("${ctx}/admin/wCreateCode.action", "json", false,
				param, function(data) {

					if (data.status == "S") {
						$("#codetext").show();
						$("#codetext").html(data.respData);
					} else {
						$.ligerDialog.success('生成失败，请联系管理员！');
					}

				}, function(data) {

				});

	}
</script>
</html>