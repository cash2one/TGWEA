<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>静态数据缓存管理</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery.blockUI.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

        function block() {
            $.blockUI(
            {   
                message:'<p>正在处理....</p>'
            });
        }

        function unblock() {
        	$.unblockUI();
        }
</script>
</head>
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
                <div id="beautiful">
                <div id="etitle">
               <div id="whereimg"><img src="../images/adminBP/syscfgload.webp"/></div>
               <div id="whatfont">静态数据缓存管理</div>
                <div class="both"></div>
               </div>
            <div align="center" style="overflow:hidden;width:600px;margin-left:7rem;margin-top:15rem;">
                <ul>
					<li class="i-spacing-follow">  
						<input id="genproddetailfilecache" class="button-common" type="button" value="生成产品静态数据" style="width:12rem;height:3rem;"/>
				    </li>
				   
				</ul>
            </div>
        </div>
        </div>
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body> 
<script  type="text/javascript">

	$(function(){
		$.expandAccordionMenu("configmenu");
		$("#genproddetailfilecache").click(ajaxPostfileCache);
	});
	function ajaxPostfileCache(){
		if(confirm("此操作可能会影响正在使用相关功能的用户，确定执行么?")){
			//$.applyWindowMask();
			block();
			var targetFileCache = this.id;
			var param = {"targetfilecache":targetFileCache};
			j4tg.ajaxPost("${ctx}/admin/wGenFileCache.action", "json", false, param,
            function(data) {

                if (data.status == "S") {
                    $.ligerDialog.success('执行成功');
                }else{
                	$.ligerDialog.error(data.message);
                }
                //$.removeWindowMask();
                unblock();

            },
            function(data) {
            	//$.removeWindowMask();
            	 unblock();
     		});

		}
	}
</script>
</html>