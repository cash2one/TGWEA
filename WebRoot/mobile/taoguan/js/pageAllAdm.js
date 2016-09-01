
/*Public PageEvt{*/
//数据库事件
var operatingDatabaseEvent = {
    //创建表
    crateTable:function() {
        if (localStorage.getItem(publicParameterObj.parameters.userName) == undefined) {
            var jsondata = [];
            localStorage.setItem(publicParameterObj.parameters.userName, JSON.stringify(jsondata));
        } else {}
    },
//添加数据
    insertData:function(id, number, scope) {
        var jsondata = JSON.parse(localStorage.getItem(publicParameterObj.parameters.userName));
        var datacount = jsondata.length;
        for (var i = 0, len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid == id) {
                scope.showAlert("提 示", "这件商品已存在购物车中!");
                return;
            }
        }
        jsondata.push({
            myid:id,
            mynumber:number
        });
        localStorage.setItem(publicParameterObj.parameters.userName, JSON.stringify(jsondata));
        if (jsondata.length > datacount) {
            scope.viewStates.setShoppingCarState(false);
            scope.showAlert("提 示", "添加成功!");
        } else {
            scope.showAlert("提 示", "添加失败!");
        }
    },
    //查询数据
    selectData:function() {
        var jsondata = JSON.parse(localStorage.getItem(publicParameterObj.parameters.userName));
        return jsondata;
    },
    //更新数据
    updateData:function(id, number) {
        var jsondata = JSON.parse(localStorage.getItem(publicParameterObj.parameters.userName));
        for (var i = 0, len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid === id) {
                if (jsondata[i].mynumber != number) {
                    jsondata[i].mynumber = number;
                    localStorage.setItem(publicParameterObj.parameters.userName, JSON.stringify(jsondata));
                    return;
                }
                return;
            }
        }
    },
    //删除数据
    deleteItemData:function(id) {
        var jsondata = JSON.parse(localStorage.getItem(publicParameterObj.parameters.userName));
        for (var i = 0, len = jsondata.length; i < len; i++) {
            if (jsondata[i].myid === id) {
                jsondata.splice(i, 1);
                localStorage.setItem(publicParameterObj.parameters.userName, JSON.stringify(jsondata));
                return;
            }
        }
    },
    //删除数据
    deleteallData:function() {
        localStorage.removeItem(publicParameterObj.parameters.userName);
        publicEventsObj.operatingDatabaseEvent.crateTable();
    }
};

var publicEventsClass = {
    operatingDatabaseEvent:Object.create(operatingDatabaseEvent)
};

var publicEventsObj = Object.create(publicEventsClass);
/*}*/

/*Index PageEvt{*/
var indexModule = angular.module("ionicApp", [ "ionic" ]);

var iconfig = function($stateProvider, $urlRouterProvider) {
    publicEventsObj.operatingDatabaseEvent.crateTable();
    $stateProvider.state("detailed",{
        url:"/detailed",
        templateUrl:"detailed.html",
        controller:"detailed"
    }).state("adminMenu",{
        url:"/adminMenu",
        templateUrl:"adminMenu.html",
        controller:"adminMenu"
    }).state("adminModifyPass",{
        url:"/adminModifyPass",
        templateUrl:"adminModifyPass.html",
        controller:"adminModifyPass"
    }).state("adminClient",{
        url:"/adminClient",
        templateUrl:"adminClientSearch.html",
        controller:"adminClient"
    }).state("adminProManage",{
        url:"/adminProManage",
        templateUrl:"adminProManage.html",
        controller:"adminProManage"
    }).state("adminSelectOrder",{
        url:"/adminSelectOrder",
        templateUrl:"adminSelectOrder.html",
        controller:"adminSelectOrder"
    }).state("historyOrder",{
        url:"/historyOrder",
        templateUrl:"historyOrder.html",
        controller:"historyOrder"
    }).state("adminOrderInfo",{
        url:"/adminOrderInfo",
        templateUrl:"adminOrderInfo.html",
        controller:"adminOrderInfo"
    });
    $urlRouterProvider.otherwise("/adminMenu");
};

