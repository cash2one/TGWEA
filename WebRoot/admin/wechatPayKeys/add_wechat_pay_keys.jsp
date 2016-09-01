<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>添加客户微信支付信息</title> 
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
               <div id="whereimg"><img src="../images/adminBP/addAlipayKeys.png"/></div>
               <div id="whatfont">添加微信支付信息</div>
                <div class="both"></div>
               </div>
        	<form name="wechatKeysForm" method="post" id="wechatKeysForm">
	        <ul style="padding-left:5rem;">
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
	        商户号：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="mchId" name="mchId" />
	                </i>
	            </li>
	           
	            <li class="li-line">
	                <i class="i-spacing-first">
			支付密钥：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="payKey" name="payKey" />
	                </i>
	                
	            </li>
	            
	            <li class="li-line">
	                <i class="i-spacing-first">
			备注：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="remark" name="remark" />
	                </i>
	                
	            </li>
	            
	            <li class="li-line" style="margin-left:6rem;margin-top:8rem;">
	                <input type="submit" value="提交" id="saveWechatKeys" name="saveWechatKeys"
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
        $.expandAccordionMenu("paymenu");
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectOwner,
            valueFieldID: 'hidOwnerNum',
            cancelable: false,
            width: 200
        });
        formvalidator = $("#wechatKeysForm").validate({
        	focusInvalid:false, 
        	ignore: "",
            rules:{ 
                "hidOwnerNum":{ 
                    required: true 
                }, 
                "payKey": { 
                    required: true
                },
                "mchId": {
                	required: true
                }
            }, 
            messages:{ 
            	"hidOwnerNum": { 
        			rangelength: '请选择微站企业'  
        		}
            }

        });
        $("#wechatKeysForm").ligerForm();
    });

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
        $("#companyName").val(data.companyName);
        $("#hidOwnerNum").val(data.ownerNum);
        dialog.close();;
        
    }
    function f_selectOwnerCancel(item, dialog) {
        dialog.close();
    }

    
    function f_submitForm() {
    	var ownerNum = $.trim($("#hidOwnerNum").val());
        var payKey = $.trim($("#payKey").val());
        var mchId = $.trim($("#mchId").val());
        var remark = $.trim($("#remark").val());

        var param = {
        	"wechatPayKeys.ownerNum": ownerNum,
            "wechatPayKeys.payKey": payKey,
            "wechatPayKeys.remark": remark,
            "wechatPayKeys.mchId": mchId

        }
        
        j4tg.ajaxPost("${ctx}/admin/wAddWechatPayKeys.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                /* $.ligerDialog.success('保存成功'); */
                location.href = "${ctx}/admin/wListWechatPayKeys.action";
            }else{
            	$.ligerDialog.error(data.message);
	        }

        },
        function(data) {

		});

    }
</script>
</html>