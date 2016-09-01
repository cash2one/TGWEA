<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>入库单管理</title>
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>
<body>
	<div id="main">
		<div position="top">
			<%@ include file="/owner/top.jsp"%>
		</div>
		<div id="maincontent" position="center" title=" ">
			<div id="beautiful" style="padding-left:2rem;width: 50rem;">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_godowninvs.webp"/></div>
               <div id="whatfont">入库单管理</div>
                <div class="both"></div>
               </div>
			<div id="searchbar" style="overflow:hidden">
				<ul>
					<li><i class="i-spacing-first"> 产品名称： </i> <i
						class="i-spacing-follow"> <input name="productName"
							type="text" id="productName" />
					</i> <i class="i-spacing-follow"> 仓库： </i> <i class="i-spacing-follow">
							<input type="text" id="warehouse" />
					</i> 
					<i class="i-spacing-follow"> <input id="searchGodownInvs" type="button" style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchGodownInvs()" /></i>
					<i class="i-spacing-follow"><div class="bcolor borderradius adminico" style="margin-left:5rem;"> <a name="addGodownInv" href="${ctx}/owner/wEditGodownInv.action" id="addGodownInv"><img src='${ctx}/images/ico/addwarehouse.png' alt='添加入库单' title='添加入库单' /></a></div></i>
					 <input type="hidden" id="hidProductName" name="hidProductName"value="" /> 
					 <input type="hidden" id="hidWhNum" name="hidWhNum" value="" /></li>
				</ul>
			</div>
			<div id="maingrid"></div>
		</div>
		</div>
		
		<div position="left" title="主菜单">
			<%@ include file="/owner/left.jsp"%>
		</div>
		<div position="bottom">
			<%@ include file="/owner/bottom.jsp"%>
		</div>
	</div>
	<br />
	<div style="display:none;"></div>
