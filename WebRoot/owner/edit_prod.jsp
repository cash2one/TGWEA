<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>编辑产品</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/js/ligerui/plugins/ligerSpinner.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerForm.js" type="text/javascript"></script>
<script src="${ctx}/js/ligerui/plugins/ligerCheckBox.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/ckeditor/ckeditor.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
                <div style="clear:both;"></div>
            <div id="beautiful" style="padding-left:2rem;width:55rem;">
            <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/addProduct.webp"/></div>
               <div id="whatfont" style="margin-left:12rem;">添加新产品</div>
                <div class="both"></div>
               </div>
            <form name="productForm" method="post" id="productForm">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="productName" type="text" id="productName" style="width:300px;" />
                            <input name="hidProductNum" type="hidden" id="hidProductNum" value="<s:property value="
                            #parameters.prodNum[0] " />"/>
                            <input name="hidExternalSyscode" type="hidden" id="hidExternalSyscode"
                            value="wea" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            产品类别：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="productCatId" name="productCatId"  />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            显示状态：
                        </i>
                        <i class="i-spacing-follow">
                            <input id="topFlag" type="checkbox" name="topFlag" />
                            <label for="topFlagLabel">
                                置顶
                            </label>
                        </i>
                        <i class="i-spacing-follow">
                            <input id="newFlag" type="checkbox" name="newFlag" />
                            <label for="newFlagLabel">
                                新品
                            </label>
                        </i>
                        <i class="i-spacing-follow">
                            <input id="hotFlag" type="checkbox" name="hotFlag" />
                            <label for="hotFlagLabel">
                                热卖
                            </label>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            显示库存：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="dispStockBalance" type="text" name="dispStockBalance" id="dispStockBalance"
                            ltype='spinner' ligerui="{type:'int'}" value="999" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            单位：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="unit" name="unit" style="width:60px;" />
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                           单价：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="stdPrice" name="stdPrice" style="width:60px;" value="0.00" />
                        </i>
                    </li>
           
                    <li class="li-line">
                        <i class="i-spacing-first">
                        差异品类：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="addDiffer">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                         差异分类为空视为无效差异分类
                                    </i>
                                </li>
                                <li id="differ-hd" style="height:25px">
                                    <i class="i-spacing-follow" style="width:150px">
                                        差异分类
                                    </i>
                                    <i class="i-spacing-follow">
                                        <a href="javascript:void(0);" onclick="f_addDiffer('','');">
                                            添加
                                        </a>
                                    </i>
                                </li>
                            </ul>
                        </i>
                    </li>

                    <li class="li-line">
                        <i class="i-spacing-first">
                            自定义属性：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="addFeature">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        属性名或属性值为空视为无效属性
                                    </i>
                                </li>
                                <li id="feature-hd" style="height:25px">
                                    <i class="i-spacing-follow" style="width:150px">
                                        属性名
                                    </i>
                                    <i class="i-spacing-follow" style="width:150px">
                                        属性值
                                    </i>
                                    <i class="i-spacing-follow">
                                        <a href="javascript:void(0);" onclick="f_addFeature('','');">
                                            添加
                                        </a>
                                    </i>
                                </li>
                            </ul>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            产品图片：
                        </i>
                        <i class="i-spacing-follow">
                            <ul id="addImg">
                                <li style="height:25px">
                                    <i class="i-spacing-follow" style="width:200px;color:red">
                                        <input type="button" value="上传产品图片" onclick="javascript:f_openUploadProdImgWindow();"
                                        />
                                    </i>
                                </li>
                                <li id="prodimg-hd">
                                </li>
                            </ul>
                        </i>
                    </li>
                    <li class="li-line">
                        <i class="i-spacing-first">
                            产品简介：
                        </i>
                        <i class="i-spacing-follow">
                            <textarea name="remark" id="editor1" rows="10" cols="80"></textarea>
                        </i>
                    </li>
                   
                     <li class="li-line" style="text-align:left;margin-left:7rem;margin-top:7rem;">
                     <div style="height:2rem;"></div>
                        <input type="submit" value="提交" id="saveProd" name="saveProd" class="button-submit"
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
        
        <div id="uploadImgDiv" style="display:none;text-align:center;">
            <ul>
                <li style="height:40px;text-align:center;">
                    <h3>
                        产品图片上传
                    </h3>
                </li>
                <li style="height:40px;text-align:center;">
                    选择本地图片：
                    <input style="width:140px; border:0px; background:none; margin:0; padding:0;"
                    type="file" id="imgFile" name="imgFile"/>
                </li>
                <li style="height:40px;color:red;text-align:center;">
                    文件类型：JPG,JPEG,PNG
                </li>
                <li style="height:40px;text-align:center;">
                    <input type="submit" value="上传" id="saveImg" name="saveImg" class="button-submit"
                    />
                    <input type="button" value="取消" id="cancel" name="cancel" class="button-cancel"
                    onclick="javascript:f_closeUploadProdImgWindow();" />
                </li>
            </ul>
        </div>
        
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>    
<script type="text/javascript">
    var manager, g, updialog;
    $(function() {
        $.expandAccordionMenu("prodmenu");
    	CKEDITOR.replace( 'editor1', {
			filebrowserUploadUrl: '${ctx}/owner/wCkeditor.action'
		});
        $("#productCatId").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'prodCatId',
            textField: 'prodCatName',
            treeLeafOnly: true,
            isShowCheckBox: false

        });
        
        $("#productForm").validate({
        	focusInvalid:false, 
            rules:{ 
                "productName":{ 
                    required: true,
                    maxlength: 50
                },
                "productCatId":{ 
                    required: true
                },
                "dispStockBalance":{ 
                    required: true,
                    digits:true,
                    min:1
                },
                "unit":{ 
                    required: true,
                    maxlength: 10
                },
                "stdPrice":{ 
                	required:true,
                	number:true,
                	min:0
                }
             
            }, 
            messages:{ 
            	"productName": { 
	                maxlength: "产品名称长度不能大于50"
            	},
            	"dispStockBalance": { 
            		min: "显示库存不能小于1"
            	},
            	"unit": { 
	                maxlength: "单位长度不能大于10"
            	},
            	"stdPrice": { 
            		number: "标准价格必须为数字"
            	}
            }
        });
        $("#newFlag").ligerCheckBox({});
        $("#hotFlag").ligerCheckBox({});
        $("#topFlag").ligerCheckBox({});
        $("#productForm").ligerForm();
        $("#saveImg").click(f_saveImg);
        f_initEditProdData();

    });

    function f_initEditProdData() {
        var prodnum = $("#hidProductNum").val();
        j4tg.ajaxPost("${ctx}/owner/wGetEditProdInitData.action", "json", false, {
            "prodNum": prodnum
        },
        function(data) {
            if (data.status == "S") {
                //             				alert(JSON.stringify(data));
                liger.get("productCatId").setTree({
                    data: data.respData.prodCats,
                    idFieldName: 'prodCatId',
                    textFieldName: 'prodCatName',
                    checkbox: false,
                    slide: false,
                    parentIDFieldName: 'parentProdCatId'
                });

                if (data.respData.prod) {
                    var prod = data.respData.prod;
                    $("#productName").val(prod.prodName);
                    $("#unit").val(prod.unit);
                    $("#stdPrice").val(prod.stdPrice);
                    
                   CKEDITOR.instances.editor1.setData( prod.remark );
                    
                    $("#dispStockBalance").val(prod.dispStockBalance);
                    $("#hidExternalSyscode").val(prod.externalSyscode);
                    if (prod.newFlag == '1') {
                        liger.get("newFlag").setValue(true);
                    }
                    if (prod.hotFlag == '1') {
                        liger.get("hotFlag").setValue(true);
                    }
                    if (prod.topFlag == '1') {
                        liger.get("topFlag").setValue(true);
                    }
                    $.selectComboBoxTreeNodes(liger.get("productCatId"), prod.prodCatId, "prodCatId");

                    for (var key in prod.prodFeatures) {
                        var prodfeature = prod.prodFeatures[key];
                        f_addFeature(prodfeature.featureName, prodfeature.featureValue);
                    }
  
                    for (var key in prod.prodDiffers) {
                        var prodDiffer = prod.prodDiffers[key];
                        f_addDiffer(prodDiffer.differName);
                    }

                    for (var key in prod.prodImgs) {
                        var prodImg = prod.prodImgs[key];
                        prodImg.addImg = false;
                        f_addProdImg(prodImg, prod.externalSyscode);
                    }
                }

            }
        },
        function(data) {

		});

    }

    function f_submitForm() {

        var productnum = $.trim($("#hidProductNum").val());
        var productname = $.trim($("#productName").val());
        var productcatid = liger.get("productCatId").getValue();
        var unit = $.trim($("#unit").val());
        var stdprice = $.trim($("#stdPrice").val());
        var dispstockbalance = $.trim($("#dispStockBalance").val());
        var externalsyscode = $.trim($("#hidExternalSyscode").val());
        
        var remark = CKEDITOR.instances.editor1.getData();
        
        var newflag = 0,
        hotflag = 0,
        topflag = 0,
        showflag = 1;
        if (liger.get("newFlag").getValue()) {
            newflag = 1;
        }
        if (liger.get("hotFlag").getValue()) {
            hotflag = 1;
        }
        if (liger.get("topFlag").getValue()) {
            topflag = 1;
        }
        
        
        var param = {
            "product.prodNum": productnum,
            "product.prodName": productname,
            "product.prodCatId": productcatid,
            "product.unit": unit,
            "product.stdPrice": stdprice,
            "product.dispStockBalance": dispstockbalance,
            "product.remark": remark,
            "product.newFlag": newflag,
            "product.hotFlag": hotflag,
            "product.topFlag": topflag,
            "product.showFlag": showflag,
            "product.externalSyscode": externalsyscode

        };

        var fobjs = $("#feature-hd").parent().find("[id^=fid]");
        var fnindex = 0;
        for (var i = 0; i < fobjs.length; i++) {

            var fid = fobjs[i].id.replace("fid", "");
            var fnvalue = $.trim($("#fn" + fid).val());
            var fvvalue = $.trim($("#fv" + fid).val());
            if (!string.isInvalid(fnvalue) && !string.isInvalid(fvvalue)) {
            	var fn = "product.prodFeatures[" + fnindex + "].featureName";
                var fv = "product.prodFeatures[" + fnindex + "].featureValue";
                fnindex++;
                param[fn] = fnvalue;
                param[fv] = fvvalue;
            }
        }

        var dobjs = $("#differ-hd").parent().find("[id^=did]");
		var ddindex = 0;
        for (var i = 0; i < dobjs.length; i++) {
			
            var did = dobjs[i].id.replace("did", "");
            var dnvalue = $.trim($("#dn" + did).val());
            if (!string.isInvalid(dnvalue)) {
            	var dd = "product.prodDiffers[" + ddindex+ "].differId";
                var dn = "product.prodDiffers[" + ddindex + "].differName";
                ddindex++;
            	param[dd] = ddindex;
                param[dn] = dnvalue;
            }
        }

       // alert(JSON.stringify(param));
        var pobjs = $("#prodimg-hd").find("[id^=piid]");

        for (var i = 0; i < pobjs.length; i++) {

            var piid = pobjs[i].id.replace("piid", "");
            var imgurl = "prodImgNodes[" + i + "].imgUrl";
            var thumburl = "prodImgNodes[" + i + "].thumbUrl";
            var addimg = "prodImgNodes[" + i + "].addImg";
            var imgseq = "prodImgNodes[" + i + "].imgSeq";

            var addimgvalue = $.trim($("#padd" + piid).val());
            var thumburlvalue = $.trim($("#thumbimg" + piid).val());
            var imgurlvalue = $.trim($("#img" + piid).val());

            param[imgseq] = i + 1;
            param[imgurl] = imgurlvalue;
            param[thumburl] = thumburlvalue;
            param[addimg] = addimgvalue;

        }

        j4tg.ajaxPost("${ctx}/owner/wSaveEditProd.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                if (productnum != "") {
                    $.ligerDialog.success('操作成功');
                    location.href = "${ctx}/owner/wListProds.action";
                } else {
                    $.ligerDialog.confirm('保存成功,是否继续添加新产品',
                    function(yes) {
                        if (yes) {
                            location.href = "${ctx}/owner/wEditProd.action";

                        } else {
                            location.href = "${ctx}/owner/wListProds.action";
                        }
                    });
                }

            } else {
                $.ligerDialog.error(data.message);
            }

        },
        function(data) {

		});
    }

    function f_addDiffer(dn) {

        // if ($("#differ-hd").parent().find("[id^=did]").size() > 6) {
        //     $.ligerDialog.error('最多只能添加10个差异品类');
        //     return;
        // }
        var did = Math.uuid();
        $("#differ-hd").parent().append('<li id="did' + did + '" style="height:25px"><i class="i-spacing-follow"  style="width:150px;"><input type="text" id="dn' + did + '" name="dn' + did + '" value="' + dn + '" style="width:130px;"/></i><i class="i-spacing-follow" style="width:150px"><i class="i-spacing-follow" ><a href="javascript:void(0);" onclick="f_delDiffer(this);">删除</a></i></li>');
    }
    
    function f_delDiffer(dela) {
        $(dela).parent().parent().remove();
    }
    
    function f_addFeature(fn, fv) {

        if ($("#feature-hd").parent().find("[id^=fid]").size() > 24) {
            $.ligerDialog.error('最多只能添加25个自定义属性');
            return;
        }
        var fid = Math.uuid();
        $("#feature-hd").parent().append('<li id="fid' + fid + '" style="height:25px"><i class="i-spacing-follow"  style="width:150px;"><input type="text" id="fn' + fid + '" name="fn' + fid + '" value="' + fn + '" style="width:130px;"/></i><i class="i-spacing-follow" style="width:150px"><input type="text" id="fv' + fid + '" name="fv' + fid + '" value="' + fv + '" style="width:130px;"/></i><i class="i-spacing-follow" ><a href="javascript:void(0);" onclick="f_delFeature(this);">删除</a></i></li>');
    }
    function f_delFeature(dela) {
        $(dela).parent().parent().remove();
    }

    function f_openUploadProdImgWindow() {

        if ($("#prodimg-hd").find("[id^=piid]").size() > 4) {
            $.ligerDialog.error('最多只能添加5张产品图片');
            return;
        }
        updialog = $.ligerDialog.open({
            target: $("#uploadImgDiv"),
            title: '图片上传',
            width: 300,
            height: 300
        });
    }
    function f_closeUploadProdImgWindow() {
        updialog.hide();
        $("#imgFile").val("");
    }
    function f_saveImg() {
        var imgfile = $.trim($("#imgFile").val());
        if (imgfile == "" || !j4tg.isImgFile(imgfile)) {
            $.ligerDialog.error('请选择图片文件');
            return;
        }
        
        var param = {
            "thumbWidth": 250
        };
        $.ajaxFileUpload({
            url: '${ctx}/owner/wUploadProdImg.action',
            data: param,
            secureuri: false,
            fileElementId: 'imgFile',
            dataType: 'json',
            success: function(data, status) {
                if (data.status == "S") {
                    f_closeUploadProdImgWindow();
                    $.ligerDialog.success('上传成功');
                    data.respData.addImg = true;
                    f_addProdImg(data.respData, 'wea');

                } else {
                    alert(data.message);
                }
            },
            error: function(data, status, e) {

			}
        });
    }

    function f_addProdImg(imgData, sysCode) {

        var piid = Math.uuid();
        var preva = '<a href="javascript:void(0);" onclick="f_toPrevious(this);">前移</a>';
        var nexta = '<a href="javascript:void(0);" onclick="f_toAfter(this);">后移</a>';
        var dela = '<a href="javascript:void(0);" onclick="f_delProdImg(this);">删除</a>';
        var imgobj = [];
        imgobj.push('<i id="piid' + piid + '" class="i-spacing-follow"  style="width:150px;height:150px">');
        imgobj.push('<div id="pidid' + piid + '" style="position:relative;">');
		if(!j4tg.isUrl(imgData.thumbUrl)){
            imgobj.push('<img src="${imgCtx}/' + imgData.thumbUrl + '" style="width:150px;height:150px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
        } else {
            imgobj.push('<img src="' + imgData.thumbUrl + '" style="width:150px;height:150px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" />');
        }
        imgobj.push('<input id="thumbimg' + piid + '" type="hidden" value="' + imgData.thumbUrl + '" />');
        imgobj.push('<input id="img' + piid + '" type="hidden" value="' + imgData.imgUrl + '" />');
        imgobj.push('<input id="padd' + piid + '" type="hidden" value="' + imgData.addImg + '" />');
        imgobj.push('<div id="pimdid' + piid + '" class="popImgMenu" style="display:none;">');
        imgobj.push('<div style="float:left">');
        imgobj.push(preva);
        imgobj.push(nexta);
        imgobj.push('</div>');
        imgobj.push('<div style="float:right">');
        imgobj.push(dela);
        imgobj.push('</div>');
        imgobj.push('</div></div></i>');

        $("#prodimg-hd").append(imgobj.join(''));
        $("#pidid" + piid).hover(function() {
            $("#pimdid" + piid, this).slideToggle(500);
        });
    }
    function f_toPrevious(aobj) {
        var currImg = $(aobj).parents("i:first");
        var prevImg = currImg.prev();
        if (prevImg.is('i')) {
            prevImg.before(currImg);
        }
    }
    function f_toAfter(aobj) {
        var currImg = $(aobj).parents("i:first");
        var afterImg = currImg.next();
        if (afterImg.is('i')) {
            afterImg.after(currImg);
        }
    }
    function f_delProdImg(aobj) {
        $(aobj).parents("i:first").remove();
    }
</script>
</html>