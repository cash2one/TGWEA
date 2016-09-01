<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>添加特供产品信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerCheckBox.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
       <div id="maincontent" position="center" title=" ">
             <div id="beautiful">
              <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/addgps128.webp"/></div>
               <div id="whatfont">添加特供产品</div>
                <div class="both"></div>
               </div>
            <form name="godownForm" method="post" id="godownForm">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            选择客户组：<input type="hidden" id="choosed"/>
                        </i>
                        <i class="i-spacing-follow">
                            <select id="contactPerson"></select>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            选择产品：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="godowninv">
                                <li id="godowninv-hd" style="height:25px;width:430px;text-align:right">
                                    <a href="javascript:void(0);" onclick="f_addGodownInvItem();">
                                        <img src="../images/adminBP/add_group.webp" alt="添加" title="添加"/>
                                    </a>
                                </li>
                                <li class="li-line">
                                    <div id="maingrid">
                                    </div>
                                </li>
                            </ul>
                        </i>
                    </li>
                   <br/><br/>
                   <input type="hidden" id="chanpin"/>
                   <input type="hidden" id="chanpinxq"/>
                    <li class="li-line" style="text-align:center;margin-top:7rem;">
                        <input type="button" value="添&nbsp;加" id="saveGodownInv" name="saveGodownInv" onclick="javascript:f_addProdgps()"
                        class="button-submit" />
                        <input type="button" value="取&nbsp;消 " id="cancel" name="cancel" class="button-cancel"
                        onclick="javascript:history.back(-1);" />
                    </li>
                </ul>
            </form>
        </div>
        </div>
        <div position="top"> 
        <%@ include file="/owner/top.jsp" %>  
        </div>
        <div position="bottom">
         <%@ include file="/owner/bottom.jsp" %>
        </div>
    </div>
