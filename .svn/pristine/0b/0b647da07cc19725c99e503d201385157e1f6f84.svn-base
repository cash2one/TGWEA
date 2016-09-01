<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>产品类别信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerTree.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
         <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div style="width:500px;height:450px; display:block; margin-left:30px; margin-top:30px;background:white; border:1px solid #ccc; overflow:auto;float:left  ">
                <ul id="prodCatTree" name="prodCatTree">
                </ul>
            </div>
            <div style="margin-left:80px; margin-top:30px;float:left">
                <ul>
                    <li>
                        <i class="i-spacing-first" style="li">
                            <input class="button-common" onclick="javascript:f_addProdCat();" type="button"
                            name="addProdCat" id="addProdCat" value="新增分类" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i>
                            <div id="addProdCatDiv" style="display:none;text-align:center;margin-left:50px;border:1px solid #ccc">
                                <ul>
                                    <li style="height:40px;">
                                        <h3>
                                            新增产品分类
                                        </h3>
                                    </li>
                                    <li style="height:40px;">
                                        <i class="i-spacing-first">
                                            父分类名：
                                        </i>
                                        <i class="i-spacing-follow">
                                            <input type="text" id="addParentProdCatName" disabled="disabled" />
                                            <input type="hidden" id="hidAddParentProdCatId" />
                                        </i>
                                    </li>
                                    <li style="height:40px;">
                                        <i class="i-spacing-first">
                                            分类名：
                                        </i>
                                        <i class="i-spacing-follow">
                                            <input type="text" id="addProdCatName" />
                                        </i>
                                    </li>
                                    <li style="height:40px;text-align:center;">
                                        <input type="submit" value="保存" id="saveAddProdCat" name="saveAddProdCat"
                                        class="button-submit" onclick="javascript:f_saveAddProdCat();" />
                                        <input type="button" value="取消" id="cancelAddProdCat" name="cancelAddProdCat"
                                        class="button-cancel" onclick="javascript:f_cancelAddProdCat();" />
                                    </li>
                                </ul>
                            </div>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_updateProdCat();" type="button"
                            name="updateProdCat" id="updateProdCat" value="修改分类" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i>
                            <div id="updateProdCatDiv" style="display:none;text-align:center;margin-left:50px;border:1px solid #ccc">
                                <ul>
                                    <li style="height:40px;">
                                        <h3>
                                            更新产品分类
                                        </h3>
                                    </li>
                                    <li style="height:40px;">
                                        <i class="i-spacing-first">
                                            父分类名：
                                        </i>
                                        <i class="i-spacing-follow">
                                            <input type="text" id="updateParentProdCatName" disabled="disabled" />
                                        </i>
                                    </li>
                                    <li style="height:40px;">
                                        <i class="i-spacing-first">
                                            分类名：
                                        </i>
                                        <i class="i-spacing-follow">
                                            <input type="text" id="updateProdCatName" />
                                            <input type="hidden" id="hidUpdateProdCatId" />
                                        </i>
                                    </li>
                                    <li style="height:40px;text-align:center;">
                                        <input type="submit" value="保存" id="saveUpdateProdCat" name="saveUpdateProdCat"
                                        class="button-submit" onclick="javascript:f_saveUpdateProdCat();" />
                                        <input type="button" value="取消" id="cancelUpdateProdCat" name="cancelUpdateProdCat"
                                        class="button-cancel" onclick="javascript:f_cancelUpdateProdCat();" />
                                    </li>
                                </ul>
                            </div>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_delProdCat();" type="button"
                            name="delProdCat" id="delProdCat" value="删除分类" />
                        </i>
                    </li>
                    <li class="li-line">
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_refreshProdCatTreeData();"
                            type="button" name="refreshProdCat" id="refreshProdCat" value="刷新产品分类"
                            />
                        </i>
                    </li>
                </ul>
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
    var t, manager;

    $(function() {
        $.expandAccordionMenu("prodmenu");
        f_showProdCatsData();

    });

    function f_showProdCatsData() {
        t = manager = $("#prodCatTree").ligerTree({
            idFieldName: 'prodCatId',
            textFieldName: 'prodCatName',
            onSelect: f_onSelectProdCat,
            onCancelselect: f_onUnSelectProdCat,
            checkbox: false,
            slide: false,
            parentIDFieldName: 'parentProdCatId',
            nodeWidth:150
        });
        f_refreshProdCatTreeData();
    }

    function f_onSelectProdCat(note) {
        var selProdCat = note.data;
        var selParentProdCat = manager.getParent(note.target);
        $("#addParentProdCatName").val(selProdCat.prodCatName);
        $("#hidAddParentProdCatId").val(selProdCat.prodCatId);
        $("#hidDelProdCatId").val(selProdCat.prodCatId);
        if (selParentProdCat == null) {
            $("#updateParentProdCatName").val("");
        } else {
            $("#updateParentProdCatName").val(selParentProdCat.prodCatName);
        }
        $("#updateProdCatName").val(selProdCat.prodCatName);
        $("#hidUpdateProdCatId").val(selProdCat.prodCatId);

        //			alert(JSON.stringify(manager.getParent(note.target).prodCatName));
        //		    alert(JSON.stringify(manager.getSelected().data)); 
    }
    function f_onUnSelectProdCat(note) {
        f_resetAllItemData();
    }

    function f_addProdCat() {
    	if($("#addProdCatDiv").is(":hidden")){
        	$("#addProdCatDiv").show();
    	}else{
    		$("#addProdCatDiv").hide();
        }
    }

    function f_cancelAddProdCat() {
        $("#addParentProdCatName").val("");
        $("#addProdCatName").val("");
        $("#addProdCatDiv").hide();

    }

    function f_saveAddProdCat() {
        var parentprodcatname = $.trim($("#addParentProdCatName").val());
        var parentprodcatid = $.trim($("#hidAddParentProdCatId").val());
        var prodcatname = $.trim($("#addProdCatName").val());
        if (string.isInvalid(parentprodcatname)) {
            $.ligerDialog.error('请选择父分类');
            return;
        }
        if (string.isInvalid(prodcatname)) {
            $.ligerDialog.error('请填写分类名');
            return;
        }
        var param = {
            "prodCat.parentProdCatId": parentprodcatid,
            "prodCat.prodCatName": prodcatname
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveProdCat.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('添加成功');
                f_refreshProdCatTreeData();
            }
        },
        function(data) {

		});

    }

    function f_saveUpdateProdCat() {
        var parentprodcatname = $.trim($("#updateParentProdCatName").val());
        var prodcatid = $.trim($("#hidUpdateProdCatId").val());
        var prodcatname = $.trim($("#updateProdCatName").val());
        if (string.isInvalid(parentprodcatname) || string.isInvalid(prodcatid)) {
            $.ligerDialog.error('请选择有效分类');
            return;
        }

        if (string.isInvalid(prodcatname)) {
            $.ligerDialog.error('请填写分类名');
            return;
        }
        var param = {
            "prodCat.prodCatId": prodcatid,
            "prodCat.prodCatName": prodcatname
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveProdCat.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                f_refreshProdCatTreeData();
                $("#updateProdCatDiv").hide();
            }
        },
        function(data) {

		});

    }

    function f_updateProdCat() {
    	if($("#updateProdCatDiv").is(":hidden")){
    		$("#updateProdCatDiv").show();
        }else{
        	$("#updateProdCatDiv").hide();
        }
        
    }

    function f_cancelUpdateProdCat() {
        $("#updateParentProdCatName").val("");
        $("#updateProdCatName").val("");
        $("#updateProdCatDiv").hide();

    }

    function f_delProdCat() {
    	var selProdCat = t.getSelected();
		if(!selProdCat||string.isInvalid(selProdCat.data.parentProdCatId)){
			$.ligerDialog.error('请选择有效产品分类');
            return;
		}
        var prodCatIds = $.getSelectedAllDataValue("prodCatId", manager);
//        if (prodCatIds.length == 0) {
//            $.ligerDialog.error('请选择产品分类');
//            return;
//        }
        //    		alert(prodCatIds);
        var param = {
            "prodCatIds": prodCatIds
        };
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelBatchProdCat.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_refreshProdCatTreeData();
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_refreshProdCatTreeData() {
        j4tg.ajaxPost("${ctx}/owner/wListProdCatsData.action", "json", false, {},
        function(data) {

            if (data.status == "S") {
                manager.clear();
                manager.setData(data.respData);
                f_resetAllItemData();
            }
        },
        function(data) {

		});

        manager.expandAll();

    }

    function f_resetAllItemData() {
        $("#addParentProdCatName").val("");
        $("#hidAddParentProdCatId").val("");
        $("#addProdCatName").val("");
        $("#updateParentProdCatName").val("");
        $("#updateProdCatName").val("");
        $("#hidUpdateProdCatId").val("");
    }
</script>
</html>