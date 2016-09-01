<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>产品信息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerCheckBox.js" type="text/javascript"></script>
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
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="productName" type="text" id="productName" class="l-text" />
                        </i>
                        <i class="i-spacing-follow">
                            产品类别：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="productCatIds" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="newFlag" type="checkbox" name="newFlag" />
                        </i>
                        <i class="i-spacing-follow">
                            <label for="newFlagLabel">
                                新品
                            </label>
                        </i>
                        <i class="i-spacing-follow">
                            <input id="hotFlag" type="checkbox" name="hotFlag" />
                        </i>
                        <i class="i-spacing-follow">
                            <label for="hotFlagLabel">
                                热卖
                            </label>
                        </i>
                        <i class="i-spacing-follow">
                            <input id="showFlag" type="checkbox" name="showFlag" />
                        </i>
                        <i class="i-spacing-follow">
                            <label for="showFlagLabel">
                                下架
                            </label>
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchProd" type="button" value="搜&nbsp;&nbsp;索" style="width:65px;height:28px;background-color:#e0e4e9;border-radius:5px;" onclick="f_searchProd()"
                            />
                        </i>
                        <input type="hidden" id="hidProductName" name="hidProductName" value=""
                        />
                        <input type="hidden" id="hidProductCatIds" name="hidProductCatIds" value=""
                        />
                        <input type="hidden" id="hidProductModel" name="hidProductModel" value=""
                        />
                        <input type="hidden" id="hidNewFlag" name="hidNewFlag" value="-1" />
                        <input type="hidden" id="hidHotFlag" name="hidHotFlag" value="-1" />
                        <input type="hidden" id="hidShowFlag" name="hidShowFlag" value="-1" />
                    </li>
                </ul>
            </div>
            <br/>
            <br/>
           <div class="bcolor borderradius adminico" style="margin-left:7rem;"><a name="addNewprod" href="${ctx}/owner/wEditProd.action" id="addNewprod"><img src='${ctx}/images/ico/addnew.png' alt='添加新品' title='添加新品'/></a></div>
            <br/>
            <div id="batchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-follow">
                            <input name="settop" onclick="javascript:f_updateProdFlag('topflag',1);"
                            type="button" id="settop" value="置&nbsp;顶" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setuntop" onclick="javascript:f_updateProdFlag('topflag',0);"
                            type="button" id="setuntop" value="取消置顶" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setshow" onclick="javascript:f_updateProdFlag('showflag',1);"
                            type="button" id="setshow" value="上&nbsp;架" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setunshow" onclick="javascript:f_updateProdFlag('showflag',0);"
                            type="button" id="setunshow" value="下&nbsp;架" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;" />
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setnew" onclick="javascript:f_updateProdFlag('newflag',1);"
                            type="button" id="setnew" value="新&nbsp;品" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setunnew" onclick="javascript:f_updateProdFlag('newflag',0);"
                            type="button" id="setunnew" value="取消新品" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;" />
                        </i>
                        <i class="i-spacing-follow">
                            <input name="sethot" onclick="javascript:f_updateProdFlag('hotflag',1);"
                            type="button" id="sethot" value="热&nbsp;卖" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;" />
                        </i>
                        <i class="i-spacing-follow">
                            <input name="setunhot" onclick="javascript:f_updateProdFlag('hotflag',0);"
                            type="button" id="setunhot" value="取消热卖" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;" />
                        </i>
                        <i class="i-spacing-follow">
                            <input name="settop" onclick="javascript:f_batchDelProd();" type="button"
                            id="batchdel" value="批量删除" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                         <i class="i-spacing-follow">
                            <input name="public" onclick="javascript:f_updateProdFlag('isPublic',0);"
                            type="button" id="public" value="公&nbsp;开" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
                         <i class="i-spacing-follow">
                            <input name="conceal" onclick="javascript:f_updateProdFlag('isPublic',1);"
                            type="button" id="conceal" value="隐&nbsp;藏" style="width:65px;height:25px;background-color:#e6a96a;border-radius:5px;"/>
                        </i>
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
    var manager, g, gcheckbox;

    $(function() {
        $.expandAccordionMenu("prodmenu");
        gcheckbox = new $.ligerGridCheckboxVO({
            checkFieldName: 'prodNum'
        });

        $("#productCatIds").ligerComboBox({
            width: 250,
            selectBoxWidth: 250,
            selectBoxHeight: 250,
            valueField: 'prodCatId',
            textField: 'prodCatName',
            treeLeafOnly: false,
            tree:{nodeWidth:150}

        });
        $("#newFlag").ligerCheckBox({});
        $("#hotFlag").ligerCheckBox({});
        $("#showFlag").ligerCheckBox({});

        f_initProdsDataGrid();
        f_initProdSearchData();
       
    });

    function f_initProdSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListProdsSearchInitData.action", "json", false, {},
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
                	
                    $("#hidProductName").val(data.searchParams['prodSearch.productName']);
                    $("#hidNewFlag").val(data.searchParams['prodSearch.newFlag']);
                    $("#hidHotFlag").val(data.searchParams['prodSearch.hotFlag']);
                    $("#hidShowFlag").val(data.searchParams['prodSearch.showFlag']);
                    if (data.searchParams['prodSearch.newFlag'] == '1') {
                        liger.get("newFlag").setValue(true);
                    }
                    if (data.searchParams['prodSearch.hotFlag'] == '1') {
                        liger.get("hotFlag").setValue(true);
                    }
                    if (data.searchParams['prodSearch.showFlag'] == '1') {
                        liger.get("showFlag").setValue(true);
                    }
                    if(data.searchParams['prodSearch.productCatIds']){
                    	$("#hidProductCatIds").val(data.searchParams['prodSearch.productCatIds'].join(";"));
                    	$.selectComboBoxTreeNodes(liger.get("productCatIds"), data.searchParams['prodSearch.productCatIds'].join(","), "prodCatId");
                    }
                }
                $.reloadGridServerData(g, f_getProdsParam(),data.searchParams);

            }
        },
        function(data) {

		});

    }

    function f_initProdsDataGrid() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品编号',
                name: 'prodNum',
                isSort: false,
                align: 'left',
                frozen: true
            },
            {
                display: '',
                isSort: false,
                align: 'left',
                width: 120,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.newFlag == "1") {
                        h += "<img src='${ctx}/images/ico/new.png' alt='新品' title='新品'/>";
                    }

                    if (rowdata.hotFlag == "1") {
                        h += "<img src='${ctx}/images/ico/hot.png' alt='热' title='热'/>";
                    }
                    if (rowdata.topFlag == "1") {
                        h += "<img src='${ctx}/images/ico/top.png' alt='置顶' title='置顶'/>";
                    }
                    if (rowdata.isPublic == "1") {
                        h += " <img src='${ctx}/images/ico/noopen.png' alt='不公开' title='不公开'/>";
                    }
                    return h;
                }
            },
            {
                display: '',
                name: 'showName',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '产品分类',
                name: 'prodCatId',
                isSort: false,
                align: 'left',
                width: 120
            },
            {
                display: '单位',
                name: 'unit',
                isSort: false,
                align: 'left',
                width: 60
            },
            {
                display: '价格',
                name: 'stdPrice',
                align: 'left',
                width: 80
            },
            {
                display: '显示库存',
                name: 'dispStockBalance',
                isSort: false,
                align: 'left',
                width: 80
            },
            {
                display: '创建日期',
                name: 'createDate',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '更新日期',
                name: 'updateDate',
                align: 'left',
                width: 100
            },
            /**            { display: '排序', isSort: false,align: 'left',width: 40,render: function (rowdata, rowindex, value)
                {
                 //获取页面数据总数
                 var datalength = g._getParentChildren(rowindex).length;
            	 var h = "";
            	 if(rowindex==0){
            		 h += "<a href='javascript:javascript:void(0);' onclick='javascript:f_exchangeProdSequence(" + rowindex + ","+(rowindex+1)+")'>下</a> ";
                 }else if(rowindex == datalength-1){
                	 h += "<a href='javascript:javascript:void(0);' onclick='javascript:f_exchangeProdSequence(" + (rowindex-1) + ","+rowindex+")'>上</a> ";
                 }else{
                	 h += "<a href='javascript:javascript:void(0);' onclick='javascript:f_exchangeProdSequence(" + (rowindex-1) + ","+rowindex+")'>上</a> ";
                	 h += "<a href='javascript:javascript:void(0);' onclick='javascript:f_exchangeProdSequence(" + rowindex + ","+(rowindex+1)+")'>下</a> ";
                 }
                          
                 return h;

            	}
            },
			**/
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";

                    h += "<a href='${ctx}/owner/wEditProd.action?prodNum=" + rowdata.prodNum + "'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                    h += "<a href='javascript:void(0);' onclick='javascript:f_deleteProd(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";

                    return h;

                }
            }],
            url: "${ctx}/owner/wListProdsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 15,
            method: "post",
            async: false,
            checkbox: true,
            onCheckRow: f_onCheckRow,
            onCheckAllRow: f_onCheckAllRow,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getProdsParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1200,
            columnWidth: 120,
            allowHideColumn: false,
            delayLoad:true
        });

    }

    function f_onCheckAllRow(checked) {
        gcheckbox.checkAllRow(g, checked);
    }

    function f_onCheckRow(checked, data) {
        gcheckbox.checkRow(checked, data);
    }

    function f_updateProdFlag(flagname, flagvalue) {

        var checkedProds = gcheckbox.getCheckedValue();
        if (checkedProds.length == 0) {
            $.ligerDialog.error('请选择产品');
            return;
        }

        var param = {
            "batchFlagChange.prodNums": checkedProds,
            "batchFlagChange.flag": flagvalue
        };
        var url;
        if (flagname == "topflag") {
            url = "${ctx}/owner/wBatchUpdateTopFlag.action";
        } else if (flagname == "showflag") {
            url = "${ctx}/owner/wBatchUpdateShowFlag.action";
        } else if (flagname == "newflag") {
            url = "${ctx}/owner/wBatchUpdateNewFlag.action";
        } else if (flagname == "hotflag") {
            url = "${ctx}/owner/wBatchUpdateHotFlag.action";
        } else if (flagname == "isPublic") {//公开，隐藏
            url = "${ctx}/owner/wBatchUpdateIsPublic.action";
        }

        j4tg.ajaxPost(url, "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                refreshProdGridData();
            }
        },
        function(data) {

		});

    }

    function f_batchDelProd(rowid) {

        var checkedProds = gcheckbox.getCheckedValue();
        if (checkedProds.length == 0) {
            $.ligerDialog.error('请选择产品');
            return;
        }

        var param = {
            "prodNums": checkedProds
        };
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wBatchDelProd.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        refreshProdGridData();
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_exchangeProdSequence(prerowid, rowid) {
        var prerow = manager.getRow(prerowid);
        var row = manager.getRow(rowid);
        var param = {
            "preProdNum": prerow.prodNum,
            "prodNum": row.prodNum
        };

        j4tg.ajaxPost("${ctx}/owner/wExchangeProdSequence.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                refreshProdGridData();
            }
        },
        function(data) {

		});

    }

    function refreshProdGridData() {
        $.reloadGridServerData(g, f_getProdsParam());
        gcheckbox.initGridCheckboxStatus();
    }

    function f_searchProd() {
        var productname = $.trim($("#productName").val());
        var productcatids = liger.get("productCatIds").getValue();
        var newflag = -1,
        hotflag = -1,
        showflag = -1;
        if (liger.get("newFlag").getValue()) {
            newflag = 1;
        }
        if (liger.get("hotFlag").getValue()) {
            hotflag = 1;
        }
        if (liger.get("showFlag").getValue()) {
            showflag = 0;
        }

        $("#hidProductName").val(productname);
        $("#hidProductCatIds").val(productcatids);
        $("#hidNewFlag").val(newflag);
        $("#hidHotFlag").val(hotflag);
        $("#hidShowFlag").val(showflag);
        $.reloadGridServerData(g, f_getProdsParam());
    }

    function f_deleteProd(rowid) {

        var prod = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelProd.action", "json", false, {
                    "prodNum": prod.prodNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        refreshProdGridData();
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_getProdsParam() {
        var prodname = $("#hidProductName").val();
        var prodcatids = $("#hidProductCatIds").val().split(";");
        var newflag = $("#hidNewFlag").val();
        var hotflag = $("#hidHotFlag").val();
        var showflag = $("#hidShowFlag").val();

        var param = {
            "prodSearch.productName": prodname,
            "prodSearch.productCatIds": prodcatids,
            "prodSearch.newFlag": newflag,
            "prodSearch.hotFlag": hotflag,
            "prodSearch.showFlag": showflag,
            "redtfw":"Y"

        };
        return param;

    }
</script>
</html>