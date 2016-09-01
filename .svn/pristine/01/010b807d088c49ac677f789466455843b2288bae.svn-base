<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>新建订单</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerPopupEdit.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
                <div id="beautiful">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/beautiful-page/createOrder128.webp"/></div>
               <div id="whatfont">创建订单</div>
                <div class="both"></div>
               </div>
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            客户：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                            <input type="hidden" id="hidCustNum" />
                        	<input type="hidden" id="hidCompanyName" value="" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            产品：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="order">
                                <li id="order-hd" style="height:25px;width:430px;text-align:right">
                                    <a href="javascript:void(0);" onclick="f_addOrderItem();">
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
                    <li class="li-line" style="margin-top:30px">
                        <i class="i-spacing-first">
                            送货地址：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea cols="100" rows="2" name="deliverAddr" id="deliverAddr" style="width:400px" maxlength="50"></textarea>
                        </i>
                    </li>
<!--  
                    <li class="li-line">
                        <i class="i-spacing-first">
                            备注：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="50"></textarea>
                        </i>
                    </li>
-->
                    <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                        <input type="submit" value="提交" id="saveOrder" name="saveOrder" onclick="javascript:f_saveOrder();"
                        class="button-submit" />
                        <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                        onclick="javascript:history.back(-1);" />
                    </li>
                </ul></div>
        </div>
        <div position="top">
        	<%@ include file="/owner/top.jsp" %>
        </div>
        <div position="bottom">
         <%@ include file="/owner/bottom.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var manager, g;
        var prodDifferNames = new Object();

    $(function() {
        $.expandAccordionMenu("ordermenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
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
                width: 200,
                editor: {
                    type: 'popup',
                    valueField: 'prodName',
                    textField: 'prodName',
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
                        parms: {
                            "prodSearch.productName": "",
                            "prodSearch.showFlag": 1
                        },
                        isScroll: true,
                        frozen: false,
                        pageSizeOptions: [10],
                        width: '100%',
                        height: '100%'
                    },
                    condition: {
                        inputWidth: 170,
                        labelWidth: 90,
                        space: 40,

                        fields: [{
                            name: 'prodSearch.productName',
                            type: 'text',
                            label: '产品名称',
                            textField: 'prodSearch.productName',
                            width: 200
                        }

                        ]
                    },
                    onSelected: f_onSelectedProd
                }

            },
            {
                display: '品类',
                name: 'differName',
                isSort: false,
                align: 'left',
                width: 100,
                editor: { type: 'select', ext:f_getProdDffers, valueField: 'differName' }
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '数量',
                name: 'cases',
                isSort: false,
                align: 'left',
                width: 60,
                editor: {
                    type: 'int',
                    min: 1
                }
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "<a href='javascript:f_deleteOrderItem(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";

                    return h;
                }
            }],
            usePager: false,
            enabledSort: true,
            enabledEdit: true,
            clickToEdit: true,
            onBeforeSubmitEdit: f_onBeforeSubmitOrderItemEdit,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 530,
            allowHideColumn: false

        });

    });

    function f_onBeforeSubmitOrderItemEdit(e) {
        if (e.column.name == "cases") {
            if (e.value <= 0) return false;
        }
        if (e.column.name == "differName") {
             if (string.isInvalid(e.value))
            return false;
        }
        return true;
    }

    function f_saveOrder() {

        var custnum = $.trim($("#hidCustNum").val());
        var deliverAddr = $.trim($("#deliverAddr").val());
        var errors = [];
        if(string.isInvalid(custnum)) {
        	errors.push('请选择订单客户');
        }
        
        var param = {
            "order.custNum": custnum,
            "order.deliverAddr": deliverAddr
        };
        //    	alert(JSON.stringify(manager.getData()));
        var orderitems = manager.getData();

        
		var haveItems  = false;
        for (var i = 0; i < orderitems.length; i++) {

            var orderitemProdNum = "order.orderItemList[" + i + "].prodNum";
            var orderitemProdName = "order.orderItemList[" + i + "].prodName";
            var orderitemUnit = "order.orderItemList[" + i + "].unit";
            var orderitemCases = "order.orderItemList[" + i + "].cases";
             var orderitemDifferName = "order.orderItemList[" + i + "].differName";

            var orderitemProdNumValue = $.trim(orderitems[i].prodNum);
            var orderitemProdNameValue = $.trim(orderitems[i].prodName);
            var orderitemUnitValue = $.trim(orderitems[i].unit);
            var orderitemDifferNameValue = $.trim(orderitems[i].differName);
            var orderitemProdCasesValue = $.trim(orderitems[i].cases);
            if (!string.isInvalid(orderitemProdNumValue) && !string.isInvalid(orderitemProdCasesValue)) {
                param[orderitemProdNum] = orderitemProdNumValue;
                param[orderitemProdName] = orderitemProdNameValue;
                param[orderitemUnit] = orderitemUnitValue;
                param[orderitemCases] = orderitemProdCasesValue;
                param[orderitemDifferName] = orderitemDifferNameValue;
                haveItems = true;
            }
        }

        if (!haveItems) {
        	errors.push('请添加有效订单产品');
        }
        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }
        j4tg.ajaxPost("${ctx}/owner/wSaveAddOrder.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListOrders.action";

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addOrderItem() {
    	manager.addEditRow();

    }
    function f_deleteOrderItem(rowindex) {
        manager.deleteRow(rowindex);
    }

    function f_onSelectedProd(e) {
        if (!e.data || !e.data.length) return;

        var selected = e.data[0];

var prodDiffers = f_getProdDifferNames(selected.prodNum);


        var editorData = [];
        var defaultDifferName = "";
        for (var index in prodDiffers) {  
            
            var prodDiffer = prodDiffers[index];
            var jsonObject = new Object();
            jsonObject["differName"]= prodDiffer["differName"];
            jsonObject["text"]= prodDiffer["differName"];
            editorData.push(jsonObject);
            if(index == 0){
                defaultDifferName = prodDiffer["differName"];
            }
        }
        prodDifferNames[selected.prodNum] = editorData;


        manager.updateRow(manager.lastEditRow, {
            prodNum: selected.prodNum,
            prodName: selected.prodName,
            differName: defaultDifferName,
            cases: 1,
            unit: selected.unit
        });

        //        alert(JSON.stringify(manager.getData()));
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

    function f_getProdDffers(e){
           
            var prodDffers = [];
            if(e.record.prodNum){
                prodDffers = prodDifferNames[e.record.prodNum];
            }

            return { data : prodDffers };
        }

    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择客户!');
            return;
        }
        $("#hidCompanyName").val(data.companyName);
        $("#companyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }
     function f_getProdDifferNames(prodNum) {
        var prodDiffers = [];
        j4tg.ajaxPost("${ctx}/owner/wGetProdDifferData.action", "json", false, {
            "prodNum": prodNum
        },
        function(data) {
            if (data.status == "S") {

                prodDiffers =data.respData;

            }
        },
        function(data) {

        });
        //alert(JSON.stringify(prodDiffers));
        return prodDiffers;

    }

</script>
</html>