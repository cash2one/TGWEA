(function ($)
{
	jQuery.validator.methods.compareDate = function(value, element, param) {
        //var startDate = jQuery(param).val() + ":00";补全yyyy-MM-dd HH:mm:ss格式
        //value = value + ":00";
        
        var startDate = jQuery(param).val();
        
        var date1 = new Date(Date.parse(startDate.replace("-", "/")));
        var date2 = new Date(Date.parse(value.replace("-", "/")));
        return date1 < date2;
    };
    
    jQuery.validator.addMethod("mobile", function(value, element) {
        var length = value.length;
        var mobile =  /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "手机号码格式错误");   

    // 电话号码验证   
    jQuery.validator.addMethod("phone", function(value, element) {
        var tel = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
        return this.optional(element) || (tel.test(value));
    }, "电话号码格式错误");

    // 邮政编码验证   
    jQuery.validator.addMethod("zipCode", function(value, element) {
        var tel = /^[0-9]{6}$/;
        return this.optional(element) || (tel.test(value));
    }, "邮政编码格式错误");

    // IP地址验证
    jQuery.validator.addMethod("ip", function(value, element) {
        var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
        return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
    }, "Ip地址格式错误");

    // 字母和数字的验证
    jQuery.validator.addMethod("chrnum", function(value, element) {
        var chrnum = /^([a-zA-Z0-9]+)$/;
        return this.optional(element) || (chrnum.test(value));
    }, "只能输入数字和字母(字符A-Z, a-z, 0-9)");

    // 中文的验证
    jQuery.validator.addMethod("chinese", function(value, element) {
        var chinese = /^[\u4e00-\u9fa5]+$/;
        return this.optional(element) || (chinese.test(value));
    }, "只能输入中文");
    
    // 非中文的验证
    jQuery.validator.addMethod("nochinese", function(value, element) {
        var chinese = /^[\u4e00-\u9fa5]+$/;
        return !(this.optional(element) || (chinese.test(value)));
    }, "不能输入中文");
    
	jQuery.validator.addMethod("checkLigerListBox", function(value, element) {
        
		if($(element).length!=0){
			var valuefield = liger.get($(element).attr("id")).options.valueFieldID;
			if(!valuefield){
	        	valuefield = param+"_val";
	        }
			var value = $.trim($("#"+valuefield).val());
	        if(string.isInvalid(value)){
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
		
        
    },"请选择项目");
	
	jQuery.validator.addMethod("checkMultiSelectligerListBox", function(value, element, param) {
//        alert($(element).length!=0);
		if($(element).length!=0){
			var groupIds = $.getListBoxAllDataValue(liger.get(param));
			if(groupIds.length==0){
	            return false;
	        }else{
				return true;
			}
		}else{
			return true;
		}
		
        
    },"请选择项目");
    
    
    $.validator.setDefaults({  
    	 errorPlacement: function (lable, element) {
   	 
	        if (element.hasClass("l-textarea")) {
	            element.addClass("l-textarea-invalid");
	        }
	        else if (element.hasClass("l-text-field")) {
	            element.parent().addClass("l-text-invalid");
	        }
	
	        var nextCell = element.parents("i:first").next("i");

	        if(nextCell.length==0){
	        	nextCell = $('<i class="i-spacing-follow"></i>').appendTo(element.parents("i:first").parent());
	        }

	        nextCell.find("div.l-exclamation").remove(); 
	        $('<div class="l-exclamation" title="' + lable.html() + '"></div>').appendTo(nextCell).ligerTip(); 
    	},
    	success: function (lable) {
	        var element = $("#" + lable.attr("for"));
	        var nextCell = element.parents("i:first").next("i");
	        if(nextCell.length!=0){
		        if (element.hasClass("l-textarea")) {
		            element.removeClass("l-textarea-invalid");
		        }
		        else if (element.hasClass("l-text-field")) {
		            element.parent().removeClass("l-text-invalid");
		        }
		        nextCell.find("div.l-exclamation").remove();
	        }
    	},
        submitHandler: function() {
            $("form .l-text,.l-textarea").ligerHideTip();
            f_submitForm();
        }
    }); 
 
})(jQuery);