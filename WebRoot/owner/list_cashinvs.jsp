<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>收款单信息列表</title> 
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
                            <input id="searchCashInvs" style="width:66px;" type="button" value="搜&nbsp;&nbsp;索" onclick="f_searchCashInvs()"
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
    var manager, g, whdmanager;
    $(function() {
        $.expandAccordionMenu("cashmenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
//      f_initCashInvsSearchData();
        f_showCashInvsData();

    })

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

    function f_initCashInvsSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListCashInvsSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {}
        },
        function(data) {

		});

    }
    function f_showCashInvsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '收款单号',
                name: 'cashNum',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '公司名',
                name: 'customer.companyName',
                isSort: false,
                align: 'left',
                width: 250
            },
            {
                display: '订单号',
                name: 'referOrderNum',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '收款类型',
                name: 'cashTypeName',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '总金额',
                name: 'priceTotal',
                isSort: false,
                align: 'left',
                width: 150,
                type: 'float'
            },
            {
                display: '收款日期',
                name: 'updateDate',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                width: 150,
                render: function(rowdata, rowindex, value) {
                    var h = "";

                    if (rowdata.order.settleStatus == 0) {
                        h += "<a href='${ctx}/owner/wEditCashInv.action?cashNum=" + rowdata.cashNum + "'><img src='${ctx}/images/ico/modification.png' alt='APP个性化定制开发' title='修改'/></a> ";
                        h += "<a href='javascript:void(0);' onclick='javascript:f_deleteCashInv(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='APP个性化定制开发' title='删除'/></a> ";
                    }

                    return h;
                }
            }],
            url: "${ctx}/owner/wListCashInvsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledEdit: true,
            enabledSort: false,
            clickToEdit: false,
            parms: f_getCashInvsParam(),
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1100,
            columnWidth: 120,
            detail: {
                onShowDetail: f_showCashInvItemsData,
                height: 'auto'
            }
        });

    }

    function f_getCashInvsParam() {

        var custnum = $.trim($("#hidCustNum").val());
        var ordernum = $.trim($("#hidOrderNum").val());
        var param = {
            "cashInvSearch.custNum": custnum,
            "cashInvSearch.referOrderNum": ordernum
        };
        return param;

    }

    function f_deleteCashInv(rowid) {
        var cashInv = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelCashInv.action", "json", false, {
                    "cashNum": cashInv.cashNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getCashInvsParam());
                    }
                },
                function(data) {

				});
            }
        });

    }

    function f_getCashInvItemData(cashNum) {
        var jsonData = {
            Rows: []
        };
        var param = {
            "cashNum": cashNum
        };
        j4tg.ajaxPost("${ctx}/owner/wListCashInvItemsData.action", "json", false, param,
        function(data) {
            jsonData.Rows = data.respData;
        },
        function(data) {

		});
        return jsonData;

    }

    function f_showCashInvItemsData(row, detailPanel, callback) {
        var grid = document.createElement('div');
        $(detailPanel).append(grid);
        $(grid).css('margin', 10).ligerGrid({
            columns: [{
                display: '付款账户',
                name: 'acctName',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '付款金额',
                name: 'payPrice',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '明细备注',
                name: 'remark',
                isSort: false,
                align: 'left',
                width: 200
            }],
            isScroll: false,
            showToggleColBtn: false,
            width: 510,
            data: f_getCashInvItemData(row.cashNum),
            showTitle: false,
            columnWidth: 100,
            onAfterShowData: callback,
            frozen: false,
            usePager: false
        });
    }

    function f_searchCashInvs() {
        var ordernum = $.trim($("#orderNum").val());
        var companyname = liger.get("companyName").getValue();

        if (string.isInvalid(companyname)) {
            $("#hidCustNum").val("");
        }

        $("#hidCompanyName").val(companyname);
        $("#hidOrderNum").val(ordernum);
        $.reloadGridServerData(g, f_getCashInvsParam());
    }
</script>
</html>