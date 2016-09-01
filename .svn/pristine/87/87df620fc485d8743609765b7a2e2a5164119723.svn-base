<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>极光推送企业列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
        	<div id="beautiful" style="padding-left:2rem;width:65rem;">
                <div id="etitle" style="margin-bottom:12rem;">
               <div id="whereimg"><img src="../images/adminBP/list_jpushkeys.webp"/></div>
               <div id="whatfont" style="margin-left:15rem;">基础资料管理</div>
                <div class="both"></div>
               </div>
        	<div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            企业：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                            <input type="hidden" id="hidOwnerNum" />
                        	<input type="hidden" id="hidCompanyName" value="" />
                        	<input type="hidden" id="hidSearchOwnerNum" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchJpushKeys" type="button" value="搜索" onclick="f_searchJpushKeys()"
                            />
                        </i>
                        <i class="i-spacing-follow" style="width:37rem;text-align:right;">
                            <a href="${ctx}/admin/wEditJpushKeys.action"><img src="../images/adminBP/add_group.webp" title="添加推送企业"/></a>
                        </i>
                        </li>
                 </ul>
            </div>
           
            <div id="maingrid" style="margin-top:2rem;">
            </div>
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
    var manager, g;
    $(function() {
        $.expandAccordionMenu("pushmenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectOwner,
            valueFieldID: 'hidOwnerNum',
            width: 200
        });
        f_showJpushKeysData();

    })

    function f_showJpushKeysData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '公司名',
                name: 'owner.companyName',
                isSort: false,
                width: 200
            },
            {
                display: '应用包名',
                name: 'appPackage',
                isSort: false,
                width: 200
            },
            {
                display: 'AppKey',
                name: 'appKey',
                isSort: false,
                width: 200
            },
            {
                display: 'MasterSecret',
                name: 'masterSecret',
                isSort: false,
                width: 200
            },
            {
                display: '更新日期',
                name: 'updateDate',
                isSort: false,
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    h += "<a href='${ctx}/admin/wEditJpushKeys.action?ownerNum=" + rowdata.ownerNum + "'>修改</a> ";
                    h += "<a href='javascript:f_deleteJpushKeys(" + rowindex + ")'>删除</a> ";
                   
                    return h;

                }
            }],
            url: "${ctx}/admin/wListJpushKeysData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: false,
            parms: f_getJpushKeysParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1010,
            columnWidth: 120,
            allowHideColumn: false

        });

    }

    function f_selectOwner() {
        $.ligerDialog.open({
            title: '选择企业',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/admin/wListSearchOwners.action?ownerSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectOwnerOK
            },
            {
                text: '取消',
                onclick: f_selectOwnerCancel
            }]
        });
        return false;
    }
    function f_selectOwnerOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择企业!');
            return;
        }
        $("#hidCompanyName").val(data.companyName);
        $("#companyName").val(data.companyName);
        $("#hidOwnerNum").val(data.ownerNum);
        dialog.close();
    }
    function f_selectOwnerCancel(item, dialog) {
        dialog.close();
    }

    
    function f_deleteJpushKeys(rowid) {
        var jpushKeys = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/admin/wDelJpushKeys.action", "json", false, {
                    "ownerNum": jpushKeys.ownerNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getJpushKeysParam());
                    }
                },
                function(data) {

				});

            }
        });


    }


    function f_getJpushKeysParam() {
        var ownernum = $("#hidSearchOwnerNum").val();
        
        var param = {
            "jpushKeysSearch.ownerNum": ownernum
        }
        return param;

    }

    function f_searchJpushKeys() {
        var ownerNum = $.trim($("#hidOwnerNum").val());
        $("#hidSearchOwnerNum").val(ownerNum);
        $.reloadGridServerData(g, f_getJpushKeysParam());

    }
</script>
</html>