var imainCtrl = function($scope, $http, $location, $timeout, $ionicPopup, $ionicPopover, $ionicModal, $ionicBackdrop,$ionicHistory) {
    $scope.acancelHide = false;
    $scope.abackHide = true;
    $scope.tabHide = true;
    $scope.tabBarHide = false;
    $scope.search = {};
    $scope.text = "<i class='ion-android-arrow-down icons'><span class='iconText'>正在加载</span></i>";
    $scope.sendMessageIsLogin = true;
    $scope.iMessageDatas = "";//留言
    $scope.indexIsShow = false;
    $scope.proIsShow = false;
    $scope.categoryIsShow = false;
    $scope.shoppingCarIsShow = false;
    if (localStorage.getItem("perSpCar") == undefined) {
        localStorage.setItem("perSpCar", 0);
    }
    $scope.perSpCar = localStorage.getItem("perSpCar") >> 0;

    $scope.viewStates = {};
    $scope.iState = false;

    var _admMenuState = false;
    var _admSelOrderState = false;
    var _admProManageState = false;
    var _admClientState = false;
    var _historyOrderState = false;

    $scope.viewStates.getAdmMenuState = function() {
        return _admMenuState;
    };
    $scope.viewStates.setAdmMenuState = function(state) {
        _admMenuState = state;
    };
    $scope.viewStates.getAdmSelOrderState = function() {
        return _admSelOrderState;
    };
    $scope.viewStates.setAdmSelOrderState = function(state) {
        _admSelOrderState = state;
    };
    $scope.viewStates.getAdmProManageState = function() {
        return _admProManageState;
    };
    $scope.viewStates.setAdmProManageState = function(state) {
        _admProManageState = state;
    };
    $scope.viewStates.getAdmClientState = function() {
        return _admClientState;
    };
    $scope.viewStates.setAdmClientState = function(state) {
        _admClientState = state;
    };
    $scope.viewStates.getHistoryOrderState = function() {
        return _historyOrderState;
    };
    $scope.viewStates.setHistoryOrderState = function(state) {
        _historyOrderState = state;
    };
    getOrPostRequestObj.detailedConnect.isCom($scope, $http);
    $scope.showAlert = function(title, text) {
       $scope.iShowAlert = $ionicPopup.alert({
            title:title,
            content:text,
            buttons:[ {
                text:"确 定",
                type:"alertCancel"
            } ]
        });
        $scope.iShowAlert.then(function(res) {});
    };
    $scope.setPerSpCar = function(num) {
        $scope.perSpCar = num;
        localStorage.setItem("perSpCar", num);
    };
    $scope.getPerSpCar = function() {
        var hisPerPage = localStorage.getItem("perSpCar");
        hisPerPage = !!hisPerPage ? parseInt(hisPerPage) :!!hisPerPage;
        $scope.perSpCar = hisPerPage;
        return $scope.perSpCar;
    };
    $scope.setCategory = function(num) {
        localStorage.setItem("isCategory", num);
    };
    $scope.getCategory = function() {
        var hisCatePage = localStorage.getItem("isCategory");
        return !!hisCatePage ? parseInt(hisCatePage) :!!hisCatePage;
    };
    $scope.setProduct = function(num) {
        localStorage.setItem("isProduct", num);
    };
    $scope.getProduct = function() {
        var hisProPage = localStorage.getItem("isProduct");
        return !!hisProPage ? parseInt(hisProPage) :!!hisProPage;
    };
    $scope.getIState = function() {
        return $scope.iState;
    };
    $scope.setIState = function(state) {
        $scope.iState = state;
    };
    $scope.back = function(num) {
        if (num !== undefined && num !== null && num != 0) {
            window.history.go(num);
            if ($scope.perSpCar > 2) {
                var perPage_s1 = $scope.perSpCar + num;
                $scope.setPerSpCar(perPage_s1);
            }
        } else {
            if ($scope.perSpCar > 0 && num != 0) {
                var perPage_s2 = $scope.perSpCar - 1;
                $scope.setPerSpCar(perPage_s2);
            }
            window.history.back();
        }
    };
    $scope.admLoginLode = function() {
        $timeout(function() {
            $scope.adminLoginShowHide(true);
        }, 500);
    };
    $scope.userLoginLoad = function() {
        $timeout(function() {
            $scope.userLoginShowHide(true);
        }, 500);
    };
    //页面正准备改变
    $scope.pageHide = function() {
        if ($scope.userLogin) {
            $scope.userLoginShowHide(false);
        }
        if ($scope.iregister) {
            $scope.userRegisterShowHide(false);
        }
    };
    $scope.$on("$stateChangeStart", function(event, toState) {
        publicParameterObj.parameters.loadingPage = 0; //产品页数初始化
        $scope.isIndex = toState.name === "index";
        $scope.indexIsShow = false;
        $scope.proIsShow = false;
        $scope.categoryIsShow = false;
        $scope.shoppingCarIsShow = false;
        $scope.navBarIsHide = false;
        $scope.isSpNewPage = true;

        if($ionicHistory.viewHistory().histories.root.cursor == -1){
            
                if(toState.name === "adminMenu"){
                    localStorage.removeItem("view");
                }
                if(localStorage.getItem("view") !== undefined && localStorage.getItem("view")!==null){
                    $ionicHistory.sviewHistory(JSON.parse(localStorage.getItem("view")));
                }
        }

        localStorage.setItem("view", JSON.stringify($ionicHistory.viewHistory()));

        if($scope.iShowAlert){
            $scope.iShowAlert.close();
        }
    });
    $scope.indexBarIconState = function() {
        $scope.indexIsShow = !$scope.indexIsShow;
    };
    $scope.proBarIconState = function() {
        $scope.proIsShow = !$scope.proIsShow;
    };
    $scope.categoryBarIconState = function() {
        $scope.categoryIsShow = !$scope.categoryIsShow;
    };
    $scope.shoppingCarIconState = function() {
        $scope.shoppingCarIsShow = !$scope.shoppingCarIsShow;
    };
    $ionicModal.fromTemplateUrl("adminLogin.html", function(adminLogin) {
        $scope.adminLogin = adminLogin;
    }, {
        scope:$scope,
        animation:"slide-in-up"
    });
    $scope.adminLoginShowHide = function(bool) {
        bool ? $scope.adminLogin.show() :$scope.adminLogin.hide();
    };
    $scope.editMessageShowHide = function(bool) {
        if (bool === true) {
            getOrPostRequestObj.userAndAdminSignIn.isUserLogin($scope, $http);
            $location.search({
                page:"editMessage"
            }).replace();
            $scope.editContent.show();
        } else {
            $location.search("").replace();
            $scope.editContent.hide();
        }
    };
    //延迟
    $scope.loadingImg = function() {
        function isIE() {
            return window.navigator.userAgent.toLowerCase().indexOf("msie") >= 1;
        }
        var _ie = isIE();
        (function() {
            var row = $$("mainContent");
            if (row !== undefined && row !== null && row.getElementsByTagName("img") !== undefined && row.getElementsByTagName("img") !== null) {
                var total = row.getElementsByTagName("img").length, cells = [];
                for (var i = 0, n = total; i < n; i++) {
                    var img = row.getElementsByTagName("img")[i];
                    if (img) {
                        img.setAttribute("_lazysrc", img.getAttribute("_lazysrc") + "?" + Math.random());
                        cells.push(img);
                    }
                }
                var lazy = new ImagesLazyLoad({
                    container:window,
                    mode:"vertical",
                    holder:"mobileImg/nopic.jpg",
                    onLoad:function(img) {
                        img.onload = function() {
                            showPic(this);
                        };
                    }
                });
                function showPic(img) {
                    var t = setInterval(function() {
                        var opacity = _ie ? img.filters.alpha.opacity :img.style.opacity * 100;
                        if (opacity < 100) {
                            _ie ? img.filters.alpha.opacity += 10 :img.style.opacity = (opacity + 10) / 100;
                        } else {
                            clearInterval(t);
                        }
                    }, 15);
                }
            }
        })();
    };
};

iconfig.$inject = [ "$stateProvider", "$urlRouterProvider" ];

indexModule.config(iconfig);

// /*}*/
imainCtrl.$inject = [ "$scope", "$http", "$location", "$timeout", "$ionicPopup", "$ionicPopover", "$ionicModal", "$ionicBackdrop","$ionicHistory" ];

indexModule.controller("mainCtrl", imainCtrl);

/*AdminClientSearch PageEvt{*/
indexModule.service("admClientService", function() {
    var service = {};
    var _nameClick = false;
    var _phoneClick = true;
    var _moreHide = true;
    var _loadingHide = false;
    var _searchKey = "";
    var _clients = "";
    var _pageNum = 2;
    service.getNameClick = function() {
        return _nameClick;
    };
    service.setNameClick = function(nameClick) {
        _nameClick = nameClick;
    };
    service.getPhoneClick = function() {
        return _phoneClick;
    };
    service.setPhoneClick = function(phoneClick) {
        _phoneClick = phoneClick;
    };
    service.getMoreHide = function() {
        return _moreHide;
    };
    service.setMoreHide = function(moreHide) {
        _moreHide = moreHide;
    };
    service.getLoadingHide = function() {
        return _loadingHide;
    };
    service.setLoadingHide = function(loadingHide) {
        _loadingHide = loadingHide;
    };
    service.getSearchKey = function() {
        return _searchKey;
    };
    service.setSearchKey = function(searchKey) {
        _searchKey = searchKey;
    };
    service.getClients = function() {
        return _clients;
    };
    service.setClients = function(clients) {
        _clients = clients;
    };
    service.getPageNum = function() {
        return _pageNum;
    };
    service.setPageNum = function(pageNum) {
        _pageNum = pageNum;
    };
    return service;
});


