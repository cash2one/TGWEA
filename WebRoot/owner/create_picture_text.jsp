<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑群发信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerRadio.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerDateEditor.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>

<script src="${ctx}/ueditor1_4_3-utf8-jsp/ueditor.config.js" type="text/javascript"></script>
<script src="${ctx}/ueditor1_4_3-utf8-jsp/ueditor.all.min.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
        <div style="padding-top:2rem;padding-bottom:2rem;padding-left:5rem;font-size:2rem;">编辑群发消息</div>
        	<form name="wechatMessageForm" method="post" id="wechatMessageForm">
        	<div style="padding-left:0.5rem;" id="miaoshu"><i class="i-spacing-first">这条消息描述:</i><i class="i-spacing-follow"><input type="text" id="msgDescribe" placeholder="例如：通知新品上市时间" required="required"/></i>
        	<br/></div>
            <div><input name="hidMassMessageId" type="hidden" id="hidMassMessageId" value="<s:property value=" #parameters.massMessageId[0] " />" />
            </div>
            <ul>
                <li id="messageTypeCt1" class="li-line">
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
                                        <img src="../images/adminBP/add_group.webp" alt="添加" title="添加"/>
                                        </a>
                                    </i>
                                </li><br/>
                                <li id="newsitem-hd" style="height:25px;background:#eee;width:1050px;">
                                    <i class="i-spacing-follow" style="width:150px;text-align:center;">
                                        图片
                                    </i>
                                   
                                    <i class="i-spacing-follow" style="width:150px;text-align:left;">
                                        标题
                                    </i>
                                    <i class="i-spacing-follow" style="width:70px">
                                        作者(可为空)
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px;text-align:center;">
                                        描述(可为空)
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px;text-align:center;">
                                        链接地址(可为空)
                                    </i>                                    
                                    <i class="i-spacing-follow" style="width:150px;text-align:center;">
                                        文字内容
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
        <div id="textEditor" style="display:none;margin:0rem 0rem 0rem 25%;padding-top:7rem;">
        <script id="editor" type="text/plain" style="width:800px;height:300px;"></script>
        <div style="width:800px;padding-top:2rem;position:absolute;z-index:9999;text-align:center;">
                    <input type="submit" value="保存" id="saveTextEditor" name="saveImg" class="button-submit" onclick="contect();"/>
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel" onclick="javascript:hideTextEditor();"/>
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
        </div><input type="hidden" id="cnt"/><input type="hidden" id="hidimgid"/>
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
var selitemid;
var isInvalid3=string.isInvalid($("#hidMassMessageId").val())
if(!isInvalid3){
	$("#miaoshu").hide();
}


