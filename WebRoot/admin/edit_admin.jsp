<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改系统管理员信息</title> 
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
                <div id="etitle" style="margin-bottom:12rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_admin.webp"/></div>
               <div id="whatfont">编辑管理员信息</div>
                <div class="both"></div>
               </div>
        	<form name="adminForm" method="post" id="adminForm">
	        <ul>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    账户名：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="text" id="adminName" name="adminName" />
	                     <input name="hidAdminId" type="hidden" id="hidAdminId" value="<s:property value="
	                    #parameters.adminId[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    密码：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="password" id="pwd" name="pwd" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    确认密码：
	                </i>
	                <i class="i-spacing-follow">
	                    <input type="password" id="confirmPwd" name="confirmPwd" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
			隶属于(组)：
	                </i>
	                <i class="i-spacing-follow">
	                    <div style="margin:4px;float:left;">
         				<div id="groups"></div>  
     					</div>
     					<div style="margin:4px;float:left;" class="middle">
     					<input type="button" onclick="moveToRight()" value="添加" />
         				<input type="button" onclick="moveToLeft()" value="删除" />
          				<input type="button" onclick="moveAllToRight()" value="全选" />
          				<input type="button" onclick="moveAllToLeft()" value="全删" />
     					</div>
    					<div style="margin:4px;float:left;">
        				<div id="adminGroups"></div> 
    					</div>
    					<input type="hidden" id="hideAGValidate" name="hideAGValidate" />
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
	            <li class="li-line" style="margin-left:6rem;margin-top:7rem;">
	                <input type="submit" value="提交" id="saveAdmin" name="saveAdmin"
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
	var formvalidate;
    $(function() {
        $.expandAccordionMenu("authmenu");
        $("#groups").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "groupId",
            textField: "groupName"
        });
        $("#adminGroups").ligerListBox({
            isMultiSelect: true,
            height: 140,
            valueField: "groupId",
            textField: "groupName",
            valueFieldID: 'groupIds'
        });
        formvalidate = $("#adminForm").validate({
        	focusInvalid:false, 
        	ignore: "",
            rules:{ 
                "adminName":{ 
                    required: true,
                    rangelength:[6,30]  
                }, 
                "pwd": { 
                    required: true,
                    rangelength:[6,30]  
                },
                "confirmPwd": { 
                    required: true, 
                    equalTo: "#pwd" 
                },
                "hideAGValidate": {
                	checkMultiSelectligerListBox: "adminGroups"
                }
            }, 
            messages:{ 
            	"adminName": { 
        			rangelength: '账户名应在6-30个字符之间'  
        		},
            	"pwd": { 
            		rangelength: '密码长度应在6-30个字符之间'  
            	},
                "confirmPwd":{ 
                	equalTo: "密码两次输入不一致"
                },
                "hideAGValidate":{ 
                	checkMultiSelectligerListBox: "请选择管理员隶属分组"
                }
            }

        });
        $("#adminForm").ligerForm();
        f_initEditAdminData();
    });

    function f_initEditAdminData() {
        var adminId = $("#hidAdminId").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditAdminInitData.action", "json", false, {"adminId":adminId},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("groups").setData(data.respData.noAdminGroups);
                liger.get("adminGroups").setData(data.respData.adminGroups);
                if (data.respData.admin) {
                    var admin = data.respData.admin;
                    $("#adminName").val(admin.adminName);
                    $("#pwd").val(admin.adminPwd);
                    $("#confirmPwd").val(admin.adminPwd);
                    $("#remark").val(admin.remark);

                }

            }
        },
        function(data) {

		});

    }

    function moveToLeft()
    {
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box2.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box2.removeItems(selecteds);
        box1.addItems(selecteds);
//        alert($("#groupIds").val());
        formvalidate.element($("#hideAGValidate"));
    }
    function moveToRight()
    {
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box1.getSelectedItems();
        if (!selecteds || !selecteds.length) return;
        box1.removeItems(selecteds);
        box2.addItems(selecteds);
        formvalidate.element($("#hideAGValidate"));
    }
    function moveAllToLeft()
    { 
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box2.data;
        if (!selecteds || !selecteds.length) return;
        box1.addItems(selecteds);
        box2.removeItems(selecteds); 
        formvalidate.element($("#hideAGValidate"));
    }
    function moveAllToRight()
    { 
        var box1 = liger.get("groups"), box2 = liger.get("adminGroups");
        var selecteds = box1.data;
        if (!selecteds || !selecteds.length) return;
        box2.addItems(selecteds);
        box1.removeItems(selecteds);
        formvalidate.element($("#hideAGValidate"));
    }

    
    function f_submitForm() {

    	var adminId = $.trim($("#hidAdminId").val());
    	var adminName = $.trim($("#adminName").val());
        var pwd = $.trim($("#pwd").val());
        var confirmPwd = $.trim($("#confirmPwd").val());
        var remark = $.trim($("#remark").val());
        var groupIds = $.getListBoxAllDataValue(liger.get("adminGroups"));
        /*
        if (string.isInvalid(adminName)) {
        	$.ligerDialog.alert("请填写账户名");
            return;
        }
        
        if(string.isInvalid(pwd)){
        	$.ligerDialog.alert("请输入管理员密码");
            return;
        }
        if (pwd != confirmPwd) {
        	$.ligerDialog.alert("密码两次输入不一致");
            return;
        }
        */
        if(groupIds.length==0){
        	$.ligerDialog.alert("请选择管理员隶属分组");
            return;
        }
		
        var param = {
        	"wadmin.admin.adminId": adminId,
            "wadmin.admin.adminName": adminName,
            "wadmin.admin.adminPwd": pwd,
            "wadmin.admin.remark": remark,
            "wadmin.groupIds": groupIds

        };

         j4tg.ajaxPost("${ctx}/admin/wSaveEditAdmin.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
                location.href = "${ctx}/admin/wListAdmins.action";
            }

        },
        function(data) {

		});

    }
</script>
</html>