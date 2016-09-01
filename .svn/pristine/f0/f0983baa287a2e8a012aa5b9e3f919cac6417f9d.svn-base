<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>微信支付</title>
    
	<style type="text/css">
*{font-family: '微软雅黑';}
body{
	margin: auto;
	text-align: center;
	font-size: 5rem;
}
div{
	margin-top: 5rem;
}
input{
	width: 100%;
	height: 7rem;
	border-radius: 1.5rem;
	 border:solid #ccc; 
	font-size: 4rem;
	background-color:transparent;
}
.inputdiv{
	width: 80%;
	margin: auto;
	margin-top: 7rem;
}

</style>
<script src="${ctx}/js/jquery/jquery-1.7.1.min.js" type="text/javascript"></script>
  </head>
  
  <body>
  
<div><img src="${ctx}/images/mobile/payMoney.png" alt="微信支付"></div>
<div id="submitContex2t">应付总金额 ￥${brandWCPayRequest.realPriceTotal}</div>
<div class="inputdiv"><input type="button" id="submitPay" onclick="onBridgeReady()" value="确认付款"></div>
<div class="inputdiv"><input type="button" onclick="javaScript:window.history.go(-2);" value="返回"></div>

	<input type="hidden" id="appid" value="${brandWCPayRequest.appid}"/>
	<input type="hidden" id="timeStamp" value="${brandWCPayRequest.timeStamp}"/>
	<input type="hidden" id="nonceStr" value="${brandWCPayRequest.nonceStr}"/>
	<input type="hidden" id="packageStr" value="${brandWCPayRequest.packageStr}"/>
	<input type="hidden" id="status" value="${brandWCPayRequest.status}"/>
	<input type="hidden" id="errorMessage" value="${brandWCPayRequest.errorMessage}"/>
	<input type="hidden" id="sign" value="${brandWCPayRequest.paySign}"/>
  
	<script type="text/javascript">
  
  	function onBridgeReady(){
  		
  		var appid = document.getElementById("appid").value;
  		var timeStamp = document.getElementById("timeStamp").value;
  		var status = document.getElementById("status").value;
  		var errorMessage = document.getElementById("errorMessage").value;
  		
  		if(status=="E"){
  		  $("#submitContex2t").html("");
  		  $("#submitContex2t").html(errorMessage);
  		  $("#submitPay").hide();
  		}else{
  			WeixinJSBridge.invoke(
   	  		       'getBrandWCPayRequest', {
   	  		    	"appId" : appid,     //公众号名称，由商户传入     
   	  	           "timeStamp":timeStamp,         //时间戳，自1970年以来的秒数     
   	  	           "nonceStr" : document.getElementById("nonceStr").value, //随机串     
   	  	           "package" : document.getElementById("packageStr").value,     
   	  	           "signType" : "MD5",         //微信签名方式:     
   	  	           "paySign" : document.getElementById("sign").value //微信签名 
   	  		       },
   	  		       function(res){     
   	  		           if(res.err_msg == "get_brand_wcpay_request:ok" ) { // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
   	  		       		window.history.go(-2);
   	  					}else{
   	  						$("#submitContex2t").html("支付遇到问题");
   	  					}
   	  		       }
   	  		   ); 
  		}
  		
  		
	}
	
  
  
  </script>
		
  </body>
  </html>
