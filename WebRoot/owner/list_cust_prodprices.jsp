<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>客户价格列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                        </i>
                        <i class="i-spacing-first">
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="productName" type="text" id="productName" />
                        </i>
                      <!--   <i class="i-spacing-follow">
                            产品类别：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="productCatIds" />
                        </i> -->
                        <i class="i-spacing-follow">
                            <input id="searchCust" type="button" value="搜&nbsp;&nbsp;索" style="width:66px;" onclick="f_searchCustProdPrice()"
                            />
                        </i>
                        <input type="hidden" id="hidProductName" name="hidProductName" value=""
                        />
                       <!--  <input type="hidden" id="hidProductCatIds" name="hidProductCatIds" value=""/> -->
                        <input type="hidden" id="hidCustNum" name="hidCustNum" value="" />
                        <input type="hidden" id="hidCompanyName" name="hidCompanyName" value=""/>
                        <input type="hidden" id="hidProdNum" name="hidProdNum" value=""/>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
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
    //扩展一个 数字输入 的编辑器
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
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        $("#productName").ligerComboBox({
            onBeforeOpen: f_selectProd,
            valueFieldID: 'hidProdNum',
            width: 200
        });
       /*  $("#productCatIds").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'prodCatId',
            textField: 'prodCatName',
            treeLeafOnly: false

        }); */
        f_initCustProdPriceSearchData();
       /*  f_showCustProdPriceData(); */
    });
    
    function f_selectProd() {
        $.ligerDialog.open({
            title: '选择产品',
            name: 'winselector',
            width: 650,
            height: 350,
            url: '${ctx}/owner/wListSearchCompProds.action?prodSearch.productName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectProdOK
            },
            {
                text: '取消',
                onclick: f_selectProdCancel
            }]
        });
        return false;
    }
    function f_selectProdOK(item,dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
        	$.ligerDialog.error('请选择产品!');
            return;
        }

        $("#productName").val(data.prodName);
        $("#hidProdNum").val(data.prodNum);
        dialog.close();
    }
    function f_selectProdCancel(item,dialog) {
        dialog.close();
    }

    
    function f_selectCust() {
        $.ligerDialog.open({
            title: '选择客户',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/owner/wListSearchCusts.action?custSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectCustOK
            },
            {
                text: '取消',
                onclick: f_selectCustCancel
            }]
        });
        return false;
    }
    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择客户!');
            return;
        }

        $("#companyName").val(data.companyName);
        $("#hidCompanyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_initCustProdPriceSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListCustProdPricesSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
               /*  liger.get("productCatIds").setTree({
                    data: data.respData.prodCats,
                    idFieldName: 'prodCatId',
                    textFieldName: 'prodCatName',
                    slide: false,
                    parentIDFieldName: 'parentProdCatId'
                }); */

                if (data.searchParams) {
                    $("#hidCustNum").val(data.searchParams['custProdPriceSearch.custNum']);
                    $("#hidProductName").val(data.searchParams['custProdPriceSearch.productName']);
                    $("#hidCompanyName").val(data.searchParams['custProdPriceSearch.companyName']);
                  /*   $("#hidproductCatIds").val(data.searchParams['custProdPriceSearch.productCatIds'].join(",")); */
                   /*  $.selectComboBoxTreeNodes(liger.get("productCatIds"), data.searchParams['prodPriceSearch.productCatIds'].join(","), "prodCatId"); */
                    $.reloadGridServerData(g, f_getCustProdPriceParam());
                }

            }
        },
        function(data) {

		});

    }

    function f_showCustProdPriceData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '公司名',
                name: 'cust.companyName',
                isSort: false,
                align: 'left',
                width: 120
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
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.stdProdPrice == 0) {
                        h += "未设置";
                    } else {
                        h += rowdata.stdProdPrice;
                    }
                    return h;
                    
                }
            },
            {
                display: '客户价格',
                name: 'prodPrice',
                isSort: false,
                align: 'left',
                width: 100,
                type: 'numberbox',
                editor: {
                    type: 'numberbox',
                    precision: 2
                }
            },
            {
                display: '价差',
                isSort: false,
                align: 'left',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.prodPrice > 0 && rowdata.stdProdPrice > 0) {
                        var minus = (rowdata.prodPrice - rowdata.stdProdPrice).toFixed(2);
                        h += "<font color='red'><b>" + minus + "</b></font>";
                    }
                    return h;

                }
            },
            {
                display: '更新时间',
                name: 'updateDate',
                isSort: false,
                align: 'center',
                width: 100
            },
            {
                display: '更新人',
                name: 'updateBy',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                	
                    var h = "";
                    if (!rowdata._editing) {
                    	if (rowdata.stdProdPrice == 0) {
                            h += "未设置标准价";
                        } else {
                        h += "<a href='javascript:f_beginUpdateCustProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                        }
                    } else {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_updateCustProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/save.png' alt='保存' title='保存'/></a> ";
                        h += "<a href='javascript:f_cancelUpdateCustProdPrice(" + rowindex + ")'><img src='${ctx}/images/ico/cancel.png' alt='取消' title='取消'/></a> ";
                    }
                    return h;

                }
            }],
            url: "${ctx}/owner/wListCustProdPricesData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getCustProdPriceParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1028,
            columnWidth: 120,
            height: 'auto'
        });

    }

    function f_getCustProdPriceParam() {
        var prodNum = $.trim($("#hidProdNum").val());
       /*  var prodcatids = $("#hidProductCatIds").val().split(";"); */
        var custnum = $.trim($("#hidCustNum").val());
        var companyname = $.trim($("#hidCompanyName").val());

        var param = {
            "custProdPriceSearch.prodNum": prodNum,
            /* "custProdPriceSearch.productCatIds": prodcatids, */
            "custProdPriceSearch.companyName": companyname,
            "custProdPriceSearch.custNum": custnum
        };
        return param;

    }

    function f_beginUpdateCustProdPrice(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateCustProdPrice(rowid) {
        manager.cancelEdit(rowid);
    }
    function f_updateCustProdPrice(rowid) {

        var prodprice = $.getGridEditColumnData(g, rowid, 'prodPrice');
        if (!j4tg.isNumeric(prodprice) || parseInt(prodprice) <= 0) {
            $.ligerDialog.error('客户价格必须为大于0');
            //			setTimeout(function () { manager.beginEdit(rowid); }, 15);
            return;
        }
        manager.endEdit(rowid);
        var custprodprice = manager.getRow(rowid);
        var param = {
            "custProdPrice.prodNum": custprodprice.prodNum,
            "custProdPrice.custNum": custprodprice.custNum,
            "custProdPrice.prodPrice": custprodprice.prodPrice
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveCustProdPrice.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                $.reloadGridServerData(g, f_getCustProdPriceParam());

            }
        },
        function(data) {

		});

    }

    function f_searchCustProdPrice() {
        var productName = $.trim($("#productName").val());
       /*  var productcatids = liger.get("productCatIds").getValue(); */
       /*  var custnum = $.trim($("#hidCustNum").val());
    	alert(custnum); */
        var companyname = $.trim($("#companyName").val());
        
       /*  if (string.isInvalid(companyname) && productName == "") { */
        if (string.isInvalid(companyname) && string.isInvalid(productName)) {
            $.ligerDialog.error('搜索前，至少选择一项');
            return;
        }
        
      /*   $("#hidProdNum").val(hidProdNum);
        $("#hidCustNum").val(custnum);
        $("#hidProductName").val(productname); */
       /*  $("#hidProductCatIds").val(productcatids); */
            f_showCustProdPriceData();
       /*  if (g) {
            $.reloadGridServerData(g, f_getCustProdPriceParam());
        } else {
            f_showCustProdPriceData();
        } */
    }
</script>
</html>