<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑特供客户组</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
           <div id="beautiful">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/pushing.webp"/></div>
               <div id="whatfont">编辑特供客户组</div>
                <div class="both"></div>
               </div>
           <form name="pushGroupForm" method="post" id="pushGroupForm">
	        <ul>
	            <li class="li-line">
	                <i class="i-spacing-first">
	                    组名：
	                </i>
	                <i class="i-spacing-follow">
	                	<input type="text" id="groupName" name="groupName" maxlength="30" />
	                    <input name="hidGroupNum" type="hidden" id="hidGroupNum" value="<s:property value="
	                    #parameters.groupNum[0] " />" />
	                </i>
	            </li>
	            <li class="li-line">
	                <i class="i-spacing-first">
			成员客户：
	                </i>
	                <i class="i-spacing-follow">
	                        <ul>
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:22rem;">
                                        <a href="javascript:void(0);" onclick="javascript:f_selectCust();"><img src="../images/beautiful-page/add_cust.webp" title="添加客户"/></a>
                                    </i>
                                </li>
                                <li >
                                    <i>
					                    <div style="clear:both;"></div>
					                    <div id="custlist" style="width:600px;"></div>
                                    </i>
                                </li>
                            </ul>
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
	            <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
	                <input type="button" value="提交" id="savePushGroup" name="savePushGroup" onclick="javascript:f_savePushGroup();" 
	                class="button-submit" />
	                <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
	                onclick="javascript:history.back(-1);" />
	            </li>
            </ul>
            </form>
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
    var manager, g, groupcusts = [];
    $(function() {
        $.expandAccordionMenu("prodmenu");
        $("#pushGroupForm").ligerForm();
        f_initEditPushGroupData();
        
    });

    function f_initEditPushGroupData() {
    	
    	var groupNum = $("#hidGroupNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditGroupInitData.action", "json", false, {"groupNum":groupNum},
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                	 $("#groupName").val(data.respData.groupName);
                     $("#remark").val(data.respData.memo);
                     
                     var custs = [];
                     
                     var  ids = data.respData.custId;
                     var resd = ids.substring(0,ids.length - 1).split(",");
                     
                     var  own = data.respData.ownerNum;
                     var ownern = own.substring(0,own.length - 1).split(",");
                   
                     for(var i=0;i<resd.length;i++){
                     var obj = new Object();
                     obj.companyName = resd[i];
                     obj.custNum = ownern[i];
                     custs.push(obj);
                     }
                     
                     f_generatorCustsLayout(custs);

            }
        },
        function(data) {

		});
    	
                   


    }

    function f_generatorCustsLayout(custRefArray) {

    	for(var key in custRefArray){
            f_generatorCustLayout(custRefArray[key]);
        }
    }

    function f_generatorCustLayout(cust) {
    	groupcusts.push(cust.custNum);
        var custobj = [];
        custobj.push('<ul id="'+cust.custNum+'" style="width:200px;height:40px;float:left">');
        custobj.push('<li><i class="i-spacing-follow">');
        custobj.push(cust.companyName);
        custobj.push('</i><i class="i-spacing-follow">');
        custobj.push('<a href="javascript:void(0);" onclick="f_delPushGroupCust(\'' +cust.custNum+ '\');"><img src=\'${ctx}/images/ico/delete.png\' alt=\'删除\' title=\'删除\'/></a>');
        custobj.push('</i></li></ul>');
        $("#custlist").append(custobj.join(''));
    }


    function f_delPushGroupCust(custNum) {

    	groupcusts.splice($.inArray(custNum,groupcusts),1);
        $("#"+custNum).remove();

    }

    function f_selectCust() {
        $.ligerDialog.open({
            title: '选择客户',
            name: 'winselector',
            width: 700,
            height: 350,
            url: '${ctx}/owner/wListSearchCusts.action?custSearch.companyName=&wpagingRequest.currentPage=1',
            buttons: [{
                text: '确定',
                onclick: f_selectCustOK
            },
            {
                text: '取消',
                onclick: f_selectCustCancel
            }]
        });
        return false;
    }
    function f_selectCustOK(item, dialog) {
        var fn = dialog.frame.f_select || dialog.frame.window.f_select;
        var data = fn();
        if (!data) {
        	$.ligerDialog.alert('请选择客户!');
            return;
        }
        if($.inArray(data.custNum, groupcusts)!=-1){
        	$.ligerDialog.alert('客户已存在');
        	return;
        }
        var cust = {"custNum":data.custNum,"companyName":data.companyName};
        f_generatorCustLayout(cust);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }

    function f_savePushGroup() {

    	var groupNum = $.trim($("#hidGroupNum").val());
        var groupName = $.trim($("#groupName").val());
        var remark = $.trim($("#remark").val());
        if (string.isInvalid(groupName)) {
        	$.ligerDialog.alert("请填写组名");
            return;
        }
        if(groupcusts.length==0){
        	$.ligerDialog.alert("请至少添加一个客户");
            return;
        }
        
        var allGp="";
        for(var i=0;i<groupcusts.length;i++){
        	allGp+=groupcusts[i]+",";
        }
        
        var param = {
        		  "custId":allGp,
                  "groupName":groupName,
                  "memo":remark,
                  "groupNum":groupNum
        };

        j4tg.ajaxPost("${ctx}/owner/wSaveOrEditGroupOfCust.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListGroupOfCust.action";
            }

        },
        function(data) {

		});

    }
    
</script>
</html>