var adminClientCtrl = function($scope, $http, admClientService, $location, $timeout) {
    $scope.keyColor = "keyColor-link";
    $scope.keyColors = "keyColor-active";
    $scope.isNameClick = admClientService.getNameClick();
    $scope.isPhoneClick = admClientService.getPhoneClick();
    $scope.noMoreHide = admClientService.getMoreHide();
    $scope.loadingHide = admClientService.getLoadingHide();
    $scope.clientSearchEvt = null;
    $scope.pageNum = admClientService.getPageNum();
    $scope.aClient = {
        searchKey:admClientService.getSearchKey()
    };

    var _historySearch = admClientService.getSearchKey();
    var _isLodeMore = true;
    $scope.$on("$stateChangeStart", function() {
        $timeout.cancel($scope.loadHttp);
    });
    $scope.$on("$stateChangeSuccess", function(event, toState){
        if(toState.name === "adminClient"){
            if ($scope.viewStates.getAdmClientState() === false) {
                getOrPostRequestObj.adminClientSearchConnect.adminSearchUserInfo($scope,$http);
                $scope.viewStates.setAdmClientState(true);
            } else {
                $scope.iClients = admClientService.getClients();
                _isLodeMore = false;
            }
        }
    })
    $scope.adminClientInit_CallBack = function(data) {
        admClientService.setClients($scope.adminClientReturnData(data));
        $scope.iClients = admClientService.getClients();
        $scope.pageNum = 2;
        admClientService.setPageNum(2);
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
    };
    $scope.adminClientLoadMore_CallBack = function(data) {
        var idatas = $scope.adminClientReturnData(data);
        $scope.iClients = $scope.iClients.concat(idatas);
        admClientService.setClients($scope.iClients);
        $scope.pageNum++;
        admClientService.setPageNum($scope.pageNum);
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
    };
    $scope.adminClientLoadMore = function() {
        if ($scope.noMoreHide && _isLodeMore === false) {
            _isLodeMore = true;
            $scope.loadHttp = $timeout(function() {
                getOrPostRequestObj.adminClientSearchConnect.adminUserInfoLoadMore($scope,$http);
                $scope.$broadcast("scroll.infiniteScrollComplete");
            }, 1000);
        } else {
            $scope.$broadcast("scroll.infiniteScrollComplete");
        }
    };
    $scope.adminClientReturnData = function(data) {
        if (data.respData.dataList.length < 9) {
            $scope.noMoreHide = false;
            $scope.loadingHide = true;
            admClientService.setMoreHide(false);
            admClientService.setLoadingHide(true);
        }
        return data.respData.dataList;
    };
    $scope.searchTextChange = function() {
        admClientService.setSearchKey($scope.aClient.searchKey);
    };
    $scope.searchUser = function() {
        if (_historySearch !== $scope.aClient.searchKey) {
            getOrPostRequestObj.adminClientSearchConnect.searchName = "";
            getOrPostRequestObj.adminClientSearchConnect.searchPhone = "";
            $scope.pageNum = 1;
            admClientService.setPageNum(1);
            $scope.noMoreHide = true;
            $scope.loadingHide = false;
            if ($scope.isNameClick === false) {
                getOrPostRequestObj.adminClientSearchConnect.searchName = $scope.aClient.searchKey;
            } else {
                if ($scope.isPhoneClick === false) {
                    getOrPostRequestObj.adminClientSearchConnect.searchPhone = $scope.aClient.searchKey;
                }
            }
            getOrPostRequestObj.adminClientSearchConnect.adminSearchUserInfo($scope,$http);
            _isLodeMore = true;
        }
        _historySearch = $scope.aClient.searchKey;
    };
    $scope.clickKey = function(iCase) {
        $scope.isNameClick = true;
        $scope.isPhoneClick = true;
        switch (iCase) {
            case 1:
                $scope.isNameClick = !$scope.isNameClick;
                break;
            case 2:
                $scope.isPhoneClick = !$scope.isPhoneClick;
                break;
            default:
                break;
        }
        admClientService.setNameClick($scope.isNameClick);
        admClientService.setPhoneClick($scope.isPhoneClick);
    };
    $scope.searchUserOrder = function(index) {
        $scope.viewStates.setHistoryOrderState(false);
        $location.path("/historyOrder").search({
            custNum:$scope.iClients[index].custNum,
            custName:$scope.iClients[index].companyName
        });
    };

   
};
/*}*/

/*AdminLogin PageEvt{*/
var adminLoginCtrl = function($scope, $http, $location) {
    $scope.cancelHide = false;
    $scope.backHide = true;
    $scope.alogin = {};
    $scope.adminNameFocus = function() {
        $scope.anameStyle = {
            color:"#ef575c"
        };
    };
    $scope.adminNameBlur = function() {
        $scope.anameStyle = {
            color:"#294775"
        };
    };
    $scope.adminPassFocus = function() {
        $scope.apassStyle = {
            color:"#ef575c"
        };
    };
    $scope.adminPassBlur = function() {
        $scope.apassStyle = {
            color:"#294775"
        };
    };
    $scope.hideAdminLogin = function() {
        var location = $location.url().split("?")[0];
        switch (location) {
            case "/adminMenu":
                $scope.back();
                break;

            case "/adminModifyPass":
            case "/adminClient":
            case "/adminSelectOrder":
            // case "/adminWaitingAudit":
            case "/adminProManage":
                $scope.back(-2);
                break;

            case "/adminOrderInfo":
            case "/historyOrder":
                $scope.back(-3);
                break;

            default:
                $scope.adminLoginShowHide(false);
        }
    };
    $scope.toAdminMenu = function() {
        switch ($location.url().split("?")[0]) {
            case "/adminMenu":
            case "/adminModifyPass":
            case "/adminClient":
            case "/adminSelectOrder":
            case "/adminProManage":
            case "/adminOrderInfo":
                location.reload();
                break;
            // case "/adminWaitingAudit":
                

            default:
                $location.path("/adminMenu");
                break;
        }
    };
    $scope.adminLoginBtnEvt = function() {
        if ($scope.alogin.adminName === "" || $scope.alogin.adminName === undefined) {
            $scope.showAlert("提 示", "账号不能为空!");
        } else {
            if ($scope.alogin.adminPass === "" || $scope.alogin.adminPass === undefined) {
                $scope.showAlert("提 示", "密码不能为空!");
            } else {
                getOrPostRequestObj.userAndAdminSignIn.adminLogin($scope, $http);
            }
        }
    };
    $scope.adminLoginDone_CallBack = function() {
        $scope.toAdminMenu();
        $scope.alogin.adminPass = "";
    };
};
/*}*/

adminClientCtrl.$inject = [ "$scope", "$http", "admClientService", "$location", "$timeout" ];

var adminClientarr = [ "$scope", "$http", "admClientService", "$location", "$timeout", adminClientCtrl ];

indexModule.controller("adminClient", adminClientarr);

/*AdminMenu PageEvt{*/
indexModule.service("adminMenuService", function() {
    var service = {};
    var _company = "未登录";
    var _name = "";
    service.getCompany = function() {
        return _company;
    };
    service.setCompany = function(company) {
        _company = company;
    };
    service.getName = function() {
        return _name;
    };
    service.setName = function(name) {
        _name = name;
    };
    return service;
});

