<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>库存管理</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="width:50rem">
            <form name="ownerForm" method="post" id="ownerForm">
                <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_prodstocks.webp"/></div>
               <div id="whatfont">库存管理</div>
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
                            仓库：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="warehouse" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchStocks" type="button"  style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchProdStocks()"
                            />
                        </i>
                        <input type="hidden" id="hidProductName" name="hidProductName" value=""
                        />
                        <input type="hidden" id="hidWhNum" name="hidWhNum" value="" />
                    </li>
                </ul>
            </div>
            <br/>
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
    var manager, g;

    $(function() {
        $.expandAccordionMenu("stockmenu");
        $("#warehouse").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidWhNum',
            valueField: 'whNum',
            textField: 'whName'
        });
        f_initProdStocksSearchData();
        f_showProdStocksData();

    });

    function f_initProdStocksSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListProdStocksSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                data.respData.warehouses.push({
                    "whNum": "",
                    "whName": "全部"
                });
                liger.get("warehouse").setData(data.respData.warehouses);

                if (data.searchParams) {

                    $("#hidProductName").val(data.searchParams['prodStockSearch.prodName']);
                    $("#hidWhNum").val(data.searchParams['prodStockSearch.whNum']);
                    liger.get("warehouse").updateStyle();
                }

            }
        },
        function(data) {

		});

    }

    function f_showProdStocksData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '仓库名',
                name: 'whName',
                isSort: false,
                align: 'left'
            },
            {
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
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '库存数量',
                name: 'cases',
                align: 'left',
                width: 120
            }],
            url: "${ctx}/owner/wListProdStocksData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            parms: f_getProdStocksParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 750,
            columnWidth: 120,
            height: 'auto'
        });

    }

    function f_getProdStocksParam() {

        var prodname = $.trim($("#hidProductName").val());
        var whNum = $("#hidWhNum").val();
        var param = {
            "prodStockSearch.prodName": prodname,
            "prodStockSearch.whNum": whNum,
        };
        return param;

    }

    function f_searchProdStocks() {
        var productname = $.trim($("#productName").val());
        var whnum = liger.get("warehouse").getValue();

        $("#hidProductName").val(productname);
        $("#hidWhNum").val(whnum);
        $.reloadGridServerData(g, f_getProdStocksParam());
    }
</script>
</html>