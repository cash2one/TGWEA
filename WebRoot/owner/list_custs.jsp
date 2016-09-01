<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>客户信息列表</title> 
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
            <div id="searchbar" style="overflow:hidden;width:1200px;">
                <ul>
                    <li>
                        <i class="i-spacing-first">
                            公司名称：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="companyName" type="text" id="companyName" />
                        </i>
                        <i class="i-spacing-follow">
                            联系人：
                        </i>
                        <i class="i-spacing-follow">
                            <input type="text" id="contactPerson" name="contactPerson" />
                        </i>
                        <i class="i-spacing-follow">
                            客户地区：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="regionCodes" type="text" id="regionCodes" />
                        </i>
                        <i class="i-spacing-follow">
                            联系电话：
                        </i>
                        <i class="i-spacing-follow">
                            <input name="phoneNum" type="text" id="phoneNum" />
                        </i>
                        <i class="i-spacing-follow">
                            <input id="searchCust" type="button" value="搜索" style="width:65px;height:28px;background-color:#e0e4e9;border-radius:5px;" onclick="f_searchCust()" style="width:50px;"/>
                        </i>
                        <input id="hidCompanyName" type="hidden" />
                        <input id="hidRegionCodes" type="hidden" />
                        <input id="hidPhoneNum" type="hidden" />
                        <input id="hidContactPerson" type="hidden" />
                    </li>
                </ul>
            </div>
            <br/> 
            <br/> 
            <div class=" bcolor borderradius adminico" style="margin-left:7rem;margin-bottom:1rem;"><a name="addCustprod" href="${ctx}/owner/wEditCust.action" id="addCustprod"><img src='${ctx}/images/ico/addcust.png' alt='添加客户' title='添加客户'/></a></div>
           <br/>
            <div id="batchbar" style="overflow:hidden">
                <ul>
                    <li>
                        <i class="i-spacing-follow">
                            <input name="batchdel" onclick="javascript:f_batchDelCust();" type="button"
                            id="batchdel" value="批量删除" style="width:80px;"/>
                        </i>
                    </li>
                </ul>
            </div>
            <br/>
            <div id="maingrid">
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
    var g, manager;

    var gcheckbox = new $.ligerGridCheckboxVO({
        checkFieldName: 'custNum'
    });

    $(function() {
        $.expandAccordionMenu("custmenu");
        $("#regionCodes").ligerComboBox({
            width: 180,
            selectBoxWidth: 200,
            selectBoxHeight: 200,
            valueField: 'regionCode',
            textField: 'regionName',
            treeLeafOnly: false

        });
        f_initCustsDataGrid();
        f_initCustSearchData();
        

    });

    function f_initCustSearchData() {

        j4tg.ajaxPost("${ctx}/owner/wGetListCustsSearchInitData.action", "json", false, {},
        function(data) {
            if (data.status == "S") {
                //                 				alert(JSON.stringify(data));
                liger.get("regionCodes").setTree({
                    data: data.respData.regionCodes,
                    idFieldName: 'regionCode',
                    textFieldName: 'regionName',
                    slide: false,
                    parentIDFieldName: 'parentRegionCode'
                });
                liger.get("regionCodes").treeManager.collapseAll();
                if (data.searchParams) {

                    $("#hidCompanyName").val(data.searchParams['custSearch.companyName']);
                    $("#hidPhoneNum").val(data.searchParams['custSearch.phoneNum']);
                    $("#hidContactPerson").val(data.searchParams['custSearch.contactPerson']);
                    if(data.searchParams['custSearch.regionCodes']){
                    	$("#hidRegionCodes").val(data.searchParams['custSearch.regionCodes'].join(";"));
                    	$.selectComboBoxTreeNodes(liger.get("regionCodes"), data.searchParams['custSearch.regionCodes'].join(","), "regionCode");
                    }
                };
                
                $.reloadGridServerData(g, f_getCustsParam(),data.searchParams);

            }
        },
        function(data) {

		});

    }
    function f_initCustsDataGrid() {
        g = manager = $("#maingrid").ligerGrid({
            columns: [{
                display: '客户编号',
                name: 'custNum',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '用户名',
                name: 'custName',
                isSort: false,
                align: 'left',
                width: 100
            },
            {
                display: '星级',
                name: 'keyLevel',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
					var keyl=rowdata.keyLevel;
					if(keyl == 0){
						h = "普通用户";
					}else if(keyl == 1){
						h = "1星"
					}else if(keyl == 2){
						h = "2星"
					}else if(keyl == 3){
						h = "3星"
					}else if(keyl == 4){
						h = "4星"
					}else if(keyl == 5){
						h = "5星"
					}
                    
                    return h;

                }
            },
            {
                display: '公司名称',
                isSort: false,
                align: 'left',
                width: 210,
                render: function(rowdata, rowindex, value) {
                    var h = "";

                    h += "<a href='${ctx}/owner/wEditCust.action?custNum=" + rowdata.custNum + "'>" + rowdata.companyName + "</a> ";
                    return h;

                }
            },
            {
                display: '地区',
                name: 'regionName',
                width: 100,
                isSort: false,
                align: 'left'
            },
            {
                display: '行业',
                name: 'tradeName',
                width: 80,
                isSort: false,
                align: 'left'
            },
            {
                display: '联系人',
                name: 'contactPerson',
                width: 100,
                isSort: false,
                align: 'left'
            },
            {
                display: '联系电话',
                name: 'phoneNum',
                width: 100,
                isSort: false,
                align: 'center'
            },
            {
                display: '地址',
                name: 'address',
                width: 220,
                isSort: false,
                align: 'left'
            },
            //                { display: '登录时间', name: 'loginDate', width: 100, align: 'left' },   
            {
                display: '操作',
                isSort: false,
                align: 'center',
                width: 100,
                render: function(rowdata, rowindex, value) {
                    var h = "";
                    h += "<a href='javascript:f_resetCustPwd(" + rowindex + ")'><img src='${ctx}/images/ico/reset.png' alt='APP个性化定制开发' title='重置'/></a> ";
                    return h;

                }
            }],
            url: "${ctx}/owner/wListCustsData.action",
            pagesizeParmName: "wpagingRequest.perPageUnitNum",
            pageParmName: "wpagingRequest.currentPage",
            sortnameParmName: "sortParam.sortBy",
            sortorderParmName: "sortParam.sortType",
            pageSize: 20,
            method: "post",
            async: false,
            checkbox: true,
            onCheckRow: f_onCheckRow,
            onCheckAllRow: f_onCheckAllRow,
            enabledSort: true,
            enabledEdit: true,
            parms: f_getCustsParam(),
            dataAction: "server",
            clickToEdit: false,
            isScroll: false,
            frozen: false,
            pageSizeOptions: [20, 40],
            showTitle: false,
            width: 1260,
            columnWidth: 120,
            allowHideColumn: false,
            delayLoad:true
        });

    }
    function f_onCheckAllRow(checked) {
        gcheckbox.checkAllRow(g, checked);
    }

    function f_onCheckRow(checked, data) {
        gcheckbox.checkRow(checked, data);
    }

    function f_getCustsParam() {
        var companyname = $("#hidCompanyName").val();
        var contactperson = $("#hidContactPerson").val();
        var regioncodes = $("#hidRegionCodes").val().split(";");
        var phonenum = $("#hidPhoneNum").val();
 
        var param = {
            "custSearch.companyName": companyname,
            "custSearch.contactPerson": contactperson,
            "custSearch.regionCodes": regioncodes,
            "custSearch.phoneNum": phonenum,
            "redtfw":"Y"
        };
        return param;

    }

    function f_searchCust() {
        var companyname = $.trim($("#companyName").val());
        var contactperson = $.trim($("#contactPerson").val());
        var regioncodes = liger.get("regionCodes").getValue();
        var phonenum = $.trim($("#phoneNum").val());

        $("#hidCompanyName").val(companyname);
        $("#hidContactPerson").val(contactperson);
        $("#hidRegionCodes").val(regioncodes);
        $("#hidPhoneNum").val(phonenum);
        $.reloadGridServerData(g, f_getCustsParam());
    }

    function f_resetCustPwd(rowid) {

        var cust = manager.getRow(rowid);
        $.ligerDialog.confirm('确定重置密码么?',
        function(yes) {
            if (yes) {
                j4tg.ajaxPost("${ctx}/owner/mResetCustPwd.action", "json", false, {
                    "custNum": cust.custNum
                },
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('重置成功');
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_batchDelCust(rowid) {
        var checkedCusts = gcheckbox.getCheckedValue();
        if (checkedCusts.length == 0) {
            $.ligerDialog.error('请选择客户');
            return;
        }

        var param = {
            "custNums": checkedCusts
        };
        $.ligerDialog.confirm('确定要删除么?',
        function(yes) {
            if (yes) {

                j4tg.ajaxPost("${ctx}/owner/wBatchDelCust.action", "json", false, param,
                function(data) {
                    if (data.status == "S") {
                        $.ligerDialog.success('删除成功');
                        f_refreshCustGridData();
                    }
                },
                function(data) {

				});

            }
        });
    }

    function f_refreshCustGridData() {
        $.reloadGridServerData(g, f_getCustsParam());
        gcheckbox.initGridCheckboxStatus();
    }
</script>
</html>