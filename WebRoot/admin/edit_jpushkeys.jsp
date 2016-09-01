<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改极光推送企业信息</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerListBox.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
                <div id="etitle" style="margin-bottom:12rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_jpushkeys.webp"/></div>
               <div id="whatfont">编辑企业信息推送</div>
                <div class="both"></div>
               </div>
        	<form name="jpushKeysForm" method="post" id="jpushKeysForm">
	        <ul>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    企业：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="companyName" />
                       	<input type="hidden" id="hidCompanyName" value="" />
	                    <input name="hidEditOwnerNum" type="hidden" id="hidEditOwnerNum" value="<s:property value="
	                    #parameters.ownerNum[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    应用包名：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="appPackage" name="appPackage" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	        AppKey：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="appKey" name="appKey" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
			MasterSecret：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="masterSecret" name="masterSecret" />
	                </i>
	                
	            </li>
	            <li class="li-line">
                    <i class="i-spacing-first">
                        备注：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="50"></textarea>
                    </i>
                </li>
	            <li class="li-line" style="margin-left:6rem;margin-top:7rem;">
	                <input type="submit" value="提交" id="saveJpushKeys" name="saveJpushKeys"
	                class="button-submit" />
	                <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
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
	var formvalidator;
    $(function() {
        $.expandAccordionMenu("pushmenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectOwner,
            valueFieldID: 'hidOwnerNum',
            cancelable: false,
            width: 200
        });
        formvalidator = $("#jpushKeysForm").validate({
        	focusInvalid:false, 
        	ignore: "",
            rules:{ 
                "hidOwnerNum":{ 
                    required: true 
                }, 
                "appPackage": { 
                    required: true
                },
                "appKey": { 
                    required: true
                },
                "masterSecret": {
                	required: true
                }
            }, 
            messages:{ 
            	"hidOwnerNum": { 
        			rangelength: '请选择推送企业'  
        		}
            }

        });
        $("#jpushKeysForm").ligerForm();
        f_initEditJpushKeysData();
    });

    function f_initEditJpushKeysData() {
        var ownerNum = $("#hidEditOwnerNum").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditJpushKeysInitData.action", "json", false, {"ownerNum":ownerNum},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                if (data.respData.jpushKeys) {
                    var jpushKeys = data.respData.jpushKeys;
                    var owner = data.respData.owner;
                    $("#companyName").val(owner.companyName);
                    $("#appPackage").val(jpushKeys.appPackage);
                    $("#appKey").val(jpushKeys.appKey);
                    $("#masterSecret").val(jpushKeys.masterSecret);
                    $("#remark").val(jpushKeys.remark);
                    $("#hidOwnerNum").val(jpushKeys.ownerNum);
                    liger.get("companyName").updateStyle();
                    liger.get("companyName").setDisabled(true);
                }

            }
        },
        function(data) {

		});

    }
    function f_selectOwner() {
        $.ligerDialog.open({
            title: '选择客户',
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
            alert('请选择客户!');
            return;
        }
        $("#hidCompanyName").val(data.companyName);
        $("#companyName").val(data.companyName);
        $("#hidOwnerNum").val(data.ownerNum);
        dialog.close();;
        
 //       formvalidator.element($("#hidOwnerNum"));
    }
    function f_selectOwnerCancel(item, dialog) {
        dialog.close();
    }

    
    function f_submitForm() {

    	var editOwnerNum = $.trim($("#hidEditOwnerNum").val());
    	var ownerNum = $.trim($("#hidOwnerNum").val());
    	var appPackage = $.trim($("#appPackage").val());
        var appKey = $.trim($("#appKey").val());
        var masterSecret = $.trim($("#masterSecret").val());
        var remark = $.trim($("#remark").val());
        
        var url = "${ctx}/admin/wSaveAddJpushKeys.action";
        if(!string.isInvalid(editOwnerNum)){
        	ownerNum = editOwnerNum;
        	url = "${ctx}/admin/wSaveEditJpushKeys.action";
        }
        
        var param = {
        	"jpushKeys.ownerNum": ownerNum,
            "jpushKeys.appPackage": appPackage,
            "jpushKeys.appKey": appKey,
            "jpushKeys.masterSecret": masterSecret,
            "jpushKeys.remark": remark

        };



        j4tg.ajaxPost(url, "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/admin/wListJpushKeys.action";
            }else{
            	$.ligerDialog.error(data.message);
	        }

        },
        function(data) {

		});

    }
</script>
</html>