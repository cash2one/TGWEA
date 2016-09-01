<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>原始订单信息列表</title> 
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
                            <a href="/WEA/owner/wAddWechatOrder.action">客户：</a>
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                            <input type="hidden" id="hidCustNum" />
                            <input type="hidden" id="hidCompanyName" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchOrigOrder" type="button" value="搜&nbsp;&nbsp;索" onclick="f_searchOrigOrder()" style="width:60px;"/>
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
        $.expandAccordionMenu("ordermenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        f_showOrigOrdersData();

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
        $("#hidCompanyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_searchOrigOrder() {
        var companyname = $.trim($("#companyName").val());
        if (string.isInvalid(companyname)) {
            $("#hidCustNum").val("");
        }
        $.reloadGridServerData(g, f_getOrigOrdersParam());
    }
    

    function f_showOrigOrdersData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '订单编号',
                name: 'origOrderNum',
                isSort: false,
                align: 'center',
                frozen: true
            },
            {
                display: '客户名',
                name: 'customer.custName',
                isSort: false,
                align: 'center',
                width: 120
            },
            {
                display: '公司名',
                name: 'customer.companyName',
                isSort: false,
                align: 'center',
                width: 350
            },
            {
                display: '联系人',
                name: 'customer.contactPerson',
                isSort: false,
                align: 'center',
                width: 100
            },
            {
                display: '联系电话',
                name: 'customer.phoneNum',
                isSort: false,
                align: 'center',
                width: 150
            },
            {
                display: '订单总价',
                name: 'priceTotal',
                isSort: false,
                align: 'center',
                width: 120
            },
            {
                display: '提交日期',
                name: 'createDate',
                isSort: false,
                align: 'center',
                width: 150
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.haveReferOrder == 0) {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_genOrder(\"" + rowdata.origOrderNum + "\")'><img src='${ctx}/images/ico/createOrder.png' title='创建订单'/></a>";
                        h += "<a href='javascript:void(0);' onclick='javascript:f_delOrigOrder(\"" + rowdata.origOrderNum + "\")'><img src='${ctx}/images/ico/delete.png' title='删除'/></a>";
                    }

                    return h;
                }
            }],
            url: "${ctx}/owner/wListOrigOrdersData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            parms: f_getOrigOrdersParam(),
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1140,
            columnWidth: 120,
            detail: {
                onShowDetail: f_showOrigOrderItemsData,
                height: 'auto'
            }
        });

    }

    function f_getOrigOrdersParam() {

        var custnum = $.trim($("#hidCustNum").val());
        var companyname = $.trim($("#hidCompanyName").val());
        var param = {
            "origOrderSearch.custNum": custnum,
            "origOrderSearch.companyName": companyname
        };
        return param;

    }

    function f_delOrigOrder(origOrderNum) {
    
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelOrigOrder.action", "json", false, {
                    "origOrderNum": origOrderNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getOrigOrdersParam());
                    }
                },
                function(data) {

				});
            }
        });

    }

    function f_genOrder(origOrderNum) {
        $.ligerDialog.confirm('确定要生成订单么?',
        function(yes) {
            if (yes) {
                j4tg.ajaxPost("${ctx}/owner/wGenOrder.action", "json", false, {
                    "origOrderNum": origOrderNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('订单生成成功');
                        $.reloadGridServerData(g, f_getOrigOrdersParam());
                    }
                },
                function(data) {

				});

            }
        });

    }

    function f_getOrigOrderItemData(origOrderNum) {
        var jsonData = {
            Rows: []
        };
        var param = {
            "origOrderNum": origOrderNum
        };
        j4tg.ajaxPost("${ctx}/owner/wListOrigOrderItemsData.action", "json", false, param,
        function(data) {
            jsonData.Rows = data.respData;
        },
        function(data) {

		});
        return jsonData;

    }

    function f_showOrigOrderItemsData(row, detailPanel, callback) {
        var grid = document.createElement('div');
        $(detailPanel).append(grid);
        $(grid).css('margin', 10).ligerGrid({
            columns: [{
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'center',
                width: 300,
                type: 'text'
            },
            {
                display: '品类',
                name: 'differName',
                isSort: false,
                align: 'center',
                width: 100,
                type: 'text'
            },
            {
                display: '订购数量',
                name: 'cases',
                isSort: false,
                align: 'center',
                width: 120,
                type: 'float'
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'center',
                width: 80
            },
            {
                display: '订购价格',
                name: 'prodPrice',
                isSort: false,
                align: 'center',
                width: 120
            },
            {
                display: '总价格',
                name: 'prodPriceTotal',
                isSort: false,
                align: 'center',
                width: 120
            }],
            isScroll: false,
            showToggleColBtn: false,
            width: 760,
            data: f_getOrigOrderItemData(row.origOrderNum),
            showTitle: false,
            columnWidth: 100,
            onAfterShowData: callback,
            frozen: false,
            usePager: false
        });
    }
</script>
</html>