<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改安卓版本</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerListBox.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
    input {
	padding-left: 0.2rem;
}

textarea {
	padding-left: 0.2rem;
}

.middle input {
	display: block;
	width: 30px;
	margin: 2px;
}
.i-spacing-first {
	text-align: right;
}
</style>

</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
                <div id="etitle" style="margin-bottom:9rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_android_vs.webp"/></div>
               <div id="whatfont">修改安卓版本</div>
                <div class="both"></div>
               </div>
        	<form name="androidForm" method="post" id="androidForm">
	        <ul>
	          <input name="hidversionId" type="hidden" id="hidversionId" value="<s:property value="#parameters.versionId[0] " />" />
	            <li class="li-line"><i class="i-spacing-first"> 选择安装包： </i> 
					<i class="i-spacing-follow"><input style="width:140px; border:0px; background:none; margin:0; padding:0;"  type="file" id="mobileApp" name="mobileApp"/><input type="button" value="上传" id="uploadApp" class="button-submit"/></i>
					<i class="i-spacing-follow" id="tishi" style="color:blue;"></i>
					</li>
					
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    包名：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="packageName" name="packageName" placeholder="com.etaoguan.wea.app.taoguan"/>
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    应用名：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="appName" name="appName" placeholder="淘冠科技"/>
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    文件名：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="fileName" name="fileName" placeholder="taoguanV1.0.0"/>
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    详细版本号：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="versionCode" name="versionCode" placeholder=" 1.0.0"/>
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    企业：
	                </i>
	                <i class="i-spacing-follow">
	                <span id="companyName"></span>
	                    <input type="hidden" id="companyName" name="companyName"/>
                       <input type="hidden" id="ownerNum" />
                       <input type="hidden" id="fullPath" />
	                </i>
	            </li>
	            <li class="li-line">
                    <i class="i-spacing-first">
                        备注：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="100"></textarea>
                    </i>
                </li>
	            <li class="li-line" style="margin-left:6rem;margin-top:7rem;">
	                <input type="submit" value="提&nbsp;&nbsp;交" id="saveAdmin" name="saveAdmin"
	                class="button-submit" />
	                <input type="button" value="取&nbsp;&nbsp;消" id="cancel" name="cancel" class="button-cancel"
	                onclick="javascript:history.back(-1);" />
	            </li>
	        </ul>
   			</form>
        </div>
        </div>
        <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>    
<script type="text/javascript">
	var formvalidate;
    $(function() {
        $.expandAccordionMenu("upgrademenu");
    
        $("#groups").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "groupId",
            textField: "groupName"
        });
        $("#adminGroups").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "groupId",
            textField: "groupName",
            valueFieldID: 'groupIds'
        });
        
        $("#uploadApp").click(function(){
       	 var own=$.trim($("#ownerNum").val());
  		 var mobileApp = $.trim($("#mobileApp").val());
  	        if (mobileApp == "" ) {
  	            $.ligerDialog.error('请选择安装包');
  	            return;
  	        }
  	       
  	        $.ajaxFileUpload({
  	            url: '${ctx}/admin/wUploadAndroidApp.action',
  	            data: {
  	            	"ownerNum":own,
  	            	"appType":"apk"
  	            	},
  	            secureuri: false,
  	            fileElementId: 'mobileApp',
  	            dataType: 'json',
  	            success: function(data, status) {
  	                if (data.status == "S") {
  	                             			//	alert(JSON.stringify(data));
  	                	$("#tishi").text(data.respData.fileName+" 上传成功！");
  	                    $.ligerDialog.success('上传成功');
  	                  $("#fullPath").val(data.respData.fullPath);
  	                } else {
  	                    alert(data.message);
  	                }
  	            },
  	            error: function(data, status, e) {

  				}
  	        });
  	});
      
        
        formvalidate = $("#androidForm").validate({
        	focusInvalid:false, 
        	ignore: "",
            rules:{ 
                "versionCode": { 
                    required: true,
                    rangelength:[3,30]
                },
                "appName":{ 
                    required: true,
                    rangelength:[2,30]  
                },
                "fileName":{ 
                    required: true,
                    rangelength:[2,30]  
                },
                "packageName":{ 
                    required: true
                }
            }, 
            messages:{ 
                "versionCode": { 
                    rangelength:'长度是3-30个字符之间'  
                },
                "appName":{ 
                    rangelength:'长度是2-30个字符之间' 
                }
            }

        });
        $("#androidForm").ligerForm();
        f_initEditAdminData();
    });

    function f_initEditAdminData() {
        var versionId = $("#hidversionId").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditAndroidvsInitData.action", "json", false, {"versionId":versionId},
        function(data) {
            if (data.status == "S") {
                if (data.respData) {
                    var androidVersion = data.respData;
                    $("#versionCode").val(androidVersion.versionCode);
                    $("#appName").val(androidVersion.appName);
                    $("#remark").val(androidVersion.remark);
                    $("#ownerNum").val(androidVersion.ownerNum);
                    $("#companyName").text(androidVersion.companyName);
                    $("#fileName").val(androidVersion.fileName);
                    $("#packageName").val(androidVersion.packageName);
                }

            }
        },
        function(data) {

		});

    }

    function moveToLeft()
    {
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box2.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box2.removeItems(selecteds);
        box1.addItems(selecteds);
//        alert($("#groupIds").val());
        formvalidate.element($("#hideAGValidate"));
    }
    function moveToRight()
    {
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box1.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box1.removeItems(selecteds);
        box2.addItems(selecteds);
        formvalidate.element($("#hideAGValidate"));
    }
    function moveAllToLeft()
    { 
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box2.data;
        if (!selecteds || !selecteds.length) return;
        box1.addItems(selecteds);
        box2.removeItems(selecteds); 
        formvalidate.element($("#hideAGValidate"));
    }
    function moveAllToRight()
    { 
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box1.data;
        if (!selecteds || !selecteds.length) return;
        box2.addItems(selecteds);
        box1.removeItems(selecteds);
        formvalidate.element($("#hideAGValidate"));
    }

    
    function f_submitForm() {
    	var fullPath = $.trim($("#fullPath").val());
    	
    	var versionId = $.trim($("#hidversionId").val());
    	var versionCode = $.trim($("#versionCode").val());
        var appName = $.trim($("#appName").val());
        var remark = $.trim($("#remark").val());
        var ownerNum = $.trim($("#ownerNum").val());
        var fileName = $.trim($("#fileName").val());
        var packageName = $.trim($("#packageName").val());
		
        var param = {
        		"androidVersion.versionId": versionId,
            "androidVersion.versionCode": versionCode,
            "androidVersion.appName": appName,
            "androidVersion.remark": remark,
            "androidVersion.ownerNum": ownerNum,
            "androidVersion.fileName": fileName,
            "androidVersion.packageName": packageName,
			"androidVersion.fullPath":fullPath
        };

        j4tg.ajaxPost("${ctx}/admin/wSaveEditAndroidvs.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                location.href = "${ctx}/admin/wAndroidversion.action";
            }

        },
        function(data) {

		});
    }
    
    jQuery.validator.addMethod("checkVcersionCode", function(value, element) { 
      	var mobile = /^[1-9]{1,2}.[0-9]{1,2}.[0-9]{1,2}$/; 
      	return this.optional(element) || (mobile.test(value)); 
      	}, "请输入 格式为1.3.1的版本号");
</script>
</html>