var adminMenuCtrl = function($scope,$http,adminMenuService,$ionicPopup,$location,$timeout) {
    $scope.adminCompany = adminMenuService.getCompany();
    $scope.adminName = adminMenuService.getName();
    $scope.$on("$stateChangeStart", function() {
        if($scope.admMenuConfirms){
            $scope.admMenuConfirms.close();
        }
    });
    $scope.$on("$stateChangeSuccess",function(event, toState){
        if(toState === "adminMenu"){
            $scope.viewStates.setAdmSelOrderState(false);
            $scope.viewStates.setAdmProManageState(false);
            $scope.viewStates.setAdmSelOrderState(false);
        }
    });
    $scope.admMenuConfirm = function() {
        $scope.admMenuConfirms = $ionicPopup.confirm({
            title:"提 示",
            content:"您确定要退出登录吗?",
            buttons:[ {
                text:"取 消",
                type:"alertCancel",
                onTap:function(e) {
                    return false;
                }
            }, {
                text:"确 定",
                type:"alertComfirm",
                onTap:function(e) {
                    return true;
                }
            } ]
        });
        $scope.admMenuConfirms.then(function(res) {
            if (res) {
                adminMenuService.setCompany("未登录");
                adminMenuService.setName("");
                $scope.adminCompany = "未登陆";
                $scope.adminName = "";
                getOrPostRequestObj.userAndAdminSignIn.adminLoginOut($scope,$http);
                $scope.viewStates.setAdmMenuState(false);
                $scope.viewStates.setAdmClientState(false);
                $scope.viewStates.setAdmProManageState(false);
                $scope.viewStates.setAdmSelOrderState(false);
            } else {}
        });
    };
    $scope.adminInfo_CallBack = function(data) {
        $scope.adminCompany = data.respData.companyName;
        $scope.adminName = data.respData.adminName;
        adminMenuService.setCompany(data.respData.companyName);
        adminMenuService.setName(data.respData.adminName);
        $scope.viewStates.setAdmMenuState(true);
    };
    $scope.adminOutLogin = function() {
        $scope.admMenuConfirm();
    };
    $scope.admList = function(index) {
        switch (index) {
            case 0:
                $location.path("/adminSelectOrder");
                break;
//            case 1:
//                $location.path("/adminWaitingAudit");
//                break;
            case 1:
                $location.path("/adminProManage");
                break;

            case 2:
                $location.path("/adminClient");
                break;
                
            case 3:
                $location.path("/adminModifyPass");
                break;
        }
    };
    $scope.refresh=function(){
        $timeout(function(){
            getOrPostRequestObj.adminInfoConnect.getAdminInfo($scope,$http)
        },500);
    };
    if ($scope.viewStates.getAdmMenuState() === false) {
        $timeout(function() {
            getOrPostRequestObj.adminInfoConnect.getAdminInfo($scope,$http);
        }, 500);
    }
};
/*}*/

adminLoginCtrl.$inject = [ "$scope", "$http", "$location" ];

indexModule.controller("adminLoginCtrl", adminLoginCtrl);

/*AdminModifyPass PageEvt{*/
var adminModifyPassCtrl = function($scope, $http, $ionicLoading) {
    var foucsStyle = {
        color:"#ef575c"
    };
    var blurStyle = {
        color:"#294775"
    };

    $scope.aupdatePass = {};
    $scope.aoldPassFocus = function() {
        $scope.aoldPassStyle = foucsStyle;
    };
    $scope.aoldPassBlur = function() {
        $scope.aoldPassStyle = blurStyle;
    };
    $scope.anewPassFocus = function() {
        $scope.anewPassStyle = foucsStyle;
    };
    $scope.anewPassBlur = function() {
        $scope.anewPassStyle = blurStyle;
    };
    $scope.anewPassCFocus = function() {
        $scope.anewPassCStyle = foucsStyle;
    };
    $scope.anewPassCBlur = function() {
        $scope.anewPassCStyle = blurStyle;
    };
    $scope.clearData = function() {
        $scope.aupdatePass.oldPass = "";
        $scope.aupdatePass.newPass = "";
        $scope.aupdatePass.newPassC = "";
    };
    $scope.amodifyPassDone = function() {
        $ionicLoading.show({
            template:"<div>密码修改成功!</div>",
            delay:100,
            duration:1000
        });
    };
    $scope.amodifyPassDone_CallBack = function() {
        $scope.amodifyPassDone();
        window.history.back();
    };
    $scope.asendNewPass = function() {
        if (privateVerifictionObj.verifiction.isLetterAndNum($scope.aupdatePass.oldPass) === false) {
            $scope.showAlert("提 示", "旧密码输入错误，只能由数字或字母组成!");
        } else {
            if (privateVerifictionObj.verifiction.isLetterAndNum($scope.aupdatePass.newPass) === false || $scope.aupdatePass.newPass === undefined) {
                $scope.showAlert("提 示", "新密码输入错误，只能由数字或字母组成!");
            } else {
                if ($scope.aupdatePass.newPass !== $scope.aupdatePass.newPassC) {
                    $scope.showAlert("提 示", "新密码两次输入不一致!");
                } else {
                    getOrPostRequestObj.userAndAdminSignIn.isAdminLegality($scope, $http, $scope.aupdatePass.oldPass, $scope.aupdatePass.newPass);
                }
            }
        }
    };
};
/*}*/

adminMenuCtrl.$inject = [ "$scope", "$http", "adminMenuService", "$ionicPopup", "$location", "$timeout" ];

var adminMenuCtrlarr = [ "$scope", "$http", "adminMenuService", "$ionicPopup", "$location", "$timeout", adminMenuCtrl ];

indexModule.controller("adminMenu", adminMenuCtrlarr);

/*AdminOrderInfo PageEvt{*/
var adminOrderInfoCtrl = function($scope, $http, $location, $timeout) {
    $scope.iOrderId = $location.search().orderId;
    $scope.toDetailed = function(proId) {
        $location.path("/detailed").search({
            proNum:proId,
            hisPage:1
        });
    };
    $scope.aOrderInfoInit_CallBack = function(data) {
        var idata = [], item = {}, iPros = [], tempporarySpace;
        for (var j = 0, lens = data.orderItemList.length; j < lens;j++) {
            item = {
                proId:data.orderItemList[j].prodNum,
                img:privateVerifictionObj.verifiction.imgLink(data.orderItemList[j].whereimg),
                name:data.orderItemList[j].prodName,
                num:"订购数量 : " + data.orderItemList[j].cases,
                price:"¥" + data.orderItemList[j].custProdPrice
            };
            iPros.push(item);
        }
        tempporarySpace = {
            orderNum:data.orderNum,
            userName:data.custName,
            proCount:data.orderItemList.length,
            proPrices:"¥" + data.custPriceTotal,
            cashState:data.cashStatusName,
            cashType:data.cashTypeName,
            deliveryState:data.deliverStatusName,
            date:data.createDate,
            iPros:iPros
        };
        idata.push(tempporarySpace);
        $scope.aOrderInfos = idata;
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
    };
    getOrPostRequestObj.adminSelectOrderConnect.adminGetOrderInfo($scope,$http);
};
/*}*/

adminModifyPassCtrl.$inject = [ "$scope", "$http", "$ionicLoading" ];

indexModule.controller("adminModifyPass", adminModifyPassCtrl);

