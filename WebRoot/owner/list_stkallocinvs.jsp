<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>调拨单管理</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="padding-left:3rem;width:55rem;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_stkallocinvs.webp"/></div>
               <div id="whatfont" style="margin-left:12rem;">调拨管理</div>
                <div class="both"></div>
               </div>
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="productName" type="text" id="productName" />
                        </i>
                        <i class="i-spacing-follow">
                            发货仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="fromWh" />
                        </i>
                        <i class="i-spacing-follow">
                            收货仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="toWh" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchStkAllocInvs" type="button" style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchStkAllocInvs()"
                            />
                        </i>
                        <input type="hidden" id="hidProductName" name="hidProductName" value=""
                        />
                        <input type="hidden" id="hidFromWhNum" name="hidFromWhNum" value="" />
                        <input type="hidden" id="hidToWhNum" name="hidToWhNum" value="" />
                    </li>
                </ul>
            </div>
            <br/>
			<div class=" bcolor borderradius adminico" style="margin-left: 45rem;"><a name="addStkAllocInv" href="${ctx}/owner/wEditStkAllocInv.action" onclick="javascript:f_addWarehouse();" id="addStkAllocInv"><img src='${ctx}/images/ico/allot.png' alt='库存调拨' title='库存调拨'/></a></div>
            <div id="maingrid">
            </div>
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
    var manager, g

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
        f_initStkAllocInvsSearchData();
        f_showStkAllocInvsData();

    });

    function f_initStkAllocInvsSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListStkAllocInvsSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                data.respData.warehouses.push({
                    "whNum": "",
                    "whName": "全部"
                });
                liger.get("fromWh").setData(data.respData.warehouses);
                liger.get("toWh").setData(data.respData.warehouses);

                if (data.searchParams) {

                    $("#hidProductName").val(data.searchParams['stkAllocInvSearch.prodName']);
                    $("#hidFromWhNum").val(data.searchParams['stkAllocInvSearch.fromWhNum']);
                    $("#hidToWhNum").val(data.searchParams['stkAllocInvSearch.toWhNum']);
                    liger.get("fromWh").updateStyle();
                    liger.get("toWh").updateStyle();
                }

            }
        },
        function(data) {

		});

    }

    function f_showStkAllocInvsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '调拨单号',
                name: 'stkAllocNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '发货仓库',
                name: 'fromWhName',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '收货仓库',
                name: 'toWhName',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '产品数量',
                name: 'prodCount',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '调拨单状态',
                name: 'stkAllocStatusName',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '备注',
                name: 'remark',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 150,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.stkAllocStatus == 0) {
                        h += "<i class='i-spacing-follow'><input id='putinstock' type='button' value='确认调拨' onclick='f_confirmStkAllocInvPutinStock(" + rowindex + ")'/></i>";
                        h += "<a href='${ctx}/owner/wEditStkAllocInv.action?stkAllocNum=" + rowdata.stkAllocNum + "'><img src='${ctx}/images/ico/modification.png'/></a> ";
                        h += "<a href='javascript:void(0);' onclick='javascript:f_deleteStkAllocInv(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png'/></a> ";
                    }

                    return h;

                }
            }],
            url: "${ctx}/owner/wListStkAllocInvsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            parms: f_getStkAllocInvsParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 810,
            columnWidth: 120,
            height: 'auto',
            detail: {
                onShowDetail: f_showStkAllocInvItemsData,
                height: 'auto'
            }
        });

    }

    function f_getStkAllocInvsParam() {

        var prodname = $.trim($("#hidProductName").val());
        var fromWhNum = $("#hidFromWhNum").val();
        var toWhNum = $("#hidToWhNum").val();
        var param = {
            "stkAllocInvSearch.prodName": prodname,
            "stkAllocInvSearch.fromWhNum": fromWhNum,
            "stkAllocInvSearch.toWhNum": toWhNum
        };
        return param;

    }

    function f_searchStkAllocInvs() {
        var productname = $.trim($("#productName").val());
        var fromwhnum = liger.get("fromWh").getValue();
        var towhnum = liger.get("toWh").getValue();

        $("#hidProductName").val(productname);
        $("#hidFromWhNum").val(fromwhnum);
        $("#hidToWhNum").val(towhnum);
        $.reloadGridServerData(g, f_getStkAllocInvsParam());
    }

    function f_showStkAllocInvItemsData(row, detailPanel, callback) {
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
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '数量',
                name: 'cases',
                isSort: false,
                align: 'left',
                width: 120
            }],
            isScroll: false,
            showToggleColBtn: false,
            width: 620,
            data: f_getStkAllocInvItemsData(row.stkAllocNum),
            showTitle: false,
            columnWidth: 100,
            onAfterShowData: callback,
            frozen: false,
            usePager: false
        });
    }

    function f_getStkAllocInvItemsData(stkAllocNum) {
        var jsonData = {
            Rows: []
        };
        var param = {
            "stkAllocNum": stkAllocNum
        }
        j4tg.ajaxPost("${ctx}/owner/wListStkAllocInvItemsData.action", "json", false, param,
        function(data) {
            jsonData.Rows = data.respData;
        },
        function(data) {

		});
        return jsonData;

    }

    function f_deleteStkAllocInv(rowid) {

        var stkallocinv = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelStkAllocInv.action", "json", false, {
                    "stkAllocNum": stkallocinv.stkAllocNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getStkAllocInvsParam());
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_confirmStkAllocInvPutinStock(rowid) {

        var stkallocinv = manager.getRow(rowid);
        $.ligerDialog.confirm('确定执行产品入库么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wConfirmStkAllocInvPutinStock.action", "json", false, {
                    "stkAllocNum": stkallocinv.stkAllocNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('调拨成功');
                        $.reloadGridServerData(g, f_getStkAllocInvsParam());
                    }
                },
                function(data) {

				});

            }
        });
    }
</script>
</html>