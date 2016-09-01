<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>结算详情</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
 
<script type="text/javascript">
    $(function() {

        $("#settlemain").ligerLayout({
            leftWidth: '50%',
            rightWidth: '50%',
            topHeight: 300,
            bottomHeight: 300,
            height: 1000,
            allowLeftCollapse: false,
            allowRightCollapse: false
        });
    });
</script>
<style type="text/css">
    body{ padding:10px; margin:0;} #settlemain{ width:100%; margin:40px; height:400px;
    margin:0; padding:0;} #accordion1 { height:270px;}
</style>
</head>
<body>
    <div id="settlemain">
        <div position="left" title="送货单详情">
            <div id="deliverheader" style="overflow:hidden">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            送货单号：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="deliver_deliverNum">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            发货仓库:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="deliver_whName">
                            </span>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            物流单号：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="deliver_logisticsNum">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            创建日期:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="deliver_createDate">
                            </span>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-follow">
                            送货地址:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="deliver_deliverAddress">
                            </span>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="delivergrid">
            </div>
        </div>
        <div position="right" title="回库单详情">
            <div id="returnedheader" style="overflow:hidden">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            回库单号：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="returned_retNum">
                            </span>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            回库仓库:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="returned_whName">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            创建日期:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="returned_createDate">
                            </span>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            回库原因:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="returned_retReasonName">
                            </span>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="returnedgrid">
            </div>
        </div>
        <div position="top" title="订单详情">
            <input name="hidOrderNum" type="hidden" id="hidOrderNum" value="<s:property value="
            #parameters.orderNum[0] " />"/>
            <div id="orderheader" style="overflow:hidden">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:250px;" id="order_companyName">
                            </span>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            订单编号：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="order_orderNum">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            客户价总金额:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:80px;" id="order_custPriceTotal">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            成交总金额:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:80px;color:red" id="order_realPriceTotal">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            创建日期:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="order_createDate">
                            </span>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="ordergrid">
            </div>
        </div>
        <div position="bottom" title="收款单详情">
            <div id="orderheader" style="overflow:hidden">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            收款单号：
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="cash_cashNum">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            收款类型:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:80px;" id="cash_cashTypeName">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            收款金额:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:80px;color:red" id="cash_priceTotal">
                            </span>
                        </i>
                        <i class="i-spacing-follow">
                            创建日期:
                        </i>
                        <i class="i-spacing-follow">
                            <span class="spanField" style="width:100px;" id="cash_createDate">
                            </span>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="cashgrid">
            </div>
        </div>
    </div>
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var ordergrid, delivergrid, returnedgrid, cashgrid;
    $(function() {

        $("div[class=l-layout-top]").prepend('<div class="l-layout-header">订单详情</div>');

        ordergrid = $("#ordergrid").ligerGrid({
            columns: [{
                display: '产品编号-名称',
                isSort: false,
                align: 'left',
                width: 360,
                render: function(rowdata, rowindex, value) {
                    var h = rowdata.prodNum + "-" + rowdata.prodName;
                    return h;

                }
            }, {
                display: '品类',
                name: 'differName',
                isSort : false,
                align: 'left',
                width : 100
            },
            
            {
                display: '数量',
                name: 'cases',
                align: 'left',
                width: 100,
                type: 'int'
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 80,
                type: 'int'
            },
            {
                display: '标准价',
                name: 'stdProdPrice',
                align: 'left',
                width: 100,
                type: 'float'
            },
            {
                display: '客户价',
                name: 'custProdPrice',
                align: 'left',
                width: 100,
                type: 'float'
            },
            {
                display: '客户总价',
                name: 'custProdPriceTotal',
                align: 'left',
                width: 100,
                type: 'float',
                totalSummary: {
                    type: 'sum'
                }
            }],

            enabledEdit: false,
            enabledSort: true,
            clickToEdit: false,
            frozen: true,
            isScroll: false,
            showToggleColBtn: false,
            usePager: false,
            allowHideColumn: false,
            showTitle: false,
            width: 1300,
            columnWidth: 120
        });

        delivergrid = $("#delivergrid").ligerGrid({
            columns: [{
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 260
            }, {
                display: '品类',
                name: 'differName',
                isSort : false,
                align: 'left',
                width : 100
            },
            {
                display: '送货数量',
                name: 'cases',
                align: 'left',
                width: 80
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 80
            }],

            enabledEdit: false,
            enabledSort: true,
            clickToEdit: false,
            frozen: true,
            isScroll: false,
            showToggleColBtn: false,
            usePager: false,
            allowHideColumn: false,
            showTitle: false,
            width: 550,
            columnWidth: 120
        });

        returnedgrid = $("#returnedgrid").ligerGrid({
            columns: [{
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 260
            }, {
                display: '品类',
                name: 'differName',
                isSort : false,
                align: 'left',
                width : 100
            },
            {
                display: '送货数量',
                name: 'cases',
                align: 'left',
                width: 80
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 80
            }],

            enabledEdit: false,
            enabledSort: true,
            clickToEdit: false,
            frozen: true,
            isScroll: false,
            showToggleColBtn: false,
            usePager: false,
            allowHideColumn: false,
            showTitle: false,
            width: 550,
            columnWidth: 120
        });

        cashgrid = $("#cashgrid").ligerGrid({
            columns: [{
                display: '付款账户',
                name: 'acctName',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '付款金额',
                name: 'payPrice',
                align: 'left',
                width: 150,
                type: 'float',
                totalSummary: {
                    type: 'sum'
                }
            },
            {
                display: '明细备注',
                name: 'remark',
                isSort: false,
                align: 'left',
                width: 400
            }],

            enabledEdit: false,
            enabledSort: true,
            clickToEdit: false,
            frozen: true,
            isScroll: false,
            showToggleColBtn: false,
            usePager: false,
            allowHideColumn: false,
            showTitle: false,
            width: 1300,
            columnWidth: 120
        });

        f_initSettleInvData();

    });

    function f_initSettleInvData() {
        var orderNum = $("#hidOrderNum").val();
        j4tg.ajaxPost("${ctx}/owner/wgetSettleInvData.action", "json", false, {
            "orderNum": orderNum
        },
        function(data) {
            if (data.status == "S") {

                var customer = data.respData.customer;
                var order = data.respData.order;
                var deliverInv = data.respData.deliverInv;
                var returnedInv = data.respData.returnedInv;
                var cashInv = data.respData.cashInv;

                $("#order_companyName").html(customer.companyName);
                $("#order_orderNum").html(order.orderNum);
                $("#order_custPriceTotal").html("￥" + order.custPriceTotal);
                $("#order_realPriceTotal").html("￥" + order.realPriceTotal);
                $("#order_createDate").html(order.createDate);
                var orderItems = {};
                orderItems.Rows = order.orderItemList;
                ordergrid.loadData(orderItems);

                $("#deliver_deliverNum").html(deliverInv.deliverNum);
                $("#deliver_whName").html(deliverInv.whName);
                $("#deliver_logisticsNum").html(deliverInv.logisticsNum);
                $("#deliver_createDate").html(deliverInv.createDate);
                $("#deliver_deliverAddress").html(deliverInv.deliverAddress);
                
                var deliverItems = {};
                deliverItems.Rows = deliverInv.deliverInvItemList;
                delivergrid.loadData(deliverItems);
                
                $("#cash_cashNum").html(cashInv.cashNum);
                $("#cash_priceTotal").html("￥" + cashInv.priceTotal);
                $("#cash_cashTypeName").html(cashInv.cashTypeName);
                $("#cash_createDate").html(cashInv.createDate);
                var cashItems = {};
                cashItems.Rows = cashInv.cashInvItemList;
                cashgrid.loadData(cashItems);
                
                
               if(returnedInv != null){
            	     $("#returned_retNum").html(returnedInv.retNum);
                   $("#returned_whName").html(returnedInv.whName);
                   $("#returned_createDate").html(returnedInv.createDate);
                   $("#returned_retReasonName").html(returnedInv.retReasonName);
                   
                   var returnedItems = {};
                   returnedItems.Rows = returnedInv.returnedInvItemList;
                   returnedgrid.loadData(returnedItems);
               }
             
               
            }
        },
        function(data) {

		});

    }

    function f_getOrderNum() {
        return $("#hidOrderNum").val();
    }
</script>
</html>