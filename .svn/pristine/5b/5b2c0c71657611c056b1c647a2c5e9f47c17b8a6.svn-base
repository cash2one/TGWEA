<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加安卓版本信息</title>
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerListBox.js"
	type="text/javascript"></script>
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
			<%@ include file="/admin/left.jsp"%>
		</div>
		<div id="maincontent" position="center" title=" ">
                <div id="beautiful">
                <div id="etitle">
               <div id="whereimg"><img src="../images/adminBP/add_apple_version.webp"/></div>
               <div id="whatfont">添加苹果版本</div>
                <div class="both"></div>
               </div>
                <div style="height:10rem;"></div>
			<form name="appleForm" method="post" id="appleForm">
				<ul>
				<li class="li-line">
	                <i class="i-spacing-first">
	                    企业：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="companyName" name="companyName"/>
                       <input type="hidden" id="ownerNum" />
                       <input type="hidden" id="fullPath" />
	                </i>
	            </li>
				
					<li class="li-line"><i class="i-spacing-first"> 选择安装包： </i> 
					<i class="i-spacing-follow"><input style="width:140px; border:0px; background:none; margin:0; padding:0;"  type="file" id="mobileApp" name="mobileApp"/><input type="button" value="上传" id="uploadApp" class="button-submit"/></i>
					</li>
					<li class="li-line"><i class="i-spacing-first"> 提示：</i> 
					<i class="i-spacing-follow" id="tishi" style="color:blue;">请先上传安装包再进行下面的操作</i>
					</li>
					<li class="li-line"><i class="i-spacing-first"> 包名：</i> <i
						class="i-spacing-follow"> <input type="text" id="packageName" name="packageName"/>格式：com.etaoguan.wea.app.taoguan
					</i></li>
					<li class="li-line"><i class="i-spacing-first"> 应用名：</i> <i
						class="i-spacing-follow"> <input type="text" id="appName" name="appName" placeholder="淘冠科技"/>
					</i></li>
				<li class="li-line"><i class="i-spacing-first"> 文件名：</i> <i
						class="i-spacing-follow"> <input type="text" id="fileName" name="fileName" placeholder="taoguanV1.0.0"/>
					</i></li>
					<li class="li-line"><i class="i-spacing-first"> 绑定的Id号： </i> <i
						class="i-spacing-follow"> <input type="text" id="bundleId" name="bundleId"/>
					</i></li>
					<li class="li-line"><i class="i-spacing-first"> 版本号： </i> <i
						class="i-spacing-follow"> <input type="text" id="versionCode" name="versionCode" placeholder="1.0.0"/>
					</i></li>
					
					<li class="li-line"><i class="i-spacing-first"> 备注： </i> <i
						class="i-spacing-follow"> <textarea cols="100" rows="4" id="remark" style="width:400px" maxlength="100"></textarea>
					</i></li>
					<li class="li-line" style="margin-left:6rem;margin-top:7rem;"><input type="submit" value="提交"
						id="saveAdmin" name="saveAdmin" class="button-submit" /> <input
						type="button" value="取消" id="cancel" name="cancel"
						class="button-cancel" onclick="javascript:history.back(-1);" /></li>
				</ul>
			</form>
		</div>
		</div>
		<div position="top">
			<%@ include file="/admin/top.jsp"%>
		</div>
	</div>
	<br />
	<div style="display:none;"></div>
</body>
<script type="text/javascript">
var formvalidate;
$(function() {
    $.expandAccordionMenu("upgrademenu");
    
    $("#companyName").ligerComboBox({
        onBeforeOpen: f_selectOwner,
        cancelable: false,
        width: 200
    });
    
    $("#uploadApp").click(function(){
   	 var own=$.trim($("#ownerNum").val());
	        if(own == undefined || own.length == 0){
	        	$.ligerDialog.error('请先选择企业');
	            return;
	        }
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
            "versionCode":{ 
                required: true,
                rangelength:[3,30],
                checkVcersionCode:"#companyName"
            },
            "companyName":{ 
                required: true
            },
            "appName":{ 
                required: true
            },
            "fileName":{ 
                required: true
            },
            "packageName":{ 
                required: true
            }
        },
        messages:{ 
            "bundleId":{ 
                digits:'请输入整数',
                min:'最小值应该是1'
            },
            "versionCode":{ 
            	 digits:'请输入整数',
                 min:'最小值应该是1'
            }
        }

    });
    $("#appleForm").ligerForm();
    f_initEditAdminData();
});

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
    $("#companyName").val(data.companyName);
    $("#ownerNum").val(data.ownerNum);
    dialog.close();
}
function f_selectOwnerCancel(item, dialog) {
    dialog.close();
}
	function f_submitForm() {
var fullPath = $.trim($("#fullPath").val());
		
		if(fullPath.length > 5){//代表已上传APP
		var bundleId = $.trim($("#bundleId").val());
		var versionCode = $.trim($("#versionCode").val());
		var activeFlag = 1;
		var remark = $.trim($("#remark").val());
		var ownerNum = $.trim($("#ownerNum").val());
		var appName = $.trim($("#appName").val());
		var fileName = $.trim($("#fileName").val());
		var packageName = $.trim($("#packageName").val());

		var param = {
			"appleVersion.bundleId" : bundleId,
			"appleVersion.versionCode" : versionCode,
			"appleVersion.activeFlag" : activeFlag,
			"appleVersion.remark" : remark,
			"appleVersion.ownerNum" : ownerNum,
			"appleVersion.appName" : appName,
			"appleVersion.fileName" : fileName,
			"appleVersion.packageName" : packageName,
			"appleVersion.fullPath":fullPath

		};
		
		j4tg.ajaxPost("${ctx}/admin/wAddapplevs.action", "json", false,
				param, function(data) {

					if (data.status == "S") {
						$.ligerDialog.success('添加 成功');
						location.href = "${ctx}/admin/wAppleInformation.action";
					}

				}, function(data) {

				});
		}else{
			alert("请先上传安装包");
		}
	}
	
	 jQuery.validator.addMethod("checkVcersionCode", function(value, element) { 
	      	var mobile = /^[1-9]{1,2}.[0-9]{1,2}.[0-9]{1,2}$/; 
	      	return this.optional(element) || (mobile.test(value)); 
	      	}, "请输入 格式为1.3.1的版本号");
</script>
</html>