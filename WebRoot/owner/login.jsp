<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>企业登陆</title>
<%@ include file="/admin/common/admin-sc.jsp"%>
<link href="${ctx}/style/global.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="login-bg1">
		<div class="login-title">
			<img src='${ctx}/images/bgindex/gear-1.png' /><span>企业管理中心</span>
		</div>
		<div class="login-panel">


			<h3>登录</h3>
			<div class="login-mod">
				<div id="err_area" class="login-err-panel dn">
					<span class="icon-wrapper"> <i
						style="margin-top:-.2em;*margin-top:0;" class="icon24-login err">
					</i>
					</span> <span id="err_tips"> </span>
				</div>
				<form action="${ctx}/owner/wLogin.action?shopNum=taoguan" method="post"
					class="login-form" id="f">
					<div class="login-un">
						<input type="text" placeholder="用户名" maxlength="20" id="adminName"
							name="adminName" />
					</div>
					<div class="login-pwd">
						<input type="password" placeholder="密码" maxlength="20"
							id="adminPwd" name="adminPwd" />
					</div>
					<div class="login-pwd">
						<div style="float:left;margin-top:0.5rem;"><input type="text" id="checkcode" placeholder="验证码" maxlength="4" name="captchaimage" style="width:4.5rem;text-align:center;font-size:20px;font-family:'微软雅黑';background-repeat: no-repeat;background-position:2px;" /></div>
						<div style="float:left;margin-left:1rem;"><img id="captchaimage" src="${ctx}/common/captchas.action?uuid=1" onclick="this.src='${ctx}/common/captchas.action?uuid=1&r=' + Math.random(); " title="看不清楚？点击图片刷新" style="cursor:pointer;vertical-align: middle;" /></div>
						<div style="clear:both"></div>
					</div>
				</form>
				<div>
					<a class="login-btn-panel" href="#" id="login">登 录</a>
				</div>
				<div> <font style="color:#F00;">
                        <s:property value="weaResponse.message" />
                    </font></div>
			</div>
		</div>


	</div>

	<div class="login-foot">淘冠科技版权所有 2012-2013 浙ICP备12024355号</div>
	
</body>
<script type="text/javascript">
	
	$(function() {
		$("#checkcode").keyup(function(){
			var tv=$(this).val().toLocaleLowerCase();
			if(tv.length == 4){
                var regcode="";
				
                var param = {
        				"parameter" : "It is no use"
        			};
               
			        j4tg.ajaxPost("${ctx}/owner/WRegcode.action", "json", false,param,
			        function(data) {
			        	regcode = data.respData;
			        },
			        function(data) {

					});
			        
				if(tv == regcode){
					$("#checkcode").css("background-image","url(${ctx}/images/bgindex/right.png)");
					}else{
					$("#checkcode").css("background-image","url(${ctx}/images/bgindex/wrong.png)");
					}
				}else if(tv.length == 0){
					$("#checkcode").css("background-image","");
				}
			});
		$("#login").click(function() {
			if (validate()) {
				$("#f").submit();
			}
		});
	});
	
	function validate() {
		var adminname = $.trim($("#adminName").val());
		var adminpwd = $.trim($("#adminPwd").val());
		if (adminname.length == 0) {
			alert("请输入账户");
			return false;
		}
		if (adminpwd.length == 0) {
			alert("请输入密码");
			return false;
		}
		return true;
	}
</script>
</html>
