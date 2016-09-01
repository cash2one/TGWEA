<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改苹果版本</title> 
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
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_applevs.webp"/></div>
               <div id="whatfont">修改苹果版本</div>
                <div class="both"></div>
               </div>
                <div style="height:7rem;"></div>
        	<form name="appleForm" method="post" id="appleForm">
	        <ul>
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
	                    绑定的Id号：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="bundleId" name="bundleId" />
	                     <input name="hidversionId" type="hidden" id="hidversionId" value="<s:property value="
	                    #parameters.versionId[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    版本号：
	                </i>
	                <i class="i-spacing-follow">
	                <input type="text" id="versionCode" name="versionCode" placeholder="1.0.0" />
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
     	            	"appType":"ipa"
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
        formvalidate = $("#appleForm").validate({
        	focusInvalid:false, 
        	ignore: "",
            rules:{ 
                "bundleId":{ 
                    required: true,
                    rangelength:[2,30]
                }, 
                "versionCode": { 
                    required: true,
                    rangelength:[3,30]
                }, 
                "appName": { 
                    required: true
                }, 
                "fileName": { 
                    required: true
                }, 
                "packageName": { 
                    required: true
                }
            }, 
            messages:{ 
            	"bundleId":{ 
                    digits:'请输入整数',
                    min:'最小值是1'
                }, 
                "versionCode": { 
                	digits:'请输入整数',
                    min:'最小值是1'
                }
            }

        });
        $("#appleForm").ligerForm();
        f_initEditAdminData();
    });

    function f_initEditAdminData() {
        var versionId = $("#hidversionId").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditApplevsInitData.action", "json", false, {"versionId":versionId},
        function(data) {
            if (data.status == "S") {
                if (data.respData) {
                    var appleVersion = data.respData;
                    $("#bundleId").val(appleVersion.bundleId);
                    $("#versionCode").val(appleVersion.versionCode);
                    $("#remark").val(appleVersion.remark);
                    $("#ownerNum").val(appleVersion.ownerNum);
                    $("#companyName").text(appleVersion.companyName);
                    $("#appName").val(appleVersion.appName);
                    $("#fileName").val(appleVersion.fileName);
                    $("#packageName").val(appleVersion.packageName);
                }                                   

            }
        },
        function(data) {

		});

    }

    function f_submitForm() {
    	var fullPath = $.trim($("#fullPath").val());
    	
    	var versionId = $.trim($("#hidversionId").val());
    	var bundleId = $.trim($("#bundleId").val());
    	var versionCode = $.trim($("#versionCode").val());
        var remark = $.trim($("#remark").val());
        var ownerNum = $.trim($("#ownerNum").val());
        var fileName = $.trim($("#fileName").val());
        var appName = $.trim($("#appName").val());
        var packageName = $.trim($("#packageName").val());
		
        var param = {
        	"appleVersion.versionId": versionId,
        	"appleVersion.bundleId": bundleId,
            "appleVersion.versionCode": versionCode,
            "appleVersion.remark": remark,
            "appleVersion.ownerNum": ownerNum,
            "appleVersion.fileName": fileName,
            "appleVersion.appName": appName,
            "appleVersion.packageName": packageName,
			"appleVersion.fullPath":fullPath
            

        };

        j4tg.ajaxPost("${ctx}/admin/wSaveEditApplevs.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                location.href = "${ctx}/admin/wAppleInformation.action";
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