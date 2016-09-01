<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>微站消息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerDateEditor.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="padding-left:2rem;width:59rem;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_wechatmsg.webp"/></div>
               <div id="whatfont" style="margin-left:10rem;">响应微站消息</div>
                <div class="both"></div>
               </div>
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                         <i class="i-spacing-first">
                    消息类型：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="messageType" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchWechatMessage" type="button" style="width:65px;height:28px;background-color:#e0e4e9;border-radius:5px;" value="搜&nbsp;&nbsp;索" onclick="f_searchWechatMessage()"
                            />
                        </i>
                        <i class="i-spacing-follow">
                            <div class="bcolor borderradius adminico"><a name="addWechatMessage" href="${ctx}/owner/wEditWechatMessage.action" id="addWechatMessage"><img src='${ctx}/images/ico/createnews.png' alt='创建微站消息' title='创建微站消息'/></a></div>
                        </i>
                        <input type="hidden" id="hidMessageType" value="-1" />

                    </li>
                </ul>
            </div>
            <div id="maingrid">
            </div>
        </div>
        </div>
        
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
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
    $(function() {
        $.expandAccordionMenu("wechatmenu");
        $("#messageType").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidMessageType'
        });
        f_initWechatMessageSearchData();
        f_initWechatMessageDataGrid();



    }); 

    function f_searchWechatMessage() {
        var messageType = liger.get("messageType").getValue();

        $("#hidMessageType").val(messageType);
        $.reloadGridServerData(g, f_getWechatMessageParam());
    }

    function f_getWechatMessageParam() {

        var messageType = $("#hidMessageType").val();

        var param = {
            "wechatMessageSearch.messageType": messageType
        };
        return param;

    }

    function f_initWechatMessageSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListWechatMessageSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("messageType").setData($.transformMap2ComboBoxData(data.respData.messageType, -1));

            }
        },
        function(data) {

		});

    }

    function f_initWechatMessageDataGrid() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '消息类型',
                name: 'messageTypeName',
                isSort: false,
                width: 200
            },
            {
                display: '概述',
                name: 'subject',
                isSort: false,
                align: 'left',
                width: 300,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '回复关联消息',
                name: 'replyKey',
                isSort: false,
                align: 'left',
                width: 150,
                editor: {
                    type: 'text'
                }
            },
            {
                display: '更新日期',
                name: 'updateDate',
                isSort: false,
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                width: 120,
                render: function(rowdata, rowindex, value) {
            	var h = "";
                if (!rowdata._editing) {
                	h += "<a href='javascript:f_beginUpdateWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/kg.png' alt='快速修改' title='快速修改'/></a> ";
                   	h += "<a href='${ctx}/owner/wEditWechatMessage.action?messageId=" + rowdata.messageId + "'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                    h += "<a href='javascript:void(0);' onclick='javascript:f_deleteWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";
                } else {
                    h += "<a href='javascript:void(0);' onclick='javascript:f_updateWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/save.png' alt='保存' title='保存'/></a> ";
                    h += "<a href='javascript:f_cancelUpdateWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/cancel.png' alt='取消' title='取消'/></a> ";
                }
                return h;

                
                    var h = "";
                    

                    return h;

                }
            }],
            url: "${ctx}/owner/wListWechatMessagesData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: false,
            enabledEdit: true,
            parms: f_getWechatMessageParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 905,
            columnWidth: 120,
            allowHideColumn: false,
            detail: {
                onShowDetail: f_showWechatMessageData,
                height: 'auto'
            }
        });

    }
    function f_beginUpdateWechatMessage(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateWechatMessage(rowid) {
        manager.cancelEdit(rowid);
    }
    
    function f_deleteWechatMessage(rowid) {

        var wechatMessage = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelWechatMessage.action", "json", false, {
                    "messageId": wechatMessage.messageId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getWechatMessageParam());
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_updateWechatMessage(rowid){

    	var subject = $.getGridEditColumnData(manager, rowid, 'subject');
        if (string.isInvalid(subject)) {
            $.ligerDialog.error('消息概要不能为空');
            return;
        }
        
        manager.endEdit(rowid);
        
    	var wechatMessage = manager.getRow(rowid);
    	
    	var param = {
                "wechatMessage.messageId": wechatMessage.messageId,
                "wechatMessage.subject": wechatMessage.subject,
                "wechatMessage.replyKey": wechatMessage.replyKey

        };
        
    	j4tg.ajaxPost("${ctx}/owner/wUpdateWechatMessageSubjectNReplyKey.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                $.reloadGridServerData(g, f_getWechatMessageParam());
            }
        },
        function(data) {

		});
    }

    function f_showWechatMessageData(row, detailPanel, callback) {
    	 var messageId = row['messageId'];
    	 var messageType = row['messageType'];
         var contentdiv = document.createElement('div');
         $(detailPanel).append(contentdiv);
         var jqcontentdiv = $(contentdiv);
         jqcontentdiv.css("width","650px");
         j4tg.ajaxPost("${ctx}/owner/wGetWechatMessageData.action", "json", false, {"messageId":messageId},
                 function(data) {
                     if (data.status == "S") {
                         //             				alert(JSON.stringify(data));
                         if (data.respData) {
                             if(messageType==0){
                            	 var msgobj = [];
                            	 msgobj.push('<ul style="width:650px;float:left;margin-left:30px;margin-top:10px;"><li>');
                            	 msgobj.push('<i class="i-spacing-follow" style="width:550px;" >');
                            	 msgobj.push(data.respData.messageText);
                            	 msgobj.push('</i></li></ul>');
                            	 jqcontentdiv.append(msgobj.join(''));
                             }

                             if(messageType==1){
                            	 var messageDatas = data.respData.messageDatas;
                            	 jqcontentdiv.append('<ul style="width:650px;height:30px;float:left;margin-left:30px;margin-top:10px;border-bottom:1px solid #333;background:#eee"><li><i class="i-spacing-follow" style="width:80px;" >图片</i><i class="i-spacing-follow" style="width:200px" >标题</i><i class="i-spacing-follow" style="width:250px" >描述</i></li></ul>');
                            	 for (var key in messageDatas) {
                                     var messageData = messageDatas[key];
                                     var msgobj = [];
                                     msgobj.push('<ul style="width:650px;float:left;margin-left:30px;margin-top:10px;border-bottom:1px solid #333"><li>');
                                     msgobj.push('<i class="i-spacing-follow" style="width:80px;" >');
                                     msgobj.push('<a href="');
                                     if(string.isInvalid(messageData.linkUrl)){
                                    	 msgobj.push("#");
                                     }else{
                                    	 msgobj.push(messageData.linkUrl);
                                     }
                                     msgobj.push('" target="_blank">');
                                     msgobj.push('<img src="');
                                     if(!j4tg.isUrl(messageData.imgUrl)){
                                    	 msgobj.push('${imgCtx}/');
                                     }
                                     msgobj.push(messageData.imgUrl);
                                     msgobj.push('" style="width:60px;height:60px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" /></a>');
                                     msgobj.push('</i><i class="i-spacing-follow" style="width:200px;height:60px" >');
                                     msgobj.push(messageData.title);
                                     msgobj.push('</i><i class="i-spacing-follow" style="width:250px;height:60px" >');
                                     msgobj.push(messageData.description);
                                     msgobj.push('</i></li></ul>');
                                     jqcontentdiv.append(msgobj.join(''));
                                 }
                             }

                         }

                     }
                 },
                 function(data) {

         		});
    }
</script>
</html>