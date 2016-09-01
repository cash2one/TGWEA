<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>留言信息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="padding-left:2rem;width:60rem;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_guestbooks.webp"/></div>
               <div id="whatfont" style="margin-left:15rem;">留言管理</div>
                <div class="both"></div>
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
        $.expandAccordionMenu("othermenu");
        f_showGuestBooksData();

    });

    function f_showGuestBooksData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '留言编号',
                name: 'messageId',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '留言信息',
                name: 'content',
                width: 350,
                isSort: false,
                align: 'left'
            },
            {
                display: '账户',
                name: 'customer.custNum',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '公司名',
                name: 'customer.companyName',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '提交日期',
                name: 'createDate',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 60,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    h += "<a href='javascript:void(0);' onclick='javascript:f_delGuestBook(\"" + rowdata.messageId + "\")'><img src='${ctx}/images/ico/delete.png' alt='' title='删除'/></a> ";
                    return h;
                }
            }],
            url: "${ctx}/owner/wListGuestBooksData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            parms: {},
            dataAction: "server",
            isScroll: true,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 920,
            columnWidth: 120
        });

    }

    function f_delGuestBook(messageId) {

        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelGuestBook.action", "json", false, {
                    "messageId": messageId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, {});
                    }
                },
                function(data) {

				});
            }
        });

    }
</script>
</html>