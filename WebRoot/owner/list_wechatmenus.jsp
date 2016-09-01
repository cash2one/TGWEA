<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>微站菜单信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerTree.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div style="width:300px;height:450px; display:block; margin-left:30px; margin-top:30px;background:white; border:1px solid #ccc; overflow:auto;float:left  ">
                <ul id="wechatMenuTree" name="wechatMenuTree">
                </ul>
            </div>
            <div style="margin-left:80px; margin-top:30px;float:left">
                <ul>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_addWechatMenu();" type="button"
                            name="addWechatMenu" id="addWechatMenu" value="新增菜单" />
                        </i>
                    </li>
                    <li class="li-line">
                    </li>                    
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_updateWechatMenu();" type="button"
                            name="updateWechatMenu" id="updateWechatMenu" value="修改菜单" />
                        </i>
                    </li>
                    <li class="li-line">
                    </li>                    
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_delWechatMenu();" type="button"
                            name="delWechatMenu" id="delWechatMenu" value="删除菜单" />
                        </i>
                    </li>
                    <li class="li-line">
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_refreshWechatMenuTreeData();"
                            type="button" name="refreshWechatMenu" id="refreshWechatMenu" value="刷新菜单"
                            />
                        </i>
                    </li>
                    <li class="li-line" style="height:50px">
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            <input class="button-common" onclick="javascript:f_syncWechatMenu();"
                            type="button" name="syncWechatMenu" id="syncWechatMenu" value="微站同步"
                            />
                        </i>
                    </li>
                </ul>
            </div>
            <div style="margin-left:80px; margin-top:30px;float:left">
                <ul>
                    <li class="li-line">
                        <i><input type="hidden" id="hidMobileIndexUrl" name="hidMobileIndexUrl" />
                            <div id="updateWechatMenuDiv" style="display:none;text-align:center;margin-left:50px;border:1px solid #ccc;width:500px;height:300px">
                                <ul>
                                    <li style="text-align:left;">
                                        <h3>
                                            修改菜单
                                        </h3>
                                    </li>
                                    <li  class="li-line">
                                        <i class="i-spacing-first">
                                            上级菜单名：
                                        </i>
                                        <i class="i-spacing-follow">
                                            <input type="text" id="parentWechatMenuName" disabled="disabled" />
                                            <input type="hidden" id="hidParentWechatMenuId" />
                                            <input type="hidden" id="hidParentWechatMenuLevel" />
                                        </i>
                                    </li>
                                    <li class="li-line">
                                        <i class="i-spacing-first">
                                            菜单名：
                                        </i>
                                        <i class="i-spacing-follow">
                                        <input type="text" id="wechatMenuName"/>
                                            <input type="hidden" id="hidWechatMenuId" />
                                        </i>
                                    </li>
                                    <li id="menuTypeContainer" class="li-line">
                                        <i class="i-spacing-first">
                                            响应类型：
                                        </i>
                                        <i class="i-spacing-follow">
					                        <input type="radio" value="0" id="menuType0" name="menuType" onclick="javascript:showExcludeContentContainer('menuTypeCt','0');"
					                        />
					                        消息
					                    </i>
					                    <i class="i-spacing-follow">
					                        <input type="radio" value="1" id="menuType1" name="menuType" onclick="javascript:showExcludeContentContainer('menuTypeCt','1');"
					                        />
					                        链接
					                    </i>
                                    </li>
                                    <li id="menuTypeCt0" style="display:none;height:40" class="li-line">
					                    <i class="i-spacing-first">
					                        响应消息：
					                    </i>

					                    <i class="i-spacing-follow">
					                        <input type="text" id="subject" style="width:200px" disabled="disabled"/>
					                        <input type="hidden" id="hidMessageId" />

					                    </i>
					                    <i class="i-spacing-follow" style="100px;">
					                       <label id="messageType"></label>
					                    </i>
					                    <i class="i-spacing-follow">
					                       <a href="javascript:void(0);" onclick="f_selectWechatMsg();">选择响应消息</a>
					                    </i>
					                </li>
					                <li id="menuTypeCt1" style="display:none;height:40" class="li-line">
					                    <i class="i-spacing-first">
					                       响应链接：
					                    </i>
					                    <i class="i-spacing-follow">
					                        <textarea cols="100" rows="3" name="linkUrl" id="linkUrl" style="width:250px" maxlength="100"></textarea>
					                    </i>
					                    <i class="i-spacing-follow">
					                       <a href="javascript:void(0);" onclick="f_selectMoibleIndexUrl();">设置APP默认地址</a>
					                    </i>
					                </li>
					                <li style="height:40px;text-align:center;" class="li-line">
                                        <input type="submit" value="保存" id="saveUpdateWechatMenu" name="saveUpdateWechatMenu"
                                        class="button-submit" onclick="javascript:f_saveUpdateWechatMenu();" />
                                        <input type="button" value="取消" id="cancelWechatMenu" name="cancelWechatMenu"
                                        class="button-cancel" onclick="javascript:$('#updateWechatMenuDiv').hide();" />
                                    </li>
                                </ul>
                            </div>
                        </i>
                    </li>
                </ul>
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
    var t, manager;

    $(function() {
        $.expandAccordionMenu("wechatmenu");
        $("#menuTypeContainer input:radio").ligerRadio();
        f_initWechatMenusData();
        f_showWechatMenusData();

    });

    function f_initWechatMenusData() {
    
    $("#hidMobileIndexUrl").val("http://"+window.location.host+"/mobile/index.html");
     /*	访问方式改成二级域名代理转发后，获取的地址不是二级域名，停止使用
    	j4tg.ajaxPost("${ctx}/owner/wGetOwnerMobileIndexUrl.action", "json", false, {},
    	        function(data) {

    	            if (data.status == "S") {
    	            	$("#hidMobileIndexUrl").val(data.respData);

    	            }
    	        },
    	        function(data) {

    			});
    */
    }
    function f_showWechatMenusData() {
        t = manager = $("#wechatMenuTree").ligerTree({
            idFieldName: 'menuId',
            textFieldName: 'menuName',
            checkbox: false,
            slide: false,
            parentIDFieldName: 'parentMenuId'
        });
        f_refreshWechatMenuTreeData();
    }

    function showExcludeContentContainer(ctPrefix, ctIndex) {
        for (var i = 0; i <= 1; i++) {
            $("#" + ctPrefix + i).hide();
            if (i == ctIndex) {
                $("#" + ctPrefix + i).show();
            }
        }
    }
   
	function f_selectMoibleIndexUrl(){

		$("#linkUrl").val($("#hidMobileIndexUrl").val());
	}
    function f_addWechatMenu() {
    	
   		if(!$("#updateWechatMenuDiv").is(":hidden")){
   			$("#updateWechatMenuDiv").hide();
   	   	}
   	   		var selmenu = t.getSelected();
   			if(selmenu){
//   				alert(JSON.stringify(t.data));
   	   			if(selmenu.data.menuLevel==0){
			$("#wechatMenuName").attr("maxlength","4");
			$("#wechatMenuName").attr("placeholder","最多只能输入4个字");
   	   				if(t.hasChildren(selmenu.data)&&selmenu.data.children.length>=3){
		   				$.ligerDialog.error('微站只支持3个一级菜单');
		   				return;
   	   				}
	   	   	    }
	   	   		if(selmenu.data.menuLevel==1){
	   	   		$("#wechatMenuName").attr("maxlength","7");
	   	   	$("#wechatMenuName").attr("placeholder","最多只能输入7个字");
	   				if(t.hasChildren(selmenu.data)&&selmenu.data.children.length>=5){
		   				$.ligerDialog.error('微站只支持5个二级菜单');
		   				return;
	   				}
	   	   	    }

   	   			if(selmenu.data.menuLevel==2){
   	   				$.ligerDialog.error('微站不支持三级菜单');
   	   				return;
   	   	   	    }
			        
   				f_resetMenuData();
	   			$("#parentWechatMenuName").val(selmenu.data.menuName);
	   	        $("#hidParentWechatMenuId").val(selmenu.data.menuId);
	   	     	$("#hidParentWechatMenuLevel").val(selmenu.data.menuLevel);
	   	     	$("#updateWechatMenuDiv").show();
	   	     	var checkedRadio = liger.get("menuType0");
                checkedRadio.setValue(true);
                checkedRadio.updateStyle();
                checkedRadio = liger.get("menuType1");
                checkedRadio.setValue(false);
                checkedRadio.updateStyle();
	   	     	showExcludeContentContainer('menuTypeCt','0');
   			}else{
   				$.ligerDialog.error('请选择上级菜单');
   	            return;
   	   		}


    }


    function f_updateWechatMenu() {
    	if(!$("#updateWechatMenuDiv").is(":hidden")){
   			$("#updateWechatMenuDiv").hide();
   	   	}
   	   		var selmenu = t.getSelected();
   			if(selmenu&&selmenu.data.menuId!=0){
   				f_resetMenuData();
   				var selParentWechatMenu = manager.getParent(selmenu.target);
   		        if (selParentWechatMenu != null) {

   		        	$("#parentWechatMenuName").val(selParentWechatMenu.menuName);
   		   	        $("#hidParentWechatMenuId").val(selParentWechatMenu.menuId);
   		   	  		$("#hidParentWechatMenuLevel").val(selmenu.data.menuLevel);
   		        }
   		     	$("#wechatMenuName").val(selmenu.data.menuName);
	   	        $("#hidWechatMenuId").val(selmenu.data.menuId);
   		        var param = {
   		            "menuId": selmenu.data.menuId
   		        };
   				j4tg.ajaxPost("${ctx}/owner/wGetWechatMenuData.action", "json", false, param,
   		                function(data) {
   		                    if (data.status == "S") {
   		                    	
								var menu = data.respData;
   		                    	
	   		                    if (menu.menuType == "0") {
	   		                    	/* 更改选中状态 */
	   		                      liger.get("menuType0").setValue(true);
	   		                   	  liger.get("menuType1").setValue(false);
   		                    	 
	   		                        $("#hidMessageId").val(menu.wechatMessage.messageId);
	   		                     	$("#messageType").html(menu.wechatMessage.messageTypeName);
	   		                     	$("#subject").val(menu.wechatMessage.subject);
	   		                        showExcludeContentContainer('menuTypeCt','0');
	   		                    }
	   		                    if (menu.menuType == "1") {
	   		                    	/* 更改选中状态 */
	   		                     liger.get("menuType1").setValue(true);
	   		                     liger.get("menuType0").setValue(false);
	   		                    	
	   		                    	$("#linkUrl").val(menu.content);
	   		                        showExcludeContentContainer('menuTypeCt','1');
	   		                    }
	   		                   	$("#parentWechatMenuName").val(selmenu.data.menuName);
	   		     	   	        $("#hidParentWechatMenuId").val(selmenu.data.menuId);
   		                    }
   		                },
   		                function(data) {

   						});
           		$("#updateWechatMenuDiv").show();
   			}else{
   				$.ligerDialog.error('请选择有效菜单');
   	            return;
   	   		}

    }
   

    function f_saveUpdateWechatMenu() {
    	var errors = [];
        var parentmenuid = $("#hidParentWechatMenuId").val();
        var parentmenulevel = $("#hidParentWechatMenuLevel").val();
        var menuid = $.trim($("#hidWechatMenuId").val());
        var menuname = $.trim($("#wechatMenuName").val());
        var messageid = $.trim($("#hidMessageId").val());
        var content = "";
        if (string.isInvalid(menuname)) {
        	errors.push('菜单名不能为空');
        }

        var menutype = $.trim($('#menuTypeContainer input:radio[name="menuType"]:checked').val());
        if (menutype == "0") {
        	content = messageid;
        	if (string.isInvalid(content)) {
            	errors.push('请选择响应消息');
            }
            

        }
        if (menutype == "1") {
        	content = $.trim($("#linkUrl").val());
        	if (!j4tg.isUrl(content)) {
            	errors.push('请填写合法的链接地址');
            }

        }
        if(errors.length>0){
        	$.ligerDialog.error(errors.join("<br/>"));
        	return;
        }
        var param = {
            "wechatMenu.menuId": menuid,
            "wechatMenu.menuName": menuname,
            "wechatMenu.menuType": menutype,
            "wechatMenu.menuKey": messageid,
            "wechatMenu.menuLevel": parseInt(parentmenulevel)+1,
            "wechatMenu.content": content,
            "wechatMenu.parentMenuId": parentmenuid,
        };
        j4tg.ajaxPost("${ctx}/owner/wSaveEditWechatMenu.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                $("#updateWechatMenuDiv").hide();
                f_refreshWechatMenuTreeData();
                f_resetMenuData();
            }
        },
        function(data) {

		});

    }

    function f_delWechatMenu() {
    	var selmenu = t.getSelected();
		if(!selmenu||selmenu.data.menuId==0){
			$.ligerDialog.error('请选择有效菜单');
            return;
		}
        var menuIds = $.getSelectedAllDataValue("menuId", manager);
//        if (menuIds.length == 0) {
//            $.ligerDialog.error('请选择有效菜单');
//            return;
//        }
//            		alert(menuIds);
        var param = {
            "menuIds": menuIds
        };
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelBatchWechatMenu.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_refreshWechatMenuTreeData();
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_refreshWechatMenuTreeData() {
        j4tg.ajaxPost("${ctx}/owner/wListWechatMenusData.action", "json", false, {},
        function(data) {

            if (data.status == "S") {
                manager.clear();
                manager.setData(data.respData);
                
                f_resetMenuData();
            }
        },
        function(data) {

		});

        manager.expandAll();

    }

    function f_resetMenuData() {
        $("#parentWechatMenuName").val("");
        $("#hidParentWechatMenuId").val("");
        $("#hidParentWechatMenuLevel").val("");
        $("#hidWechatMenuId").val("");
        $("#wechatMenuName").val("");
        $("#subject").val("");
        $("#hidMessageId").val("");
        $("#messageType").html("");
        $("#linkUrl").val("");

    }

    function f_selectWechatMsg() {
        $.ligerDialog.open({
            title: '选择响应信息',
            name: 'winselector',
            width: 650,
            height: 500,
            url: '${ctx}/owner/wListSearchWechatMessages.action?wechatMessageSearch.messageType=-1&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectWechatMsgOK
            },
            {
                text: '取消',
                onclick: f_selectWechatMsgCancel
            }]
        });
        return false;
    }
    function f_selectWechatMsgOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
        	$.ligerDialog.error('请选择响应消息!');
            return;
        }

        $("#subject").val(data.subject);
        $("#hidMessageId").val(data.messageId);
        $("#messageType").html(data.messageTypeName);
        dialog.close();
    }
    function f_selectWechatMsgCancel(item, dialog) {
        dialog.close();
    }

    function f_syncWechatMenu(){
    	j4tg.ajaxPost("${ctx}/owner/wSyncWechatMenu.action", "json", false, {},
    	        function(data) {

    	            if (data.status == "S") {
    	            	$.ligerDialog.success('同步成功');
    	            }else{
    	            	$.ligerDialog.error(data.message);
        	        }
    	        },
    	        function(data) {
    	        	
    			});
    }
</script>
</html>