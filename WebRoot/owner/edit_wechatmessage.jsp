<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑微网站信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerRadio.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful" style="width:900px;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/pushing.webp"/></div>
               <div id="whatfont">创建微站消息</div>
                <div class="both"></div>
               </div>
        	<form name="wechatMessageForm" method="post" id="wechatMessageForm">
            <div><input name="hidMessageId" type="hidden" id="hidMessageId" value="<s:property value="
	                    #parameters.messageId[0] " />" />
            </div>
            <ul>
                <li class="li-line">
	                <i class="i-spacing-first">
	              消息概要：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="subject" name="subject" maxlength="50" style="width:250px;" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	              回复关联消息：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="replyKey" name="replyKey" maxlength="30" style="width:150px;" />
	                </i>
	            </li>
                <li id="messageTypeContainer" class="li-line">
                    <i class="i-spacing-first">
                        消息类型：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="0" id="messageType0" name="messageType" onclick="javascript:showExcludeContentContainer('messageTypeCt','0');"
                        />
                        文本消息
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="1" id="messageType1" name="messageType" onclick="javascript:showExcludeContentContainer('messageTypeCt','1');"
                        />
                        图文消息
                    </i>
                </li>
                <li id="messageTypeCt0" style="display:none" class="li-line">
                    <i class="i-spacing-first">
                        文本消息内容：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="5" name="messageText" id="messageText" style="width:400px" maxlength="100"></textarea>
                    </i>
                </li>
                <li id="messageTypeCt1" style="display:none" class="li-line">
                     <i class="i-spacing-first">
                                       图文消息明细：
                     </i>
                        <i class="i-spacing-follow">
                            <ul id="addnewsitems">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        请详细填写图文消息数据
                                    </i>
                                    <i class="i-spacing-follow">
                                        <a href="javascript:void(0);" onclick="f_addNewsItem();">
                                        添加
                                        </a>
                                    </i>
                                </li>
                                <li id="newsitem-hd" style="height:25px;background:#eee">
                                    <i class="i-spacing-follow" style="width:150px;text-align:left;">
                                        图片
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px;text-align:left;">
                                        标题
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px;text-align:left;">
                                        描述
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px;text-align:left;">
                                        链接地址(可为空)
                                    </i>                                    
                                    
                                </li>
                            </ul>
                        </i>
                </li>

                <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                    <input type="button" value="保存" id="saveWechatMessage" name="saveWechatMessage"
                    class="button-submit" />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:history.back(-1);" />
                </li>
            </ul>
           	</form>
        </div>
        </div>
        <div id="uploadImgDiv" style="display:none;text-align:center;">
            <ul>
                <li style="height:40px;text-align:center;">
                    <h3>
                     消息图片上传
                    </h3>
                </li>
                <li style="height:40px;text-align:center;">
                    选择本地图片：
                    <input style="width:140px; border:0px; background:none; margin:0; padding:0;"
                    type="file" id="imgFile" name="imgFile" accept="application/msexcel" />
                </li>
                <li style="height:40px;color:red;text-align:center;">
                    文件类型：JPG,JPEG,PNG
                </li>
                <li style="height:40px;text-align:center;">
                    <input type="submit" value="上传" id="saveImg" name="saveImg" class="button-submit"
                    />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:f_closeUploadImgWindow();" />
                </li>
            </ul>
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
    var selitemid,upload;
    var params = {};
    $(function() {
        $.expandAccordionMenu("wechatmenu");
        $("#messageTypeContainer input:radio").ligerRadio();
        $("#wechatMessageForm").ligerForm();
        $("#saveWechatMessage").click(f_saveWechatMessage);
        $("#saveImg").click(f_saveImg);
        f_initEditWechatMessageData();

    });

    function f_initEditWechatMessageData() {
        var messageId = $("#hidMessageId").val();
        j4tg.ajaxPost("${ctx}/owner/wGetWechatMessageData.action", "json", false, {
            "messageId": messageId
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                if (data.respData.wechatMessage) {
                    var wechatMessage = data.respData.wechatMessage;
                    $("#subject").val(wechatMessage.subject);
                    $("#messageId").val(wechatMessage.messageId);
                    $("#replyKey").val(wechatMessage.replyKey);
                    var checkedRadio = liger.get("messageType" + wechatMessage.messageType);
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    if (wechatMessage.messageType == "0") {
                        $("#messageText").val(data.respData.messageText);
                        showExcludeContentContainer('messageTypeCt','0');
                    }
                    if (wechatMessage.messageType == "1") {
	                   	 var messageDatas = data.respData.messageDatas;
	                	 for (var key in messageDatas) {
	                		 f_addNewsItem(messageDatas[key]);
	                	 }
                        showExcludeContentContainer('messageTypeCt','1');
                    }


                } else {
                    var checkedRadio = liger.get("messageType0");
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    showExcludeContentContainer('messageTypeCt','0');
                }


            }
        },
        function(data) {

		});

    }

    function f_addNewsItem(newsItem) {
    	if(newsItem){
    		 var url = newsItem.imgUrl;
    		 if(!j4tg.isUrl(newsItem.imgUrl)){
    			 url = "${imgCtx}/"+newsItem.imgUrl;
    	        }
    		
            var newsid = Math.uuid();
            var itemobj = [];
            itemobj.push('<li id="newsid' + newsid + '" style="height:80px;border-bottom:1px solid #333">');
            itemobj.push('<i class="i-spacing-follow"  style="width:100px;">');
            itemobj.push('<img id="img'+newsid+'" src="' + url + '" style="width:60px;height:60px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
            itemobj.push('<input type="hidden" id="hidimg' + newsid + '" name="hidimg' + newsid + '" value="'+newsItem.imgUrl+'"/>');
            itemobj.push('<input type="hidden" id="addimg' + newsid + '" name="addImg' + newsid + '" value="false" />');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="2" id="title' + newsid + '" name="title' + newsid + '" style="width:130px" maxlength="150">'+newsItem.title+'</textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" id="desc' + newsid + '" name="desc' + newsid + '" style="width:130px" maxlength="150">'+newsItem.description+'</textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" id="link' + newsid + '" name="link' + newsid + '" style="width:130px" maxlength="150">'+newsItem.linkUrl+'</textarea>');
            itemobj.push('</i><i class="i-spacing-follow" >');
            itemobj.push('<a href="javascript:void(0);" onclick="f_openUploadImgWindow(\''+newsid+'\');">添加图片</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_selectProd(\''+newsid+'\');">选择产品</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_delNewsItem(\''+newsid+'\');">删除</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_goBefore(\''+newsid+'\');">上</a>');
            itemobj.push('<a href="javascript:void(0);" style="margin-left:10px" onclick="f_goAfter(\''+newsid+'\');">下</a>');
            itemobj.push('</i></li>');
            
            $("#newsitem-hd").parent().append(itemobj.join(''));
            
       	}else{
       		
            if ($("#newsitem-hd").parent().find("[id^=newsid]").size() > 4) {
                $.ligerDialog.error('最多只能添加5个图文消息');
                return;
            }
            var newsid = Math.uuid();
            var itemobj = [];
            itemobj.push('<li id="newsid' + newsid + '" style="height:80px;border-bottom:1px solid #333">');
            itemobj.push('<i class="i-spacing-follow"  style="width:100px;">');
            itemobj.push('<img id="img'+newsid+'" src="${ctx}/images/nopic.jpg" style="width:80px;height:80px" />');
            itemobj.push('<input type="hidden" id="hidimg' + newsid + '" name="hidimg' + newsid + '" />');
            itemobj.push('<input type="hidden" id="addimg' + newsid + '" name="addImg' + newsid + '" value="false" />');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="2" id="title' + newsid + '" name="title' + newsid + '" style="width:130px"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" name="desc' + newsid + '" id="desc' + newsid + '" style="width:130px"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" id="link' + newsid + '" name="link' + newsid + '" style="width:130px"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow" >');
            itemobj.push('<a href="javascript:void(0);" onclick="f_openUploadImgWindow(\''+newsid+'\');">添加图片</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_selectProd(\''+newsid+'\');">选择产品</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_delNewsItem(\''+newsid+'\');">删除</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_goBefore(\''+newsid+'\');">上</a>');
            itemobj.push('<a href="javascript:void(0);" style="margin-left:10px" onclick="f_goAfter(\''+newsid+'\');">下</a>');
            itemobj.push('</i></li>');
            
            $("#newsitem-hd").parent().append(itemobj.join(''));
        }


    }
    function f_delNewsItem(itemid) {
    	$("#newsid"+itemid).remove();
    	selitemid="";
    	
    }
    function showExcludeContentContainer(ctPrefix, ctIndex) {
        for (var i = 0; i <= 1; i++) {
            $("#" + ctPrefix + i).hide();
            if (i == ctIndex) {
                $("#" + ctPrefix + i).show();
            }
        }
    }

    function f_openUploadImgWindow(itemid) {
    	selitemid = itemid;
        updialog = $.ligerDialog.open({
            target: $("#uploadImgDiv"),
            title: '图片上传',
            width: 400,
            height: 250
        });
    }
    function f_closeUploadImgWindow() {
        updialog.hide();
        $("#imgFile").val("");
    }

    function f_saveImg() {
        var imgfile = $.trim($("#imgFile").val());
        if (imgfile == "" || !j4tg.isImgFile(imgfile)) {
            $.ligerDialog.error('请选择图片文件');
            return;
        }

        $.ajaxFileUpload({
            url: '${ctx}/owner/wUploadWechatMessageImg.action',
            data: {},
            secureuri: false,
            fileElementId: 'imgFile',
            dataType: 'json',
            success: function(data, status) {
                if (data.status == "S") {
                    f_closeUploadImgWindow();
                    $.ligerDialog.success('上传成功');
                    $("#addimg"+selitemid).val(true);
                    $("#hidimg"+selitemid).val(data.respData.imgUrl);
                    if(!j4tg.isUrl(data.respData.imgUrl)){
                    	$("#img"+selitemid).attr("src","${imgCtx}/"+data.respData.imgUrl);
                    }else{
                    	$("#img"+selitemid).attr("src",data.respData.imgUrl);
                    }
               

                } else {
                	$.ligerDialog.error(data.message);
                }
            },
            error: function(data, status, e) {

			}
        });
    }

    function f_selectProd(itemid) {
    	selitemid = itemid;
        $.ligerDialog.open({
            title: '选择产品',
            name: 'winselector',
            width: 650,
            height: 350,
            url: '${ctx}/owner/wListSearchCompProds.action?prodSearch.productName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectProdOK
            },
            {
                text: '取消',
                onclick: f_selectProdCancel
            }]
        });
        return false;
    }
    function f_selectProdOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
        	$.ligerDialog.error('请选择产品!');
            return;
        }

        $("#title"+selitemid).val(data.prodName);
        $("#desc"+selitemid).val(data.prodName);
        $("#hidimg"+selitemid).val(data.firstProdImg);
        $("#addimg"+selitemid).val(false);
        if(!j4tg.isUrl(data.firstProdImg)){
        	$("#img"+selitemid).attr("src","${ctx}/"+data.firstProdImg);
        }else{
        	$("#img"+selitemid).attr("src",data.firstProdImg);
        }
        //alert(JSON.stringify(data));
        
        
        for(var key in data.prodExternals){
            var prodext = data.prodExternals[key];
			if("murl"==prodext.externalName){
				$("#link"+selitemid).val("http://"+window.location.host+"${ctx}/mobile/index.html#/detailed?proNum="+data.prodNum);
				break;
			}
        }
        if(data.prodExternals == ""){
        	$("#link"+selitemid).val("http://"+window.location.host+"${ctx}/mobile/index.html#/detailed?proNum="+data.prodNum);
        }
        dialog.close();
    }
    function f_selectProdCancel(item, dialog) {
        dialog.close();
    }

    function f_goBefore(itemid) {
        var currItem = $("#newsid"+itemid);
        var prevItem = currItem.prev();
        if (prevItem.is('li')&&prevItem.attr("id")!="newsitem-hd") {
        	prevItem.before(currItem);
        }
    }
    function f_goAfter(itemid) {
        var currItem = $("#newsid"+itemid);
        var afterItem = currItem.next();
        if (afterItem.is('li')) {
        	afterItem.after(currItem);
        }
    }

    function f_saveWechatMessage() {
    	var messageId = $("#hidMessageId").val();
        var subject = $.trim($("#subject").val());
        var replyKey = $.trim($("#replyKey").val());
        var messageType = $.trim($('#messageTypeContainer input:radio[name="messageType"]:checked').val());
        var errors = [];
        var param = {};
        if (string.isInvalid(subject)) {
        	errors.push('消息概要不能为空');
        }
        param["wechatMessage.messageId"] = messageId;
        param["wechatMessage.subject"] = subject;
        param["wechatMessage.messageType"] = messageType;
        param["wechatMessage.replyKey"] = replyKey;
        if (messageType == 0) {
        	messageText = $.trim($("#messageText").val());
            if (string.isInvalid(messageText)) {
            	errors.push('文本消息内容不能为空');
            }else{
            	param['wwechatMessageItems[0].wechatMessageDatas[0].itemNum'] = 0;
            	param['wwechatMessageItems[0].wechatMessageDatas[0].dataName'] = 'messageText';
            	param['wwechatMessageItems[0].wechatMessageDatas[0].dataValue'] = messageText;
            }
        }else if(messageType == 1) {
            var newsobjs = $("#newsitem-hd").parent().find("[id^=newsid]");
			
			if(newsobjs.length>0){
	            for (var i = 0; i < newsobjs.length; i++) {
	
	                var newsid = newsobjs[i].id.replace("newsid", "");
	                var addimg = "wwechatMessageItems[" + i + "].addImg";
	                var addimgvalue = $.trim($("#addimg" + newsid).val());
	                param[addimg] = addimgvalue;
	                
	                var datanamevalue0 = "title";
	                var datavaluevalue0 = $.trim($("#title" + newsid).val());
	
	                var datanamevalue1 = "imgUrl";
	                var datavaluevalue1 = $.trim($("#hidimg" + newsid).val());
	
	                var datanamevalue2 = "linkUrl";
	                var datavaluevalue2 = $.trim($("#link" + newsid).val());
	
	                var datanamevalue3 = "description";
	                var datavaluevalue3 = $.trim($("#desc" + newsid).val());

					/* if(string.isInvalid(datavaluevalue0)
							||string.isInvalid(datavaluevalue1)
							||string.isInvalid(datavaluevalue3)
							||(!string.isInvalid(datavaluevalue2)&&!j4tg.isUrl(datavaluevalue2))){
						errors.push("明细"+(i+1)+"存在无效内容或非法链接地址");
	
					} */
	                
	
	                for (var j = 0; j <4; j++) {
	                	eval("param['wwechatMessageItems[" + i + "].wechatMessageDatas["+j+"].itemNum'] = "+(i+1));
	                	eval("param['wwechatMessageItems[" + i + "].wechatMessageDatas["+j+"].dataName'] = datanamevalue"+j);
	                	eval("param['wwechatMessageItems[" + i + "].wechatMessageDatas["+j+"].dataValue'] = datavaluevalue"+j);
	                }
	            }
	            
			}else{

				errors.push('请添加图文消息明细');
			}
            
       	}else{
       		return;
       	}

        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }
        
        j4tg.ajaxPost("${ctx}/owner/wSaveEditWechatMessage.action", "json", false, param,
        function(data) {
            if (data.status == "S") {

                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListWechatMessages.action";
                

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }
</script>
</html>