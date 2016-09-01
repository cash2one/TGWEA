<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>下载APP</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
* {
	font-family: "微软雅黑";
}
.clear {
	clear: both;
}

.fleft {
	float: left;
}
.wd {
	margin-top:2rem;
	margin-left:4rem;
	width: 24rem;
}
.wbd {
	height:2rem;
	border-bottom: 0.2rem solid #CCC;
}
.bddiv {
	background-image: url(/images/download/bgbtn.png);
	height: 55px;
	width: 152px;
	margin-left:1rem;
}
.could {
	margin-top:0.7rem;
margin-left:1rem;
}
.ft {
	margin-top: 1rem;
	margin-left: 1rem;
}
.djf{padding-top:1rem;padding-left:2rem;}
.sos{padding-top:2rem;padding-left:2rem;}
.sysf{padding-top:5rem;}
.qrcode{padding-left:1rem;}

li{
            float: left;
            list-style: none;
			font-size: 0.75rem;
            color:#999;
            margin-top: 2rem;
        }
        #w1{
            background-color: rgba(200, 200, 200, 0.25);
            width:40rem;
            margin: auto;
            padding:1rem 0rem 1rem 0rem;
        }
        #w2{
            width: 35rem;
            margin:auto;
            background-color: rgba(159, 159, 159, 0.05);
            padding:3rem 0rem 4rem 3rem;
        }

       #font_place{float:left;font-size:2rem;margin-left:6rem;margin-top:3rem;color:#db4a39;}
       #img_place{float:left;margin-left:2rem;}
</style>
</head>  
<body>
    <div id="main">
     <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        
        <div id="maincontent" position="center" title=" " style="margin-top:6rem;">
        <div id="w1">
            <div id="w2">
            <div id="changepwd"><div id="font_place">APP下载</div><div id="img_place"><img src="../images/beautiful-page/down_app.webp"/></div></div>
             <div class="clear"></div>
             <div class="wd">
   <div class="fleft djf">点击右侧按钮打开下载页：</div>
   <div class="fleft bddiv" id="dlapp">
                <div class="fleft could"><img src='${ctx}/images/download/colud.png'/></div>
                <div class="fleft ft">下载APP</div>
  				
   </div>
    <div class="clear"></div>
   <div class="wbd"></div>
   <div class="sos">
    <div class="fleft sysf">扫一扫，轻松下载：</div> <div class="fleft qrcode"><img id="androidimg"/></div>
   </div>
  </div>
  <div class="clear"></div>
        </div>
        </div>
        </div>
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div position="bottom">
         <%@ include file="/owner/bottom.jsp" %>
        </div>
    </div>
    <input type="hidden" id="v1" value="${sessionScope.ownerNum}"/>
    
</body>
<script  type="text/javascript">
$(function() {
    $.expandAccordionMenu("othermenu");
    $("#androidimg").attr("src","${ctx}/admin/androidqr.action?ownerNum="+$("#v1").val());
    $("#dlapp").click(function(){
    	
    	$.ligerDialog.open({ height: 500,width:500,title:'App下载',url: '/download/page/'+$("#v1").val()+'.html' });
    	
    });
});
</script>
</html>