/**
 * 提现申请审核通过记录
 * @audor zhengjiaoguo love yangqianqian
 * @date 2015-07-08
 */
window.ApplyAuditPass=(function($, module){
	
	var allRowDatas;
	var $exportAuditPassData  = $('#exportAuditPass_jqgrid_data');
	//判断复选框是否选中
	function isChecked(){
		var checkedCount = $("input[type=checkbox]:checked").length;
		if(checkedCount > 0){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//加载审核通过数据列表Grid
	function loadExportAuditPassDataGrid(){
		var id ;
		var rowData;
		$exportAuditPassData.jqGrid({
			url : "../../pay/applyAuditpass/queryAuditPassData",
	        datatype : "json",
	        mtype : "post",
	        height : "auto",
	        forceFit : true,
	        rownumbers:true,
	        width : 1300,
	        colNames : ['序号', '提现申请账号',  '申请提现金额',  '申请开始日期', '审核日期', '审核结果', '备注'],
	        colModel : [ {
	            name : 'id',
	            index : 'id',
	            width : 80,
	            align : "center", 
	            hidden: true,	
	            formatter:function(cellvalue, options, rowObject){
	            	id = cellvalue;
		            return cellvalue;
		        }
	        },
	        /*
	        {
	            name : 'applyFlowNO',
	            index : 'applyFlowNO',
	            width : 120,
	            align : "center",
	        },{
	            name : 'realName',
	            index : 'realName',
	            width : 80,
	            align : "center"            
	        },
	        {
	            name : 'paygateName',
	            index : 'paygateName',
	            width : 80,
	            align : "center"
	        },
	        {
	        	name : 'surplusMoney',
	        	index : 'surplusMoney',
	        	width : 80,
	        	align : 'center'
	        }, 
	        {
	            name : 'endApplyDate',
	            index : 'endApplyDate',
	            width : 120,
	            align : "center"
	        }, 
	        {
	            name : 'auditUser',
	            index : 'auditUser',
	            width : 70,
	            align : "center"
	        }, {
	            name : 'auditStep',
	            index : 'auditStep',
	            width : 60,
	            align : "center"
	        },
	        */
	        {
	            name : 'account',
	            index : 'account',
	            width : 100,
	            align : "center"
	        },{
	        	name : 'applyMoney',
	        	index : 'applyMoney',
	        	width : 80,
	        	align : 'center'
	        },{
	            name : 'beginApplyDate',
	            index : 'beginApplyDate',
	            width : 120,
	            align : "center"
	        },{
	            name : 'auditDate',
	            index : 'auditDate',
	            width : 120,
	            align : "center"
	        },{
	            name : 'auditStatus',
	            index : 'auditStatus',
	            width : 80,
	            align : "center",
	            formatter:function(cellvalue, options, rowObject){            	
	            	if(cellvalue == 1){
	            		return "发起";
	            	}else if(cellvalue == 2){
	            		return "正在审核"
	            	}else if(cellvalue == 3){
	            		return "通过"
	            	}else if(cellvalue == 4){
	            		return "驳回"
	            	}
			     }
	        },{
	            name : 'auditRemark',
	            index : 'auditRemark',
	            width : 100,
	            align : "center"
	        }],
	        multiselect : true,
	        rowNum : 10,
	        rowList : [ 10, 20, 30 ],
	        pager : '#exportAuditPass_jqgrid_pager',
	        recordpos : 'right',
	        viewrecords : true,
	        pgbuttons : true,
	        pginput : true,
	        gridComplete: function(){
	        }, 
	        onSelectRow : function(rowid, status) {
            },
	        prmNames : {
	            page : "pageParm",
	            rows : "rowsParm",
	            sidx : "sidxParm",
	            sord : "sordParm",
	            nd : "ndParm"           
	        },
	        jsonReader : {
	            root : "auditPassList",
	            page : "pageInfo.page",
	            records : "pageInfo.record",
	            total : "pageInfo.totalPage",
	            sidx : "pageInfo.sidx",
	            sord : "pageInfo.sord",
	            userdata : "",
	            repeatitems : false,
	        }
	    });
	}
	
	/**
	 * 将审核通过数据导出为excel文件
	 */
	function exportExcel()
	{
		// 行数据
		var rowData;
		if (!isChecked())
		{
			jAlert("请选中一行!", "提示");
			return;
		}
		// 获取选中的所有行的id集合,rowIds是一个数组(如：1,2,3)
		var rowIds  = $exportAuditPassData.jqGrid('getGridParam','selarrrow'); 
	 	 //index:索引 rowId:数据
		 $.each(rowIds, function (index, rowId) {  
	         rowData = $exportAuditPassData.jqGrid('getRowData',rowId);
	         // 申请提现金额
	         var applyMoney = rowData.applyMoney;
	         // 账户余额
	         var surplusMoney = rowData.surplusMoney;
	         //业务流水
	         var businessFlow = rowData.applyFlowNO;
	         if (applyMoney <= surplusMoney)
	         {
	        	 $.ajax({
	     			url: "../../pay/applyAudit/updateAuditStatus",
	     			type: "post",
	     			async: false,
	     			dataType: "text",
	     			data:  {"businessFlow":businessFlow}
	     		}).done(function(data) {
	     			alert("data===" + data);
	     		})
	         }
	     });  
	}
	
	/**
	 * 搜索提现申请记录
	 */
	function searchApplyMoneyRecord()
	{
		var postData = $exportAuditPassData.jqGrid("getGridParam", "postData");
		// 将form表单数据序列化为数组
		$.each($("#applyMoney_search_form").serializeArray(), function(i, n){
			var name = n.name;
			var value = n.value;
//			alert("i = " + i +" name == " + name + " value==" + value);
			if(value == undefined){
				postData[name] = "";
			}else{
				postData[name] = value;
			}
		});
		$exportAuditPassData.jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	/**
	 * 提现申请时间
	 */
	function bindApplyDate()
	{
		CommonDateTimePickerBind.bindDateTimePicker("applyDate");
	}
	
	/**
	 * 初始化页面数据
	 */
	function init()
	{
		bindApplyDate();
		loadExportAuditPassDataGrid();
	}
	
	module.init = init;
	module.exportExcel = exportExcel;
	module.searchApplyMoneyRecord = searchApplyMoneyRecord;
	return module;
})($, window.ApplyAuditPass || {});

/**
 * 页面初始化（入口）
 */
(function() {
	ApplyAuditPass.init();
	
	// 绑定审核按钮
	$("#exportPass_btn").on("click", function() {
		ApplyAuditPass.exportExcel();
    });
	
	// 绑定搜索事件
	$("#search_btn").on("click", function() {
		ApplyAuditPass.searchApplyMoneyRecord();
	});
})();