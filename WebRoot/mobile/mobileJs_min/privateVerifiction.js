var VerifictionClass={isPhoneInternal:false,subNum:function(d,c){return Math.round(d*Math.pow(10,c))/Math.pow(10,c)},iphonever:function(b){if(b==""){return false}else{if(!/^1[3|4|5|8][0-9]\d{8}$/.test(b)){return false}else{return true}}},isMobile:function(){var f=/(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;var d=navigator.userAgent;if(null==d){return true}var e=f.exec(d);if(null==e){return false}else{return true}},isInt:function(c){var d=/^(-|\+)?\d+$/;return d.test(c)},isFloat:function(b){if(!/^\d+(.\d{1,2}){0,1}$/.test(b)){return false}else{return true}},isNotNull:function(a){if(a!==""&&a!==undefined&&a!==null){return true}return false},imgLink:function(e){var f;var g="";if(e===null){f=publicParameterObj.parameters.proImgUrl+publicParameterObj.parameters.defaultuImg}else{if(e.substring(0,4)==="http"){f=e}else{var h=publicParameterObj.parameters.proImgUrl.split(".");f="http://img."+h[1]+"."+h[2]+e}}return f},isLetterAndNum:function(c){var d=/^(([a-z]+[0-9]+)|([0-9]+[a-z]+)|[a-z]|[0-9])[a-z0-9]*$/;return d.test(c)},textLengthTrim:function(b){return b.replace(/\s/g,"")},textLengthCut:function(b){if(b.length>10){return b.substring(0,10)+"..."}return b},onOffLineInternal:function(){$(".conPrompt").fadeIn();customControlObj.mControl.hideLoader();publicParameterObj.parameters.isLoding=true},onOnLineInternal:function(){$(".conPrompt").fadeOut();publicParameterObj.parameters.isLoding=false},onBackKeyDown:function(){if(indexclass.isIndex===true){navigator.notification.confirm("确定退出企业应用吗",function(b){if(b===1){navigator.app.exitApp()}else{navigator.notification.cancel()}},"退出企业应用",["退出","返回"])}else{navigator.app.backHistory()}},testSetJushTagNalias:function(){var f={};var d=publicParameterObj.parameters.userUrlHead+publicParameterObj.parameters.userGetAliasNTags;var e=function(b){var a="";if(b.status==="S"){try{cordova.exec(phonedealwith.pluginAlert,phonedealwith.pluginAlert,"JpushClient","setJpushAliasAndTags",[b.respData.alias,b.respData.tags])}catch(c){}}else{}};getOrPostRequestObj.ajaxRquest.asynAjaxRequest("post",f,d,e)},ios7navInit:function(){try{if(this.isMobile()){if(window.device.platform==="iOS"){if(window.device.version.substr(0,1)==="7"||window.device.version.substr(0,1)==="8"){}}}}catch(b){}},getUrlParm:function(f){var g="[\\?&]"+f+"=([^&#]*)";var h=new RegExp(g);var i=window.location.href;var j=h.exec(i);if(j==null){return""}else{return j[1]}}};var privateVerifiction={verifiction:Object.create(VerifictionClass)};var privateVerifictionObj=Object.create(privateVerifiction);
