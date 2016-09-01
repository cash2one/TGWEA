<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>结算订单信息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
         <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            客户：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                        </i>
                        <i class="i-spacing-follow">
                            订单编号：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="orderNum" />
                            <input type="hidden" id="hidCustNum" />
                            <input type="hidden" id="hidCompanyName" value="" />
                            <input type="hidden" id="hidOrderNum" />
                        </i>
                    </li>
                    <li>
                        <i class="i-spacing-follow">
                            <input id="searchSettleInvs" style="width:66px;" type="button" value="搜&nbsp;&nbsp;索" onclick="f_searchSettleInvs()"
                            />
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
            </div>
        </div>
       
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
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
        $.expandAccordionMenu("cashmenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        f_showSettleInvsData();

    });

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
            alert('请选择客户!');
            return;
        }

        $("#companyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_showSettleInvsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '公司名',
                name: 'customer.companyName',
                isSort: false,
                align: 'left',
                width: 250
            },
            {
                display: '订单号',
                name: 'orderNum',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '标准总价',
                name: 'stdPriceTotal',
                isSort: false,
                align: 'left',
                width: 100,
                type: 'float'
            },
            {
                display: '客户总价',
                name: 'custPriceTotal',
                isSort: false,
                align: 'left',
                width: 100,
                type: 'float'
            },
            {
                display: '实际收款',
                name: 'realPriceTotal',
                isSort: false,
                align: 'left',
                width: 100,
                type: 'float'
            },
            {
                display: '有无回库',
                isSort: false,
                align: 'left',
                width: 80,
                render: function(rowdata, rowindex, value) {
                    return rowdata.retInvCount == 0 ? "无": "有";

                }
            },
            {
                display: '结算日期',
                name: 'updateDate',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "<a href='javascript:void(0);' onclick='javascript:f_viewSettleInv(" + rowindex + ")'><img src='${ctx}/images/ico/particulars.png' alt='' title='详情'/></a> ";

                    return h;
                }
            }],
            url: "${ctx}/owner/wListSettleInvsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledEdit: false,
            enabledSort: false,
            clickToEdit: false,
            parms: f_getSettleInvsParam(),
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1000,
            columnWidth: 120
        });

    }

    function f_getSettleInvsParam() {

        var custnum = $.trim($("#hidCustNum").val());
        var ordernum = $.trim($("#hidOrderNum").val());
        var param = {
            "settleInvSearch.custNum": custnum,
            "settleInvSearch.referOrderNum": ordernum
        };
        return param;

    }

    function f_searchSettleInvs() {
        var ordernum = $.trim($("#orderNum").val());
        var companyname = liger.get("companyName").getValue();

        if (string.isInvalid(companyname)) {
            $("#hidCustNum").val("");
        }

        $("#hidCompanyName").val(companyname);
        $("#hidOrderNum").val(ordernum);
        $.reloadGridServerData(g, f_getSettleInvsParam());
    }

    function f_viewSettleInv(rowid) {
        var order = manager.getRow(rowid);
        var viewSettleUrl = "${ctx}/owner/wviewSettleInv.action?orderNum=" + order.orderNum;

        $.ligerDialog.open({
            height: 700,
            url: viewSettleUrl,
            width: 1200,
            showMax: false,
            showToggle: true,
            isResize: false,
            slide: false,
            title: "结算明细",
            buttons: [{
                text: '关闭',
                onclick: function(item, dialog) {
                    dialog.close();
                }
            }]
        });
    }
</script>
</html>