/*AdminProManage PageEvt{*/
indexModule.service("admProManageService", function() {
    var service = {};
    var _searchText = "";
    var _data = {};
    var _moreHide = true;
    var _loadingHide = false;
    var _aEditPros = "";
    var _pageNum = 2;

    service.getSearchText = function() {
        return _searchText;
    };
    service.setSearchText = function(searchText) {
        _searchText = searchText;
    };
    service.getData = function() {
        return _data;
    };
    service.setData = function(data) {
        _data = data;
    };
    service.getMoreHide = function() {
        return _moreHide;
    };
    service.setMoreHide = function(moreHide) {
        _moreHide = moreHide;
    };
    service.getLoadingHide = function() {
        return _loadingHide;
    };
    service.setLoadingHide = function(loadingHide) {
        _loadingHide = loadingHide;
    };
    service.getaEditPros = function() {
        return _aEditPros;
    };
    service.setaEditPros = function(aEditPros) {
        _aEditPros = aEditPros;
    };
    service.getPageNum = function() {
        return _pageNum;
    };
    service.setPageNum = function(pageNum) {
        _pageNum = pageNum;
    };
    return service;
});

var adminProManageCtrl = function($scope,$http,admProManageService,$location,$ionicPopup,$timeout) {
    $scope.aProManage = {
        searchVal:admProManageService.getSearchText()
    };
    $scope.iProId = "";
    $scope.iProVlaue = "";
    $scope.pricePrompt = "";
    $scope.pricePrompt1 = "";
    $scope.numPrompt = "";
    $scope.index = 0;
    $scope.data = admProManageService.getData();
    $scope.noMoreHide = admProManageService.getMoreHide();
    $scope.loadingHide = admProManageService.getLoadingHide();
    $scope.manageSearchEvt = null;
    $scope.pageNum = admProManageService.getPageNum();
    var _historySearchText = admProManageService.getSearchText();
    var _isLodeMore = true;

    $scope.$on("$stateChangeStart", function(event, toState) {
        if($scope.iPrompt){
            $scope.iPrompt.close();
        }
        if($scope.iPrompt1) {
            $scope.iPrompt1.close();
        }
        $timeout.cancel($scope.loadHttp);

        if(toState.name !== "detailed" && toState.name === "adminProManage"){
            $scope.viewStates.setAdmProManageState(false);
        }
    });
    $scope.$on("$stateChangeSuccess",function(event, toState){
        if(toState.name === "adminProManage"){
            if ($scope.viewStates.getAdmProManageState() === false) {
                getOrPostRequestObj.adminProManageConnect.adminGetProList($scope,$http);
                $scope.viewStates.setAdmProManageState(true);
            } else {
                $scope.aEditPros = admProManageService.getaEditPros();
                _isLodeMore = false;
                $timeout(function() {
                    $scope.loadingImg();
                }, 500);
            }
        }
    });


    $scope.toDetailed = function(index) {
        $location.path("/detailed").search({
            proNum:index,
            hisPage:1
        });
    };
    $scope.updatePrice = function(index) {
        $scope.index = index;
        $scope.data.price = $scope.aEditPros[index].price.replace("¥", "");
        $scope.iPrompt = $ionicPopup.prompt({
            title:"修改产品价格",
            template:"<div class='item-input-inset alertInputView'><label class='item-input-wrapper alertInput'><input ng-model='data.price' type='text' class='ng-pristine ng-valid text-center'></label></div><h3 class='text-center assertive errText' ng-bind='pricePrompt'></h3><h4 class='text-center assertive errText' ng-bind='pricePrompt1'></h4>",
            scope:$scope,
            buttons:[ {
                text:"取 消",
                type:"alertCancel",
                onTap:function(e){
                    return false;
                }
            }, {
                text:"确 定",
                type:"alertComfirm",
                onTap:function(e) {
                    if ($scope.data.price === "" || $scope.data.price === undefined) {
                        $scope.pricePrompt = "价格不能为空!";
                        $scope.pricePrompt1 = "";
                        e.preventDefault();
                    } else {
                        if($scope.data.price < 0.1 || $scope.data.price > 9999999){
                            $scope.pricePrompt = "价格必须大于0.1且小于1000万";
                            $scope.pricePrompt1 = "";
                            e.preventDefault();
                        } else {
                            if (privateVerifictionObj.verifiction.isFloat($scope.data.price) === false) {
                                $scope.pricePrompt = "价格输入有误!";
                                $scope.pricePrompt1 = "注:小数点后只允许2位小数.";
                                e.preventDefault();
                            } else {
                                return true;
                            }
                        }
                       
                    }
                }
            } ]
        });
        $scope.iPrompt.then(function(res) {
            if (res) {
                $scope.iProId = $scope.aEditPros[index].proId;
                $scope.iProVlaue = $scope.data.price;
                getOrPostRequestObj.adminProManageConnect.updatePrice($scope,$http);
            } else {}
            $scope.pricePrompt = "";
            $scope.pricePrompt1 = "";
        });
        admProManageService.setData($scope.data);
    };
    $scope.updateNum = function(index) {
        $scope.index = index;
        $scope.data.num = $scope.aEditPros[index].num;
        $scope.iPrompt1 = $ionicPopup.prompt({
            title:"修改产品数量",
            template:"<div class='item-input-inset alertInputView'><label class='item-input-wrapper alertInput'><input ng-model='data.num' type='text' class='ng-pristine ng-valid text-center'></label></div><h3 class='text-center assertive errText' ng-bind='numPrompt'></h3>",
            scope:$scope,
            buttons:[{
                text:"取 消",
                type:"alertCancel",
                onTap:function(e) {
                    return false;
                }
            }, {
                text:"确 定",
                type:"alertComfirm",
                onTap:function(e) {
                    if ($scope.data.num === "" || $scope.data.num === undefined) {
                        $scope.numPrompt = "数量不能为空!";
                        e.preventDefault();
                    } else {
                        if($scope.data.num < 1 || $scope.data.num > 999999){
                            $scope.numPrompt = "数量必须大于1且小于99万!";
                            e.preventDefault();
                        }
                        if (privateVerifictionObj.verifiction.isInt($scope.data.num) === false) {
                            $scope.numPrompt = "数量输入有误!";
                            e.preventDefault();
                        } else {
                            return true;
                        }
                    }
                }
            } ]
        });
        $scope.iPrompt1.then(function(res) {
            if (res) {
                $scope.iProId = $scope.aEditPros[index].proId;
                $scope.iProVlaue = $scope.data.num;
                getOrPostRequestObj.adminProManageConnect.updateNum($scope,$http);
            } else {}
            $scope.numPrompt = "";
        });
        admProManageService.setData($scope.data);
    };
    $scope.searchChange = function() {
        admProManageService.setSearchText($scope.aProManage.searchVal);
    };
    $scope.aProManageSearch = function() {
        if ($scope.aProManage.searchVal !== _historySearchText) {
            getOrPostRequestObj.adminProManageConnect.adminGetProList($scope, $http);
            $scope.pageNum = 1;
            admProManageService.setPageNum(1);
            $scope.noMoreHide = true;
            $scope.loadingHide = false;
            admProManageService.setMoreHide(true);
            admProManageService.setLoadingHide(false);
            _isLodeMore = true;
        }
        _historySearchText = $scope.aProManage.searchVal;
    };
    $scope.adminProManageInit_CallBack = function(data) {
        admProManageService.setaEditPros($scope.adminProManageRetrunData(data));
        $scope.aEditPros = admProManageService.getaEditPros();
        $scope.pageNum = 2;
        admProManageService.setPageNum(2);
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
    };
    $scope.adminProManageLoadMore_CallBack = function(data) {
        var idatas = $scope.adminProManageRetrunData(data);
        $scope.aEditPros = $scope.aEditPros.concat(idatas);
        admProManageService.setaEditPros($scope.aEditPros);
        $scope.pageNum++;
        admProManageService.setPageNum($scope.pageNum);
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
    };
    $scope.adminProManageLoadMore = function() {
        if ($scope.noMoreHide && _isLodeMore === false) {
            _isLodeMore = true;
            $scope.loadHttp = $timeout(function() {
                getOrPostRequestObj.adminProManageConnect.adminProListLoadMore($scope,$http);
                $scope.$broadcast("scroll.infiniteScrollComplete");
            }, 1000);
        } else {
            $scope.$broadcast("scroll.infiniteScrollComplete");
        }
    };
    $scope.adminProManageRetrunData = function(data) {
        var idata = [],
            idatas = data.respData.dataList,
            tempporarySpace = {};
        for (var i = 0, len = idatas.length; i < len;i++) {
            tempporarySpace = {
                name:idatas[i].prodName,
                proId:idatas[i].prodNum,
                img:privateVerifictionObj.verifiction.imgLink(idatas[i].firstProdImg),
                price:"¥" + idatas[i].stdPrice,
                num:idatas[i].dispStockBalance,
                date:"上架日期: " + idatas[i].createDate
            };
            idata.push(tempporarySpace);
        }
        if (idatas.length < 9) {
            $scope.noMoreHide = false;
            $scope.loadingHide = true;
            admProManageService.setMoreHide(false);
            admProManageService.setLoadingHide(true);
        }
        return idata;
    };
    $scope.updatePriceDone_CallBack = function() {
        var num = $scope.data.price;
        num = (num+'').replace(/^0+\./g,'0.');
        num.match(/^0+[1-9]+/)? num = num.replace(/^0+/g,'') : num;
        $scope.aEditPros[$scope.index].price = "¥" + num;
    };
    $scope.updateNumDone_CallBack = function() {
        $scope.aEditPros[$scope.index].num = $scope.data.num.replace(/\b(0+)/gi, "");
    };
};
/*}*/

