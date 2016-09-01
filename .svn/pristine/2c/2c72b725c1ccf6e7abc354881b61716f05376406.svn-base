<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑调拨单</title> 
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
            <form name="stkAllocForm" method="post" id="stkAllocForm">
                <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/allot128.webp"/></div>
               <div id="whatfont">库存调拨</div>
                <div class="both"></div>
               </div>
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            发货仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="fromWh" name="fromWh" ltype="text" validate="{required:true}"
                            />
                            <input type="hidden" id="hidFromWhNum" name="hidFromWhNum" value="" />
                            <input name="hidStkAllocNum" type="hidden" id="hidStkAllocNum" value="<s:property value="
                            #parameters.stkAllocNum[0] " />"/>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            收货仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="toWh" name="toWh" ltype="text" validate="{required:true}"
                            />
                            <input type="hidden" id="hidToWhNum" name="hidToWhNum" value="" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            调拨产品：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="stkallocinvitems">
                                <li id="stkallocinvitems-hd" style="height:25px;width:450px;text-align:right">
                                    <a href="javascript:void(0);" onclick="f_addStkAllocInvItem();">
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
                    <li class="li-line">
                        <i class="i-spacing-first">
                            备注：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="50"></textarea>
                        </i>
                    </li>
                    <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                        <input type="submit" value="提交" id="saveStkAllocInv" name="saveStkAllocInv"
                        class="button-submit" />
                        <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
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
    <br />
    <div style="display:none;">
    </div>
