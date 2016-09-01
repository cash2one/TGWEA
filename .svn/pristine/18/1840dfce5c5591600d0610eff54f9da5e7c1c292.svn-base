var VerifictionClass = {
    isPhoneInternal:false,
    subNum:function(a, b) {
        return Math.round(a * Math.pow(10, b)) / Math.pow(10, b);
    },
    iphonever:function(a) {
        if (a == "") {
            return false;
        } else {
            if (!/^1[3|4|5|8][0-9]\d{8}$/.test(a)) {
                return false;
            } else {
                return true;
            }
        }
    },
    isMobile:function() {
        var c = /(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;
        var b = navigator.userAgent;
        if (null == b) {
            return true;
        }
        var a = c.exec(b);
        if (null == a) {
            return false;
        } else {
            return true;
        }
    },
    isInt:function(b) {
        var a = /^(-|\+)?\d+$/;
        return a.test(b);
    },
    isFloat:function(a) {
        if (!/^\d+(.\d{1,2}){0,1}$/.test(a)) {
            return false;
        } else {
            return true;
        }
    },
    isNotNull:function(str){
    	if(str !== "" && str !== undefined && str !== null){
            return true;
        }
        return false;
    },
    imgLink:function(b) {
        var a;
        var d = "";
        if (b === null) {
            a = publicParameterObj.parameters.proImgUrl + publicParameterObj.parameters.defaultuImg;
        } else {
            if (b.substring(0, 4) === "http") {
                a = b;
            } else {
                var c = publicParameterObj.parameters.proImgUrl.split(".");
                a = "http://img." + c[1] + "." + c[2] + b;
            }
        }
        return a;
    },
    isLetterAndNum:function(b) {
        var a = /^(([a-z]+[0-9]+)|([0-9]+[a-z]+)|[a-z]|[0-9])[a-z0-9]*$/;
        return a.test(b);
    },
    textLengthTrim:function(a) {
        return a.replace(/\s/g, "");
    },
    textLengthCut:function(a) {
        if (a.length > 10) {
            return a.substring(0, 10) + "...";
        }
        return a;
    },
    onOffLineInternal:function() {
        $(".conPrompt").fadeIn();
        customControlObj.mControl.hideLoader();
        publicParameterObj.parameters.isLoding = true;
    },
    onOnLineInternal:function() {
        $(".conPrompt").fadeOut();
        publicParameterObj.parameters.isLoding = false;
    },
    onBackKeyDown:function() {
        if (indexclass.isIndex === true) {
            navigator.notification.confirm("确定退出企业应用吗", function(a) {
                if (a === 1) {
                    navigator.app.exitApp();
                } else {
                    navigator.notification.cancel();
                }
            }, "退出企业应用", [ "退出", "返回" ]);
        } else {
            navigator.app.backHistory();
        }
    },
    testSetJushTagNalias:function() {
        var c = {};
        var b = publicParameterObj.parameters.userUrlHead + publicParameterObj.parameters.userGetAliasNTags;
        var a = function(e) {
            var f = "";
            if (e.status === "S") {
                try {
                    cordova.exec(phonedealwith.pluginAlert, phonedealwith.pluginAlert, "JpushClient", "setJpushAliasAndTags", [ e.respData.alias, e.respData.tags ]);
                } catch (d) {}
            } else {}
        };
        getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post", c, b, a);
    },
    ios7navInit:function() {
        try {
            if (this.isMobile()) {
                if (window.device.platform === "iOS") {
                    if (window.device.version.substr(0, 1) === "7" || window.device.version.substr(0, 1) === "8") {}
                }
            }
        } catch (a) {}
    },
    getUrlParm:function(b) {
        var a = "[\\?&]" + b + "=([^&#]*)";
        var e = new RegExp(a);
        var d = window.location.href;
        var c = e.exec(d);
        if (c == null) {
            return "";
        } else {
            return c[1];
        }
    }
};

var privateVerifiction = {
    verifiction:Object.create(VerifictionClass)
};

var privateVerifictionObj = Object.create(privateVerifiction);