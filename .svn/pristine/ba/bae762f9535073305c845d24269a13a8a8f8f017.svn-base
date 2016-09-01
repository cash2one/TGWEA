<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>企业回收站</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerTree.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
         <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
           <div style="margin-top:2rem;margin-left:5rem;font-size:2rem;">企业回收站 </div>
             <br/>
           
            <br/>
            <br/>
            <div id="maingrid" style="margin-left:2rem;">
            </div>
        </div>
       
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var g, manager;

    $(function() {
        $.expandAccordionMenu("enterprise");
        f_initOwnersDataGrid();
    });

    function f_initOwnersDataGrid() {
        g = manager = $("#maingrid").ligerGrid({
            columns: [
            {
                display: '公司名称',
                isSort: false,
                align: 'left',
                width: 320,
                name: 'companyName'
            },
            {
                display: '操作',
                isSort: false,
                width: 120,
                render: function(rowdata, rowindex, value) {

	            	return "<a href='javascript:f_Recovery(" + rowindex + ")'>恢复</a>";

                }
        	}],
            url: "${ctx}/admin/wListOwnersData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 15,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: true, 
            parms: f_getOwnersParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [15, 30],
            showTitle: false,
            width: 450,
            columnWidth: 120
        });

    }
    
    function f_getOwnersParam() {

        var param = {
            "ownerSearch.delFlag": 1
        };
        return param;

    }
    
    function f_Recovery(rowid) {

        var param = {
            "owner.ownerNum": manager.getRow(rowid).ownerNum
        };
        $.ligerDialog.confirm('确定要恢复吗?',
        function(yes) {
            if (yes) {
            	
                j4tg.ajaxPost("${ctx}/admin/wRecycle.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('企业已恢复');
                        f_refreshOwnerGridData();
                    }
                },
                function(data) {

				});

            }
        });
    }  
    
    function f_refreshOwnerGridData() {
        $.reloadGridServerData(g, f_getOwnersParam());
    }

</script>
</html>