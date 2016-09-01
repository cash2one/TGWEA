<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>特供产品</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
         <div position="top">
        <%@ include file="/owner/top.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
            <div id="beautiful" style="padding-left:2rem;width:59rem;">
               <div id="etitle" style="margin-bottom:2rem;">
               <div id="whereimg"><img src="../images/beautiful-page/list_prodsgps.webp"/></div>
               <div id="whatfont" style="margin-left:15rem;">特供产品</div>
                <div class="both"></div>
               </div>
            <div id="searchbar" style="overflow:hidden;">
             <ul>
                    <li>
                        <i class="i-spacing-first">
                            产品名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="prodName" type="text" id="prodName" />
                        </i>
                        <i class="i-spacing-follow">
                           客户名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="contactPerson" />
                            <input type="hidden" id="hidCustNum" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchCust" type="button" style="width:66px;" value="搜&nbsp;&nbsp;索" onclick="f_searchProdgps()"/>
                        </i>
                        <i class="i-spacing-follow" style="margin-left:9rem;">
                            <a href="${ctx}/owner/wAddProdsGps.action"><input id="addproductgps" type="button" style="width:66px;" value="添&nbsp;&nbsp;加"/></a>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
            </div>
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

    var manager, g;

    $(function() {
    	
        $.expandAccordionMenu("prodmenu");
        f_showProdPriceData();
        $("#contactPerson").ligerComboBox({
            onBeforeOpen: f_selectCust,
            valueFieldID: 'hidCustNum',
            width: 200
        });
    });
    

    function f_showProdPriceData() {

        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '产品名称',
                name: 'prodName',
                isSort: false,
                align: 'center',
                width: 500
            },
            {
                display: '客户所属组',
                name: 'custNum',
                isSort: false,
                align: 'center',
                width: 300
            },
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                        h += "<a href='javascript:f_deleteDeliverInv(" + rowindex + ")'><img src='${ctx}/images/ico/delete.png'/></a> ";
                    return h;

                }
            }],
            url: "${ctx}/owner/wListProdGpsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            pageSize: 20,
            method: "post",
            async: false,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getProdGpsParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 903,
            columnWidth: 120,
            height: 'auto'
        });

    }

    function f_deleteDeliverInv(rowid) {
        var prodGps = manager.getRow(rowid);
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wDelproductGps.action", "json", false, {
                    "custNum": prodGps.custNum,
                    "prodNum": prodGps.prodNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_showProdPriceData();
                    }
                },
                function(data) {

				});
            }
        });

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
            alert('请选择客户!');
            return;
        }

        $("#contactPerson").val(data.contactPerson);
        $("#hidCustNum").val(data.custNum);
        dialog.close();
    }
    function f_selectCustCancel(item, dialog) {
        dialog.close();
    }


    function f_searchProdgps() {
        $.reloadGridServerData(g, f_getProdGpsParam());
    }

    function f_getProdGpsParam() {
        var prodName = $("#prodName").val();
        var custNum = $("#hidCustNum").val();
        
        var param = {
            "specialProdCustRefSearch.prodName": prodName,
            "specialProdCustRefSearch.groupName": custNum

        };
        return param;

    }
</script>
</html>