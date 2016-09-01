var index = 1; //幻灯片播放选择按钮编号
var timeout;
var loadingPage = 1; //下拉加载当前页数
//var product_orginx = 0;
//var product_orginy = 0;
var isLoding = false;
var i = 5; //广告关闭时间
var isComShopping = false; //是否强制购物
var isAlertShow = false; //判断悬浮框是否显示
var isNoLoading = false; //是否停止滚动响应
var saveSearchKey = ""; //保存产品展示页面传递搜索条件
//var windowScrolly = 0;
var searchUserKey = 1; //搜索客户条件
var orderSearchKey = 1; //搜索订单条件
var myScroll, pullDownEl, pullDownOffset, pullUpEl;

var userName = "";
if (localStorage.userName !== undefined) {
    userName = (localStorage.userName).replace(/\"/g, ""); //用户名
}

var poppage = ""; //保存上一页
var pushpage = ""; //保存下一页
//var httpUrl = "http://" + window.location.host + "/";
var httpUrl = "http://taoguan.zzt.com/";
var errImg = httpUrl + "images/nopic.jpg";
var productIndex; //保存产品显示页产品信息
var IsToProductInfo = false; //是否从登陆跳转到产品信息
var defaultuImg = "images/nopic.jpg"; //默认图片目录
var proImgUrl = httpUrl; //图片根目录
var userUrlHead = httpUrl + "/cust/"; //用户链接头
var userLogin = "mLogin.action"; //用户登陆
var userGetProductList = "mListProducts.action"; //用户获取产品列表页
var userGetProductInfo = "mGetProductInfo.action"; //用户获取产品信息
var userGetProCats = "mListProdCats.action"; //用户获取产品分类
var userGetSuperPro = "mGetProductsList.action"; //用户获取特供商品
var userWaitingOrderList = "mUnauditedOrders.action"; //用户待审核订单
var userGetOrderList = "mListOrders.action"; //用户获取订单列表
//var userGetOrderInfo = "mGetOrderInfo.action";			//用户获取订单信息

var userGetGuestBooks = "mListGuestBooks.action"; //用户获取留言板信息
var userAddGuestBook = "mAddGuestBook.action"; //用户发表留言
var userAddOrder = "mAddOrigOrder.action"; //用户提交订单
var userGetCust = "mGetCust.action"; //获取用户个人信息
var userUpdateCust = "mUpdateCust.action"; //用户修改个人信息
var userUpdatePwd = "mUpdateCustPwd.action"; //用户修改密码
var userReg = "mRegCust.action"; //用户注册
var userExistCustname = "mExistCustname.action"; //用户名重复
var userGetAliasNTags = "mGetCustPushMessageAliasNTags.action"; //获取推送注册信息;
var adminUrlHead = httpUrl + "owner/"; //管理员链接头
var adminLogin = "mLogin.action"; //管理员登陆
var adminInfo = "mGetOwnerData.action"; //获取管理员信息
var adminGetOrderInfo = "mGetOrderInfo.action"; //管理员获取订单信息
var adminGetOrderList = "mListOrders.action"; //管理员获取订单列表
var adminUpdatePwd = "mUpdateOwnerAdminPwd.action"; //管理员修改密码
var adminUpdateStockBalance = "mUpdateProdDispStockBalance.action"; //管理员更新产品库存	
var adminUpadtePrice = "mUpdateProdPrice.action"; //管理员更新产品价格
var adminUserList = "mListCusts.action"; //管理员查看客户列表
//var adminGetAdImg = "mGetRecommendOwners.action";				        //管理员获取广告图片
var getIsLogin = "mGetLoginStatus.action"; //获取登陆状态
var getOwnerInfo = "mGetOwnerInfo.action"; //获取企业信息
var getBannerImg = "mGetOwnerBanners.action"; //获取Banner图片
var loginOut = "mLogout.action"; //退出登陆
var getSetting = "mGetOwnerSettingForceToLocal.action"; //强制购买
document.addEventListener("deviceready", onDeviceReady, false);
function onDeviceReady() {
    //首页加载完成后执行
    phonedealwith.isPhoneInternal = true;
    if (classverifiction.isMobile()) {
        document.addEventListener("offline", phonedealwith.onOffLineInternal, false);
        document.addEventListener("online", phonedealwith.onOnLineInternal, false);
        document.addEventListener("backbutton", phonedealwith.onBackKeyDown, false);
    }
}

/*函数功能:首页初始化入口*/
$(document).on('pageinit', '#index',
    function() {
        $("#indexMenuId").hide();
        $(".indexMenuIconBtn").css("bottom", "0px");
        $(".menu").hide();
        $("#index .all-tittle").show();
        myenvetclass.indexMenuEvent();
        if (classverifiction.isMobile()) {
            indexclass.initPhoneBtn();
        }
        setTimeout(function() {
                indexclass.indexDataInit();
            },
            500);
        document.getElementById('index').addEventListener('DOMContentLoaded', loaded('wrapper', 'indexPullDown', null, indexclass.indexRefresh, null, 'clickBlock', 46), false);
    });

/*函数功能:首页被隐藏*/
$(document).on("pagebeforehide", "#index",
    function() {
        indexclass.isIndex = false;
        $(".menu").show();
        $("#indexViewHide").hide();
        var indexMenuIdObj = $("#indexMenuId");
        indexMenuIdObj.hide();
        indexMenuIdObj.attr("data-isInit", "false");
        $(".indexMenuIconBtn").css("bottom", "0px");
        $("#indexMenuImg").attr("src", "img/indexview/ttop.png");
        poppage = "#index";
        indexclass.isIndexMenuOpen = false;
    });
$(document).on('pagebeforeshow', '#index',
    function() {
        if (classlogin.isLoginToIndex === false) {
            $("#indexViewHide").hide();
        }
        classlogin.isLoginToIndex = false;
    });
/*函数功能:首品页显示*/
$(document).on("pageshow", "#index",
    function() {
        indexclass.isIndex = true;
        //	$(".menu").hide();
    });

/*函数功能:产品展示页面初始化入口*/
$(document).on('pageinit', '#product',
    function() {
        ios7navInit();
        myenvetclass.proListShow();
        myenvetclass.proSearchShow();
    });
$(document).on('pagebeforeshow', '#product',
    function() {
        $("#container1").show();
        setTimeout(function() {
                productshow.prodcutInit();
            },
            500);
    });
$(document).on("pagebeforehide", "#product",
    function() {
        myenvetclass.ScrollEnvetRelease();
        $(".productcontent").html("");
        $(".noMore").hide();
        menuClose();
    });
$(document).on("pageshow", "#product",
    function() {
        myenvetclass.method = productshow.loadData;
        setTimeout(function() {
                myenvetclass.myScrollEnvet([]);
            },
            500);
    });
$(document).on('pageinit', '#proSearch',
    function() {
        ios7navInit();
        $("#container1").hide();
        productshow.proMenuIconLayout();

    });
$(document).on('pagebeforeshow', '#proSearch',
    function() {});
$(document).on("pagebeforehide", "#proSearch",
    function() {
        menuClose();
    });
$(document).on("pageshow", "#proSearch",
    function() {
        $(".proCateSearch").attr("href", "javascript:void(0)");
    });

$(document).on('pageinit', '#allListProShow',
    function() {
        ios7navInit();
        myenvetclass.proSearchShow();
    });
$(document).on('pagebeforeshow', '#allListProShow',
    function() {
        setTimeout(function() {
                productshow.allProShowStyleTwo();
            },
            500);
        $("#container1").show();
    });
$(document).on("pagebeforehide", "#allListProShow",
    function() {
        menuClose();
        $(".allProList ul").html("");
        $(".proListMore").hide();
        myenvetclass.ScrollEnvetRelease();
    });
$(document).on("pageshow", "#allListProShow",
    function() {
        myenvetclass.method = productshow.allProShowStyleTwo;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*产品分类*/
$(document).on('pageinit', '#page2-1',
    function() {
        ios7navInit();
    });
$(document).on('pagebeforeshow', '#page2-1',
    function() {
        if (saveSearchKey !== "") {
            searchclass.searchKey = saveSearchKey;
            saveSearchKey = "";
        }
        if (getUrlParm("prodName") !== "" || getUrlParm("prodCatId") !== "") {
            setTimeout(function() {
                    searchclass.userSearchPro(getUrlParm("prodName"), getUrlParm("prodCatId"));
                },
                500);
        } else {}
    });
$(document).on("pagebeforehide", "#page2-1",
    function() {
        myenvetclass.ScrollEnvetRelease();
        $(".fproMore").hide();
        menuClose();
    });
$(document).on("pageshow", "#page2-1",
    function() {
        myenvetclass.method = searchclass.userSearchPro;
        myenvetclass.args = [searchclass.searchKey, ""];
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能：产品详细信息页面初始化*/
$(document).on('pageinit', '#page2-2',
    function() {
        ios7navInit();
        var detailedTitle = $(".detailed-tittle h5");
        $("#send").hide();
        $(".quantity").hide();
        $("#goToDetailed").hide();
        $("#goToTaoBao").hide();
        if (getUrlParm("prodNum") !== "") {
            setTimeout(function() {
                    userproduct.getDetailed(getUrlParm("prodNum"));
                },
                500);
        }
        myenvetclass.proDetailClickEvent();
        myenvetclass.addShopping("tb-stockminus", "tb-stockadd");
    });
$(document).on("pagebeforehide", "#page2-2",
    function() {
        $("#addNum").val("0");
        $(".menu").show();
        menuClose();
        $(".ampImgLayer").hide();
        $(".ampImgBg").html("");
        $(".closeAmpImg").hide();
        $(".myAlertView").hide();
    });
$(document).on("pagebeforeshow", "#page2-2",
    function() {
        $(".menu").hide();
    });
$(document).on("pageshow", "#page2-2",
    function() {});

/*函数功能:留言板页面初始化入口*/
$(document).on('pageinit', '#message',
    function() {
        ios7navInit();
        myenvetclass.addMessage();
        //	closeAlert("#message");
    });
$(document).on('pagebeforeshow', '#message',
    function() {
        $("#container1").show();
        setTimeout(function() {
                messageboards.getMessage();
            },
            500);
    });
$(document).on("pagebeforehide", "#message",
    function() {
        $(".allMessageList").html("");
        $(".messageView #messageContent").html("");
        myenvetclass.ScrollEnvetRelease();
        $(".noMessage").hide();
        menuClose();
        closeAlert('#message');
        $(".myAlertView").hide();

    });
$(document).on("pageshow", "#message",
    function() {
        myenvetclass.method = messageboards.getMessage;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能:用户登陆页初始化入口*/
$(document).on('pageinit', '#userlogin',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.userRegisterClickEnvet();
        myenvetclass.userLoginClickEnvet();
    });
$(document).on('pagebeforeshow', '#userlogin',
    function() {
        if (classlogin.isUserOrAdminBack === true && classlogin.isRegister === false) {
            $("#userLoginHide").show();
            $.mobile.back();
            classlogin.isUserOrAdminBack = false;
        }
    });
$(document).on("pagebeforehide", "#userlogin",
    function() {
        menuClose();
        $("#userpassword").val("");
        $(".allMessage .alertViewBg").hide();
        $(".allMessage .alertViewBg2").hide();
        $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','')");
        $(".allMessage .alertMessage").html("提&nbsp;&nbsp;&nbsp;&nbsp;示");
        $("#userLoginHide").hide();
        if (classlogin.userLoginState === false) {
            classlogin.isUserOrAdminBack = false;
        }
        if (classlogin.isRegister === true) {
            classlogin.isRegister = false;
        }

    });
$(document).on("pageshow", "#userlogin",
    function() {});

/*函数功能:用户注册页初始化入口*/
$(document).on('pageinit', '#register',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.sendRegisterInfo();
    });
$(document).on('pagebeforeshow', '#register',
    function() {});
$(document).on("pagebeforehide", "#register",
    function() {
        menuClose();
        $("#raccount").val("");
        $("#rpassword").val("");
        $("#rpasswordok").val("");
        $("#rname").val("");
        $("#rcompanyName").val("");
        closeAlert('.allMessage');
        $(".myAlertView").hide();

    });
$(document).on("pageshow", "#register",
    function() {});

/*函数功能:个人中心页初始化入口*/
$(document).on('pageinit', '#personal',
    function() {
        $("#container1").hide();
        ios7navInit();
        myenvetclass.personalItemEvent();
    });
$(document).on("pagebeforeshow", "#personal",
    function() {});
$(document).on("pagebeforehide", "#personal",
    function() {
        menuClose();
        closeAlert('#personal');
    });
$(document).on("pageshow", "#personal",
    function() {
        registclass.userGetInfo();
        var loca = location.hash.split("#", 2)[1];
    });

/*函数功能:修改个人信息页初始化入口*/
$(document).on('pageinit', '#userModifyInfo',
    function() {
        ios7navInit();
        registclass.userGetInfo();
        $("#container1").hide();
        myenvetclass.userUpdateInfo();
    });
/*函数功能:修改个人信息页被加载*/
$(document).on('pagebeforeshow', '#userModifyInfo',
    function() {});
$(document).on("pagebeforehide", "#userModifyInfo",
    function() {
        menuClose();
        closeAlert('.allMessage');
        $(".myAlertView").hide();
    });
$(document).on("pageshow", "#userModifyInfo",
    function() {});

/*函数功能:修改密码页初始化入口*/
$(document).on('pageinit', '#userModifyPass',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.userUpdatePass();
    });
$(document).on('pagebeforeshow', '#userModifyPass',
    function() {});
$(document).on("pagebeforehide", "#userModifyPass",
    function() {
        menuClose();
        closeAlert('.allMessage');
        $(".myAlertView").hide();
    });
$(document).on("pageshow", "#userModifyPass",
    function() {});

/*函数功能:联系我们页面初始化入口*/
$(document).on('pageinit', '#about',
    function() {
        ios7navInit();
        var uiBar = $(".ui-bar-y");
        var bary = 48;
        $("#container1").show();
        setTimeout(function() {
                classownerinfo.getContactInfo();
            },
            500);
        if (uiBar.height() > 0) {
            bary = uiBar.height();
        }
        myenvetclass.aboutAndContact();
        $("#contenttext").height(document.body.clientHeight - ($(".ui-bar-x").height() + bary + 52));

    });
$(document).on("pagebeforehide", "#about",
    function() {
        menuClose();
    });
$(document).on("pagebeforeshow", "#about",
    function() {});
$(document).on("pageshow", "#about",
    function() {});

$(document).on('pageinit', '#contact',
    function() {
        ios7navInit();
        $("#contenttexts").height(300);
        setTimeout(function(){
                classownerinfo.getContactInfo();
            },
            500);
        myenvetclass.aboutAndContact();
    });
$(document).on("pagebeforehide", "#contact",
    function() {
        menuClose();
    });
$(document).on("pageshow", "#contact",
    function() {
        $("#container1").hide();
        setTimeout(function() {
                mapInit(classownerinfo.longi, classownerinfo.lati);
            },
            300);
    });

/*函数功能:购物车内容页面初始化*/
$(document).on('pageinit', '#page5',
    function() {
        ios7navInit();
        $("#orderSendBtn").hide();
        myenvetclass.sendShoppingOrder();
    });
$(document).on("pagebeforehide", "#page5",
    function() {
        $(".shoppingBack").attr("href", "#personal");
        menuClose();
        closeAlert('.allMessage');
        $(".promptText").hide();
        $(".shoppingBg").html("");
        $(".myAlertView").hide();
        closeAlert('#page5');
    });
$(document).on("pageshow", "#page5",
    function() {});
/*函数功能:购物车页面被加载*/
$(document).on('pagebeforeshow', '#page5',
    function() {
        $("#container1").show();
        setTimeout(function() {
                userproduct.getShoppingInfo();
            },
            500);
    });

/*函数功能:客户查询待审核订单列表*/
$(document).on('pageinit', '#userWaitingAudit',
    function() {
        ios7navInit();
    });
$(document).on('pagebeforeshow', '#userWaitingAudit',
    function() {
        $("#container1").show();
        setTimeout(function() {
                manageorder.userShowWaitingList();
            },
            500);
    });
$(document).on("pagebeforehide", "#userWaitingAudit",
    function() {
        myenvetclass.ScrollEnvetRelease();
        $(".userWaitingOrder").html("");
        $(".noMyWaitingOrder").hide();
        $("#userWaitingAudit .all-tittle").hide();
        manageorder.orderNum = 0;
        menuClose();
    });
$(document).on("pageshow", "#userWaitingAudit",
    function() {
        myenvetclass.method = manageorder.userShowWaitingList;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能:客户查询订单列表*/
$(document).on('pageinit', '#myorder',
    function() {
        ios7navInit();
    });
$(document).on('pagebeforeshow', '#myorder',
    function() {
        $(".noMyOrder").hide();
        $("#container1").show();
        setTimeout(function() {
                manageorder.userShowOrderList();
            },
            500);
    });
$(document).on("pagebeforehide", "#myorder",
    function() {
        myenvetclass.ScrollEnvetRelease();
        manageorder.orderNum = 0;
        $(".userOrderList").html("");
        $("#myorder .all-tittle").hide();
        menuClose();
    });
$(document).on("pageshow", "#myorder",
    function() {
        myenvetclass.method = manageorder.userShowOrderList;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

$(document).on('pageinit', '#superPro',
    function() {
        ios7navInit();
    });
$(document).on('pagebeforeshow', '#superPro',
    function() {
        setTimeout(function() {
                productshow.superProList();
            },
            500);
        $("#container1").show();
    });
$(document).on("pagebeforehide", "#superPro",
    function() {
        $(".waterfall-ri").html("");
        $(".waterfall-le").html("");
        $(".superProMore").hide();
        menuClose();
        myenvetclass.ScrollEnvetRelease();
    });
$(document).on("pageshow", "#superPro",
    function() {
        myenvetclass.method = productshow.superProList;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能:管理员登陆页初始化入口*/
$(document).on('pageinit', '#pageadminlogin',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.adminLoginClickEvent();
    });
$(document).on('pagebeforeshow', '#pageadminlogin',
    function() {
        if (classlogin.isUserOrAdminBack === true) {
            $("#adminLoginHide").show();
            $.mobile.back();
            classlogin.isUserOrAdminBack = false;
        }
    });
$(document).on("pagebeforehide", "#pageadminlogin",
    function() {
        menuClose();
        $("#adminpassword").val("");
        $("#adminLoginHide").hide();
        if (classlogin.adminLoginState === false) {
            classlogin.isUserOrAdminBack = false;
        }
    });
$(document).on("pageshow", "#pageadminlogin",
    function() {});

/*函数功能:管理员界面页初始化入口*/
$(document).on('pageinit', '#adminMenu',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.adminMenuItemEvent();
    });
$(document).on('pagebeforeshow', '#pageadminlogin',
    function() {});
$(document).on("pagebeforehide", "#adminMenu",
    function() {
        menuClose();
        closeAlert('#adminMenu');
    });
$(document).on("pageshow", "#adminMenu",
    function() {
        registclass.adminGetInfo();
    });

/*函数功能:管理员查询客户订单列表页初始化入口*/
$(document).on('pageinit', '#adminselectorder',
    function() {
        ios7navInit();
        myenvetclass.adminSearchOrderKey();
        myenvetclass.adminOpenSearchKey();
        myenvetclass.adminSearchOrderBtn();
    });
$(document).on('pagebeforeshow', '#adminselectorder',
    function() {
        $("#container1").show();
        setTimeout(function() {
                manageorder.adminShowOrderList();
            },
            500);
    });
$(document).on("pagebeforehide", "#adminselectorder",
    function() {
        myenvetclass.ScrollEnvetRelease();
        manageorder.userNum = "";
        $(".noOrder").hide();
        $(".aorderList").html("");
        $("#aSOrderBack").attr('href', '#adminMenu');
        menuClose();
    });
$(document).on("pageshow", "#adminselectorder",
    function() {
        myenvetclass.method = manageorder.adminShowOrderList;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能:管理员查询客户订单详情页初始化入口*/
$(document).on('pageinit', '#orderinfo',
    function() {
        ios7navInit();
        $("#container1").hide();
    });
$(document).on("pagebeforehide", "#orderinfo",
    function() {
        menuClose();
    });
$(document).on("pageshow", "#orderinfo",
    function() {});

/*函数功能:管理员查看产品列表页初始化入口*/
$(document).on('pageinit', '#adminProManage',
    function() {
        ios7navInit();
        myenvetclass.adminSearchBtnClickEvent();
    });
/*函数功能:管理员查看产品列表页被加载*/
$(document).on('pagebeforeshow', '#adminProManage',
    function() {
        $("#container1").show();
        setTimeout(function() {
                admingetprodata.adminGetProList();
            },
            500);
    });
$(document).on("pagebeforehide", "#adminProManage",
    function() {
        myenvetclass.ScrollEnvetRelease();
        admingetprodata.pageNum = 0;
        admingetprodata.aNameKey = "";
        $(".proShowList ul").html("");
        $(".anoMorePro").hide();
        menuClose();
    });
$(document).on("pageshow", "#adminProManage",
    function() {
        myenvetclass.method = admingetprodata.adminGetProList;
        myenvetclass.args = [admingetprodata.aNameKey];
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*函数功能:管理员修改密码页初始化入口*/
$(document).on('pageinit', '#adminModifyPass',
    function() {
        ios7navInit();
        $("#container1").hide();
        myenvetclass.updateAdminPass();
    });
$(document).on('pagebeforeshow', '#adminModifyPass',
    function() {});
$(document).on("pagebeforehide", "#adminModifyPass",
    function() {
        menuClose();
        closeAlert('.allMessage');
        $(".myAlertView").hide();
    });
$(document).on("pageshow", "#adminModifyPass",
    function() {});

/*函数功能:管理员搜索客户页初始化入口*/
$(document).on('pageinit', '#clientsearch',
    function() {
        ios7navInit();
        myenvetclass.adminSearch()
    });
/*函数功能:管理客户页面被加载*/
$(document).on('pagebeforeshow', '#clientsearch',
    function() {
        $("#container1").show();
        setTimeout(function() {
                searchclass.adminSearchUserInfo();
            },
            500);
    });
$(document).on("pagebeforehide", "#clientsearch",
    function() {
        searchclass.searchName = "";
        searchclass.searchArea = "";
        searchclass.searchPhone = "";
        $(".center-order").html("");
        $(".searUserMore").hide();
        $("#custSearch").val("");
        myenvetclass.ScrollEnvetRelease();
        menuClose();
    });
$(document).on("pageshow", "#clientsearch",
    function() {
        myenvetclass.method = searchclass.adminSearchUserInfo;
        setTimeout(function() {
                myenvetclass.myScrollEnvet();
            },
            500);
    });

/*首页类*/
var indexClass = {
    isIndex: false,
    isIndexMenuOpen: false,
    indexSwiper: null,
    //初始化首页电话按钮
    initPhoneBtn: function() {
        var param = {};
        var eurl = adminUrlHead + getOwnerInfo;
        var fun = function(data) {
            if (data.status === "S") {
                myenvetclass.phonenum = "tel://" + data.respData.phoneNum.replace(/\s/g, "");
            } else {}
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    /** 获取banner条图片类方法**/
    getIndexBanner: function() {
        var param = {};
        var eurl = adminUrlHead + getBannerImg;
        var fun = function(data) {
            if (data.status === "S") {
                var array_banner = data.respData;
                var standbyUrl = "";
                var myimg = "";
                if (array_banner.length < 1) {
                    myimg += "<div class='swiper-slide'><a href='javascript:void(0)'><img src='http://zzt.etaoguan.com/images/nopic.jpg' onerror=this.src='" + errImg + "' style='height:100%;'></a> </div>";
                    var myimgcontent = "<div class='swiper-wrapper' id='silderclass'>" + myimg + "</div><div class='ipagination'></div><div class='repair'>.</div>";
                    $(".indexSwiper .swiper-container").append(myimgcontent);
                }
                for (var j = 0,
                         len = array_banner.length; j < len; j++) {
                    standbyUrl = imgLink(array_banner[j].imgUrl);
                    if (array_banner[j].linkType === 0) {
                        myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='seldetail'  data-iswindow='true' data-aliurl='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'></a> </div>";
                    } else {
                        myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'></a> </div>";
                    }
                }
                if (array_banner.length > 0) {
                    var myimgcontent = "<div class='swiper-wrapper' id='silderclass'>" + myimg + "</div><div class='ipagination'></div><div class='repair'>.</div>";
                    $(".indexSwiper .swiper-container").append(myimgcontent);
                }
                indexclass.indexSwiper = new Swiper('.indexSwiper .swiper-container', {
                    pagination: '.ipagination',
                    loop: true,
                    grabCursor: true,
                    paginationClickable: true
                });
                $("#container1").hide();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //banner刷新数据
    bannerRefresh: function() {
        indexclass.indexSwiper.swipeTo(0, 0, false);
        indexclass.indexSwiper.removeAllSlides();
        var standbyUrl = "";
        var param = {};
        var eurl = adminUrlHead + getBannerImg;
        var fun = function(data) {
            if (data.status === "S") {
                var array_banner = data.respData;
                if (array_banner.length < 1) {
                    indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)'><img src='" + errImg + "' onerror=this.src='" + errImg + "' style='height:200px;'></a> ");
                }
                for (var j = 0,
                    len = array_banner.length; j < len; j++) {
                    standbyUrl = imgLink(array_banner[j].imgUrl);
                    if (array_banner[j].linkType === 0) {
                        indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)' class='seldetail'  data-iswindow='true' data-aliurl='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:200px;'></a>");
                    } else {
                        indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:200px;'></a> ");
                    }
                }
                myenvetclass.selectDetailed();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    /** 获取新产品内容类方法**/
    getIndexNewProduct: function() {
        var standbyUrl = "";
        var standbyUrl1 = "";
        var newProLength = 0;
        var lastPro = 0;
        var nextPro = 0;
        var param = {

            "prodSearch.prodName": "",
            "prodSearch.newFlag": 1,
            "mpagingRequest.perPageUnitNum": 6,
            "mpagingRequest.currentPage": 1
        };
        var eurl = userUrlHead + userGetProductList;
        var fun = function(data) {
            if (data.status === "S") {
                $(".newProDynamic").html("");
                var array_newproduct = data.respData.dataList;
                if (array_newproduct.length === 1) {
                    newProLength = 2;
                } else if (array_newproduct.length % 2 > 0) {
                    newProLength = array_newproduct.length - 1
                } else {
                    newProLength = array_newproduct.length;
                }
                for (var i = 0,
                         len = newProLength; i < len; i += 2) {
                    if (array_newproduct.length === 1) {
                        lastPro = 1;
                        nextPro = 1;
                    } else {
                        lastPro = i;
                        nextPro = i + 1;
                    }
                    standbyUrl = imgLink(array_newproduct[lastPro].firstProdImg);
                    standbyUrl1 = imgLink(array_newproduct[nextPro].firstProdImg);
                    $(".newProDynamic").append("<div class='new-list'><div class='new-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_newproduct[lastPro].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "' ><p>" + array_newproduct[lastPro].prodName + "</p></a><ul><li><span></span><strong>¥" + array_newproduct[lastPro].stdPrice + "</strong></li></ul></div><div class='new-ri'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_newproduct[nextPro].prodNum + "'><img src='" + standbyUrl1 + "' onerror=this.src='" + errImg + "'><p>" + array_newproduct[nextPro].prodName + "</p></a><ul><li><span></span><strong>¥" + array_newproduct[nextPro].stdPrice + "</strong></li></ul></div></div>");
                }
                myenvetclass.selectDetailed();
                $("#newProId").show();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //首页全部产品摘要
    indexAllProBreviary: function() {
        var standbyUrl = "";
        var standbyUrl1 = "";
        var standbyUrl2 = "";
        var proLength = 0;
        var lastPro = 0;
        var nextPro = 0;
        var nextTwoPro = 0;
        var param = {

            "prodSearch.prodName": "",
            "prodSearch.newFlag": -1,
            "prodSearch.hotFlag": -1,
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": 1
        };
        var eurl = userUrlHead + userGetProductList;
        var fun = function(data) {
            if (data.status === "S") {
                $(".allProShow").html("");
                var array_product = data.respData.dataList;
                if (array_product.length === 1) {
                    proLength = 3;
                } else if (array_product.length % 3 > 0) {
                    proLength = array_product.length - array_product.length % 3
                } else {
                    proLength = array_product.length;
                }
                for (var i = 0,
                         len = proLength; i < len; i += 3) {
                    if (array_product.length === 1) {
                        lastPro = 1;
                        nextPro = 1;
                        nextTwoPro = 1;
                    } else {
                        lastPro = i;
                        nextPro = i + 1;
                        nextTwoPro = i + 2;
                    }
                    standbyUrl = imgLink(array_product[lastPro].firstProdImg);
                    standbyUrl1 = imgLink(array_product[nextPro].firstProdImg);
                    standbyUrl2 = imgLink(array_product[nextTwoPro].firstProdImg);
                    $(".allProShow").append("<div class='new-list'><div class='all-pro-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[lastPro].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'><p>" + array_product[lastPro].prodName + "</p></a><span> </span><strong>¥" + array_product[lastPro].stdPrice + "</strong></div><div class='all-pro-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[nextPro].prodNum + "'><img src='" + standbyUrl1 + "' onerror=this.src='" + errImg + "'><p>" + array_product[nextPro].prodName + "</p></a><span> </span><strong>¥" + array_product[nextPro].stdPrice + "</strong></div><div class='all-pro-ri'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[nextTwoPro].prodNum + "'><img src='" + standbyUrl2 + "' onerror=this.src='" + errImg + "'><p>" + array_product[nextTwoPro].prodName + "</p></a><span> </span><strong>¥" + array_product[nextTwoPro].stdPrice + "</strong></div></div>");
                }
                myenvetclass.selectDetailed();
                $("#allProId").show();
                $("#moreProBtnId").show();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    indexDataInit: function() {
        indexclass.getIndexBanner();
        indexclass.getIndexNewProduct();
        indexclass.indexAllProBreviary();
    },

    //首页所有数据刷新
    indexRefresh: function() {
        indexclass.bannerRefresh();
        indexclass.getIndexNewProduct();
        indexclass.indexAllProBreviary();
    }
};

/*产品展示类*/
var productShowClass = {
    titleClassNameLeft: "proTitleNameLeft",
    //文字Class名
    priceClassNameRight: "proTitlePriceRight",
    //文字Class名
    //**产品列表初始化
    prodcutInit: function() {
        this.getProduct();
    },

    //** 获取产品内容
    getProduct: function() {
        var param = {

            "prodSearch.prodName": "",
            "prodSearch.newFlag": -1,
            "prodSearch.hotFlag": -1,
            "mpagingRequest.perPageUnitNum": 14,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userGetProductList;
        var fun = function(data) {
            if (data.status === "S") {
                var product_style = 0;
                var product_row = 0;
                var product_rowindex = 1;
                //				  var product_contentwidth = $(".productcontent").width();
                var product_content = "";
                var array_product = data.respData.dataList;
                var standbyUrl = "";
                if (array_product.length == 0) {
                    isNoLoading = true;
                    $(".noMore").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }
                for (var i = 0,
                         len = array_product.length; i < len; i++) {
                    standbyUrl = imgLink(array_product[i].firstProdImg);
                    if (product_row === i) {
                        product_rowindex = 1;
                        if ((array_product.length - i) === 1) {
                            product_style = 5;
                        } else if ((array_product.length - i) === 2) {
                            product_style = 4;
                            product_row += 2;
                        } else {
                            product_style = Math.floor(Math.random() * 5);
                            if (product_style === 0) {
                                product_style = 1;
                            }
                            switch (product_style) {
                                case 1:
                                case 2:
                                case 3:
                                    product_row += 3;
                                    break;
                                case 4:
                                    product_row += 2;
                                    break;
                            }
                        }
                    }
                    switch (product_style) {
                        case 1:
                            switch (product_rowindex) {
                                case 1:
                                    var div = "<div class='proshowpanl1'>";
                                    var str = productshow.imageAndTextCareate("proshowcontent1", "proshowcontentimg1", "proshowcotenttextview1", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");

                                    product_content = div + str;
                                    $(".productcontent").append(product_content);
                                    product_rowindex++;
                                    product_content = "";
                                    break;
                                case 2:
                                    var div1 = "<div class='proshowpanl2'>";
                                    var str1 = productshow.imageAndTextCareate("proshowcontentlink2", "proshowcontentimg2", "proshowcotenttextview2", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content = div1 + str1;
                                    product_rowindex++;
                                    break;
                                case 3:
                                    var str2 = productshow.imageAndTextCareate("proshowcontentlink2", "proshowcontentimg2", "proshowcotenttextview3", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content += str2 + "</div> ";
                                    $(".productcontent").append(product_content);
                                    product_content = "";
                                    product_rowindex++;
                                    break;
                            }
                            break;
                        case 2:
                            switch (product_rowindex) {
                                case 1:
                                    var div1 = "<div class='proshowview1'>";
                                    var div2 = "<div class='proshowpanl4'>";
                                    var str = productshow.imageAndTextCareate("proshowcontentlink4", "proshowcontentimg4", "proshowcotenttextview4", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "right");
                                    product_content = div1 + div2 + str;
                                    product_rowindex++;
                                    break;
                                case 2:
                                    var str = productshow.imageAndTextCareate("proshowcontentlink5", "proshowcontentimg4", "proshowcotenttextview5", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "right");
                                    product_content += str + "</div>";
                                    product_rowindex++;
                                    break;
                                case 3:

                                    var div3 = "<div class='proshowpanl6'>";
                                    var str = productshow.imageAndTextCareate("proshowcontentlink6", "proshowcontentimg6", "proshowcotenttextview6", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "right");
                                    product_content += div3 + str;
                                    $(".productcontent").append(product_content);
                                    product_rowindex++;
                                    product_content = "";
                                    break;
                            }
                            break;
                        case 3:
                            switch (product_rowindex) {
                                case 1:
                                    var div = "<div class='proshowview2'>";
                                    var str = productshow.imageAndTextCareate("proshowcontentlink7", "proshowcontentimg7", "proshowcotenttextview7", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content = div + str;
                                    product_rowindex++;
                                    break;
                                case 2:
                                    var str = productshow.imageAndTextCareate("proshowcontentlink8", "proshowcontentimg8", "proshowcotenttextview8", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content += str;
                                    product_rowindex++;
                                    break;
                                case 3:
                                    var str = productshow.imageAndTextCareate("proshowcontentlink9", "proshowcontentimg9", "proshowcotenttextview9", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content += str + "</div>";
                                    $(".productcontent").append(product_content);
                                    product_content = "";
                                    product_rowindex++;
                                    break;
                            }
                            break;
                        case 4:
                            switch (product_rowindex) {
                                case 1:
                                    var div = "<div class='proshowview3'>";
                                    var str = productshow.imageAndTextCareate("proshowcontentlink10", "proshowcontentimg10", "proshowcotenttextview10", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content = div + str;
                                    product_rowindex++;
                                    break;
                                case 2:
                                    var str = productshow.imageAndTextCareate("proshowcontentlink11", "proshowcontentimg11", "proshowcotenttextview11", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                                    product_content += str + "</div> ";
                                    $(".productcontent").append(product_content);
                                    product_content = "";
                                    product_rowindex++;
                                    break;
                            }
                            break;
                        case 5:
                            var div = "<div class='proshowview4'>";
                            var str = productshow.imageAndTextCareate("proshowcontentlink12", "proshowcontentimg12", "proshowcotenttextview12", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                            product_content = div + str;
                            var str1 = productshow.imageAndTextCareate("proshowcontentlink13", "proshowcontentimg13", "proshowcotenttextview13", productshow.titleClassNameLeft, productshow.priceClassNameRight, array_product[i].prodNum, standbyUrl, array_product[i].prodName, array_product[i].stdPrice, array_product[i].unit, "left");
                            product_content += str1 + "</div>";
                            $(".productcontent").append(product_content);
                            product_content = "";
                            break;
                    }
                }
                $("#container1").hide();
                myenvetclass.selectDetailed();
                productshow.imageAndTextSize(); //图片大小变化
                if ($(".content").width() >= 768) {
                    $(".proTitleNameLeft").css("font-size", "25px");
                    $(".proTitleNameLeft").css("line-height", "25px");
                    $(".proTitlePriceRight").css("font-size", "23px");
                    $(".proTitlePriceRight").css("line-height", "23px");
                    $(".proTitlePriceRight").css("font-size", "23px");
                    $(".proTitlePriceRight").css("line-height", "23px");
                } else if ($(".content").width() < 768 && $(".content").width() >= 540) {
                    $(".proTitleNameLeft").css("font-size", "18px");
                    $(".proTitleNameLeft").css("line-height", "18px");
                    $(".proTitlePriceRight").css("font-size", "16px");
                    $(".proTitlePriceRight").css("line-height", "16px");
                    $(".proTitlePriceRight").css("font-size", "16px");
                    $(".proTitlePriceRight").css("line-height", "16px");
                } else {
                    $(".proTitleNameLeft").css("font-size", "12px");
                    $(".proTitleNameLeft").css("line-height", "12px");
                    $(".proTitlePriceRight").css("font-size", "10px");
                    $(".proTitlePriceRight").css("line-height", "10px");
                    $(".proTitlePriceRight").css("font-size", "10px");
                    $(".proTitlePriceRight").css("line-height", "10px");
                }

                if (array_product.length < 9) {
                    $(".noMore").show();
                    isNoLoading = true;
                    hideLoader();
                    return;
                }

                loadingPage++;
                hideLoader();
                isLoding = false;;
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //产品图片生成创建
    imageAndTextCareate: function(linkCName, imgCName, viewCName, titleCName, priceCName, strProNum, strImgUrl, strProName, strProPrice, strProUnit, dire) {
        var Str = "";
        Str = "<div class='" + viewCName + "' align='" + dire + "'><div class='" + titleCName + "'>" + textLengthTrim(textLengthCut(strProName)) + "</div><div class='" + priceCName + "'>" + strProPrice + "元/" + strProUnit + "</div></div><div class='" + linkCName + "'><a href='javascript:void(0)' class='seldetail' data-myindex='" + strProNum + "'><img src='" + strImgUrl + "' onerror=this.src='" + errImg + "' class='" + imgCName + "'></a></div>"
        return Str;
    },

    //产品图片大小加载
    imageAndTextSize: function() {
        var product_contentwidth = $(".productcontent").width();
        /** 风格一:1-3 **/
        /** 风格二:4-6 **/
        /** 风格三:7-9 **/
        /** 风格四:10-11 **/
        /** 风格五:12-13 **/
        $(".proshowcontent1,.proshowpanl1,.proshowcontent1,.proshowcontentimg1,.proshowcotenttextview1,.proshowpanl6,.proshowcontentimg6,.proshowcotenttextview6").width((product_contentwidth - 6) * 0.67);
        $(".proshowcontentimg1,.proshowcotenttextview1,.proshowcontentimg6,.proshowcotenttextview6,.proshowview1,.proshowpanl2").height((product_contentwidth - 6) * 0.67);
        $(".proshowpanl2,.proshowcontentlink2,.proshowcontentimg2,.proshowcotenttextview2,.proshowcotenttextview3,.proshowpanl4,.proshowcontentimg4,.proshowcotenttextview4,.proshowcotenttextview5,.proshowcontentimg9").width((product_contentwidth - 8) - ((product_contentwidth - 6) * 0.67));
        $(".proshowcontentlink2,.proshowcontentimg2,.proshowcontentimg4").height(((product_contentwidth - 6) * 0.67 - 2) / 2);
        $(".proshowcotenttextview2,.proshowcotenttextview3,.proshowcotenttextview4,.proshowcotenttextview5").height((product_contentwidth - 5) - ((product_contentwidth - 6) * 0.67));
        $(".proshowcotenttextview3").css("margin-top", (((product_contentwidth) * 0.67 - 2) / 2));
        $(".proshowview1").width(product_contentwidth);
        $(".proshowcotenttextview4").css("margin-top", (((product_contentwidth) * 0.67 - 2) / 2));
        $(".proshowview2").width(product_contentwidth - 4);
        $(".proshowcontentimg7,.proshowcotenttextview7,.proshowcontentimg7,.proshowcontentimg8,.proshowcotenttextview8,.proshowcotenttextview9").width(((product_contentwidth - 6) * 0.67 - 2) / 2);
        $(".proshowcontentimg7,.proshowcotenttextview7,.proshowcontentimg7,.proshowcontentimg8,.proshowcontentimg9,.proshowcotenttextview8,.proshowcotenttextview9").height(((product_contentwidth - 6) * 0.67 - 2) / 2);

        $(".proshowcotenttextview8").css("margin-left", (((product_contentwidth - 6) * 0.67) / 2));
        $(".proshowcotenttextview9").css("margin-left", ((product_contentwidth - 2) * 0.67));
        //风格四、五
        $(".proshowview3,.proshowview4").width(product_contentwidth - 2);
        $(".proshowcontentimg10,.proshowcontentimg11,.proshowcontentimg12,.proshowcontentimg13").width((product_contentwidth - 6) * 0.5);
        $(".proshowcontentimg10,.proshowcontentimg11,.proshowcontentimg12,.proshowcontentimg13").height((product_contentwidth - 6) * 0.5);
        $(".proshowcotenttextview10,.proshowcotenttextview11,.proshowcotenttextview12,.proshowcotenttextview13").width((product_contentwidth - 2) * 0.5);
        $(".proshowcotenttextview10,.proshowcotenttextview11,.proshowcotenttextview12,.proshowcotenttextview13").height((product_contentwidth - 2) * 0.5);
        $(".proshowcotenttextview11,.proshowcotenttextview13").css("margin-left", ((product_contentwidth - 2) * 0.5));
    },

    // 产品加载
    loadData: function() {
        if (isNoLoading == false) {
            productshow.getProduct();
        }
    },

    producRefresh: function() {
        loadingPage = 1;
        productshow.getProduct("true");
    },

    /***产品分类菜单图标布局***/
    proMenuIconLayout: function() {
        var param = {};
        var eurl = userUrlHead + userGetProCats;
        var fun = function(data) {
            if (data.status === "S") {
                var proDataArr = data.respData;
                productshow.proCateCount(proDataArr, "");
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //**递归产品分类所有数据并添加到页面
    proCateCount: function(data, parentDate) {
        var isRepeat = false;
        for (var n = 0,
                 len = data.length; n < len; n++) {
            if (data[n].childProdCatHiers.length > 0) {
                productshow.proCateCount(data[n].childProdCatHiers, data[n]);
            } else {
                if (parentDate !== "") {
                    if (isRepeat === false) {
                        $(".proCateMenuContent").append("<li><a href='javascript:void(0)' class='myProMenu'><span class='tie'>></span>" + parentDate.prodCat.prodCatName + "</a><ul ishide='flase'></ul></li>");
                        isRepeat = true;
                    }
                    $(".alpha2 ul").last().append("<li><a href='javascript:void(0)' class='catItem' data-catId='" + data[n].prodCat.prodCatId + "' data-catName='" + data[n].prodCat.prodCatName + "'>" + data[n].prodCat.prodCatName + "</a></li>");
                }
            }
        }
        myenvetclass.proCatItemCilicEvent();
    },

    allProShowStyleTwo: function() {
        var standbyUrl = "";
        var param = {

            "prodSearch.prodName": "",
            "prodSearch.newFlag": -1,
            "prodSearch.hotFlag": -1,
            "mpagingRequest.perPageUnitNum": 14,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userGetProductList;
        var fun = function(data) {
            var xh = "";
            if (data.status === "S") {
                var arrProList = data.respData.dataList;

                if (arrProList.length == 0) {
                    isNoLoading = true;
                    $(".proListMore").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }
                for (var i = 0,
                         len = arrProList.length; i < len; i++) {
                    standbyUrl = imgLink(arrProList[i].firstProdImg);
                    if (arrProList[i].featureName === null || arrProList[i].featureName === undefined) {
                        xh = "";
                    } else {
                        xh = arrProList[i].featureName;
                    }

                    $(".allProList ul").append("<a href='#page2-2' onClick=setpoppage(this,'#allListProShow') data-myindex='" + arrProList[i].prodNum + "'><li><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65'><p>" + arrProList[i].prodName + "</p> <p class='price45'>产品型号：" + xh + "</p><b class='b-green'>¥" + arrProList[i].stdPrice + "</b></div></li></a>");
                }
                $("#container1").hide();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (arrProList.length < 9) {
                $(".proListMore").show();
                isNoLoading = true;
                hideLoader();
                return;
            }
            loadingPage++;
            hideLoader();
            isLoding = false;
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    allProListLoadMore: function() {
        if (isNoLoading === false && isLoding === false) {
            productshow.allProShowStyleTwo();
        }
    },

    allProducRefresh: function() {
        loadingPage = 1;
        productshow.allProShowStyleTwo("true");
    },

    //商品特供
    superProList: function() {
        var param = {
            "prodSearch.prodName": "",
            "prodSearch.newFlag": -1,
            "prodSearch.hotFlag": -1,
            "mpagingRequest.perPageUnitNum": 14,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userGetSuperPro;
        var fun = function(data) {
            var xh = "";
            if (data.status === "S") {
                var arrProList = data.respData.dataList;
                var standbyLeftUrl = "";
                var standbyRightUrl = "";
                if (arrProList.length == 0) {
                    isNoLoading = true;
                    $(".superProMore").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }
                for (var i = 0,
                         len = arrProList.length; i < len; i++) {
                    standbyLeftUrl = imgLink(arrProList[i].firstProdImg);
                    $(".waterfall-le").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrProList[i].prodNum + "'> <img src=" + standbyLeftUrl + " onerror=this.src='" + errImg + "'><p class='fon-2'>" + arrProList[i].prodName + "</p></a><div class='waterfall-price'><strong style='color:#34a277; font-size:16px;'>¥" + arrProList[i].stdPrice + "</strong></div></a></li>");
                    if (++i < len) {
                        standbyRightUrl = imgLink(arrProList[i].firstProdImg);
                    }
                    if (standbyRightUrl !== "") {
                        $(".waterfall-ri").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrProList[i].prodNum + "'><img src=" + standbyRightUrl + " onerror=this.src='" + errImg + "'><p class='fon-2'>" + arrProList[i].prodName + "</p></a><div class='waterfall-price'><strong style='color:#34a277; font-size:16px;'>¥" + arrProList[i].stdPrice + "</strong></div></a></li>");
                        standbyRightUrl = "";
                    }
                }
                myenvetclass.selectDetailed();
                $("#container1").hide();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }

            if (arrProList.length < 9) {
                $(".superProMore").show();
                isNoLoading = true;
                hideLoader();
                return;
            }
            loadingPage++;
            hideLoader();
            isLoding = false;
        };
        serviceconnection.postRequest("post", param, eurl, fun);

    }

};

/*数据库类*/
var operatingDatabaseClass = {
    //创建表
    crateTable: function() {
        if (localStorage.getItem(userName) == undefined) {
            var jsondata = [];
            localStorage.setItem(userName, JSON.stringify(jsondata));
            return;
        } else {
            return;
        }
    },

    //添加数据
    insertData: function(id, number) {
        var jsondata = JSON.parse(localStorage.getItem(userName));
        var datacount = jsondata.length;
        for (var i = 0,
                 len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid == id) {
                myAlert(".myAlertView", ".myAlertMessage", "这件商品已存在购物车中!");
                return;
            }
        }
        jsondata.push({
            myid: id,
            mynumber: number
        });
        localStorage.setItem(userName, JSON.stringify(jsondata));
        if (jsondata.length > datacount) {
            myAlert(".myAlertView", ".myAlertMessage", "添加成功!");
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "添加失败!");
        }
    },

    //查询数据
    selectData: function() {
        var jsondata = JSON.parse(localStorage.getItem(userName));
        return jsondata;
    },

    //更新数据
    updateData: function(id, number) {
        var jsondata = JSON.parse(localStorage.getItem(userName));
        for (var i = 0,
                 len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid === id) {
                if (jsondata[i].mynumber != number) {
                    jsondata[i].mynumber = number;
                    localStorage.setItem(userName, JSON.stringify(jsondata));
                    return;
                }
                return;
            }
        }
    },

    //删除数据
    deleteItemData: function(id, itemId) {
        var jsondata = JSON.parse(localStorage.getItem(userName));
        for (var i = 0,
                 len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid === id) {
                jsondata.splice(i, 1);
                localStorage.setItem(userName, JSON.stringify(jsondata));
                if (jsondata.length === 0) {
                    $(".shoppingBg").html("");
                    $("#orderSendBtn").hide();
                    $(".promptText").show();
                }
                if (itemId !== undefined && itemId !== "") {
                    $(itemId).remove();
                    $("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',userproduct.sendOrder())");
                    $("#page5 .alertMessage").html("您确定提交订单吗？");
                }
                return;
            }
        }
    },

    //删除数据
    deleteallData: function() {
        $(".shoppingBg").html("");
        $("#orderSendBtn").hide();
        $(".promptText").show();
        localStorage.removeItem(userName);
        mydatabase.crateTable();
    }
};

/*登陆类*/
var classLoginClass = {
    userLoginState: false,
    adminLoginState: false,
    reLogin: true,
    isLoginToIndex: false,
    isUserOrAdminBack: false,
    isRegister: false,

    //判断是否用户登陆
    isUserLogin: function() {
        var param = {};
        var eurl = userUrlHead + getIsLogin;
        var fun = function(data) {
            if (data.status === "S") {
                classlogin.userLoginState = true;
            } else {
                classlogin.isUserOrAdminBack = false;
                classlogin.userLoginState = false;
            }
        };
        serviceconnection.postRequests("post", param, eurl, fun);
    },

    getUserLoginState: function(page1, page2) {
        pushpage = page1;
        $("#loginback").attr("href", page2);
        classlogin.isUserLogin();
        if (classlogin.userLoginState === true) {
            if (page2 === "#page5" || page2 === "#userWaitingAudit" || page2 === "#myorder" || page2 === "#userModifyInfo" || page2 === "#userModifyPass" || page2 === "#adminModifyPass" || page2 === "#clientsearch" || page2 === "#superPro") {
                $("#userBack").attr("href", "#index");
            } else {
                $("#userBack").attr("href", page2);
            }
            window.location.href = pushpage;
        } else {
            window.location.href = "#userlogin";
        }
    },

    //判断是否用户登陆_添加到购物车
    isUserLoginAddOrder: function(page1, page2, my) {
        pushpage = page1;
        var addNum = $("#addNum");
        $("#loginback").attr("href", page2);
        classlogin.isUserLogin();
        if (classlogin.userLoginState === true) {
            if (classverifiction.isInt(addNum.val()) && parseInt(addNum.val()) > 0) {
                mydatabase.insertData($(my).attr("data-myindex"), parseInt(addNum.val()));
                addNum.val("0");
            } else {
                myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!");
            }
        } else {
            window.location.href = "#userlogin";
        }
    },

    //用户登陆
    userLogin: function(username, userpass) {
        var param = {

            custName: username,
            custPwd: userpass
        };
        var eurl = userUrlHead + userLogin;
        var fun = function(data) {
            if (data.status === "S") {
                localStorage.setItem("userName", username + "");
                userName = (localStorage.userName).replace(/\"/g, "");
                mydatabase.crateTable();
                $("#userpassword").val("");
                if (IsToProductInfo === true) {
                    setpoppage(productIndex, "#product");
                    IsToProductInfo = false;
                }
                phonedealwith.testSetJushTagNalias(); //注册推送
                if (pushpage === "") {
                    pushpage = "#personal";
                }
                classlogin.reLogin = false;
                classlogin.isUserOrAdminBack = true;
                classlogin.userLoginState = true;
                classlogin.adminLoginState = false;
                $("#adminLoginHide").hide();
                window.location.href = pushpage;
            } else {
                myAlert(".myAlertView", ".myAlertMessage", data.message);
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //用户登出
    userLoginOut: function() {
        var param = {};
        var eurl = userUrlHead + loginOut;
        var fun = function(data) {
            if (data.status === "S") {
                classlogin.userLoginState = false;
                window.history.go( - (window.history.length - 2));
                $(".shoppingBg").html("");
                $("#orderSendBtn").hide();
                $(".promptText").hide();
                $(".personal-cen").html("<p><span>用 户 名：</span>未登录</p><p><span>企业名称：</span>未登录</p>");
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //用户修改密码
    isUserLegality: function() {
        if (classverifiction.isLetterAndNum($("#oldPass").val()) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "旧密码输入错误，只能由数字或字母组成!");
            return;
        } else if (classverifiction.isLetterAndNum($("#newPass").val()) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "新密码输入错误，只能由数字或字母组成!");
            return;
        } else if ($("#newPass").val() !== $("#confirmNewPass").val()) {
            myAlert(".myAlertView", ".myAlertMessage", "新密码两次输入不一致!");
            return;
        } else {
            var param = {

                oldPwd: $("#oldPass").val(),
                newPwd: $("#newPass").val()
            };
            var eurl = userUrlHead + userUpdatePwd;
            var fun = function(data) {
                if (data.status === "S") {
                    $("#newPass,#confirmNewPass,#oldPass").val("");
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',$.mobile.back(),'')");
                    $(".allMessage .alertMessage").html("修改密码成功!");
                    openAlert('.allMessage');
                } else {
                    if (data.message === "您还没有登录") {
                        $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                        $(".allMessage .alertMessage").html(data.message);
                        openAlert('.allMessage');
                        $("#newPass,#confirmNewPass,#oldPass").val("");
                    } else {
                        myAlert(".myAlertView", ".myAlertMessage", data.message);
                    }
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        }
    },

    //判断管理是否登陆
    isAdminLogin: function() {
        var param = {};
        var eurl = adminUrlHead + getIsLogin;
        var fun = function(data) {
            if (data.status === "S") {
                classlogin.adminLoginState = true;
            } else {
                classlogin.isUserOrAdminBack = false;
                classlogin.adminLoginState = false;
            }
        };
        serviceconnection.postRequests("post", param, eurl, fun);
    },

    getAdminLoginState: function(push, pop) {
        classlogin.isAdminLogin();
        pushpage = push;
        $("#aloginBack").attr("href", pop);
        if (pop === "#adminMenu" || pop === "#adminselectorder" || pop === "#adminselectorder" || pop === "#orderinfo" || pop === "#adminProManage" || pop === "#adminModifyPass" || pop === "#clientsearch") {
            $("#adminBack").attr("href", "#index");
        } else {
            $("#adminBack").attr("href", pop);
        }
        if (classlogin.adminLoginState === true) {
            window.location.href = pushpage;
        } else {
            window.location.href = "#pageadminlogin";
        }
    },

    //管理员登陆
    adminLogin: function(name, pass) {
        var param = {

            adminName: name,
            adminPwd: pass
        };
        var eurl = adminUrlHead + adminLogin;
        var fun = function(data) {
            if (data.status == "S") {
                $("#adminpassword").val("");
                classlogin.reLogin = false;
                classlogin.adminLoginState = true;
                classlogin.userLoginState = false;
                classlogin.isUserOrAdminBack = true;
                window.location.href = "#adminMenu";
                $("#userLoginHide").hide();
            } else {
                myAlert(".myAlertView", ".myAlertMessage", data.message);
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //管理员登出
    adminLoginOut: function() {
        var param = {};
        var eurl = adminUrlHead + loginOut;
        var fun = function(data) {
            if (data.status === "S") {
                $(".admin-cen").html("<p><span>厂 家：</span>未登录</p><p><span>厂家账号：</span>未登录</p>");
                classlogin.adminLoginState = false;
                window.history.go( - (window.history.length - 2));
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //管理员修改密码
    isAdminLegality: function() {
        if (classverifiction.isLetterAndNum($("#adminOldPass").val()) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "旧密码输入错误，只能由数字或字母组成!");
            return;
        } else if (classverifiction.isLetterAndNum($("#adminNewPass").val()) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "新密码输入错误，只能由数字或字母组成!");
            return;
        } else if ($("#adminNewPass").val() !== $("#confirmAdminNewPass").val()) {
            myAlert(".myAlertView", ".myAlertMessage", "新密码两次输入不一致!");
            return;
        } else {
            var param = {

                oldPwd: $("#adminOldPass").val(),
                newPwd: $("#adminNewPass").val()
            };
            var eurl = adminUrlHead + adminUpdatePwd;
            var fun = function(data) {
                if (data.status === "S") {
                    $("#adminNewPass,#confirmAdminNewPass,#adminOldPass").val("");
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','#adminMenu')");
                    $(".allMessage .alertMessage").html("管理员修改密码成功!");
                    openAlert('.allMessage');
                } else {
                    if (data.message === "您还没有登录") {
                        $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                        $(".allMessage .alertMessage").html(data.message);
                        openAlert('.allMessage');
                        $("#adminNewPass,#confirmAdminNewPass,#adminOldPass").val("");
                    } else {
                        myAlert(".myAlertView", ".myAlertMessage", data.message);
                    }
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        }
    },

    //用户或者管理员未登录请求数据
    isLoginGetStatu: function(text, type) {
        hideLoader();
        if (text === "您还没有登录") {
            classlogin.reLogin = true;
            classlogin.isLoginToIndex = true;
            classlogin.userLoginState = false;
            classlogin.adminLoginState = false;
            classlogin.isUserOrAdminBack = false;
            $("#adminLoginHide").hide();
            $("#userLoginHide").hide();
            $("#indexViewHide").show();
            if (type === "admin") {
                setTimeout(function() {
                        window.location.href = "#pageadminlogin";
                    },
                    60);
                window.history.go( - (window.history.length - 2));
            } else {
                setTimeout(function() {
                        window.location.href = "#userlogin";
                    },
                    60);
                window.history.go( - (window.history.length - 2));
            }
        }
    }
};

/*类名:用户注册类*/
var registClass = {
    //用户注册
    userRegist: function(acc, pass, passConfirm, name, companyName) {
        if (classverifiction.iphonever(acc) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "手机号码输入错误!");
            return;
        } else {
            var param = {

                custName: acc
            };
            var eurl = userUrlHead + userExistCustname;
            var fun = function(data) {
                if (data.status === "S") {
                    if (data.respData === false) {
                        if (classverifiction.isLetterAndNum(pass) === false) {
                            myAlert(".myAlertView", ".myAlertMessage", "用户密码只能由字母或数字组成!");
                            return;
                        } else if (pass !== passConfirm) {
                            myAlert(".myAlertView", ".myAlertMessage", "两次用户密码输入不正确!");
                            return;
                        } else if (name === "") {
                            myAlert(".myAlertView", ".myAlertMessage", "姓名不能为空!");
                            return;
                        } else if (companyName === "") {
                            myAlert(".myAlertView", ".myAlertMessage", "商家名/公司名不能为空!");
                            return;
                        } else {
                            var param = {

                                "customer.custName": acc,
                                "customer.password": pass,
                                "customer.contactPerson": name,
                                "customer.phoneNum": acc,
                                "customer.companyName": companyName
                            };
                            var eurl = userUrlHead + userReg;
                            var fun = function(data) {
                                if (data.status === "S") {
                                    classlogin.isRegister = true;
                                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.userLogin('" + acc + "','" + pass + "'),'')");
                                    $(".allMessage .alertMessage").html("注册成功!");
                                    $.mobile.back();
                                    setTimeout(function() {
                                            openAlert('.allMessage');
                                        },
                                        100);
                                } else {
                                    $(".allMessage .alertMessage").html(data.message);
                                    openAlert('.allMessage');
                                }
                            };
                            serviceconnection.postRequest("post", param, eurl, fun);
                        }
                    } else {
                        myAlert(".myAlertView", ".myAlertMessage", "该手机号码已存在!");
                    }
                } else {
                    myAlert(".myAlertView", ".myAlertMessage", data.message);
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        }
    },

    //获取用户注册信息
    userGetInfo: function() {
        var param = {};
        var eurl = userUrlHead + userGetCust;
        var fun = function(data) {
            if (data.status === "S") {
                $("#sUserName").html("");
                $("#sUserName").html(data.respData.custName);
                $('#companyName').val(data.respData.companyName);
                $('#contactName').val(data.respData.contactPerson);
                $('#contactPhone').val(data.respData.phoneNum);
                $('#companyAddress').val(data.respData.address);
                $('#remark').val(data.respData.remark);

                $(".personal-cen").html("<p><span>用 户 名：</span>" + data.respData.custName + "</p><p><span>企业名称：</span>" + data.respData.companyName + "</p>");
            } else {
                $(".personal-cen").html("<p><span>用 户 名：</span>未登录</p><p><span>企业名称：</span>未登录</p>");
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //获取管理员资料
    adminGetInfo: function() {
        var param = {};
        var eurl = adminUrlHead + adminInfo;
        var fun = function(data) {
            if (data.status === "S") {
                $(".admin-cen").html("<p><span>厂 家：</span>" + data.respData.companyName + "</p><p><span>厂家账号：</span>" + data.respData.ownerNum + "</p>");
            } else {
                $(".admin-cen").html("<p><span>厂 家：</span>未登录</p><p><span>厂家账号：</span>未登录</p>");
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //用户信息
    userUpdateInfo: function(company, contact, phone, address) {
        if (company === "") {
            myAlert(".myAlertView", ".myAlertMessage", "公司名不能为空!");
        } else if (contact === "") {
            myAlert(".myAlertView", ".myAlertMessage", "联系人不能为空!");
        } else if (phone === "") {
            myAlert(".myAlertView", ".myAlertMessage", "手机号码不能为空!");
        } else if (classverifiction.iphonever(phone) === false) {
            myAlert(".myAlertView", ".myAlertMessage", "手机号码格式不正确!");
        } else {
            var param = {

                "customer.companyName": company,
                "customer.contactPerson": contact,
                "customer.phoneNum": phone,
                "customer.address": address
                //			"customer.remark":remark
            };
            var eurl = userUrlHead + userUpdateCust;
            var fun = function(data) {
                if (data.status === "S") {
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',$.mobile.back(),'')");
                    $(".allMessage .alertMessage").html("修改成功!");
                    openAlert('.allMessage');
                } else {
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                    $(".allMessage .alertMessage").html(data.message);
                    openAlert('.allMessage');
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        }
    }
};

/*类名:管理员产品类*/
var adminGetProDataClass = {
    pageNum: 0,
    aNameKey: "",

    //获取产品列表
    adminGetProList: function(name) {
        if (name === undefined) {
            name = "";
        }
        var standbyUrl = "";
        var param = {

            "prodSearch.prodName": name,
            "prodSearch.isPublic": -1,
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = adminUrlHead + userGetProductList;
        var fun = function(data) {
            if (data.status === "S") {
                var arrData = data.respData.dataList;
                if (arrData.length == 0) {
                    isNoLoading = true;
                    $(".anoMorePro").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }

                for (var i = 0,
                         len = arrData.length; i < len; i++) {
                    standbyUrl = imgLink(arrData[i].firstProdImg);
                    $(".proShowList ul").append("<li><div class='pro-manage-i'><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrData[i].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></a> </div><div class='p65'><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrData[i].prodNum + "'><p class='p-title'>" + arrData[i].prodName + "</p></a><p class='p-green' ><span id='editProPrice" + admingetprodata.pageNum + i + "'>¥" + arrData[i].stdPrice + "</span><img src='img/edit.png' priceValue=" + arrData[i].stdPrice + "   proPriceId='#editProPrice" + admingetprodata.pageNum + i + "' data-price='" + arrData[i].prodNum + "' class='adminUpdatePrice' ondragstart='return false'  style='width:44px; float:right;'></p> <p class='p-green' ><span id='editProStock" + admingetprodata.pageNum + i + "'>库存数量:" + arrData[i].dispStockBalance + "</span><img src='img/edit.png' stockValue=" + arrData[i].dispStockBalance + " proStrockId='#editProStock" + admingetprodata.pageNum + i + "' data-num='" + arrData[i].prodNum + "' class='adminUpdateProNum' ondragstart='return false'  style='width:44px; float:right;'></p><p class='p-date' >上架日期:" + arrData[i].createDate + "</p></div></li>");
                }
                myenvetclass.adminUpdateNumAdnPrice();
                myenvetclass.selectDetailed();
                admingetprodata.pageNum++;
                $("#container1").hide();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (arrData.length < 9) {
                isNoLoading = true;
                $(".anoMorePro").show();
                hideLoader();
                return;
            }

            hideLoader();
            loadingPage++;
            isLoding = false;

        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //更新价格和库存
    editPro: function(type, num, key, my, event) {
        $("#proManage").val($(my).attr(key));
        if (type === "a") {
            $("#adminProManage .alertTitle").html("请输入价格");
            $(document).unbind("click");
            $(document).on("click", "#adminProManage .alertBtnConfirm",
                function() {
                    confirmEnvent('#adminProManage', admingetprodata.updatePrice(num, $("#proManage").val(), $(my).attr("proPriceId"), my), '', "false");
                });
        } else if (type === "b") {
            $("#adminProManage .alertTitle").html("请输入数量");
            $(document).unbind("click");
            $(document).on("click", "#adminProManage .alertBtnConfirm",
                function() {
                    confirmEnvent('#adminProManage', admingetprodata.updateNum(num, $("#proManage").val(), $(my).attr("proStrockId"), my), '', "false");
                });
        }
        openAlert('#adminProManage');
    },

    updatePrice: function(num, value, priceId, my) {
        if (value === "") {} else if (classverifiction.isFloat(value)) {
            var param = {

                "prodPrice.prodNum": num,
                "prodPrice.prodPrice": value
            };
            var eurl = adminUrlHead + adminUpadtePrice;
            var fun = function(data) {
                if (data.status === "S") {
                    $("#adminProManage .alertViewBg").hide();
                    $("#adminProManage .alertViewBg2").hide();
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','')");
                    $(".allMessage .alertMessage").html("价格更新成功!");
                    openAlert('.allMessage');
                    $(priceId).html("¥" + value);
                    $(my).attr("priceValue", value);
                } else {
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                    $(".allMessage .alertMessage").html(data.message);
                    openAlert('.allMessage');
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "产品单价输入有误!");
        }
    },

    updateNum: function(num, value, stockId, my) {
        if (value === "") {} else if (classverifiction.isInt(value)) {
            var param = {

                "product.prodNum": num,
                "product.dispStockBalance": value
            };
            var eurl = adminUrlHead + adminUpdateStockBalance;
            var fun = function(data) {
                if (data.status === "S") {
                    $("#adminProManage .alertViewBg").hide();
                    $("#adminProManage .alertViewBg2").hide();
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','')");
                    $(".allMessage .alertMessage").html("库存更新成功!");
                    openAlert('.allMessage');
                    $(stockId).html("产品库存:" + value);
                    $(my).attr("stockValue", value);
                } else {
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                    $(".allMessage .alertMessage").html(data.message);
                    openAlert('.allMessage');
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "请输入正确的产品数量!");
        }
    },

    aSearchPro: function name(name) {
        $(".proShowList ul").html("");
        $("#container1").show();
        admingetprodata.pageNum = 0;
        admingetprodata.aNameKey = name;
        loadingPage = 1;
        $(".anoMorePro").hide();
        isNoLoading = false;
        admingetprodata.adminGetProList(name);
    }
};

/*类名:搜索类*/
var SearchClass = {
    isSuccess: false,
    searchKey: "",

    searchName: "",
    searchArea: "",
    searchPhone: "",

    //管理员搜索客户
    adminSearchUserInfo: function() {
        var param = {

            "custSearch.contactPerson": searchclass.searchName,
            "custSearch.address": searchclass.searchArea,
            "custSearch.phoneNum": searchclass.searchPhone,
            "custSearch.orderDate": "",
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = adminUrlHead + adminUserList;
        var fun = function(data) {
            if (data.status === "S") {
                searchclass.isSuccess = false;
                if (data.respData.dataList.length === 0) {
                    $(".searUserMore").show();
                    isLoding = true;
                    hideLoader();
                    return;
                }

                for (var i = 0,
                         len = data.respData.dataList.length; i < len; i++) {
                    $(".center-order").append("<div class='search-list toUserOrder' data-orderKey='" + data.respData.dataList[i].custNum + "'><ul><li><span class='top-bg'>联系人: " + data.respData.dataList[i].contactPerson + "</span></li><li>公司: " + data.respData.dataList[i].companyName + "</li><li>账号: " + data.respData.dataList[i].custName + "</li><li>手机: " + data.respData.dataList[i].phoneNum + "</li><li>地址: " + data.respData.dataList[0].address + "</li></ul></div>");
                    searchclass.isSuccess = true;
                }
                myenvetclass.selectAUserOrder();
                loadingPage++;
                isLoding = false;
                $("#container1").hide();
                $(".searUserMore").hide();
                hideLoader();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequests("post", param, eurl, fun);
    },

    //条件搜索
    conditionSearch: function() {
        var complexKey = $("#custSearch").val();
        loadingPage = 1;
        $(".center-order").html("");
        $(".searUserMore").hide();
        searchclass.searchName = "";
        searchclass.searchArea = "";
        searchclass.searchPhone = "";
        switch (searchUserKey) {
            case 1:
                searchclass.searchName = complexKey;
                searchclass.adminSearchUserInfo();
                break;
            case 2:
                searchclass.searchPhone = complexKey;
                searchclass.adminSearchUserInfo();
                break;
            case 3:
                searchclass.searchArea = complexKey;
                searchclass.adminSearchUserInfo();
                break;
            default:
                searchclass.searchName = "";
                searchclass.searchArea = "";
                searchclass.searchPhone = "";
                searchclass.adminSearchUserInfo();
                break;
        }
    },

    //用户搜索产品
    userSearchPro: function(cateName, proName, proCategoryId) {
        searchKey = proName;
        var param = {

            "prodSearch.prodName": searchKey,
            "prodSearch.prodCatId": proCategoryId,
            "prodSearch.newFlag": -1,
            "prodSearch.hotFlag": -1,
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage
        };

        var eurl = userUrlHead + userGetProductList;
        var fun = function(data) {
            if (data.status === "S") {

                var array_productclass = data.respData.dataList;
                var standbyUrl = "";
                if (cateName !== "") {
                    $("#page2-1 h3").html(cateName);
                }
                if (array_productclass.length == 0) {
                    isNoLoading = true;
                    $(".fproMore").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }
                for (var i = 0,
                         len = array_productclass.length; i < len; i++) {
                    standbyUrl = imgLink(array_productclass[i].firstProdImg);
                    if (array_productclass[i].featureName === null || array_productclass[i].featureName === undefined) {
                        xh = "";
                    } else {
                        xh = array_productclass[i].featureName;
                    }
                    $(".proSearchResults ul").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_productclass[i].prodNum + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65'><p>" + array_productclass[i].prodName + "</p> <p class='price45'>产品型号：" + xh + "</p><b class='b-green'>¥" + array_productclass[i].stdPrice + "</b></div></a></li>");
                }
                $("#container1").hide();
                myenvetclass.selectDetailed();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (array_productclass.length < 9) {
                isNoLoading = true;
                $(".fproMore").show();
                hideLoader();
                return;
            }

            hideLoader();
            loadingPage++;
            isLoding = false;

        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //判断搜索条件是否为空
    userSearchIsNull: function(my, cateName, proName, proCategoryId) {
        if (cateName === "") {
            myAlert(".myAlertView", ".myAlertMessage", "条件不能为空!");
        } else {
            $("#container1").show();
            $(".proSearchResults ul").html("");
            $(my).attr("href", "#page2-1");
            searchclass.userSearchPro(cateName, proName, proCategoryId);
        }
    },

    //修改产品分类搜索页面上一级页面
    proSearchBack: function(page) {
        $("#proSearchBack").attr("href", page);
    }
};

/*类名:留言板类*/
var messageBoardsClass = {
    //显示留言板
    getMessage: function() {
        var createBy = "";
        var param = {

            "guestBookSearch.createDateFrom": "",
            "mpagingRequest.perPageUnitNum": 14,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userGetGuestBooks;
        var fun = function(data) {
            if (data.status === "S") {
                var array_message = data.respData.dataList;
                if (array_message.length == 0) {
                    isNoLoading = true;
                    $(".noMessage").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }
                for (var i = 0,
                         len = array_message.length; i < len; i++) {
                    if (array_message[i].createBy === "") {
                        createBy = "匿名账户";
                    } else {
                        createBy = array_message[i].createBy.substr(0, 5) + "******";
                    }

                    $(".allMessageList").append("<div class='message' ><div class='message-tittle'><ul><li class='f14'>" + createBy + "</li><li class='f12'>" + array_message[i].createDate.replace("T", " ") + "</li></ul></div><div class='message-centent'><ul><li class='himg'><img src='img/messageview/picture.png' ondragstart='return false'></li><li class='hfont'>" + array_message[i].content + "</li></ul></div></div>");
                }
                $("#container1").hide();
                if (array_message.length < 9) {
                    isNoLoading = true;
                    $(".noMessage").show();
                    hideLoader();
                    return;
                }
                hideLoader();
                loadingPage++;
                isLoding = false;
                $("#container1").hide();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },
    //发表留言
    sendMessage: function() {
        var param = {

            "guestBook.content": $("#messagetext").val()
        };
        var eurl = userUrlHead + userAddGuestBook;
        var fun = function(data) {
            if (data.status === "S") {
                var name = "";
                closeAlert("#message");
                classlogin.isUserLogin();
                if (classlogin.userLoginState === true) {
                    name = userName.substr(0, 5) + "******";
                } else {
                    name = "匿名账户";
                }

                $(".allMessageList").prepend("<div class='message' ><div class='message-tittle'><ul><li class='f14'>" + name + "</li><li class='f12'>1秒前</li></ul></div><div class='message-centent'><ul><li class='himg'><img src='img/messageview/picture.png' ondragstart='return false'></li><li class='hfont'>" + $('#messagetext').val() + "</li></ul></div></div>");
                document.getElementsByTagName('body')[0].scrollTop = 0;
                $("#messagetext").val("");

            } else {
                alert(data.message);
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    }
};

/*类名:管理员订单类*/
var ManageOrderClass = {
    orderNum: 0,
    userNum: "",
    aUserCompany: "",
    aUserPhoneNum: "",

    //管理员查看订单列表
    adminShowOrderList: function() {
        var param = {

            "orderSearch.custNum": manageorder.userNum,
            "orderSearch.custCompanyName": manageorder.aUserCompany,
            "orderSearch.phoneNum": manageorder.aUserPhoneNum,
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage,
            "orderSearch.deliverStatus": -1,
            "orderSearch.cashStatus": -1,
            "orderSearch.settleStatus": -1
        };

        var eurl = adminUrlHead + adminGetOrderList;
        var fun = function(data) {
            var array_order = {};
            var itemId = "";
            if (data.status === "S") {
                array_order = data.respData.dataList;
                if (array_order.length == 0) {
                    isNoLoading = true;
                    $(".noOrder").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                }

                for (var i = 0,
                         len = array_order.length; i < len; i++) {
                    $(".aorderList").append("<div class='center-order'><div class='order' id='aSelectOrderHead" + manageorder.orderNum + i + "'><ul><li><a href='javascript:void(0)' class='toOrderInfo' data-myindex='" + array_order[i].orderNum + "'><span>订单编号：" + array_order[i].orderNum + "<span class='order-go'>></span></span></a></li><li>客户：" + array_order[i].custName + "</li><li>产品总数： " + array_order[i].orderItemList.length + "  </li><li>成交总价：<b class='b-green'>¥" + array_order[i].custPriceTotal + "</b></li><li>结算状态：" + array_order[i].cashStatusName + "</li><li>发货状态：" + array_order[i].deliverStatusName + "</li><li>提交时间：" + array_order[i].createDate + "</li></ul> </div></div>");

                    for (var j = 0,
                             itemLen = array_order[i].orderItemList.length; j < itemLen; j++) {

                        standbyUrl = imgLink(array_order[i].orderItemList[j].whereimg);
                        if (j > 2) {
                            itemId = itemId = "aSelectOrderItem" + manageorder.orderNum + i;
                        }
                        $("#aSelectOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_order[i].orderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_order[i].orderItemList[j].prodName + "</p><p class='price45'>¥" + array_order[i].orderItemList[j].custProdPrice + " x " + array_order[i].orderItemList[j].cases + "</p><p><b class='b-green'>总价：¥" + array_order[i].orderItemList[j].custProdPriceTotal + "</b></p></div></div></a>");
                    }

                    if (array_order[i].orderItemList.length > 3) {
                        $("#aSelectOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]'  onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
                        $("div[data-waitingItem='" + itemId + "']").hide();
                        itemId = "";
                    }

                }
                myenvetclass.adminToOrderDetailInfo();
                myenvetclass.selectDetailed();
                manageorder.orderNum++;
                $("#container1").hide();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (array_order.length < 9) {
                isNoLoading = true;
                $(".noOrder").show();
                hideLoader();
                return;
            }
            hideLoader();
            loadingPage++;
            isLoding = false;

        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //管理员查看订单详细信息
    adminGetOrderInfo: function(my) {
        var param = {

            orderNum: $(my).attr("data-myindex")
        };
        var eurl = adminUrlHead + adminGetOrderInfo;
        var fun = function(data) {
            if (data.status === "S") {
                var array_orderinfo = data.respData;
                if (array_orderinfo.order.orderItemList.length === 0) {
                    $(".allMessage .alertMessage").html(data.message);
                    openAlert('.allMessage');
                } else {
                    var listView = "";
                    var listItems = "";
                    var listHead = "";
                    $(".ordercontent").html("");
                    $(".ordercontent").append("<div class='center-order'><div class='order' id='aSelectOrderInfoHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + array_orderinfo.order.orderNum + "</span></li><li>客户：" + array_orderinfo.order.custName + "</li><li>产品总数：<p> " + array_orderinfo.order.orderItemList.length + "  </p></li></li><li>成交总价：<b class='b-green'>¥" + array_orderinfo.order.custPriceTotal + "</b></li><li>收款类型：" + array_orderinfo.order.cashTypeName + "</li><li>收款类型：" + array_orderinfo.order.cashTypeName + "</li><li>结算状态：" + array_orderinfo.order.cashStatusName + "</li><li>发货状态：" + array_orderinfo.order.deliverStatusName + "</li><li>提交时间：" + array_orderinfo.order.createDate + "</li></ul> </div></div>");

                    for (var j = 0,
                             itemLen = array_orderinfo.order.orderItemList.length; j < itemLen; j++) {
                        standbyUrl = imgLink(array_orderinfo.order.orderItemList[j].whereimg);
                        $("#aSelectOrderInfoHead" + manageorder.orderNum + i).append("<div class='order-list'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_orderinfo.order.orderItemList[j].prodName + "</p><p class='price45'>¥" + array_orderinfo.order.orderItemList[j].custProdPrice + " x " + array_orderinfo.order.orderItemList[j].cases + "</p><p><b class='b-green'>总价：¥" + array_orderinfo.order.orderItemList[j].custProdPriceTotal + "</b></p></div></div>");
                    }
                    window.location.href = "#orderinfo";
                }
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //待审核订单列表
    userShowWaitingList: function() {
        var param = {

            "orderSearch.custNum": "",
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userWaitingOrderList;
        var fun = function(data) {
            var arrayWaitingOrder = "";
            var standbyUrl = "";
            var itemId = "";
            if (data.status === "S") {
                arrayWaitingOrder = data.respData.dataList;
                if (arrayWaitingOrder.length == 0) {
                    isNoLoading = true;
                    $(".noMyWaitingOrder").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                } else {
                    $("#userWaitingAudit .all-tittle").show();
                }

                $("#userWaitingAudit .all-tittle h5").html("用户名: " + arrayWaitingOrder[0].createBy);
                for (var i = 0,
                         len = arrayWaitingOrder.length; i < len; i++) {
                    $(".userWaitingOrder").append("<div class='center-order'><div class='order' id='doneWaitingOrderHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + arrayWaitingOrder[i].origOrderNum + "</span></li><li>产品总数：<b class='b-green'> " + arrayWaitingOrder[i].origOrderItemList.length + "  </b></li><li>成交总价：¥" + arrayWaitingOrder[i].priceTotal + "</li><li>下单日期：" + arrayWaitingOrder[i].createDate + "</li></ul> </div></div>");

                    for (var j = 0,
                             itemLen = arrayWaitingOrder[i].origOrderItemList.length; j < itemLen; j++) {
                        standbyUrl = imgLink(arrayWaitingOrder[i].origOrderItemList[j].whereimg);
                        if (j > 2) {
                            itemId = "doneWaitingOrderProItem" + manageorder.orderNum + i;
                        }
                        $("#doneWaitingOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + arrayWaitingOrder[i].origOrderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='price45'>订购数量：" + arrayWaitingOrder[i].origOrderItemList[j].cases + "</p><b class='b-green'>产品单价：¥" + arrayWaitingOrder[i].origOrderItemList[j].prodPrice + "</b></div></div></a>");
                    }
                    if (arrayWaitingOrder[i].origOrderItemList.length > 3) {
                        $("#doneWaitingOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]' onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
                        $("div[data-waitingItem='" + itemId + "']").hide();
                        itemId = "";
                    }
                }
                manageorder.orderNum++;
                myenvetclass.selectDetailed();
                $("#container1").hide();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (arrayWaitingOrder.length < 9) {
                isNoLoading = true;
                $(".noMyWaitingOrder").show();
                hideLoader();
                return;
            }
            hideLoader();
            loadingPage++;
            isLoding = false;
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //客户查看订单列表
    userShowOrderList: function() {
        var param = {

            "orderSearch.custNum": "",
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": loadingPage
        };
        var eurl = userUrlHead + userGetOrderList;
        var fun = function(data) {
            var array_order = {};
            var standbyUrl = "";
            var itemId = "";
            if (data.status === "S") {
                array_order = data.respData.dataList;

                if (array_order.length == 0) {
                    isNoLoading = true;
                    $(".noMyOrder").show();
                    hideLoader();
                    $("#container1").hide();
                    return;
                } else {
                    $("#myorder .all-tittle").show();
                }

                $("#myorder .all-tittle h5").html("用户名: " + array_order[0].custName);
                for (var i = 0,
                         len = array_order.length; i < len; i++) {
                    $(".userOrderList").append("<div class='center-order'><div class='order' id='doneOrderHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + array_order[i].orderNum + "</span></li><li>产品总数：<b class='b-green'> " + array_order[i].orderItemList.length + "  </b></li><li>成交总价：¥" + array_order[i].custPriceTotal + "</li><li>发货状态：" + array_order[i].deliverStatusName + "</li><li>下单日期：" + array_order[i].createDate + "</li></ul> </div></div>");
                    for (var j = 0,
                             itemLen = array_order[i].orderItemList.length; j < itemLen; j++) {
                        standbyUrl = imgLink(array_order[i].orderItemList[j].whereimg);
                        if (j > 2) {
                            itemId = itemId = "doneOrderProItem" + manageorder.orderNum + i;
                        }
                        $("#doneOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_order[i].orderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_order[i].orderItemList[j].prodName + "</p><p class='price45'>订购数量：" + array_order[i].orderItemList[j].cases + "</p><b class='b-green'>产品单价：¥" + array_order[i].orderItemList[j].custProdPrice + "</b></div></div></a>");
                    }
                    if (array_order[i].orderItemList.length > 3) {
                        $("#doneOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]' onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
                        $("div[data-waitingItem='" + itemId + "']").hide();
                        itemId = "";
                    }
                }
                manageorder.orderNum++;
                myenvetclass.selectDetailed();
                $("#container1").hide();
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
            if (array_order.length < 9) {
                isNoLoading = true;
                $(".noMyOrder").show();
                hideLoader();
                return;
            }
            hideLoader();
            loadingPage++;
            isLoding = false;
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    showOrderAllProList: function(my) {
        if ($(my).attr("data-isShowAll") === "false") {
            $($(my).attr("itemListId")).show();
            $(my).html("收起展开的商品");
            $(my).attr("data-isShowAll", "true");
        } else {
            $($(my).attr("itemListId")).hide();
            $(my).attr("data-isShowAll", "false");
            $(my).html("显示订单所有商品");
        }
    }
};

/* 类名:用户购物类*/
var userProductClass = {
    myThis: this,

    //查看商品详情
    getDetailed: function(index) {
        var param = {

            prodNum: index
        };
        var eurl = userUrlHead + userGetProductInfo;
        var fun = function(data) {
            if (data.status === "S") {
                var detailedinfo = {};
                var text = "";
                var myimg = "";
                var prodExtFeatures = "";
                var standbyUrl = "";
                detailedinfo = data.respData;
                for (var i = 0,
                         len = detailedinfo.prodImgs.length; i < len; i++) {
                            standbyUrl = imgLink(detailedinfo.prodImgs[i].thumbUrl);
                    myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='ampImg' data-myImg='"+standbyUrl+"'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'> </a></div>";
                }
                if (detailedinfo.prodImgs.length > 0) {
                    var myimgcontent = "<div class='swiper-wrapper' id='silderclass'>" + myimg + "</div><div class='mpagination'></div><div class='repair'>.</div>";
                    $("#contentslider .swiper-container").show();
                } else {
                    $("#contentslider .swiper-container").hide();
                }
                $("#contentslider .swiper-container").append(myimgcontent);
                for (var y = 0,
                         len = detailedinfo.prodFeatures.length; y < len; y++) {
                    prodExtFeatures += "<li>" + detailedinfo.prodFeatures[y].featureName + ": " + detailedinfo.prodFeatures[y].featureValue + "</li>"
                }
                $(".detailed-tittle h5").html(detailedinfo.prodName);
                text = "<li>产品单价: <span class='#green'>¥" + detailedinfo.stdPrice + "</span></li>" + "<li>产品库存: " + detailedinfo.dispStockBalance + "件</li>" + prodExtFeatures + "<li>上市日期: " + detailedinfo.createDate.replace("T", " ") + "</li>";
                $(".cqcs ul").append(text);
                $("#send").attr("data-myindex", index);
                if (detailedinfo.externalSysCode === "1688" && isComShopping === false) {
                    $("#goToTaoBao").show();
                    $("#send").hide();
                    $("#goToDetailed").hide();
                    $(".quantity").hide();
                    for (var i = 0,
                             len = detailedinfo.prodExternals.length; i < len; i++) {
                        if (classverifiction.isMobile()) {
                            if (detailedinfo.prodExternals[i].externalName === "murl") {
                                //手机跳转到1688
                                try {
                                    window.device.version.substr(0, 1);
                                    $("#goToTaoBao").unbind("click").bind("click", {
                                            url: detailedinfo.prodExternals[i].externalValue
                                        },
                                        function(event) {
                                            webpage_mobile(event.data.url);
                                            $("#goToTaoBao").attr("href", "#");
                                            $("#goToTaoBao").removeAttr("target");
                                        });
                                } catch(error) {
                                    //手机浏览器
                                    //								  	$("#send").show();
                                    //								  	$("#goToDetailed").show();
                                    //								  	$(".quantity").show();
                                    $("#goToTaoBao").unbind("click");
                                    $("#goToTaoBao").bind("click", {
                                            url: detailedinfo.prodExternals[i].externalValue
                                        },
                                        function(event) {
                                            window.open(event.data.url);
                                        });
                                }
                            }
                        } else {
                            if (detailedinfo.prodExternals[i].externalName === "url") {
                                //							  		$("#send").show();
                                //							  		$("#goToDetailed").show();
                                //							  		$(".quantity").show();
                                //电脑跳转到1688
                                $("#goToTaoBao").unbind("click");
                                $("#goToTaoBao").bind("click", {
                                        url: detailedinfo.prodExternals[i].externalValue
                                    },
                                    function(event) {
                                        window.open(event.data.url);
                                    });
                            }
                        }
                    }
                } else {
                    $("#send").show();
                    $("#goToDetailed").show();
                    $(".quantity").show();
                    $("#goToTaoBao").hide();
                }
                $("#container1").hide();
                //var mySwiper =
                new Swiper('#contentslider .swiper-container', {
                    pagination: '.mpagination',
                    loop: true,
                    grabCursor: true,
                    paginationClickable: true
                });
                myenvetclass.ampImgEvent();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    //产品数量+1或者-1
    addOrMinusNumber: function(my, type, key) {
        var number = 0;
        var pageInputClass = $(my).attr("data-inputId");
        if (classverifiction.isInt($(pageInputClass).val())) {
            number = parseInt($(pageInputClass).val());

            if (type === "add") {
                $(pageInputClass).val(++number);
            } else {
                if (key === 1) {
                    if (number >= 2) {
                        $(pageInputClass).val(--number);
                    }
                } else {
                    if (number >= 1) {
                        $(pageInputClass).val(--number);
                    }
                }
            }
            if (key === 1) {
                userproduct.changeNumber(pageInputClass, $(pageInputClass).attr("proNum"));
            }
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!");
        }
    },

    //提交购物车
    sendOrder: function() {
        var jsonitems = "";
        var sendjson = "";
        var param = {};
        var bool_refresh;
        var jsondata = JSON.parse(localStorage.getItem(userName));
        for (var i = 0,
                 len = jsondata.length; i < len; i++) {
            if (i === 0) {
                jsonitems += "{'prodNum':'" + jsondata[i].myid + "','cases':" + jsondata[i].mynumber + "}";
            } else {
                jsonitems += ",{'prodNum':'" + jsondata[i].myid + "','cases':" + jsondata[i].mynumber + "}";
            }
        }
        sendjson = "[" + jsonitems + "]";
        param = {

            prodQtys: sendjson
        };
        var eurl = userUrlHead + userAddOrder;
        var fun = function(data) {
            if (data.status === "S") {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',mydatabase.deleteallData(),'#userWaitingAudit')");
                $(".allMessage .alertMessage").html("订单提交成功!");
                openAlert('.allMessage');
            } else {
                $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    },

    sendOrderDone: function(my, num) {
        if (num === "" && num === undefined) {} else if (classverifiction.isInt(num)) {
            var jsonitems = "";
            var sendjson = "";
            var param = {};
            jsonitems = "{'prodNum':'" + $(my).attr('data-myindex') + "','cases':" + num + "}";
            sendjson = "[" + jsonitems + "]";
            param = {

                prodQtys: sendjson
            };
            var eurl = userUrlHead + userAddOrder;
            var fun = function(data) {
                if (data.status === "S") {
                    $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','#myorder')");
                    $(".allMessage .alertMessage").html("订单提交成功!");
                    openAlert('.allMessage');
                } else {
                    $(".allMessage .alertMessage").html(data.message);
                    openAlert('.allMessage');
                }
            };
            serviceconnection.postRequest("post", param, eurl, fun);
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!");
        }
    },

    //查看购物车
    getShoppingInfo: function() {
        if (localStorage.getItem(userName) === "[]" || localStorage.getItem(userName) === undefined) {
            $(".shoppingBg").html("");
            $(".promptText").show();
            $("#container1").hide();
            return;
        } else {
            var jsondata = JSON.parse(localStorage.getItem(userName));
            $("#orderSendBtn").show();

            for (var i = 0,
                     len = jsondata.length; i < len; i++) {
                var param = {

                    prodNum: jsondata[i].myid
                };
                var eurl = userUrlHead + userGetProductInfo;
                var fun = function(data) {
                    if (data.status === "S") {
                        var standbyUrl = "";
                        var array_orderinfo = data.respData;
                        standbyUrl = imgLink(array_orderinfo.firstProdImg);
                        $(".shoppingBg").append("<div class='pro-list' id='shoppingItem" + i + "'><div class='tb-tittle' >" + array_orderinfo.prodName + "</div><div class='tb-property'><div class='tb-fon' ><a     href='javascript:void(0)' class='seldetail' data-myindex='" + array_orderinfo.prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></a></div><div class='tb-sku'><p>产品序号:<br>" + array_orderinfo.prodNum + "</p><p class='price' >¥" + array_orderinfo.stdPrice + "</p><p><span class='sliang'>购买数量：</span><a class='tb-stock' id='minusShopping" + i + "' data-inputId='#shoppingNum" + i + "'  href='javascript:void(0)'>-</a><input  data-role='none' class='tb-amount' type='text' value=" + jsondata[i].mynumber + " proNum='" + array_orderinfo.prodNum + "' id='shoppingNum" + i + "' onblur=userproduct.changeNumber(this,'" + array_orderinfo.prodNum + "')  title='请输入购买量'><a class='tb-stock' id='addShopping" + i + "' 'href='javascript:void(0)' data-inputId='#shoppingNum" + i + "'>+</a></p></div></div><div class='delete'><a href='javascript:void(0)' shoppingItemId='#shoppingItem" + i + "' data-inputId='#shoppingNum" + i + "' class='deleteBtn'><img src='img/delete-icon.png' ></a></div>");

                        myenvetclass.shoppingNum = jsondata.length;
                        myenvetclass.addShopping("minusShopping" + i, "addShopping" + i, 1);
                        $("#container1").hide();
                        myenvetclass.selectDetailed();
                        myenvetclass.deleteShoppingAPro();
                    } else {
                        $(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
                        $(".allMessage .alertMessage").html(data.message);
                        openAlert('.allMessage');
                        return;
                    }
                };
                serviceconnection.postRequests("post", param, eurl, fun);
            }
        }
    },

    //更改购买商品数量
    changeNumber: function(my, index) {
        if (classverifiction.isInt($(my).val()) && classverifiction.isInt($(my).val()) > 0) {
            mydatabase.updateData(index, $(my).val());
        } else {
            myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!");
        }
    },

    //删除购物车物品
    deleteShoppingInfo: function(my) {
        $("#page5 .alertMessage").html("您正在执行删除购物车商品，是否确定执行？");
        $("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',mydatabase.deleteItemData('" + $($(my).attr("data-inputId")).attr("proNum") + "','" + $(my).attr("shoppingItemId") + "'))");
        openAlert("#page5");
    }
};

/*类名:企业信息类*/
var OwnerInfoClass = {
    lati:0,
    longi:0,
    getEnterpriseInfo: function() {},

    getContactInfo: function() {
        var param = {};
        var eurl = adminUrlHead + getOwnerInfo;
        var fun = function(data) {
            var standbyUrl = "";
            if (data.status === "S") {
                var strAbout = data.respData.introduction;
                strAbout = strAbout.replace(/\./g, "。");
                var arrStr = strAbout.split("。");
                $("#codetext").append("<p>" + arrStr[0] + "。</p>");
                standbyUrl = imgLink(data.respData.ownerImg);
                $(".aboutImg").html("<img src='" + standbyUrl + "'  onerror=this.src='" + errImg + "'>");
                $("#contactInfo").prepend("<p>企业名：" + data.respData.companyName + "</p><p>地址：" + data.respData.address + "</p><p>网址：" + data.respData.webSite + "</p><p>联系人：" + data.respData.contactPerson + "</p><p>电话：" + data.respData.phoneNum.replace(/\s/g, "") + "</a></p>");
                classownerinfo.lati = data.respData.latitudes;
                classownerinfo.longi = data.respData.longitude;
                $("#container1").hide();
            } else {
                $(".allMessage .alertMessage").html(data.message);
                openAlert('.allMessage');
            }
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    }
};

/*类名:服务器交互类*/
var serviceConnectionClass = {
    //异步交互
    postRequest: function(type, param, url, method) {
        $.ajax({
            type: type,
            url: url,
            data: param,
            dataType: "json",
            success: method,
            //XmlHttpRequest,textStatus,error
            error: function() {
                //		    		alert(XmlHttpRequest.responseText);
                $("#container1").hide();
                if (phonedealwith.isPhoneInternal === false) {
                    hideLoader();
                    isLoding = true;
                }
            }
        });
    },

    //同步交互
    postRequests: function(type, param, url, method) {
        $.ajax({
            type: type,
            url: url,
            data: param,
            async: false,
            dataType: "json",
            success: method,
            error: function() {
                if (phonedealwith.isPhoneInternal === false) {
                    $("#container1").hide();
                    hideLoader();
                    isLoding = true;
                }
            }
        });
    }
};

/*类名:手机处理类*/
var phoneDealWithClass = {
    isPhoneInternal: false,

    onOffLineInternal: function() {
        $(".conPrompt").fadeIn();
        hideLoader();
        isLoding = true;
    },

    onOnLineInternal: function() {
        $(".conPrompt").fadeOut();
        isLoding = false;
    },

    onBackKeyDown: function() {
        if (indexclass.isIndex === true) {
            navigator.notification.confirm('确定退出企业应用吗',
                function(buttonIndex) {
                    if (buttonIndex === 1) {
                        phonedealwith.exitApp();
                    } else {
                        navigator.notification.cancel();
                    }
                },
                '退出企业应用', ['退出', '返回'])
        } else {
            navigator.app.backHistory();
        }
    },
    exitApp: function() {
        navigator.app.exitApp();
    },

    testSetJushTagNalias: function() {

        var param = {};
        var eurl = userUrlHead + userGetAliasNTags;
        var fun = function(data) {
            var standbyUrl = "";
            if (data.status === "S") {
                try {
                    cordova.exec(phonedealwith.pluginAlert, phonedealwith.pluginAlert, "JpushClient", "setJpushAliasAndTags", [data.respData.alias, data.respData.tags]);
                } catch(err) {}
            } else {}
        };
        serviceconnection.postRequest("post", param, eurl, fun);
    }
    //
    //    pluginAlert: function(message) {navigator.notification.alert("", function() {}, message,'确定');}
};

/*类名:验证类*/
var classVerifictionClass = {
    //验证手机号码合法性
    iphonever: function(str) {
        if (str == "") {
            return false;
        } else if (! (/^1[3|4|5|8][0-9]\d{8}$/.test(str))) {
            return false;
        } else {
            return true
        }
    },

    //验证纯数字
    isInt: function(str) {
        var reg = /^(-|\+)?\d+$/;
        return reg.test(str);
    },

    //验证是否字母和数字组成
    isLetterAndNum: function(str) {
        var reg = /^(([a-z]+[0-9]+)|([0-9]+[a-z]+)|[a-z]|[0-9])[a-z0-9]*$/;
        return reg.test(str);
    },

    //验证小数
    isFloat: function(str) {
        if (! (/^\d+(.\d{1,2}){0,1}$/.test(str))) {
            return false;
        } else {
            return true;
        }
    },

    //验证当前访问网站的是否属于手机
    isMobile: function() {
        var regex_match = /(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;
        var u = navigator.userAgent;
        if (null == u) {
            return true;
        }
        var result = regex_match.exec(u);
        if (null == result) {
            return false
        } else {
            return true
        }
    },

    wordLengthMax: function(wordLength) {
        var _zh = text ? text.match(/[^ -~]/g) : 0;
        var num = wordLength - Math.ceil((text.length + (_zh && _zh.length) || 0) / 2);
        if (num <= 0) {}
    }
};

//页面事件类
var myEnvetClass = {

    method: null,
    args: [],
    phonenum: "",
    //电话号码
    shoppingNum: 0,
    //购物车商品数量
    //滚动条事件绑定
    myScrollEnvet: function(mId) {

        $(document).on("scroll", "",
            function() {

                if (isNoLoading == false) {

                    var sHeight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
                    if (($(document).height() <= sHeight) && (isLoding == false)) {
                        isLoding = true;
                        showLoader();
                        if (myenvetclass.method != null) {
                            switch (myenvetclass.args.length) {
                                case 0:
                                    myenvetclass.method();
                                    break;
                                case 1:
                                    myenvetclass.method(myenvetclass.args[0]);
                                    break;
                                case 2:
                                    myenvetclass.method(myenvetclass.args[0], myenvetclass.args[1]);
                                    break;
                            }
                        } else {
                            hideLoader();
                            return;
                        }
                    }
                }
            });
    },

    //滚动条解除监听事件及页面参数恢复初始值
    ScrollEnvetRelease: function() {
        $(document).unbind("scroll");
        isNoLoading = false;
        isLoding = false;
        loadingPage = 1;
        $("#container1").hide();
        searchclass.searchKey = "";
        myenvetclass.args = [];
        myenvetclass.method = null;
    },

    //点击body隐藏菜单
    bodyClickEvent: function() {
        $("body").unbind("click").on("click",
            function(event) {
                var e = event || window.event;
                var elem = e.srcElement || e.target;
                if (elem !== document) {
                    if (elem.className !== "rigthMenu" && elem.className !== "rigthMenuImg" && elem.className !== "left-search" && elem.className !== "left-searchText" && elem.className !== "left-searchImg") {
                        if ($(".rigthMenu").attr("data-isMenuBtnOpen") === "true") {
                            $(".rigthMenu").attr("data-isMenuBtnOpen", "false");
                            $(".right-menu-list").hide();
                        }
                        if ($(".left-search").attr("data-isShow") === "true") {
                            $(".left-search-list").hide();
                            $(".left-search").attr("data-isShow", "false");
                        }
                        return;
                    }
                    elem = elem.parentNode;
                } else {
                    return;
                }

            });
    },

    alertConfirmAndCancel:function(){
        $(".confirmBtn").unbind("touchstart").on("touchstart",
            function(){
                $(".confirmBtn").css("color","#FFFFFF");
                $(".confirmBtn").css("background-color","#35C28C");
            });
        $(".confirmBtn").unbind("touchend").on("touchend",
            function(){
                $(".confirmBtn").css("color","#34A277");
                $(".confirmBtn").css("background-color","#e9e8e8");
            });
        $(".cancelBtn").unbind("touchstart").on("touchstart",
            function(){
                $(".cancelBtn").css("color","#FFFFFF");
                $(".cancelBtn").css("background-color","#35C28C");
            });
        $(".cancelBtn").unbind("touchend").on("touchend",
            function(){
                $(".cancelBtn").css("color","#34A277");
                $(".cancelBtn").css("background-color","transparent");
            });
    },


    //购物数量更改事件
    addShopping: function(minus, add, key) {
        if (key === undefined || key === null) {
            key = 0;
        }
        document.getElementById(minus).addEventListener("touchend",
            function() {
                userproduct.addOrMinusNumber("#" + minus, "minus", key);
            },
            true);
        document.getElementById(add).addEventListener("touchend",
            function() {
                userproduct.addOrMinusNumber("#" + add, "add", key);
            },
            true);
    },

    //右上菜单点击事件
    rightMenuEvent: function() {
        $(".rigthMenu").unbind("touchstart").on("touchstart",
            function() {
                $(".rigthMenu").css("display","block");
                $(".rigthMenu").css("background-color","#35C28C");
            });
        $(".rigthMenu").unbind("touchend").on("touchend",
            function() {
                $(".rigthMenu").css("background-color","transparent");
                var rigthMenu = $(".rigthMenu");
                var rightMenuList = $(".right-menu-list");
                if (rigthMenu.attr("data-isMenuBtnOpen") === "false") {
                    rigthMenu.attr("data-isMenuBtnOpen", "true");
                    rightMenuList.show();
                } else {
                    rigthMenu.attr("data-isMenuBtnOpen", "false");
                    rightMenuList.hide();
                }
            });

        //首页
        $(".index").unbind("touchstart").on("touchstart",
            function() {
                $(".index").css("display","block");
                $(".index").css("background-color","#35C28C");
                return;
            });
        $(".index").unbind("touchend").on("touchend",
            function() {
                $(".index").css("background-color","transparent");
                return;
            });
        $(".index").unbind("click").on("click",
            function() {
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                window.location.href = "#index";
            });
        //产品
        $(".product").unbind("touchstart").on("touchstart",
            function() {
                $(".product").css("display","block");
                $(".product").css("background-color","#35C28C");
            });
        $(".product").unbind("touchend").on("touchend",
            function() {
                $(".product").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                window.location.href = "#product";
            });
        //留言
        $(".leave").unbind("touchstart").on("touchstart",
            function() {
                $(".leave").css("display","block");
                $(".leave").css("background-color","#35C28C");
            });
        $(".leave").unbind("touchend").on("touchend",
            function() {
                $(".leave").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                window.location.href = "#message";
            });
        //企业
        $(".about").unbind("touchstart").on("touchstart",
            function() {
                $(".about").css("display","block");
                $(".about").css("background-color","#35C28C");
            });
        $(".about").unbind("touchend").on("touchend",
            function() {
                $(".about").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                window.location.href = "#about";
            });
        //买家
        $(".buyers").unbind("touchstart").on("touchstart",
            function() {
                $(".buyers").css("display","block");
                $(".buyers").css("background-color","#35C28C");
            });
        $(".buyers").unbind("touchend").on("touchend",
            function() {
                $(".buyers").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                classlogin.getUserLoginState('#personal', poppage);
            });
        //联系
        $(".phone").unbind("touchstart").on("touchstart",
            function() {
                $(".phone").css("display","block");
                $(".phone").css("background-color","#35C28C");
            });
        $(".phone").unbind("touchend").on("touchend",
            function() {
                $(".phone").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                if (myenvetclass.phonenum === "") {} else {
                    window.location.href = myenvetclass.phonenum;
                }
            });
        //卖家
        $(".seller").unbind("touchstart").on("touchstart",
            function() {
                $(".seller").css("display","block");
                $(".seller").css("background-color","#35C28C");
            });
        $(".seller").unbind("touchend").on("touchend",
            function() {
                $(".seller").css("background-color","transparent");
                if ($(this).attr("data-isRmenu") === "true") {
                    menuClose();
                }
                classlogin.getAdminLoginState('#adminMenu', poppage);
            });
    },

    //首页菜单点击事件
    indexMenuEvent: function() {
        //抽屉菜单打开与关闭
        $(".indexMenuIconBtn").unbind("click").on("click",
            function() {
                var indexMenuId = $("#indexMenuId");
                var indexMenuIconBtn = $(".indexMenuIconBtn");
                var indexMenuImg = $("#indexMenuImg");
                if (indexMenuId.attr("data-isInit") === "false") {
                    indexMenuId.show();
                    indexMenuId.attr("data-isInit", "true");
                }
                if (indexclass.isIndexMenuOpen === false) {
                    indexMenuImg.attr("src", "img/indexview/tdown.png");
                    indexMenuIconBtn.css("bottom", $(".classindexmenu").height());
                    indexMenuId.show();
                    indexclass.isIndexMenuOpen = true;
                } else {
                    indexMenuImg.attr("src", "img/indexview/ttop.png");
                    indexMenuIconBtn.css("bottom", "0px");
                    indexMenuId.hide();
                    indexclass.isIndexMenuOpen = false;
                }
            });
    },

    //产品展示前往列表展示
    proListShow: function() {
        $("#toAllListProShow").unbind("touchstart").on("touchstart",
            function() {
                $("#toAllListProShow").css("display","block");
                $("#toAllListProShow").css("background-color","#35C28C");
            });
        $("#toAllListProShow").unbind("touchend").on("touchend",
            function() {
                $("#toAllListProShow").css("background-color","transparent");
                window.location.href = "#allListProShow";
            });
    },

    //产品分类搜索菜单
    proSearchShow: function() {

        $(".toProSearch").unbind("touchstart").on("touchstart",
            function() {
                $(".toProSearch").css("display","block");
                $(".toProSearch").css("background-color","#35C28C");
            });
        $(".toProSearch").unbind("touchend").on("touchend",
            function() {
                $(".toProSearch").css("background-color","transparent");
                searchclass.proSearchBack(poppage);
                window.location.href = "#proSearch";
            });
    },

    //产品搜索选项事件
    proCatItemCilicEvent: function() {
        $(".catItem").unbind("touchend").on("touchend",
            function() {
                searchclass.userSearchIsNull('', $(this).attr("data-catName"), '', $(this).attr("data-catId"));
                window.location.href = "#page2-1";
            });
    },

    //产品详细按钮事件
    proDetailClickEvent: function() {
        //加入购物车
        $("#send").unbind("touchend").on("touchend",
            function() {
                classlogin.isUserLoginAddOrder('#page2-2', '#page2-2', this);
            });
        //查看购物车
        $("#goToDetailed").unbind("touchend").on("touchend",
            function() {
                classlogin.getUserLoginState('#page5', '#page2-2');
            });
    },

    //产品详情图片放大查看
    ampImgEvent:function(){
        $(".ampImg").unbind("click").on("click",
           function(){
               if($(this).attr("data-myImg") !== "" || $(this).attr("data-myImg") !== undefined){
                   $(".ampImgLayer").show();
                   $(".closeAmpImg").show();
                   $(".ampImgBg").html("<img src='"+$(this).attr("data-myImg")+"'>");
                   $(".ampImgBg").css("margin-left",-($(".ampImgBg").width() / 2));
                   $(".ampImgBg").css("margin-top",-($(".ampImgBg").height() / 2));
               }
           });
        $("#closeAmpBtn").unbind("touchstart").on("touchstart",
            function() {
                $(".closeAmpImg").css("background-color","#FF6666");
            });
        $("#closeAmpBtn").unbind("touchend").on("touchend",
            function() {
                $(".closeAmpImg").css("background-color","transparent");
                $(".ampImgLayer").hide();
                $(".ampImgBg").html("");
                $(".closeAmpImg").hide();
            });
    },

    //去1688按钮点击变色
    goto1688Event:function(){
        $("#goToTaoBao").unbind("touchstart").on("touchstart",
            function(){
                $("#goToTaoBao").css("filter","alpha(opacity=0.8)");
                $("#goToTaoBao").css("-moz-opacity","0.8");
                $("#goToTaoBao").css("-khtml-opacity","0.8");
                $("#goToTaoBao").css("opacity","0.8");
            });

        $("#goToTaoBao").unbind("touchend").on("touchend",
            function(){
                $("#goToTaoBao").css("filter","alpha(opacity=1)");
                $("#goToTaoBao").css("-moz-opacity","1");
                $("#goToTaoBao").css("-khtml-opacity","1");
                $("#goToTaoBao").css("opacity","1");
            });
    },

    //查看详情
    selectDetailed: function() {
        $(".seldetail").unbind("click").on("click",
            function() {
                if ($(this).attr("data-iswindow") === undefined || $(this).attr("data-iswindow") === null) {
                    setpoppage(this, poppage);
                    window.location.href = "#page2-2";
                } else {
                    webpage_mobile($(this).attr("data-aliurl"));
                }
            });
    },

    //返回按钮
    backBtnClickEnvet: function() {
        $(".back").unbind("touchstart").on("touchstart",
            function() {
                $(".back").css("display","block");
                $(".back").css("background-color","#35C28C");
            });
        $(".back").unbind("touchend").on("touchend",
            function() {
                $(".back").css("background-color","transparent");
                $.mobile.back();
            });
    },

    //发表评论
    addMessage: function() {
        $("#addmessagebtn").unbind("touchstart").on("touchstart",
            function(){
                $("#addmessagebtn img").css("filter","alpha(opacity=0.7)");
                $("#addmessagebtn img").css("-moz-opacity","0.7");
                $("#addmessagebtn img").css("opacity","0.7");
                $("#addmessagebtn img").css("-khtml-opacity","0.7");
            });
        $("#addmessagebtn").unbind("touchend").on("touchend",
            function() {
                $("#addmessagebtn img").css("filter","alpha(opacity=1)");
                $("#addmessagebtn img").css("-moz-opacity","1");
                $("#addmessagebtn img").css("opacity","1");
                $("#addmessagebtn img").css("-khtml-opacity","1");
                if ($("#messagetext").val() !== "") {
                    classlogin.isUserLogin();
                    if (classlogin.userLoginState === true) {
                        messageboards.sendMessage();
                    } else {
                        $("#message .alertMessage").html("您当前尚未登录，将以匿名身份进行评论。");
                        $("#message .alertBtnConfirm a").attr("onclick", "messageboards.sendMessage()");
                        openAlert("#message");
                    }
                } else {
                    myAlert(".myAlertView", ".myAlertMessage", "评论不能为空!");
                }
            });
    },

    //企业简介
    aboutAndContact: function() {
        //到联系我们
        $("#toContact").unbind("touchstart").on("touchstart",
            function(){
                $("#toContact").css("background-color","#dadada");
            });
        $("#toContact").unbind("touchend").on("touchend",
            function() {
                $("#toContact").css("background-color","transparent");
                window.location.href = "#contact";
            });
        //到简介
        $("#toAbout").unbind("touchstart").on("touchstart",
            function(){
                $("#toAbout").css("background-color","#dadada");
            });
        $("#toAbout").unbind("touchend").on("touchend",
            function() {
                $("#toAbout").css("background-color","transparent");
                $.mobile.back();
            });
    },

    //用户注册
    userRegisterClickEnvet: function(){
        $("#toregister").unbind("touchstart").on("touchstart",
            function() {
                $("#toregister").css("background-color","#e9e8e8");
            });
        $("#toregister").unbind("touchend").on("touchend",
            function() {
                $("#toregister").css("background-color","#ffffff");
                window.location.href = "#register";
            });
    },

    //用户登陆
    userLoginClickEnvet: function() {

        $("#userloginsend").unbind("touchstart").on("touchstart",
            function(){
                $("#userloginsend").css("background-color","#2eb07f");
            });
        $("#userloginsend").unbind("touchend").on("touchend",
            function() {
                $("#userloginsend").css("background-color","#35C28C");
                classlogin.userLogin($('#username').val(), $('#userpassword').val());
            });
    },

    //提交注册信息
    sendRegisterInfo: function() {
        $("#sendRegisterBtn").unbind("touchstart").on("touchstart",
            function(){
                $("#sendRegisterBtn").css("background-color","#2eb07f");
            });
        $("#sendRegisterBtn").unbind("touchend").on("touchend",
            function() {
                $("#sendRegisterBtn").css("background-color","#35C28C");
                registclass.userRegist($('#raccount').val(), $('#rpassword').val(), $('#rpasswordok').val(), $('#rname').val(), $('#rcompanyName').val());
            });
    },

    //个人中心菜单事件
    personalItemEvent: function() {
        //购物车
        $("#toShopping").unbind("touchstart").on("touchstart",
            function(){
                $("#toShopping").css("background-color","#35C28C");
                $("#toShopping").css("color","#FFFFFF");
            });
        $("#toShopping").unbind("touchend").on("touchend",
            function() {
                $("#toShopping").css("background-color","transparent");
                $("#toShopping").css("color","#9e9b9b");
                window.location.href = "#page5";
            });
        //待审核订单
        $("#toUserWaitingAudit").unbind("touchstart").on("touchstart",
            function(){
                $("#toUserWaitingAudit").css("background-color","#35C28C");
                $("#toUserWaitingAudit").css("color","#FFFFFF");
            });
        $("#toUserWaitingAudit").unbind("touchend").on("touchend",
            function() {
                $("#toUserWaitingAudit").css("background-color","transparent");
                $("#toUserWaitingAudit").css("color","#9e9b9b");
                window.location.href = "#userWaitingAudit";
            });
        //我已下订单
        $("#toMyOrder").unbind("touchstart").on("touchstart",
            function(){
                $("#toMyOrder").css("background-color","#35C28C");
                $("#toMyOrder").css("color","#FFFFFF");
            });
        $("#toMyOrder").unbind("touchend").on("touchend",
            function() {
                $("#toMyOrder").css("background-color","transparent");
                $("#toMyOrder").css("color","#9e9b9b");
                window.location.href = "#myorder";
            });
        //特供商品
        $("#toSuperPro").unbind("touchstart").on("touchstart",
            function(){
                $("#toSuperPro").css("background-color","#35C28C");
                $("#toSuperPro").css("color","#FFFFFF");
            });
        $("#toSuperPro").unbind("touchend").on("touchend",
            function() {
                $("#toSuperPro").css("background-color","transparent");
                $("#toSuperPro").css("color","#9e9b9b");
                window.location.href = "#superPro";
            });
        //修改注册信息
        $("#toUserModifyInfo").unbind("touchstart").on("touchstart",
            function(){
                $("#toUserModifyInfo").css("background-color","#35C28C");
                $("#toUserModifyInfo").css("color","#FFFFFF");
            });
        $("#toUserModifyInfo").unbind("touchend").on("touchend",
            function() {
                $("#toUserModifyInfo").css("background-color","transparent");
                $("#toUserModifyInfo").css("color","#9e9b9b");
                window.location.href = "#userModifyInfo";
            });
        //修改密码
        $("#toUserModifyPass").unbind("touchstart").on("touchstart",
            function(){
                $("#toUserModifyPass").css("background-color","#35C28C");
                $("#toUserModifyPass").css("color","#FFFFFF");
            });
        $("#toUserModifyPass").unbind("touchend").on("touchend",
            function() {
                $("#toUserModifyPass").css("background-color","transparent");
                $("#toUserModifyPass").css("color","#9e9b9b");
                window.location.href = "#userModifyPass";
            });
        //注销登陆
        $("#myOutLogin").unbind("touchstart").on("touchstart",
            function(){
                $("#myOutLogin").css("background-color","#35C28C");
                $("#myOutLogin").css("color","#FFFFFF");
            });
        $("#myOutLogin").unbind("touchend").on("touchend",
            function() {
                $("#myOutLogin").css("background-color","transparent");
                $("#myOutLogin").css("color","#9e9b9b");
                openAlert('#personal');
            });
    },

    //用户修改密码
    userUpdatePass: function() {
        $("#updateUpassDone").unbind("touchstart").on("touchstart",
            function(){
                $("#updateUpassDone").css("background-color","#2eb07f");
            });
        $("#updateUpassDone").unbind("touchend").on("touchend",
            function() {
                $("#updateUpassDone").css("background-color","#35C28C");
                classlogin.isUserLegality();
            });
    },

    //用户修改注册信息
    userUpdateInfo: function() {
        $("#updateInfoDone").unbind("touchstart").on("touchstart",
            function(){
                $("#updateInfoDone").css("background-color","#2eb07f");
            });
        $("#updateInfoDone").unbind("touchend").on("touchend",
            function() {
                $("#updateInfoDone").css("background-color","#35C28C");
                registclass.userUpdateInfo($('#companyName').val(), $('#contactName').val(), $('#contactPhone').val(), $('#companyAddress').val());
            });
    },

    //购物车删除商品
    deleteShoppingAPro: function() {
        $(".deleteBtn").unbind("touchend").on("touchend",
            function() {
                userproduct.deleteShoppingInfo(this);
            });
    },

    //提交购物车
    sendShoppingOrder: function() {
        $("#orderSendBtn").unbind("click").on("click",
            function() {
                for (var i = 0,
                         len = myenvetclass.shoppingNum; i < len; i++) {
                    if (classverifiction.isInt($("#shoppingNum" + i).val()) && classverifiction.isInt($("#shoppingNum" + i).val()) > 0) {
                        mydatabase.updateData($("#shoppingNum" + i).attr("proNum"), $("#shoppingNum" + i).val());
                        if (i === len - 1) {
                            openAlert('#page5');
                        }
                    } else {
                        myAlert(".myAlertView", ".myAlertMessage", "第" + (i + 1) + "个产品数量有误!");
                        break;

                    }
                }
            });
    },

    //管理员登陆
    adminLoginClickEvent: function() {
        $("#adminLoginBtn").unbind("touchstart").on("touchstart",
            function(){
                $("#adminLoginBtn").css("background-color","#2eb07f");
            });
        $("#adminLoginBtn").unbind("touchend").on("touchend",
            function() {
                $("#adminLoginBtn").css("background-color","#35C28C");
                classlogin.adminLogin($('#adminname').val(), $('#adminpassword').val())
            });
    },

    //管理员界面菜单事件
    adminMenuItemEvent: function() {
        //管理员订单管理
        $("#toAdminSelectOrder").unbind("touchstart").on("touchstart",
            function(){
                $("#toAdminSelectOrder").css("background-color","#35C28C");
                $("#toAdminSelectOrder").css("color","#FFFFFF");
            });
        $("#toAdminSelectOrder").unbind("touchend").on("touchend",
            function() {
                $("#toAdminSelectOrder").css("background-color","transparent");
                $("#toAdminSelectOrder").css("color","#9e9b9b");
                window.location.href = "#adminselectorder";
            });
        //管理员产品管理
        $("#toAdminProManage").unbind("touchstart").on("touchstart",
            function(){
                $("#toAdminProManage").css("background-color","#35C28C");
                $("#toAdminProManage").css("color","#FFFFFF");
            });
        $("#toAdminProManage").unbind("touchend").on("touchend",
            function() {
                $("#toAdminProManage").css("background-color","transparent");
                $("#toAdminProManage").css("color","#9e9b9b");
                window.location.href = "#adminProManage";
            });
        //管理员修改密码
        $("#toAdminModifyPass").unbind("touchstart").on("touchstart",
            function(){
                $("#toAdminModifyPass").css("background-color","#35C28C");
                $("#toAdminModifyPass").css("color","#FFFFFF");
            });
        $("#toAdminModifyPass").unbind("touchend").on("touchend",
            function() {
                $("#toAdminModifyPass").css("background-color","transparent");
                $("#toAdminModifyPass").css("color","#9e9b9b");
                window.location.href = "#adminModifyPass";
            });
        //管理员产看客户列表
        $("#toClientSearch").unbind("touchstart").on("touchstart",
            function(){
                $("#toClientSearch").css("background-color","#35C28C");
                $("#toClientSearch").css("color","#FFFFFF");
            });
        $("#toClientSearch").unbind("touchend").on("touchend",
            function() {
                $("#toClientSearch").css("background-color","transparent");
                $("#toClientSearch").css("color","#9e9b9b");
                window.location.href = "#clientsearch";
            });
        //管理员注销登录
        $("#adminOutLogin").unbind("touchstart").on("touchstart",
            function(){
                $("#adminOutLogin").css("background-color","#35C28C");
                $("#adminOutLogin").css("color","#FFFFFF");
            });
        $("#adminOutLogin").unbind("touchend").on("touchend",
            function() {
                $("#adminOutLogin").css("background-color","transparent");
                $("#adminOutLogin").css("color","#9e9b9b");
                openAlert('#adminMenu');
            });
    },

    //管理员搜索客户搜索框
    adminSearch: function() {
        //搜索条件
        $(".aSearchItem").unbind("touchend").on("touchend",
            function() {
                if ($(this).attr("data-optionItem") === "item") {
                    $(".search-custoner-top div").attr("data-optionItem", "item");
                    $(this).attr("data-optionItem", "itemSelected");
                    searchUserKey = parseInt($(this).attr("data-myVal"));
                } else {}
            });
        //搜索按钮
        $("#aSearchBtn").unbind("touchstart").on("touchstart",
            function() {
                $("#aSearchBtn").css("filter","alpha(opacity=0.7)");
                $("#aSearchBtn").css("-moz-opacity","0.7");
                $("#aSearchBtn").css("opacity","0.7");
                $("#aSearchBtn").css("-khtml-opacity","0.7");
            });
        $("#aSearchBtn").unbind("touchend").on("touchend",
            function() {
                $("#aSearchBtn").css("filter","alpha(opacity=1)");
                $("#aSearchBtn").css("-moz-opacity","1");
                $("#aSearchBtn").css("opacity","1");
                $("#aSearchBtn").css("-khtml-opacity","1");
                searchclass.conditionSearch();
            });
    },

    adminOpenSearchKey: function() {
        $(".left-search").unbind("touchend").on("touchend",
            function() {
                if ($(this).attr("data-isShow") === "false") {
                    $(".left-search-list").show();
                    $(".left-search-list ul li a[data-state='true']").hide();
                    $(".left-search-list ul li a[data-state='false']").show();
                    $(this).attr("data-isShow", "true");
                } else {
                    $(".left-search-list").hide();
                    $(this).attr("data-isShow", "false");
                }
            });
    },

    adminSearchOrderKey: function() {
        $(".orderSearchKey").unbind("touchend").on("touchend",
            function() {
                var leftSearch = $(".left-search");
                leftSearch.attr("data-searchKey", $(this).attr("data-keyValue"));
                $(".left-search-list ul li a:nth-child(0)").attr("data-state", "false");
                $(".left-search-list ul li a:nth-child(1)").attr("data-state", "false");
                $(this).attr("data-state", "true");
                $(".left-searchText").html($(this).html());
                $(".left-search-list").hide();
                leftSearch.attr("data-isShow", "false");
            });
    },

    adminSearchOrderBtn: function() {
        $(".right-search").unbind("touchstart").on("touchstart",
            function() {
                $(".right-search").css("filter","alpha(opacity=0.7)");
                $(".right-search").css("-moz-opacity","0.7");
                $(".right-search").css("opacity","0.7");
                $(".right-search").css("-khtml-opacity","0.7");
            });
        $(".right-search").unbind("touchend").on("touchend",
            function() {
                $(".right-search").css("filter","alpha(opacity=1)");
                $(".right-search").css("-moz-opacity","1");
                $(".right-search").css("opacity","1");
                $(".right-search").css("-khtml-opacity","1");
                loadingPage = 1;
                manageorder.aUserCompany = "";
                manageorder.aUserPhoneNum = "";
                isNoLoading = false;
                var searchType = $(".left-search").attr("data-searchKey");
                manageorder.aUserCompany = "";
                $(".aorderList").html("");
                $(".noOrder").hide();
                $("#container1").show();
                if (searchType === "1") {
                    manageorder.aUserCompany = $(".search-order2-1").val();
                    manageorder.adminShowOrderList();
                    return;
                } else {
                    manageorder.aUserPhoneNum = $(".search-order2-1").val();
                    manageorder.adminShowOrderList();
                    return;
                }
            });
    },

    //管理员查看单个客户所有订单
    selectAUserOrder: function() {
        $(".toUserOrder").unbind("click").on("click",
            function() {
                setCustOrderKey($(this).attr("data-orderKey"));
                window.location.href = "#adminselectorder";
            });
    },

    //管理员修改密码
    updateAdminPass: function() {
        $("#updateAdminPassBtn").unbind("touchend").on("touchend",
            function() {
                classlogin.isAdminLegality();
            });
    },

    //管理员搜索产品按钮
    adminSearchBtnClickEvent: function() {
        $("#adminSearchPro").unbind("touchstart").on("touchstart",
            function() {
                $("#adminSearchPro").css("filter","alpha(opacity=0.7)");
                $("#adminSearchPro").css("-moz-opacity","0.7");
                $("#adminSearchPro").css("opacity","0.7");
                $("#adminSearchPro").css("-khtml-opacity","0.7");
            });
        $("#adminSearchPro").unbind("touchend").on("touchend",
            function() {
                $("#adminSearchPro").css("filter","alpha(opacity=1)");
                $("#adminSearchPro").css("-moz-opacity","1");
                $("#adminSearchPro").css("opacity","1");
                $("#adminSearchPro").css("-khtml-opacity","1");
                admingetprodata.aSearchPro($("#proSearchKey").val());
            });
    },

    //管理员管理产品库存及价格 li class='seldetail'

    adminUpdateNumAdnPrice: function() {
        //价格
        $(".adminUpdatePrice").unbind("touchstart").on("touchstart",
            function(){
                $(this).css("filter","alpha(opacity=0.7)");
                $(this).css("-moz-opacity","0.7");
                $(this).css("-khtml-opacity","0.7");
                $(this).css("opacity","0.7");
            });
        $(".adminUpdatePrice").unbind("touchend").on("touchend",
            function() {
                $(this).css("filter","alpha(opacity=1)");
                $(this).css("-moz-opacity","1");
                $(this).css("-khtml-opacity","1");
                $(this).css("opacity","1");
            });
        $(".adminUpdatePrice").unbind("click").on("click",
            function() {
                admingetprodata.editPro('a', $(this).attr("data-price"), 'priceValue', this);
            });
        //数量
        $(".adminUpdateProNum").unbind("touchstart").on("touchstart",
            function(){
                $(this).css("filter","alpha(opacity=0.7)");
                $(this).css("-moz-opacity","0.7");
                $(this).css("-khtml-opacity","0.7");
                $(this).css("opacity","0.7");
            });
        $(".adminUpdateProNum").unbind("touchend").on("touchend",
            function() {
                $(this).css("filter","alpha(opacity=1)");
                $(this).css("-moz-opacity","1");
                $(this).css("-khtml-opacity","1");
                $(this).css("opacity","1");
            });
        $(".adminUpdateProNum").unbind("click").on("click",
            function() {
                admingetprodata.editPro('b', $(this).attr("data-num"), 'stockValue', this);
            });
    },

    //管理员进入订单详细页
    adminToOrderDetailInfo: function() {
        $(".toOrderInfo span").unbind("touchstart").on("touchstart",
            function(){
                $(this).css("filter","alpha(opacity=0.7)");
                $(this).css("-moz-opacity","0.7");
                $(this).css("-khtml-opacity","0.7");
                $(this).css("opacity","0.7");
            });
        $(".toOrderInfo span").unbind("touchend").on("touchend",
            function(){
                $(this).css("filter","alpha(opacity=1)");
                $(this).css("-moz-opacity","1");
                $(this).css("-khtml-opacity","1");
                $(this).css("opacity","1");
            });
        $(".toOrderInfo").unbind("click").on("click",
            function() {
                manageorder.adminGetOrderInfo(this);
                window.location.href = "#orderinfo";
            });
    }
};

/*页面载入执行方法*/
$(document).bind('pageinit',
    function() {
        var content = $(".content");
        var classindexmenu = $(".classindexmenu");
        var wrapper = $("#index #wrapper");

        $(".ui-li-thumb").css("top", "20");
        $(".ui-listview .ui-li-icon").css("top", "20");
        if (classverifiction.isMobile()) {
            content.width(window.innerWidth);
            $(".swiper-container").width(content.width());
            $(".slider-wrapper").width(content.width());
            classindexmenu.width(content.width());
            $(".productcontent").width(content.width());
            $(".sendbutton").width(content.width());
        } else {
            content.width(320);
            wrapper.css("left", "50%");
            wrapper.css("margin-left", "-160px");
            wrapper.css("_margin-left", "-160px");
            wrapper.css("*margin-left", "-160px");
            $(".productcontent").width(content.width());
            $(".swiper-container").width(content.width());
            $(".slider-wrapper").width(content.width());
            $(".classindexmenu").width(content.width());
            $(".sendbutton").width(content.width());
        }
        $(".scrollerBg").width(content.width());
        $(".searchtypetext").width(content.width() - 150);
        classindexmenu.css("top", $("footer").height() - 50);
        $(".optionItem a").width((content.width() - 2) * 0.28);
        $(".indexMenuIcon").width(content.width());
        myenvetclass.bodyClickEvent();
        myenvetclass.rightMenuEvent();
        myenvetclass.backBtnClickEnvet();
        myenvetclass.alertConfirmAndCancel();
        myenvetclass.goto1688Event();
    });

//显示加载器  
function showLoader() {
    $.mobile.loading('show', {
        text: '加载中...',
        //加载器中显示的文字  
        textVisible: true,
        //是否显示文字  
        theme: 'b',
        //加载器主题样式  
        textonly: true,
        //是否只显示文字  
        html: "" //要显示的html内容，如图片等 
    });
}

//隐藏加载器
function hideLoader() {
    //隐藏加载器  
    $.mobile.loading('hide');
}

function setpoppage(my, page) {
    productIndex = my;
    poppage = page;
    $("#back").attr("href", poppage);
    $("#contentslider .swiper-container").html("");
    $(".detailed-tittle h5").html("");
    $(".cqcs ul").html("");
    userproduct.getDetailed($(my).attr("data-myindex"));
    $("#container1").show();
}

function webpage_mobile(url) {
    var ref = window.open(url, '_blank', 'location=yes,closebuttoncaption=关闭,transitionstyle=crossdissolve,presentationstyle=pagesheet');
    ref.addEventListener('loaderror',
        function(event) {
            $(".allMessage .alertMessage").html('error: ' + event.message);
            openAlert('.allMessage');
        });
}

//*IOS7头部标题栏增加高度，以适应被状态栏挡住的字体
function ios7navInit() {

    try {
        if (classverifiction.isMobile()) {

            if (window.device.platform === "iOS") {

                if (window.device.version.substr(0, 1) === "7" || window.device.version.substr(0, 1) === "8") {
                    var uiBar = $(".ui-bar-y");
                    $(".ui-title").css("height", "64px");
                    $(".ui-title").css("line-height", "55px");
                    uiBar.css("height", "64px");
                    uiBar.css("line-height", "120px");
                    $(".navigationLeftBtn").css("top", "16px");
                    $(".navigationRightBtn").css("top", "16px");
                    $(".navigationMenuBtn").css("top", "16px");
                    $(".navigationImg").css("top", "14px");
                    $(".right-menu-list").css("top", "62px");
                    $("#wrapper").css("top", "64px");
                }
            }
        }
    } catch(error) {}
}

function textLengthCut(str) {
    if (str.length > 10) {
        return str.substring(0, 10) + "...";
    }
    return str;
}

function textLengthTrim(str) {
    return str.replace(/\s/g, "");
}

//获取url后面的参数值
function getUrlParm(name) {
    var regexS = "[\\?&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var tmpURL = window.location.href;
    var results = regex.exec(tmpURL);
    if (results == null) {
        return "";
    } else {
        return results[1];
    }
}

//图片链接处理
function imgLink(url) {
    var urlData;
    if (url === null) {
        urlData = proImgUrl + defaultuImg;
    } else {
        if (url.substring(0, 4) === "http") {
            urlData = url;
        } else {
            urlData = proImgUrl + url;
        }
    }
    return urlData;
}

function isCom() {
    var eurl = adminUrlHead + getSetting;
    var param = {};
    var fun = function(data) {
        if (data.status === "S" && data.respData === true) {
            isComShopping = true;
        }
    };
    serviceconnection.postRequest("post", param, eurl, fun);
}
function myAlert(view, messageView, message) {
    $(messageView).html(message);
    $(view).fadeIn();
    if (isAlertShow === false) {
        setTimeout(function() {
                $(view).fadeOut();
                isAlertShow = false;
            },
            3000);
    }
    isAlertShow = true;
}
function inputFocusOrInputBlur(className, imgUrl) {
    $(className).attr("src", imgUrl);
}

function openAlert(id) {
    $(id + " .alertViewBg").fadeIn();
    $(id + " .alertViewBg2").fadeIn();
}

function confirmEnvent(id, medthod, url, isHide) {
    if (isHide !== "false") {
        $(id + " .alertViewBg").hide();
        $(id + " .alertViewBg2").hide();
    }
    if (medthod !== "" && medthod !== undefined) {
        medthod;
    }
    if (url !== "" && url !== undefined) {
        window.location.href = url;
    }
}

function closeAlert(id) {
    $(id + " .alertViewBg").fadeOut();
    $(id + " .alertViewBg2").fadeOut();
    if (id === "#page5") {
        setTimeout(function() {
                $("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',userproduct.sendOrder())");
                $("#page5 .alertMessage").html("您确定提交订单吗？");
            },
            1000);
    }
}

function mapInit(lon, la) {
    var map = new BMap.Map("contenttexts");
    var point = new BMap.Point(lon, la);
    var marker = new BMap.Marker(point);
    map.centerAndZoom(point, 16);
    map.addControl(new BMap.ZoomControl()); //添加地图缩放控件
    map.addOverlay(marker);
    var traffic = new BMap.TrafficLayer(); // 创建交通流量图层实例
    map.addTileLayer(traffic); // 将图层添加到地图上
    //放到到14级
    map.setZoom(17);
}

//function setSearchKey(key){saveSearchKey = key;}
$(document).on("click", "#goToDetailed",
    function() {
        $(".shoppingBack").attr("href", "#page2-2");
    });

$(document).on("click", ".myProMenu",
    function() {
        if ($(this).parent().find("ul").attr("ishide") === "true") {
            $(this).parent().find("ul").hide();
            $(this).parent().find("span").html(">");
            $(this).parent().find("ul").attr("ishide", "false");
        } else {
            $(this).parent().find("ul").show();
            $(this).parent().find("ul").attr("ishide", "true");
            $(this).parent().find("span").html("∨");
        }
    });

function menuClose() {
    var rigthMenu = $(".rigthMenu");
    if (rigthMenu.attr("data-isMenuBtnOpen") === "true") {
        rigthMenu.attr("data-isMenuBtnOpen", "false");
        $(".right-menu-list").hide();
    }
    poppage = "#" + location.hash.split("#", 2)[1];
}

$(document).on('click', '#adminselectorder',
    function() {
        var orderSearchOption = $(".orderSearchOption");
        if (orderSearchOption.attr("isOptionShow") === "true") {
            orderSearchOption.hide();
            orderSearchOption.attr("isOptionShow", "false");
        }
    });

function setCustOrderKey(unum) {
    manageorder.userNum = unum;
    $("#aSOrderBack").attr('href', '#clientsearch');
}

function pullDownAction(method) {
    setTimeout(function() {
            method();
            myScroll.refresh();
        },
        100);
}

function pullUpAction(method) {
    setTimeout(function() { // <-- Simulate network congestion, remove setTimeout from production!
            method();
            myScroll.refresh(); // 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
        },
        1000); // <-- Simulate network congestion, remove setTimeout from production!
}

function loaded(mId, pullDown, pullUp, downmethod, upmethod, block, moffset) {
    pullDownEl = document.getElementById(pullDown);
    if (pullUp !== null) {
        pullUpEl = document.getElementById(pullUp);
    }

    myScroll = new iScroll(mId, {
        scrollbarClass: 'myScrollbar',
        /* 重要样式 */
        hScroll: false,
        hScrollbar: false,
        useTransition: true,
        useTransform: true,
        topOffset: moffset,
        checkDOMChanges: true,
        onRefresh: function() {
            if (pullDownEl.className.match('loading')) {
                pullDownEl.className = '';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
            } else if (pullUp !== null) {
                if (pullUpEl.className.match('loading')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                }
            }
        },
        onBeforeScrollMove: function() {
            $("#" + block + "").show();
            $(".rigthMenu").attr("data-isMenuBtnOpen", "false");
            $(".right-menu-list").hide();
        },
        onScrollMove: function() {
            if (this.y > 5 && !pullDownEl.className.match('flip')) {
                pullDownEl.className = 'flip';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
                this.minScrollY = 0;
            } else if (this.y < 5 && pullDownEl.className.match('flip')) {
                pullDownEl.className = '';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                this.minScrollY = -pullDownOffset;
            } else if (pullUp !== null) {
                if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'flip';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
                    this.maxScrollY = this.maxScrollY;
                } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
                    pullUpEl.className = '';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                    this.maxScrollY = this.y;
                }
            }
        },
        onScrollEnd: function() {
            if (pullDownEl.className.match('flip')) {
                pullDownEl.className = 'loading';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';
                pullDownAction(downmethod); // Execute custom function (ajax call?)
            } else if (pullUp !== null) {
                if (pullUpEl.className.match('flip')) {
                    pullUpEl.className = 'loading';
                    pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';
                    pullUpAction(upmethod); // Execute custom function (ajax call?)
                }
            }
            $("#" + block + "").hide();

        },
        onTouchEnd: function() {
            $("#" + block + "").hide();
        }
    });
}

//加载中动画
(function() {
    var emptyFn = function() {};
    function Sonic(d) {
        this.data = d.path || d.data;
        this.imageData = [];
        this.multiplier = d.multiplier || 1;
        this.padding = d.padding || 0;
        this.fps = d.fps || 25;
        this.stepsPerFrame = ~~d.stepsPerFrame || 1;
        this.trailLength = d.trailLength || 1;
        this.pointDistance = d.pointDistance || .05;
        this.domClass = d.domClass || 'sonic';
        this.fillColor = d.fillColor || '#FFF';
        this.strokeColor = d.strokeColor || '#FFF';
        this.stepMethod = typeof d.step == 'string' ? stepMethods[d.step] : d.step || stepMethods.square;
        this._setup = d.setup || emptyFn;
        this._teardown = d.teardown || emptyFn;
        this._preStep = d.preStep || emptyFn;
        this.width = d.width;
        this.height = d.height;
        this.fullWidth = this.width + 2 * this.padding;
        this.fullHeight = this.height + 2 * this.padding;
        this.domClass = d.domClass || 'sonic';
        this.setup();
    }
    var argTypes = Sonic.argTypes = {
        DIM: 1,
        DEGREE: 2,
        RADIUS: 3,
        OTHER: 0
    };
    var argSignatures = Sonic.argSignatures = {
        arc: [1, 1, 3, 2, 2, 0],
        bezier: [1, 1, 1, 1, 1, 1, 1, 1],
        line: [1, 1, 1, 1]
    };
    var pathMethods = Sonic.pathMethods = {
        bezier: function(t, p0x, p0y, p1x, p1y, c0x, c0y, c1x, c1y) {

            t = 1 - t;
            var i = 1 - t,
                x = t * t,
                y = i * i,
                a = x * t,
                b = 3 * x * i,
                c = 3 * t * y,
                d = y * i;
            return [a * p0x + b * c0x + c * c1x + d * p1x, a * p0y + b * c0y + c * c1y + d * p1y]
        },
        arc: function(t, cx, cy, radius, start, end) {
            var point = (end - start) * t + start;
            var ret = [(Math.cos(point) * radius) + cx, (Math.sin(point) * radius) + cy];
            ret.angle = point;
            ret.t = t;
            return ret;
        },
        line: function(t, sx, sy, ex, ey) {
            return [(ex - sx) * t + sx, (ey - sy) * t + sy]
        }
    };
    var stepMethods = Sonic.stepMethods = {

        square: function(point) {
            this._.fillRect(point.x - 3, point.y - 3, 6, 6);
        }
        //		fader: function(point) {
        //			this._.beginPath();
        //			if (this._last) {
        //				this._.moveTo(this._last.x, this._last.y);
        //			}
        //			this._.lineTo(point.x, point.y);
        //			this._.closePath();
        //			this._.stroke();
        //			this._last = point;
        //		}
    };
    Sonic.prototype = {
        setup: function() {
            var args, type, method, value, data = this.data;
            this.canvas = document.createElement('canvas');
            this._ = this.canvas.getContext('2d');
            this.canvas.className = this.domClass;
            this.canvas.height = this.fullHeight;
            this.canvas.width = this.fullWidth;
            this.points = [];
            for (var i = -1,
                     l = data.length; ++i < l;) {
                args = data[i].slice(1);
                method = data[i][0];
                if (method in argSignatures) for (var a = -1,
                                                      al = args.length; ++a < al;) {
                    type = argSignatures[method][a];
                    value = args[a];
                    switch (type) {
                        case argTypes.RADIUS:
                            value *= this.multiplier;
                            break;
                        case argTypes.DIM:
                            value *= this.multiplier;
                            value += this.padding;
                            break;
                        case argTypes.DEGREE:
                            value *= Math.PI / 180;
                            break;
                    }
                    args[a] = value;
                }
                args.unshift(0);
                for (var r, pd = this.pointDistance,
                         t = pd; t <= 1; t += pd) {

                    // Avoid crap like 0.15000000000000002
                    t = Math.round(t / pd) / (1 / pd);
                    args[0] = t;
                    r = pathMethods[method].apply(null, args);
                    this.points.push({
                        x: r[0],
                        y: r[1],
                        progress: t
                    });
                }
            }
            this.frame = 0;
            //this.prep(this.frame);
        },
        prep: function(frame) {
            if (frame in this.imageData) {
                return;
            }
            this._.clearRect(0, 0, this.fullWidth, this.fullHeight);

            var points = this.points,
                pointsLength = points.length,
            //				pd = this.pointDistance,
                point, index, frameD, indexD;
            this._setup();
            for (var i = -1,
                     l = pointsLength * this.trailLength; ++i < l && !this.stopped;) {
                index = frame + i;
                point = points[index] || points[index - pointsLength];
                if (!point) continue;
                this.alpha = Math.round(1000 * (i / (l - 1))) / 1000;
                this._.globalAlpha = this.alpha;
                this._.fillStyle = this.fillColor;
                this._.strokeStyle = this.strokeColor;
                frameD = frame / (this.points.length - 1);
                indexD = i / (l - 1);
                this._preStep(point, indexD, frameD);
                this.stepMethod(point, indexD, frameD);
            }
            this._teardown();
            this.imageData[frame] = (this._.getImageData(0, 0, this.fullWidth, this.fullWidth));
            return true;
        },
        draw: function() {

            if (!this.prep(this.frame)) {
                this._.clearRect(0, 0, this.fullWidth, this.fullWidth);
                this._.putImageData(this.imageData[this.frame], 0, 0);
            }
            this.iterateFrame();
        },
        iterateFrame: function() {

            this.frame += this.stepsPerFrame;
            if (this.frame >= this.points.length) {
                this.frame = 0;
            }
        },
        play: function() {
            this.stopped = false;
            var hoc = this;
            this.timer = setInterval(function() {
                    hoc.draw();
                },
                    1000 / this.fps);
        },
        stop: function() {
            this.stopped = true;
            this.timer && clearInterval(this.timer);
        }
    };
    window.Sonic = Sonic;
} ());

//动画特效数组
$(function() {
    var loaders = [{
        width: 100,
        height: 100,
        stepsPerFrame: 1,
        trailLength: 1,
        pointDistance: .02,
        fps: 100,
        fillColor: '#000000',
        step: function(point, index) {
            this._.beginPath();
            this._.moveTo(point.x, point.y);
            this._.arc(point.x, point.y, index * 4, 0, Math.PI * 2, false);
            this._.closePath();
            this._.fill();
        },
        path: [['arc', 50, 50, 15, 0, 360]]
    }];

    //动画播放
    var d, a, container = document.getElementById('in');
    for (var i = -1,
             l = loaders.length; ++i < l;) {
        d = document.createElement('div');
        d.className = 'l';
        a = new Sonic(loaders[i]);
        d.appendChild(a.canvas);
        container.appendChild(d);
        a.canvas.style.marginTop = (100 - a.fullHeight) / 2 + 'px';
        a.canvas.style.marginLeft = (100 - a.fullWidth) / 2 + 'px';
        a.play();
    }
});

var indexclass = Object.create(indexClass); //首页类
var productshow = Object.create(productShowClass); //产品展示类
var classlogin = Object.create(classLoginClass); //登陆类
var registclass = Object.create(registClass); //注册类
var admingetprodata = Object.create(adminGetProDataClass); //管理员获取产品数据类
var searchclass = Object.create(SearchClass); //客户搜索类
var messageboards = (messageBoardsClass); //留言板类
var userproduct = Object.create(userProductClass); //用户商品操作类
var serviceconnection = Object.create(serviceConnectionClass); //服务器交互类
var classverifiction = Object.create(classVerifictionClass); //验证类
var phonedealwith = Object.create(phoneDealWithClass); //手机事件类
var classownerinfo = Object.create(OwnerInfoClass); //企业信息类
var manageorder = Object.create(ManageOrderClass); //订单类
var mydatabase = Object.create(operatingDatabaseClass); //数据库类
var myenvetclass = Object.create(myEnvetClass); //事件类
