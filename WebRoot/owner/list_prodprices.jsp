<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>标准价格列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="width:50rem;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_prodprices.webp"/></div>
               <div id="whatfont" style="margin-left:10rem;">标准价管理</div>
                <div class="both"></div>
               </div>
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="productName" type="text" id="productName" />
                        </i>
                        <i class="i-spacing-follow">
                            产品类别：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="productCatIds" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchCust" type="button" style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchProdPrice()"
                            />
                        </i>
                        <input type="hidden" id="hidProductName" name="hidProductName" value=""
                        />
                        <input type="hidden" id="hidProductCatIds" name="hidProductCatIds" value=""
                        />
                    </li>
                </ul>
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
    $.ligerDefaults.Grid.editors['numberbox'] = {
        create: function(container, editParm) {
            var column = editParm.column;
            var precision = column.editor.precision;
            var input = $("<input type='text' style='text-align:right' class='l-text' />");
            input.bind('keypress',
            function(e) {
                var keyCode = window.event ? e.keyCode: e.which;
                return keyCode >= 48 && keyCode <= 57 || keyCode == 46 || keyCode == 8;
            });
            input.bind('blur',
            function() {
                //放置编辑框出现NaN
                //var value = input.val();
                //input.val(parseFloat(value).toFixed(precision));
            });
            container.append(input);
            return input;
        },
        getValue: function(input, editParm) {
            return parseFloat(input.val());

        },
        setValue: function(input, value, editParm) {
            var column = editParm.column;
            var precision = column.editor.precision;
            if (value == 0) {
                input.val("未设置");
            } else {
                input.val(value.toFixed(precision));
            }
        },
        resize: function(input, width, height, editParm) {
            input.width(width).height(height);
        }
    };

    //扩展 numberbox 类型的格式化函数
    $.ligerDefaults.Grid.formatters['numberbox'] = function(value, column) {

        if (value == 0) {
            return "未设置";
        } else {
            var precision = column.editor.precision;
            return value.toFixed(precision);
        }
    };

    var manager, g;

    $(function() {
        $.expandAccordionMenu("pricemenu");
        $("#productCatIds").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'prodCatId',
            textField: 'prodCatName',
            treeLeafOnly: false

        });
        f_initProdPriceSearchData();
        f_showProdPriceData();

    });

    function f_initProdPriceSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListProdPricesSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("productCatIds").setTree({
                    data: data.respData.prodCats,
                    idFieldName: 'prodCatId',
                    textFieldName: 'prodCatName',
                    slide: false,
                    parentIDFieldName: 'parentProdCatId'
                });

                if (data.searchParams) {

                    $("#hidProductName").val(data.searchParams['prodPriceSearch.productName']);
                    $("#hidproductCatIds").val(data.searchParams['prodPriceSearch.productCatIds'].join(","));
                    $.selectComboBoxTreeNodes(liger.get("productCatIds"), data.searchParams['prodPriceSearch.productCatIds'].join(","), "prodCatId");
                }

            }
        },
        function(data) {

		});

    }

    function f_showProdPriceData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '产品名',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '标准价格',
                name: 'prodPrice',
                isSort: false,
                align: 'left',
                width: 120,
                type: 'numberbox',
                editor: {
                    type: 'numberbox',
                    precision: 2
                }
            },
            {
                display: '更新时间',
                name: 'updateDate',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '更新人',
                name: 'customer.phoneNum',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (!rowdata._editing) {
                        h += "<a href='javascript:f_beginUpdateProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/modification.png'/></a> ";
                    } else {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_updateProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/save.png'/></a> ";
                        h += "<a href='javascript:f_cancelUpdateProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/cancel.png' alt='取消' title='取消'/></a> ";
                    }
                    return h;

                }
            }],
            url: "${ctx}/owner/wListProdPricesData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getProdPriceParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 730,
            columnWidth: 120,
            height: 'auto'
        });

    }

    function f_getProdPriceParam() {

        var prodname = $.trim($("#hidProductName").val());
        var prodcatids = $("#hidProductCatIds").val().split(";");
        var param = {
            "prodPriceSearch.prodName": prodname,
            "prodPriceSearch.productCatIds": prodcatids,
        };
        return param;

    }

    function f_beginUpdateProdPrice(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateProdPrice(rowid) {
        manager.cancelEdit(rowid);
    }
    function f_updateProdPrice(rowid) {

        var prodprice = $.getGridEditColumnData(g, rowid, 'prodPrice');
        if (!j4tg.isNumeric(prodprice) || parseInt(prodprice) <= 0) {
            $.ligerDialog.error('标准价格必须为大于0');
            //			setTimeout(function () { manager.beginEdit(rowid); }, 15);
            return;
        }
        manager.endEdit(rowid);
        var prodprice = manager.getRow(rowid);
        var param = {
            "prodPrice.prodNum": prodprice.prodNum,
            "prodPrice.prodPrice": prodprice.prodPrice
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveProdStdPrice.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                $.reloadGridServerData(g, f_getProdPriceParam());

            }
        },
        function(data) {

		});

    }

    function f_searchProdPrice() {
        var productname = $.trim($("#productName").val());
        var productcatids = liger.get("productCatIds").getValue();

        $("#hidProductName").val(productname);
        $("#hidProductCatIds").val(productcatids);
        $.reloadGridServerData(g, f_getProdPriceParam());
    }
</script>
</html>