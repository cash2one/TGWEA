<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑入库单</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerTree.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerPopupEdit.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerCheckBox.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerButton.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <a href="javascript:void(0);" onclick="manager.addEditRow();">
        添加
    </a>
    <div id="maingrid">
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var manager, g;
    $(function() {
        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 200,
                editor: {
                    type: 'popup',
                    valueField: 'prodNum',
                    textField: 'prodName',
                    grid: {
                        columns: [{
                            display: '产品名',
                            name: 'prodName',
                            isSort: false,
                            align: 'left',
                            width: 300
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
                        },
                        {
                            display: '显示库存',
                            name: 'dispStockBalance',
                            width: 90,
                            isSort: false,
                            align: 'left'
                        }],
                        url: "${ctx}/owner/wListSearchProdsData.action",
                        pagesizeParmName: "wpagingRequest.perPageUnitNum",
                        pageParmName: "wpagingRequest.currentPage",
                        pageSize: 10,
                        method: "post",
                        async: false,
                        enabledSort: false,
                        dataAction: "server",
                        parms: {
                            "prodSearch.productName": "",
                            "prodSearch.showFlag": 1
                        },
                        isScroll: true,
                        frozen: false,
                        pageSizeOptions: [5],
                        width: '100%',
                        height: '100%'
                    },
                    condition: {
                        inputWidth: 170,
                        labelWidth: 90,
                        space: 40,

                        fields: [{
                            name: 'prodSearch.productName',
                            type: 'text',
                            label: '产品名称',
                            textField: 'prodSearch.productName',
                            width: 200
                        }

                        ]
                    },
                    onSelected: f_onSelectedProd
                }

            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '数量',
                name: 'cases',
                isSort: false,
                align: 'left',
                width: 60,
                editor: {
                    type: 'int',
                    min: 1
                }
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "<a href='javascript:f_deleteGodownInv(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png'/></a> ";

                    return h;
                }
            }],
            usePager: false,
            enabledSort: true,
            enabledEdit: true,
            clickToEdit: true,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 430,
            allowHideColumn: false

        });

    }) function f_onSelectedProd(e) {
        if (!e.data || !e.data.length) return;

        var grid = liger.get("grid1");

        var selected = e.data[0];
        grid.updateRow(grid.lastEditRow, {
            CustomerID: selected.CustomerID,
            CompanyName: selected.CompanyName
        });

        var out = JSON.stringify(selected);
        $("#message").html('最后选择:' + out);
    }
</script>
</html>