adminOrderInfoCtrl.$inject = [ "$scope", "$http", "$location", "$timeout" ];

indexModule.controller("adminOrderInfo", adminOrderInfoCtrl);

/*AdminSelectOrder PageEvt{*/
indexModule.service("admSelService",function(){
    var service = {};
    var _data = {};
    var _moreHide = true;
    var _loadingHide = false;
    var _pageNum = 2;
    var _searchVal = "";
    var _company = false;
    var _phone = true;

    service.getData = function(){
        return _data;
    };
    service.setData = function(data){
        _data = data;
    };
    service.getMoreHide = function(){
        return _moreHide;
    };
    service.setMoreHide = function(moreHide){
        _moreHide = moreHide;
    };
    service.getLoadingHide = function(){
        return _loadingHide;
    };
    service.setLoadingHide = function(loadingHide){
        _loadingHide = loadingHide;
    };
    service.getPageNum = function(){
        return _pageNum;
    };
    service.setPageNum = function(pageNum){
        _pageNum = pageNum;
    };
    service.getSearchVal = function(){
        return _searchVal;
    };
    service.setSearchVal = function(searchVal){
        _searchVal = searchVal;
    };
    service.getCompany = function(){
        return _company;
    };
    service.setCompany = function(company){
        _company = company;
    };
    service.getPhone = function(){
        return _phone;
    };
    service.setPhone = function(phone){
        _phone = phone;
    };
    return service;
});
var adminSelectOrderCtrl = function($scope,$http,$location,$timeout,admSelService) {
    $scope.adminOrder = {
        searchVal:""
    };
    $scope.iCustNum = "";
    $scope.keyColor = "keyColor-link";
    $scope.keyColors = "keyColor-active";
    $scope.isCompanyClick = false;
    $scope.isPhoneClick = true;
    $scope.noMoreHide = true;
    $scope.loadingHide = false;
    $scope.selSearchEvt = null;
    $scope.pageNum = 2;
    var _historySearchText = "";
    var _isLodeMore = true;

    $scope.$on("$stateChangeStart", function(event, toState) {
        $timeout.cancel($scope.loadHttp);
    });
    $scope.$on("$stateChangeSuccess", function(event, toState){
        if(toState.name === "adminSelectOrder"){
            if($scope.viewStates.getAdmSelOrderState() === false){
                getOrPostRequestObj.adminSelectOrderConnect.aUserCompany = "";
                getOrPostRequestObj.adminSelectOrderConnect.aUserPhoneNum = "";
                getOrPostRequestObj.adminSelectOrderConnect.adminShowOrderList($scope,$http);
                $scope.viewStates.setAdmSelOrderState(true);
            }else{
                $scope.adminOrder.searchVal = admSelService.getSearchVal();
                $scope.aOrders = admSelService.getData();
                $scope.isCompanyClick = admSelService.getCompany();
                $scope.isPhoneClick = admSelService.getPhone();
                $scope.noMoreHide = admSelService.getMoreHide();
                $scope.loadingHide = admSelService.getLoadingHide();
                $scope.pageNum = admSelService.getPageNum();
                _isLodeMore = false;
                $timeout(function() {
                    $scope.loadingImg();
                }, 500);
            };
    
        }
    })
    // $scope.admSelRefresh = function() {
    //     $timeout(function() {
    //         getOrPostRequestObj.adminSelectOrderConnect.adminShowOrderList($scope,$http);
    //         $scope.$broadcast("scroll.refreshComplete");
    //     }, 1000);
    // };
    $scope.adminOrderInit_CallBack = function(data) {
        $scope.aOrders = $scope.adminOrderReturnData(data);
        $scope.pageNum = 2;
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
        admSelService.setData($scope.aOrders);
        admSelService.setPageNum(2);
    };
    $scope.adminOrderLoadMore_CallBack = function(data) {
        var idatas = $scope.adminOrderReturnData(data);
        $scope.aOrders = $scope.aOrders.concat(idatas);
        $scope.pageNum++;
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
        admSelService.setData($scope.aOrders);
        admSelService.setPageNum($scope.pageNum);
    };
    $scope.adminOrderLoadMore = function() {
        if ($scope.noMoreHide && _isLodeMore === false) {
            _isLodeMore = true;
            $scope.loadHttp = $timeout(function() {
                getOrPostRequest.adminSelectOrderConnect.adminSelOrderLoadMore($scope,$http);
                $scope.$broadcast("scroll.infiniteScrollComplete");
            }, 1000);
        } else {
            $scope.$broadcast("scroll.infiniteScrollComplete");
        }
    };
    $scope.adminOrderReturnData = function(data) {
        var idata = [],
            idatas = data.respData.dataList,
            item,
            iPros = [],
            iHidePros = [],
            tempporarySpace,
            isProBtn = true;

        for (var i = 0, len = idatas.length;i < len;i++) {
            for (var j = 0,lens = idatas[i].orderItemList.length;j < lens;j++) {
                item = {
                    proId:idatas[i].orderItemList[j].prodNum,
                    img:privateVerifictionObj.verifiction.imgLink(idatas[i].orderItemList[j].whereimg),
                    name:idatas[i].orderItemList[j].prodName,
                    num:idatas[i].orderItemList[j].cases,
                    price:"¥" + idatas[i].orderItemList[j].custProdPrice,
                    type:idatas[i].orderItemList[j].differName
                };
                if (j < 3) {
                    iPros.push(item);
                } else {
                    iHidePros.push(item);
                    isProBtn = false;
                }
            }
            tempporarySpace = {
                orderNum:idatas[i].orderNum,
                userName:idatas[i].custName,
                proCount:idatas[i].orderItemList.length,
                proPrices:"¥" + idatas[i].custPriceTotal,
                cashState:idatas[i].cashStatusName,
                deliveryState:idatas[i].deliverStatusName,
                date:idatas[i].createDate,
                iPros:iPros,
                isHidePro:true,
                iHidePros:iHidePros,
                isHide:isProBtn,
                btnText:"显示全部"
            };
            isProBtn = true;
            iHidePros = [];
            iPros = [];
            idata.push(tempporarySpace);
        }
        if (idatas.length < 9) {
            $scope.noMoreHide = false;
            $scope.loadingHide = true;
            admSelService.setLoadingHide(true);
            admSelService.setMoreHide(false);
        }
        return idata;
    };
    $scope.toDetailed = function(index) {
        $location.path("/detailed").search({
            proNum:index,
            hisPage:1
        });
    };
    $scope.searchChange = function(){
        admSelService.setSearchVal($scope.adminOrder.searchVal);
    };
    $scope.toOrderDetailed = function(index) {
        $location.path("/adminOrderInfo").search({
            orderId:$scope.aOrders[index].orderNum
        });
    };
    $scope.clickKey = function(type) {
        $scope.isCompanyClick = true;
        $scope.isPhoneClick = true;
        if (type === 1) {
            $scope.isCompanyClick = !$scope.isCompanyClick;
        } else {
            $scope.isPhoneClick = !$scope.isPhoneClick;
        }
        admSelService.setCompany($scope.isCompanyClick);
        admSelService.setPhone($scope.isPhoneClick);
    };
    $scope.hideShowPro = function(index) {
        $scope.aOrders[index].isHidePro = !$scope.aOrders[index].isHidePro;
        $scope.aOrders[index].isHidePro ? $scope.aOrders[index].btnText = "显示全部" :$scope.aOrders[index].btnText = "隐藏部分";
        admSelService.setData($scope.aOrders);
    };
    $scope.orderSearch = function() {
        if ($scope.adminOrder.searchVal !== _historySearchText) {
            getOrPostRequestObj.adminSelectOrderConnect.aUserCompany = "";
            getOrPostRequestObj.adminSelectOrderConnect.aUserPhoneNum = "";
            $scope.pageNum = 1;
            $scope.noMoreHide = true;
            $scope.loadingHide = false;
            if ($scope.isCompanyClick === false) {
                getOrPostRequestObj.adminSelectOrderConnect.aUserCompany = $scope.adminOrder.searchVal;
            } else {
                getOrPostRequestObj.adminSelectOrderConnect.aUserPhoneNum = $scope.adminOrder.searchVal;
            }
            admSelService.setLoadingHide(false);
            admSelService.setMoreHide(true);
            admSelService.setPageNum(1);
            getOrPostRequestObj.adminSelectOrderConnect.adminShowOrderList($scope,$http);
            _isLodeMore = true;
        }
        _historySearchText = $scope.adminOrder.searchVal;
    };
    
};
/*}*/

