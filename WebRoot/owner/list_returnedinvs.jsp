<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>回库单信息列表</title> 
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
                            <input id="searchReturnedInvs" type="button"  style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchReturnedInvs()"
                            />
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
            </div>
            <div id="whdiv" style="overflow:hidden;display:none">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="warehouse" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input id="confirmPutinStock" type="button" value="确定" class="button-common"
                            />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="cancelConfirmPutinStock" type="button" value="取消  " class="button-common"
                            onclick="javascript:whdmanager.hide();" />
                        </i>
                    </li>
                </ul>
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
        $.expandAccordionMenu("sendstuff");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        $("#warehouse").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidWhNum',
            valueField: 'whNum',
            textField: 'whName'
        });
        f_initReturnedInvsSearchData();
        f_showReturnedInvsData();

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
        $.reloadGridServerData(g, f_getDeliverInvsParam());
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_initReturnedInvsSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListReturnedInvsSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                data.respData.warehouses.push({
                    "whNum": "",
                    "whName": "请选择仓库"
                });
                liger.get("warehouse").setData(data.respData.warehouses);
            }
        },
        function(data) {

		});

    }
    function f_showReturnedInvsData() {
        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '回库单号',
                name: 'retNum',
                isSort: false,
                align: 'left',
                width: 100
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
                width: 100
            },
            {
                display: '发货仓库',
                name: 'deliverInv.whName',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '发货单号',
                name: 'deliverInv.deliverNum',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '回库仓库',
                name: 'whName',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '出库日期',
                name: 'deliverInv.updateDate',
                isSort: false,
                align: 'center',
                width: 100
            },
            {
                display: '回库日期',
                name: 'updateDate',
                isSort: false,
                align: 'center',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 150,
                render: function(rowdata, rowindex, value) {
                    var h = "";

                    if (rowdata.retWhStatus == 0) {
                        h += "<img id='putinstock' src='${ctx}/images/ico/addwarehouse.png' alt='确认回库' title='确认回库'  onclick='f_selectWarehouse(" + rowindex + ")'/>";
                        h += "<a href='${ctx}/owner/wEditReturnedInv.action?retInvNum=" + rowdata.retNum + "'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                        h += "<a href='javascript:void(0);' onclick='javascript:f_deleteReturnedInv(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";
                    }

                    return h;
                }
            }],
            url: "${ctx}/owner/wListReturnedInvsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledEdit: true,
            enabledSort: false,
            clickToEdit: false,
            parms: f_getReturnedInvsParam(),
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1130,
            columnWidth: 120,
            detail: {
                onShowDetail: f_showReturnedInvItemsData,
                height: 'auto'
            }
        });
    }

    function f_getReturnedInvsParam() {

        var custnum = $.trim($("#hidCustNum").val());
        var ordernum = $.trim($("#hidOrderNum").val());
        var param = {
            "returnedInvSearch.custNum": custnum,
            "returnedInvSearch.referOrderNum": ordernum
        };
        return param;
    }

    function f_deleteReturnedInv(rowid) {
        var returnedInv = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelReturnedInv.action", "json", false, {
                    "retInvNum": returnedInv.retNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getReturnedInvsParam());
                    }
                },
                function(data) {

				});
            }
        });

    }
    function f_confirmReturnedInvPutinStock(rowid) {
        var whNum = liger.get("warehouse").getValue();
        if (string.isInvalid(whNum)) {
            $.ligerDialog.error('请选择回库仓库');
            return;
        }
        var returnedInv = manager.getRow(rowid);
        $.ligerDialog.confirm('确定执行产品回库么?',
        function(yes) {
            if (yes) {

                var param = {
                    "retInvNum": returnedInv.retNum,
                    "whNum": whNum
                };
                j4tg.ajaxPost("${ctx}/owner/wConfirmReturnedInvPutinStock.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('成功回库');
                        $.reloadGridServerData(g, f_getReturnedInvsParam());
                        whdmanager.hide();

                    } else {
                        $.ligerDialog.error(data.message);
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_getReturnedInvItemData(retInvNum) {
        var jsonData = {
            Rows: []
        };
        var param = {
            "retInvNum": retInvNum
        };
        j4tg.ajaxPost("${ctx}/owner/wListReturnedInvItemsData.action", "json", false, param,
        function(data) {
            jsonData.Rows = data.respData;
        },
        function(data) {

		});
        return jsonData;

    }

    function f_showReturnedInvItemsData(row, detailPanel, callback) {
        var grid = document.createElement('div');
        $(detailPanel).append(grid);
        $(grid).css('margin', 10).ligerGrid({
            columns: [{
                display: '产品名称',
                name: 'prodName',
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
                display: '回库数量',
                name: 'cases',
                isSort: false,
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
            isScroll: false,
            showToggleColBtn: false,
            width: 570,
            data: f_getReturnedInvItemData(row.retNum),
            showTitle: false,
            columnWidth: 100,
            onAfterShowData: callback,
            frozen: false,
            usePager: false
        });
    }

    function f_selectWarehouse(rowid) {
        $("#confirmPutinStock").bind("click",
        function() {
            f_confirmReturnedInvPutinStock(rowid);
        });
        if (whdmanager) {
            whdmanager.show();
        } else {
            whdmanager = $.ligerDialog.open({
                target: $("#whdiv"),
                title: '选择回库仓库'
            });
        }
    }

    function f_searchReturnedInvs() {
        var ordernum = $.trim($("#orderNum").val());
        var companyname = liger.get("companyName").getValue();

        if (string.isInvalid(companyname)) {
            $("#hidCustNum").val("");
        }

        $("#hidCompanyName").val(companyname);
        $("#hidOrderNum").val(ordernum);
        $.reloadGridServerData(g, f_getReturnedInvsParam());
    }
</script>
</html>