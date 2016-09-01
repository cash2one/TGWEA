<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>苹果版本信息列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="addadminbar" style="overflow:hidden;margin-top:1rem;margin-left:5rem;" >
                <a href="${ctx}/admin/wAddappleversion.action">
                    <img src="../images/adminBP/add_group.webp" title="添加苹果版本"/>
                </a>
            </div>
            <div style="text-align:center;padding-top:0.5rem;padding-bottom:0.5rem;">公司名：<input type="text" id="companyName" placeholder="淘冠科技" style="padding-left:0.3rem;"/>&nbsp;&nbsp;&nbsp;<input type="button" value="搜&nbsp;索" style="height:1.5rem;width:3rem;" onclick="f_searchCompany()"/></div>
            <input type="hidden" id="hidCompanyName"/>
            <br/>
            <div id="maingrid">
            </div>
        </div>
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
    </div>
    
    
</body>
<script  type="text/javascript">
var manager, g, pwddialog;
$(function() {
    $.expandAccordionMenu("upgrademenu");
    f_showAdminsData();
});

function f_showAdminsData() {

    g = manager = $("#maingrid").ligerGrid({
        columns: [{
            display: '应用名',
            name: 'appName',
            isSort: false,
            width: 170
        },
        {
            display: '包名',
            name: 'packageName',
            isSort: false,
            width: 200
        },
        {
            display: '文件名',
            name: 'fileName',
            isSort: false,
            width: 170
        },
        {
            display: '绑定的Id号',
            name: 'bundleId',
            isSort: false,
            width: 70
        },
        {
            display: '版本号',
            name: 'versionCode',
            isSort: false,
            width: 120
        },
        {
            display: '是否有效',
            name: 'activeFlag',
            isSort: false,
            align: 'center',
            width: 50
        },
        {
            display: '企业',
            name: 'companyName',
            isSort: false,
            align: 'center',
            width: 250
        },
        {
            display: '备注',
            name: 'remark',
            isSort: false,
            align: 'center',
            width: 270
        },{
            display: '创建时间',
            name: 'createDate',
            isSort: false,
            align: 'center',
            width: 100
        },{
            display: '创建人',
            name: 'createBy',
            isSort: false,
            align: 'center',
            width: 140
        },{
            display: '最后更新时间',
            name: 'updateDate',
            isSort: false,
            align: 'center',
            width: 100
        },{
            display: '更新人',
            name: 'updateBy',
            isSort: false,
            align: 'center',
            width: 140
        },
        {
            display: '操作',
            isSort: false,
            width: 100,
            render: function(rowdata, rowindex, value) {
                var h = "";
                if(rowdata.reserveFlag==1){
                	h += "<a href='javascript:f_resetAdminPwd(" + rowindex + ")'>修改密码</a> ";
                }else{
                    h += "<a href='${ctx}/admin/wEditAppleVs.action?versionId=" + rowdata.versionId + "'>修改</a> ";
                    h += "<a href='javascript:f_deleteAdmin(" + rowindex + ")'>删除</a> ";
                }
               
                return h;

            }
        }],
        url: "${ctx}/admin/wListApplevsData.action",
        pagesizeParmName: "wpagingRequest.perPageUnitNum",
        pageParmName: "wpagingRequest.currentPage",
        pageSize: 20,
        method: "post",
        async: false,
        enabledSort: false,
        enabledEdit: true,
        parms: f_getCompanyParam(),
        dataAction: "server",
        clickToEdit: false,
        isScroll: false,
        frozen: false,
        pageSizeOptions: [20, 40],
        showTitle: false,
        width: 1905,
        columnWidth: 120,
        allowHideColumn: false

    });

}

function f_deleteAdmin(rowid) {
    var androidVersion = manager.getRow(rowid);
    $.ligerDialog.confirm('确定要删除么?',
    function(yes) {
        if (yes) {
            j4tg.ajaxPost("${ctx}/admin/wDelApplevs.action", "json", false, {
                "versionId": androidVersion.versionId
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
function f_getCompanyParam() {
    var companyname = $("#hidCompanyName").val();

    var param = {
        "appleSearch.companyName": companyname
    };
    return param;

}
function f_searchCompany() {
    var companyname = $.trim($("#companyName").val());
    $("#hidCompanyName").val(companyname);
    $.reloadGridServerData(g, f_getCompanyParam());
}
</script>
</html>