</body>
<script type="text/javascript">
	var manager, g;

	$(function() {
		$.expandAccordionMenu("stockmenu");
		$("#warehouse").ligerComboBox({
			data : null,
			cancelable : false,
			valueFieldID : 'hidWhNum',
			valueField : 'whNum',
			textField : 'whName'
		});
		f_initGodownInvsSearchData();
		f_showGodownInvsData();

	});

	function f_initGodownInvsSearchData() {

		j4tg
				.ajaxPost(
						"${ctx}/owner/wGetListGodownInvsSearchInitData.action",
						"json",
						false,
						{},
						function(data) {
							if (data.status == "S") {
								//             				alert(JSON.stringify(data));
								data.respData.warehouses.push({
									"whNum" : "",
									"whName" : "全部"
								});
								liger.get("warehouse").setData(
										data.respData.warehouses);

								if (data.searchParams) {

									$("#hidProductName")
											.val(
													data.searchParams['godownInvSearch.prodName']);
									$("#hidWhNum")
											.val(
													data.searchParams['godownInvSearch.whNum']);
									liger.get("warehouse").updateStyle();
								}

							}
						}, function(data) {

						});

	}

	function f_showGodownInvsData() {

		g = manager = $("#maingrid")
				.ligerGrid(
						{
							columns : [
									{
										display : '入库单号',
										name : 'gdNum',
										isSort : false,
										align : 'left',
										frozen : true
									},
									{
										display : '仓库名',
										name : 'whName',
										isSort : false,
										align : 'left',
										width : 200
									},
									{
										display : '产品数量',
										name : 'prodCount',
										isSort : false,
										align : 'left',
										width : 80
									},
									{
										display : '入库单状态',
										name : 'gdStatusName',
										isSort : false,
										align : 'left',
										width : 80
									},
									{
										display : '备注',
										name : 'remark',
										isSort : false,
										align : 'left',
										width : 200
									},
									{
										display : '操作',
										isSort : false,
										align : 'left',
										width : 150,
										render : function(rowdata, rowindex,
												value) {
											var h = "";
											if (rowdata.gdStatus == 0) {
												h += "<i class='i-spacing-follow'><input id='putinstock' type='button' value='确认入库' onclick='f_confirmGodownInvPutinStock("
														+ rowindex + ")'/></i>";
												h += "<a href='${ctx}/owner/wEditGodownInv.action?gdNum="
														+ rowdata.gdNum
														+ "'><img src='${ctx}/images/ico/modification.png' alt='APP个性化定制开发' title='修改'/></a> ";
												h += "<a href='javascript:void(0);' onclick='javascript:f_deleteGodownInv("
														+ rowindex
														+ ")'><img src='${ctx}/images/ico/delete.png' alt='APP个性化定制开发' title='删除'/></a> ";
											}

											return h;

										}
									} ],
							url : "${ctx}/owner/wListGodownInvsData.action",
							pagesizeParmName : "wpagingRequest.perPageUnitNum",
							pageParmName : "wpagingRequest.currentPage",
							pageSize : 20,
							method : "post",
							async : false,
							enabledSort : true,
							parms : f_getGodownInvsParam(),
							dataAction : "server",
							clickToEdit : false,
							isScroll : false,
							frozen : false,
							pageSizeOptions : [ 20, 40 ],
							showTitle : false,
							width : 760,
							columnWidth : 120,
							height : 'auto',
							detail : {
								onShowDetail : f_showGodownInvItemsData,
								height : 'auto'
							}
						});

	}

	function f_getGodownInvsParam() {

		var prodname = $.trim($("#hidProductName").val());
		var whNum = $("#hidWhNum").val();
		var param = {
			"godownInvSearch.prodName" : prodname,
			"godownInvSearch.whNum" : whNum
		};
		return param;

	}

	function f_searchGodownInvs() {
		var productname = $.trim($("#productName").val());
		var whnum = liger.get("warehouse").getValue();

		$("#hidProductName").val(productname);
		$("#hidWhNum").val(whnum);
		$.reloadGridServerData(g, f_getGodownInvsParam());
	}

	function f_showGodownInvItemsData(row, detailPanel, callback) {
		var grid = document.createElement('div');
		$(detailPanel).append(grid);
		$(grid).css('margin', 10).ligerGrid({
			columns : [ {
				display : '产品名称',
				name : 'prodName',
				isSort : false,
				align : 'left',
				width : 300
			}, {
                display: '品类',
                name: 'differName',
                isSort : false,
                align: 'left',
                width : 100
            },{
				display : '单位',
				name : 'unit',
				isSort : false,
				align : 'left',
				width : 80
			}, {
				display : '数量',
				name : 'cases',
				isSort : false,
				align : 'left',
				width : 120
			} ],
			isScroll : false,
			showToggleColBtn : false,
			width : 620,
			data : f_getGodownInvItemsData(row.gdNum),
			showTitle : false,
			columnWidth : 100,
			onAfterShowData : callback,
			frozen : false,
			usePager : false
		});
	}

	function f_getGodownInvItemsData(gdNum) {
		var jsonData = {
			Rows : []
		};
		var param = {
			"gdNum" : gdNum
		};
		j4tg.ajaxPost("${ctx}/owner/wListGodownInvItemsData.action", "json",
				false, param, function(data) {
					jsonData.Rows = data.respData;
				}, function(data) {

				});
		return jsonData;

	}

	function f_deleteGodownInv(rowid) {

		var godowninv = manager.getRow(rowid);
		$.ligerDialog.confirm('确定要删除么?', function(yes) {
			if (yes) {

				j4tg.ajaxPost("${ctx}/owner/wDelGodownInv.action", "json",
						false, {
							"gdNum" : godowninv.gdNum
						}, function(data) {
							if (data.status == "S") {
								$.ligerDialog.success('删除成功');
								$.reloadGridServerData(g,
										f_getGodownInvsParam());
							}
						}, function(data) {

						});

			}
		});
	}

	function f_confirmGodownInvPutinStock(rowid) {

		var godowninv = manager.getRow(rowid);
		$.ligerDialog.confirm('确定执行产品入库么?', function(yes) {
			if (yes) {

				j4tg.ajaxPost(
						"${ctx}/owner/wConfirmGodownInvPutinStock.action",
						"json", false, {
							"gdNum" : godowninv.gdNum
						}, function(data) {
							if (data.status == "S") {
								$.ligerDialog.success('成功入库');
								$.reloadGridServerData(g,
										f_getGodownInvsParam());
							}
						}, function(data) {

						});

			}
		});
	}
</script>
</html>