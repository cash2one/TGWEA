<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>首页展示信息列表</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <br/>
            <ul>
                <li style="height:25px;width:850px;text-align:right">
                    <a href="${ctx}/owner/wEditOwnerBanner.action">
                       <img src="../images/adminBP/add_group.webp" alt="添加" title="添加"/>
                    </a>
                </li>
                <li>
                    <div id="bannerlist" style="width:1000px">
                    </div>
                </li>
            </ul>
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
    var manager, g;
    $(function() {
        $.expandAccordionMenu("othermenu");
        f_showOwnerBannersData();

    });

    function f_showOwnerBannersData() {

        j4tg.ajaxPost("${ctx}/owner/wListOwnerBannersData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                $("#bannerlist").empty();
                f_generatorOwnerBannerLayout(data.respData);
            }
        },
        function(data) {

		});

    }

    function f_generatorOwnerBannerLayout(wobArray) {

        for (var i = 0; i < wobArray.length; i++) {
            var wob = wobArray[i];
            var tip = "";
            if (wob.ownerBanner.linkType == 0) {
                tip = wob.ownerBanner.linkContent;
            } else {
                tip = wob.ownerBanner.linkRemark;
            }
            var imgobj = [];
            imgobj.push('<i class="i-spacing-follow"  style="width:200px;height:250px">');
            imgobj.push('<ul>');
            imgobj.push('<li><img src="${imgCtx}/' + wob.ownerBanner.imgUrl + '" style="width:200px;height:200px" onerror="javascript:this.src=\'${ctx}/images/nopic.jpg\'" title="' + tip + '"   />');
            imgobj.push('</li><li>');
            imgobj.push('<div style="float:left" class="imgMenuDiv">');
            if (wob.preBannerId != 0) {
                imgobj.push('<a href="javascript:void(0);" onclick="f_exchangeOwnerBannerSequence(' + wob.preBannerId + ',' + wob.ownerBanner.bannerId + ');">前移</a>');
            }
            if (wob.nextBannerId != 0) {
                imgobj.push('<a href="javascript:void(0);" onclick="f_exchangeOwnerBannerSequence(' + wob.ownerBanner.bannerId + ',' + wob.nextBannerId + ');">后移</a>');
            }
            imgobj.push('</div>');
            imgobj.push('<div style="float:right" class="imgMenuDiv">');
            imgobj.push('<a href="${ctx}/owner/wEditOwnerBanner.action?bannerId=' + wob.ownerBanner.bannerId + '">编辑</a>');
            imgobj.push('<a href="javascript:void(0);" onclick="f_delOwnerBanner(' + wob.ownerBanner.bannerId + ');">删除</a>');
            imgobj.push('</div>');
            imgobj.push('</li></ul></i>');
            $("#bannerlist").append(imgobj.join(''));
        }
    }

    function f_delOwnerBanner(bannerId) {

        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelOwnerBanner.action", "json", false, {
                    "bannerId": bannerId
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_showOwnerBannersData();
                    }
                },
                function(data) {

				});
            }
        });

    }

    function f_exchangeOwnerBannerSequence(preBannerId, bannerId) {
        var param = {
            "preBannerId": preBannerId,
            "bannerId": bannerId
        };

        j4tg.ajaxPost("${ctx}/owner/wExchangeOwnerBannerSequence.action", "json", false, param,
        function(data) {
            if (data.status == "S") {
                f_showOwnerBannersData();
                //						$.ligerDialog.success('操作成功');		
            }
        },
        function(data) {

		});

    }
</script>
</html>