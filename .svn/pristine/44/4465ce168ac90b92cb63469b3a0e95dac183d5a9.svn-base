<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>表字段值列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
    <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        
        <div id="maincontent" position="center" title=" ">
        	<div id="beautiful" style="padding-left:2rem;width:59rem;">
                <div id="etitle" style="margin-bottom:12rem;">
               <div id="whereimg"><img src="../images/adminBP/list_groups.webp"/></div>
               <div id="whatfont" style="margin-left:10rem;">表字段值列表</div>
                <div class="both"></div>
               </div>
        	<div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            表名：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="tables" type="text" id="tables" />
                        </i>
                       
                        <i class="i-spacing-follow" style="width:35rem;text-align:right;">
                            <a href="javascript:f_updateTableCodeName()"><img src="../images/adminBP/add_group.webp" title="添加表字段值"/></a>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
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
    
   <div id="editcodenamediv" style="display:none">
   	<form name="editCodenameForm" method="post" id="editCodenameForm">
          <ul>
              <li class="li-line">
                  <i class="i-spacing-first">
                      表名：
                  </i>
                  <i class="i-spacing-follow">
                  	<input name="edittables" type="text" id="edittables" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      字段名：
                  </i>
                  <i class="i-spacing-follow">
                      <input name="editcolumns" type="text" id="editcolumns" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      字段值：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="columncode" name="columncode"  size="30" maxlength="50" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      中文名：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="namech" name="namech"  size="30" maxlength="50" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      英文名：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="nameen" name="nameen"  size="30" maxlength="50" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      备注：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="columndesc" name="columndesc"  size="30" maxlength="50" />
                  </i>
              </li>
              <li class="li-line">
                  <input type="submit" value="提交" id="saveTableCodeName" name="saveTableCodeName"  
                  class="button-submit" />
                  <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                  onclick="javascript:tablenamedialog.hide();" />
              </li>
          </ul>
          </form>
  	</div>      