adminProManageCtrl.$inject = [ "$scope", "$http", "admProManageService", "$location", "$ionicPopup", "$timeout" ];

var adminProManagearr = [ "$scope", "$http", "admProManageService", "$location", "$ionicPopup", "$timeout", adminProManageCtrl ];

indexModule.controller("adminProManage", adminProManagearr);

adminSelectOrderCtrl.$inject = [ "$scope", "$http", "$location", "$timeout", "admSelService" ];
var adminSelectOrderarr = [ "$scope", "$http", "$location", "$timeout", "admSelService", adminSelectOrderCtrl ];
indexModule.controller("adminSelectOrder", adminSelectOrderarr);

/*Detailed PageEvt{*/
/*Detailed PageEvt{*/
indexModule.service("detaiService",function(){
    var service = {};
    var _DNum = 0;
    service.getDNum = function(){
        return _DNum;
    };
    service.setDNum = function(DNum){
        _DNum = DNum;
    };
    return service;
});
var detailedCtrl = function($scope,detaiService,$http,$timeout,$location) {
    var pcUrl = "";
    var mobileUrl = "";
    $scope.shoppingType = 0;
    $scope.detailed = {
        proNum:0
    };
    var pageNUm = $location.search().dNum;
    var hisPage = $location.search().hisPage;
    $location.search({
        proNum:$location.search().proNum,
        hisPage:$location.search().hisPage
    }).replace();
    $scope.cartHide = hisPage == 1;
    $scope.detailedInit_CallBack = function(data) {
        var idatas = $scope.detailedReturnData(data);
        $scope.detailedDatas = idatas;
        for (var i = 0, len = data.prodExternals.length; i < len;i++) {
            if (data.prodExternals[i].externalName === "murl") {
                mobileUrl = data.prodExternals[i].externalValue;
            } else {
                pcUrl = data.prodExternals[i].externalValue;
            }
        }
        try{
            if(data.prodExternals.externalValue !== undefined && data.prodExternals.externalValue !== null){
                $scope.isToAl = data.prodExternals.externalValue.substring(0, 4) === "http"
            }else{
                $scope.isToAl = false;
            }
        }catch (e){
            $scope.isToAl = false;
        }

        var sliders = idatas.islides;
        var isliders = [];
        for (var j = 0, jlen = sliders.length;j < jlen; j++) {
            isliders.push({
                content:"<div class='detailed_bannerImg' ><img src='" + sliders[j].iSlideImg + "' onerror=this.src=errImg></div>"
            });
        }
        var opts = {
            type:"dom",
            data:isliders,
            dom:document.getElementById("detailedSwiper"),
            duration:3000,
            isLooping:true,
            isAutoplay:true,
            onslidechange:function(idx) {
                sliderSwiper_detailed.changeIndexDot();
            }
        };
        if (sliders.length > 0) {
            var sliderSwiper_detailed = new iSlider(opts);
            var dotOpt = {
                top:"42%",
                width:"100%",
                diameter:"0.8em",
                borderColor:"#365b88"
            };
            sliderSwiper_detailed.renderDot(dotOpt);
        }
    };
    $scope.detailedReturnData = function(data) {
        var idata,
            idatas = data,
            iextFeatrues = [],
            slides = [],
            slideImg = "",
            ifeatureName = "",
            ifeatureValue = "";
        for (var i = 0, ilen = idatas.prodImgs.length; i < ilen;i++) {
            slideImg = privateVerifictionObj.verifiction.imgLink(idatas.prodImgs[i].thumbUrl);
            slides.push({
                iSlideImg:slideImg
            });
        }
        for (var j = 0, jlen = idatas.prodFeatures.length; j < jlen;j++) {
            ifeatureName = idatas.prodFeatures[j].featureName;
            ifeatureValue = idatas.prodFeatures[j].ifeatureValue;
            iextFeatrues.push({
                extFeatrue:ifeatureName + ": " + ifeatureValue
            });
        }
        idata = {
            detailedTitle:idatas.prodName,
            islides:slides,
            price:"¥" + idatas.stdPrice,
            balance:idatas.dispStockBalance,
            extFeatrue:iextFeatrues,
            data:idatas.createDate,
            remark:idatas.remark,
            external:idatas.prodExternals
        };
        return idata;
    };
    $scope.$on("$stateChangeStart", function() {
        getOrPostRequestObj.userAndAdminSignIn.isToShoppingCar = false;
    });
    if ($location.search().proNum !== "") {
        getOrPostRequestObj.detailedConnect.getDetailed($location.search().proNum, $scope,$http);
    } else {
        $scope.detailedDatas = {
            detailedTitle:"产品获取失败，请返回重新选择产品。"
        };
    }
};
/*}*/


