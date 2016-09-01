var requestClass = {
    asynAjaxRequest:function(d, e, b, f, a, c) {
        if (d.toLowerCase() === "post") {
            a({
                method:"post",
                url:b,
                data:e,
                headers:{
                    "Content-Type":"application/x-www-form-urlencoded"
                },
                transformRequest:function(h) {
                    var i = [];
                    for (var g in h) {
                        i.push(encodeURIComponent(g) + "=" + encodeURIComponent(h[g]));
                    }
                    return i.join("&");
                }
            }).success(function(i, g, j, h) {
                f(i);
            }).error(function(i, g, j, h) {});
        } else {
            if (d.toLowerCase() === "get") {
                a({
                    method:"get",
                    url:b,
                    params:e
                }).success(function(i, g, j, h) {
                    f(i);
                }).error(function(i, g, j, h) {});
            }
        }
    }
};

var indexConnectClass = {
    isIndex:false,
    isIndexMenuOpen:false,
    indexSwiper:null,
    initPhoneBtn:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getOwnerInfo;
        var a = function(f) {
            if (f.status === "S") {
                var g = f.respData.phoneNum;
                if (g !== undefined && g !== null) {
                    g = "tel://" + f.respData.phoneNum.replace(/\s/g, "");
                }
                c.phoneBtn_CallBack(g);
            } else {}
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    getIndexBanner:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getBannerImg;
        var a = function(f) {
            if (f.status === "S") {
                c.bannerInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    getIndexNewProduct:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":1,
            "mpagingRequest.perPageUnitNum":5,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.newProInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    indexAllProBreviary:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.proInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var userAndAdminLoginClass = {
    userLoginState:false,
    isToShoppingCar:false,
    adminLoginState:false,
    reLogin:true,
    isLoginToIndex:false,
    isUserOrAdminBack:false,
    isRegister:false,
    isUserLogin:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.getIsLogin;
        var a = function(f) {
            if (f.status === "S") {
                c.isLogin_CallBack(true);
            } else {
                c.isLogin_CallBack(false);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userLogin:function(d, c, g, b) {
        var f = {
            custName:g,
            custPwd:b
        };
        var e = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userLogin;
        var a = function(h) {
            if (h.status === "S") {
                d.userLoginDone_CallBack(g);
            } else {
                d.showAlert("提 示", h.message);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", f, e, a, c, d);
    },
    testSetJushTagNalias:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetAliasNTags;
        var a = function(g) {
            if (g.status === "S") {
                try {
                    cordova.exec(pluginAlert, pluginAlert, "JpushClient", "setJpushAliasAndTags", [ g.respData.alias, g.respData.tags ]);
                } catch (f) {}
            } else {}
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userLoginOut:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.loginOut;
        var a = function(f) {
            if (f.status === "S") {
                window.history.back();
            } else {
                c.showAlert("提 示", "注销失败!");
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userModifyPass:function(d, c, a, e) {
        var g = {
            oldPwd:a,
            newPwd:e
        };
        var f = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userUpdatePwd;
        var b = function(h) {
            if (h.status === "S") {
                d.modifyPassDone_CallBakc();
            } else {
                if (h.message === "您还没有登录") {
                    d.userLoginLoad();
                    d.clearData();
                } else {
                    d.showAlert("提 示", h.message);
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", g, f, b, c, d);
    },
    isAdminLogin:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getIsLogin;
        var a = function(f) {
            if (f.status === "S") {
                c.isaLogin_CallBack(true);
            } else {
                c.isaLogin_CallBack(false);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminLogin:function(c, b) {
        var e = {
            adminName:c.alogin.adminName,
            adminPwd:c.alogin.adminPass
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminLogin;
        var a = function(f) {
            if (f.status == "S") {
                c.adminLoginDone_CallBack();
            } else {
                c.showAlert("提 示", f.message);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminLoginOut:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.loginOut;
        var a = function(f) {
            if (f.status === "S") {
                try{
                    c.refresh();
                }catch (e){
                    window.history.back();
                }
            } else {
                c.showAlert("提 示", "退出失败!");
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    isAdminLegality:function(d, c, a, e) {
        var g = {
            oldPwd:a,
            newPwd:e
        };
        var f = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminUpdatePwd;
        var b = function(h) {
            if (h.status === "S") {
                d.amodifyPassDone_CallBack();
            } else {
                if (h.message === "您还没有登录") {
                    d.admLoginLode();
                    d.clearData();
                } else {
                    d.showAlert("提 示", h.message);
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", g, f, b, c, d);
    }
};

var registClass = {
    userRegist:function(c, b) {
        var e = {
            custName:c.register.rPhone
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userExistCustname;
        var a = function(g) {
            if (g.status === "S") {
                if (g.respData === false) {
                    var i = {
                        "mcustomer.customer.custName":c.register.rPhone,
                        "mcustomer.customer.password":c.register.rPass,
                        "mcustomer.customer.contactPerson":c.register.rName,
                        "mcustomer.customer.phoneNum":c.register.rPhone,
                        "mcustomer.checkCode":c.register.rverifi
                    };
                    var h = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userReg;
                    var f = function(j) {
                        if (j.status === "S") {
                            c.registerDone_CallBack(c.register.rPhone, c.register.rPass);
                        } else {
                            c.showAlert("提 示", j.message);
                        }
                    };
                    getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", i, h, f, b, c);
                } else {
                    c.showAlert("提 示", "该手机号码已存在!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userLoginInfo:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetCust;
        var a = function(f) {
            if (f.status === "S") {
                c.infoInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                } else {
                    c.showAlert("提 示", "服务器繁忙!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userGetInfo:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetCust;
        var a = function(f) {
            if (f.status === "S") {
                c.userInfoInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                } else {
                    c.showAlert("提 示", "服务器繁忙!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userUpdateInfo:function(c, b) {
        var e = {
            "customer.companyName":c.modify.userCompany,
            "customer.contactPerson":c.modify.userName,
            "customer.phoneNum":c.modify.userPhone,
            "customer.address":c.modify.userAddress
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userUpdateCust;
        var a = function(f) {
            if (f.status === "S") {
                c.updateUserInfoDone_CallBack();
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                } else {
                    c.showAlert("提 示", f.message);
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userGetVerifiCodes: function(scope,http){
        var param = {
            mobileNum: scope.register.rPhone
        };
        var url = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetVerifiCode;
        var method = function(data){
            scope.getVerfiCode_CallBack();
        }
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", param, url, method, http, scope);
    }

};

var detailedConnectClass = {
    getDetailed:function(c, d, b) {
        var f = {};
        var e = httpUrl + publicParameterObj.parameters.userGetProductInfo + c;
        var a = function(g) {
            d.detailedInit_CallBack(g);
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("get", f, e, a, b, d);
    },
    isCom:function(c, b) {
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getSetting;
        var e = {};
        var a = function(f) {
            if (f.status === "S" && f.respData === true) {
                publicParameterObj.parameters.isComShopping = true;
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var productClass = {
    getProduct:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "sortParam.sortType": c.sortType,
            "sortParam.sortBy": c.sortBy,
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.productInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    getProductMore:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "sortParam.sortType": c.sortType,
            "sortParam.sortBy": c.sortBy,
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.productLoadMore_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var proSearchClass = {
    proMenuIconLayout:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProCats;
        var a = function(f) {
            if (f.status === "S") {
                c.categoryInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userSearchPro:function(c, b, e, d) {
        getOrPostRequestObj.adminClientSearchConnect.searchKey = c;
        var g = {
            "prodSearch.prodName":getOrPostRequestObj.adminClientSearchConnect.searchKey,
            "prodSearch.prodCatId":b,
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var f = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(h) {
            if (h.status === "S") {
                e.showSearchResInit_CallBack(h);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", g, f, a, d, e);
    },
    userSearchMore:function(c, b, e, d) {
        getOrPostRequestObj.adminClientSearchConnect.searchKey = c;
        var g = {
            "prodSearch.prodName":getOrPostRequestObj.adminClientSearchConnect.searchKey,
            "prodSearch.prodCatId":b,
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":e.pageNum
        };
        var f = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(h) {
            if (h.status === "S") {
                e.searchResLoadMore_CallBack(h);
            } else {
                e.showAlert("提 示", h.message);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", g, f, a, d, e);
    }
};

var messageClass = {
    getMessage:function(c, b) {
        var e = {
            "guestBookSearch.createDateFrom":"",
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetGuestBooks;
        var a = function(f) {
            if (f.status === "S") {
                c.messageInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    messageLoadMore:function(c, b) {
        var e = {
            "guestBookSearch.createDateFrom":"",
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetGuestBooks;
        var a = function(f) {
            if (f.status === "S") {
                c.messageLoadMore_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    sendMessage:function(c, b) {
        var e = {
            "guestBook.content":c.iMeassage
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userAddGuestBook;
        var a = function(f) {
            if (f.status === "S") {
                c.sendMessageDone_CallBack();
            } else {
                c.showAlert("提 示", "发表留言失败!");
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var OwnerInfoClass = {
    lati:0,
    longi:0,
    getEnterpriseInfo:function() {},
    getAboutInfo:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getOwnerInfo;
        var a = function(f) {
            if (f.status === "S") {
                c.aboutInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    getContactInfo:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getOwnerInfo;
        var a = function(f) {
            if (f.status === "S") {
                c.contactInit_CallBack(f);
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var shoppingCarClass = {
    getShoppingInfo:function(c, b) {
        var e = {
            prodNum:c.iProNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetProductInfos;
        var a = function(f) {
            if (f.status === "S") {
                c.shoppingCarInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c, c.proIndex);
    },
    sendOrder:function(c, b) {
        var e = {
            prodQtys:c.sendjson,
            deliverAddr : c.data.addr
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userAddOrder;
        var a = function(f) {
            if (f.status === "S") {
                c.sendOrder_CallBack();
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                } else {
                    c.showAlert("提 示", "提交订单失败!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var superProClass = {
    superProList:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetSuperPro;
        var a = function(f) {
            if (f.status === "S") {
                c.superInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    superProListLoadMore:function(c, b) {
        var e = {
            "prodSearch.prodName":"",
            "prodSearch.newFlag":-1,
            "prodSearch.hotFlag":-1,
            "mpagingRequest.perPageUnitNum":14,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetSuperPro;
        var a = function(f) {
            if (f.status === "S") {
                c.superLoadMore_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var userWaitingAuditClass = {
    userShowWaitingList:function(c, b) {
        var e = {
            "orderSearch.custNum":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userWaitingOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.waOrderInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userWaitingListLoadMore:function(c, b) {
        var e = {
            "orderSearch.custNum":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userWaitingOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.waOrderLoadMore_CallBack(f);
            } else {
                if (f.message === "你还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var myOrderClass = {
    userShowOrderList:function(c, b) {
        var e = {
            "orderSearch.custNum":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.myOrderInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    userMyOrderLoadMore:function(c, b) {
        var e = {
            "orderSearch.custNum":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.myOrderLoadMore_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.userLoginLoad();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var adminInfoClass = {
    getAdminInfo:function(c, b) {
        var e = {};
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminInfo;
        var a = function(f) {
            if (f.status === "S") {
                c.adminInfo_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var adminSelectOrderClass = {
    aUserCompany:"",
    aUserPhoneNum:"",
    adminShowOrderList:function(c, b) {
        var e = {
            "orderSearch.custNum":c.iCustNum,
            "orderSearch.custCompanyName":getOrPostRequestObj.adminSelectOrderConnect.aUserCompany,
            "orderSearch.phoneNum":getOrPostRequestObj.adminSelectOrderConnect.aUserPhoneNum,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1,
            "orderSearch.deliverStatus":-1,
            "orderSearch.cashStatus":-1,
            "orderSearch.settleStatus":-1
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGetOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminOrderInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminSelOrderLoadMore:function(c, b) {
        var e = {
            "orderSearch.custNum":c.iCustNum,
            "orderSearch.custCompanyName":getOrPostRequestObj.adminSelectOrderConnect.aUserCompany,
            "orderSearch.phoneNum":getOrPostRequestObj.adminSelectOrderConnect.aUserPhoneNum,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":c.pageNum,
            "orderSearch.deliverStatus":-1,
            "orderSearch.cashStatus":-1,
            "orderSearch.settleStatus":-1
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGetOrderList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminOrderLoadMore_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminGetOrderInfo:function(c, b) {
        var e = {
            orderNum:c.iOrderId
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGetOrderInfo;
        var a = function(f) {
            if (f.status === "S") {
                c.aOrderInfoInit_CallBack(f.respData.order);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var adminWaitingAuditClass = {
    adminWaitingAuditList: function(scope,http){
        var param = {
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": 1
        };
        var url = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGetWaitingAudit;
        var fun = function(data){
            if(data.status === "S"){
                scope.aWaitingAuditInit_CallBack(data);
            }else{
                if(data.message === "您还没有登录"){
                    scope.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", param, url, fun, http, scope);
    },

    adminWaitingAuditLoadMore: function(scope,http){
        var param = {
            "mpagingRequest.perPageUnitNum": 9,
            "mpagingRequest.currentPage": scope.pageNum
        };
        var url = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGetWaitingAudit;
        var fun = function(data){
            if(data.status === "S"){
                scope.aWaitingAuditLoad_CallBack(data);
            }else{
                if(data.message === "您还没有登录"){
                    scope.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", param, url, fun, http, scope);
    },

    adminGenerate: function(scope,http){
        var param = {
            origOrderNum: scope.orderNum
        };
        var url = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminGenerateOrder;
        var fun = function(data){
            if(data.status === "S"){
                scope.generateOrderDone_CallBack(data);
            }else{
                if(data.message === "您还没有登录"){
                    scope.admLoginLode();
                }else{
                    scope.generateOrderDone_CallBack(data);
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", param, url, fun, http, scope);
    }
};

var adminProManageClass = {
    pageNum:0,
    aNameKey:"",
    adminGetProList:function(c, b) {
        var e = {
            "prodSearch.prodName":c.aProManage.searchVal,
            "prodSearch.isPublic":-1,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminProManageInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminProListLoadMore:function(c, b) {
        var e = {
            "prodSearch.prodName":c.aProManage.searchVal,
            "prodSearch.isPublic":-1,
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.userGetProductList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminProManageLoadMore_CallBack(f);
            } else {
                if (f.message === "你还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    updatePrice:function(c, b) {
        var e = {
            "prodPrice.prodNum":c.iProId,
            "prodPrice.prodPrice":c.iProVlaue
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminUpadtePrice;
        var a = function(f) {
            if (f.status === "S") {
                c.showAlert("提 示", "更新成功!");
                c.updatePriceDone_CallBack();
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                } else {
                    c.showAlert("提 示", "价格更新失败!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    updateNum:function(c, b) {
        var e = {
            "product.prodNum":c.iProId,
            "product.dispStockBalance":c.iProVlaue
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminUpdateStockBalance;
        var a = function(f) {
            if (f.status === "S") {
                c.showAlert("提 示", "更新成功!");
                c.updateNumDone_CallBack();
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                } else {
                    c.showAlert("提 示", "数量更新失败!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var adminClientSearchClass = {
    isSuccess:false,
    searchKey:"",
    searchName:"",
    searchArea:"",
    searchPhone:"",
    searchUserKey:1,
    adminSearchUserInfo:function(c, b) {
        var e = {
            "custSearch.contactPerson":getOrPostRequestObj.adminClientSearchConnect.searchName,
            "custSearch.address":getOrPostRequestObj.adminClientSearchConnect.searchArea,
            "custSearch.phoneNum":getOrPostRequestObj.adminClientSearchConnect.searchPhone,
            "custSearch.orderDate":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":1
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminUserList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminClientInit_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                } else {
                    c.showAlert("提 示", "搜素出错!");
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    },
    adminUserInfoLoadMore:function(c, b) {
        var e = {
            "custSearch.contactPerson":getOrPostRequestObj.adminClientSearchConnect.searchName,
            "custSearch.address":getOrPostRequestObj.adminClientSearchConnect.searchArea,
            "custSearch.phoneNum":getOrPostRequestObj.adminClientSearchConnect.searchPhone,
            "custSearch.orderDate":"",
            "mpagingRequest.perPageUnitNum":9,
            "mpagingRequest.currentPage":c.pageNum
        };
        var d = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.adminUserList;
        var a = function(f) {
            if (f.status === "S") {
                c.adminClientLoadMore_CallBack(f);
            } else {
                if (f.message === "您还没有登录") {
                    c.admLoginLode();
                }
            }
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", e, d, a, b, c);
    }
};

var adminPayClass = {
    admGetPayTypes: function(scope,http){
        var param = {
        };
        var url = publicParameterObj.parameters.adminUrlHead + publicParameterObj.parameters.getPayType;
        var method = function(data){
            if(data.status === "S"){
                if(data.respData.canPay === "Y"){
                    scope.pay_callBack(true,data);
                }else{}
            }else{}
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", param, url, method, http, scope);
    }

};

var getOrPostRequest = {
    ajaxRquest:Object.create(requestClass),
    indexConnect:Object.create(indexConnectClass),
    userAndAdminSignIn:Object.create(userAndAdminLoginClass),
    detailedConnect:Object.create(detailedConnectClass),
    productConnect:Object.create(productClass),
    proSearchConnec:Object.create(proSearchClass),
    messageConnect:Object.create(messageClass),
    orderInfoConnect:Object.create(OwnerInfoClass),
    registConnect:Object.create(registClass),
    shoppingCarConnect:Object.create(shoppingCarClass),
    superProConnect:Object.create(superProClass),
    userWaitingAuditConnect:Object.create(userWaitingAuditClass),
    myOrderConnect:Object.create(myOrderClass),
    adminSelectOrderConnect:Object.create(adminSelectOrderClass),
    adminWaitingAuditConnect:Object.create(adminWaitingAuditClass),
    adminProManageConnect:Object.create(adminProManageClass),
    adminClientSearchConnect:Object.create(adminClientSearchClass),
    adminInfoConnect:Object.create(adminInfoClass),
    adminPayConnect:Object.create(adminPayClass)
};

var getOrPostRequestObj = Object.create(getOrPostRequest);