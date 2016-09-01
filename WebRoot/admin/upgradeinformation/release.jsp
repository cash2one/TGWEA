<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>APP发布管理</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div style="height:1rem;margin-top:1rem;" >
               
            </div>
            <div id="maingrid">
            </div>
        </div>
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
    </div>
    
    <input type="text" id="versionId"/>
    <input type="text" id="ownerNum"/>
    <input type="text" id="packagename"/>
</body>
<script  type="text/javascript">
var manager, g, pwddialog;
$(function() {
    $.expandAccordionMenu("upgrademenu");
    f_showAdminsData();
});


function f_showAdminsData() {

    g = manager = $("#maingrid").ligerGrid({
        columns: [
        {
            display: '企业名称',
            name: 'companyName',
            isSort: false,
            width: 300
        },
        {
            display: '苹果最新版本',
            name: 'versionCode',
            isSort: false,
            width: 150
        },
        {
            display: '苹果最后更新时间',
            name: 'updateDate',
            isSort: false,
            width: 150
        },
        {
            display: '安卓最新版本',
            name: 'versionNum',
            isSort: false,
            align: 'center',
            width: 150
        },
        {
            display: '安卓最后更新时间',
            name: 'aupdateDate',
            isSort: false,
            align: 'center',
            width: 150
        },
        {
            display: '操作',
            isSort: false,
            width: 206,
            render: function(rowdata, rowindex, value) {
                var h = "";
                    h += "<a href='${ctx}/admin/wReleaseDownload.action?ownerNum="+manager.getRow(rowindex).ownerNum+"'>查看下载页 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                   h += "<a href='javascript:shengcheng(" + rowindex + ")'>生成下载页 </a>";
                   return h;

            }
        }],
        url: "${ctx}/admin/wListAppsData.action",
        method: "post",
        usePager: false,
        async: false,
        enabledSort: true,
        enabledEdit: true,
        dataAction: "server",
        clickToEdit: false,
        isScroll: false,
        frozen: false,
        showTitle: false,
        width: 1112,
        allowHideColumn: false

    });

}

function shengcheng(rowid) {
            j4tg.ajaxPost("${ctx}/admin/wReleaseStatic.action", "json", false, {
                "versionId":  manager.getRow(rowid).versionId,
                "ownerNum": manager.getRow(rowid).ownerNum,
                "bundleId":manager.getRow(rowid).bundleId,
                "iosId":manager.getRow(rowid).iosId
                
            },
            function(data) {
                if (data.status == "S") {
                    $.ligerDialog.success('生成页面成功');
                    $.reloadGridServerData(g, {});
                }
            },
            function(data) {

			});
}

</script>
</html>