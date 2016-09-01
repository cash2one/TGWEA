<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑推送信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerRadio.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerDateEditor.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/createmsg.webp"/></div>
               <div id="whatfont">创建推送消息</div>
                <div class="both"></div>
               </div>
        	<form name="pushMessageForm" method="post" id="pushMessageForm">
            <div><input name="hidMessageId" type="hidden" id="hidMessageId" value="<s:property value="
	                    #parameters.messageId[0] " />" />
            </div>
            <ul>
                <li id="targetTypeContainer" class="li-line">
                    <i class="i-spacing-first">
                        推送目标：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="0" id="targetType0" name="targetType" onclick="javascript:showExcludeContentContainer('targetTypeCt','0');"
                        />
                        所有客户
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="1" id="targetType1" name="targetType" onclick="javascript:showExcludeContentContainer('targetTypeCt','1');"
                        />
                        推送客户组
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="2" id="targetType2" name="targetType" onclick="javascript:showExcludeContentContainer('targetTypeCt','2');"
                        />
                        指定客户
                    </i>
                </li>
                <li id="targetTypeCt1" style="display:none" class="li-line">
                    <i class="i-spacing-first">
		   推送客户组
                    </i>
                    <i class="i-spacing-follow">
                       <input type="text" id="pushGroups" name="pushGroups" />
                    </i>
                </li>
                <li id="targetTypeCt2" style="display:none" class="li-line">
                    <i class="i-spacing-first">
                        指定客户              
                    </i>
                    <i class="i-spacing-follow">
                        <input type="text" id="companyName" />
                        <input type="hidden" id="hidCustNum" />
                        <input type="hidden" id="hidCompanyName" value="" />
                    </i>
                </li>
                <li id="messageTypeContainer" class="li-line">
                    <i class="i-spacing-first">
                        消息类型：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="0" id="messageType0" name="messageType" disabled="disabled" checked="checked" />
                        通知
                    </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	              标题：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="title" name="title" maxlength="30" style="width:250px;" />
	                </i>
	            </li>
	            <li id="sendTimeTypeContainer" class="li-line">
	                <i class="i-spacing-first">
	              推送时间：
	                </i>
	                <i class="i-spacing-follow">
                        <input type="radio" value="0" id="sendTimeType0" name="sendTimeType" onclick="javascript:showExcludeContentContainer('sendTimeTypeCt','0');"
                        />
                        立即
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="1" id="sendTimeType1" name="sendTimeType" onclick="javascript:showExcludeContentContainer('sendTimeTypeCt','1');"
                        />
                        指定时间
                    </i>
	            </li>
	            <li id="sendTimeTypeCt1" style="display:none" class="li-line">
                    <i class="i-spacing-first">
		  指定时间
                    </i>
                    <i class="i-spacing-follow">
                       <input type="text" id="sendTime" name="sendTime" />
                    </i>
                </li>
                <li class="li-line">
                        <i class="i-spacing-first">
                            自定义参数：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="addparams">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        参数名或参数值为空视为无效参数
                                    </i>
                                </li>
                                <li id="param-hd" style="height:25px">
                                    <i class="i-spacing-follow" style="width:150px">
                                        参数名
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px">
                                        参数值
                                    </i>
                                </li>
                            </ul>
                        </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        内容：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="5" name="content" id="content" style="width:400px" maxlength="70"></textarea>
                    </i>
                </li>
                <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                    <input type="button" value="保存" id="savePushMessage" name="savePushMessage"
                    class="button-submit" />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:history.back(-1);" />
                </li>
            </ul>
           	</form>
        </div>
        </div>
        </div>
        <div position="top">
        	<%@ include file="/owner/top.jsp" %>
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
    var manager, g;
    var params = {};
    $(function() {
        $.expandAccordionMenu("pushmenu");
        $("#pushGroups").ligerComboBox({
            data: null,
            cancelable: false,
            valueField: 'groupNum',
            textField: 'groupName',
            valueFieldID: 'hidPushGroup'
        });
        $("#companyName").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
        $("#targetTypeContainer input:radio").ligerRadio();
        $("#messageTypeContainer input:radio").ligerRadio();
        $("#sendTimeContainer input:radio").ligerRadio();
        $("#sendTime").ligerDateEditor({
        	showTime: true,
            cancelable: false
        });
        $("#pushMessageForm").ligerForm();
        $("#savePushMessage").click(f_savePushMessage);
        f_initEditPushMessageData();

    });

    function f_selectCust() {
        $.ligerDialog.open({
            title: '选择客户',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/owner/wListSearchCusts.action?custSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectCustOK
            },
            {
                text: '取消',
                onclick: f_selectCustCancel
            }]
        });
        return false;
    }
    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
            alert('请选择客户!');
            return;
        }
        $("#hidCompanyName").val(data.companyName);
        $("#companyName").val(data.companyName);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_initEditPushMessageData() {
        var messageId = $("#hidMessageId").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditPushMessageInitData.action", "json", false, {
            "messageId": messageId
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("pushGroups").setData(data.respData.pushGroups);
                if(data.respData.pushMessageExtraNames){
                	params = data.respData.pushMessageExtraNames;
                	f_addParams();
                }
                if (data.respData.pushMessage) {
                    var pushMessage = data.respData.pushMessage;
                    var checkedRadio = liger.get("targetType" + pushMessage.targetType);
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    if (pushMessage.targetType == "1") {
                        $("#hidPushGroup").val(pushMessage.targetId);
                        liger.get("pushGroups").updateStyle();
                        showExcludeContentContainer('targetTypeCt','1');
                    }
                    if (pushMessage.targetType == "2") {
                        $("#companyName").val(pushMessage.targetId);
                        $("#hidCustNum").val(pushMessage.targetDesc);
                        showExcludeContentContainer('targetTypeCt','2');
                    }
                    checkedRadio = liger.get("messageType" + pushMessage.messageType);
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();


                   	checkedRadio = liger.get("sendTimeType1");
                   	$("#sendTime").ligerGetDateEditorManager().setValue(pushMessage.sendTime);
                   	showExcludeContentContainer('sendTimeTypeCt','1');

                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    $("#title").val(pushMessage.title);
                    $("#content").val(pushMessage.content);

                    var extras = pushMessage.pushMessageExtras;
                    for(var i in extras)  
                    {  
                       $("#"+extras[i].extraName).val(extras[i].extraValue);  
                    }  

                } else {
                    var checkedRadio = liger.get("targetType0");
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    checkedRadio = liger.get("messageType0");
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    checkedRadio = liger.get("sendTimeType0");
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                }


            }
        },
        function(data) {

		});

    }

    function showExcludeContentContainer(ctPrefix, ctIndex) {
        for (i = 1; i <= 2; i++) {
            $("#" + ctPrefix + i).hide();
            if (i == ctIndex) {
                $("#" + ctPrefix + i).show();
            }
        }
    }

    function f_savePushMessage() {
    	var errors = [];
    	var messageid = $.trim($("#hidMessageId").val());
    	var title = $.trim($("#title").val());
        var content = $.trim($("#content").val());
        var targetid,targetdesc,messagetype,sendtime;

        if(string.isInvalid(title)){
        	errors.push('信息标题不能为空');
        }
        if(string.isInvalid(content)){
        	errors.push('信息内容不能为空');
        }
            
        var targettype = $.trim($('#targetTypeContainer input:radio[name="targetType"]:checked').val());
        if (targettype == "0") {
        	targetid = "";
        	targetdesc = "";

        }
        if (targettype == "1") {
        	targetid = liger.get("pushGroups").getValue();
        	targetdesc = liger.get("pushGroups").getText();
            if (string.isInvalid(targetid)) {
            	errors.push('请选择目标推送客户组');
            }

        }
        if (targettype == "2") {
        	targetid = $("#hidCustNum").val();
        	targetdesc = $("#companyName").val();
            if (string.isInvalid(targetid)) {
            	errors.push('请选择目标客户');
               
            }
        }

        messagetype = $.trim($('#messageTypeContainer input:radio[name="messageType"]:checked').val());

        var sendtimetype = $.trim($('#sendTimeTypeContainer input:radio[name="sendTimeType"]:checked').val());

//      if (sendtimetype == "0") {
//       	sendtime = new Date().format("yyyy-MM-dd hh:mm:ss");
// 			sendtime = null;
//      }
        if (sendtimetype == "1") {
	    	sendtime = liger.get("sendTime").inputText.val();
	    	
	    	if(string.isInvalid(sendtime)){
	    		errors.push('请选择推送时间');

	    	}else{
	    		sendtime = sendtime+":00";
	    		if(!j4tg.isDateTime(sendtime)){
	    			errors.push('推送时间格式不正确');
		    	}
	            var nowtime = Date.parse(new Date().format("yyyy-MM-dd hh:mm:ss"));
	            if (Date.parse(sendtime)< nowtime) {
	                errors.push('推送时间不能小于当前日期');
	            }
		    }

        }

        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }

        var param = {
            "pushMessage.messageId": messageid,
            "pushMessage.targetType": targettype,
            "pushMessage.targetId": targetid,
            "pushMessage.targetDesc": targetdesc,
            "pushMessage.messageType": messagetype,
            "pushMessage.sendTimeType": sendtimetype,
            "pushMessage.title": title,
            "pushMessage.content": content

        };
        
        if (sendtimetype == "1") {
        	param["pushMessage.sendTime"] = sendtime;
        }

        j4tg.ajaxPost("${ctx}/owner/wSaveEditPushMessage.action", "json", false, param,
        function(data) {
			//alert(JSON.stringify(data));
            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListPushMessages.action";
            }
            if (data.status == "F") {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }
    function f_addParams() {
    	for(var key in params){
            $("#param-hd").parent().append('<li style="height:25px"><i class="i-spacing-follow"  style="width:150px;">'+params[key]+'</i><i class="i-spacing-follow" style="width:150px"><input type="text" id="' + key + '" name="' + key + '" value="" class="l-text" style="width:130px;"/></i></li>');
        }

    }

</script>
</html>