<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改系统管理员角色信息</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerListBox.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
<style type="text/css">
    .middle input {
        display: block;width:30px; margin:2px;
    }
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
               <div id="whereimg"><img src="../images/adminBP/edit_role.webp"/></div>
               <div id="whatfont">编辑管理员角色</div>
                <div class="both"></div>
               </div>
	        <ul>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    角色名：
	                </i>
	                <i class="i-spacing-follow">
	                	<input type="text" id="roleName" class="l-text" name="roleName" />
	                    <input name="hidRoleId" type="hidden" id="hidRoleId" value="<s:property value="
	                    #parameters.roleId[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
			访问权限：
	                </i>
	                <i class="i-spacing-follow">
  						<ul>
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        请选择角色关联的权限
                                    </i>
                                    <i class="i-spacing-follow">
                                        <input type="checkbox" onclick="javascript:j4tg.selallcheckbox('selallfunctions','operation');" id="selallfunctions" name="selallfunctions"/>全选
                                    </i>
                                </li>
                                <li style="height:25px">
                                	<div id="operations" style="width:800px">
                    				</div>
                                </li>
                        </ul>
	                </i>
	                
	            </li>
	            <li class="li-line">
                    <i class="i-spacing-first">
                        备注：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="4" name="remark" class="l-textarea" id="remark" style="width:400px" maxlength="100"></textarea>
                    </i>
                </li>
	            <li class="li-line" style="text-align:center;">
	                <input type="button" value="提交" id="saveRole" name="saveRole" onclick="javascript:f_saveRole();" 
	                class="button-submit" />
	                <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
	                onclick="javascript:history.back(-1);" />
	            </li>
	        </ul>
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
        f_initEditRoleData();
    });

    function f_initEditRoleData() {
        var roleId = $("#hidRoleId").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditRoleInitData.action", "json", false, {"roleId":roleId},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));

				f_displayAllAccessOperation(data.respData.operationsMap);
                if (data.respData.role) {
                    var role = data.respData.role;
                    var roleOperationsMap = data.respData.roleOperationsMap;

                    $("#roleName").val(role.roleName);
                    $("#remark").val(role.remark);
                    $("input[name='operation']").each(function(){
                        if(roleOperationsMap[$(this).val()]){
                        	$(this).attr("checked",true);
                        }
                    });
                }

            }
        },
        function(data) {

		});

    }

    function f_displayAllAccessOperation(operationsMap) {

    	var checkTexts = {"READ":"查找","CREATE":"新增","UPDATE":"更新","DELETE":"删除"};
    	for(var key in operationsMap){
        	var operationobj = [];
        	operationobj.push('<i class="i-spacing-follow"  style="width:200px;height:100px">');
        	operationobj.push('<ul>');
        	operationobj.push('<li><b>'+key+'</b></li>');
        	operationobj.push('<li>');
        	operationobj.push('<div style="float:left;padding-right:10px;margin-top:10px" >');
            var operations = operationsMap[key];
            for(var okey in operations){
                var moduleName = operations[okey].moduleName;
                var operationName = operations[okey].operationName;
                var checkId = moduleName+operationName;
                var checkValue = moduleName+";"+operationName;
                operationobj.push('<i class="i-spacing-follow"><input type="checkbox" id="operation" name="operation" value="'+checkValue+'" />'+checkTexts[operationName]+'</i>');
            }
            operationobj.push('</div>');
            operationobj.push('</li></ul></i>');
            $("#operations").append(operationobj.join(''));
        }

    }
    
    function f_saveRole() {

    	var roleId = $.trim($("#hidRoleId").val());
        var roleName = $.trim($("#roleName").val());
        var remark = $.trim($("#remark").val());
        var checkedOperations = $('input[name="operation"]:checked');

        if (string.isInvalid(roleName)) {
        	$.ligerDialog.alert("请填写角色名");
            return;
        }
        if(checkedOperations.length==0){
        	$.ligerDialog.alert("请选择包含的权限");
            return;
        }

        var param = {
        	"wadminRole.adminRole.roleId": roleId,
            "wadminRole.adminRole.roleName": roleName,
            "wadminRole.adminRole.remark": remark
        };


        for (var i = 0; i < checkedOperations.length; i++) {
        	var moduleNOperationName = "wadminRole.moduleNOperations[" + i + "]";
        	var moduleNOperationValue = $.trim($(checkedOperations[i]).val());
        	param[moduleNOperationName] = moduleNOperationValue;
        }

        j4tg.ajaxPost("${ctx}/admin/wSaveEditRole.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/admin/wListRoles.action";
            }

        },
        function(data) {

		});

    }
</script>
</html>