</body>   
<script type="text/javascript">
    var manager, g;
    $(function() {
        $.expandAccordionMenu("stockmenu");
        $("#fromWh").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidFromWhNum',
            valueField: 'whNum',
            textField: 'whName'
        });
        $("#toWh").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidToWhNum',
            valueField: 'whNum',
            textField: 'whName'
        });
        $.metadata.setType("attr", "validate");
        var v = $("#stkAllocForm").validate({
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
                f_saveStkAllocInv();
                return false;
            }
        });

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 200,
                editor: {
                    type: 'popup',
                    valueField: 'product.prodName',
                    textField: 'product.prodName',
                    grid: {
                        columns: [{
                            display: '产品名称',
                            name: 'product.prodName',
                            isSort: false,
                            align: 'left',
                            width: 300
                        }, {
                            display: '品类',
                            name: 'differName',
                            isSort : false,
                            align: 'left',
                            width : 100
                        },
                        {
                            display: '产品单位',
                            name: 'product.unit',
                            width: 80,
                            isSort: false,
                            align: 'left'
                        },
                        {
                            display: '库存数量',
                            name: 'cases',
                            width: 100,
                            minWidth: 60,
                            isSort: false,
                            align: 'left'
                        }],
                        url: "${ctx}/owner/wListSearchProdStockData.action",
                        pagesizeParmName: "wpagingRequest.perPageUnitNum",
                        pageParmName: "wpagingRequest.currentPage",
                        pageSize: 10,
                        method: "post",
                        async: false,
                        enabledSort: false,
                        dataAction: "server",
                        parms: f_getProdStocksParam(),
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
                            name: 'prodStockSearch.prodName',
                            type: 'text',
                            label: '产品名称',
                            textField: 'prodStockSearch.prodName',
                            width: 200
                        }

                        ]
                    },
                    parms: f_getProdStocksParam,
                    onSelected: f_onSelectedProdStock
                }

            },{
                display: '品类',
                name: 'differName',
                isSort : false,
                align: 'left',
                width : 100
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '库存数量',
                name: 'availCases',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '调拨数量',
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
                width: 60,
                render: function(rowdata, rowindex, value) {
                    var h = "<a href='javascript:f_deleteStkAllocInvItem(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='APP个性化定制开发' title='删除'/></a> ";

                    return h;
                }
            }],
            usePager: false,
            enabledSort: true,
            enabledEdit: true,
            clickToEdit: true,
            onBeforeSubmitEdit: f_onBeforeSubmitStkAllocInvItemEdit,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 550,
            allowHideColumn: false

        });

        $("#stkAllocForm").ligerForm();
        f_initEditStkAllocInvData();

    });

    function f_initEditStkAllocInvData() {
        var stkAllocNum = $("#hidStkAllocNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditStkAllocInvInitData.action", "json", false, {
            "stkAllocNum": stkAllocNum
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("fromWh").setData(data.respData.warehouses);
                liger.get("toWh").setData(data.respData.warehouses);

                if (data.respData.stkAllocInv) {
                    var stkAllocInv = data.respData.stkAllocInv;
                    $("#hidFromWhNum").val(stkAllocInv.fromWhNum);
                    $("#hidToWhNum").val(stkAllocInv.toWhNum);
                    $("#remark").val(stkAllocInv.remark);
                    liger.get("fromWh").updateStyle();
                    liger.get("toWh").updateStyle();
                    for (var key in stkAllocInv.stkAllocInvItemList) {
                        var stkAllocInvItem = stkAllocInv.stkAllocInvItemList[key];
                        f_addStkAllocInvItem(stkAllocInvItem);
                    }

                }

            }
        },
        function(data) {

		});

    }

    function f_onBeforeSubmitStkAllocInvItemEdit(e) {
        if (e.column.name == "cases") {
            if (e.value <= 0) return false;

            var stkAllocInvItem = manager.getRow(e.rowindex);
            if (e.value > stkAllocInvItem.availCases) {
                $.ligerDialog.error('调拨产品数量不能大于存库产品数量');
                return false;
            }

        }
        return true;
    }

    function f_saveStkAllocInv() {

        var stkAllocNum = $.trim($("#hidStkAllocNum").val());
        var fromWhNum = liger.get("fromWh").getValue();
        var fromWhName = liger.get("fromWh").getText();
        var toWhNum = liger.get("toWh").getValue();
        var toWhName = liger.get("toWh").getText();
        var remark = $.trim($("#remark").val());
        var param = {
            "stkAllocInv.stkAllocNum": stkAllocNum,
            "stkAllocInv.fromWhNum": fromWhNum,
            "stkAllocInv.fromWhName": fromWhName,
            "stkAllocInv.toWhNum": toWhNum,
            "stkAllocInv.toWhName": toWhName,
            "godownInvoice.remark": remark
        }
        var errors = [];
        if (fromWhNum == toWhNum) {
        	errors.push('发货仓库与收货仓库不能相同');
        }
        //    	alert(JSON.stringify(manager.getData()));
        var stkAllocItems = manager.getData();

        if (stkAllocItems.length == 0) {
        	errors.push('请添加调拨产品');
        }
        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }

        for (var i = 0; i < stkAllocItems.length; i++) {

            var stkAllocItemProdNum = "stkAllocInv.stkAllocInvItemList[" + i + "].prodNum";
            var stkAllocItemProdName = "stkAllocInv.stkAllocInvItemList[" + i + "].prodName";
            var stkAllocItemDifferName = "stkAllocInv.stkAllocInvItemList[" + i + "].differName";
            var stkAllocItemUnit = "stkAllocInv.stkAllocInvItemList[" + i + "].unit";
            var stkAllocItemCases = "stkAllocInv.stkAllocInvItemList[" + i + "].cases";

            var stkAllocItemProdNumValue = $.trim(stkAllocItems[i].prodNum);
            var stkAllocItemProdNameValue = $.trim(stkAllocItems[i].prodName);
            var stkAllocItemDifferNameValue = $.trim(stkAllocItems[i].differName);
            var stkAllocItemUnitValue = $.trim(stkAllocItems[i].unit);
            var stkAllocItemProdCasesValue = $.trim(stkAllocItems[i].cases);
            if (!string.isInvalid(stkAllocItemProdNumValue) && !string.isInvalid(stkAllocItemProdCasesValue)) {
                param[stkAllocItemProdNum] = stkAllocItemProdNumValue;
                param[stkAllocItemProdName] = stkAllocItemProdNameValue;
                param[stkAllocItemDifferName] = stkAllocItemDifferNameValue;
                param[stkAllocItemUnit] = stkAllocItemUnitValue;
                param[stkAllocItemCases] = stkAllocItemProdCasesValue;
            }
        }
        
        j4tg.ajaxPost("${ctx}/owner/wSaveEditStkAllocInv.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListStkAllocInvs.action";

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addStkAllocInvItem(stkAllocInvItem) {

        //    	alert(JSON.stringify(manager.getData().length));
        if (stkAllocInvItem) {
            liger.get("fromWh").setDisabled();
            manager.addEditRow({
                "prodNum": stkAllocInvItem.prodNum,
                "prodName": stkAllocInvItem.prodName,
                "differName": stkAllocInvItem.differName,
                "unit": stkAllocInvItem.unit,
                "availCases": stkAllocInvItem.availCases,
                "cases": stkAllocInvItem.cases
            });
        } else {
            var fromWhNum = liger.get("fromWh").getValue();
            if (string.isInvalid(fromWhNum)) {
                $.ligerDialog.alert('请选择发货仓库');
                return;
            }
            liger.get("fromWh").setDisabled();
            if (manager.getData().length > 10) {
                $.ligerDialog.error('最多只能添加10个调拨产品');
                return;
            }
            manager.addEditRow();
        }
    }
    function f_deleteStkAllocInvItem(rowindex) {
        manager.deleteRow(rowindex);
        if (manager.getData().length == 0) {
            liger.get("fromWh").setEnabled();
        }
    }

    function f_onSelectedProdStock(e) {
        if (!e.data || !e.data.length) return;
        var selected = e.data[0];
        var stkAllocItems = manager.getData();
        for (var i = 0; i < stkAllocItems.length; i++) {
            var prodNum = $.trim(stkAllocItems[i].prodNum);
            var differName = $.trim(stkAllocItems[i].differName);
            if (selected.prodNum == prodNum &&selected.differName == differName && i != manager.lastEditRow.__index) {
                $.ligerDialog.error('选择的产品已存在');
                manager.deleteRow(manager.lastEditRow.__index);
                return;
            }
        }
        manager.updateRow(manager.lastEditRow, {
            prodNum: selected.prodNum,
            prodName: selected.product.prodName,
            differName: selected.differName,
            availCases: selected.cases,
            unit: selected.product.unit
        });

        //        alert(JSON.stringify(manager.getData()));
    }

    function f_getProdStocksParam() {
        var fromWhNum = liger.get("fromWh").getValue();
        var param = {
            "prodStockSearch.prodName": '',
            "prodStockSearch.whNum": fromWhNum,
        };
        return param;

    }
</script>
</html>