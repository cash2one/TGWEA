<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑系统管理员组信息</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerListBox.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
    .middle input {
        display: block;width:30px; margin:2px;
</style>

</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_group.webp"/></div>
               <div id="whatfont">编辑管理员组信息</div>
                <div class="both"></div>
               </div>
        	<form name="groupForm" method="post" id="groupForm">
	        <ul>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    组名：
	                </i>
	                <i class="i-spacing-follow">
	                	<input type="text" id="groupName" name="groupName" maxlength="30" />
	                    <input name="hidGroupId" type="hidden" id="hidGroupId" value="<s:property value="
	                    #parameters.groupId[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
			包含角色：
	                </i>
	                <i class="i-spacing-follow">
	                    <div style="margin:4px;float:left;">
         				<div id="roles"></div>  
     					</div>
     					<div style="margin:4px;float:left;" class="middle">
     					<input type="button" onclick="moveToRight()" value="添加" />
         				<input type="button" onclick="moveToLeft()" value="删除" />
          				<input type="button" onclick="moveAllToRight()" value="全选" />
          				<input type="button" onclick="moveAllToLeft()" value="全删" />
     					</div>
    					<div style="margin:4px;float:left;">
        				<div id="groupRoles"></div> 
    					</div>
	                </i>
	                
	            </li>
	            <li class="li-line">
                    <i class="i-spacing-first">
                        备注：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="100"></textarea>
                    </i>
                </li>
	            <li class="li-line" style="text-align:center;margin-top:7rem;">
	                <input type="button" value="提交" id="saveGroup" name="saveGroup" onclick="javascript:f_saveGroup();" 
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
    var manager, g;
    $(function() {
        $.expandAccordionMenu("authmenu");
        $("#roles").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "roleId",
            textField: "roleName"
                
        });
        $("#groupRoles").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "roleId",
            textField: "roleName",
            valueFieldID: 'roleIds'
                
        });
        $("#groupForm").ligerForm();
        f_initEditGroupData();
    });

    function f_initEditGroupData() {
        var groupId = $("#hidGroupId").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditGroupInitData.action", "json", false, {"groupId":groupId},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("roles").setData(data.respData.noGroupRoles);
                liger.get("groupRoles").setData(data.respData.groupRoles);
                if (data.respData.group) {
                    var group = data.respData.group;
                    $("#groupName").val(group.groupName);
                    $("#remark").val(group.remark);
                }

            }
        },
        function(data) {

		});

    }

    function moveToLeft()
    {
        var box1 = liger.get("roles"), box2 = liger.get("groupRoles");
        var selecteds = box2.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box2.removeItems(selecteds);
        box1.addItems(selecteds);
    }
    function moveToRight()
    {
        var box1 = liger.get("roles"), box2 = liger.get("groupRoles");
        var selecteds = box1.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box1.removeItems(selecteds);
        box2.addItems(selecteds);
        
    }
    function moveAllToLeft()
    { 
        var box1 = liger.get("roles"), box2 = liger.get("groupRoles");
        var selecteds = box2.data;
        if (!selecteds || !selecteds.length) return;
        box1.addItems(selecteds);
        box2.removeItems(selecteds); 

    }
    function moveAllToRight()
    { 
        var box1 = liger.get("roles"), box2 = liger.get("groupRoles");
        var selecteds = box1.data;
        if (!selecteds || !selecteds.length) return;
        box2.addItems(selecteds);
        box1.removeItems(selecteds);

    }

    
    function f_saveGroup() {

    	var groupId = $.trim($("#hidGroupId").val());
        var groupName = $.trim($("#groupName").val());
        var roleIds = $.getListBoxAllDataValue(liger.get("groupRoles"));
        var remark = $.trim($("#remark").val());
        if (string.isInvalid(groupName)) {
        	$.ligerDialog.alert("请填写组名");
            return;
        }

        if(roleIds.length==0){
        	$.ligerDialog.alert("请选择包含的角色");
            return;
        }

        var param = {
        	"wadminGroup.adminGroup.groupId": groupId,
            "wadminGroup.adminGroup.groupName": groupName,
            "wadminGroup.adminGroup.remark": remark,
            "wadminGroup.roleIds": roleIds

        }


        j4tg.ajaxPost("${ctx}/admin/wSaveEditGroup.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/admin/wListGroups.action";
            }

        },
        function(data) {

		});

    }
</script>
</html>