</body>    
<script  type="text/javascript">
	var manager, g, tableColumns,tablenamedialog;
	$(function() {
	    $.expandAccordionMenu("configmenu");
	    $("#tables").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            treeLeafOnly: false,
            cancelable: false,
            valueFieldID: 'searchtablename',
            onSelected: function (newvalue)
            {	
	    		
            	$.reloadGridServerData(g, f_getTableCodeNamesParam());
            }
        });
	    $("#edittables").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            treeLeafOnly: false,
            cancelable: false,
            valueFieldID: 'tablename',
            onSelected: function (newvalue)
            {
		    	 var comboBoxData = [];
		    	 if(!string.isInvalid(newvalue)){
		             columns = tableColumns[newvalue];
		        	 for(var key in columns){
		             	comboBoxData.push({ id: columns[key], text: columns[key] }); 
		             }
		    	 }
	           	 liger.get("editcolumns").setData(comboBoxData);
            }

        });
	    $("#editcolumns").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            treeLeafOnly: false,
            cancelable: false,
            valueFieldID: 'columnname'

        });
	    $("#editCodenameForm").validate({
        	focusInvalid:false, 
        	ignore:"",
            rules:{ 
                "edittables":{ 
	    			checkLigerListBox: true
                }, 
                "editcolumns": { 
                	checkLigerListBox: true
                },
                "columncode": { 
                    required: true,
                    maxlength: 30
                },
                "namech": { 
                    required: true, 
                    maxlength: 30
                },
                "nameen": { 
                    maxlength: 30
                }
            }, 
            messages:{ 
            	"edittables": { 
            		checkLigerListBox : '请选择表名'
    			},
    			"editcolumns": { 
    				checkLigerListBox : '请选择字段名'
    			},
            	"columncode": { 
            		maxlength: '字段值长度不能大于30'
        		},
	            "namech":{ 
        			maxlength: '中文名长度不能大于30' 
	            },
	            "nameen":{ 
        			maxlength: '英文名长度不能大于30' 
	            } 
            }

        });
        $("#editCodenameForm").ligerForm();
	    f_initTableCodeNameSearchData();
	    f_showTableCodeNamesData();

	})
    function f_initTableCodeNameSearchData() {

        j4tg.ajaxPost("${ctx}/admin/wGetListTableCodeNamesSearchInitData.action", "json", false, {},
        function(data) {
            //alert(JSON.stringify(data));
            if (data.status == "S") {
                var comboBoxData = [];
                tableColumns = data.respData.tableCodeNames;
           	 	for(var key in tableColumns){
                	comboBoxData.push({ id: key, text: key }); 
                }
           	 	comboBoxData.push({ id: "", text: "请选择表名" }); 
                liger.get("tables").setData(comboBoxData);
                liger.get("edittables").setData(comboBoxData);

            }
        },
        function(data) {

		});

    }

    function f_showTableCodeNamesData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '表名',
                name: 'tableName',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '字段名',
                name: 'columnName',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '值信息',
                name: 'columnCode',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '中文显示名',
                name: 'nameCh',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '备注',
                name: 'columnDesc',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    h += "<a href='javascript:f_updateTableCodeName(" + rowindex + ")'>修改</a> ";
                    h += "<a href='javascript:f_deleteTableCodeName(" + rowindex + ")'>删除</a> ";
                   
                    return h;

                }
            }],
            url: "${ctx}/admin/wListTableCodeNamesData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 15,
            method: "post",
            usePager: true,
            async: false,
            enabledSort: false,
            enabledEdit: false,
            dataAction: "server",
            parms: f_getTableCodeNamesParam(),
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [15, 30],
            showTitle: false,
            width: 920,
            columnWidth: 120,
            allowHideColumn: false

        });

    }

    function f_updateTableCodeName(rowid){
    	f_initTableCodeNameEditField();
        if(!string.isInvalid(rowid)){
        	var tableCodeName = manager.getRow(rowid);
        	$("#tablename").val(tableCodeName.tableName);
        	liger.get("edittables").updateStyle();
        	var comboBoxData = [];
            columns = tableColumns[tableCodeName.tableName];
       	 	for(var key in columns){
            	comboBoxData.push({ id: columns[key], text: columns[key] }); 
            }
          	liger.get("editcolumns").setData(comboBoxData);
          	$("#columnname").val(tableCodeName.columnName);
          	liger.get("editcolumns").updateStyle();
          	$("#columncode").val(tableCodeName.columnCode);
			$("#namech").val(tableCodeName.nameCh);
			$("#nameen").val(tableCodeName.nameEn);
			$("#columndesc").val(tableCodeName.columnDesc);
			liger.get("edittables").setDisabled();
			liger.get("editcolumns").setDisabled();
        }else{
        	liger.get("edittables").setEnabled();
			liger.get("editcolumns").setEnabled();
        }

        if(!tablenamedialog){
        	tablenamedialog = $.ligerDialog.open({
	            target: $("#editcodenamediv"),
	            title: '表字段值信息',
	            width: 400,
	            height: 350
	        });
        }
        tablenamedialog.show();
        $.clearElementValidateErrors($("#editCodenameForm"));
    }

	function f_submitForm(){
		var tablename = $.trim($("#tablename").val());
		var columnname = $.trim($("#columnname").val());
		var columncode = $.trim($("#columncode").val());
		var namech=$.trim($("#namech").val());
		var nameen=$.trim($("#nameen").val());
		var columndesc=$.trim($("#columndesc").val());
/*
		if(string.isInvalid(tablename)){
			$.ligerDialog.alert("请选择表名");
			return ;
		}
		if(string.isInvalid(columnname)){
			$.ligerDialog.alert("请选择字段名");
			return ;
		}
		if(string.isInvalid(columncode)){
			$.ligerDialog.alert("请填写字段值");
			return ;
		}
		if(string.isInvalid(namech.length)){
			$.ligerDialog.alert("请填写中文名");
			return ;
		}
*/

		var param = {
			"tableCodeName.tableName":tablename,
			"tableCodeName.columnName":columnname,
			"tableCodeName.columnCode":columncode,
			"tableCodeName.nameCh":namech,
			"tableCodeName.nameEn":nameen,
			"tableCodeName.columnDesc":columndesc
		}
		j4tg.ajaxPost("${ctx}/admin/wSaveEditTableCodeName.action", "json", false, param,
        function(data) {
			if (data.status == "S") {
				tablenamedialog.hide();
				$.ligerDialog.alert("保存成功");
				$.reloadGridServerData(g, f_getTableCodeNamesParam());
			}
        },
        function(data) {

		});
	}	
	
	function f_deleteTableCodeName(rowid) {
		var tableCodeName = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

            	var param = {
            			"tableCodeName.tableName":tableCodeName.tableName,
            			"tableCodeName.columnName":tableCodeName.columnName,
            			"tableCodeName.columnCode":tableCodeName.columnCode
            	}
                j4tg.ajaxPost("${ctx}/admin/wDelTableCodeName.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getTableCodeNamesParam());
                    }
                },
                function(data) {

				});

            }
    	});
	}
	
    function f_getTableCodeNamesParam() {

        var tableName = $.trim($("#searchtablename").val());
        var param = {
            "tableCodeNameSearch.tableName": tableName
        }
        return param;

    }

    function f_initTableCodeNameEditField() {

    	$("#tablename").val("");
	    liger.get("editcolumns").setData([]);
	    $("#columnname").val("");
	    liger.get("edittables").updateStyle();
	    liger.get("editcolumns").updateStyle();
	    $("#columncode").val("");
		$("#namech").val("");
		$("#nameen").val("");
		$("#columndesc").val("");

    }
			
</script>
</html>