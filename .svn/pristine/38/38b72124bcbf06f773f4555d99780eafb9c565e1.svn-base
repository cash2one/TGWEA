<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑客户信息</title> 
<%@ include file="/admin/common/admin-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/admin/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/admin/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
                 <div id="beautiful">
                <div id="etitle" style="margin-bottom:3rem;">
               <div id="whereimg"><img src="../images/adminBP/edit_owner.webp"/></div>
               <div id="whatfont">编辑企业信息</div>
                <div class="both"></div>
               </div>
                <div class="both" style="height:7rem;"></div>
            <form name="ownerForm" method="post" id="ownerForm">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="companyName" type="text" id="companyName" style="width:300px;"
                            ltype="text" validate="{required:true}" />
                            <input name="hidOwnerNum" type="hidden" id="hidOwnerNum" value="<s:property value="
                            #parameters.ownerNum[0] " />" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            行业：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="tradeId" name="tradeId" ltype="text" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            地区：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="regionCode" name="regionCode" ltype="text" />
                        </i>
                    </li>
                     <li class="li-line">
                        <i class="i-spacing-first">
                            经度：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="longitude" name="longitude" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                           纬度：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="latitudes" name="latitudes" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            联系人：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="contactPerson" name="contactPerson" ltype="text"
                            validate="{required:true}" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            办公电话：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="phoneNum" name="phoneNum" ltype="text" validate="{required:true}"
                            />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            移动电话：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="mobileNum" name="mobileNum" ltype="text" validate="{required:true}"
                            />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司地址：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="address" name="address" style="width:300px;" ltype="text"
                            validate="{required:true}" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            公司主页：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="webSite" name="webSite" style="width:300px;" ltype="text"
                            validate="{required:true,url:true}" />
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
                            <textarea cols="100" rows="5" name="introduction" id="introduction" style="width:400px"></textarea>
                        </i>
                    </li>
                    <li class="li-line" style="text-align:center;padding-top:3rem;">
                        <input type="submit" value="保存" id="saveOwner" name="saveOwner" class="button-submit"
                        />
                        <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                        onclick="javascript:history.back(-1);" />
                    </li>
                </ul>
            </form>
        </div>
        </div>
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
    	$.expandAccordionMenu("enterprise");
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
                    required: true,
                    maxlength: 30
                },
                "mobileNum":{ 
                    required: true,
                    maxlength: 30
                },
                "address":{ 
                    required: true,
                    maxlength: 50
                },
                "webSite":{ 
                    required: true,
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
        var ownerNum = $("#hidOwnerNum").val();
        j4tg.ajaxPost("${ctx}/admin/wGetEditOwnerInitData.action", "json", false, {"ownerNum":ownerNum},
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

    	var ownerNum = $("#hidOwnerNum").val();
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
        	"owner.ownerNum": ownerNum,
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
            "imgNode.imgUrl": imgUrl,
            "imgNode.addImg": addImg,
            "owner.longitude": longitude,
            "owner.latitudes": latitudes

        };

        $.ligerDialog.confirm('确定要保存么?',
                function(yes) {
                    if (yes) {

                        j4tg.ajaxPost("${ctx}/admin/wSaveEditOwner.action", "json", false, param,
                        function(data) {

                            if (data.status == "S") {
                                $.ligerDialog.success('保存成功');
                                location.href = "${ctx}/admin/wListOwners.action";
                            }

                        },
                        function(data) {

                 		});

                    }
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
		var ownerNum = $("#hidOwnerNum").val();
        $.ajaxFileUpload({
            url: '${ctx}/admin/wUploadOwnerImg.action',
            data: {"ownerNum":ownerNum},
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
        imgobj.push('<img src="${ctx}/' + imgData.imgUrl + '" style="width:200px;height:200px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
        imgobj.push('<input id="ownerImgAdd" type="hidden" value="' + imgData.addImg + '" />');
        imgobj.push('<input id="ownerImgUrl" type="hidden" value="' + imgData.imgUrl + '" />');
        imgobj.push('</div></i>');

        $("#ownerimg-hd").append(imgobj.join(''));
    }
</script>
</html>