detailedCtrl.$inject = [ "$scope", "detaiService", "$http", "$timeout", "$location" ];

var detailedarr =  [ "$scope", "detaiService", "$http", "$timeout", "$location",detailedCtrl];

indexModule.controller("detailed", detailedarr);

/*HistoryOrder PageEvt{*/
indexModule.service("historyOrderService", function() {
    var service = {};
    var _moreHide = false;
    var _loadingHide = true;
    var _historyOrder = "";

    service.getMoreHide = function() {
        return _moreHide;
    };
    service.setMoreHide = function(moreHide) {
        _moreHide = moreHide;
    };
    service.getLoadingHide = function() {
        return _loadingHide;
    };
    service.setLoadingHide = function(loadingHide) {
        _loadingHide = loadingHide;
    };
    service.getHistoryOrder = function() {
        return _historyOrder;
    };
    service.setHistoryOrder = function(historyOrder) {
        _historyOrder = historyOrder;
    };
    return service;
});

var historyOrderCtrl = function($scope,$http,historyOrderService,$location,$timeout) {
    $scope.iCustNum = "";
    $scope.noMoreHide = historyOrderService.getMoreHide();
    $scope.loadingHide = historyOrderService.getLoadingHide();
    var _isLodeMore = true;
    if ($location.search().custNum) {
        $scope.iCustNum = $location.search().custNum;
        $scope.companyTitle = $location.search().custName;
    }

    $scope.$on("$stateChangeSuccess",function(event, toState){
        if(toState.name === "historyOrder"){
             if ($scope.viewStates.getHistoryOrderState() === false) {
                getOrPostRequestObj.adminSelectOrderConnect.adminShowOrderList($scope,$http);
                $scope.viewStates.setHistoryOrderState(true);
             } else {
                $scope.histroyOrders = historyOrderService.getHistoryOrder();
                _isLodeMore = false;
                $timeout(function() {
                    $scope.loadingImg();
                }, 500);
            }
        }
    });

    $scope.adminOrderInit_CallBack = function(data) {
        historyOrderService.setHistoryOrder($scope.adminOrderReturnData(data));
        $scope.histroyOrders = historyOrderService.getHistoryOrder();
        publicParameterObj.parameters.loadingPage = 2;
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
    };
    $scope.adminOrderLoadMore_CallBack = function(data) {
        var idatas = $scope.adminOrderReturnData(data);
        $scope.histroyOrders = $scope.histroyOrders.concat(idatas);
        historyOrderService.setHistoryOrder($scope.histroyOrders);
        publicParameterObj.parameters.loadingPage++;
        $timeout(function() {
            _isLodeMore = false;
        }, 1000);
        $timeout(function() {
            $scope.loadingImg();
        }, 500);
    };
    $scope.adminOrderLoadMore = function() {
        if ($scope.noMoreHide && _isLodeMore === false) {
            _isLodeMore = true;
            $timeout(function() {
                getOrPostRequest.adminSelectOrderConnect.adminSelOrderLoadMore($scope,$http);
                $scope.$broadcast("scroll.infiniteScrollComplete");
            }, 1000);
        } else {
            $scope.$broadcast("scroll.infiniteScrollComplete");
        }
    };
    $scope.adminOrderReturnData = function(data) {
        var idata = [],
            idatas = data.respData.dataList,
            item,
            iPros = [],
            iHidePros = [],
            tempporarySpace,
            isProBtn = true;
        for (var i = 0, len = idatas.length; i < len;i++) {
            for (var j = 0, lens = idatas[i].orderItemList.length; j < lens;j++) {
                item = {
                    proId:idatas[i].orderItemList[j].prodNum,
                    img:privateVerifictionObj.verifiction.imgLink(idatas[i].orderItemList[j].whereimg),
                    name:idatas[i].orderItemList[j].prodName,
                    num:idatas[i].orderItemList[j].cases,
                    price:"¥" + idatas[i].orderItemList[j].custProdPrice
                };
                if (j < 3) {
                    iPros.push(item);
                } else {
                    iHidePros.push(item);
                    isProBtn = false;
                }
            }
            tempporarySpace = {
                orderNum:idatas[i].orderNum,
                userName:idatas[i].custName,
                proCount:idatas[i].orderItemList.length,
                proPrices:"¥" + idatas[i].custPriceTotal,
                cashState:idatas[i].cashStatusName,
                deliveryState:idatas[i].deliverStatusName,
                date:idatas[i].createDate,
                iPros:iPros,
                isHidePro:true,
                iHidePros:iHidePros,
                isHide:isProBtn,
                btnText:"显示全部"
            };
            isProBtn = true;
            iHidePros = [];
            iPros = [];
            idata.push(tempporarySpace);
        }
        if (idatas.length < 9) {
            $scope.noMoreHide = false;
            $scope.loadingHide = true;
            historyOrderService.setMoreHide(false);
            historyOrderService.setLoadingHide(true);
        }
        return idata;
    };
    $scope.toDetailed = function(index) {
        $location.path("/detailed").search({
            proNum:index,
            hisPage:1
        });
    };
    $scope.toOrderDetailed = function(index) {
        $location.path("/adminOrderInfo").search({
            orderId:$scope.histroyOrders[index].orderNum
        });
    };
    $scope.hideShowPro = function(index) {
        $scope.histroyOrders[index].isHidePro = !$scope.histroyOrders[index].isHidePro;
        $scope.histroyOrders[index].isHidePro ? $scope.histroyOrders[index].btnText = "显示全部" :$scope.histroyOrders[index].btnText = "隐藏部分";
        historyOrderService.setHistoryOrder($scope.histroyOrders);
    };
   
};
/*}*/

historyOrderCtrl.$inject = [ "$scope", "$http", "historyOrderService", "$location", "$timeout" ];

var histroryOrderarr = [ "$scope", "$http", "historyOrderService", "$location", "$timeout", historyOrderCtrl ];

indexModule.controller("historyOrder", histroryOrderarr);