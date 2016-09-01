(function () {
	/** 
	 * 时间对象的格式化; 
	 */  
	Date.prototype.format = function(format) {  
	    /* 
	     * eg:format="yyyy-MM-dd hh:mm:ss"; 
	     */  
	    var o = {  
	        "M+" : this.getMonth() + 1, // month  
	        "d+" : this.getDate(), // day  
	        "h+" : this.getHours(), // hour  
	        "m+" : this.getMinutes(), // minute  
	        "s+" : this.getSeconds(), // second  
	        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter  
	        "S" : this.getMilliseconds()  
	        // millisecond  
	    };  
	  
	    if (/(y+)/.test(format)) {  
	        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4  
	                        - RegExp.$1.length));  
	    }  
	  
	    for (var k in o) {  
	        if (new RegExp("(" + k + ")").test(format)) {  
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1  
	                            ? o[k]  
	                            : ("00" + o[k]).substr(("" + o[k]).length));  
	        }  
	    }  
	    return format;  
	};  

	var j4tg = {
		log: function (message) {
	        console.log(message);
	    },
	    error: function (message) {
	        throw new Error(message);
	    },
	    _extend: function (obj) {
	        for (var i in obj) {
	        	j4tg[i] = obj[i];
	        }
	    }
    };
	
	j4tg.selallcheckbox = function(selallid,chkboxid){
		if($("#"+selallid).is("input[type='checkbox']"))
		{
			var checked = $("#"+selallid).attr("checked");
			if(checked){
				$("[id="+chkboxid+"]").attr("checked",'true');//全选
			}else{
				$("[id="+chkboxid+"]").removeAttr("checked");//取消全选
			}
		}
		
	};
	
	j4tg.haveIllegalFileChar = function(str){
		if(str.indexOf("\\")>=0){
			return true;	
		}
		if(str.indexOf("/")>=0){
			return true;	
		}
		if(str.indexOf(":")>=0){
			return true;	
		}
		if(str.indexOf("*")>=0){
			return true;	
		}
		if(str.indexOf("?")>=0){
			return true;	
		}
		if(str.indexOf("<")>=0){
			return true;	
		}
		if(str.indexOf(">")>=0){
			return true;	
		}
		if(str.indexOf("\"")>=0){
			return true;	
		}
		if(str.indexOf("|")>=0){
			return true;	
		}
		return false;
	};
	
	j4tg.getCookie = function (Name) {
		var search = Name + "="
		var returnvalue = ""
		if (document.cookie.length > 0) {
		offset = document.cookie.indexOf(search)
		if (offset != -1) {
		offset += search.length
		end = document.cookie.indexOf(";", offset)
		if (end == -1)
		end = document.cookie.length;
		returnvalue=unescape(document.cookie.substring(offset, end));
		}
		}
		return returnvalue;
	};
	
	j4tg.popCenterWindow = function (url) {
		var newWindow;//定义一个窗口，有利于窗口间的通讯
		if (!newWindow || newWindow.closed) {
			var width = 400;
	        var height = 300;
	        var left = parseInt((screen.availWidth/2) - (width/2));//屏幕居中
	        var top = parseInt((screen.availHeight/2) - (height/2));
	        var windowFeatures = "width=" + width + ",height=" + height + ",status,resizable,left=" + left + ",top=" + top + "screenX=" + left + ",screenY=" + top;
	        newWindow = window.open(url, "subWind", windowFeatures);
	    } else {
	        // window is already open, so bring it to the front
	        newWindow.focus();
	    }
	} ;
	j4tg.ajaxLoading = function () {
		$("#loading")
	    .ajaxStart(function(){
	        $(this).show();
	    })//开始上传文件时显示一个图片
	    .ajaxComplete(function(){
	        $(this).hide();
	    });//文件上传完成将图片隐藏起来
	};
	
	j4tg.ajaxPost = function (url,type,async,param,success,error) {
		
		var ajaxParam = {
				   type: "POST",
				   url: url,
				   data: $.param(param,true),
				   async:async,
				   dataType:type,
				   success: success,
				   error: error
				};
		if(type == "jsonp"){
			ajaxParam.jsonp = "callback";
			var currentTime= new Date().getTime();
			ajaxParam.jsonpCallback = "jsonp"+currentTime;
			
		}
		
		$.ajax(ajaxParam);
	};
	
	j4tg.ajaxGet = function (url,type,async,param,success,error) {
		
		var getParam = {
			type: "GET",
			   url: url,
			   data: $.param(param,true),
			   async:async,
			   dataType:type,
			   success: success,
			   error: error
		};
		
		if(type == "jsonp"){
			getParam.jsonp = "callback";
		}
		
		$.ajax(getParam);
	};
	
	var validatorRegex = {
	        mobile: /^(1[3,5,8][0-9])\d{8}$/,
	        phone: /^(\d{3,5}-?)?\d{7,9}$/,
	        postcode: /^[1-9]\d{5}(?!\d)/,
	        email: /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i,
	        url: /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
	        integer: /^\d+$/,
	        chinese: /^[^u4e00-u9fa5]+$/,
	        letter: /^[a-zA-z]+$/,
	        digit : /^\d+(.\d{1,2}){0,1}$/,
	        time : /^(0\d{1}|1\d{1}|2[0-3]{1})(:(0\d{1}|[1-5]{1}\d{1})){1}$/,
	        //time : /^(\d{1}|0\d{1}|1\d{1}|2[0-3]{1})(:(\d{1}|0\d{1}|[1-5]{1}\d{1})){1,2}$/
	        imgfile : /^.*(.jpg|.JPG|.jpeg|.JPEG|.png|.PNG){1}$/,
	        datetime : /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/
	};
	
	j4tg._extend({
        isIDCard: function (idcard) {
            ///	<summary>
            /// 身份证验证 正确返回"ok" ， 错误返回错误消息
            ///	</summary>

            var Errors = ["ok",
                          "身份证号码位数不对!",
                          "身份证号码填写不正确，请仔细核对!", //出生日期超出范围或含有非法字符
                          "身份证号码填写不正确，请仔细核对!", //校验错误
                          "身份证号码填写不正确，请仔细核对!"]; //地区非法

            var area = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "xingjiang", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" };
            var idcard, Y, JYM, result = 0;
            var S, M;
            var idcard_array = new Array();
            idcard = idcard.toUpperCase();
            idcard_array = idcard.split("");
            //地区检验 
            if (area[parseInt(idcard.substr(0, 2))] == null) {
                result = 4;
            } else {
                //身份号码位数及格式检验 
                switch (idcard.length) {
                    case 15:
                        if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {
                            ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/; //测试出生日期的合法性 
                        } else {
                            ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/; //测试出生日期的合法性 
                        }
                        if (!ereg.test(idcard)) {
                            result = 2;
                        }
                        break;
                    case 18:
                        //18位身份号码检测 
                        //出生日期的合法性检查   
                        //闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9])) 
                        //平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8])) 
                        if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0)) {
                            ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/; //闰年出生日期的合法性正则表达式 
                        } else {
                            ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/; //平年出生日期的合法性正则表达式 
                        }
                        if (ereg.test(idcard)) {//测试出生日期的合法性 
                            //计算校验位 
                            S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
			            + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
			            + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
			            + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
			            + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
			            + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
			            + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
			            + parseInt(idcard_array[7]) * 1
			            + parseInt(idcard_array[8]) * 6
			            + parseInt(idcard_array[9]) * 3;
                            Y = S % 11;
                            M = "F";
                            JYM = "10X98765432";
                            M = JYM.substr(Y, 1); //判断校验位 
                            if (M != idcard_array[17]) {
                                result = 3;
                            }
                        } else {
                            result = 2;
                        }
                        break;
                    default:
                        result = 1;
                        break;
                }
            }
            return Errors[result];
        },
        isPhone: function (value) {
            /// <summary>电话号码验证</summary>
            return validatorRegex.phone.test(value);
        },
        isMobile: function (value) {
            /// <summary>手机号码验证</summary>
            return value.length === 11 && validatorRegex.mobile.test(value);
        },
        isPostCode: function (value) {
            /// <summary>邮编验证</summary>
            return validatorRegex.postcode.test(value);
        },
        isEmail: function (value) {
            /// <summary>Email验证</summary>
            return validatorRegex.email.test(value);
        },
        isUrl: function (value) {
            /// <summary>Url验证</summary>
            return validatorRegex.url.test(value);
        },
        isInteger: function (value) {
            /// <summary>整数验证</summary>
            return validatorRegex.integer.test(value);
        },
        isChinese: function (value) {
            /// <summary>中文验证</summary>
            return validatorRegex.chinese.test(value);
        },
        isLetter: function (value) {
            /// <summary>字母验证</summary>
            return validatorRegex.letter.test(value);
        },
        isNumeric: function (value) {
            /// <summary>是否是数字 包括小数</summary>
            return !string.isInvalid(value) && !isNaN(value);
        },
        isDigit: function (value) {
            /// <summary>是否是整数或者包含两位的小数</summary>
            return validatorRegex.digit.test(value);
        },
        isTime: function (value) {
            /// <summary>是否是时间格式</summary>
            return validatorRegex.time.test(value);
        },
        isImgFile: function (value) {
            /// <summary>是否是图片文件</summary>
            return validatorRegex.imgfile.test(value);
        },
        isDateTime: function (value) {
            /// <summary>是否是日期时间格式</summary>
            return validatorRegex.datetime.test(value);
        }
    });
	
	// string
    var string = {
        format: function (value, args) {
            /// <summary>将指定字符串中的一个或多个格式项替换为指定对象的字符串表示形式。</summary>
            /// <param name="value" type="String">复合格式字符串。</param>
            /// <param name="args" type="Object">要设置格式的对象，可以为多个。</param>
            if (arguments.length === 0) return "";

            var str = value;
            for (var i = 1, len = arguments.length; i < len; i++) {
                var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
                str = str.replace(re, arguments[i]);
            }
            return str;
        },
        isInvalid: function (s) {
            /// <summary>指示指定的字符串是否是无效的字符串 无效的字符串包括 null、undefined、空、仅由空白字符。</summary>
            /// <param name="s" type="String">要测试的字符串</param>
            if ($.trim(s) === "" || s === null || s === undefined) {
                return true;
            }
            else {
                var str = $.trim(String(s));
                return !str;
            }
        }
    };
    
	window.j4tg = j4tg;
	window.string = string;

})();
/*
$(document).ready(function(){ 
	var elements = document.getElementsByTagName("table");  
	for (var i=0; i<elements.length; i++){       
		elements[i].style.fontSize = "14px";  
	}
})*/
