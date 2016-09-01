<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>特供客户组管理</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
       <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
             <div id="beautiful">
                <div id="etitle" style="margin-bottom:1rem;">
               <div id="whereimg"><img src="../images/beautiful-page/Exclusively.png"/></div>
               <div id="whatfont">特供客户组管理</div>
                <div class="both"></div>
               </div>
			<div class="borderradius adminico" style="margin-left:33rem;"><a name="addStkAllocInv" href="${ctx}/owner/wEditGroupOfCust.action"><img src="../images/adminBP/add_group.webp" alt="添加特供客户组" title="添加特供客户组"/></a></div>
            <br/>
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
        $.expandAccordionMenu("prodmenu");
        f_showPushGroupsData();

    });

    function f_showPushGroupsData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '组名',
                name: 'groupName',
                isSort: false,
                width: 150
            },
            {
                display: '创建日期',
                name: 'createDate',
                isSort: false,
                width: 150
            },
            {
                display: '备注',
                name: 'memo',
                isSort: false,
                align: 'left',
                width: 200
            },
            {
                display: '操作',
                isSort: false,
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    h += "<a href='${ctx}/owner/wEditGroupOfCust.action?groupNum=" + rowdata.groupNum + "'><img src='${ctx}/images/ico/modification.png'/></a> ";
                    h += "<a href='javascript:f_deletePushGroup(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png'/></a> ";
                   
                    return h;

                }
            }],
            url: "${ctx}/owner/wListSearchGroupOfCustsData.action",
            method: "post",
            usePager: false,
            async: false,
            enabledSort: true,
            enabledEdit: true,
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            showTitle: false,
            width: 650,
            columnWidth: 120,
            allowHideColumn: false,
            detail: {
                onShowDetail: f_showGroupCustData,
                height: 'auto'
            }

        });

    }

    function f_deletePushGroup(rowid) {
        
        var group = manager.getRow(rowid);
    	/* alert("group="+group.id); */
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelGroupOfCust.action", "json", false, {
                    "id": group.id
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        $.reloadGridServerData(g, {});
                    }
                },
                function(data) {

				});

            }
        });


    }

    function f_showGroupCustData(row, detailPanel, callback) {
        var groupNum = row['groupNum'];
        var custsdiv = document.createElement('div');
        $(detailPanel).append(custsdiv);
        var jqcustsdiv = $(custsdiv);
        jqcustsdiv.css("width","600px");
        j4tg.ajaxPost("${ctx}/owner/wGetEditGroupInitData.action", "json", false, {"groupNum":groupNum},
                function(data) {
                    if (data.status == "S") {
                        //             				alert(JSON.stringify(data));
                        if (data.respData) {
                        	
                        	var  ids = data.respData.custId;
                            var resd = ids.substring(0,ids.length - 1).split(",");
                           
                             for(var i=0;i<resd.length;i++){
                             var custobj = [];
                             custobj.push('<ul style="width:150px;float:left;margin-left:30px;margin-top:10px;"><li>');
                             custobj.push('<i class="i-spacing-follow" style="width:150px;height:20px" >');
                             custobj.push(resd[i]);
                             custobj.push('</i></li></ul>');
                             jqcustsdiv.append(custobj.join(''));
                             
                             }
                        	
                        }

                    }
                },
                function(data) {

        		});
              
    }


   
</script>
</html>