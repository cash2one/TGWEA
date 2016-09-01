var index = 1;
var timeout;
var loadingPage = 1;
var isLoding = false;
var i = 5;
var isComShopping = false;
var isAlertShow = false;
var isNoLoading = false;
var saveSearchKey = "";
var searchUserKey = 1;
var orderSearchKey = 1;
var myScroll, pullDownEl, pullDownOffset, pullUpEl;
var userName = "";
if (localStorage.userName !== undefined) {
	userName = (localStorage.userName).replace(/\"/g, "")
}
var poppage = "";
var pushpage = "";
var httpUrl = "http://" + window.location.host + "/";
var errImg = httpUrl + "images/nopic.jpg";
var productIndex;
var IsToProductInfo = false;
var defaultuImg = "images/nopic.jpg";
var proImgUrl = httpUrl;
var userUrlHead = httpUrl + "/cust/";
var userLogin = "mLogin.action";
var userGetProductList = "mListProducts.action";
var userGetProductInfo = "mGetProductInfo.action";
var userGetProCats = "mListProdCats.action";
var userGetSuperPro = "mGetProductsList.action";
var userWaitingOrderList = "mUnauditedOrders.action";
var userGetOrderList = "mListOrders.action";
var userGetGuestBooks = "mListGuestBooks.action";
var userAddGuestBook = "mAddGuestBook.action";
var userAddOrder = "mAddOrigOrder.action";
var userGetCust = "mGetCust.action";
var userUpdateCust = "mUpdateCust.action";
var userUpdatePwd = "mUpdateCustPwd.action";
var userReg = "mRegCust.action";
var userExistCustname = "mExistCustname.action";
var userGetAliasNTags = "mGetCustPushMessageAliasNTags.action";
var adminUrlHead = httpUrl + "owner/";
var adminLogin = "mLogin.action";
var adminInfo = "mGetOwnerData.action";
var adminGetOrderInfo = "mGetOrderInfo.action";
var adminGetOrderList = "mListOrders.action";
var adminUpdatePwd = "mUpdateOwnerAdminPwd.action";
var adminUpdateStockBalance = "mUpdateProdDispStockBalance.action";
var adminUpadtePrice = "mUpdateProdPrice.action";
var adminUserList = "mListCusts.action";
var getIsLogin = "mGetLoginStatus.action";
var getOwnerInfo = "mGetOwnerInfo.action";
var getBannerImg = "mGetOwnerBanners.action";
var loginOut = "mLogout.action";
var getSetting = "mGetOwnerSettingForceToLocal.action";
document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
	phonedealwith.isPhoneInternal = true;
	if (classverifiction.isMobile()) {
		document.addEventListener("offline", phonedealwith.onOffLineInternal, false);
		document.addEventListener("online", phonedealwith.onOnLineInternal, false);
		document.addEventListener("backbutton", phonedealwith.onBackKeyDown, false)
	}
}
$(document).on('pageinit', '#index', function() {
	$("#indexMenuId").hide();
	$(".indexMenuIconBtn").css("bottom", "0px");
	$(".menu").hide();
	$("#index .all-tittle").show();
	myenvetclass.indexMenuEvent();
	if (classverifiction.isMobile()) {
		indexclass.initPhoneBtn()
	}
	setTimeout(function() {
		indexclass.indexDataInit()
	}, 500);
	document.getElementById('index').addEventListener('DOMContentLoaded', loaded('wrapper', 'indexPullDown', null, indexclass.indexRefresh, null, 'clickBlock', 46), false)
});
$(document).on("pagebeforehide", "#index", function() {
	indexclass.isIndex = false;
	$(".menu").show();
	$("#indexViewHide").hide();
	var indexMenuIdObj = $("#indexMenuId");
	indexMenuIdObj.hide();
	indexMenuIdObj.attr("data-isInit", "false");
	$(".indexMenuIconBtn").css("bottom", "0px");
	$("#indexMenuImg").attr("src", "img/indexview/ttop.png");
	poppage = "#index";
	indexclass.isIndexMenuOpen = false
});
$(document).on('pagebeforeshow', '#index', function() {
	if (classlogin.isLoginToIndex === false) {
		$("#indexViewHide").hide()
	}
	classlogin.isLoginToIndex = false
});
$(document).on("pageshow", "#index", function() {
	indexclass.isIndex = true
});
$(document).on('pageinit', '#product', function() {
	ios7navInit();
	myenvetclass.proListShow();
	myenvetclass.proSearchShow()
});
$(document).on('pagebeforeshow', '#product', function() {
	$("#container1").show();
	setTimeout(function() {
		productshow.prodcutInit()
	}, 500)
});
$(document).on("pagebeforehide", "#product", function() {
	myenvetclass.ScrollEnvetRelease();
	$(".productcontent").html("");
	$(".noMore").hide();
	menuClose()
});
$(document).on("pageshow", "#product", function() {
	myenvetclass.method = productshow.loadData;
	setTimeout(function() {
		myenvetclass.myScrollEnvet([])
	}, 500)
});
$(document).on('pageinit', '#proSearch', function() {
	ios7navInit();
	$("#container1").hide();
	productshow.proMenuIconLayout()
});
$(document).on('pagebeforeshow', '#proSearch', function() {});
$(document).on("pagebeforehide", "#proSearch", function() {
	menuClose()
});
$(document).on("pageshow", "#proSearch", function() {
	$(".proCateSearch").attr("href", "javascript:void(0)")
});
$(document).on('pageinit', '#allListProShow', function() {
	ios7navInit();
	myenvetclass.proSearchShow()
});
$(document).on('pagebeforeshow', '#allListProShow', function() {
	setTimeout(function() {
		productshow.allProShowStyleTwo()
	}, 500);
	$("#container1").show()
});
$(document).on("pagebeforehide", "#allListProShow", function() {
	menuClose();
	$(".allProList ul").html("");
	$(".proListMore").hide();
	myenvetclass.ScrollEnvetRelease()
});
$(document).on("pageshow", "#allListProShow", function() {
	myenvetclass.method = productshow.allProShowStyleTwo;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#page2-1', function() {
	ios7navInit()
});
$(document).on('pagebeforeshow', '#page2-1', function() {
	if (saveSearchKey !== "") {
		searchclass.searchKey = saveSearchKey;
		saveSearchKey = ""
	}
	if (getUrlParm("prodName") !== "" || getUrlParm("prodCatId") !== "") {
		setTimeout(function() {
			searchclass.userSearchPro(getUrlParm("prodName"), getUrlParm("prodCatId"))
		}, 500)
	} else {}
});
$(document).on("pagebeforehide", "#page2-1", function() {
	myenvetclass.ScrollEnvetRelease();
	$(".fproMore").hide();
	menuClose()
});
$(document).on("pageshow", "#page2-1", function() {
	myenvetclass.method = searchclass.userSearchPro;
	myenvetclass.args = [searchclass.searchKey,searchclass.searchKey];
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#page2-2', function() {
	ios7navInit();
	var detailedTitle = $(".detailed-tittle h5");
	$("#send").hide();
	$(".quantity").hide();
	$("#goToDetailed").hide();
	$("#goToTaoBao").hide();
	if (getUrlParm("prodNum") !== "") {
		setTimeout(function() {
			userproduct.getDetailed(getUrlParm("prodNum"))
		}, 500)
	}
	myenvetclass.proDetailClickEvent();
	myenvetclass.addShopping("tb-stockminus", "tb-stockadd")
});
$(document).on("pagebeforehide", "#page2-2", function() {
	$("#addNum").val("0");
	$(".menu").show();
	menuClose();
	$(".ampImgLayer").hide();
	$(".ampImgBg").html("");
	$(".closeAmpImg").hide();
	$(".myAlertView").hide()
});
$(document).on("pagebeforeshow", "#page2-2", function() {
	$(".menu").hide()
});
$(document).on("pageshow", "#page2-2", function() {});
$(document).on('pageinit', '#message', function() {
	ios7navInit();
	myenvetclass.addMessage()
});
$(document).on('pagebeforeshow', '#message', function() {
	$("#container1").show();
	setTimeout(function() {
		messageboards.getMessage()
	}, 500)
});
$(document).on("pagebeforehide", "#message", function() {
	$(".allMessageList").html("");
	$(".messageView #messageContent").html("");
	myenvetclass.ScrollEnvetRelease();
	$(".noMessage").hide();
	menuClose();
	closeAlert('#message');
	$(".myAlertView").hide()
});
$(document).on("pageshow", "#message", function() {
	myenvetclass.method = messageboards.getMessage;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#userlogin', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.userRegisterClickEnvet();
	myenvetclass.userLoginClickEnvet()
});
$(document).on('pagebeforeshow', '#userlogin', function() {
	if (classlogin.isUserOrAdminBack === true && classlogin.isRegister === false) {
		$("#userLoginHide").show();
		$.mobile.back();
		classlogin.isUserOrAdminBack = false
	}
});
$(document).on("pagebeforehide", "#userlogin", function() {
	menuClose();
	$("#userpassword").val("");
	$(".allMessage .alertViewBg").hide();
	$(".allMessage .alertViewBg2").hide();
	$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage','','')");
	$(".allMessage .alertMessage").html("提&nbsp;&nbsp;&nbsp;&nbsp;示");
	$("#userLoginHide").hide();
	if (classlogin.userLoginState === false) {
		classlogin.isUserOrAdminBack = false
	}
	if (classlogin.isRegister === true) {
		classlogin.isRegister = false
	}
});
$(document).on("pageshow", "#userlogin", function() {});
$(document).on('pageinit', '#register', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.sendRegisterInfo()
});
$(document).on('pagebeforeshow', '#register', function() {});
$(document).on("pagebeforehide", "#register", function() {
	menuClose();
	$("#raccount").val("");
	$("#rpassword").val("");
	$("#rpasswordok").val("");
	$("#rname").val("");
	$("#rcompanyName").val("");
	closeAlert('.allMessage');
	$(".myAlertView").hide()
});
$(document).on("pageshow", "#register", function() {});
$(document).on('pageinit', '#personal', function() {
	$("#container1").hide();
	ios7navInit();
	myenvetclass.personalItemEvent()
});
$(document).on("pagebeforeshow", "#personal", function() {});
$(document).on("pagebeforehide", "#personal", function() {
	menuClose();
	closeAlert('#personal')
});
$(document).on("pageshow", "#personal", function() {
	registclass.userGetInfo();
	var loca = location.hash.split("#", 2)[1]
});
$(document).on('pageinit', '#userModifyInfo', function() {
	ios7navInit();
	registclass.userGetInfo();
	$("#container1").hide();
	myenvetclass.userUpdateInfo()
});
$(document).on('pagebeforeshow', '#userModifyInfo', function() {});
$(document).on("pagebeforehide", "#userModifyInfo", function() {
	menuClose();
	closeAlert('.allMessage');
	$(".myAlertView").hide()
});
$(document).on("pageshow", "#userModifyInfo", function() {});
$(document).on('pageinit', '#userModifyPass', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.userUpdatePass()
});
$(document).on('pagebeforeshow', '#userModifyPass', function() {});
$(document).on("pagebeforehide", "#userModifyPass", function() {
	menuClose();
	closeAlert('.allMessage');
	$(".myAlertView").hide()
});
$(document).on("pageshow", "#userModifyPass", function() {});
$(document).on('pageinit', '#about', function() {
	ios7navInit();
	var uiBar = $(".ui-bar-y");
	var bary = 48;
	$("#container1").show();
	setTimeout(function() {
		classownerinfo.getContactInfo()
	}, 500);
	if (uiBar.height() > 0) {
		bary = uiBar.height()
	}
	myenvetclass.aboutAndContact();
	$("#contenttext").height(document.body.clientHeight - ($(".ui-bar-x").height() + bary + 52))
});
$(document).on("pagebeforehide", "#about", function() {
	menuClose()
});
$(document).on("pagebeforeshow", "#about", function() {});
$(document).on("pageshow", "#about", function() {});
$(document).on('pageinit', '#contact', function() {
	ios7navInit();
	$("#contenttexts").height(300);
	setTimeout(function() {
		classownerinfo.getContactInfo()
	}, 500);
	myenvetclass.aboutAndContact()
});
$(document).on("pagebeforehide", "#contact", function() {
	menuClose()
});
$(document).on("pageshow", "#contact", function() {
	$("#container1").hide();
	setTimeout(function() {
		mapInit(classownerinfo.longi, classownerinfo.lati)
	}, 300)
});
$(document).on('pageinit', '#page5', function() {
	ios7navInit();
	$("#orderSendBtn").hide();
	myenvetclass.sendShoppingOrder()
});
$(document).on("pagebeforehide", "#page5", function() {
	$(".shoppingBack").attr("href", "#personal");
	menuClose();
	closeAlert('.allMessage');
	$(".promptText").hide();
	$(".shoppingBg").html("");
	$(".myAlertView").hide();
	closeAlert('#page5')
});
$(document).on("pageshow", "#page5", function() {});
$(document).on('pagebeforeshow', '#page5', function() {
	$("#container1").show();
	setTimeout(function() {
		userproduct.getShoppingInfo()
	}, 500)
});
$(document).on('pageinit', '#userWaitingAudit', function() {
	ios7navInit()
});
$(document).on('pagebeforeshow', '#userWaitingAudit', function() {
	$("#container1").show();
	setTimeout(function() {
		manageorder.userShowWaitingList()
	}, 500)
});
$(document).on("pagebeforehide", "#userWaitingAudit", function() {
	myenvetclass.ScrollEnvetRelease();
	$(".userWaitingOrder").html("");
	$(".noMyWaitingOrder").hide();
	$("#userWaitingAudit .all-tittle").hide();
	manageorder.orderNum = 0;
	menuClose()
});
$(document).on("pageshow", "#userWaitingAudit", function() {
	myenvetclass.method = manageorder.userShowWaitingList;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#myorder', function() {
	ios7navInit()
});
$(document).on('pagebeforeshow', '#myorder', function() {
	$(".noMyOrder").hide();
	$("#container1").show();
	setTimeout(function() {
		manageorder.userShowOrderList()
	}, 500)
});
$(document).on("pagebeforehide", "#myorder", function() {
	myenvetclass.ScrollEnvetRelease();
	manageorder.orderNum = 0;
	$(".userOrderList").html("");
	$("#myorder .all-tittle").hide();
	menuClose()
});
$(document).on("pageshow", "#myorder", function() {
	myenvetclass.method = manageorder.userShowOrderList;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#superPro', function() {
	ios7navInit()
});
$(document).on('pagebeforeshow', '#superPro', function() {
	setTimeout(function() {
		productshow.superProList()
	}, 500);
	$("#container1").show()
});
$(document).on("pagebeforehide", "#superPro", function() {
	$(".waterfall-ri").html("");
	$(".waterfall-le").html("");
	$(".superProMore").hide();
	menuClose();
	myenvetclass.ScrollEnvetRelease()
});
$(document).on("pageshow", "#superPro", function() {
	myenvetclass.method = productshow.superProList;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#pageadminlogin', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.adminLoginClickEvent()
});
$(document).on('pagebeforeshow', '#pageadminlogin', function() {
	if (classlogin.isUserOrAdminBack === true) {
		$("#adminLoginHide").show();
		$.mobile.back();
		classlogin.isUserOrAdminBack = false
	}
});
$(document).on("pagebeforehide", "#pageadminlogin", function() {
	menuClose();
	$("#adminpassword").val("");
	$("#adminLoginHide").hide();
	if (classlogin.adminLoginState === false) {
		classlogin.isUserOrAdminBack = false
	}
});
$(document).on("pageshow", "#pageadminlogin", function() {});
$(document).on('pageinit', '#adminMenu', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.adminMenuItemEvent()
});
$(document).on('pagebeforeshow', '#pageadminlogin', function() {});
$(document).on("pagebeforehide", "#adminMenu", function() {
	menuClose();
	closeAlert('#adminMenu')
});
$(document).on("pageshow", "#adminMenu", function() {
	registclass.adminGetInfo()
});
$(document).on('pageinit', '#adminselectorder', function() {
	ios7navInit();
	myenvetclass.adminSearchOrderKey();
	myenvetclass.adminOpenSearchKey();
	myenvetclass.adminSearchOrderBtn()
});
$(document).on('pagebeforeshow', '#adminselectorder', function() {
	$("#container1").show();
	setTimeout(function() {
		manageorder.adminShowOrderList()
	}, 500)
});
$(document).on("pagebeforehide", "#adminselectorder", function() {
	myenvetclass.ScrollEnvetRelease();
	manageorder.userNum = "";
	$(".noOrder").hide();
	$(".aorderList").html("");
	$("#aSOrderBack").attr('href', '#adminMenu');
	menuClose()
});
$(document).on("pageshow", "#adminselectorder", function() {
	myenvetclass.method = manageorder.adminShowOrderList;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#orderinfo', function() {
	ios7navInit();
	$("#container1").hide()
});
$(document).on("pagebeforehide", "#orderinfo", function() {
	menuClose()
});
$(document).on("pageshow", "#orderinfo", function() {});
$(document).on('pageinit', '#adminProManage', function() {
	ios7navInit();
	myenvetclass.adminSearchBtnClickEvent()
});
$(document).on('pagebeforeshow', '#adminProManage', function() {
	$("#container1").show();
	setTimeout(function() {
		admingetprodata.adminGetProList()
	}, 500)
});
$(document).on("pagebeforehide", "#adminProManage", function() {
	myenvetclass.ScrollEnvetRelease();
	admingetprodata.pageNum = 0;
	admingetprodata.aNameKey = "";
	$(".proShowList ul").html("");
	$(".anoMorePro").hide();
	menuClose()
});
$(document).on("pageshow", "#adminProManage", function() {
	myenvetclass.method = admingetprodata.adminGetProList;
	myenvetclass.args = [admingetprodata.aNameKey];
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
$(document).on('pageinit', '#adminModifyPass', function() {
	ios7navInit();
	$("#container1").hide();
	myenvetclass.updateAdminPass()
});
$(document).on('pagebeforeshow', '#adminModifyPass', function() {});
$(document).on("pagebeforehide", "#adminModifyPass", function() {
	menuClose();
	closeAlert('.allMessage');
	$(".myAlertView").hide()
});
$(document).on("pageshow", "#adminModifyPass", function() {});
$(document).on('pageinit', '#clientsearch', function() {
	ios7navInit();
	myenvetclass.adminSearch()
});
$(document).on('pagebeforeshow', '#clientsearch', function() {
	$("#container1").show();
	setTimeout(function() {
		searchclass.adminSearchUserInfo()
	}, 500)
});
$(document).on("pagebeforehide", "#clientsearch", function() {
	searchclass.searchName = "";
	searchclass.searchArea = "";
	searchclass.searchPhone = "";
	$(".center-order").html("");
	$(".searUserMore").hide();
	$("#custSearch").val("");
	myenvetclass.ScrollEnvetRelease();
	menuClose()
});
$(document).on("pageshow", "#clientsearch", function() {
	myenvetclass.method = searchclass.adminSearchUserInfo;
	setTimeout(function() {
		myenvetclass.myScrollEnvet()
	}, 500)
});
var indexClass = {
	isIndex: false,
	isIndexMenuOpen: false,
	indexSwiper: null,
	initPhoneBtn: function() {
		var param = {};
		var eurl = adminUrlHead + getOwnerInfo;
		var fun = function(data) {
				if (data.status === "S") {
					myenvetclass.phonenum = "tel://" + data.respData.phoneNum.replace(/\s/g, "")
				} else {}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						$(".indexSwiper .swiper-container").append(myimgcontent)
					}
					for (var j = 0, len = array_banner.length; j < len; j++) {
						standbyUrl = imgLink(array_banner[j].imgUrl);
						if (array_banner[j].linkType === 0) {
							myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='seldetail'  data-iswindow='true' data-aliurl='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'></a> </div>"
						} else {
							myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'></a> </div>"
						}
					}
					if (array_banner.length > 0) {
						var myimgcontent = "<div class='swiper-wrapper' id='silderclass'>" + myimg + "</div><div class='ipagination'></div><div class='repair'>.</div>";
						$(".indexSwiper .swiper-container").append(myimgcontent)
					}
					indexclass.indexSwiper = new Swiper('.indexSwiper .swiper-container', {
						pagination: '.ipagination',
						loop: true,
						grabCursor: true,
						paginationClickable: true
					});
					$("#container1").hide()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)'><img src='" + errImg + "' onerror=this.src='" + errImg + "' style='height:200px;'></a> ")
					}
					for (var j = 0, len = array_banner.length; j < len; j++) {
						standbyUrl = imgLink(array_banner[j].imgUrl);
						if (array_banner[j].linkType === 0) {
							indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)' class='seldetail'  data-iswindow='true' data-aliurl='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:200px;'></a>")
						} else {
							indexclass.indexSwiper.appendSlide("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_banner[j].linkContent + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:200px;'></a> ")
						}
					}
					myenvetclass.selectDetailed()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						newProLength = 2
					} else if (array_newproduct.length % 2 > 0) {
						newProLength = array_newproduct.length - 1
					} else {
						newProLength = array_newproduct.length
					}
					for (var i = 0, len = newProLength; i < len; i += 2) {
						if (array_newproduct.length === 1) {
							lastPro = 1;
							nextPro = 1
						} else {
							lastPro = i;
							nextPro = i + 1
						}
						standbyUrl = imgLink(array_newproduct[lastPro].firstProdImg);
						standbyUrl1 = imgLink(array_newproduct[nextPro].firstProdImg);
						$(".newProDynamic").append("<div class='new-list'><div class='new-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_newproduct[lastPro].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "' ><p>" + array_newproduct[lastPro].prodName + "</p></a><ul><li><span></span><strong>¥" + array_newproduct[lastPro].stdPrice + "</strong></li></ul></div><div class='new-ri'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_newproduct[nextPro].prodNum + "'><img src='" + standbyUrl1 + "' onerror=this.src='" + errImg + "'><p>" + array_newproduct[nextPro].prodName + "</p></a><ul><li><span></span><strong>¥" + array_newproduct[nextPro].stdPrice + "</strong></li></ul></div></div>")
					}
					myenvetclass.selectDetailed();
					$("#newProId").show()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						proLength = 3
					} else if (array_product.length % 3 > 0) {
						proLength = array_product.length - array_product.length % 3
					} else {
						proLength = array_product.length
					}
					for (var i = 0, len = proLength; i < len; i += 3) {
						if (array_product.length === 1) {
							lastPro = 1;
							nextPro = 1;
							nextTwoPro = 1
						} else {
							lastPro = i;
							nextPro = i + 1;
							nextTwoPro = i + 2
						}
						standbyUrl = imgLink(array_product[lastPro].firstProdImg);
						standbyUrl1 = imgLink(array_product[nextPro].firstProdImg);
						standbyUrl2 = imgLink(array_product[nextTwoPro].firstProdImg);
						$(".allProShow").append("<div class='new-list'><div class='all-pro-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[lastPro].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'><p>" + array_product[lastPro].prodName + "</p></a><span> </span><strong>¥" + array_product[lastPro].stdPrice + "</strong></div><div class='all-pro-le'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[nextPro].prodNum + "'><img src='" + standbyUrl1 + "' onerror=this.src='" + errImg + "'><p>" + array_product[nextPro].prodName + "</p></a><span> </span><strong>¥" + array_product[nextPro].stdPrice + "</strong></div><div class='all-pro-ri'><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_product[nextTwoPro].prodNum + "'><img src='" + standbyUrl2 + "' onerror=this.src='" + errImg + "'><p>" + array_product[nextTwoPro].prodName + "</p></a><span> </span><strong>¥" + array_product[nextTwoPro].stdPrice + "</strong></div></div>")
					}
					myenvetclass.selectDetailed();
					$("#allProId").show();
					$("#moreProBtnId").show()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	indexDataInit: function() {
		indexclass.getIndexBanner();
		indexclass.getIndexNewProduct();
		indexclass.indexAllProBreviary()
	},
	indexRefresh: function() {
		indexclass.bannerRefresh();
		indexclass.getIndexNewProduct();
		indexclass.indexAllProBreviary()
	}
};
var productShowClass = {
	titleClassNameLeft: "proTitleNameLeft",
	priceClassNameRight: "proTitlePriceRight",
	prodcutInit: function() {
		this.getProduct()
	},
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
					var product_content = "";
					var array_product = data.respData.dataList;
					var standbyUrl = "";
					if (array_product.length == 0) {
						isNoLoading = true;
						$(".noMore").show();
						hideLoader();
						$("#container1").hide();
						return
					}
					for (var i = 0, len = array_product.length; i < len; i++) {
						standbyUrl = imgLink(array_product[i].firstProdImg);
						if (product_row === i) {
							product_rowindex = 1;
							if ((array_product.length - i) === 1) {
								product_style = 5
							} else if ((array_product.length - i) === 2) {
								product_style = 4;
								product_row += 2
							} else {
								product_style = Math.floor(Math.random() * 5);
								if (product_style === 0) {
									product_style = 1
								}
								switch (product_style) {
								case 1:
								case 2:
								case 3:
									product_row += 3;
									break;
								case 4:
									product_row += 2;
									break
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
								break
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
								break
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
								break
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
								break
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
							break
						}
					}
					$("#container1").hide();
					myenvetclass.selectDetailed();
					productshow.imageAndTextSize();
					if ($(".content").width() >= 768) {
						$(".proTitleNameLeft").css("font-size", "25px");
						$(".proTitleNameLeft").css("line-height", "25px");
						$(".proTitlePriceRight").css("font-size", "23px");
						$(".proTitlePriceRight").css("line-height", "23px");
						$(".proTitlePriceRight").css("font-size", "23px");
						$(".proTitlePriceRight").css("line-height", "23px")
					} else if ($(".content").width() < 768 && $(".content").width() >= 540) {
						$(".proTitleNameLeft").css("font-size", "18px");
						$(".proTitleNameLeft").css("line-height", "18px");
						$(".proTitlePriceRight").css("font-size", "16px");
						$(".proTitlePriceRight").css("line-height", "16px");
						$(".proTitlePriceRight").css("font-size", "16px");
						$(".proTitlePriceRight").css("line-height", "16px")
					} else {
						$(".proTitleNameLeft").css("font-size", "12px");
						$(".proTitleNameLeft").css("line-height", "12px");
						$(".proTitlePriceRight").css("font-size", "10px");
						$(".proTitlePriceRight").css("line-height", "10px");
						$(".proTitlePriceRight").css("font-size", "10px");
						$(".proTitlePriceRight").css("line-height", "10px")
					}
					if (array_product.length < 9) {
						$(".noMore").show();
						isNoLoading = true;
						hideLoader();
						return
					}
					loadingPage++;
					hideLoader();
					isLoding = false
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	imageAndTextCareate: function(linkCName, imgCName, viewCName, titleCName, priceCName, strProNum, strImgUrl, strProName, strProPrice, strProUnit, dire) {
		var Str = "";
		Str = "<div class='" + viewCName + "' align='" + dire + "'><div class='" + titleCName + "'>" + textLengthTrim(textLengthCut(strProName)) + "</div><div class='" + priceCName + "'>" + strProPrice + "元/" + strProUnit + "</div></div><div class='" + linkCName + "'><a href='javascript:void(0)' class='seldetail' data-myindex='" + strProNum + "'><img src='" + strImgUrl + "' onerror=this.src='" + errImg + "' class='" + imgCName + "'></a></div>"
		return Str
	},
	imageAndTextSize: function() {
		var product_contentwidth = $(".productcontent").width();
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
		$(".proshowview3,.proshowview4").width(product_contentwidth - 2);
		$(".proshowcontentimg10,.proshowcontentimg11,.proshowcontentimg12,.proshowcontentimg13").width((product_contentwidth - 6) * 0.5);
		$(".proshowcontentimg10,.proshowcontentimg11,.proshowcontentimg12,.proshowcontentimg13").height((product_contentwidth - 6) * 0.5);
		$(".proshowcotenttextview10,.proshowcotenttextview11,.proshowcotenttextview12,.proshowcotenttextview13").width((product_contentwidth - 2) * 0.5);
		$(".proshowcotenttextview10,.proshowcotenttextview11,.proshowcotenttextview12,.proshowcotenttextview13").height((product_contentwidth - 2) * 0.5);
		$(".proshowcotenttextview11,.proshowcotenttextview13").css("margin-left", ((product_contentwidth - 2) * 0.5))
	},
	loadData: function() {
		if (isNoLoading == false) {
			productshow.getProduct()
		}
	},
	producRefresh: function() {
		loadingPage = 1;
		productshow.getProduct("true")
	},
	proMenuIconLayout: function() {
		var param = {};
		var eurl = userUrlHead + userGetProCats;
		var fun = function(data) {
				if (data.status === "S") {
					var proDataArr = data.respData;
					productshow.proCateCount(proDataArr, "")
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	proCateCount: function(data, parentDate) {
		var isRepeat = false;
		for (var n = 0, len = data.length; n < len; n++) {
			if (data[n].childProdCatHiers.length > 0) {
				productshow.proCateCount(data[n].childProdCatHiers, data[n])
			} else {
				if (parentDate !== "") {
					if (isRepeat === false) {
						$(".proCateMenuContent").append("<li><a href='javascript:void(0)' class='myProMenu'><span class='tie'>></span>" + parentDate.prodCat.prodCatName + "</a><ul ishide='flase'></ul></li>");
						isRepeat = true
					}
					$(".alpha2 ul").last().append("<li><a href='javascript:void(0)' class='catItem' data-catId='" + data[n].prodCat.prodCatId + "' data-catName='" + data[n].prodCat.prodCatName + "'>" + data[n].prodCat.prodCatName + "</a></li>")
				}
			}
		}
		myenvetclass.proCatItemCilicEvent()
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
						return
					}
					for (var i = 0, len = arrProList.length; i < len; i++) {
						standbyUrl = imgLink(arrProList[i].firstProdImg);
						if (arrProList[i].featureName === null || arrProList[i].featureName === undefined) {
							xh = ""
						} else {
							xh = arrProList[i].featureName
						}
						$(".allProList ul").append("<a href='#page2-2' onClick=setpoppage(this,'#allListProShow') data-myindex='" + arrProList[i].prodNum + "'><li><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65'><p>" + arrProList[i].prodName + "</p> <p class='price45'>产品型号：" + xh + "</p><b class='b-green'>¥" + arrProList[i].stdPrice + "</b></div></li></a>")
					}
					$("#container1").hide()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (arrProList.length < 9) {
					$(".proListMore").show();
					isNoLoading = true;
					hideLoader();
					return
				}
				loadingPage++;
				hideLoader();
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	allProListLoadMore: function() {
		if (isNoLoading === false && isLoding === false) {
			productshow.allProShowStyleTwo()
		}
	},
	allProducRefresh: function() {
		loadingPage = 1;
		productshow.allProShowStyleTwo("true")
	},
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
						return
					}
					for (var i = 0, len = arrProList.length; i < len; i++) {
						standbyLeftUrl = imgLink(arrProList[i].firstProdImg);
						$(".waterfall-le").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrProList[i].prodNum + "'> <img src=" + standbyLeftUrl + " onerror=this.src='" + errImg + "'><p class='fon-2'>" + arrProList[i].prodName + "</p></a><div class='waterfall-price'><strong style='color:#34a277; font-size:16px;'>¥" + arrProList[i].stdPrice + "</strong></div></a></li>");
						if (++i < len) {
							standbyRightUrl = imgLink(arrProList[i].firstProdImg)
						}
						if (standbyRightUrl !== "") {
							$(".waterfall-ri").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrProList[i].prodNum + "'><img src=" + standbyRightUrl + " onerror=this.src='" + errImg + "'><p class='fon-2'>" + arrProList[i].prodName + "</p></a><div class='waterfall-price'><strong style='color:#34a277; font-size:16px;'>¥" + arrProList[i].stdPrice + "</strong></div></a></li>");
							standbyRightUrl = ""
						}
					}
					myenvetclass.selectDetailed();
					$("#container1").hide()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (arrProList.length < 9) {
					$(".superProMore").show();
					isNoLoading = true;
					hideLoader();
					return
				}
				loadingPage++;
				hideLoader();
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	}
};
var operatingDatabaseClass = {
	crateTable: function() {
		if (localStorage.getItem(userName) == undefined) {
			var jsondata = [];
			localStorage.setItem(userName, JSON.stringify(jsondata));
			return
		} else {
			return
		}
	},
	insertData: function(id, number) {
		var jsondata = JSON.parse(localStorage.getItem(userName));
		var datacount = jsondata.length;
		for (var i = 0, len = jsondata.length; i < len; i++) {
			if (jsondata[i].myid == id) {
				myAlert(".myAlertView", ".myAlertMessage", "这件商品已存在购物车中!");
				return
			}
		}
		jsondata.push({
			myid: id,
			mynumber: number
		});
		localStorage.setItem(userName, JSON.stringify(jsondata));
		if (jsondata.length > datacount) {
			myAlert(".myAlertView", ".myAlertMessage", "添加成功!")
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "添加失败!")
		}
	},
	selectData: function() {
		var jsondata = JSON.parse(localStorage.getItem(userName));
		return jsondata
	},
	updateData: function(id, number) {
		var jsondata = JSON.parse(localStorage.getItem(userName));
		for (var i = 0, len = jsondata.length; i < len; i++) {
			if (jsondata[i].myid === id) {
				if (jsondata[i].mynumber != number) {
					jsondata[i].mynumber = number;
					localStorage.setItem(userName, JSON.stringify(jsondata));
					return
				}
				return
			}
		}
	},
	deleteItemData: function(id, itemId) {
		var jsondata = JSON.parse(localStorage.getItem(userName));
		for (var i = 0, len = jsondata.length; i < len; i++) {
			if (jsondata[i].myid === id) {
				jsondata.splice(i, 1);
				localStorage.setItem(userName, JSON.stringify(jsondata));
				if (jsondata.length === 0) {
					$(".shoppingBg").html("");
					$("#orderSendBtn").hide();
					$(".promptText").show()
				}
				if (itemId !== undefined && itemId !== "") {
					$(itemId).remove();
					$("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',userproduct.sendOrder())");
					$("#page5 .alertMessage").html("您确定提交订单吗？")
				}
				return
			}
		}
	},
	deleteallData: function() {
		$(".shoppingBg").html("");
		$("#orderSendBtn").hide();
		$(".promptText").show();
		localStorage.removeItem(userName);
		mydatabase.crateTable()
	}
};
var classLoginClass = {
	userLoginState: false,
	adminLoginState: false,
	reLogin: true,
	isLoginToIndex: false,
	isUserOrAdminBack: false,
	isRegister: false,
	isUserLogin: function() {
		var param = {};
		var eurl = userUrlHead + getIsLogin;
		var fun = function(data) {
				if (data.status === "S") {
					classlogin.userLoginState = true
				} else {
					classlogin.isUserOrAdminBack = false;
					classlogin.userLoginState = false
				}
			};
		serviceconnection.postRequests("post", param, eurl, fun)
	},
	getUserLoginState: function(page1, page2) {
		pushpage = page1;
		$("#loginback").attr("href", page2);
		classlogin.isUserLogin();
		if (classlogin.userLoginState === true) {
			if (page2 === "#page5" || page2 === "#userWaitingAudit" || page2 === "#myorder" || page2 === "#userModifyInfo" || page2 === "#userModifyPass" || page2 === "#adminModifyPass" || page2 === "#clientsearch" || page2 === "#superPro") {
				$("#userBack").attr("href", "#index")
			} else {
				$("#userBack").attr("href", page2)
			}
			window.location.href = pushpage
		} else {
			window.location.href = "#userlogin"
		}
	},
	isUserLoginAddOrder: function(page1, page2, my) {
		pushpage = page1;
		var addNum = $("#addNum");
		$("#loginback").attr("href", page2);
		classlogin.isUserLogin();
		if (classlogin.userLoginState === true) {
			if (classverifiction.isInt(addNum.val()) && parseInt(addNum.val()) > 0) {
				mydatabase.insertData($(my).attr("data-myindex"), parseInt(addNum.val()));
				addNum.val("0")
			} else {
				myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!")
			}
		} else {
			window.location.href = "#userlogin"
		}
	},
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
						IsToProductInfo = false
					}
					phonedealwith.testSetJushTagNalias();
					if (pushpage === "") {
						pushpage = "#personal"
					}
					classlogin.reLogin = false;
					classlogin.isUserOrAdminBack = true;
					classlogin.userLoginState = true;
					classlogin.adminLoginState = false;
					$("#adminLoginHide").hide();
					window.location.href = pushpage
				} else {
					myAlert(".myAlertView", ".myAlertMessage", data.message)
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	userLoginOut: function() {
		var param = {};
		var eurl = userUrlHead + loginOut;
		var fun = function(data) {
				if (data.status === "S") {
					classlogin.userLoginState = false;
					window.history.go(-(window.history.length - 2));
					$(".shoppingBg").html("");
					$("#orderSendBtn").hide();
					$(".promptText").hide();
					$(".personal-cen").html("<p><span>用 户 名：</span>未登录</p><p><span>企业名称：</span>未登录</p>")
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	isUserLegality: function() {
		if (classverifiction.isLetterAndNum($("#oldPass").val()) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "旧密码输入错误，只能由数字或字母组成!");
			return
		} else if (classverifiction.isLetterAndNum($("#newPass").val()) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "新密码输入错误，只能由数字或字母组成!");
			return
		} else if ($("#newPass").val() !== $("#confirmNewPass").val()) {
			myAlert(".myAlertView", ".myAlertMessage", "新密码两次输入不一致!");
			return
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
						openAlert('.allMessage')
					} else {
						if (data.message === "您还没有登录") {
							$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
							$(".allMessage .alertMessage").html(data.message);
							openAlert('.allMessage');
							$("#newPass,#confirmNewPass,#oldPass").val("")
						} else {
							myAlert(".myAlertView", ".myAlertMessage", data.message)
						}
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		}
	},
	isAdminLogin: function() {
		var param = {};
		var eurl = adminUrlHead + getIsLogin;
		var fun = function(data) {
				if (data.status === "S") {
					classlogin.adminLoginState = true
				} else {
					classlogin.isUserOrAdminBack = false;
					classlogin.adminLoginState = false
				}
			};
		serviceconnection.postRequests("post", param, eurl, fun)
	},
	getAdminLoginState: function(push, pop) {
		classlogin.isAdminLogin();
		pushpage = push;
		$("#aloginBack").attr("href", pop);
		if (pop === "#adminMenu" || pop === "#adminselectorder" || pop === "#adminselectorder" || pop === "#orderinfo" || pop === "#adminProManage" || pop === "#adminModifyPass" || pop === "#clientsearch") {
			$("#adminBack").attr("href", "#index")
		} else {
			$("#adminBack").attr("href", pop)
		}
		if (classlogin.adminLoginState === true) {
			window.location.href = pushpage
		} else {
			window.location.href = "#pageadminlogin"
		}
	},
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
					$("#userLoginHide").hide()
				} else {
					myAlert(".myAlertView", ".myAlertMessage", data.message)
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	adminLoginOut: function() {
		var param = {};
		var eurl = adminUrlHead + loginOut;
		var fun = function(data) {
				if (data.status === "S") {
					$(".admin-cen").html("<p><span>厂 家：</span>未登录</p><p><span>厂家账号：</span>未登录</p>");
					classlogin.adminLoginState = false;
					window.history.go(-(window.history.length - 2))
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	isAdminLegality: function() {
		if (classverifiction.isLetterAndNum($("#adminOldPass").val()) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "旧密码输入错误，只能由数字或字母组成!");
			return
		} else if (classverifiction.isLetterAndNum($("#adminNewPass").val()) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "新密码输入错误，只能由数字或字母组成!");
			return
		} else if ($("#adminNewPass").val() !== $("#confirmAdminNewPass").val()) {
			myAlert(".myAlertView", ".myAlertMessage", "新密码两次输入不一致!");
			return
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
						openAlert('.allMessage')
					} else {
						if (data.message === "您还没有登录") {
							$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
							$(".allMessage .alertMessage").html(data.message);
							openAlert('.allMessage');
							$("#adminNewPass,#confirmAdminNewPass,#adminOldPass").val("")
						} else {
							myAlert(".myAlertView", ".myAlertMessage", data.message)
						}
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		}
	},
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
					window.location.href = "#pageadminlogin"
				}, 60);
				window.history.go(-(window.history.length - 2))
			} else {
				setTimeout(function() {
					window.location.href = "#userlogin"
				}, 60);
				window.history.go(-(window.history.length - 2))
			}
		}
	}
};
var registClass = {
	userRegist: function(acc, pass, passConfirm, name, companyName) {
		if (classverifiction.iphonever(acc) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "手机号码输入错误!");
			return
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
								return
							} else if (pass !== passConfirm) {
								myAlert(".myAlertView", ".myAlertMessage", "两次用户密码输入不正确!");
								return
							} else if (name === "") {
								myAlert(".myAlertView", ".myAlertMessage", "姓名不能为空!");
								return
							} else if (companyName === "") {
								myAlert(".myAlertView", ".myAlertMessage", "商家名/公司名不能为空!");
								return
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
												openAlert('.allMessage')
											}, 100)
										} else {
											$(".allMessage .alertMessage").html(data.message);
											openAlert('.allMessage')
										}
									};
								serviceconnection.postRequest("post", param, eurl, fun)
							}
						} else {
							myAlert(".myAlertView", ".myAlertMessage", "该手机号码已存在!")
						}
					} else {
						myAlert(".myAlertView", ".myAlertMessage", data.message)
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		}
	},
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
					$(".personal-cen").html("<p><span>用 户 名：</span>" + data.respData.custName + "</p><p><span>企业名称：</span>" + data.respData.companyName + "</p>")
				} else {
					$(".personal-cen").html("<p><span>用 户 名：</span>未登录</p><p><span>企业名称：</span>未登录</p>");
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	adminGetInfo: function() {
		var param = {};
		var eurl = adminUrlHead + adminInfo;
		var fun = function(data) {
				if (data.status === "S") {
					$(".admin-cen").html("<p><span>厂 家：</span>" + data.respData.companyName + "</p><p><span>厂家账号：</span>" + data.respData.ownerNum + "</p>")
				} else {
					$(".admin-cen").html("<p><span>厂 家：</span>未登录</p><p><span>厂家账号：</span>未登录</p>");
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	userUpdateInfo: function(company, contact, phone, address) {
		if (company === "") {
			myAlert(".myAlertView", ".myAlertMessage", "公司名不能为空!")
		} else if (contact === "") {
			myAlert(".myAlertView", ".myAlertMessage", "联系人不能为空!")
		} else if (phone === "") {
			myAlert(".myAlertView", ".myAlertMessage", "手机号码不能为空!")
		} else if (classverifiction.iphonever(phone) === false) {
			myAlert(".myAlertView", ".myAlertMessage", "手机号码格式不正确!")
		} else {
			var param = {
				"customer.companyName": company,
				"customer.contactPerson": contact,
				"customer.phoneNum": phone,
				"customer.address": address
			};
			var eurl = userUrlHead + userUpdateCust;
			var fun = function(data) {
					if (data.status === "S") {
						$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',$.mobile.back(),'')");
						$(".allMessage .alertMessage").html("修改成功!");
						openAlert('.allMessage')
					} else {
						$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
						$(".allMessage .alertMessage").html(data.message);
						openAlert('.allMessage')
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		}
	}
};
var adminGetProDataClass = {
	pageNum: 0,
	aNameKey: "",
	adminGetProList: function(name) {
		if (name === undefined) {
			name = ""
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
						return
					}
					for (var i = 0, len = arrData.length; i < len; i++) {
						standbyUrl = imgLink(arrData[i].firstProdImg);
						$(".proShowList ul").append("<li><div class='pro-manage-i'><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrData[i].prodNum + "'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></a> </div><div class='p65'><a href='javascript:void(0)' class='seldetail' data-myindex='" + arrData[i].prodNum + "'><p class='p-title'>" + arrData[i].prodName + "</p></a><p class='p-green' ><span id='editProPrice" + admingetprodata.pageNum + i + "'>¥" + arrData[i].stdPrice + "</span><img src='img/edit.png' priceValue=" + arrData[i].stdPrice + "   proPriceId='#editProPrice" + admingetprodata.pageNum + i + "' data-price='" + arrData[i].prodNum + "' class='adminUpdatePrice' ondragstart='return false'  style='width:44px; float:right;'></p> <p class='p-green' ><span id='editProStock" + admingetprodata.pageNum + i + "'>库存数量:" + arrData[i].dispStockBalance + "</span><img src='img/edit.png' stockValue=" + arrData[i].dispStockBalance + " proStrockId='#editProStock" + admingetprodata.pageNum + i + "' data-num='" + arrData[i].prodNum + "' class='adminUpdateProNum' ondragstart='return false'  style='width:44px; float:right;'></p><p class='p-date' >上架日期:" + arrData[i].createDate + "</p></div></li>")
					}
					myenvetclass.adminUpdateNumAdnPrice();
					myenvetclass.selectDetailed();
					admingetprodata.pageNum++;
					$("#container1").hide()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (arrData.length < 9) {
					isNoLoading = true;
					$(".anoMorePro").show();
					hideLoader();
					return
				}
				hideLoader();
				loadingPage++;
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	editPro: function(type, num, key, my, event) {
		$("#proManage").val($(my).attr(key));
		if (type === "a") {
			$("#adminProManage .alertTitle").html("请输入价格");
			$(document).unbind("click");
			$(document).on("click", "#adminProManage .alertBtnConfirm", function() {
				confirmEnvent('#adminProManage', admingetprodata.updatePrice(num, $("#proManage").val(), $(my).attr("proPriceId"), my), '', "false")
			})
		} else if (type === "b") {
			$("#adminProManage .alertTitle").html("请输入数量");
			$(document).unbind("click");
			$(document).on("click", "#adminProManage .alertBtnConfirm", function() {
				confirmEnvent('#adminProManage', admingetprodata.updateNum(num, $("#proManage").val(), $(my).attr("proStrockId"), my), '', "false")
			})
		}
		openAlert('#adminProManage')
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
						$(my).attr("priceValue", value)
					} else {
						$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
						$(".allMessage .alertMessage").html(data.message);
						openAlert('.allMessage')
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "产品单价输入有误!")
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
						$(my).attr("stockValue", value)
					} else {
						$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
						$(".allMessage .alertMessage").html(data.message);
						openAlert('.allMessage')
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "请输入正确的产品数量!")
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
		admingetprodata.adminGetProList(name)
	}
};
var SearchClass = {
	isSuccess: false,
	searchKey: "",
	searchName: "",
	searchArea: "",
	searchPhone: "",
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
						$("#container1").hide();
						isLoding = true;
						hideLoader();
						return
					}
					for (var i = 0, len = data.respData.dataList.length; i < len; i++) {
						$(".center-order").append("<div class='search-list toUserOrder' data-orderKey='" + data.respData.dataList[i].custNum + "'><ul><li><span class='top-bg'>联系人: " + data.respData.dataList[i].contactPerson + "</span></li><li>公司: " + data.respData.dataList[i].companyName + "</li><li>账号: " + data.respData.dataList[i].custName + "</li><li>手机: " + data.respData.dataList[i].phoneNum + "</li><li>地址: " + data.respData.dataList[0].address + "</li></ul></div>");
						searchclass.isSuccess = true
					}
					myenvetclass.selectAUserOrder();
					loadingPage++;
					isLoding = false;
					$("#container1").hide();
					$(".searUserMore").hide();
					hideLoader()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequests("post", param, eurl, fun)
	},
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
			break
		}
	},
	userSearchPro: function(cateName, proName, proCategoryId) {
		searchclass.searchKey = proName;
		var param = {
			"prodSearch.prodName": searchclass.searchKey,
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
						$("#page2-1 h3").html(cateName)
					}
					if (array_productclass.length == 0) {
						isNoLoading = true;
						$(".fproMore").show();
						hideLoader();
						$("#container1").hide();
						return
					}
					for (var i = 0, len = array_productclass.length; i < len; i++) {
						standbyUrl = imgLink(array_productclass[i].firstProdImg);
						if (array_productclass[i].featureName === null || array_productclass[i].featureName === undefined) {
							xh = ""
						} else {
							xh = array_productclass[i].featureName
						}
						$(".proSearchResults ul").append("<li><a href='javascript:void(0)' class='seldetail' data-myindex='" + array_productclass[i].prodNum + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65'><p>" + array_productclass[i].prodName + "</p> <p class='price45'>产品型号：" + xh + "</p><b class='b-green'>¥" + array_productclass[i].stdPrice + "</b></div></a></li>")
					}
					$("#container1").hide();
					myenvetclass.selectDetailed()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (array_productclass.length < 9) {
					isNoLoading = true;
					$(".fproMore").show();
					hideLoader();
					return
				}
				hideLoader();
				loadingPage++;
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	userSearchIsNull: function(my, cateName, proName, proCategoryId) {
		if (cateName === "") {
			myAlert(".myAlertView", ".myAlertMessage", "条件不能为空!")
		} else {
			$("#container1").show();
			$(".proSearchResults ul").html("");
			$(my).attr("href", "#page2-1");
			searchclass.userSearchPro(cateName, proName, proCategoryId)
		}
	},
	proSearchBack: function(page) {
		$("#proSearchBack").attr("href", page)
	}
};
var messageBoardsClass = {
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
						return
					}
					for (var i = 0, len = array_message.length; i < len; i++) {
						if (array_message[i].createBy === "") {
							createBy = "匿名账户"
						} else {
							createBy = array_message[i].createBy.substr(0, 5) + "******"
						}
						$(".allMessageList").append("<div class='message' ><div class='message-tittle'><ul><li class='f14'>" + createBy + "</li><li class='f12'>" + array_message[i].createDate.replace("T", " ") + "</li></ul></div><div class='message-centent'><ul><li class='himg'><img src='img/messageview/picture.png' ondragstart='return false'></li><li class='hfont'>" + array_message[i].content + "</li></ul></div></div>")
					}
					$("#container1").hide();
					if (array_message.length < 9) {
						isNoLoading = true;
						$(".noMessage").show();
						hideLoader();
						return
					}
					hideLoader();
					loadingPage++;
					isLoding = false;
					$("#container1").hide()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						name = userName.substr(0, 5) + "******"
					} else {
						name = "匿名账户"
					}
					$(".allMessageList").prepend("<div class='message' ><div class='message-tittle'><ul><li class='f14'>" + name + "</li><li class='f12'>1秒前</li></ul></div><div class='message-centent'><ul><li class='himg'><img src='img/messageview/picture.png' ondragstart='return false'></li><li class='hfont'>" + $('#messagetext').val() + "</li></ul></div></div>");
					document.getElementsByTagName('body')[0].scrollTop = 0;
					$("#messagetext").val("")
				} else {
					alert(data.message)
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	}
};
var ManageOrderClass = {
	orderNum: 0,
	userNum: "",
	aUserCompany: "",
	aUserPhoneNum: "",
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
						return
					}
					for (var i = 0, len = array_order.length; i < len; i++) {
						$(".aorderList").append("<div class='center-order'><div class='order' id='aSelectOrderHead" + manageorder.orderNum + i + "'><ul><li><a href='javascript:void(0)' class='toOrderInfo' data-myindex='" + array_order[i].orderNum + "'><span>订单编号：" + array_order[i].orderNum + "<span class='order-go'>></span></span></a></li><li>客户：" + array_order[i].custName + "</li><li>产品总数： " + array_order[i].orderItemList.length + "  </li><li>成交总价：<b class='b-green'>¥" + array_order[i].custPriceTotal + "</b></li><li>结算状态：" + array_order[i].cashStatusName + "</li><li>发货状态：" + array_order[i].deliverStatusName + "</li><li>提交时间：" + array_order[i].createDate + "</li></ul> </div></div>");
						for (var j = 0, itemLen = array_order[i].orderItemList.length; j < itemLen; j++) {
							standbyUrl = imgLink(array_order[i].orderItemList[j].whereimg);
							if (j > 2) {
								itemId = itemId = "aSelectOrderItem" + manageorder.orderNum + i
							}
							$("#aSelectOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_order[i].orderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_order[i].orderItemList[j].prodName + "</p><p class='price45'>¥" + array_order[i].orderItemList[j].custProdPrice + " x " + array_order[i].orderItemList[j].cases + "</p><p><b class='b-green'>总价：¥" + array_order[i].orderItemList[j].custProdPriceTotal + "</b></p></div></div></a>")
						}
						if (array_order[i].orderItemList.length > 3) {
							$("#aSelectOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]'  onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
							$("div[data-waitingItem='" + itemId + "']").hide();
							itemId = ""
						}
					}
					myenvetclass.adminToOrderDetailInfo();
					myenvetclass.selectDetailed();
					manageorder.orderNum++;
					$("#container1").hide()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (array_order.length < 9) {
					isNoLoading = true;
					$(".noOrder").show();
					hideLoader();
					return
				}
				hideLoader();
				loadingPage++;
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						openAlert('.allMessage')
					} else {
						var listView = "";
						var listItems = "";
						var listHead = "";
						$(".ordercontent").html("");
						$(".ordercontent").append("<div class='center-order'><div class='order' id='aSelectOrderInfoHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + array_orderinfo.order.orderNum + "</span></li><li>客户：" + array_orderinfo.order.custName + "</li><li>产品总数：<p> " + array_orderinfo.order.orderItemList.length + "  </p></li></li><li>成交总价：<b class='b-green'>¥" + array_orderinfo.order.custPriceTotal + "</b></li><li>收款类型：" + array_orderinfo.order.cashTypeName + "</li><li>收款类型：" + array_orderinfo.order.cashTypeName + "</li><li>结算状态：" + array_orderinfo.order.cashStatusName + "</li><li>发货状态：" + array_orderinfo.order.deliverStatusName + "</li><li>提交时间：" + array_orderinfo.order.createDate + "</li></ul> </div></div>");
						for (var j = 0, itemLen = array_orderinfo.order.orderItemList.length; j < itemLen; j++) {
							standbyUrl = imgLink(array_orderinfo.order.orderItemList[j].whereimg);
							$("#aSelectOrderInfoHead" + manageorder.orderNum + i).append("<div class='order-list'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_orderinfo.order.orderItemList[j].prodName + "</p><p class='price45'>¥" + array_orderinfo.order.orderItemList[j].custProdPrice + " x " + array_orderinfo.order.orderItemList[j].cases + "</p><p><b class='b-green'>总价：¥" + array_orderinfo.order.orderItemList[j].custProdPriceTotal + "</b></p></div></div>")
						}
						window.location.href = "#orderinfo"
					}
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','admin'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						return
					} else {
						$("#userWaitingAudit .all-tittle").show()
					}
					$("#userWaitingAudit .all-tittle h5").html("用户名: " + arrayWaitingOrder[0].createBy);
					for (var i = 0, len = arrayWaitingOrder.length; i < len; i++) {
						$(".userWaitingOrder").append("<div class='center-order'><div class='order' id='doneWaitingOrderHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + arrayWaitingOrder[i].origOrderNum + "</span></li><li>产品总数：<b class='b-green'> " + arrayWaitingOrder[i].origOrderItemList.length + "  </b></li><li>成交总价：¥" + arrayWaitingOrder[i].priceTotal + "</li><li>下单日期：" + arrayWaitingOrder[i].createDate + "</li></ul> </div></div>");
						for (var j = 0, itemLen = arrayWaitingOrder[i].origOrderItemList.length; j < itemLen; j++) {
							standbyUrl = imgLink(arrayWaitingOrder[i].origOrderItemList[j].whereimg);
							if (j > 2) {
								itemId = "doneWaitingOrderProItem" + manageorder.orderNum + i
							}
							$("#doneWaitingOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + arrayWaitingOrder[i].origOrderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='price45'>订购数量：" + arrayWaitingOrder[i].origOrderItemList[j].cases + "</p><b class='b-green'>产品单价：¥" + arrayWaitingOrder[i].origOrderItemList[j].prodPrice + "</b></div></div></a>")
						}
						if (arrayWaitingOrder[i].origOrderItemList.length > 3) {
							$("#doneWaitingOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]' onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
							$("div[data-waitingItem='" + itemId + "']").hide();
							itemId = ""
						}
					}
					manageorder.orderNum++;
					myenvetclass.selectDetailed();
					$("#container1").hide()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (arrayWaitingOrder.length < 9) {
					isNoLoading = true;
					$(".noMyWaitingOrder").show();
					hideLoader();
					return
				}
				hideLoader();
				loadingPage++;
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
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
						return
					} else {
						$("#myorder .all-tittle").show()
					}
					$("#myorder .all-tittle h5").html("用户名: " + array_order[0].custName);
					for (var i = 0, len = array_order.length; i < len; i++) {
						$(".userOrderList").append("<div class='center-order'><div class='order' id='doneOrderHead" + manageorder.orderNum + i + "'><ul><li><span>订单编号：" + array_order[i].orderNum + "</span></li><li>产品总数：<b class='b-green'> " + array_order[i].orderItemList.length + "  </b></li><li>成交总价：¥" + array_order[i].custPriceTotal + "</li><li>发货状态：" + array_order[i].deliverStatusName + "</li><li>下单日期：" + array_order[i].createDate + "</li></ul> </div></div>");
						for (var j = 0, itemLen = array_order[i].orderItemList.length; j < itemLen; j++) {
							standbyUrl = imgLink(array_order[i].orderItemList[j].whereimg);
							if (j > 2) {
								itemId = itemId = "doneOrderProItem" + manageorder.orderNum + i
							}
							$("#doneOrderHead" + manageorder.orderNum + i).append("<a href='javascript:void(0)' class='seldetail' data-myindex='" + array_order[i].orderItemList[j].prodNum + "'><div class='order-list' data-waitingItem='" + itemId + "'><div class='w30'><img src='" + standbyUrl + "' onerror=this.src='" + errImg + "'></div><div class='w65 ee'><p class='fon-1'>" + array_order[i].orderItemList[j].prodName + "</p><p class='price45'>订购数量：" + array_order[i].orderItemList[j].cases + "</p><b class='b-green'>产品单价：¥" + array_order[i].orderItemList[j].custProdPrice + "</b></div></div></a>")
						}
						if (array_order[i].orderItemList.length > 3) {
							$("#doneOrderHead" + manageorder.orderNum + i).append("<div class='buttonView-a'><div class='buttonClass-a'><a href='javascript:void(0)' style='width:100%;text-align:center' data-isShowAll='false' itemListId='div[data-waitingItem=" + itemId + "]' onclick='manageorder.showOrderAllProList(this)' data-role='none'>显示订单所有商品</a></div></div>");
							$("div[data-waitingItem='" + itemId + "']").hide();
							itemId = ""
						}
					}
					manageorder.orderNum++;
					myenvetclass.selectDetailed();
					$("#container1").hide()
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
				if (array_order.length < 9) {
					isNoLoading = true;
					$(".noMyOrder").show();
					hideLoader();
					return
				}
				hideLoader();
				loadingPage++;
				isLoding = false
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	showOrderAllProList: function(my) {
		if ($(my).attr("data-isShowAll") === "false") {
			$($(my).attr("itemListId")).show();
			$(my).html("收起展开的商品");
			$(my).attr("data-isShowAll", "true")
		} else {
			$($(my).attr("itemListId")).hide();
			$(my).attr("data-isShowAll", "false");
			$(my).html("显示订单所有商品")
		}
	}
};
var userProductClass = {
	myThis: this,
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
					for (var i = 0, len = detailedinfo.prodImgs.length; i < len; i++) {
						standbyUrl = imgLink(detailedinfo.prodImgs[i].thumbUrl);
						myimg += "<div class='swiper-slide'><a href='javascript:void(0)' class='ampImg' data-myImg='" + standbyUrl + "'><img src=" + standbyUrl + " onerror=this.src='" + errImg + "' style='height:100%;'> </a></div>"
					}
					if (detailedinfo.prodImgs.length > 0) {
						var myimgcontent = "<div class='swiper-wrapper' id='silderclass'>" + myimg + "</div><div class='mpagination'></div><div class='repair'>.</div>";
						$("#contentslider .swiper-container").show()
					} else {
						$("#contentslider .swiper-container").hide()
					}
					$("#contentslider .swiper-container").append(myimgcontent);
					for (var y = 0, len = detailedinfo.prodFeatures.length; y < len; y++) {
						prodExtFeatures += "<li>" + detailedinfo.prodFeatures[y].featureName + ": " + detailedinfo.prodFeatures[y].featureValue + "</li>"
					}
					$(".detailed-tittle h5").html(detailedinfo.prodName);
					text = "<li>产品单价: <span class='#green'>¥" + detailedinfo.stdPrice + "</span></li>" + "<li>产品库存: " + detailedinfo.dispStockBalance + "件</li>" + prodExtFeatures + "<li>上市日期: " + detailedinfo.createDate.replace("T", " ") + "</li>";
					$(".cqcs ul").append(text);
                    var longImg = "";
                    if(detailedinfo.detailedImg !== null && detailedinfo.detailedImg !== "" && detailedinfo.detailedImg !== undefined){
                        longImg = imgLink(detailedinfo.detailedImg);
                    }
                    $(".proLongImg").html(longImg);

					$("#send").attr("data-myindex", index);
					if (detailedinfo.externalSysCode === "1688" && isComShopping === false) {
						$("#goToTaoBao").show();
						$("#send").hide();
						$("#goToDetailed").hide();
						$(".quantity").hide();
						for (var i = 0, len = detailedinfo.prodExternals.length; i < len; i++) {
							if (classverifiction.isMobile()) {
								if (detailedinfo.prodExternals[i].externalName === "murl") {
									try {
										window.device.version.substr(0, 1);
										$("#goToTaoBao").unbind("click").bind("click", {
											url: detailedinfo.prodExternals[i].externalValue
										}, function(event) {
											webpage_mobile(event.data.url);
											$("#goToTaoBao").attr("href", "#");
											$("#goToTaoBao").removeAttr("target")
										})
									} catch (error) {
										$("#goToTaoBao").unbind("click");
										$("#goToTaoBao").bind("click", {
											url: detailedinfo.prodExternals[i].externalValue
										}, function(event) {
											window.open(event.data.url)
										})
									}
								}
							} else {
								if (detailedinfo.prodExternals[i].externalName === "url") {
									$("#goToTaoBao").unbind("click");
									$("#goToTaoBao").bind("click", {
										url: detailedinfo.prodExternals[i].externalValue
									}, function(event) {
										window.open(event.data.url)
									})
								}
							}
						}
					} else {
						$("#send").show();
						$("#goToDetailed").show();
						$(".quantity").show();
						$("#goToTaoBao").hide()
					}
					$("#container1").hide();
					new Swiper('#contentslider .swiper-container', {
						pagination: '.mpagination',
						loop: true,
						grabCursor: true,
						paginationClickable: true
					});
					myenvetclass.ampImgEvent()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	},
	addOrMinusNumber: function(my, type, key) {
		var number = 0;
		var pageInputClass = $(my).attr("data-inputId");
		if (classverifiction.isInt($(pageInputClass).val())) {
			number = parseInt($(pageInputClass).val());
			if (type === "add") {
				$(pageInputClass).val(++number)
			} else {
				if (key === 1) {
					if (number >= 2) {
						$(pageInputClass).val(--number)
					}
				} else {
					if (number >= 1) {
						$(pageInputClass).val(--number)
					}
				}
			}
			if (key === 1) {
				userproduct.changeNumber(pageInputClass, $(pageInputClass).attr("proNum"))
			}
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!")
		}
	},
	sendOrder: function() {
		var jsonitems = "";
		var sendjson = "";
		var param = {};
		var bool_refresh;
		var jsondata = JSON.parse(localStorage.getItem(userName));
		for (var i = 0, len = jsondata.length; i < len; i++) {
			if (i === 0) {
				jsonitems += "{'prodNum':'" + jsondata[i].myid + "','cases':" + jsondata[i].mynumber + "}"
			} else {
				jsonitems += ",{'prodNum':'" + jsondata[i].myid + "','cases':" + jsondata[i].mynumber + "}"
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
					openAlert('.allMessage')
				} else {
					$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
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
						openAlert('.allMessage')
					} else {
						$(".allMessage .alertMessage").html(data.message);
						openAlert('.allMessage')
					}
				};
			serviceconnection.postRequest("post", param, eurl, fun)
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!")
		}
	},
	getShoppingInfo: function() {
		if (localStorage.getItem(userName) === "[]" || localStorage.getItem(userName) === undefined) {
			$(".shoppingBg").html("");
			$(".promptText").show();
			$("#container1").hide();
			return
		} else {
			var jsondata = JSON.parse(localStorage.getItem(userName));
			$("#orderSendBtn").show();
			for (var i = 0, len = jsondata.length; i < len; i++) {
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
							myenvetclass.deleteShoppingAPro()
						} else {
							$(".allMessage .alertBtnConfirm a").attr("onclick", "confirmEnvent('.allMessage',classlogin.isLoginGetStatu('您还没有登录','user'),'')");
							$(".allMessage .alertMessage").html(data.message);
							openAlert('.allMessage');
							return
						}
					};
				serviceconnection.postRequests("post", param, eurl, fun)
			}
		}
	},
	changeNumber: function(my, index) {
		if (classverifiction.isInt($(my).val()) && classverifiction.isInt($(my).val()) > 0) {
			mydatabase.updateData(index, $(my).val())
		} else {
			myAlert(".myAlertView", ".myAlertMessage", "请输入正确的数量!")
		}
	},
	deleteShoppingInfo: function(my) {
		$("#page5 .alertMessage").html("您正在执行删除购物车商品，是否确定执行？");
		$("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',mydatabase.deleteItemData('" + $($(my).attr("data-inputId")).attr("proNum") + "','" + $(my).attr("shoppingItemId") + "'))");
		openAlert("#page5")
	}
};
var OwnerInfoClass = {
	lati: 0,
	longi: 0,
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
					$("#codetext").html("<p>" + arrStr[0] + "。</p>");
					standbyUrl = imgLink(data.respData.ownerImg);
					$(".aboutImg").html("<img src='" + standbyUrl + "'  onerror=this.src='" + errImg + "'>");
					$("#contactInfo").html("<p>企业名：" + data.respData.companyName + "</p><p>地址：" + data.respData.address + "</p><p>网址：" + data.respData.webSite + "</p><p>联系人：" + data.respData.contactPerson + "</p><p>电话：" + data.respData.phoneNum.replace(/\s/g, "") + "</a></p>");
					classownerinfo.lati = data.respData.latitudes;
					classownerinfo.longi = data.respData.longitude;
					$("#container1").hide()
				} else {
					$(".allMessage .alertMessage").html(data.message);
					openAlert('.allMessage')
				}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	}
};
var serviceConnectionClass = {
	postRequest: function(type, param, url, method) {
		$.ajax({
			type: type,
			url: url,
			data: param,
			dataType: "json",
			success: method,
			error: function() {
				$("#container1").hide();
				if (phonedealwith.isPhoneInternal === false) {
					hideLoader();
					isLoding = true
				}
			}
		})
	},
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
					isLoding = true
				}
			}
		})
	}
};
var phoneDealWithClass = {
	isPhoneInternal: false,
	onOffLineInternal: function() {
		$(".conPrompt").fadeIn();
		hideLoader();
		isLoding = true
	},
	onOnLineInternal: function() {
		$(".conPrompt").fadeOut();
		isLoding = false
	},
	onBackKeyDown: function() {
		if (indexclass.isIndex === true) {
			navigator.notification.confirm('确定退出企业应用吗', function(buttonIndex) {
				if (buttonIndex === 1) {
					phonedealwith.exitApp()
				} else {
					navigator.notification.cancel()
				}
			}, '退出企业应用', ['退出', '返回'])
		} else {
			navigator.app.backHistory()
		}
	},
	exitApp: function() {
		navigator.app.exitApp()
	},
	testSetJushTagNalias: function() {
		var param = {};
		var eurl = userUrlHead + userGetAliasNTags;
		var fun = function(data) {
				var standbyUrl = "";
				if (data.status === "S") {
					try {
						cordova.exec(phonedealwith.pluginAlert, phonedealwith.pluginAlert, "JpushClient", "setJpushAliasAndTags", [data.respData.alias, data.respData.tags])
					} catch (err) {}
				} else {}
			};
		serviceconnection.postRequest("post", param, eurl, fun)
	}
};
var classVerifictionClass = {
	iphonever: function(str) {
		if (str == "") {
			return false
		} else if (!(/^1[3|4|5|8][0-9]\d{8}$/.test(str))) {
			return false
		} else {
			return true
		}
	},
	isInt: function(str) {
		var reg = /^(-|\+)?\d+$/;
		return reg.test(str)
	},
	isLetterAndNum: function(str) {
		var reg = /^(([a-z]+[0-9]+)|([0-9]+[a-z]+)|[a-z]|[0-9])[a-z0-9]*$/;
		return reg.test(str)
	},
	isFloat: function(str) {
		if (!(/^\d+(.\d{1,2}){0,1}$/.test(str))) {
			return false
		} else {
			return true
		}
	},
	isMobile: function() {
		var regex_match = /(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;
		var u = navigator.userAgent;
		if (null == u) {
			return true
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
var myEnvetClass = {
	method: null,
	args: [],
	phonenum: "",
	shoppingNum: 0,
	myScrollEnvet: function(mId) {
		$(document).on("scroll", "", function() {
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
							break
						}
					} else {
						hideLoader();
						return
					}
				}
			}
		})
	},
	ScrollEnvetRelease: function() {
		$(document).unbind("scroll");
		isNoLoading = false;
		isLoding = false;
		loadingPage = 1;
		$("#container1").hide();
		searchclass.searchKey = "";
		myenvetclass.args = [];
		myenvetclass.method = null
	},
	bodyClickEvent: function() {
		$("body").unbind("click").on("click", function(event) {
			var e = event || window.event;
			var elem = e.srcElement || e.target;
			if (elem !== document) {
				if (elem.className !== "rigthMenu" && elem.className !== "rigthMenuImg" && elem.className !== "left-search" && elem.className !== "left-searchText" && elem.className !== "left-searchImg") {
					if ($(".rigthMenu").attr("data-isMenuBtnOpen") === "true") {
						$(".rigthMenu").attr("data-isMenuBtnOpen", "false");
						$(".right-menu-list").hide()
					}
					if ($(".left-search").attr("data-isShow") === "true") {
						$(".left-search-list").hide();
						$(".left-search").attr("data-isShow", "false")
					}
					return
				}
				elem = elem.parentNode
			} else {
				return
			}
		})
	},
	alertConfirmAndCancel: function() {
		$(".confirmBtn").unbind("touchstart").on("touchstart", function() {
			$(".confirmBtn").css("color", "#FFFFFF");
			$(".confirmBtn").css("background-color", "#35C28C")
		});
		$(".confirmBtn").unbind("touchend").on("touchend", function() {
			$(".confirmBtn").css("color", "#34A277");
			$(".confirmBtn").css("background-color", "#e9e8e8")
		});
		$(".cancelBtn").unbind("touchstart").on("touchstart", function() {
			$(".cancelBtn").css("color", "#FFFFFF");
			$(".cancelBtn").css("background-color", "#35C28C")
		});
		$(".cancelBtn").unbind("touchend").on("touchend", function() {
			$(".cancelBtn").css("color", "#34A277");
			$(".cancelBtn").css("background-color", "transparent")
		})
	},
	addShopping: function(minus, add, key) {
		if (key === undefined || key === null) {
			key = 0
		}
		document.getElementById(minus).addEventListener("touchend", function() {
			userproduct.addOrMinusNumber("#" + minus, "minus", key)
		}, true);
		document.getElementById(add).addEventListener("touchend", function() {
			userproduct.addOrMinusNumber("#" + add, "add", key)
		}, true)
	},
	rightMenuEvent: function() {
		$(".rigthMenu").unbind("touchstart").on("touchstart", function() {
			$(".rigthMenu").css("display", "block");
			$(".rigthMenu").css("background-color", "#35C28C")
		});
		$(".rigthMenu").unbind("touchend").on("touchend", function() {
			$(".rigthMenu").css("background-color", "transparent");
			var rigthMenu = $(".rigthMenu");
			var rightMenuList = $(".right-menu-list");
			if (rigthMenu.attr("data-isMenuBtnOpen") === "false") {
				rigthMenu.attr("data-isMenuBtnOpen", "true");
				rightMenuList.show()
			} else {
				rigthMenu.attr("data-isMenuBtnOpen", "false");
				rightMenuList.hide()
			}
		});
		$(".index").unbind("touchstart").on("touchstart", function() {
			$(".index").css("display", "block");
			$(".index").css("background-color", "#35C28C");
			return
		});
		$(".index").unbind("touchend").on("touchend", function() {
			$(".index").css("background-color", "transparent");
			return
		});
		$(".index").unbind("click").on("click", function() {
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			window.location.href = "#index"
		});
		$(".product").unbind("touchstart").on("touchstart", function() {
			$(".product").css("display", "block");
			$(".product").css("background-color", "#35C28C")
		});
		$(".product").unbind("touchend").on("touchend", function() {
			$(".product").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			window.location.href = "#product"
		});
		$(".leave").unbind("touchstart").on("touchstart", function() {
			$(".leave").css("display", "block");
			$(".leave").css("background-color", "#35C28C")
		});
		$(".leave").unbind("touchend").on("touchend", function() {
			$(".leave").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			window.location.href = "#message"
		});
		$(".about").unbind("touchstart").on("touchstart", function() {
			$(".about").css("display", "block");
			$(".about").css("background-color", "#35C28C")
		});
		$(".about").unbind("touchend").on("touchend", function() {
			$(".about").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			window.location.href = "#about"
		});
		$(".buyers").unbind("touchstart").on("touchstart", function() {
			$(".buyers").css("display", "block");
			$(".buyers").css("background-color", "#35C28C")
		});
		$(".buyers").unbind("touchend").on("touchend", function() {
			$(".buyers").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			classlogin.getUserLoginState('#personal', poppage)
		});
		$(".phone").unbind("touchstart").on("touchstart", function() {
			$(".phone").css("display", "block");
			$(".phone").css("background-color", "#35C28C")
		});
		$(".phone").unbind("touchend").on("touchend", function() {
			$(".phone").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			if (myenvetclass.phonenum === "") {} else {
				window.location.href = myenvetclass.phonenum
			}
		});
		$(".seller").unbind("touchstart").on("touchstart", function() {
			$(".seller").css("display", "block");
			$(".seller").css("background-color", "#35C28C")
		});
		$(".seller").unbind("touchend").on("touchend", function() {
			$(".seller").css("background-color", "transparent");
			if ($(this).attr("data-isRmenu") === "true") {
				menuClose()
			}
			classlogin.getAdminLoginState('#adminMenu', poppage)
		})
	},
	indexMenuEvent: function() {
		$(".indexMenuIconBtn").unbind("click").on("click", function() {
			var indexMenuId = $("#indexMenuId");
			var indexMenuIconBtn = $(".indexMenuIconBtn");
			var indexMenuImg = $("#indexMenuImg");
			if (indexMenuId.attr("data-isInit") === "false") {
				indexMenuId.show();
				indexMenuId.attr("data-isInit", "true")
			}
			if (indexclass.isIndexMenuOpen === false) {
				indexMenuImg.attr("src", "img/indexview/tdown.png");
				indexMenuIconBtn.css("bottom", $(".classindexmenu").height());
				indexMenuId.show();
				indexclass.isIndexMenuOpen = true
			} else {
				indexMenuImg.attr("src", "img/indexview/ttop.png");
				indexMenuIconBtn.css("bottom", "0px");
				indexMenuId.hide();
				indexclass.isIndexMenuOpen = false
			}
		})
	},
	proListShow: function() {
		$("#toAllListProShow").unbind("touchstart").on("touchstart", function() {
			$("#toAllListProShow").css("display", "block");
			$("#toAllListProShow").css("background-color", "#35C28C")
		});
		$("#toAllListProShow").unbind("touchend").on("touchend", function() {
			$("#toAllListProShow").css("background-color", "transparent");
			window.location.href = "#allListProShow"
		})
	},
	proSearchShow: function() {
		$(".toProSearch").unbind("touchstart").on("touchstart", function() {
			$(".toProSearch").css("display", "block");
			$(".toProSearch").css("background-color", "#35C28C")
		});
		$(".toProSearch").unbind("touchend").on("touchend", function() {
			$(".toProSearch").css("background-color", "transparent");
			searchclass.proSearchBack(poppage);
			window.location.href = "#proSearch"
		})
	},
	proCatItemCilicEvent: function() {
		$(".catItem").unbind("touchend").on("touchend", function() {
			searchclass.userSearchIsNull('', $(this).attr("data-catName"), '', $(this).attr("data-catId"));
			window.location.href = "#page2-1"
		})
	},
	proDetailClickEvent: function() {
		$("#send").unbind("touchend").on("touchend", function() {
			classlogin.isUserLoginAddOrder('#page2-2', '#page2-2', this)
		});
		$("#goToDetailed").unbind("touchend").on("touchend", function() {
			classlogin.getUserLoginState('#page5', '#page2-2')
		})
	},
	ampImgEvent: function() {
		$(".ampImg").unbind("click").on("click", function() {
			if ($(this).attr("data-myImg") !== "" && $(this).attr("data-myImg") !== undefined && $(this).attr("data-myImg") !== errImg) {
				$(".ampImgLayer").show();
				$(".closeAmpImg").show();
				$(".ampImgBg").html("<img src='" + $(this).attr("data-myImg") + "'>");
				$(".ampImgBg").css("margin-left", -($(".ampImgBg").width() / 2));
				$(".ampImgBg").css("margin-top", -($(".ampImgBg").height() / 2))
			}
		});
		$("#closeAmpBtn").unbind("touchstart").on("touchstart", function() {
			$(".closeAmpImg").css("background-color", "#FF6666")
		});
		$("#closeAmpBtn").unbind("touchend").on("touchend", function() {
			$(".closeAmpImg").css("background-color", "transparent");
			$(".ampImgLayer").hide();
			$(".ampImgBg").html("");
			$(".closeAmpImg").hide()
		})
	},
	goto1688Event: function() {
		$("#goToTaoBao").unbind("touchstart").on("touchstart", function() {
			$("#goToTaoBao").css("filter", "alpha(opacity=0.8)");
			$("#goToTaoBao").css("-moz-opacity", "0.8");
			$("#goToTaoBao").css("-khtml-opacity", "0.8");
			$("#goToTaoBao").css("opacity", "0.8")
		});
		$("#goToTaoBao").unbind("touchend").on("touchend", function() {
			$("#goToTaoBao").css("filter", "alpha(opacity=1)");
			$("#goToTaoBao").css("-moz-opacity", "1");
			$("#goToTaoBao").css("-khtml-opacity", "1");
			$("#goToTaoBao").css("opacity", "1")
		})
	},
	selectDetailed: function() {
		$(".seldetail").unbind("click").on("click", function() {
			if ($(this).attr("data-iswindow") === undefined || $(this).attr("data-iswindow") === null) {
				setpoppage(this, poppage);
				window.location.href = "#page2-2"
			} else {
				webpage_mobile($(this).attr("data-aliurl"))
			}
		})
	},
	backBtnClickEnvet: function() {
		$(".back").unbind("touchstart").on("touchstart", function() {
			$(".back").css("display", "block");
			$(".back").css("background-color", "#35C28C")
		});
		$(".back").unbind("touchend").on("touchend", function() {
			$(".back").css("background-color", "transparent");
			$.mobile.back()
		})
	},
	addMessage: function() {
		$("#addmessagebtn").unbind("touchstart").on("touchstart", function() {
			$("#addmessagebtn img").css("filter", "alpha(opacity=0.7)");
			$("#addmessagebtn img").css("-moz-opacity", "0.7");
			$("#addmessagebtn img").css("opacity", "0.7");
			$("#addmessagebtn img").css("-khtml-opacity", "0.7")
		});
		$("#addmessagebtn").unbind("touchend").on("touchend", function() {
			$("#addmessagebtn img").css("filter", "alpha(opacity=1)");
			$("#addmessagebtn img").css("-moz-opacity", "1");
			$("#addmessagebtn img").css("opacity", "1");
			$("#addmessagebtn img").css("-khtml-opacity", "1");
			if ($("#messagetext").val() !== "") {
				classlogin.isUserLogin();
				if (classlogin.userLoginState === true) {
					messageboards.sendMessage()
				} else {
					$("#message .alertMessage").html("您当前尚未登录，将以匿名身份进行评论。");
					$("#message .alertBtnConfirm a").attr("onclick", "messageboards.sendMessage()");
					openAlert("#message")
				}
			} else {
				myAlert(".myAlertView", ".myAlertMessage", "评论不能为空!")
			}
		})
	},
	aboutAndContact: function() {
		$("#toContact").unbind("touchstart").on("touchstart", function() {
			$("#toContact").css("background-color", "#dadada")
		});
		$("#toContact").unbind("touchend").on("touchend", function() {
			$("#toContact").css("background-color", "transparent");
			window.location.href = "#contact"
		});
		$("#toAbout").unbind("touchstart").on("touchstart", function() {
			$("#toAbout").css("background-color", "#dadada")
		});
		$("#toAbout").unbind("touchend").on("touchend", function() {
			$("#toAbout").css("background-color", "transparent");
			$.mobile.back()
		})
	},
	userRegisterClickEnvet: function() {
		$("#toregister").unbind("touchstart").on("touchstart", function() {
			$("#toregister").css("background-color", "#e9e8e8")
		});
		$("#toregister").unbind("touchend").on("touchend", function() {
			$("#toregister").css("background-color", "#ffffff");
			window.location.href = "#register"
		})
	},
	userLoginClickEnvet: function() {
		$("#userloginsend").unbind("touchstart").on("touchstart", function() {
			$("#userloginsend").css("background-color", "#2eb07f")
		});
		$("#userloginsend").unbind("touchend").on("touchend", function() {
			$("#userloginsend").css("background-color", "#35C28C");
			classlogin.userLogin($('#username').val(), $('#userpassword').val())
		})
	},
	sendRegisterInfo: function() {
		$("#sendRegisterBtn").unbind("touchstart").on("touchstart", function() {
			$("#sendRegisterBtn").css("background-color", "#2eb07f")
		});
		$("#sendRegisterBtn").unbind("touchend").on("touchend", function() {
			$("#sendRegisterBtn").css("background-color", "#35C28C");
			registclass.userRegist($('#raccount').val(), $('#rpassword').val(), $('#rpasswordok').val(), $('#rname').val(), $('#rcompanyName').val())
		})
	},
	personalItemEvent: function() {
		$("#toShopping").unbind("touchstart").on("touchstart", function() {
			$("#toShopping").css("background-color", "#35C28C");
			$("#toShopping").css("color", "#FFFFFF")
		});
		$("#toShopping").unbind("touchend").on("touchend", function() {
			$("#toShopping").css("background-color", "transparent");
			$("#toShopping").css("color", "#9e9b9b");
			window.location.href = "#page5"
		});
		$("#toUserWaitingAudit").unbind("touchstart").on("touchstart", function() {
			$("#toUserWaitingAudit").css("background-color", "#35C28C");
			$("#toUserWaitingAudit").css("color", "#FFFFFF")
		});
		$("#toUserWaitingAudit").unbind("touchend").on("touchend", function() {
			$("#toUserWaitingAudit").css("background-color", "transparent");
			$("#toUserWaitingAudit").css("color", "#9e9b9b");
			window.location.href = "#userWaitingAudit"
		});
		$("#toMyOrder").unbind("touchstart").on("touchstart", function() {
			$("#toMyOrder").css("background-color", "#35C28C");
			$("#toMyOrder").css("color", "#FFFFFF")
		});
		$("#toMyOrder").unbind("touchend").on("touchend", function() {
			$("#toMyOrder").css("background-color", "transparent");
			$("#toMyOrder").css("color", "#9e9b9b");
			window.location.href = "#myorder"
		});
		$("#toSuperPro").unbind("touchstart").on("touchstart", function() {
			$("#toSuperPro").css("background-color", "#35C28C");
			$("#toSuperPro").css("color", "#FFFFFF")
		});
		$("#toSuperPro").unbind("touchend").on("touchend", function() {
			$("#toSuperPro").css("background-color", "transparent");
			$("#toSuperPro").css("color", "#9e9b9b");
			window.location.href = "#superPro"
		});
		$("#toUserModifyInfo").unbind("touchstart").on("touchstart", function() {
			$("#toUserModifyInfo").css("background-color", "#35C28C");
			$("#toUserModifyInfo").css("color", "#FFFFFF")
		});
		$("#toUserModifyInfo").unbind("touchend").on("touchend", function() {
			$("#toUserModifyInfo").css("background-color", "transparent");
			$("#toUserModifyInfo").css("color", "#9e9b9b");
			window.location.href = "#userModifyInfo"
		});
		$("#toUserModifyPass").unbind("touchstart").on("touchstart", function() {
			$("#toUserModifyPass").css("background-color", "#35C28C");
			$("#toUserModifyPass").css("color", "#FFFFFF")
		});
		$("#toUserModifyPass").unbind("touchend").on("touchend", function() {
			$("#toUserModifyPass").css("background-color", "transparent");
			$("#toUserModifyPass").css("color", "#9e9b9b");
			window.location.href = "#userModifyPass"
		});
		$("#myOutLogin").unbind("touchstart").on("touchstart", function() {
			$("#myOutLogin").css("background-color", "#35C28C");
			$("#myOutLogin").css("color", "#FFFFFF")
		});
		$("#myOutLogin").unbind("touchend").on("touchend", function() {
			$("#myOutLogin").css("background-color", "transparent");
			$("#myOutLogin").css("color", "#9e9b9b");
			openAlert('#personal')
		})
	},
	userUpdatePass: function() {
		$("#updateUpassDone").unbind("touchstart").on("touchstart", function() {
			$("#updateUpassDone").css("background-color", "#2eb07f")
		});
		$("#updateUpassDone").unbind("touchend").on("touchend", function() {
			$("#updateUpassDone").css("background-color", "#35C28C");
			classlogin.isUserLegality()
		})
	},
	userUpdateInfo: function() {
		$("#updateInfoDone").unbind("touchstart").on("touchstart", function() {
			$("#updateInfoDone").css("background-color", "#2eb07f")
		});
		$("#updateInfoDone").unbind("touchend").on("touchend", function() {
			$("#updateInfoDone").css("background-color", "#35C28C");
			registclass.userUpdateInfo($('#companyName').val(), $('#contactName').val(), $('#contactPhone').val(), $('#companyAddress').val())
		})
	},
	deleteShoppingAPro: function() {
		$(".deleteBtn").unbind("touchend").on("touchend", function() {
			userproduct.deleteShoppingInfo(this)
		})
	},
	sendShoppingOrder: function() {
		$("#orderSendBtn").unbind("click").on("click", function() {
			for (var i = 0, len = myenvetclass.shoppingNum; i < len; i++) {
				if (classverifiction.isInt($("#shoppingNum" + i).val()) && classverifiction.isInt($("#shoppingNum" + i).val()) > 0) {
					mydatabase.updateData($("#shoppingNum" + i).attr("proNum"), $("#shoppingNum" + i).val());
					if (i === len - 1) {
						openAlert('#page5')
					}
				} else {
					myAlert(".myAlertView", ".myAlertMessage", "第" + (i + 1) + "个产品数量有误!");
					break
				}
			}
		})
	},
	adminLoginClickEvent: function() {
		$("#adminLoginBtn").unbind("touchstart").on("touchstart", function() {
			$("#adminLoginBtn").css("background-color", "#2eb07f")
		});
		$("#adminLoginBtn").unbind("touchend").on("touchend", function() {
			$("#adminLoginBtn").css("background-color", "#35C28C");
			classlogin.adminLogin($('#adminname').val(), $('#adminpassword').val())
		})
	},
	adminMenuItemEvent: function() {
		$("#toAdminSelectOrder").unbind("touchstart").on("touchstart", function() {
			$("#toAdminSelectOrder").css("background-color", "#35C28C");
			$("#toAdminSelectOrder").css("color", "#FFFFFF")
		});
		$("#toAdminSelectOrder").unbind("touchend").on("touchend", function() {
			$("#toAdminSelectOrder").css("background-color", "transparent");
			$("#toAdminSelectOrder").css("color", "#9e9b9b");
			window.location.href = "#adminselectorder"
		});
		$("#toAdminProManage").unbind("touchstart").on("touchstart", function() {
			$("#toAdminProManage").css("background-color", "#35C28C");
			$("#toAdminProManage").css("color", "#FFFFFF")
		});
		$("#toAdminProManage").unbind("touchend").on("touchend", function() {
			$("#toAdminProManage").css("background-color", "transparent");
			$("#toAdminProManage").css("color", "#9e9b9b");
			window.location.href = "#adminProManage"
		});
		$("#toAdminModifyPass").unbind("touchstart").on("touchstart", function() {
			$("#toAdminModifyPass").css("background-color", "#35C28C");
			$("#toAdminModifyPass").css("color", "#FFFFFF")
		});
		$("#toAdminModifyPass").unbind("touchend").on("touchend", function() {
			$("#toAdminModifyPass").css("background-color", "transparent");
			$("#toAdminModifyPass").css("color", "#9e9b9b");
			window.location.href = "#adminModifyPass"
		});
		$("#toClientSearch").unbind("touchstart").on("touchstart", function() {
			$("#toClientSearch").css("background-color", "#35C28C");
			$("#toClientSearch").css("color", "#FFFFFF")
		});
		$("#toClientSearch").unbind("touchend").on("touchend", function() {
			$("#toClientSearch").css("background-color", "transparent");
			$("#toClientSearch").css("color", "#9e9b9b");
			window.location.href = "#clientsearch"
		});
		$("#adminOutLogin").unbind("touchstart").on("touchstart", function() {
			$("#adminOutLogin").css("background-color", "#35C28C");
			$("#adminOutLogin").css("color", "#FFFFFF")
		});
		$("#adminOutLogin").unbind("touchend").on("touchend", function() {
			$("#adminOutLogin").css("background-color", "transparent");
			$("#adminOutLogin").css("color", "#9e9b9b");
			openAlert('#adminMenu')
		})
	},
	adminSearch: function() {
		$(".aSearchItem").unbind("touchend").on("touchend", function() {
			if ($(this).attr("data-optionItem") === "item") {
				$(".search-custoner-top div").attr("data-optionItem", "item");
				$(this).attr("data-optionItem", "itemSelected");
				searchUserKey = parseInt($(this).attr("data-myVal"))
			} else {}
		});
		$("#aSearchBtn").unbind("touchstart").on("touchstart", function() {
			$("#aSearchBtn").css("filter", "alpha(opacity=0.7)");
			$("#aSearchBtn").css("-moz-opacity", "0.7");
			$("#aSearchBtn").css("opacity", "0.7");
			$("#aSearchBtn").css("-khtml-opacity", "0.7")
		});
		$("#aSearchBtn").unbind("touchend").on("touchend", function() {
			$("#aSearchBtn").css("filter", "alpha(opacity=1)");
			$("#aSearchBtn").css("-moz-opacity", "1");
			$("#aSearchBtn").css("opacity", "1");
			$("#aSearchBtn").css("-khtml-opacity", "1");
			searchclass.conditionSearch()
		})
	},
	adminOpenSearchKey: function() {
		$(".left-search").unbind("touchend").on("touchend", function() {
			if ($(this).attr("data-isShow") === "false") {
				$(".left-search-list").show();
				$(".left-search-list ul li a[data-state='true']").hide();
				$(".left-search-list ul li a[data-state='false']").show();
				$(this).attr("data-isShow", "true")
			} else {
				$(".left-search-list").hide();
				$(this).attr("data-isShow", "false")
			}
		})
	},
	adminSearchOrderKey: function() {
		$(".orderSearchKey").unbind("touchend").on("touchend", function() {
			var leftSearch = $(".left-search");
			leftSearch.attr("data-searchKey", $(this).attr("data-keyValue"));
			$(".left-search-list ul li a:nth-child(0)").attr("data-state", "false");
			$(".left-search-list ul li a:nth-child(1)").attr("data-state", "false");
			$(this).attr("data-state", "true");
			$(".left-searchText").html($(this).html());
			$(".left-search-list").hide();
			leftSearch.attr("data-isShow", "false")
		})
	},
	adminSearchOrderBtn: function() {
		$(".right-search").unbind("touchstart").on("touchstart", function() {
			$(".right-search").css("filter", "alpha(opacity=0.7)");
			$(".right-search").css("-moz-opacity", "0.7");
			$(".right-search").css("opacity", "0.7");
			$(".right-search").css("-khtml-opacity", "0.7")
		});
		$(".right-search").unbind("touchend").on("touchend", function() {
			$(".right-search").css("filter", "alpha(opacity=1)");
			$(".right-search").css("-moz-opacity", "1");
			$(".right-search").css("opacity", "1");
			$(".right-search").css("-khtml-opacity", "1");
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
				return
			} else {
				manageorder.aUserPhoneNum = $(".search-order2-1").val();
				manageorder.adminShowOrderList();
				return
			}
		})
	},
	selectAUserOrder: function() {
		$(".toUserOrder").unbind("click").on("click", function() {
			setCustOrderKey($(this).attr("data-orderKey"));
			window.location.href = "#adminselectorder"
		})
	},
	updateAdminPass: function() {
		$("#updateAdminPassBtn").unbind("touchend").on("touchend", function() {
			classlogin.isAdminLegality()
		})
	},
	adminSearchBtnClickEvent: function() {
		$("#adminSearchPro").unbind("touchstart").on("touchstart", function() {
			$("#adminSearchPro").css("filter", "alpha(opacity=0.7)");
			$("#adminSearchPro").css("-moz-opacity", "0.7");
			$("#adminSearchPro").css("opacity", "0.7");
			$("#adminSearchPro").css("-khtml-opacity", "0.7")
		});
		$("#adminSearchPro").unbind("touchend").on("touchend", function() {
			$("#adminSearchPro").css("filter", "alpha(opacity=1)");
			$("#adminSearchPro").css("-moz-opacity", "1");
			$("#adminSearchPro").css("opacity", "1");
			$("#adminSearchPro").css("-khtml-opacity", "1");
			admingetprodata.aSearchPro($("#proSearchKey").val())
		})
	},
	adminUpdateNumAdnPrice: function() {
		$(".adminUpdatePrice").unbind("touchstart").on("touchstart", function() {
			$(this).css("filter", "alpha(opacity=0.7)");
			$(this).css("-moz-opacity", "0.7");
			$(this).css("-khtml-opacity", "0.7");
			$(this).css("opacity", "0.7")
		});
		$(".adminUpdatePrice").unbind("touchend").on("touchend", function() {
			$(this).css("filter", "alpha(opacity=1)");
			$(this).css("-moz-opacity", "1");
			$(this).css("-khtml-opacity", "1");
			$(this).css("opacity", "1")
		});
		$(".adminUpdatePrice").unbind("click").on("click", function() {
			admingetprodata.editPro('a', $(this).attr("data-price"), 'priceValue', this)
		});
		$(".adminUpdateProNum").unbind("touchstart").on("touchstart", function() {
			$(this).css("filter", "alpha(opacity=0.7)");
			$(this).css("-moz-opacity", "0.7");
			$(this).css("-khtml-opacity", "0.7");
			$(this).css("opacity", "0.7")
		});
		$(".adminUpdateProNum").unbind("touchend").on("touchend", function() {
			$(this).css("filter", "alpha(opacity=1)");
			$(this).css("-moz-opacity", "1");
			$(this).css("-khtml-opacity", "1");
			$(this).css("opacity", "1")
		});
		$(".adminUpdateProNum").unbind("click").on("click", function() {
			admingetprodata.editPro('b', $(this).attr("data-num"), 'stockValue', this)
		})
	},
	adminToOrderDetailInfo: function() {
		$(".toOrderInfo span").unbind("touchstart").on("touchstart", function() {
			$(this).css("filter", "alpha(opacity=0.7)");
			$(this).css("-moz-opacity", "0.7");
			$(this).css("-khtml-opacity", "0.7");
			$(this).css("opacity", "0.7")
		});
		$(".toOrderInfo span").unbind("touchend").on("touchend", function() {
			$(this).css("filter", "alpha(opacity=1)");
			$(this).css("-moz-opacity", "1");
			$(this).css("-khtml-opacity", "1");
			$(this).css("opacity", "1")
		});
		$(".toOrderInfo").unbind("click").on("click", function() {
			manageorder.adminGetOrderInfo(this);
			window.location.href = "#orderinfo"
		})
	}
};
$(document).bind('pageinit', function() {
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
		$(".sendbutton").width(content.width())
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
		$(".sendbutton").width(content.width())
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
	myenvetclass.goto1688Event()
});

