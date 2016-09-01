<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>产品选择列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
</head>  
<body style="padding:6px; overflow:hidden;">
    <div id="searchbar">
        产品名称：
        <input id="prodName" type="text" />
        <input id="hidProdName" type="hidden" />
        <input id="searchProd" type="button" value="搜索" style="width:65px;height:28px;background-color:#e0e4e9;border-radius:5px;" onclick="f_searchProd()"
        />
    </div>
    <br/>
    <div id="maingrid" style="margin:0; padding:0">
    </div>
    <div style="display:none;">
        <!-- g data total ttt -->
    </div>
</body>
<script type="text/javascript">
    var g;
    $(function() {
        g = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品名',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '状态',
                name: 'showName',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '单位',
                name: 'unit',
                width: 80,
                isSort: false,
                align: 'left'
            },
            {
                display: '价格',
                name: 'stdPrice',
                width: 100,
                minWidth: 60,
                isSort: false,
                align: 'left'
            }],
            url: "${ctx}/owner/wListSearchCompProdsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 5,
            method: "post",
            async: false,
            parms: f_getProdsParam,
            enabledSort: false,
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [5],
            width: '100%',
            height: '100%'
        });

    });

    function f_getProdsParam() {
        var prodname = $("#hidProdName").val();

        var param = {
            "prodSearch.productName": prodname,
            "prodSearch.showFlag": 1
        };
        return param;

    }
    function f_select() {
        return g.getSelectedRow();
    }

    function f_searchProd() {
        var prodname = $.trim($("#prodName").val());
        $("#hidProdName").val(prodname);
        $.reloadGridServerData(g, f_getProdsParam());
    }
</script>
</html>