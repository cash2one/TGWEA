<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
 <div id="leftmenu"  >
 <s:iterator value="#session.whichAuthority" id="id">
		   <s:if test="#id == 1">
		       <div id="adm" title="<img src='../images/icons-12.png' width='30' height='18'/ >账户管理"style="line-height:28px;">
		        <div  style=" height:7px;">
		        </div>
		        <a class="l-link" href="${ctx}/owner/wListOwnerAdmin.action">
		            查看管理员
		        </a>
		      </div>
    		</s:if>	
    <s:if test="#id == 2">
    <div id="basicmenu" title="<img src='../images/icons-12.png' width='30' height='18'/ >基础资料"style="line-height:28px;">
        <div  style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wEditOwnerAdminPwd.action">
            修改账户密码
        </a>
        <a class="l-link" href="${ctx}/owner/wEditOwner.action">
            修改企业基本信息
        </a>
    </div>
    </s:if>	
     <s:if test="#id == 3">
    <div class="icon2" id="custmenu" title="<img src='../images/accountm.png' width='30' height='18'/ >客户管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListCusts.action">
            客户管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 4">
    <div  id="ordermenu" title="<img src='../images/icons-14.png' width='30' height='18'/ >订单管理">
        <div style=" height:7px;">
        </div>
<!--    <a class="l-link" href="${ctx}/owner/wListOrigOrders.action">
            原始订单管理
        </a>-->
        <a class="l-link" href="${ctx}/owner/wListOrders.action">
            订单管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 5">
    <div  id="sendstuff" title="<img src='../images/sendstuff.png' width='30' height='18'/ >送货管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListDeliverInvs.action">
            送货单管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListReturnedInvs.action">
            回库单管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 6">
    <div id="stockmenu" title="<img src='../images/icons-15.png' width='30' height='18'/ >库存管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListWarehouses.action">
            仓库管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListProdStocks.action">
            库存管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListGodownInvs.action">
            入库单管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListStkAllocInvs.action">
            库存调拨
        </a>
        <a class="l-link" href="${ctx}/owner/wListStockTrace.action">
            库存跟踪
        </a>
    </div>
    </s:if>
    <s:if test="#id == 7">
    <div id="cashmenu" title="<img src='../images/icons-16.png' width='30' height='18'/ >结算管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListCashInvs.action">
            收款单管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListSettleInvs.action">
            订单结算
        </a>
    </div>
    </s:if>
    <s:if test="#id == 8">
    <div class="icon6" id="prodmenu" title="<img src='../images/icons-17.png' width='30' height='18'/ >产品管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListProdCats.action">
            产品分类管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListProds.action">
            产品管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListProdsgps.action">
            特供产品
        </a>
        <a class="l-link" href="${ctx}/owner/wListGroupOfCust.action">
            特供客户组管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 9暂时隐藏">
    <div class="icon7" id="pricemenu" title="<img src='../images/icons-18.png' width='30' height='18'/ >价格管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListProdPrices.action">
            标准价管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListCustProdPrices.action">
            客户价管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 10">
    <s:if test='#session[@com.etaoguan.wea.constant.WeaConstant@CUROWNERADMIN].owner.externalSysCode!="wea"'>
	    <div class="icon8" id="syncmenu"  title="<img src='../images/icons-19.png' width='30' height='18'/ >数据同步">
	    <div style="height:7px;"></div>
	        <a class="l-link" href="${ctx}/owner/wE688SyncPage.action">
	            1688数据同步
	        </a>
	    </div>
    </s:if>
    </s:if>
    
    <s:if test="#id == 11暂时隐藏">
    <div class="icon8" id="pushmenu" title="<img src='../images/icons-19.png' width='30' height='20'/ >推送管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link " href="${ctx}/owner/wListPushGroups.action">
            推送组管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListPushMessages.action">
            推送消息管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 12">
    <div class="icon10" id="wechatmenu" title="<img src='../images/icons-20.png' width='30' height='18'/ >微站管理">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListWechatMessages.action">
            响应信息管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListWechatMenus.action">
            微站菜单管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListPictureText.action">
            群发消息管理
        </a>
    </div>
    </s:if>
    <s:if test="#id == 13">
    <div class="icon10" id="statistics" title="<img src='../images/reports.png' width='30' height='18'/ >报表统计">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListDailyReport.action">
          对账日报表
        </a>
    </div>
    </s:if>
    <s:if test="#id == 14">
    <div class="icon11" id="othermenu" title="<img src='../images/icons-21.png' width='30' height='18'/ >功能选项">
        <div style=" height:7px;">
        </div>
        <a class="l-link" href="${ctx}/owner/wListGuestBooks.action">
            留言管理
        </a>
        <a class="l-link" href="${ctx}/owner/wListOwnerBanners.action">
            展示图片管理
        </a>
        <%-- <a class="l-link" href="${ctx}/owner/wGoDownloadApp.action">
           APP下载地址
        </a> --%>
        
    </div>
    </s:if>
    </s:iterator>
</div>