function showLoader() {
	$.mobile.loading('show', {
		text: '加载中...',
		textVisible: true,
		theme: 'b',
		textonly: true,
		html: ""
	})
}
function hideLoader() {
	$.mobile.loading('hide')
}
function setpoppage(my, page) {
	productIndex = my;
	poppage = page;
	$("#back").attr("href", poppage);
	$("#contentslider .swiper-container").html("");
	$(".detailed-tittle h5").html("");
	$(".cqcs ul").html("");
    $(".proLongImg").html("");
	userproduct.getDetailed($(my).attr("data-myindex"));
	$("#container1").show();
}
function webpage_mobile(url) {
	var ref = window.open(url, '_blank', 'location=yes,closebuttoncaption=关闭,transitionstyle=crossdissolve,presentationstyle=pagesheet');
	ref.addEventListener('loaderror', function(event) {
		$(".allMessage .alertMessage").html('error: ' + event.message);
		openAlert('.allMessage');
	})
}
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
					$("#wrapper").css("top", "64px")
				}
			}
		}
	} catch (error) {}
}
function textLengthCut(str) {
	if (str.length > 10) {
		return str.substring(0, 10) + "..."
	}
	return str
}
function textLengthTrim(str) {
	return str.replace(/\s/g, "")
}
function getUrlParm(name) {
	var regexS = "[\\?&]" + name + "=([^&#]*)";
	var regex = new RegExp(regexS);
	var tmpURL = window.location.href;
	var results = regex.exec(tmpURL);
	if (results == null) {
		return ""
	} else {
		return results[1]
	}
}
function imgLink(url) {
	var urlData;
	if (url === null) {
		urlData = proImgUrl + defaultuImg
	} else {
		if (url.substring(0, 4) === "http") {
			urlData = url
		} else {
			urlData = proImgUrl + url
		}
	}
	return urlData
}
function isCom() {
	var eurl = adminUrlHead + getSetting;
	var param = {};
	var fun = function(data) {
			if (data.status === "S" && data.respData === true) {
				isComShopping = true
			}
		};
	serviceconnection.postRequest("post", param, eurl, fun)
}
function myAlert(view, messageView, message) {
	$(messageView).html(message);
	$(view).fadeIn();
	if (isAlertShow === false) {
		setTimeout(function() {
			$(view).fadeOut();
			isAlertShow = false
		}, 3000)
	}
	isAlertShow = true
}
function inputFocusOrInputBlur(className, imgUrl) {
	$(className).attr("src", imgUrl)
}
function openAlert(id) {
	$(id + " .alertViewBg").fadeIn();
	$(id + " .alertViewBg2").fadeIn()
}
function confirmEnvent(id, medthod, url, isHide) {
	if (isHide !== "false") {
		$(id + " .alertViewBg").hide();
		$(id + " .alertViewBg2").hide()
	}
	if (medthod !== "" && medthod !== undefined) {
		medthod
	}
	if (url !== "" && url !== undefined) {
		window.location.href = url
	}
}
function closeAlert(id) {
	$(id + " .alertViewBg").fadeOut();
	$(id + " .alertViewBg2").fadeOut();
	if (id === "#page5") {
		setTimeout(function() {
			$("#page5 .alertBtnConfirm a").attr("onclick", "confirmEnvent('#page5',userproduct.sendOrder())");
			$("#page5 .alertMessage").html("您确定提交订单吗？")
		}, 1000)
	}
}
function mapInit(lon, la) {
	var map = new BMap.Map("contenttexts");
	var point = new BMap.Point(lon, la);
	var marker = new BMap.Marker(point);
	map.centerAndZoom(point, 16);
	map.addControl(new BMap.ZoomControl());
	map.addOverlay(marker);
	var traffic = new BMap.TrafficLayer();
	map.addTileLayer(traffic);
	map.setZoom(17)
}
$(document).on("click", "#goToDetailed", function() {
	$(".shoppingBack").attr("href", "#page2-2")
});
$(document).on("click", ".myProMenu", function() {
	if ($(this).parent().find("ul").attr("ishide") === "true") {
		$(this).parent().find("ul").hide();
		$(this).parent().find("span").html(">");
		$(this).parent().find("ul").attr("ishide", "false")
	} else {
		$(this).parent().find("ul").show();
		$(this).parent().find("ul").attr("ishide", "true");
		$(this).parent().find("span").html("∨")
	}
});

