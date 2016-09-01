<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑客户信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
           <div id="beautiful">
            <form name="custForm" method="post" id="custForm">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/addCust.webp"/></div>
               <div id="whatfont">添加客户</div>
                <div class="both"></div>
               </div>
                <ul><li>
                        <i class="i-spacing-first">
                            客户账号：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="custName" type="text" id="custName" style="width:200px;"/>
                           
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="companyName" type="text" id="companyName" style="width:300px;"/>
                            <input name="hidCustNum" type="hidden" id="hidCustNum" value="<s:property value="
                            #parameters.custNum[0] " />" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            行业：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="tradeId" name="tradeId" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            地区：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="regionCode" name="regionCode"/>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            联系人：
                        </i>
                        <i class="i-spacing-follow">
                            <li><input type="text" id="contactPerson" name="contactPerson" /></li><li id="contactPersonprompt" class="prompt">请输入公司负责人姓名</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            联系电话：
                        </i>
                        <i class="i-spacing-follow">
                        <li><input type="text" id="phoneNum" name="phoneNum" /></li><li id="phoneNumprompt" class="prompt">请输入负责人手机号码</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            客户等级：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="keyLevel" name="keyLevel" ltype="text" />
                            <input type="hidden" id="hidKeyLevel" name="hidKeyLevel" />
                        </i>
                        <i class="i-spacing-first">
                            信用等级：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="creditLevel" name="creditLevel" ltype="text" />
                            <input type="hidden" id="hidCreditLevel" name="hidCreditLevel" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            联系地址：
                        </i>
                        <i class="i-spacing-follow">
                            <li><input type="text" id="address" name="address" style="width:300px;" /></li><li id="addressprompt" class="prompt">请详细填写你的具体地址</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            备注：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea cols="100" rows="4" name="remark" id="remark" style="width:400px" maxlength="200"></textarea>
                        </i>
                    </li>
                    <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                        <input type="submit" value="提交" id="saveCust" name="saveCust" class="button-submit"
                        />
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
    $(function() {
        $.expandAccordionMenu("custmenu");
        $("#tradeId").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'tradeId',
            textField: 'tradeName',
            treeLeafOnly: true,
            isShowCheckBox: false

        });
        $("#regionCode").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'regionCode',
            textField: 'regionName',
            treeLeafOnly: true,
            isShowCheckBox: false

        });

        $("#keyLevel").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidKeyLevel'
        });

        $("#creditLevel").ligerComboBox({
            data: null,
            cancelable: false,
            valueFieldID: 'hidCreditLevel'
        });

        $("#custForm").validate({
        	focusInvalid:false, 
            rules:{ 
                "custName":{ 
                    required: true,
                    maxlength: 30
                },
                "companyName":{ 
                    required: true,
                    maxlength: 30
                },
                "contactPerson":{ 
                    required: true,
                    maxlength: 30
                },
                "phoneNum":{ 
                    required: true,
                    maxlength: 30
                }
            }, 
            messages:{ 
            	"custName": { 
	                maxlength: "客户账号长度不能大于30"
            	},
            	"companyName": { 
	                maxlength: "公司名称长度不能大于30"
            	},
            	"contactPerson": { 
	                maxlength: "联系人长度不能大于30"
            	},
            	"phoneNum": { 
	                maxlength: "联系电话长度不能大于30"
            	}
            }
        });
        $("#custForm").ligerForm();
        f_initEditCustData();
        
        $("input[type='text']").focus(function(){

           $("#"+$(this).attr("id")+"prompt").hide();
        });
        $("input[type='text']").blur(function(){
            if($(this).val().trim() == ""){

                $("#"+$(this).attr("id")+"prompt").show();
            }

        });

    });

    function f_initEditCustData() {
        var custnum = $("#hidCustNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditCustInitData.action", "json", false, {
            "custNum": custnum
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("tradeId").setTree({
                    data: data.respData.trades,
                    idFieldName: 'tradeId',
                    textFieldName: 'tradeName',
                    checkbox: false,
                    slide: false,
                    parentIDFieldName: 'parentTradeId'
                });
                liger.get("regionCode").setTree({
                    data: data.respData.regionCodes,
                    idFieldName: 'regionCode',
                    textFieldName: 'regionName',
                    checkbox: false,
                    slide: false,
                    parentIDFieldName: 'parentRegionCode'
                });
                liger.get("keyLevel").setData($.transformMap2ComboBoxData(data.respData.keyLevels));
                liger.get("creditLevel").setData($.transformMap2ComboBoxData(data.respData.creditLevels));
                if (data.respData.cust) {
                    var cust = data.respData.cust;
                    $("#companyName").val(cust.companyName);
                    $("#custName").val(cust.custName);
                    $("#custName").attr("disabled","disabled");
                    $("#contactPerson").val(cust.contactPerson);
                    $("#phoneNum").val(cust.phoneNum);
                    $("#remark").val(cust.remark);
                    $("#address").val(cust.address);
                    $("#hidKeyLevel").val(cust.keyLevel);
                    $("#hidCreditLevel").val(cust.creditLevel);
                    liger.get("keyLevel").updateStyle();
                    liger.get("creditLevel").updateStyle();
                    $.selectComboBoxTreeNodes(liger.get("regionCode"), cust.regionCode, "regionCode");
                    $.selectComboBoxTreeNodes(liger.get("tradeId"), cust.tradeId, "tradeId");
                }

            }
        },
        function(data) {

		});

    }

    function f_submitForm() {

        var custnum = $.trim($("#hidCustNum").val());
        var companyname = $.trim($("#companyName").val());
        var contactperson = $.trim($("#contactPerson").val());
        var custname = $.trim($("#custName").val());
        var phonenum = $.trim($("#phoneNum").val());
        var address = $.trim($("#address").val());
        var tradeid = liger.get("tradeId").getValue();
        var regioncode = liger.get("regionCode").getValue();
        var keylevel = liger.get("keyLevel").getValue();
        var creditlevel = liger.get("creditLevel").getValue();
        var remark = $.trim($("#remark").val());
        var delflag = 0;

        var param = {
            "cust.custNum": custnum,
            "cust.custName": custname,
            "cust.companyName": companyname,
            "cust.tradeId": tradeid,
            "cust.contactPerson": contactperson,
            "cust.phoneNum": phonenum,
            "cust.address": address,
            "cust.keyLevel": keylevel,
            "cust.delFlag": delflag,
            "cust.regionCode": regioncode,
            "cust.creditLevel": creditlevel,
            "cust.remark": remark

        };

        j4tg.ajaxPost("${ctx}/owner/wSaveEditCust.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListCusts.action";
            }

        },
        function(data) {

		});

    }
</script>
</html>