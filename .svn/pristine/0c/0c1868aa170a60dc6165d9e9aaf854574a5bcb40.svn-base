<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑客户信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
        <div id="beautiful">
            <form name="ownerForm" method="post" id="ownerForm">
                <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/editcom.webp"/></div>
               <div id="whatfont">修改企业基本信息</div>
                <div class="both"></div>
               </div>
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="companyName" type="text" id="companyName" style="width:300px;"/>
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
                            <input type="text" id="regionCode" name="regionCode" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            经度：
                        </i>
                        <i class="i-spacing-follow">
                         <li><input type="text" id="longitude" name="longitude" /></li><li id="longitudeprompt" class="prompt">请准确填写</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                           纬度：
                        </i>
                        <i class="i-spacing-follow">
                         <li><input type="text" id="latitudes" name="latitudes" /></li><li id="latitudesprompt" class="prompt">以便在地图上准确定位您公司的位置</li>
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
                            办公电话：
                        </i>
                        <i class="i-spacing-follow">
                            <li><input type="text" id="phoneNum" name="phoneNum" /></li><li id="phoneNumprompt" class="prompt">请输入负责人办公电话</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            移动电话：
                        </i>
                        <i class="i-spacing-follow">
                        <li><input type="text" id="mobileNum" name="mobileNum" /></li><li id="mobileNumprompt" class="prompt">请输入负责人手机号码</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司地址：
                        </i>
                        <i class="i-spacing-follow">
                        <li><input type="text" id="address" name="address" style="width:300px;" /></li><li id="addressprompt" class="prompt">请详细输入公司或厂家 地址</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司主页：
                        </i>
                        <i class="i-spacing-follow">
                             <li><input type="text" id="webSite" name="webSite" style="width:300px;" /></li><li id="webSiteprompt" class="prompt">请输入您公司的网址</li>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            展示图片：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="addImg">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        <input type="button" value="上传企业展示图片" onclick="javascript:f_openUploadOwnerImgWindow();"
                                        />
                                    </i>
                                </li>
                                <li id="ownerimg-hd">
                                </li>
                            </ul>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            企业介绍：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea cols="100" rows="5" name="introduction" id="introduction" style="width:400px" maxlength="100"></textarea>
                        </i>
                    </li>
                    <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                        <input type="submit" value="保存" id="saveOwner" name="saveOwner" class="button-submit"
                        />
                        <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                        onclick="javascript:history.back(-1);" />
                    </li>
                </ul>
            </form></div>
        </div>
        <style type="text/css">
	        #uploadImgDiv ul li{
	            text-align: center;
	        }     
    	</style>
        <div id="uploadImgDiv" style="display:none;text-align:center;">
            <ul>
                <li style="height:40px;">
                    <h3>
                        企业展示图片上传
                    </h3>
                </li>
                <li style="height:40px;">
                    选择本地图片：
                    <input style="width:140px; border:0px; background:none; margin:0; padding:0;"
                    type="file" id="imgFile" name="imgFile" accept="application/msexcel" />
                </li>
                <li style="height:40px;color:red">
                    文件类型：JPG,JPEG,PNG
                </li>
                <li style="height:40px;text-align:center;">
                    <input type="submit" value="上传" id="saveImg" name="saveImg" class="button-submit"
                    />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:f_closeUploadOwnerImgWindow();" />
                </li>
            </ul>
        </div>
        <div style="height:5rem;"></div>
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
    var manager, g;
    $(function() {
        $.expandAccordionMenu("basicmenu");
        $("input[type='text']").focus(function(){
            $("#"+$(this).attr("id")+"prompt").hide();
         });
         $("input[type='text']").blur(function(){
             if($(this).val().trim() == ""){
                 $("#"+$(this).attr("id")+"prompt").show();
             }
         });
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

        $("#ownerForm").validate({
        	focusInvalid:false, 
            rules:{ 
                "companyName":{ 
                    required: true,
                    maxlength: 30
                },
                "contactPerson":{ 
                    required: true,
                    maxlength: 30
                },
                "phoneNum":{ 
                    maxlength: 30
                },
                "mobileNum":{ 
                    required: true,
                    maxlength: 30
                },
                "address":{ 
                    maxlength: 50
                },
                "webSite":{ 
                    url:true
                }
            }, 
            messages:{ 
            	"companyName": { 
	                maxlength: "公司名称长度不能大于30"
            	},
            	"contactPerson": { 
	                maxlength: "联系人长度不能大于30"
            	},
            	"phoneNum": { 
	                maxlength: "办公电话长度不能大于30"
            	},
            	"mobileNum": { 
	                maxlength: "移动电话长度不能大于30"
            	},
            	"address": { 
	                maxlength: "公司地址长度不能大于50"
            	}
            }
        });
        $("#ownerForm").ligerForm();
        $("#saveImg").click(f_saveImg);
        f_initEditOwnerData();

    });

    function f_initEditOwnerData() {
        j4tg.ajaxPost("${ctx}/owner/wGetEditOwnerInitData.action", "json", false, {},
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
                if (data.respData.owner) {
                    var owner = data.respData.owner;
                    $("#companyName").val(owner.companyName);
                    $("#contactPerson").val(owner.contactPerson);
                    $("#phoneNum").val(owner.phoneNum);
                    $("#mobileNum").val(owner.mobileNum);
                    $("#webSite").val(owner.webSite);
                    $("#introduction").val(owner.introduction);
                    $("#address").val(owner.address);
                    $("#longitude").val(owner.longitude);
                    $("#latitudes").val(owner.latitudes);
                    if (!string.isInvalid(owner.ownerImg)) {
                        var imgData = {
                            "imgUrl": owner.ownerImg,
                            "addImg": false
                        };
                        f_addOwnerImg(imgData);
                    }
                    $.selectComboBoxTreeNodes(liger.get("regionCode"), owner.regionCode, "regionCode");
                    $.selectComboBoxTreeNodes(liger.get("tradeId"), owner.tradeId, "tradeId");
                }

            }
        },
        function(data) {

		});

    }

    function f_submitForm() {

        var companyName = $.trim($("#companyName").val());
        var contactPerson = $.trim($("#contactPerson").val());
        var phoneNum = $.trim($("#phoneNum").val());
        var address = $.trim($("#address").val());
        var tradeId = liger.get("tradeId").getValue();
        var regionCode = liger.get("regionCode").getValue();
        var ownerImg = $.trim($("#ownerImg").val());
        var mobileNum = $.trim($("#mobileNum").val());
        var webSite = $.trim($("#webSite").val());
        var introduction = $.trim($("#introduction").val());
        var imgUrl = $.trim($("#ownerImgUrl").val());
        var addImg = $.trim($("#ownerImgAdd").val());
        var longitude = $.trim($("#longitude").val());
        var latitudes = $.trim($("#latitudes").val());

        var param = {
            "owner.companyName": companyName,
            "owner.tradeId": tradeId,
            "owner.contactPerson": contactPerson,
            "owner.phoneNum": phoneNum,
            "owner.address": address,
            "owner.mobileNum": mobileNum,
            "owner.webSite": webSite,
            "owner.ownerImg": ownerImg,
            "owner.regionCode": regionCode,
            "owner.introduction": introduction,
            "owner.longitude": longitude,
            "owner.latitudes": latitudes,
            "imgNode.imgUrl": imgUrl,
            "imgNode.addImg": addImg

        };

        j4tg.ajaxPost("${ctx}/owner/wSaveEditOwner.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('更新成功');
            }

        },
        function(data) {

		});

    }

    function f_openUploadOwnerImgWindow() {

        updialog = $.ligerDialog.open({
            target: $("#uploadImgDiv"),
            title: '图片上传',
            width: 400,
            height: 250
        });
    }
    function f_closeUploadOwnerImgWindow() {
        updialog.hide();
        $("#imgFile").val("");
    }

    function f_saveImg() {
        var imgfile = $.trim($("#imgFile").val());
        if (imgfile == "" || !j4tg.isImgFile(imgfile)) {
            $.ligerDialog.error('请选择图片文件');
            return;
        }

        $.ajaxFileUpload({
            url: '${ctx}/owner/wUploadOwnerImg.action',
            data: {},
            secureuri: false,
            fileElementId: 'imgFile',
            dataType: 'json',
            success: function(data, status) {
                if (data.status == "S") {
                    f_closeUploadOwnerImgWindow();
                    $.ligerDialog.success('上传成功');
                    $("#ownerImgContainer").remove();
                    data.respData.addImg = true;
                    f_addOwnerImg(data.respData);

                } else {
                    alert(data.message);
                }
            },
            error: function(data, status, e) {

			}
        });
    }

    function f_addOwnerImg(imgData) {

        var imgobj = [];
        imgobj.push('<i id="ownerImgContainer" class="i-spacing-follow"  style="width:200px;height:200px">');
        imgobj.push('<div style="position:relative;">');
        imgobj.push('<img src="${imgCtx}/' + imgData.imgUrl + '" style="width:200px;height:200px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
        imgobj.push('<input id="ownerImgAdd" type="hidden" value="' + imgData.addImg + '" />');
        imgobj.push('<input id="ownerImgUrl" type="hidden" value="' + imgData.imgUrl + '" />');
        imgobj.push('</div></i>');

        $("#ownerimg-hd").append(imgobj.join(''));
    }
</script>
</html>