<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>修改密码信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<style type="text/css">
        li{
            float: left;
            list-style: none;
			font-size: 0.75rem;
            color:#999;
            margin-top: 2rem;
        }
        #w1{
            background-color: rgba(200, 200, 200, 0.25);
            width:40rem;
            margin: auto;
            padding:1rem 0rem 1rem 0rem;
        }
        #w2{
            width: 35rem;
            margin:auto;
            background-color: rgba(159, 159, 159, 0.05);
            padding:1rem 0rem 4rem 3rem;
        }

        #changepwd{
            text-align: center;
        }
       #font_place{float:left;font-size:2rem;margin-left:6rem;margin-top:3rem;color:#db4a39;}
       #img_place{float:left;margin-left:2rem;}
    </style>

</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title="" style="margin-top:6rem;">
            <div id="w1">
            <div id="w2">
            <div id="changepwd"><div id="font_place">修改密码</div><div id="img_place"><img src="../images/beautiful-page/changepwd128.webp"/></div></div>
            <form name="adminPwdForm" method="post" id="adminPwdForm">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            旧密码：
                        </i>
                        <i class="i-spacing-follow">
                          <input type="password" id="oldPwd" name="oldPwd"/>
                        </i>
                        <i class="i-spacing-follow">
                          <label id="oldPwdprompt" class="prompt">请输入原来的密码</label>
                        </i>
                        
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            新密码：
                        </i>
                        <i class="i-spacing-follow">
                             <input type="password" id="newPwd" name="newPwd"/>
                        </i>
                        <i class="i-spacing-follow">
                             <label id="newPwdprompt" class="prompt">请使用有字母和数字组成的至少6位的密码</label>
                        </i>

                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            确认密码：
                        </i>
                        <i class="i-spacing-follow">
                         <input type="password" id="confirmPwd" name="confirmPwd"/>
                        </i>
                        <i class="i-spacing-follow">
                         <label id="confirmPwdprompt" class="prompt">请再次输入新密码</label>
                        </i>
  
                    </li>
                    <li class="li-line" style="text-align:left;margin-left:3rem;margin-top:2rem;">
                        <input type="submit" value="提&nbsp;交" id="saveAdminPwd" name="saveAdminPwd" 
                        class="button-submit"/>
                        <input type="button" value="取&nbsp;消" id="cancel" name="cancel" class="button-cancel"
                        onclick="javascript:history.back(-1);" />
                    </li>
                </ul>
            </form><div class="both"></div></div>
        </div>
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
    $(function() {
        $.expandAccordionMenu("basicmenu");
        $("input[type='password']").focus(function(){
           $("#"+$(this).attr("id")+"prompt").hide();
        });
        $("input[type='password']").blur(function(){
            if($(this).val().trim() == ""){
                $("#"+$(this).attr("id")+"prompt").show();
            }
        });
        $("#adminPwdForm").validate({
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
            		rangelength: '密码长度应在6-30个字符之间' 
            	},
                "confirmPwd":{ 
                	equalTo: "新密码两次输入不一致"
                } 
            }

        });
        $("#adminPwdForm").ligerForm();
//        $("#saveAdminPwd").click(f_saveAdminPwd);
    });

    function f_submitForm() {

//    	if(!$("#adminPwdForm").valid()){return;}
    	
        var oldPwd = $.trim($("#oldPwd").val());
        var newPwd = $.trim($("#newPwd").val());

        var param = {
            "oldPwd": oldPwd,
            "newPwd": newPwd

        };

        j4tg.ajaxPost("${ctx}/owner/wSaveOwnerAdminPwd.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
            }else{
            	$.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});

    }
</script>
</html>