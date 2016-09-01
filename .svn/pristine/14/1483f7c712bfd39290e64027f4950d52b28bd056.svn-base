<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>推送信息列表</title> 
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
            <div id="searchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-follow">
                            推送开始日期:
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="sendTimeFrom" />
                        </i>
                        <i class="i-spacing-follow">
                           推送结束日期:
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="sendTimeTo" />
                        </i>
                         <i class="i-spacing-first">
                            推送状态：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="processStatus" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchPushMessage" type="button" value="搜&nbsp;&nbsp;索" style="width:66px;" onclick="f_searchPushMessage()"
                            />
                        </i>
                        <input type="hidden" id="hidProcessStatus" value="-1" />
                        <input type="hidden" id="hidCustNum" />
                        <input type="hidden" id="hidCompanyName" value="" />
                        <input type="hidden" id="hidSendTimeFrom" />
                        <input type="hidden" id="hidSendTimeTo" />
                    </li>
                </ul>
            </div>
            <br/>
            <br/>
					<div class="bcolor borderradius adminico" style="margin-left:7rem;">
				<a name="addPushMessage" href="${ctx}/owner/wEditPushMessage.action" id="addPushMessage">
						<img src='${ctx}/images/ico/createtnew.png' alt='创建推送消息' title='创建推送消息'/>
				</a>
					</div>
            <div id="maingrid">
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
        $.expandAccordionMenu("pushmenu");
        $("#processStatus").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidProcessStatus'
        });
        $("#sendTimeFrom").ligerDateEditor({
            cancelable: false
        });
        $("#sendTimeTo").ligerDateEditor({
            cancelable: false
        });
        f_initPushMessagesDataGrid();
        f_initPushMessageSearchData();


    }); 

    function f_searchPushMessage() {
        var companyname = $.trim($("#companyName").val());
        var sendTimeFrom = liger.get("sendTimeFrom").inputText.val();
        var sendTimeTo = liger.get("sendTimeTo").inputText.val();
        var processstatus = liger.get("processStatus").getValue();

        if (string.isInvalid(companyname)) {
            $("#hidCustNum").val("");
        }
        var fromtime = Date.parse(sendTimeFrom);
        var totime = Date.parse(sendTimeTo); 
        if (totime < fromtime) {
            alert("结束时间不能小于开始日期");
            return;
        }

        $("#hidCompanyName").val(companyname);
        $("#hidSendTimeFrom").val(sendTimeFrom);
        $("#hidSendTimeTo").val(sendTimeTo);
        $("#hidProcessStatus").val(processstatus);
        $.reloadGridServerData(g, f_getPushMessagesParam());
    }

    function f_getPushMessagesParam() {
        var companyname = $("#hidCompanyName").val();
        var sendtimefrom = $("#hidSendTimeFrom").val();
        var sendtimeto = $("#hidSendTimeTo").val();
        var processstatus = $("#hidProcessStatus").val();

        
        
            
        var param = {
            "pushMessageSearch.sendTimeFrom": sendtimefrom,
            "pushMessageSearch.sendTimeTo": sendtimeto,
            "pushMessageSearch.processStatus": processstatus
        };
        return param;

    }

    function f_initPushMessageSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListPushMessagesSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("processStatus").setData($.transformMap2ComboBoxData(data.respData.processStatus, -1));

            }
        },
        function(data) {

		});

    }

    function f_initPushMessagesDataGrid() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '消息类型',
                name: 'messageTypeName',
                isSort: false,
                width: 60
            },
            {
                display: '发送类型',
                name: 'targetTypeName',
                width: 100
            },
            {
                display: '发送目标',
                name: 'targetDesc',
                isSort: false,
                align: 'left',
                width: 200,
                
            },
            {
                display: '主题',
                name: 'title',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '内容',
                name: 'content',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '发送时间',
                name: 'sendTime',
                type: 'date',
                format: 'yyyy-MM-dd hh:mm:ss',
                width: 150, 
                editor: { type: 'date',
                showTime: true,
                cancelable: false}
            },
            {
                display: '处理状态',
                name: 'processStatusName',
                width: 80
            },
            {
                display: '更新日期',
                name: 'updateDate',
                width: 100
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    if (!rowdata._editing) {
                        if (rowdata.processStatus == 0) {
                        	h += "<a href='${ctx}/owner/wEditPushMessage.action?messageId=" + rowdata.messageId + "'><img src='${ctx}/images/ico/modification.png'/></a> ";
    	                    h += "<a href='javascript:void(0);' onclick='javascript:f_deletePushMessage(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png'/></a> ";
                        }
                    } else {
                        h += "<a href='javascript:void(0);' onclick='javascript:f_updateSendTime(" + rowindex + ")'><img src='${ctx}/images/ico/save.png'/></a> ";
                        h += "<a href='javascript:f_cancelUpdateSendTime(" + rowindex + ")'>取消</a> ";
                    }
                    return h;

                }
            }],
            url: "${ctx}/owner/wListPushMessagesData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getPushMessagesParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1290,
            columnWidth: 120,
            allowHideColumn: false,
            detail: {
                onShowDetail: f_showPushMessageResultsData,
                height: 'auto'
            }
        });

    }

 

    function f_reSendPushMessage(rowid) {

        var pushMessage = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要重新发送么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wreSendPushMessage.action", "json", false, {
                    "messageId": pushMessage.messageId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('操作成功');
                        $.reloadGridServerData(g, f_getPushMessagesParam());
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_deletePushMessage(rowid) {

        var pushMessage = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelPushMessage.action", "json", false, {
                    "messageId": pushMessage.messageId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, f_getPushMessagesParam());
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_showPushMessageResultsData(row, detailPanel, callback) {
        var grid = document.createElement('div');
        $(detailPanel).append(grid);
        $(grid).css('margin', 10).ligerGrid({
            columns: [{
                display: '推送结果码',
                name: 'errorCode',
                isSort: false,
                width: 100
            },
            {
                display: '推送结果信息',
                name: 'errorMessage',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '推送结果状态',
                name: 'resultStatusName',
                isSort: false,
                width: 300
            },
            {
                display: '结果消息编号',
                name: 'jpushMessageId',
                isSort: false,
                align: 'left',
                width: 150
            },
            {
                display: '返回日期',
                name: 'createDate',
                isSort: false,
                align: 'left',
                width: 100
            }],
            isScroll: false,
            showToggleColBtn: false,
            width: 670,
            data: f_getPushMessageResultsData(row.messageId),
            clickToEdit: false,
            showTitle: false,
            enabledEdit: false,
            columnWidth: 100,
            onAfterShowData: callback,
            frozen: false,
            usePager: false,
            allowHideColumn: false
        });
    }

    function f_getPushMessageResultsData(messageId) {
        var jsonData = {
            Rows: []
        };
        var param = {
            "messageId": messageId
        }
        j4tg.ajaxPost("${ctx}/owner/wGetPushMessageResults.action", "json", false, param,
        function(data) {
            jsonData.Rows = data.respData;
        },
        function(data) {

		});
        return jsonData;

    }

    function f_beginUpdateSendTime(rowid) {
        manager.beginEdit(rowid);
    }
    function f_cancelUpdateSendTime(rowid) {
        manager.cancelEdit(rowid);
    }

    function f_updateSendTime(rowid) {

    	var sendTime = $.getGridEditColumnData(g, rowid, 'sendTime');
		
    	var sendtime = Date.parse(sendTime);
        var nowtime = Date.parse(new Date().format("yyyy-MM-dd hh:mm:ss"));
        if (sendtime < nowtime) {
            alert("推送时间不能小于当前日期");
            return;
        }

        manager.endEdit(rowid);
        var pushMessage = manager.getRow(rowid);
        var param = {
            "pushMessage.messageId": pushMessage.messageId,
            "pushMessage.sendTime": pushMessage.sendTime
        }
        j4tg.ajaxPost("${ctx}/owner/wUpdateSendTime.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                $.reloadGridServerData(g, f_getPushMessagesParam());

            }
        },
        function(data) {

		});

    }
</script>
</html>