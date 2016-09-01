<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑BANNER信息</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerRadio.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div>
            </div>
            <ul>
                <li class="li-line">
                    <i class="i-spacing-first">
                        展示图片：
                    </i>
                    <i class="i-spacing-follow">
                        <ul id="addImg">
                            <li style="height:25px">
                                <i class="i-spacing-follow" style="width:200px;color:red">
                                    <input name="hidBannerId" type="hidden" id="hidBannerId" value="<s:property value="
                                    #parameters.bannerId[0] " />" />
                                    <input type="button" value="上传企业展示图片" onclick="javascript:f_openUploadBannerImgWindow();"
                                    />
                                </i>
                            </li>
                            <li id="bannerimg-hd">
                            </li>
                        </ul>
                    </i>
                </li>
                <li id="linkTyleContainer" class="li-line">
                    <i class="i-spacing-first">
                        链接类型：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="0" id="linkType0" name="linkType" onclick="javascript:showLinkContentContainer('linkCt','1');"
                        />
                        网址
                    </i>
                    <i class="i-spacing-follow">
                        <input type="radio" value="1" id="linkType1" name="linkType" onclick="javascript:showLinkContentContainer('linkCt','2');"
                        />
                        产品
                    </i>
                </li>
                <li id="linkCt1" style="display:none" class="li-line">
                    <i class="i-spacing-first">
                        链接url：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="text" id="url" name="url" style="width:300px;" />
                        http://***
                    </i>
                </li>
                <li id="linkCt2" style="display:none" class="li-line">
                    <i class="i-spacing-first">
                        目标产品：
                    </i>
                    <i class="i-spacing-follow">
                        <input type="text" id="prodName" name="prodName" style="width:200px;"
                        />
                    </i>
                </li>
                <li class="li-line">
                    <i class="i-spacing-first">
                        图片备注：
                    </i>
                    <i class="i-spacing-follow">
                        <textarea cols="100" rows="5" name="remark" id="remark" style="width:400px"></textarea>
                    </i>
                </li>
                <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                    <input type="submit" value="保存" id="saveOwnerBanner" name="saveOwnerBanner"
                    class="button-submit" />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:history.back(-1);" />
                </li>
            </ul>
        </div>
        <div id="uploadImgDiv" style="display:none;text-align:center;">
            <ul>
                <li style="height:40px;text-align:center;">
                    <h3>
                        企业展示图片上传
                    </h3>
                </li>
                <li style="height:40px;text-align:center;">
                    选择本地图片：
                    <input style="width:140px; border:0px; background:none; margin:0; padding:0;"
                    type="file" id="imgFile" name="imgFile" accept="image/jpeg" />
                </li>
                <li style="height:40px;color:red;text-align:center;">
                    文件类型：JPG,JPEG,PNG
                </li>
                <li style="height:40px;text-align:center;">
                    <input type="submit" value="上传" id="saveImg" name="saveImg" class="button-submit"
                    />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:f_closeUploadBannerImgWindow();" />
                </li>
            </ul>
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
    var manager, g;
    $(function() {
        $.expandAccordionMenu("othermenu");;
        $("#prodName").ligerComboBox({
            width: 200,
            slide: false,
            selectBoxWidth: 600,
            selectBoxHeight: 220,
            valueField: 'prodNum',
            textField: 'prodName',
            grid: getGridOptions(false),
            condition: {
                fields: [{
                    name: 'prodSearch.productName',
                    label: '产品名称',
                    width: 150,
                    type: 'text'
                }]
            },
            parms: f_getProdsParam(),
        });
        $("#linkTyleContainer input:radio").ligerRadio();

        $("#saveImg").click(f_saveImg);
        $("#saveOwnerBanner").click(f_saveOwnerBanner);
        f_initEditOwnerBannerData();

    });
    function f_getProdsParam() {
        var param = {
            "prodSearch.productName": "",
            "prodSearch.showFlag": 1
        };
        return param;

    }
    function getGridOptions(checkbox) {
        var options = {
            columns: [{
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'left',
                width: 300
            },
            {
                display: '状态',
                name: 'showName',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '单位',
                name: 'unit',
                width: 80,
                isSort: false,
                align: 'left',
            },
            {
                display: '价格',
                name: 'stdPrice',
                width: 80,
                minWidth: 60,
                isSort: false,
                align: 'left',
            }],
            switchPageSizeApplyComboBox: false,
            url: "${ctx}/owner/wListSearchProdsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 5,
            method: "post",
            async: false,
            parms: f_getProdsParam(),
            enabledSort: false,
            dataAction: "server",
            isScroll: true,
            frozen: true,
            pageSizeOptions: [5],
            width: '100%',
            height: '100%',
            checkbox: checkbox
        };
        return options;
    }

    function f_initEditOwnerBannerData() {
        var bannerId = $("#hidBannerId").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditOwnerBannerInitData.action", "json", false, {
            "bannerId": bannerId
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                if (data.respData) {
                    var ownerBanner = data.respData;
                    var checkedRadio = liger.get("linkType" + ownerBanner.linkType);
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    if (ownerBanner.linkType == "0") {
                        $("#url").val(ownerBanner.linkContent);
                        showLinkContentContainer("linkCt", 1);
                    } else {
                        liger.get("prodName").setValue(ownerBanner.linkContent);
                        $("#prodName").val(ownerBanner.linkRemark);
                        showLinkContentContainer("linkCt", 2);
                    }
                    $("#remark").val(ownerBanner.remark);
                    if (!string.isInvalid(ownerBanner.imgUrl)) {
                        var imgData = {
                            "imgUrl": ownerBanner.imgUrl,
                            "addImg": false
                        };
                        f_addBannerImg(imgData);
                    }
                } else {
                    var checkedRadio = liger.get("linkType0");
                    checkedRadio.setValue(true);
                    checkedRadio.updateStyle();
                    showLinkContentContainer("linkCt", 1);
                }

            }
        },
        function(data) {

		});

    }

    function showLinkContentContainer(ctPrefix, ctIndex) {
        for (var i = 1; i <= 2; i++) {
            $("#" + ctPrefix + i).hide();
            if (i == ctIndex) {
                $("#" + ctPrefix + i).show();
            }
        }
    }

    function f_saveOwnerBanner() {

        var bannerId = $.trim($("#hidBannerId").val());
        var remark = $.trim($("#remark").val());
        var imgUrl = $.trim($("#bannerImgUrl").val());
        var addImg = $.trim($("#bannerImgAdd").val());
        var linkContent = "",
        linkRemark = "";
        var linkType = $.trim($('#linkTyleContainer input:radio[name="linkType"]:checked').val());
        if (string.isInvalid(imgUrl)) {
            $.ligerDialog.error('请上传展示图片');
            return;
        }

        if (linkType == "0") {
            linkContent = $.trim($("#url").val());
            if (string.isInvalid(linkContent)) {
                $.ligerDialog.error('链接地址不能为空');
                return;
            }
            if(linkContent.length > 90){
            	$.ligerDialog.error('链接地址不能超过90个字符');
                return;
            }
            if (!j4tg.isUrl(linkContent)) {
                $.ligerDialog.error('不合法的链接地址');
                return;
            }
        } else {
            linkContent = liger.get("prodName").getValue();
            linkRemark = $.trim($("#prodName").val());
            if (string.isInvalid(linkRemark)) {
                $.ligerDialog.error('请选择链接产品');
                return;
            }
        }

        var param = {
            "ownerBanner.bannerId": bannerId,
            "ownerBanner.linkType": linkType,
            "ownerBanner.linkContent": linkContent,
            "ownerBanner.linkRemark": linkRemark,
            "ownerBanner.remark": remark,
            "imgNode.imgUrl": imgUrl,
            "imgNode.addImg": addImg

        };

        j4tg.ajaxPost("${ctx}/owner/wSaveEditOwnerBanner.action", "json", false, param,
        function(data) {

            if (data.status == "S") {
                $.ligerDialog.success('保存成功');
                location.href = "${ctx}/owner/wListOwnerBanners.action";
            }

        },
        function(data) {

		});

    }

    function f_openUploadBannerImgWindow() {

        updialog = $.ligerDialog.open({
            target: $("#uploadImgDiv"),
            title: '图片上传',
            width: 400,
            height: 250
        });
    }
    function f_closeUploadBannerImgWindow() {
        updialog.hide();
        $("#imgFile").val("");
    }

    function f_saveImg() {
        var imgfile = $.trim($("#imgFile").val());
        if (imgfile == "" ) {
            $.ligerDialog.error('请选择图片文件');
            return;
        }
        if (imgfile == "" || !j4tg.isImgFile(imgfile)) {
            $.ligerDialog.error('请选择图片文件');
            return;
        }

        $.ajaxFileUpload({
            url: '${ctx}/owner/wUploadOwnerBannerImg.action',
            data: {},
            secureuri: false,
            fileElementId: 'imgFile',
            dataType: 'json',
            success: function(data, status) {
                if (data.status == "S") {
                    f_closeUploadBannerImgWindow();
                    $.ligerDialog.success('上传成功');
                     $("#bannerImgContainer").remove();
                    data.respData.addImg = true;
                    f_addBannerImg(data.respData);

                } else {
                    alert(data.message);
                }
            },
            error: function(data, status, e) {

			}
        });
    }

    function f_addBannerImg(imgData) {

        var imgobj = [];
        imgobj.push('<i id="bannerImgContainer" class="i-spacing-follow"  style="width:200px;height:200px">');
        imgobj.push('<div style="position:relative;">');
        imgobj.push('<img src="${imgCtx}/' + imgData.imgUrl + '" style="width:200px;height:200px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
        imgobj.push('<input id="bannerImgAdd" type="hidden" value="' + imgData.addImg + '" />');
        imgobj.push('<input id="bannerImgUrl" type="hidden" value="' + imgData.imgUrl + '" />');
        imgobj.push('</div></i>');

        $("#bannerimg-hd").append(imgobj.join(''));
    }
</script>
</html>