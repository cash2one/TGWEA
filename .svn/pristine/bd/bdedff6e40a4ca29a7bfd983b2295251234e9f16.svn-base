<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>系统管理员列表</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
       <div position="top">
        <%@ include file="/admin/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
               <div id="beautiful">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/adminBP/list_admins.webp"/></div>
               <div id="whatfont">账户管理</div>
                <div class="both"></div>
               </div>
            <div id="addadminbar" style="overflow:hidden;width:610px;" align="right">
                <a href="${ctx}/admin/wEditAdmin.action" title="添加管理员"><img src="../images/adminBP/add_admin.webp" alt="添加管理员"/></a>
            </div>
            <br/>
            <div id="maingrid">
            </div>
        </div>
        </div>
         <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
    </div>
    <br />
    <div id="resetPwdDiv" style="display:none">
    	<form name="resetPwdForm" method="post" id="resetPwdForm">
          <ul>
              <li class="li-line">
                  <i class="i-spacing-first">
                      旧密码：
                  </i>
                  <i class="i-spacing-follow">
                   <input name="hidAdminId" type="hidden" id="hidAdminId"  />
                      <input type="password" id="oldPwd" name="oldPwd" />
                  </i>
              </li>
              <li class="li-line">
                  <i class="i-spacing-first">
                      新密码：
                  </i>
                  <i class="i-spacing-follow">
                      <input type="password" id="newPwd" name="newPwd" />
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
                  <input type="submit" value="提交" id="saveAdminPwd" name="saveAdminPwd" onclick="javascript:f_saveAdminPwd();" 
                  class="button-submit" />
                  <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                  onclick="javascript:pwddialog.hide();" />
              </li>
          </ul>
          </form>
  	</div>
  	
    <div style="display:none;">
    </div>
</body>
<script type="text/javascript">
var manager, g, pwddialog;
$(function() {
    $.expandAccordionMenu("authmenu");
    
    $("#resetPwdForm").validate({
    	focusInvalid:false, 
        rules:{ 
            "oldPwd":{ 
                required: true 
            }, 
            "newPwd": { 
                required: true,
                rangelength:[6,30]  
            },
            "confirmPwd": { 
                required: true, 
                equalTo: "#newPwd" 
            }
        }, 
        messages:{ 
        	"newPwd": { 
    			rangelength: '新密码长度应在6-30个字符之间' 
    		},
            "confirmPwd":{ 
            	equalTo: "新密码两次输入不一致"
            } 
        }

    });
    $("#resetPwdForm").ligerForm();

    f_showAdminsData();
});

function f_showAdminsData() {

    g = manager = $("#maingrid").ligerGrid({
        columns: [{
            display: '账号',
            name: 'adminName',
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
            name: 'remark',
            isSort: false,
            align: 'left',
            width: 200
        },
        {
            display: '操作',
            isSort: false,
            width: 106,
            render: function(rowdata, rowindex, value) {
                var h = "";
                if(rowdata.reserveFlag==1){
                	h += "<a href='javascript:f_resetAdminPwd(" + rowindex + ")'>修改密码</a> ";
                }else{
                    h += "<a href='${ctx}/admin/wEditAdmin.action?adminId=" + rowdata.adminId + "'>修改</a> ";
                    h += "<a href='javascript:f_deleteAdmin(" + rowindex + ")'>删除</a> ";
                }
               
                return h;

            }
        }],
        url: "${ctx}/admin/wListAdminsData.action",
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
        width: 610,
        columnWidth: 120,
        allowHideColumn: false

    });

}

function f_deleteAdmin(rowid) {
    var admin = manager.getRow(rowid);
    $.ligerDialog.confirm('确定要删除么?',
    function(yes) {
        if (yes) {

            j4tg.ajaxPost("${ctx}/admin/wDelAdmin.action", "json", false, {
                "adminId": admin.adminId
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

function f_resetAdminPwd(rowid) {
    var admin = manager.getRow(rowid);
    $("#hidAdminId").val(admin.adminId);
    if(!pwddialog){
        pwddialog = $.ligerDialog.open({
            target: $("#resetPwdDiv"),
            title: '修改密码',
            width: 400,
            height: 250,
            onClosed:function(){$("#hidAdminId").val("");}
        });
    }
    pwddialog.show();
}
function f_submitForm() {

	var adminId = $.trim($("#hidAdminId").val());
    var oldPwd = $.trim($("#oldPwd").val());
    var newPwd = $.trim($("#newPwd").val());
    var confirmPwd = $.trim($("#confirmPwd").val());
    
    if(string.isInvalid(oldPwd)){
    	$.ligerDialog.alert("请输入旧密码");
        return;
    }
    if(string.isInvalid(newPwd)){
    	$.ligerDialog.alert("请输入新密码");
        return;
    }
    if (newPwd != confirmPwd) {
    	$.ligerDialog.alert("新密码两次输入不一致");
        return;
    }


    var param = {
    	"adminId": adminId,
        "oldPwd": oldPwd,
        "newPwd": newPwd

    };

    j4tg.ajaxPost("${ctx}/admin/wSaveAdminPwd.action", "json", false, param,
    function(data) {

        if (data.status == "S") {
            $.ligerDialog.success('更新成功');
            pwddialog.hide();
        }else{
        	$.ligerDialog.error(data.message);
        }

    },
    function(data) {

	});

};
</script>
</html>