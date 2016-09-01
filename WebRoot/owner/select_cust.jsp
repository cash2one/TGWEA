<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>客户选择列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
</head>  
<body style="padding:6px; overflow:hidden;">
    <div id="searchbar">
        公司名：
        <input id="companyName" type="text" />
        <input id="hidCompanyName" type="hidden" />
        联系人：
        <input id="contactPerson" type="text" />
        <input id="hidContactPerson" type="hidden" />
        <input id="searchCust" type="button" value="搜索" style="width:65px;height:28px;background-color:#e0e4e9;border-radius:5px;" onclick="f_searchCust()"
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
                display: '公司名',
                name: 'companyName',
                isSort: false,
                align: 'left',
                width: 250
            },
            {
                display: '联系人',
                name: 'contactPerson',
                isSort: false,
                align: 'left',
                width: 110
            },
            {
                display: '城市',
                name: 'regionName',
                isSort: false,
                align: 'left',
                width: 130,
                minWidth: 60
            },
            {
                display: '地址',
                name: 'address',
                isSort: false,
                align: 'left',
                width: 180
            }],
            url: "${ctx}/owner/wListSearchCustsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 5,
            method: "post",
            async: false,
            enabledSort: false,
            parms: f_getCustsParam(),
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [5],
            width: '100%',
            height: '100%'
        });

    });

    function f_getCustsParam() {
        var companyname = $("#hidCompanyName").val();
        var contactperson = $("#hidContactPerson").val();

        var param = {
            "custSearch.companyName": companyname,
            "custSearch.contactPerson": contactperson
        };
        return param;

    }
    function f_select() {
        return g.getSelectedRow();
    }

    function f_searchCust() {
        var companyname = $.trim($("#companyName").val());
        var contactperson = $.trim($("#contactPerson").val());
        $("#hidCompanyName").val(companyname);
        $("#hidContactPerson").val(contactperson);
        $.reloadGridServerData(g, f_getCustsParam());
    }
</script>
</html>