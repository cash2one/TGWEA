<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>系统配置信息列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
.m1{height:1rem;width:1rem;background-color:#f9f9f9;float:left;border:0.1rem solid;margin:1px;}
.m11{height:1rem;width:1rem;background-color:#f9f9f9;float:right;border:0.1rem solid;margin:1px;}
.m2{height:1.25rem;width:3rem;background-color:#fcfcfc;border:0.1rem solid;text-align:center;}
.m22{height:1.25rem;width:3rem;background-color:#ff9129;border:0.1rem solid;text-align:center;}
</style>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful">
                <div id="etitle" style="margin-bottom:10rem;">
               <div id="whereimg"><img src="../images/adminBP/list_appsetting.webp"/></div>
               <div id="whatfont">系统配置</div>
                <div class="both"></div>
               </div>
            <div id="addappsettingbar" style="overflow:hidden;width:510px" align="right">
                <a href='javascript:void(0);' onclick='javascript:f_addAppSetting();'>
                    <img src="../images/adminBP/add_group.webp" title="添加系统配置信息"/>
                </a>
            </div>

            <br/>
            <div id="maingrid" style="margin-left:3rem;">
            </div>
            </div>
        </div>
         <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
    </div>
    <br />
    <div id="addAppSettingDiv" style="display:none">
    	<form name="appSettingForm" method="post" id="appSettingForm">
          <ul>
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
              <li class="li-line" style="text-align:center;margin-top:3rem;">
                  <input type="submit" value="提交" id="saveAppSetting" name="saveAppSetting" 
                  class="button-submit" />
                  <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                  onclick="javascript:asdialog.hide();" />
              </li>
          </ul>
          </form>
  	</div>
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
    var manager, g, asdialog;
    $(function() {
        $.expandAccordionMenu("configmenu");
        
        $("#paramName").ligerComboBox({
            data: null,
            cancelable: false,
            textField :"nameCh",
            valueField :"columnCode",
            valueFieldID: 'hidParamName'
        });

	    $("#appSettingForm").validate({
        	focusInvalid:false, 
        	ignore:"",
            rules:{ 
                "paramName": { 
                	checkLigerListBox: true
                },
                "paramValue": { 
                    required: true,
                    maxlength: 50
                }
            }, 
            messages:{ 
    			"paramName": { 
    				checkLigerListBox : '请选择参数'
    			},
            	"paramValue": { 
    				required : '参数值不能为空',
            		maxlength: '参数值长度不能大于50'
        		}
            }

        });
        $("#appSettingForm").ligerForm();

        f_showAppSettingsData();

    });

    
    function f_showAppSettingsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [
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
                editor: { type: 'text',minLength:1,maxLength:50 },
                align:'center',
                render: function(rowdata, rowindex, value) {
                	var what="";
                	if(rowdata.paramValue == "on"){
                		what = "<div onclick='f_power(" + rowindex + ")' id='d2"+rowindex+"' class='m22' style='border-color:#ccc;border-radius:1rem;margin:auto;'><div id='d1"+rowindex+"' class='m11' style='border-color:#999;border-radius:1rem;'></div></div>";
                	}else if(rowdata.paramValue == "off"){
                		what = "<div onclick='f_power(" + rowindex + ")' id='d2"+rowindex+"' class='m2' style='border-color:#ccc;border-radius:1rem;margin:auto;'><div id='d1"+rowindex+"' class='m1' style='border-color:#999;border-radius:1rem;'></div></div>";
                	}else{
                		what = rowdata.paramValue;
                	}
                	return what;         	

                }
                
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {

                	var h = "";
	                if (!rowdata._editing) {
	                	if(rowdata.paramValue != "on" && rowdata.paramValue != "off"){
                        h += "<a href='javascript:f_beginUpdateAppSetting(" + rowindex + ")'>修改</a> ";
	                	}
                        h += "<a href='javascript:f_deleteAppSetting(" + rowindex + ")'>删除</a> ";
	                } else if(rowdata.paramValue != 0 && rowdata.paramValue != 1){
	                    h += "<a href='javascript:void(0);' onclick='javascript:f_updateAppSetting(" + rowindex + ")'>保存</a> ";
	                    h += "<a href='javascript:f_cancelUpdateAppSetting(" + rowindex + ")'>取消</a> ";
	                }
	                return h;

                }
            }],
            url: "${ctx}/admin/wListAppSettingsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: true,
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 510,
            columnWidth: 120,
            allowHideColumn: false

        });

    }
    function f_power(rowid){
    	var power = manager.getRow(rowid)
    	var pw=power.paramValue;
    	if(pw == "on" || pw == "off"){
    		
    		if(pw == "on"){
    			$("#d2"+rowid).attr("class","m2");
		    	$("#d1"+rowid).attr("class","m1");
    			pw = "off";
    		}else{
    			$("#d2"+rowid).attr("class","m22");
		    	$("#d1"+rowid).attr("class","m11");
    			pw = "on";
    		}
           var param = {
               "appSetting.settingId": power.settingId,
               "appSetting.paramValue": pw
           };

           j4tg.ajaxPost("${ctx}/admin/wSaveEditAppSetting.action", "json", false, param,
           function(data) {

               if (data.status == "S") {
            	   $.reloadGridServerData(g, {});
               }else{
               	$.ligerDialog.error(data.message);
               }

           },
           function(data) {

   		});
    		    
    	}
    }
    function f_beginUpdateAppSetting(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateAppSetting(rowid) {
        manager.cancelEdit(rowid);
    }

    function f_addAppSetting(){
    	$.clearElementValidateErrors($("#appSettingForm"));
    	liger.get("paramName").setEnabled(true);
        j4tg.ajaxPost("${ctx}/admin/wGetAvailableAppSettings.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                var availableAppSettings = data.respData;
                if(availableAppSettings.length==0){
                	liger.get("paramName").setDisabled(true);
                	return;
                }
                liger.get("paramName").setData(availableAppSettings);
            }
        },
        function(data) {

		});
    	if(!asdialog){
    		asdialog = $.ligerDialog.open({
	            target: $("#addAppSettingDiv"),
	            title: '添加系统配置项',
	            width: 400,
	            height: 250
	        });
        }
    	asdialog.show();
    }
  
    function f_deleteAppSetting(rowid) {
        var appSetting = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/admin/wDelAppSetting.action", "json", false, {
                    "settingId": appSetting.settingId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, {});
                    }
                },
                function(data) {

				});

            }
        });


    }

    function f_submitForm() {

        var paramName = $.trim($("#hidParamName").val());
        var paramValue = $.trim($("#paramValue").val());

        var param = {
            "appSetting.paramName": paramName,
            "appSetting.paramValue": paramValue
        };

        j4tg.ajaxPost("${ctx}/admin/wSaveEditAppSetting.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $.reloadGridServerData(g, {});
                asdialog.hide();
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }

    function f_updateAppSetting(rowid) {

    	var appSetting = manager.getRow(rowid);

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
            "appSetting.settingId": appSetting.settingId,
            "appSetting.paramValue": paramvalue
        };

        j4tg.ajaxPost("${ctx}/admin/wSaveEditAppSetting.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $.reloadGridServerData(g, {});
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }

</script>
</html>