</body>
<script type="text/javascript">
    var manager, g, gcheckbox;

    $(function() {
        $.expandAccordionMenu("prodmenu");
        
        j4tg.ajaxPost("${ctx}/owner/wListSearchGroupOfCustsData.action", "json", false, {},
                function(data) {
            		
                    if (data.status == "S") {
        	    		for(var i=0;i<data.respData.length;i++){
        	    			
        	    			$("#contactPerson").append("<option value='"+data.respData[i].groupName+"'>"+data.respData[i].groupName+"</option>");
        	    			
        	    		}
        	               
        	         }else{
        	           	alert(data.message);
        	         }
                },
                function(data) {

        			});

        
        
        $.metadata.setType("attr", "validate");
        var v = $("#godownForm").validate({
            errorPlacement: function(lable, element) {
                if (element.hasClass("l-textarea")) {
                    element.ligerTip({
                        content: lable.html(),
                        target: element[0]
                    });
                } else if (element.hasClass("l-text-field")) {
                    element.parent().ligerTip({
                        content: lable.html(),
                        target: element[0]
                    });
                } else {
                    element.ligerTip({
                        content: lable.html(),
                        target: element[0]
                    });
                }

            },
            success: function(lable) {
                lable.ligerHideTip();
                lable.remove();
            },
            submitHandler: function() {
                $("form .l-text,.l-textarea").ligerHideTip();
                f_saveGodownInv();
                return false;
            }
        });

        
        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                align: 'left',
                frozen: true
            },
            {
                display: '产品名称',
                name: 'prodName',
                align: 'left',
                width: 400,
                editor: {
                    type: 'popup',
                    valueField: 'prodName',
                    textField: 'prodName',
                    cancelable: false,
                    grid: {
                        columns: [{
                            display: '产品名',
                            name: 'prodName',
                            isSort: false,
                            align: 'left',
                            width: 300
                        },
                        {
                            display: '单位',
                            name: 'unit',
                            width: 80,
                            isSort: false,
                            align: 'left',
                        },
                        {
                            display: '价格',
                            name: 'stdPrice',
                            width: 100,
                            minWidth: 60,
                            isSort: false,
                            align: 'left',
                        },
                        {
                            display: '显示库存',
                            name: 'dispStockBalance',
                            width: 90,
                            isSort: false,
                            align: 'left',
                        }],
                        url: "${ctx}/owner/wListSearchProdsData.action",
                        pagesizeParmName: "wpagingRequest.perPageUnitNum",
                        pageParmName: "wpagingRequest.currentPage",
                        pageSize: 10,
                        method: "post",
                        async: false,
                        enabledSort: false,
                        dataAction: "server",
                        parms: f_getProdsParam,
                        isScroll: true,
                        frozen: false,
                        pageSizeOptions: [10],
                        width: '100%',
                        height: '100%'
                        
                    },
                    onSelected: f_onSelectedProd
                }

            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 70,
                render: function(rowdata, rowindex, value) {
                	if(rowdata.prodNum !== undefined){
                		$("#choosed").val("choosed");
                	}
                    var h = "<a href='javascript:f_deleteGodownInvItem(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='' title='删除'/></a> ";

                    return h;
                }
            }],
            url: "${ctx}/owner/WChooseCustproducts.action",
            usePager: false,
            enabledSort: true,
            enabledEdit: true,
            clickToEdit: true,
            onBeforeSubmitEdit: f_onBeforeSubmitGodownInvItemEdit,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 472,
            allowHideColumn: false

        });

        $("#godownForm").ligerForm();
        f_initEditGodownInvData();
        
    });
    

    function f_getProdsParam() {
        var param = {
        		 "prodSearch.productName": "",
                 "prodSearch.showFlag": 1,
                 "prodSearch.isPublic": 1,
                 "prodSearch.chanpin": $("#chanpin").val()
        };
        return param;

    }
    
    
    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择客户!');
            return;
        }
        $("#contactPerson").val(data.contactPerson);
        $("#hidCustNum").val(data.custNum);
       
        $.reloadGridServerData(g,f_getProdParam());
        
        dialog.close();
    }
    function f_getProdParam(){
   	 var param = {
                /* "custNum": $("#hidCustNum").val() */
       };
       return param;
   }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }
    
    function f_addProdgps(){
    	
    		if($("#choosed").val() === ""){
        		alert("请选择产品");
        	}else{
                 j4tg.ajaxPost("${ctx}/owner/wAddGps.action", "json", false, {
                     "chanpin": $("#chanpinxq").val(),
                     "custNum": $("#contactPerson").val().trim()
                 },
                 function(data) {
                       location.href="${ctx}/owner/wListProdsgps.action";
                    /*  if (data.status == "S") {
                         $.ligerDialog.success('添加成功');
                       location.href="${ctx}/owner/wListProdsgps.action";
                     }else{
                    		 alert(data.message);
                     } */
                 },
                 function(data) {

        			});
        	}
    	}
    	 
   
    
    
    function f_onBeforeSubmitGodownInvItemEdit(e) {
        if (e.column.name == "cases") {
            if (e.value <= 0) return false;
        }
        return true;
    }

    function f_saveGodownInv() {

        var gdnum = $.trim($("#hidGdNum").val());
        var whNum = liger.get("warehouse").getValue();
        var whName = liger.get("warehouse").getText();
        var remark = $.trim($("#remark").val());
        var param = {
            "godownInvoice.gdNum": gdnum,
            "godownInvoice.whNum": whNum,
            "godownInvoice.whName": whName,
            "godownInvoice.remark": remark
        };
        //    	alert(JSON.stringify(manager.getData()));
        var gditems = manager.getData();

        if (gditems.length == 0) {
            $.ligerDialog.error('请添加入库产品');
            return;
        }

        for (var i = 0; i < gditems.length; i++) {

            var gditemProdNum = "godownInvoice.godownInvItemList[" + i + "].prodNum";
            var gditemProdName = "godownInvoice.godownInvItemList[" + i + "].prodName";
            var gditemUnit = "godownInvoice.godownInvItemList[" + i + "].unit";
            var gditemCases = "godownInvoice.godownInvItemList[" + i + "].cases";

            var gditemProdNumValue = $.trim(gditems[i].prodNum);
            var gditemProdNameValue = $.trim(gditems[i].prodName);
            var gditemUnitValue = $.trim(gditems[i].unit);
            var gditemProdCasesValue = $.trim(gditems[i].cases);
            if (!string.isInvalid(gditemProdNumValue) && !string.isInvalid(gditemProdCasesValue)) {
                param[gditemProdNum] = gditemProdNumValue;
                param[gditemProdName] = gditemProdNameValue;
                param[gditemUnit] = gditemUnitValue;
                param[gditemCases] = gditemProdCasesValue;
            }
        }

        j4tg.ajaxPost("${ctx}/owner/wSaveEditGodownInv.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListGodownInvs.action";
            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addGodownInvItem(godownInvItem) {
        //    	alert(JSON.stringify(manager.getData().length));
        if (godownInvItem) {
            manager.addEditRow({
                "prodNum": godownInvItem.prodNum,
                "prodName": godownInvItem.prodName,
                "unit": godownInvItem.unit,
                "cases": godownInvItem.cases
            });
        } else {
            manager.addEditRow();
        }
    }
    function f_deleteGodownInvItem(rowindex) {
       var array = $("#chanpin").val().split(",");
       array.splice($.inArray(manager.getRow(rowindex).prodNum, array),1);
      $("#chanpin").val(array);
       
       var array1 = $("#chanpinxq").val().split("---");
       var theval=manager.getRow(rowindex).prodNum+","+manager.getRow(rowindex).prodName;
       array1.splice($.inArray(theval, array1),1);
      $("#chanpinxq").val(array1.join("---"));
      
      
      manager.deleteRow(rowindex);
    }

    function f_onSelectedProd(e) {
    	
        if (!e.data || !e.data.length){
    	alert("请选择产品！");
        	return;
        }
    	
        var selected = e.data[0];
        manager.updateRow(manager.lastEditRow, {
            prodNum: selected.prodNum,
            prodName: selected.prodName,
            unit: selected.unit
        });
        
        
        $("#chanpin").val($("#chanpin").val()+selected.prodNum+",");
        $("#chanpinxq").val($("#chanpinxq").val()+selected.prodNum+","+selected.prodName+"---");
        $("#choosed").val("choosed");
    }
    
</script>
</html>