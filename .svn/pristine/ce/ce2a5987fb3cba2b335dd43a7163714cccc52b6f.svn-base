<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑回库单</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
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
             <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/editcom.webp"/></div>
               <div id="whatfont">编辑回库单</div>
                <div class="both"></div>
               </div>
            <ul>
                <li class="li-line">
                    <i class="i-spacing-first">
                        公司名称：
                    </i>
                    <i class="i-spacing-follow">
                        <label id="companyName">
                        </label>
                        <input name="hidDeliverInvNum" type="hidden" id="hidDeliverInvNum" />
                        <input name="hidCustNum" type="hidden" id="hidCustNum" />
                        <input name="hidOrderNum" type="hidden" id="hidOrderNum" value="<s:property value="
                        #parameters.orderNum[0] " />"/>
                        <input name="hidRetInvNum" type="hidden" id="hidRetInvNum" value="<s:property value="
                        #parameters.retInvNum[0] " />"/>
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        联系人：
                    </i>
                    <i class="i-spacing-follow">
                        <label id="contactPerson">
                        </label>
                    </i> </li><li class="li-line">
                    <i class="i-spacing-follow">
                        联系电话：
                    </i>
                    <i class="i-spacing-follow">
                        <label id="phoneNumber">
                        </label>
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        发货仓库：
                    </i>
                    <i class="i-spacing-follow">
                        <label id="whName">
                        </label>
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        回库原因：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="text" id="retReason" name="retReason" />
                        <input type="hidden" id="hidRetReason" name="hidRetReason" value="" />
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        回库产品：
                    </i>
                    <i class="i-spacing-follow">
                        <ul id="retinvitems">
                            <li id="retinvitems-hd" style="height:25px;width:450px;text-align:right">
                                <i class="i-spacing-follow">
                                    <a href="javascript:void(0);" onclick="f_addDeliverInvItems();">
                                        获取出库单产品
                                    </a>
                                </i>
                                <i class="i-spacing-follow">
                                    <a href="javascript:void(0);" onclick="f_addReturnedInvItem();">
                                        添加
                                    </a>
                                </i>
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
                <li class="li-line" style="text-align:center;">
                    <input type="submit" value="提交" id="saveReturnedInv" name="saveReturnedInv"
                    class="button-submit" />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:history.back(-1);" />
                </li>
            </ul>
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
        $.expandAccordionMenu("ordermenu");
        $("#retReason").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidRetReason'
        });
        $("#saveReturnedInv").click(f_saveReturnedInv);

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
                    valueField: 'prodName',
                    textField: 'prodName',
                    grid: {
                        columns: [{
                            display: '产品名称',
                            name: 'prodName',
                            isSort: false,
                            align: 'left',
                            width: 300
                        },{
                            display: '品类',
                            name: 'differName',
                            isSort: false,
                            align: 'center',
                            width: 100
                        },
                        {
                            display: '产品单位',
                            name: 'unit',
                            width: 80,
                            isSort: false,
                            align: 'left'
                        },
                        {
                            display: '产品数量',
                            name: 'cases',
                            width: 100,
                            minWidth: 60,
                            isSort: false,
                            align: 'left'
                        }],
                        url: "${ctx}/owner/wListSearchDeliverInvItemsData.action",
                        pagesizeParmName: "wpagingRequest.perPageUnitNum",
                        pageParmName: "wpagingRequest.currentPage",
                        pageSize: 10,
                        method: "post",
                        async: false,
                        enabledSort: false,
                        dataAction: "server",
                        isScroll: true,
                        frozen: false,
                        pageSizeOptions: [10],
                        width: '100%',
                        height: '100%'
                    },
                    onSelected: f_onSelectedDeliverInvItem,
                    parms: f_getDeliverInvItemParam
                }

            },{
                display: '品类',
                name: 'differName',
                isSort: false,
                align: 'center',
                width: 100
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '订单数量',
                name: 'availCases',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '回库数量',
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
                    var h = "<a href='javascript:f_deleteReturnedInvItem(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='APP个性化定制开发' title='删除'/></a> ";

                    return h;
                }
            }],
            usePager: false,
            enabledSort: true,
            enabledEdit: true,
            clickToEdit: true,
            onBeforeSubmitEdit: f_onBeforeSubmitReturnedInvItemEdit,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 550,
            allowHideColumn: false

        });

        f_initEditReturnedInvData();
    });

    function f_initEditReturnedInvData() {
        var retInvNum = $("#hidRetInvNum").val();
        var orderNum = $("#hidOrderNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditReturnedInvInitData.action", "json", false, {
            "retInvNum": retInvNum,
            "orderNum": orderNum
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                var deliverInv = data.respData.deliverInv;
                var customer = data.respData.customer;

                $("#companyName").html(customer.companyName);
                $("#contactPerson").html(customer.contactPerson);
                $("#phoneNumber").html(customer.phoneNum);
                $("#whName").html(deliverInv.whName);;
                $("#hidDeliverInvNum").val(deliverInv.deliverNum);
                $("#hidOrderNum").val(deliverInv.referOrderNum);
                $("#hidCustNum").val(deliverInv.custNum);
                liger.get("retReason").setData($.transformMap2ComboBoxData(data.respData.retReasons));
                if (data.respData.returnedInv) {
                    var returnedInv = data.respData.returnedInv;
                    $("#remark").val(returnedInv.remark);
                    $("#hidRetReason").val(returnedInv.retReason);
                    liger.get("retReason").updateStyle();
                    for (var key in returnedInv.returnedInvItemList) {
                        var returnedInvItem = returnedInv.returnedInvItemList[key];
                        for (var deliverKey in deliverInv.deliverInvItemList) {
                            var deliverInvItem = deliverInv.deliverInvItemList[deliverKey];
                            if (returnedInvItem.prodNum == deliverInvItem.prodNum) {
                                returnedInvItem.availCases = deliverInvItem.cases;
                                break;
                            }
                        }
                        f_addReturnedInvItem(returnedInvItem);
                    }

                }

            }
        },
        function(data) {

		});

    }

    function f_onBeforeSubmitReturnedInvItemEdit(e) {
        if (e.column.name == "cases") {
            if (e.value <= 0) return false;

            var returnedInvItem = manager.getRow(e.rowindex);
            if (e.value > returnedInvItem.availCases) {
                $.ligerDialog.error('回库产品数量不能大于出库产品数量');
                return false;
            }

        }
        return true;
    }

    function f_saveReturnedInv() {

        var retInvNum = $.trim($("#hidRetInvNum").val());
        var remark = $.trim($("#remark").val());
        var orderNum = $.trim($("#hidOrderNum").val());
        var custNum = $.trim($("#hidCustNum").val());
        var deliverNum = $.trim($("#hidDeliverInvNum").val());

        //    	alert(JSON.stringify(manager.getData()));
        var returnedInvItems = manager.getData();
        var retReason = liger.get("retReason").getValue();
        var errors = [];
        if (string.isInvalid(retReason)) {
        	errors.push('请选择回库原因');
        }

        if (returnedInvItems.length == 0) {
        	errors.push('请添加回库产品');
        }
        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }
        var param = {
            "returnedInv.retNum": retInvNum,
            "returnedInv.remark": remark,
            "returnedInv.retReason": retReason,
            "returnedInv.custNum": custNum,
            "returnedInv.referOrderNum": orderNum,
            "returnedInv.referDeliverNum": deliverNum
        }

        for (var i = 0; i < returnedInvItems.length; i++) {

            var returnedInvItemProdNum = "returnedInv.returnedInvItemList[" + i + "].prodNum";
            var returnedInvItemProdName = "returnedInv.returnedInvItemList[" + i + "].prodName";
            var returnedInvItemDifferName = "returnedInv.returnedInvItemList[" + i + "].differName";
            var returnedInvItemUnit = "returnedInv.returnedInvItemList[" + i + "].unit";
            var returnedInvItemCases = "returnedInv.returnedInvItemList[" + i + "].cases";

            var returnedInvItemProdNumValue = $.trim(returnedInvItems[i].prodNum);
            var returnedInvItemProdNameValue = $.trim(returnedInvItems[i].prodName);
            var returnedInvItemDifferNameValue = $.trim(returnedInvItems[i].differName);
            var returnedInvItemUnitValue = $.trim(returnedInvItems[i].unit);
            var returnedInvItemProdCasesValue = $.trim(returnedInvItems[i].cases);
            if (!string.isInvalid(returnedInvItemProdNumValue) && !string.isInvalid(returnedInvItemProdCasesValue)) {
                param[returnedInvItemProdNum] = returnedInvItemProdNumValue;
                param[returnedInvItemProdName] = returnedInvItemProdNameValue;
                param[returnedInvItemDifferName] = returnedInvItemDifferNameValue;
                param[returnedInvItemUnit] = returnedInvItemUnitValue;
                param[returnedInvItemCases] = returnedInvItemProdCasesValue;
            }
        }

        j4tg.ajaxPost("${ctx}/owner/wSaveEditReturnedInv.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListReturnedInvs.action";

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addReturnedInvItem(returnedInvItem) {

        //    	alert(JSON.stringify(manager.getData().length));
        if (returnedInvItem) {
            manager.addEditRow({
                "prodNum": returnedInvItem.prodNum,
                "prodName": returnedInvItem.prodName,
                "differName": returnedInvItem.differName,
                "unit": returnedInvItem.unit,
                "availCases": returnedInvItem.availCases,
                "cases": returnedInvItem.cases
            });
        } else {
            manager.addEditRow();
        }

    }
    function f_deleteReturnedInvItem(rowindex) {
        manager.deleteRow(rowindex);
    }

    function f_onSelectedDeliverInvItem(e) {
        if (!e.data || !e.data.length) return;
        var selected = e.data[0];
        var returnedInvItems = manager.getData();
        for (var i = 0; i < returnedInvItems.length; i++) {
            var prodNum = $.trim(returnedInvItems[i].prodNum);
            var differName = $.trim(returnedInvItems[i].differName);
            if (selected.prodNum == prodNum && selected.differName == differName &&i != manager.lastEditRow.__index) {
                $.ligerDialog.error('选择的产品已存在');
                manager.deleteRow(manager.lastEditRow.__index);
                return;
            }
        }
        manager.updateRow(manager.lastEditRow, {
            prodNum: selected.prodNum,
            prodName: selected.prodName,
            differName: selected.differName,
            availCases: selected.cases,
            unit: selected.unit
        });

        //        alert(JSON.stringify(manager.getData()));
    }

    function f_getDeliverInvItemParam() {
        var deliverInvNum = $.trim($("#hidDeliverInvNum").val());
        var param = {
            "deliverNum": deliverInvNum
        };
        return param;

    }

    function f_addDeliverInvItems() {
        var deliverInvNum = $.trim($("#hidDeliverInvNum").val());
        var param = {
            "deliverNum": deliverInvNum
        }
        j4tg.ajaxPost("${ctx}/owner/wListDeliverInvItemsData.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                var rows = manager.getData();
                for (var i = rows.length - 1; i >= 0; i--) {
                    manager.deleteRow(i);
                }
                for (var key in data.respData) {
                    var deliverInvItem = data.respData[key];
                    f_addDeliverInvItem(deliverInvItem);
                }
            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addDeliverInvItem(deliverInvItem) {

        //	    	alert(JSON.stringify(manager.getData().length));
        manager.addEditRow({
            "prodNum": deliverInvItem.prodNum,
            "prodName": deliverInvItem.prodName,
            "differName": deliverInvItem.differName,
            "unit": deliverInvItem.unit,
            "availCases": deliverInvItem.cases,
            "cases": 1
        });

    }
</script>
</html>