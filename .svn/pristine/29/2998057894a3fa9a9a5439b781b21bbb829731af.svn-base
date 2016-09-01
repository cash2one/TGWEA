<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>企业配置信息列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
        	 <div id="beautiful" style="padding-left:5rem;width:49rem;">
                <div id="etitle" style="margin-bottom:10rem;">
               <div id="whereimg"><img src="../images/adminBP/list_ownersetting.webp"/></div>
               <div id="whatfont">企业参数配置</div>
                <div class="both"></div>
               </div>
        	<div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            企业：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="companyName" />
                            <input type="hidden" id="hidOwnerNum" />
          					<input type="hidden" id="hidCompanyName" value="" />
          					<input type="hidden" id="hidSearchOwnerNum" />
                        </i>
                        <i class="i-spacing-first">
                            企业参数：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="searchParamName" />
                        </i>              
                        <i class="i-spacing-follow">
                            <input id="searchOwnerSettings" type="button" value="搜索" onclick="f_searchOwnerSettings()"
                            />
                        </i>
                        <i class="i-spacing-follow">
                            <a href='javascript:void(0);' onclick='javascript:f_addOwnerSetting();'><img src="../images/adminBP/add_group.webp" title="添加企业配置信息"/></a>
                        </i>
                        </li>
                 </ul>
            </div>
            <div id="maingrid" style="margin-top:2rem;">
            </div>
        </div>
        </div>
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
    </div>
    <br />
    <div id="addOwnerSettingDiv" style="display:none">
    	<form name="ownerSettingForm" method="post" id="ownerSettingForm">
          <ul>
              <li class="li-line">
                  <i class="i-spacing-first">
                      企业：
                  </i>
                  <i class="i-spacing-follow">
                   <input type="text" id="addCompanyName" name="addCompanyName" />
                   <input type="hidden" id="hidAddOwnerNum" name="hidAddOwnerNum" />
         		   <input type="hidden" id="hidAddCompanyName" name="hidAddCompanyName" value="" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      参数名：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="paramName" name="paramName" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      参数值：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="text" id="paramValue" name="paramValue" />
                  </i>
              </li>
              <li class="li-line">
                  <input type="submit" value="提交" id="saveOwnerSetting" name="saveOwnerSetting" 
                  class="button-submit" />
                  <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                  onclick="javascript:aosdialog.hide();" />
              </li>
          </ul>
          </form>
  	</div>
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var manager, g, aosdialog;
    $(function() {
        $.expandAccordionMenu("configmenu");
        $("#companyName").ligerComboBox({
        	cancelable: false,
            onBeforeOpen: f_selectOwner,
            valueFieldID: 'hidOwnerNum',
            width: 200
        });
        $("#addCompanyName").ligerComboBox({
        	cancelable: false,
            onBeforeOpen: f_selectAddOwner,
            valueFieldID: 'hidAddOwnerNum',
            width: 200
        });
        $("#searchParamName").ligerComboBox({
            data: null,
            cancelable: false,
            textField :"nameCh",
            valueField :"columnCode",
            valueFieldID: 'hidSearchParamName'
        });
        $("#paramName").ligerComboBox({
            data: null,
            cancelable: false,
            textField :"nameCh",
            valueField :"columnCode",
            valueFieldID: 'hidParamName'
        });

	    $("#ownerSettingForm").validate({
        	focusInvalid:false, 
        	ignore:"",
            rules:{ 
                "addCompanyName":{ 
	    			required: true
                }, 
                "paramName": { 
                	checkLigerListBox: true
                },
                "paramValue": { 
                    required: true,
                    maxlength: 50
                }
            }, 
            messages:{ 
            	"addCompanyName": { 
            		required : '请选择企业'
    			},
    			"paramName": { 
    				checkLigerListBox : '请选择参数'
    			},
            	"paramValue": { 
    				required : '参数值不能为空',
            		maxlength: '参数值长度不能大于50'
        		}
            }

        });
        $("#ownerSettingForm").ligerForm();
        
        f_initOwnerSettingSearchData();
        f_showOwnerSettingsData();

    })

    function f_initOwnerSettingSearchData(){

        j4tg.ajaxPost("${ctx}/admin/wGetListOwnerSettingSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                if (data.respData.ownerSettingTableNames) {
                    var ownerSettings = data.respData.ownerSettingTableNames;
                    ownerSettings.push({
                        "columnCode": "",
                        "nameCh": "全部"
                    });
                    liger.get("searchParamName").setData(ownerSettings);

                }

            }
        },
        function(data) {

		});

    }
    
    function f_showOwnerSettingsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '公司名',
                name: 'owner.companyName',
                isSort: false,
                width: 200
            },
            {
                display: '参数名',
                name: 'showName',
                isSort: false,
                width: 200
            },
            {
                display: '参数值',
                name: 'paramValue',
                isSort: false,
                width: 200,
                editor: { type: 'text',minLength:1,maxLength:50 }
            
                
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {

	            	var h = "";
	                if (!rowdata._editing) {
                        h += "<a href='javascript:f_beginUpdateOwnerSetting(" + rowindex + ")'>修改</a> ";
                        h += "<a href='javascript:f_deleteOwnerSetting(" + rowindex + ")'>删除</a> ";
	                } else {
	                    h += "<a href='javascript:void(0);' onclick='javascript:f_updateOwnerSetting(" + rowindex + ")'>保存</a> ";
	                    h += "<a href='javascript:f_cancelUpdateOwnerSetting(" + rowindex + ")'>取消</a> ";
	                }
	                return h;

                }
            }],
            url: "${ctx}/admin/wListOwnerSettingsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: true,
            parms: f_getOwnerSettingParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 710,
            columnWidth: 120,
            allowHideColumn: false

        });

    }

    function f_beginUpdateOwnerSetting(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateOwnerSetting(rowid) {
        manager.cancelEdit(rowid);
    }

    function f_addOwnerSetting(){
    	$.clearElementValidateErrors($("#ownerSettingForm"));
    	liger.get("paramName").setEnabled(true);
    	if(!aosdialog){
    		aosdialog = $.ligerDialog.open({
	            target: $("#addOwnerSettingDiv"),
	            title: '添加企业配置项',
	            width: 400,
	            height: 250,
	            onClosed:function(){$("#hidAddOwnerNum").val("");}
	        });
        }
    	aosdialog.show();
    }
    function f_selectAddOwner() {

        $.ligerDialog.open({
            title: '选择企业',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/admin/wListSearchOwners.action?ownerSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectAddOwnerOK
            },
            {
                text: '取消',
                onclick: f_selectOwnerCancel
            }]
        });
        return false;
    }
    
    function f_selectOwner() {

        $.ligerDialog.open({
            title: '选择企业',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/admin/wListSearchOwners.action?ownerSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectOwnerOK
            },
            {
                text: '取消',
                onclick: f_selectOwnerCancel
            }]
        });
        return false;
    }
    function f_selectOwnerOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择企业!');
            return;
        }
        $("#hidCompanyName").val(data.companyName);
        $("#companyName").val(data.companyName);
        $("#hidOwnerNum").val(data.ownerNum);
        dialog.close();
    }

    function f_selectAddOwnerOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择企业!');
            return;
        }
        $("#hidAddCompanyName").val(data.companyName);
        $("#addCompanyName").val(data.companyName);
        $("#hidAddOwnerNum").val(data.ownerNum);
        dialog.close();

        j4tg.ajaxPost("${ctx}/admin/wGetAvailableOwnerSettings.action", "json", false, {"ownerNum":data.ownerNum},
                function(data) {
                    //alert(JSON.stringify(data));
                    if (data.status == "S") {
                        var availableOwnerSettings = data.respData;
                        if(availableOwnerSettings.length==0){
                        	liger.get("paramName").setDisabled(true);
                        	return;
                        }
                        liger.get("paramName").setData(availableOwnerSettings);

                    }
                },
                function(data) {

        		});

    }
    function f_selectOwnerCancel(item, dialog) {
        dialog.close();
    }

    
    function f_deleteOwnerSetting(rowid) {
        var ownerSetting = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/admin/wDelOwnerSetting.action", "json", false, {
                    "settingId": ownerSetting.settingId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getOwnerSettingParam());
                    }
                },
                function(data) {

				});

            }
        });


    }


    function f_getOwnerSettingParam() {
        var ownernum = $("#hidSearchOwnerNum").val();
        
        var param = {
            "ownerSettingSearch.ownerNum": ownernum
        }
        return param;

    }

    function f_submitForm() {

        var ownerNum = $("#hidAddOwnerNum").val();
        var paramName = $.trim($("#hidParamName").val());
        var paramValue = $.trim($("#paramValue").val());

        var param = {
            "ownerSetting.ownerNum": ownerNum,
            "ownerSetting.paramName": paramName,
            "ownerSetting.paramValue": paramValue
        }

        j4tg.ajaxPost("${ctx}/admin/wSaveEditOwnerSetting.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $("#companyName").val($("#addCompanyName").val());
                $("#hidOwnerNum").val($("#hidAddOwnerNum").val());
                $("#hidCompanyName").val($("#addCompanyName").val());
                $.reloadGridServerData(g, f_getOwnerSettingParam());
                aosdialog.hide();
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }

    function f_updateOwnerSetting(rowid) {

    	var ownerSetting = manager.getRow(rowid);

    	 var paramvalue = $.getGridEditColumnData(g, rowid, 'paramValue');
         if (string.isInvalid(paramvalue)) {
             $.ligerDialog.error('参数值不能为空');
             return;
         }
         if(paramvalue.length>50){
        	 $.ligerDialog.error('参数值长度不能大于50');
             return;
         }

         manager.endEdit(rowid);
         
        var param = {
            "ownerSetting.settingId": ownerSetting.settingId,
            "ownerSetting.paramValue": paramvalue
        }

        j4tg.ajaxPost("${ctx}/admin/wSaveEditOwnerSetting.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $.reloadGridServerData(g, f_getOwnerSettingParam());
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }

    function f_searchOwnerSettings() {
        var ownerNum = $.trim($("#hidOwnerNum").val());
        $("#hidSearchOwnerNum").val(ownerNum);
        $.reloadGridServerData(g, f_getOwnerSettingParam());

    }
</script>
</html>