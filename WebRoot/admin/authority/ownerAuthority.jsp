<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>企业权限管理</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
li{
 margin-left: 5rem;
    list-style: none;
    float: left;
}

li input[type="button"]{padding:0.2rem;}
label{
margin-left:0.3rem;
font-size:14px;
}
</style>
</head>  
<body>
    <div id="main">
       <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/beautiful-page/editcom.webp"/></div>
               <div id="whatfont">企业权限管理</div>
                <div class="both"></div>
               </div>
                <div class="both" style="height:5rem;"></div>
            <div style="margin-left:3rem;margin-top:3rem;">选择企业:
            	<select id="selown">
				</select>
			</div>
			
            <div style="width: 30rem;margin-left:3rem;margin-top:3rem; line-height: 2rem;">
            <li style="margin-left:0;">选择功能模块:</li>
            <li><input type="button" id="selectAll" value="全选/反选"/></li>
            <li><input type="button" id="wesite" value="微&nbsp;站"/></li>
            <li><input type="button" id="invoicing" value="进销存"/></li>
			<div style="clear:both;height:1rem;"></div>
     <ul>
        <li><label>账户管理</label><label><input type="checkbox" value="1" /></label></li> 
        <li><label>基础资料</label><label><input type="checkbox" value="2"/></label></li>
        <li><label>客户管理</label><label><input type="checkbox" value="3" /></label></li>
         <li><label>订单管理</label><label><input type="checkbox" value="4"/></label></li>
        <li><label>送货管理</label><label><input type="checkbox" value="5"/></label></li>
        <li><label>库存管理</label><label><input type="checkbox" value="6" /></label></li>
         <li><label>结算管理</label><label><input type="checkbox" value="7"/></label></li>
        <li><label>产品管理</label><label><input type="checkbox" value="8" /></label></li> 
       <!--  <li><label>价格管理</label><label><input type="checkbox" value="9"/></label></li> -->
       <li><label>同步数据</label><label><input type="checkbox" value="10" /></label></li> 
       <!--  <li><label>推送管理</label><label><input type="checkbox" value="11"/></label></li>  -->
       <li><label>微站管理</label><label><input type="checkbox" value="12"/></label></li> 
       <li><label>报表管理</label><label><input type="checkbox" value="13"/></label></li>
        <li><label>功能选项</label><label><input type="checkbox" value="14"/></label></li>
    </ul>
    <div style="clear:both;"></div>
			</div>
			
            <div style="margin-left:3rem;margin-top:3rem;width: 30rem;text-align:center;"><input type="button" id="savebtn" value="保存" style="height:2rem;width:6rem;letter-spacing: 0.3rem;vertical-align: middle;"/></div>
            
        </div>
        </div>
         <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        
    </div>
    <br />
</body>
<script type="text/javascript">
$(function() {
    $.expandAccordionMenu("enterprise");
    initWwners();
    
    
    var param = {
	            "authority.ownerNum": $("select").val()
	        };

	        j4tg.ajaxPost("${ctx}/admin/wShowAuthority.action", "json", false, param,
	        function(data) {

	            if (data.status == "S") {
	            	 
	          
	            for(var i=0;i<data.respData.length;i++){
	            	 $("input").each(function(){
	    				 if($(this).val() == data.respData[i]){
	            		
	    					 $(this).attr("checked",true);
	    				 }
	    			       });
	            }
	            }else{
	            	$.ligerDialog.error(data.message);
	            }

	        },
	        function(data) {

	    	});
	        
    $("#selectAll").click(function(){
        
        $("input[type='checkbox']").each(function(){
			if($(this).attr("checked")){
				 $("input[type='checkbox']").each(function(){
				 $(this).attr("checked",false);
			       });
				return false;
			}else{
				$("input[type='checkbox']").each(function(){
				 $(this).attr("checked",true);
				       });
				 return false;
			}
       });
          
   });
    
    $("#wesite").click(function(){
        $("input[type='checkbox']").each(function(){
        	  $(this).attr("checked",false);
       });
        
        $("input[type='checkbox']").each(function(){
          if( $(this).val() == 1 || $(this).val() == 2 || $(this).val() == 3 || $(this).val() == 4 || $(this).val() == 8 || $(this).val() == 10 || $(this).val() == 12){
        	  $(this).attr("checked",true);
          }
       
       });
          
   });
    
    $("#invoicing").click(function(){
        $("input[type='checkbox']").each(function(){

        	  $(this).attr("checked",true);
       
       });
          
   });
    
    $("#savebtn").click(function(){
    	
    	 var checked = [];
    	   
    	        $('input:checkbox:checked').each(function() {
    	            checked.push($(this).val().trim());
    	        });
    	       
    	    var param = {
    	            "authority.ownerNum": $("#selown").val(),
    	            "authority.whichAuthority": checked

    	        };

    	        j4tg.ajaxPost("${ctx}/admin/wSaveAuthority.action", "json", false, param,
    	        function(data) {

    	            if (data.status == "S") {
    	                $.ligerDialog.success('保存成功');
    	            }else{
    	            	$.ligerDialog.error(data.message);
    	            }

    	        },
    	        function(data) {

    	    	});
    });
    
    
    $("select").change(function(){
    	 $("input").each(function(){
				 $(this).attr("checked",false);
		 });
    	 
    	var ownerNum = $(this).val();
    	 var param = {
 	            "authority.ownerNum": ownerNum
 	        };

 	        j4tg.ajaxPost("${ctx}/admin/wShowAuthority.action", "json", false, param,
 	        function(data) {

 	            if (data.status == "S") {
 	            	 
		           /*  alert(JSON.stringify(data)); */
		            for(var i=0;i<data.respData.length;i++){
		            	 $("input").each(function(){
		    				 if($(this).val() == data.respData[i]){
		            		
		    					 $(this).attr("checked",true);
		    				 }
		    			       });
		            }
 	            }else{
 	            	$.ligerDialog.error(data.message);
 	            }

 	        },
 	        function(data) {

 	    	});
 	        
	});
    
    
});

function initWwners(){
	
	j4tg.ajaxPost("${ctx}/admin/wShowAllOwner.action", "json", false,{},
		    function(data) {

		        if (data.status == "S") {
		            /* 
		            alert(JSON.stringify(data)); */
		            for(var i=0;i<data.respData.length;i++){
		            $("#selown").append("<option value="+data.respData[i].ownerNum+">"+data.respData[i].companyName+"</option>");
		            }
		        }else{
		        	$.ligerDialog.error(data.message);
		        }

		    },
		    function(data) {

			});
}

</script>
</html>