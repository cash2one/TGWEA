<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>仓库列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
        <div id="beautiful" style="padding-left:2rem;width: 55rem;">
            <form name="ownerForm" method="post" id="ownerForm">
                <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_warehouses.webp"/></div>
               <div id="whatfont" style="margin-left:12rem;">仓库管理</div>
                <div class="both"></div>
               </div>
       <br/>
       <br/>
		<div class=" bcolor borderradius adminico" style="margin-left:45rem;"><a name="addwarehouse" href="javascript:void(0);" onclick="javascript:f_addWarehouse();" id="addwarehouse"><img src='${ctx}/images/ico/addwarehouse.png' alt='新仓库' title='新仓库'/></a></div>
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
        f_showWarehousesData();

    });

    function f_showWarehousesData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '仓库编号',
                name: 'whNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '仓库名',
                name: 'whName',
                isSort: false,
                align: 'left',
                width: 150,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '仓库地址',
                name: 'address',
                isSort: false,
                align: 'left',
                width: 250,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '备注',
                name: 'remark',
                isSort: false,
                align: 'left',
                width: 200,
                editor: {
                    type: 'textarea',
                    height: 40,
                    width: 200
                }
            },
            {
                display: '创建日期',
                name: 'createDate',
                isSort: false,
                align: 'center',
                width: 150
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (!rowdata._editing) {
                        h += "<a href='javascript:f_beginUpdateWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                        h += "<a href='javascript:f_deleteWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";
                    } else {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_updateWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/save.png' alt='保存' title='保存'/></a> ";
                        h += "<a href='javascript:f_cancelUpdateWarehouse(" + rowindex + ")'><img src='${ctx}/images/ico/cancel.png' alt='取消' title='取消'/></a> ";
                    }
                    return h;

                }
            }],
            url: "${ctx}/owner/wListWarehousesData.action",
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
            width: 860,
            columnWidth: 120,
            allowHideColumn: false

        });

    }
    function f_addWarehouse() {
        manager.addEditRow();
    }

    function f_beginUpdateWarehouse(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateWarehouse(rowid) {
        var warehouse = manager.getRow(rowid);
        manager.cancelEdit(rowid);
        if (string.isInvalid(warehouse.whNum)) {
            manager.deleteRow(rowid);
        }
    }
    function f_updateWarehouse(rowid) {

        var whname = $.getGridEditColumnData(g, rowid, 'whName');
        var remark = $.getGridEditColumnData(g, rowid, 'remark');
        if (string.isInvalid(whname)) {
            $.ligerDialog.error('请填写仓库名');
            return;
        }
        if (!string.isInvalid(remark)&&remark.length>50) {
            $.ligerDialog.error('备注长度不能超过50');
            return;
        }
        
        manager.endEdit(rowid);
        var warehouse = manager.getRow(rowid);
        if (string.isInvalid(warehouse.whNum)) {
            warehouse.whNum = "";
        }
        var param = {
            "wareHouse.whNum": warehouse.whNum,
            "wareHouse.whName": warehouse.whName,
            "wareHouse.address": warehouse.address,
            "wareHouse.remark": warehouse.remark
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveWarehouse.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $.reloadGridServerData(g, {});

            }
        },
        function(data) {

		});

    }

    function f_deleteWarehouse(rowid) {
        var warehouse = manager.getRow(rowid);
        if (string.isInvalid(warehouse.whNum)) {
            manager.deleteRow(rowid);
        } else {
            $.ligerDialog.confirm('确定要删除么?',
            function(yes) {
                if (yes) {

                    j4tg.ajaxPost("${ctx}/owner/wDelWarehouse.action", "json", false, {
                        "whNum": warehouse.whNum
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