function menuClose() {
	var rigthMenu = $(".rigthMenu");
	if (rigthMenu.attr("data-isMenuBtnOpen") === "true") {
		rigthMenu.attr("data-isMenuBtnOpen", "false");
		$(".right-menu-list").hide()
	}
	poppage = "#" + location.hash.split("#", 2)[1]
}
$(document).on('click', '#adminselectorder', function() {
	var orderSearchOption = $(".orderSearchOption");
	if (orderSearchOption.attr("isOptionShow") === "true") {
		orderSearchOption.hide();
		orderSearchOption.attr("isOptionShow", "false")
	}
});

function setCustOrderKey(unum) {
	manageorder.userNum = unum;
	$("#aSOrderBack").attr('href', '#clientsearch')
}
function pullDownAction(method) {
	setTimeout(function() {
		method();
		myScroll.refresh()
	}, 100)
}
function pullUpAction(method) {
	setTimeout(function() {
		method();
		myScroll.refresh()
	}, 1000)
}
function loaded(mId, pullDown, pullUp, downmethod, upmethod, block, moffset) {
	pullDownEl = document.getElementById(pullDown);
	if (pullUp !== null) {
		pullUpEl = document.getElementById(pullUp)
	}
	myScroll = new iScroll(mId, {
		scrollbarClass: 'myScrollbar',
		hScroll: false,
		hScrollbar: false,
		useTransition: true,
		useTransform: true,
		topOffset: moffset,
		checkDOMChanges: true,
		onRefresh: function() {
			if (pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...'
			} else if (pullUp !== null) {
				if (pullUpEl.className.match('loading')) {
					pullUpEl.className = '';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...'
				}
			}
		},
		onBeforeScrollMove: function() {
			$("#" + block + "").show();
			$(".rigthMenu").attr("data-isMenuBtnOpen", "false");
			$(".right-menu-list").hide()
		},
		onScrollMove: function() {
			if (this.y > 5 && !pullDownEl.className.match('flip')) {
				pullDownEl.className = 'flip';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
				this.minScrollY = 0
			} else if (this.y < 5 && pullDownEl.className.match('flip')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
				this.minScrollY = -pullDownOffset
			} else if (pullUp !== null) {
				if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
					pullUpEl.className = 'flip';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
					this.maxScrollY = this.maxScrollY
				} else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
					pullUpEl.className = '';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
					this.maxScrollY = this.y
				}
			}
		},
		onScrollEnd: function() {
			if (pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';
				pullDownAction(downmethod)
			} else if (pullUp !== null) {
				if (pullUpEl.className.match('flip')) {
					pullUpEl.className = 'loading';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';
					pullUpAction(upmethod)
				}
			}
			$("#" + block + "").hide()
		},
		onTouchEnd: function() {
			$("#" + block + "").hide()
		}
	})
}(function() {
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
		this.setup()
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
			return ret
		},
		line: function(t, sx, sy, ex, ey) {
			return [(ex - sx) * t + sx, (ey - sy) * t + sy]
		}
	};
	var stepMethods = Sonic.stepMethods = {
		square: function(point) {
			this._.fillRect(point.x - 3, point.y - 3, 6, 6)
		}
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
			for (var i = -1, l = data.length; ++i < l;) {
				args = data[i].slice(1);
				method = data[i][0];
				if (method in argSignatures) for (var a = -1, al = args.length; ++a < al;) {
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
						break
					}
					args[a] = value
				}
				args.unshift(0);
				for (var r, pd = this.pointDistance, t = pd; t <= 1; t += pd) {
					t = Math.round(t / pd) / (1 / pd);
					args[0] = t;
					r = pathMethods[method].apply(null, args);
					this.points.push({
						x: r[0],
						y: r[1],
						progress: t
					})
				}
			}
			this.frame = 0
		},
		prep: function(frame) {
			if (frame in this.imageData) {
				return
			}
			this._.clearRect(0, 0, this.fullWidth, this.fullHeight);
			var points = this.points,
				pointsLength = points.length,
				point, index, frameD, indexD;
			this._setup();
			for (var i = -1, l = pointsLength * this.trailLength; ++i < l && !this.stopped;) {
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
				this.stepMethod(point, indexD, frameD)
			}
			this._teardown();
			this.imageData[frame] = (this._.getImageData(0, 0, this.fullWidth, this.fullWidth));
			return true
		},
		draw: function() {
			if (!this.prep(this.frame)) {
				this._.clearRect(0, 0, this.fullWidth, this.fullWidth);
				this._.putImageData(this.imageData[this.frame], 0, 0)
			}
			this.iterateFrame()
		},
		iterateFrame: function() {
			this.frame += this.stepsPerFrame;
			if (this.frame >= this.points.length) {
				this.frame = 0
			}
		},
		play: function() {
			this.stopped = false;
			var hoc = this;
			this.timer = setInterval(function() {
				hoc.draw()
			}, 1000 / this.fps)
		},
		stop: function() {
			this.stopped = true;
			this.timer && clearInterval(this.timer)
		}
	};
	window.Sonic = Sonic
}());
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
			this._.fill()
		},
		path: [
			['arc', 50, 50, 15, 0, 360]
		]
	}];
	var d, a, container = document.getElementById('in');
	for (var i = -1, l = loaders.length; ++i < l;) {
		d = document.createElement('div');
		d.className = 'l';
		a = new Sonic(loaders[i]);
		d.appendChild(a.canvas);
		container.appendChild(d);
		a.canvas.style.marginTop = (100 - a.fullHeight) / 2 + 'px';
		a.canvas.style.marginLeft = (100 - a.fullWidth) / 2 + 'px';
		a.play()
	}
});
var indexclass = Object.create(indexClass);
var productshow = Object.create(productShowClass);
var classlogin = Object.create(classLoginClass);
var registclass = Object.create(registClass);
var admingetprodata = Object.create(adminGetProDataClass);
var searchclass = Object.create(SearchClass);
var messageboards = (messageBoardsClass);
var userproduct = Object.create(userProductClass);
var serviceconnection = Object.create(serviceConnectionClass);
var classverifiction = Object.create(classVerifictionClass);
var phonedealwith = Object.create(phoneDealWithClass);
var classownerinfo = Object.create(OwnerInfoClass);
var manageorder = Object.create(ManageOrderClass);
var mydatabase = Object.create(operatingDatabaseClass);
var myenvetclass = Object.create(myEnvetClass);