var ue = UE.getEditor('editor');
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

    function contect(){
    	var arr = [];
    	 arr.push(UE.getEditor('editor').hasContents());
         var istrue = arr.join("\n");
         
    	if(istrue === "true"){
    		 var arr1 = [];
    	        arr1.push(UE.getEditor('editor').getContent());
    	        var number=$("#cnt").val();
    	        $("#content"+number).html(arr1.join("\n"));
    	        $("#textEditor").hide();
    		$.ligerDialog.success('保存成功');
    	}else{
    		alert("请编辑文字内容或点击取消");
    	}
    }
    function f_initEditWechatMessageData() {
        var mpnewId = $("#hidMassMessageId").val();
        j4tg.ajaxPost("${ctx}/owner/wGetPictureTextData.action", "json", false, {
            "mpnewId": mpnewId
        },
        function(data) {
            if (data.status == "S") {
            	
                        // alert(JSON.stringify(data));
                   var rdata=data.respData.wechatPictureTexts;
                  var len = rdata.length;
                                            	
                if (len > 0) {
	                   	 var accessToken = data.respData.accessToken;
	                   	 
	                   	  for (var i = 0;i < len;i++) {
	                   		 
	                   		 var newsid = Math.uuid();
	                         var itemobj = [];
	                         itemobj.push('<input type="hidden" id="ids' + newsid + '" name="ids' + newsid + '" value="'+rdata[i].mpnewsId+'"/>');
	                         itemobj.push('<li id="newsid' + newsid + '" style="height:80px;border-bottom:1px solid #333">');
	                         itemobj.push('<i class="i-spacing-follow"  style="width:100px;">');
	                         
	                         itemobj.push('<img id="img'+newsid+'" src="');
                             itemobj.push('http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=');
                             itemobj.push(accessToken);
                             itemobj.push('&media_id=');
                             itemobj.push(rdata[i].thumbMediaId);
                             itemobj.push('" style="width:60px;height:60px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
	                         
	                         itemobj.push('<input type="hidden" id="thumbMediaId' + newsid + '" name="thumbMediaId' + newsid + '" value="'+rdata[i].thumbMediaId+'"/>');
	                         itemobj.push('<input type="hidden" id="addimg' + newsid + '" name="addImg' + newsid + '" value="false" />');
	                         itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
	                         itemobj.push('<textarea cols="50" rows="2" id="title' + newsid + '" name="title' + newsid + '" style="width:130px" maxlength="50">'+rdata[i].title+'</textarea>');
	                         itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
	                         itemobj.push('<textarea cols="100" rows="3" id="author' + newsid + '" name="author' + newsid + '" style="width:130px" maxlength="50">'+rdata[i].author+'</textarea>');
	                         itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
	                         itemobj.push('<textarea cols="50" rows="3" id="desc' + newsid + '" name="desc' + newsid + '" style="width:130px" maxlength="50">'+rdata[i].digest+'</textarea>');
	                         itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
	                         itemobj.push('<textarea cols="50" rows="3" id="link' + newsid + '" name="link' + newsid + '" style="width:130px" maxlength="50">'+rdata[i].contentSourceUrl+'</textarea>');
	                         itemobj.push('</i><i class="i-spacing-follow"  style="width:95px;text-align:center;">');
	                         var nid=newsid;
	                         itemobj.push('<br/><input type="button" onclick="f_openTextEditorWindow(\''+newsid+'\',\''+nid+'\');" value="编辑内容"/><div style="display:none;" id="content' + nid + '">'+rdata[i].content+'</div> ');
	                         itemobj.push('</i><i class="i-spacing-follow" >');
	                         itemobj.push('<a href="javascript:void(0);" onclick="f_openUploadImgWindow(\''+newsid+'\');">添加图片</a><br/>');
	                         itemobj.push('<a href="javascript:void(0);" onclick="f_selectProd(\''+newsid+'\');">选择产品</a><br/>');
	                         itemobj.push('<a href="javascript:void(0);" onclick="f_delNewsItem(\''+newsid+'\');">删除</a><br/>');
	                         itemobj.push('</i></li>');
	                         
	                         $("#newsitem-hd").parent().append(itemobj.join(''));
	                	 }
                       
                }


            }
        },
        function(data) {

		});

    }


    function f_addNewsItem(newsItem) {
            if ($("#newsitem-hd").parent().find("[id^=newsid]").size() > 4) {
                $.ligerDialog.error('最多只能添加5个图文消息');
                return;
            }
            var newsid = Math.uuid();
            var ok=1;
            var itemobj = [];
            itemobj.push('<li id="newsid' + newsid + '" style="height:80px;border-bottom:1px solid #333">');
            itemobj.push('<i class="i-spacing-follow"  style="width:100px;">');
            itemobj.push('<img id="img'+newsid+'" src="${ctx}/images/nopic.jpg" style="width:80px;height:80px" />');
            itemobj.push('<input type="hidden" id="thumbMediaId' + newsid + '" name="thumbMediaId' + newsid + '" />');
            itemobj.push('<input type="hidden" id="addimg' + newsid + '" name="addImg' + newsid + '" value="false" />');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="2" id="title' + newsid + '" name="title' + newsid + '" style="width:130px" maxlength="50"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="2" id="author' + newsid + '" name="author' + newsid + '" style="width:130px" maxlength="50"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" name="desc' + newsid + '" id="desc' + newsid + '" style="width:130px" maxlength="50"></textarea>');
            itemobj.push('</i><i class="i-spacing-follow"  style="width:150px;">');
            itemobj.push('<textarea cols="50" rows="3" id="link' + newsid + '" name="link' + newsid + '" style="width:130px" maxlength="50"></textarea>');
            
            itemobj.push('</i><i class="i-spacing-follow"  style="width:95px;text-align:center;">');
            itemobj.push('<br/><input type="button" onclick="f_openTextEditorWindow(\''+newsid+'\',\''+ok+'\');" value="编辑内容"/><div style="display:none;" id="content' + newsid + '"></div> ');
           
            itemobj.push('</i><i class="i-spacing-follow" >');
            itemobj.push('<a href="javascript:void(0);" onclick="f_openUploadImgWindow(\''+newsid+'\');">添加图片</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_selectProd(\''+newsid+'\');">选择产品</a><br/>');
            itemobj.push('<a href="javascript:void(0);" onclick="f_delNewsItem(\''+newsid+'\');">删除</a><br/>');
            itemobj.push('</i></li>');
            
            $("#newsitem-hd").parent().append(itemobj.join(''));

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

    function f_openTextEditorWindow(itemid,content) {
    	$("#cnt").val("");
    	$("#cnt").val(itemid);
    	 UE.getEditor('editor').setContent($("#content"+itemid).html());
    	$("#textEditor").show();
    }
    function hideTextEditor() {
    	$("#textEditor").hide();
    }
    function f_openUploadImgWindow(itemid) {
    	$("#hidimgid").val(itemid);
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
            url: '${ctx}/owner/wUploadPictureTextImg.action',
            data: {},
            secureuri: false,
            fileElementId: 'imgFile',
            dataType: 'json',
            success: function(data, status) {
                
                if (data.status == "S") {
                    f_closeUploadImgWindow();
                    $.ligerDialog.success('上传成功');
                    $("#addimg"+selitemid).val(true);
                    $("#thumbMediaId"+selitemid).val(data.respData.mediaId);
                    
                    data.respData.imgUrl = data.respData.imgUrl.replace("&amp;","&");
                    document.getElementById("img"+selitemid).src = data.respData.imgUrl;

                } else {
                	$.ligerDialog.error(data.message);
                }
            },
            error: function(data, status, e) {

			}
        });
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
        var messageType = 1;
        var errors = [];
       if(isInvalid3){
        if($("#msgDescribe").val().trim() == ""){
        	alert("请填写最上面一栏的消息描述");
        	return;
        }
       }
        
        var param = {
                "massMessageId": $("#hidMassMessageId").val(),
                "wechatDescribe": $("#msgDescribe").val()
            };
        
        if (messageType == 0) {
        }else if(messageType == 1) {
            var newsobjs = $("#newsitem-hd").parent().find("[id^=newsid]");
			
			if(newsobjs.length>0){
	            for (var i = 0; i < newsobjs.length; i++) {
	
	                var newsid = newsobjs[i].id.replace("newsid", "");
	                
	                if($("#img" + newsid).attr("src").indexOf("/images/nopic.jpg") >= 0){
	                	errors.push("第"+(i+1)+"条数据，图片失效，请重新上传");
	                }
	                
	                var datavaluevalue0 = $.trim($("#title" + newsid).val());
	
	                var datavaluevalue1 = $.trim($("#thumbMediaId" + newsid).val());
	
	                var datavaluevalue2 = $.trim($("#link" + newsid).val());
	
	                var datavaluevalue3 = $.trim($("#desc" + newsid).val());
	                var datavaluevalue4 = $.trim($("#content" + newsid).html());
	                var datavaluevalue5 = $.trim($("#author" + newsid).val());
	                var datavaluevalue6 = $.trim($("#ids" + newsid).val());


					if(!string.isInvalid(datavaluevalue2) && !j4tg.isUrl(datavaluevalue2)){
						errors.push("第"+(i+1)+"条数据，链接地址有误。");
					}
					if(string.isInvalid(datavaluevalue0)){
						errors.push("请填写第"+(i+1)+"条数据的标题");
					}
					if(string.isInvalid(datavaluevalue1)){
						errors.push("请上传第"+(i+1)+"条数据的展示图片");
					}
					if(string.isInvalid(datavaluevalue4)){
						errors.push("请填写第"+(i+1)+"条数据的文字内容");
					}
					
				            var title = "wechatMassMpnews[" + i + "].title";
				            var thumbMediaId = "wechatMassMpnews[" + i + "].thumbMediaId";
				            var contentSourceUrl = "wechatMassMpnews[" + i + "].contentSourceUrl";
				            var digest = "wechatMassMpnews[" + i + "].digest";
				            var content = "wechatMassMpnews[" + i + "].content";
				            var author = "wechatMassMpnews[" + i + "].author";
				            var ids = "wechatMassMpnews[" + i + "].ids";

				            var ptitle = $.trim($("#title" + newsid).val());
				            var pthumbMediaId = $.trim($("#thumbMediaId" + newsid).val());
				            
				            var pcontent = $.trim($("#content" + newsid).html());
				            
				            var pauthor = $.trim($("#author" + newsid).val());
				            var pids = $.trim($("#ids" + newsid).val());
				            
				                param[title] = ptitle;
				                param[thumbMediaId] = pthumbMediaId;
				                param[contentSourceUrl] = datavaluevalue2;
				                param[digest] = datavaluevalue3;
				                param[content] = pcontent;
				                param[author] = pauthor;
				                param[ids] = pids;
				     
	           		  
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
      
       
        
        var whichUrl="";
        var isInvalid=string.isInvalid($("#hidMassMessageId").val())
        if(isInvalid){
        	whichUrl="${ctx}/owner/wSavePictureText.action";//保存
        }else{
        	whichUrl="${ctx}/owner/wUpdatePictureText.action";//更新
        }
        
        j4tg.ajaxPost(whichUrl, "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('编辑成功');
                location.href = "${ctx}/owner/wListPictureText.action";
            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

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
        	$("#img"+selitemid).attr("src","${imgCtx}/"+data.firstProdImg);
        }else{
        	$("#img"+selitemid).attr("src",data.firstProdImg);
        }
        //alert(JSON.stringify(data));
        
        
        for(var key in data.prodExternals){
            var prodext = data.prodExternals[key];
			if("murl"==prodext.externalName){
        	$("#link"+selitemid).val("http://"+window.location.host+"${ctx}/mobile/index.html#/detailed?proNum="+data.prodNum);
				$("#content"+selitemid).html("<img src='"+data.firstProdImg+"'/><br/><br/>点击左下角[阅读原文]选购此商品");
				break;
			}
        }
        if(data.prodExternals == ""){
        	$("#link"+selitemid).val("http://"+window.location.host+"${ctx}/mobile/index.html#/detailed?proNum="+data.prodNum);
        	
        	$("#content"+selitemid).html("<img src='${imgCtx}/"+data.firstProdImg+"'/><br/><br/>点击左下角[阅读原文]选购此商品");
        }
        dialog.close();
        
       /* 这里上传图片到微信服务器 */
       
       var imgAdress = document.getElementById("img"+selitemid).src;
       
       if(imgAdress == ""){
    	   alert("请先上传这个产品的图片，再保存。避免微信里不显示图片");
       }else{
	    	   var paramsNo = {
	          		 "productImgUrl": document.getElementById("img"+selitemid).src
	         };
	           var wechatUrl = "${ctx}/owner/uploadImageToWechat.action";
	          j4tg.ajaxPost(wechatUrl, "json", false, paramsNo,
	          function(data) {
	              if (data.status == "S") {
	              	console.log("id= ",data.respData);
	              	$("#thumbMediaId"+selitemid).val(data.respData);
	              } else {
	                  $.ligerDialog.error("上传图片到微信服务器时出现问题，请重试  ***** "+data.message);
	              }
	
	          },
	          function(data) {
	
	  		});
       }
       
       
       
       
       /* 这里上传图片到微信服务器 */
        
        
    }
    function f_selectProdCancel(item, dialog) {
        dialog.close();
    }
    
</script>
</html>