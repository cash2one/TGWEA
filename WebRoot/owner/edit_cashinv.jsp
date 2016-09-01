<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑收款单</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        
        <div id="maincontent" position="center" title=" ">
             <div id="beautiful">
             <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/editcom.webp"/></div>
               <div id="whatfont">编辑收款单</div>
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
                        <input name="hidCustNum" type="hidden" id="hidCustNum" />
                        <input name="hidOrderNum" type="hidden" id="hidOrderNum" value="<s:property value="
                        #parameters.orderNum[0] " />"/>
                        <input name="hidCashNum" type="hidden" id="hidCashNum" value="<s:property value="
                        #parameters.cashNum[0] " />"/>
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        联系人：
                    </i>
                    <i class="i-spacing-follow">
                        <label id="contactPerson">
                        </label>
                    </i> </li>
                    <li class="li-line">
                    <i class="i-spacing-follow">
                        联系电话：
                        </label>
                    </i>
                    <i class="i-spacing-follow">
                        <label id="phoneNumber">
                        </label>
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        收款类型：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="text" id="cashType" name="cashType" />
                        <input type="hidden" id="hidCashType" name="hidCashType" value="" />
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        收款明细：
                    </i>
                    <i class="i-spacing-follow">
                        <ul id="retinvitems">
                            <li id="retinvitems-hd" style="height:25px;width:620px;text-align:right">
                            <label style="display: block;float:left;">订单金额：<span id="realPriceTotal"></span> 元</label>
  							<label style="display: block;float:right;"><a href="javascript:void(0);" onclick="f_addCashInvItem();">添加</a></label>
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
                        <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="100"></textarea>
                    </i>
                </li>
                <li class="li-line" style="text-align:center;">
                    <input type="submit" value="提交" id="saveCashInv" name="saveCashInv" class="button-submit"
                    />
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
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    $.ligerDefaults.Grid.editors['numberbox'] = {
        create: function(container, editParm) {
            var column = editParm.column;
            var precision = column.editor.precision;
            var input = $("<input type='text' style='text-align:right' class='l-text' />");
            input.bind('keypress',
            function(e) {
                var keyCode = window.event ? e.keyCode: e.which;
                return keyCode >= 48 && keyCode <= 57 || keyCode == 46 || keyCode == 8;
            });
            input.bind('blur',
            function() {
                //放置编辑框出现NaN
                //var value = input.val();
                //input.val(parseFloat(value).toFixed(precision));
            });
            container.append(input);
            return input;
        },
        getValue: function(input, editParm) {
            if (string.isInvalid(input.val())) {
                return "";
            } else {
                return parseFloat(input.val());
            }

        },
        setValue: function(input, value, editParm) {
            var column = editParm.column;
            var precision = column.editor.precision;
            if (string.isInvalid(value)) {
                input.val("");
            } else {

                input.val(value.toFixed(precision));
            }

        },
        resize: function(input, width, height, editParm) {
            input.width(width).height(height);
        }
    };

    //扩展 numberbox 类型的格式化函数
    $.ligerDefaults.Grid.formatters['numberbox'] = function(value, column) {
        var precision = column.editor.precision;
        if (string.isInvalid(value)) {
            return "";
        } else {
            return value.toFixed(precision);
        }
    };

    var manager, g;
    $(function() {
        $.expandAccordionMenu("cashmenu");
        $("#cashType").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidCashType'
        });
        $("#saveCashInv").click(f_saveCashInv);

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '付款账户',
                name: 'acctName',
                isSort: false,
                align: 'left',
                width: 200,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '付款金额',
                name: 'payPrice',
                isSort: false,
                align: 'left',
                width: 100,
                type: 'numberbox',
                editor: {
                    type: 'numberbox',
                    precision: 2
                }
            },
            {
                display: '明细备注',
                name: 'remark',
                isSort: false,
                align: 'left',
                width: 200,
                editor: {
                    type: 'textarea',
                    height: 40,
                    width: 200
                }
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "<a href='javascript:f_deleteCashInvItem(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";

                    return h;
                }
            }],
            usePager: false,
            enabledSort: false,
            enabledEdit: true,
            clickToEdit: true,
            onBeforeSubmitEdit: f_onBeforeSubmitCashInvItemEdit,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 620,
            columnWidth: 120,
            allowHideColumn: false

        });

        f_initEditCashInvData();
    });

    function f_initEditCashInvData() {
        var cashNum = $("#hidCashNum").val();
        var orderNum = $("#hidOrderNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditCashInvInitData.action", "json", false, {
            "cashNum": cashNum,
            "orderNum": orderNum
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                var order = data.respData.order;
                var customer = data.respData.customer;

                $("#companyName").html(customer.companyName);
                $("#contactPerson").html(customer.contactPerson);
                $("#phoneNumber").html(customer.phoneNum);
                $("#hidCustNum").val(order.custNum);
                $("#hidOrderNum").val(order.orderNum);
                $("#realPriceTotal").text(order.realPriceTotal);
                liger.get("cashType").setData($.transformMap2ComboBoxData(data.respData.cashTypes));
                if (data.respData.cashInv) {
                    var cashInv = data.respData.cashInv;
                    $("#remark").val(cashInv.remark);
                    $("#hidCashType").val(cashInv.cashType);
                    liger.get("cashType").updateStyle();
                    for (var key in cashInv.cashInvItemList) {
                        var cashInvItem = cashInv.cashInvItemList[key];
                        f_addCashInvItem(cashInvItem);
                    }

                }

            }
        },
        function(data) {

		});

    }

    function f_onBeforeSubmitCashInvItemEdit(e) {
        if (e.column.name == "payPrice") {
            if (string.isInvalid(e.value)) {
                return false;
            }
            if (e.value <= 0) {
                $.ligerDialog.error('收款金额必须大于0');
                return false;
            }

        }
        return true;
    }

    function f_saveCashInv() {

        var cashNum = $.trim($("#hidCashNum").val());
        var remark = $.trim($("#remark").val());
        var orderNum = $.trim($("#hidOrderNum").val());
        var custNum = $.trim($("#hidCustNum").val());

        //    	alert(JSON.stringify(manager.getData()));
        var cashInvItems = manager.getData();
        var cashType = liger.get("cashType").getValue();
        var errors = [];
        if (string.isInvalid(cashType)) {
        	errors.push('请选择收款类型');
        }

        if (cashInvItems.length == 0) {
        	errors.push('请添加收款明细');
        }
        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }
        var param = {
            "cashInv.cashNum": cashNum,
            "cashInv.remark": remark,
            "cashInv.cashType": cashType,
            "cashInv.custNum": custNum,
            "cashInv.referOrderNum": orderNum
        };

        for (var i = 0; i < cashInvItems.length; i++) {

            var cashInvItemAcctName = "cashInv.cashInvItemList[" + i + "].acctName";
            var cashInvItemPayPrice = "cashInv.cashInvItemList[" + i + "].payPrice";
            var cashInvItemRemark = "cashInv.cashInvItemList[" + i + "].remark";

            var cashInvItemAcctNameValue = $.trim(cashInvItems[i].acctName);
            var cashInvItemPayPriceValue = $.trim(cashInvItems[i].payPrice);
            var cashInvItemRemarkValue = $.trim(cashInvItems[i].remark);

            if (!string.isInvalid(cashInvItemAcctNameValue) && !string.isInvalid(cashInvItemPayPriceValue)) {
                param[cashInvItemAcctName] = cashInvItemAcctNameValue;
                param[cashInvItemPayPrice] = cashInvItemPayPriceValue;
                param[cashInvItemRemark] = cashInvItemRemarkValue;
            }
        }

        j4tg.ajaxPost("${ctx}/owner/wSaveEditCashInv.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListCashInvs.action"; 

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addCashInvItem(cashInvItem) {

        //    	alert(JSON.stringify(manager.getData().length));
        if (cashInvItem) {
            manager.addEditRow({
                "acctName": cashInvItem.acctName,
                "payPrice": cashInvItem.payPrice,
                "remark": cashInvItem.remark
            });
        } else {
            manager.addEditRow();
        }

    }
    function f_deleteCashInvItem(rowindex) {
        manager.deleteRow(rowindex);
    }
</script>
</html>