<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>对账日报表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
 <style type="text/css">
.clear {
	clear: both;
}

.center{text-align:center;margin-top:2rem;}
.tleft{text-align:left;}
.title{border-top:0.1rem solid;border-bottom:0.1rem solid;border-right:0.1rem solid;width: 1190px;}
.title label {
	display: block;
	float:left;
	width:8rem;
	text-align:center;
	border-left:0.1rem solid;
	padding-top:0.5rem;
	padding-bottom:0.5rem;
	font-weight:bold;
}
.head{
	float:left;
	width:129px;
	border-bottom:0.1rem solid;
	text-align:center;
}
.con{width: 1061px;float:left;}
.con label {
	display: block;
	float:left;
	width:8rem;
	text-align:center;
	border-left:0.1rem solid;
	border-bottom:0.1rem solid;
	padding-top:1rem;
	padding-bottom:1rem;
}
.xiaoji{width:1189px;border-left:0.1rem solid;border-right:0.1rem solid;border-bottom:0.1rem solid;}
        
.xiaoji label {
	display: block;
	float:left;
	text-align:center;
	border-left:0.1rem solid;
	padding-top:1rem;
	padding-bottom:1rem;
}
.reportButton{
border:thin solid #ccc;background-color:#ffffff;border-radius:0.3rem;padding:0.2rem;
}
#nextOrPrev_page {
margin:auto;margin-top:1rem;margin-bottom:1rem;width:45rem;
}
.pageButton{float:left;margin-left:1rem;text-align:center;}
.pageButton ul li{float:left;margin-left:0.5rem;padding:0;border:thin solid #ccc;width:1rem;border-radius:0.2rem;text-align:center;}
#showPages{border:none;padding:0;}
#toWhichPage{width:50px;text-align:center;}
#toPage{float:left;margin-left:1rem;padding:0.2rem 0.5rem 0.2rem 0.5rem;color:#ffffff;background-color:#8cb0dc;border:none;border-radius:0.3rem;}
</style>
</head>  
<body>
    <div id="main">
       
        <div id="maincontent" position="center" title=" ">
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first" style="text-align:right;">
                            客户：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" placeholder="请选择客户"/>
                            <input type="hidden" id="hidCustNum"/>
                        </i>
                        <i class="i-spacing-follow">
                            从：
                        </i>
                        <i class="i-spacing-follow">
                           <input type="text" id="createDateFrom" placeholder="请选择日期时间段"/>
                        </i>
                        <i class="i-spacing-follow">
                            到：
                        </i>
                        <i class="i-spacing-follow">
                           <input type="text" id="createDateTo" placeholder="请选择日期时间段"/>
                        </i>
                    </li>
                    <li>
                        <i class="i-spacing-follow">
                            <input type="button" class="reportButton" value="生成PDF报表" onclick="f_searchStaInvs('wGetOrderProductsSumPDFReport')"/>
                            &nbsp;&nbsp;&nbsp;<input class="reportButton" type="button" value="生成网页报表" onclick="f_searchStaInvs('wGetOrderProductsSumHTMLReport')"/>
                            &nbsp;&nbsp;&nbsp;<input class="reportButton" type="button" value="生成XLS报表" onclick="f_searchStaInvs('wGetOrderProductsSumXLSReport')"/>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
             <div id="nextOrPrev_page">
             <div class="pageButton" style="padding-top:0.2rem;">记录数 <label id="count"></label> 条</div>
             <div class="pageButton" style="padding-top:0.2rem;">共 <label id="totalpage"></label> 页</div>
             <div class="pageButton" style="padding-top:0.2rem;">第 <label id="pageNumber"></label> 页</div>
             <div class="pageButton" id="PREV" style="padding-top:0.2rem;">上一页</div>
             <div class="pageButton" id="showPages"></div>
             <div class="pageButton" id="NextPage" style="padding-top:0.2rem;">下一页</div>
             <div class="pageButton">跳转到 <input type="text" id="toWhichPage"/> 页</div>
             <div id="toPage">确&nbsp;定</div>
             <div style="clear:both;"></div>
             </div>
             <div style="clear:both;"></div>
             <iframe id="riframe" width='100%' height='650' style="border:none;"></iframe>
            </div>
        </div>
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div position="bottom">
         <%@ include file="/owner/bottom.jsp" %>
        </div>
         <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
     <input type="hidden" id="hidCreateDateFrom" />
     <input type="hidden" id="hidCreateDateTo" />
     <input type="hidden" id="hidOwnerNum" />
     <input type="hidden" id="whichReport" />
     
</body>
<script type="text/javascript">

    $(function() {
    	$(".title").hide();
    	$("#nextOrPrev_page").hide();
        $.expandAccordionMenu("statistics");
        
        $("#pageNumber").text(1);
        
        $(".reportButton").click(function(){
    		$(".reportButton").css("border-color","#ccc");
    		$(this).css("border-color","#347dd7");
    	});

        $("#goIndexPage").click(function(){
        	 f_searchStaInvs($("#whichReport").val());
        	 $("#pageNumber").text(1);
        });
        $("#goLastPage").click(function(){
        	var lastPageNum = $("#totalpage").text();
        	nextPageFun(lastPageNum);
        	$("#pageNumber").text(lastPageNum);
        });
        
    	$("#NextPage").click(function(){
    		nextPageFun();
    	});
    	$("#toPage").click(function(){
    		nextPageFun(parseInt($("#toWhichPage").val().trim()));
    	});
    	
    	 $(document).on('click', '#showPages ul li', function() {
     		nextPageFun(parseInt($(this).text()));
    	 });
    	

    	$("#PREV").click(function(){
    		
    		if($("#pageNumber").text() != 1){
    			$("#pageNumber").text(parseInt($("#pageNumber").text()) - parseInt(1));
    			
    		 
    			var custNum =  $("#hidCustNum").val();
    	       	 var ownerNum =  $("#hidOwnerNum").val();
    	       	 var createdatefrom = liger.get("createDateFrom").inputText.val();
    	       	 var createDateTo = liger.get("createDateTo").inputText.val();
    	       	 
    	       	 if (string.isInvalid(custNum)) {
    	               $.ligerDialog.error('请选择客户');
    	               return;
    	           }
    	       	 if (string.isInvalid(createdatefrom) || string.isInvalid(createDateTo)) {
    	               $.ligerDialog.error('请选择您要查询的时间段');
    	               return;
    	           }
    	            
    	            if(createDateTo < createdatefrom){
    	           	 $.ligerDialog.error('结束时间不能小于开始时间');
    	                return;
    	            }
    	            
    	            
    	   		var ct= new Date(Date.parse(createDateTo.replace(/-/g,   "/"))); 
    	   		var cf= new Date(Date.parse(createdatefrom.replace(/-/g,   "/")));
    	   		
    	   		var date3=ct.getTime()-cf.getTime()
    	   		var days=Math.floor(date3/(24*3600*1000))
    	            
    	            if (days > 15) {
    	           	 $.ligerDialog.error('时间段，请不要大于15天');
    	                return;
    	            } 
    	       	 
    	            $("#riframe").attr(
    	    				"src",
    	    				"http://rpt.etaoguan.com/wea/"+$("#whichReport").val()+".action?orderProductsSearch.custNum=" +custNum
    	    						+ "&orderProductsSearch.ownerNum=" + ownerNum + "&orderProductsSearch.createDateFrom="
    	    						+ createdatefrom + "&orderProductsSearch.createDateTo=" + createDateTo +"&wpagingRequest.perPageUnitNum=4&wpagingRequest.currentPage="+parseInt($("#pageNumber").text())+"&signCode=074CE79A5ADF6307929CB2D4EB0A07B4" );
    	   			
    		}else{
    			 $.ligerDialog.error('这已经是第一页');
    		}

    	});
    	
    	
    	
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        $("#createDateFrom").ligerDateEditor({
            cancelable: false
        });
        $("#createDateTo").ligerDateEditor({
            cancelable: false
        });
    });
    
    
    function nextPageFun(pageNumber){
    	
    	if(pageNumber != undefined){
    	$("#pageNumber").text(parseInt(pageNumber));
    	}else{
    	$("#pageNumber").text(parseInt($("#pageNumber").text()) + parseInt(1));
    	}
		
		 
		var custNum =  $("#hidCustNum").val();
   	 var ownerNum =  $("#hidOwnerNum").val();
   	 var createdatefrom = liger.get("createDateFrom").inputText.val();
   	 var createDateTo = liger.get("createDateTo").inputText.val();
   	 
   	 if (string.isInvalid(custNum)) {
           $.ligerDialog.error('请选择客户');
           return;
       }
   	 if (string.isInvalid(createdatefrom) || string.isInvalid(createDateTo)) {
           $.ligerDialog.error('请选择您要查询的时间段');
           return;
       }
        
        if(createDateTo < createdatefrom){
       	 $.ligerDialog.error('结束时间不能小于开始时间');
            return;
        }
        
        
		var ct= new Date(Date.parse(createDateTo.replace(/-/g,   "/"))); 
		var cf= new Date(Date.parse(createdatefrom.replace(/-/g,   "/")));
		
		var date3=ct.getTime()-cf.getTime()
		var days=Math.floor(date3/(24*3600*1000))
        
        if (days > 15) {
       	 $.ligerDialog.error('时间段，请不要大于15天');
            return;
        } 
   	 
        $("#riframe").attr(
				"src",
				"http://rpt.etaoguan.com/wea/"+$("#whichReport").val()+".action?orderProductsSearch.custNum=" +custNum
						+ "&orderProductsSearch.ownerNum=" + ownerNum + "&orderProductsSearch.createDateFrom="
						+ createdatefrom + "&orderProductsSearch.createDateTo=" + createDateTo +"&wpagingRequest.perPageUnitNum=4&wpagingRequest.currentPage="+parseInt($("#pageNumber").text())+"&signCode=074CE79A5ADF6307929CB2D4EB0A07B4" );
		
    }

    function f_selectCust() {
    	
        $.ligerDialog.open({
            title: '选择客户',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/owner/wListSearchCusts.action?custSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectCustOK
            },
            {
                text: '取消',
                onclick: f_selectCustCancel
            }]
        });
        return false;
    }
    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            $.ligerDialog.error('请选择客户');
            return;
        }

        $("#companyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        $("#hidOwnerNum").val(data.ownerNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }
    
    


    function f_searchStaInvs(whichReport) {
    	
    	$("#whichReport").val(whichReport);
    	
    	
    	 var custNum =  $("#hidCustNum").val();
    	 var ownerNum =  $("#hidOwnerNum").val();
    	 var createdatefrom = liger.get("createDateFrom").inputText.val();
    	 var createDateTo = liger.get("createDateTo").inputText.val();
    	 
    	 if (string.isInvalid(custNum)) {
            $.ligerDialog.error('请选择客户');
            return;
        }
    	 if (string.isInvalid(createdatefrom) || string.isInvalid(createDateTo)) {
            $.ligerDialog.error('请选择您要查询的时间段');
            return;
        }
         
         if(createDateTo < createdatefrom){
        	 $.ligerDialog.error('结束时间不能小于开始时间');
             return;
         }
         
         
		var ct= new Date(Date.parse(createDateTo.replace(/-/g,   "/"))); 
		var cf= new Date(Date.parse(createdatefrom.replace(/-/g,   "/")));
		
		var date3=ct.getTime()-cf.getTime()
		var days=Math.floor(date3/(24*3600*1000))
         
         if (days > 15) {
        	 $.ligerDialog.error('时间段，请不要大于15天');
             return;
         } 
    	 
		
         $("#riframe").attr(
 				"src",
 				"http://rpt.etaoguan.com/wea/"+whichReport+".action?orderProductsSearch.custNum=" +custNum
 						+ "&orderProductsSearch.ownerNum=" + ownerNum + "&orderProductsSearch.createDateFrom="
 						+ createdatefrom + "&orderProductsSearch.createDateTo=" + createDateTo +"&wpagingRequest.perPageUnitNum=4"+ "&wpagingRequest.currentPage=1"+ "&signCode=074CE79A5ADF6307929CB2D4EB0A07B4" );
			
			
         $("#nextOrPrev_page").show();
			
         /* 获取总页数 */
         
         var param = {
	            "orderProductsSearch.custNum": custNum,
	            "orderProductsSearch.ownerNum": ownerNum,
	            "orderProductsSearch.createDateFrom": createdatefrom,
	            "orderProductsSearch.createDateTo": createDateTo,
	            "orderProductsSearch.perPageUnitNum": 4,
	            "orderProductsSearch.currentPage": 1,
	            "orderProductsSearch.signCode": "074CE79A5ADF6307929CB2D4EB0A07B4",
	            "wpagingRequest.currentPage": 1,
	            "wpagingRequest.perPageUnitNum": 4
	        };
         
         j4tg.ajaxPost("http://rpt.etaoguan.com/wea/countPages.action", "jsonp", false, param,
     	        function(data) {
        	
     		for(var i in data) {
     			
     			if( i == "respData"){
     				$("#totalpage").text(data[i].totalPages);//总页数
     				var tpages = data[i].totalPages;
     				$("#count").text(data[i].totalRecNum);//总条数
     				
     				var loopPages=0;
     	     		if(parseInt(tpages) >= 7){
     	     			loopPages = 7;
     	     		}else{
     	     			loopPages = tpages; 
     	     		}
     	     		
     	     		var liText = "";//显示的页码
     	     		for(var i = 1;i< parseInt(loopPages)+1; i++){
     	     			liText = liText + "<li>"+i+"</li>";
     	     		}
     	     		$("#showPages").html("<ul>"+liText+"</ul>");
     	     		
     			}
             } 
     		
     		
     		
     		
     	        },
     	        function(data) {
     	        	/* alert("你选择的时间段内没有数据"); */
     	        });	
         
         /* 获取总页数 */
    	 
    }
    
    

</script>
</html>