<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>微信支付信息列表</title> 
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
            <div align="left" style="margin-top:3rem;">
            公司名：<input type="text" id="companyName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="serachBtn" value="搜索"/>
            </div>
            <div style="width:1000px" align="right">
                <a href="${ctx}/admin/wGoAddWechatPayKeys.action"><img src="../images/adminBP/add_group.webp" title="添加新用户支付信息"/></a>
            </div>
            <br/>
           
            <div id="maingrid">
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

    var gcheckbox = new $.ligerGridCheckboxVO({
        checkFieldName: 'ownerNum'
    });
    
    $(function() {
        $.expandAccordionMenu("paymenu");
        f_initOwnersDataGrid();
        $("#serachBtn").click(function(){
        	f_refreshGridData();
        });
    });

    function f_initOwnersDataGrid() {
        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '公司名',
                name: 'companyName',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '支付密钥',
                name: 'payKey',
                width: 250,
                isSort: false,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '商户号',
                name: 'mchId',
                width: 150,
                isSort: false,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '备注',
                name: 'remark',
                width: 200,
                isSort: false,
                editor: {
                    type: 'text'
                }
            },
            {
            	display: '创建时间',
                name: 'createDate',
                width: 100,
                isSort: false,
            },
            {
                display: '创建人',
                name: 'createBy',
                width: 100,
                isSort: false,
            },
            {
            	display: '更新时间',
                name: 'updateDate',
                width: 100,
                isSort: false,
            },
            {
                display: '更新人',
                name: 'updateBy',
                width: 100,
                isSort: false,
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {

	            	var h = "";
	                if (!rowdata._editing) {
                        h += "<a href='javascript:f_edit(" + rowindex + ")'>修改</a>";
                        h += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:f_del(" + rowindex + ")'>删除</a> ";  
	                } else {
	                    h += "<a href='javascript:void(0);' onclick='javascript:f_save(" + rowindex + ")'>保存</a> ";
	                    h += "&nbsp;&nbsp;<a href='javascript:f_cancelEdit(" + rowindex + ")'>取消</a> ";
	                }
	                return h;

                }
        	}],
            url: "${ctx}/admin/wListWechatPayKeysData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 15,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: true, 
            parms: f_param(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [15, 30],
            showTitle: false,
            width: 1332,
            columnWidth: 120,
            allowHideColumn: false
        });

    }
    
    
    function f_del(rowid) {
    	var ownerNum = manager.getRow(rowid).ownerNum;
        var param = {
            "ownerNum": ownerNum
        };
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/admin/wDelWechatPayKeys.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_refreshGridData();
                    }
                },
                function(data) {

				});

            }
        });
    }  
    
    function f_param() {
        var param = {
            "wechatPayKeysSearch.companyName": $("#companyName").val().trim()
        };
        return param;

    }
    
    function f_refreshGridData() {
        $.reloadGridServerData(g, f_param());
    }
    
    function f_edit(rowid) {
   	 manager.beginEdit(rowid);
   }
    
    /* 取消编辑 */
    function f_cancelEdit(rowid) {
        manager.cancelEdit(rowid);
    }
    
    function f_save(rowid) {

    	 var payKey = $.getGridEditColumnData(g, rowid, 'payKey');
         if (string.isInvalid(payKey)) {
             $.ligerDialog.error('支付密钥');
             return;
         }
    	 var mchId = $.getGridEditColumnData(g, rowid, 'mchId');
         if (string.isInvalid(mchId)) {
             $.ligerDialog.error('商户号 不能为空');
             return;
         }
    	 var remark = $.getGridEditColumnData(g, rowid, 'remark');
         
         
        var param = {
            "wechatPayKeys.ownerNum": manager.getRow(rowid).ownerNum,
            "wechatPayKeys.payKey":payKey,
            "wechatPayKeys.remark":remark,
            "wechatPayKeys.mchId":mchId
        };

        j4tg.ajaxPost("${ctx}/admin/wUpdateWechatPayKeys.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                manager.endEdit(rowid);
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {
        	$.ligerDialog.error("出错了，请联系管理员");
		});

    }
    

</script>
</html>