<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>群发消息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerDateEditor.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div> <br/>
        <div id="maincontent" position="center" title=" ">
             <br/>
	 <div class="bcolor borderradius adminico" style="margin-left:5rem;"><a name="addWechatMessage" href="${ctx}/owner/wCreatePictureText.action" id="addWechatMessage"><img src='${ctx}/images/ico/createnews.png' alt='创建微站消息' title='创建微站消息'/></a></div>
            <br/>
            <div id="maingrid">
            </div>
        </div>
        <input type="hidden" id="hidMessageType" value="-1" />
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
        f_initWechatMessageDataGrid();
    }); 


    function f_initWechatMessageDataGrid() {

        g = manager = $("#maingrid").ligerGrid({ 
            columns: [{
                display: 'id',
                name: 'massMessageId',
                isSort: false,
                width: 50,
                frozen: true
                
            },{
                display: '消息类型',
                isSort: false,
                width: 200,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (rowdata.msgType == 0) {
                        h += "图文消息";
                    } else {
                        h += rowdata.msgType;
                    }
                    return h;
                }
            },
            {
                display: '概述',
                name: 'wechatSubject',
                isSort: false,
                align: 'left',
                width: 300,
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
                display: '发送状态',
                name: 'wechatMassMsgRequest.processStatus',
                isSort: false,
                width: 100
                /* ,
                render: function(rowdata, rowindex, value) {
                	alert("fasongzt "+rowdata.wechatMassMsgRequest.processStatus);
                	  var h = "";
                	  var xvalue=rowdata.wechatMassMsgRequest.processStatus;
                      if (xvalue == 0) {
                          h += "未发送";
                      } else if(xvalue==1){
                          h += "已发送";
                      }else if(xvalue==2){
                          h += "已重复";
                      }
                      return h;
                    } */
            },
            {
                display: '发送结果',
                name: 'wechatMassMsgRequest.requestErrorCode',
                isSort: false,
                width: 100
            },
            {
                display: '返回状态',
                name: 'wechatMassMsgRequest.responseStatus',
                isSort: false,
                width: 100
            },
            {
                display: '失败数量',
                name: 'wechatMassMsgRequest.responseErrorCount',
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
                	h += "<a href='javascript:f_beginSendWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/qunfa.png' alt='' title='群发'/></a> ";
                   	h += "<a href='${ctx}/owner/wCreatePictureText.action?massMessageId=" + rowdata.massMessageId + "'><img src='${ctx}/images/ico/modification.png' alt='修改' title='修改'/></a> ";
                    h += "<a href='javascript:void(0);' onclick='javascript:f_deleteWechatMessage(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png' alt='删除' title='删除'/></a> ";
                }
                return h;

                
                    var h = "";
                    

                    return h;

                }
            }],
            url: "${ctx}/owner/wListWechatMassMessageData.action",
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
            width: 1160,
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

        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {
                j4tg.ajaxPost("${ctx}/owner/wDelWechatPictureText.action", "json", false, {
                    "massMessageId": manager.getRow(rowid).massMessageId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g);
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_beginSendWechatMessage(rowid){

    	
    	 $.ligerDialog.confirm('确定要发送吗?',
    		        function(yes) {
    		            if (yes) {
    		            	var wechatMessage = manager.getRow(rowid);
    		            	
    		            	var param = {
    		                        "massMessageId": wechatMessage.massMessageId
    		                };
    		                
    		            	j4tg.ajaxPost("${ctx}/owner/wSendWechatMessages.action", "json", false, param,
    		                function(data) {
    		                    if (data.status == "S") {
    		                        $.ligerDialog.success('已发送');
    		                        $.reloadGridServerData(g);
    		                    }
    		                },
    		                function(data) {

    		        		});

    		            }
    		        });
    	
    	
    }

    function f_showWechatMessageData(row, detailPanel, callback) {
    	 var massMessageId = row['massMessageId'];
    	 
         var contentdiv = document.createElement('div');
         $(detailPanel).append(contentdiv);
         var jqcontentdiv = $(contentdiv);
         jqcontentdiv.css("width","650px");
         j4tg.ajaxPost("${ctx}/owner/wGetPictureTextData.action", "json", false, {"mpnewId":massMessageId},
                 function(data) {
                     if (data.status == "S") {
                                     			//	alert(JSON.stringify(data));
                                     			
                        	 var rdata=data.respData.wechatPictureTexts;
                            var len = rdata.length;
                            	
                        if (len > 0) {
                        	 
                        	 var accessToken=data.respData.accessToken;
                            	
                            	 jqcontentdiv.append('<ul style="width:900px;height:30px;float:left;margin-left:30px;margin-top:10px;border-bottom:1px solid #333;background:#eee"><li><i class="i-spacing-follow" style="width:80px;" >图片</i><i class="i-spacing-follow" style="width:200px" >标题</i><i class="i-spacing-follow" style="width:250px" >连接地址</i><i class="i-spacing-follow" style="width:250px" >描述</i></li></ul>');
                            	 for (var i = 0;i < len;i++) {
                                     var msgobj = [];
                                     msgobj.push('<ul style="width:900px;float:left;margin-left:30px;margin-top:10px;border-bottom:1px solid #333"><li>');
                                     msgobj.push('<i class="i-spacing-follow" style="width:80px;" >');
                                     msgobj.push('<img src="');
                                     msgobj.push('http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=');
                                     msgobj.push(accessToken);
                                     msgobj.push('&media_id=');
                                     msgobj.push(rdata[i].thumbMediaId);
                                     msgobj.push('" style="width:60px;height:60px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
                                     msgobj.push('</i><i class="i-spacing-follow" style="width:200px;height:60px;overflow:hidden;" >');
                                     msgobj.push(rdata[i].title);
                                     msgobj.push('</i><i class="i-spacing-follow" style="width:250px;height:60px;overflow:hidden;" >');
                                     msgobj.push(rdata[i].contentSourceUrl);
                                     msgobj.push('</i><i class="i-spacing-follow" style="width:250px;height:60px;overflow:hidden;" >');
                                     msgobj.push(rdata[i].digest);
                                     msgobj.push('</i></li></ul>');
                                     jqcontentdiv.append(msgobj.join(''));
                                 }

                        }

                     }
                 },
                 function(data) {

         		});
    }
    
</script>
</html>