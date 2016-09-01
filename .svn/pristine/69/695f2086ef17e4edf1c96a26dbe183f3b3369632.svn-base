(function ($)
{
	//ligerGrid.js.submitEdit.964
    $.getGridEditColumnData = function (g,rowParm,columnname)
    {
         var newvalue = "";
    	 var rowdata = g.getRow(rowParm);
         if (!g.editors[rowdata['__id']]) return;
         for (var columnid in g.editors[rowdata['__id']])
         {
             var o = g.editors[rowdata['__id']][columnid];
             var column = o.editParm.column;
             if (column.name==columnname)
             {
            	 newvalue = o.editor.getValue(o.input, o.editParm);
             }
             
         }
         return newvalue
    }
    
    
    //ligerGrid.js.extendDetail.2030  
    $.genNExtendDetail = function (g,rowParm)
    {
    	var rowdata = g.getRow(rowParm);
        if (!rowdata) return;
        
        for (var i = 0, l = g.columns.length; i < l; i++)
        {   
            if (g.columns[i].isdetail)
            {
            	
                var cell = g.getCellObj(rowdata, g.columns[i]);
                var span = $(".l-grid-row-cell-detailbtn:first", cell);
                $(span).trigger("click");
                return;
            }
        }
    }
    
    $.recoverGridCommonParms = function (g,svrParms){ 
    	var sortname = svrParms["sortParam.sortBy"];
    	g.options.newPage = svrParms["wpagingRequest.currentPage"];
        g.options.pageSize = svrParms["wpagingRequest.perPageUnitNum"]; 
        if (g.options.newPage == 1)
        {
            $(".l-bar-btnfirst span", g.toolbar).addClass("l-disabled");
            $(".l-bar-btnprev span", g.toolbar).addClass("l-disabled");
        }
        else
        {
            $(".l-bar-btnfirst span", g.toolbar).removeClass("l-disabled");
            $(".l-bar-btnprev span", g.toolbar).removeClass("l-disabled");
        }
        if (g.options.newPage == g.options.pageSize)
        {
            $(".l-bar-btnlast span", g.toolbar).addClass("l-disabled");
            $(".l-bar-btnnext span", g.toolbar).addClass("l-disabled");
        }
        else
        {
            $(".l-bar-btnlast span", g.toolbar).removeClass("l-disabled");
            $(".l-bar-btnnext span", g.toolbar).removeClass("l-disabled");
        }
        if(!string.isInvalid(sortname)){
        	var sortorder = svrParms["sortParam.sortType"];
        	var hcell = $("td[columnname='"+sortname+"']:first",g.gridheader);
        	var hinnercell = $(".l-grid-hd-cell-inner:first",hcell);
        	var sort = $(".l-grid-hd-cell-sort:first", hinnercell);
        	sort.remove();
        	if (sortorder=="asc")
            {	
        		hinnercell.append('<span class="l-grid-hd-cell-sort l-grid-hd-cell-sort-asc">&nbsp;&nbsp;</span>');

            }
            else if (sortorder=="desc")
            {
            	hinnercell.append('<span class="l-grid-hd-cell-sort l-grid-hd-cell-sort-desc">&nbsp;&nbsp;</span>');

            }
	        g.options.sortName = sortname; 
	        g.options.sortOrder = sortorder; 
        }

    }
    	
    $.reloadGridServerData = function (g,gparms,svrCommonParms){ 
        if(g){
        	if(svrCommonParms){
        		$.recoverGridCommonParms(g,svrCommonParms);
        	}
        	 //如果不是服务器记忆参数
        	else{
	            //当grid参数delayLoad设置为true不会自动初始化newPage
	            g.options.newPage = 1;
            }
//        	alert(JSON.stringify(gparms));
        	g.options.parms = gparms;
            var gridparms = []; 
            for(var key in g.options.parms){
            	var paramvalue = g.options.parms[key];
//            	if(Object.prototype.toString.call(paramvalue) == '[object Array]'){
            	if(paramvalue instanceof Array){
            		$.each(paramvalue,function(n,value) { 
            			//解决服务端产生空置无效数组导致查询条件判断不正确问题
            			if(!(value === "" || value === null || value === undefined)){
            				gridparms.push({ name: key, value: value }); 
            			}
            		}); 
            	}else{
            		gridparms.push({ name: key, value: paramvalue });
            	}
            }
           
            
            gridparms.push({ name: g.options.pageParmName, value: g.options.newPage }); 
            gridparms.push({ name: g.options.pagesizeParmName, value: g.options.pageSize }); 
            if(g.options.sortName){
	            gridparms.push({ name: g.options.sortnameParmName, value: g.options.sortName });
	            gridparms.push({ name: g.options.sortorderParmName, value: g.options.sortOrder });
            }
            g.loadServerData(gridparms); 
        } 
    }  
    
    //ligerComboBox.js.extendDetail.2030  
    $.setComboBoxTreeData = function (g,treedata){ 
        if(g){
    
        	 //树形格式初始化[{ "text": "1", "children": [{ "text": "1.1" },{ "text": "1.2" }]},{ "text": "2" }]
        	 //ligerComboBox.js.setTree.799 初始化ComboBox Tree控件
        	 g.tree = $("<ul></ul>");
             $("div:first", g.selectBox).append(g.tree);
             g.tree.ligerTree({});
             g.treeManager = g.tree.ligerGetTreeManager();
             //ligerComboBox.js.setTree.762 注册选择点击事件
             g.setTree({});
             //ligerTree.js.setData.141 设置ComboBox treedata  
             g.treeManager.setData(treedata);

        } 
    } 
    //"1,2,3,4,5,6,7,8,9"
    $.selectComboBoxTreeNodes = function (g,selectnode,valuefield) {
    	selectnode = "," + selectnode + ",";
        var parm = function(data) {
        	if (selectnode.indexOf("," + data[valuefield] + ",") != -1)
            {return true; } else { return false }
        };
        //选择tree的节点(注意：如果树只支持叶子节点，设置父节点将无效)
        g.treeManager.selectNode(parm);
        //触发tree的check事件设置COMBOBOX对应选中节点的值 ligerComboBox.js.setTree.762
        g.treeManager.trigger("check");
    };
    
    //ligerComboBox.js._getSrcElementByEvent.3496,3499 
    $.cancelGridSelectAll = function (gridid) {
    	
    	if($("#"+gridid).find(".l-grid-hd-row").hasClass("l-checked")){
   	 		$("#"+gridid).find(".l-grid-hd-row").find(".l-grid-hd-cell-checkbox").trigger("click");
    	}
//	 		$("#"+gridid).find(".l-grid-hd-row").removeClass("l-checked");
    };
	
	
    $.transformMap2ComboBoxData = function (mapdata,allvalue){ 

    	var comboBoxData = [];
    	if(allvalue){
    		comboBoxData.push({ id: allvalue, text:'全部' });
    	}
        if(mapdata){ 
//        	alert(JSON.stringify(mapdata));
            for(var key in mapdata){
            	comboBoxData.push({ id: key, text: mapdata[key] }); 
            }

        }
//        alert(JSON.stringify(comboBoxData));
        return comboBoxData;
    }  
    
    
    $.expandAccordionMenu = function (menuid)
    {
    	var accordionheader = $("#"+menuid).prev();
    	if(accordionheader.find(".l-accordion-toggle").hasClass("l-accordion-toggle-close")){
    		accordionheader.trigger("click");
    	}
    }
    
	$.ligerDefaults.Grid.editors['textarea'] = {
	           create: function (container, editParm)
	           {
	               var input = $("<textarea style='font-size: 12px'/>");
	               container.append(input);
	               container.width('auto').height('auto');
	               return input;
	           },
	           getValue: function (input, editParm)
	           {
	               return input.val();
	           },
	           setValue: function (input, value, editParm)
	           {
	               input.val(value);
	           },
	           resize: function (input, width, height, editParm)
	           {
	               var column = editParm.column;
	               input.width(column.editor.width);
	               input.height(column.editor.height);
	           }
	 }

	
	$.getSelectedAllDataValue = function (idfieldname,t){
		var valuearray = [];
		if(t.getSelected()){
			$.getSelectedDataValue(idfieldname,t.getSelected().data,valuearray);
		}
		return valuearray;
	}

	$.getListBoxAllDataValue = function (listgrid){
		
		var valuefield = listgrid.options.valueField;
		if(!valuefield){
			valuefield = 'id';
		}
		if (!listgrid.data) listgrid.data = [];
		
		var valuearray = [];

		for (var i = 0, l = listgrid.data.length; i < l; i++)
        {
			valuearray.push(listgrid.data[i][valuefield]);
        }
		
		
		return valuearray;
	}
	
	$.getSelectedDataValue = function (idfieldname,data,valuearray){

		if(data){
			valuearray.push(data[idfieldname]);
	//		alert(valuearray.join(","));
			if (data.children)
			{
				for (var child in data.children) 
				{ 
					$.getSelectedDataValue(idfieldname,data.children[child],valuearray)
				}
			}
		}

	}
	$.applyWindowMask = function ()
    {

        $(".l-window-mask").remove();
        $("<div class='l-window-mask' style='display: block;'></div>").appendTo($("body"));
    }
    $.removeWindowMask = function ()
    {
        var g = this, p = this.options;
        $(".l-window-mask").remove();
    }
    
    $.clearElementValidateErrors = function (valelement)
    {
//    	var valelement = $("#" + elementid);
    	var container;
    	if(valelement.is('form')){
    		container = valelement;

    	}else{	
    		container = valelement.parents("i:first").next("i");
    	}
    	if(container.length!=0){
    		container.find(".l-textarea-invalid").removeClass("l-textarea-invalid");
    		container.find(".l-text-invalid").removeClass("l-text-invalid");
    		container.find("div.l-exclamation").remove();
    	}
    }
	
	$.ligerGridCheckboxVO = function (params) {
        var checkedValues = [];     //这个是私有变量，外部无法访问
        var checkFieldName = params.checkFieldName;
        var gridId = 'maingrid';
        if(!(params.gridId===null||params.gridId===""||params.gridId===undefined)){
        	gridId = params.gridId;
        }
       	this.checkAllRow = function (g,checked)
        {
            for (var rowid in g.records)
            {
                if(checked)
                	addCheckedValue(g.records[rowid][checkFieldName]);
                else
                	removeCheckedValue(g.records[rowid][checkFieldName]);
            }
        }


       	this.checkRow = function (checked, rowdata)
        {
            if (checked) addCheckedValue(rowdata[checkFieldName]);
            else removeCheckedValue(rowdata[checkFieldName]);
        }
    	function findCheckedValue(fieldValue)
        {
            for(var i =0;i<checkedValues.length;i++)
            {
                if(checkedValues[i] == fieldValue) return i;
            }
            return -1;
        }


    	function addCheckedValue(fieldValue)
    	{
    	    if(findCheckedValue(fieldValue) == -1)
    	    	checkedValues.push(fieldValue);
    	}
    	function removeCheckedValue(fieldValue)
    	{
    	    var i = findCheckedValue(fieldValue);
    	    if(i==-1) return;
    	    checkedValues.splice(i,1);
    	}

    	this.getCheckedValueText = function()
        {
            return checkedValues.join(',');
        }
    	
    	this.getCheckedValue = function()
        {
            return checkedValues;
        }
    	
    	this.initGridCheckboxStatus = function()
        {
    		//重置全选选择框的选中状态
    		$.cancelGridSelectAll(gridId);
    		//清除上一次的选择结果
    		checkedValues = [];
        }
    };
})(jQuery);