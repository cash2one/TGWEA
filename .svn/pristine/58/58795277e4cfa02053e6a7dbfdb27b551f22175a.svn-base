<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>管理员列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
	 <div id="beautiful">
                <div id="etitle">
               <div id="whereimg"><img src="../images/beautiful-page/list_admins.webp"/></div>
               <div id="whatfont">查看管理员</div>
                <div class="both"></div>
               </div>
	 <div class=" bcolor borderradius adminico"><a name="addwarehouse" href="javascript:void(0);" onclick="javascript:f_addOwneradmin();"><img src='${ctx}/images/ico/addcust.png' alt='添加管理员' title='添加管理员'/></a></div>
            <div id="maingrid" style="margin-left:6rem;">
            </div>
        </div>
        </div>
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
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
        $.expandAccordionMenu("adm");
        f_showWarehousesData();

    });

    function f_showWarehousesData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [
            {
                display: '用户名',
                name: 'adminName',
                isSort: false,
                align: 'left',
                width: 150,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '创建日期',
                name: 'createDate',
                isSort: false,
                align: 'center',
                width: 150,
                editor: {
                    type: 'text',
                    value:'默认密码：6个8',
                    readonly:'readonly'
                }
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (!rowdata._editing) {
                        h += "<a href='javascript:f_deleteOwneradmin(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";
                    } else {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_updateWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/save.png' alt='保存' title='保存'/></a> ";
                        h += "<a href='javascript:f_cancelUpdateWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/cancel.png' alt='取消' title='取消'/></a> ";
                    }
                    return h;

                }
            }],
            url: "${ctx}/owner/wListAdminData.action",
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
            width: 404,
            columnWidth: 120,
            allowHideColumn: false

        });

    }
    function f_addOwneradmin() {
        manager.addEditRow();
    }

    function f_cancelUpdateWarehouse(rowid) {
        var ownerAdmin = manager.getRow(rowid);
        manager.cancelEdit(rowid);
        if (string.isInvalid(ownerAdmin.adminName)) {
            manager.deleteRow(rowid);
        }
    }
    function f_updateWarehouse(rowid) {

        var adminName = $.getGridEditColumnData(g, rowid, 'adminName');
        if (string.isInvalid(adminName)) {
            $.ligerDialog.error('请输入管理员用户名');
            return;
        }
        
        manager.endEdit(rowid);
        var ownerAdmin = manager.getRow(rowid);
        if (string.isInvalid(ownerAdmin.adminName)) {
        	ownerAdmin.adminName = "";
        }
        var param = {
            "ownerAdmin.adminName": ownerAdmin.adminName
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveOwneradmin.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $.reloadGridServerData(g, {});
            }
            if (data.status == "F") {
            	  manager.deleteRow(rowid);
                $.ligerDialog.error(data.message);
            }
        },
        function(data) {

		});

    }

    function f_deleteOwneradmin(rowid) {
        var ownerAdmin = manager.getRow(rowid);
        if (string.isInvalid(ownerAdmin.adminName)) {
            manager.deleteRow(rowid);
        } else {
            $.ligerDialog.confirm('确定要删除么?',
            function(yes) {
                if (yes) {
                    j4tg.ajaxPost("${ctx}/owner/wDelOwneradmin.action", "json", false, {
                        "adminId": ownerAdmin.adminId
                    },
                    function(data) {
                        if (data.status == "S") {
                            $.ligerDialog.success('删除成功');
                            $.reloadGridServerData(g, {});
                        }
                        if (data.status == "F") {
                            $.ligerDialog.error(data.message);
                        }
                    },
                    function(data) {

					});

                }
            });
        }

    }
</script>
</html>