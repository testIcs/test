/**
 * 提现申请审核
 * @audor zhengjiaoguo love yangqianqian
 * @date 2015-07-08
 */
window.ApplyMoneyAudit=(function($, module){
	
	var $applyMoneyAuditJqgridData  = $('#applyMoneyAudit_jqgrid_data');
	
	/**
	 * 产生token 
	 */
	function makeToken(){
		$.ajax({
   			url: "../../pay/applyAudit/makeToken",
   			type: "get",
   			dataType: "text",
   			async: false
   		}).done(function(data){
   			console.log("tokenStr: " + data);
   			$("#token_hidden").val(data);	
   		}).fail(function(){
   			console.log("makeToken fail!");
   		});
	}
	
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
	
	//加载提现申请审核数据列表Grid
	function loadApplyMoneyAuditDataGrid(){
		var id ;
		var rowData;
		$applyMoneyAuditJqgridData.jqGrid({
			url : "../../pay/applyAudit/getApplyMoneyRecord",
	        datatype : "json",
	        mtype : "post",
	        height : "auto",
	        forceFit : true,
	        rownumbers:true,
	        width : 1188,
	        colNames : ['序号','提现流水号','支付渠道类型', '用户ID', '姓名', '绑定账号', '支付渠道', '提现金额', '提现后余额', '申请日期', '操作', '查看明细'],
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
	        },{
	            name : 'applyFlowNo',
	            index : 'applyFlowNo',
	            width : 100,
	            align : "center"
	        },{
	            name : 'paygateType',
	            index : 'paygateType',
	            width : 100,
	            align : "center",
	            hidden: true
	        },{
	            name : 'userId',
	            index : 'userId',
	            width : 50,
	            align : "center",
	            hidden: true
	        },{
	            name : 'realName',
	            index : 'realName',
	            width : 80,
	            align : "center"            
	        },{
	            name : 'account',
	            index : 'account',
	            width : 80,
	            align : "center"
	        },{
	            name : 'paygateName',
	            index : 'paygateName',
	            width : 80,
	            align : "center"
	        },{
	        	name : 'applyMoney',
	        	index : 'applyMoney',
	        	width : 80,
	        	align : 'center'
	        },{
	        	name : 'surplusMoney',
	        	index : 'surplusMoney',
	        	width : 80,
	        	align : 'center'
	        },{
	            name : 'beginApplyDate',
	            index : 'beginApplyDate',
	            width : 100,
	            align : "center"
	        },{
	            name : 'operation',
	            index : 'operation',
	            width : 100,
	            align : "center"
	        },{
	            name : 'detailMsg',
	            index : 'detailMsg',
	            width : 100,
	            align : "center"
	        }],
	        multiselect : true,
	        rowNum : 10,
	        rowList : [ 10, 20, 30 ],
	        pager : '#applyMoneyAudit_jqgrid_pager',
	        recordpos : 'right',
	        viewrecords : true,
	        pgbuttons : true,
	        pginput : true,
	        gridComplete: function(){
				var ids = $applyMoneyAuditJqgridData.getDataIDs();
				$.each(ids, function(i, id) {
					 //var id = ids[i];
					 var operateBtn = "<input type='button' id='pass_btn' value='通过' passValue='PASS' onclick='ApplyMoneyAudit.sigleRowAudit(\""+id+"\",this)' style='color:red'/> <input type='button' id='nopass_btn' value='驳回' passValue='NO_PASS' onclick='ApplyMoneyAudit.sigleRowAudit(\""+id+"\",this)' style='color:red'/>";
					 var detailBtn = "<a id='details' href='javascript:ApplyMoneyAudit.queryAccountDetailData(\""+id+"\")' style='color:blue'>查看账户明细</a>";
					 $applyMoneyAuditJqgridData.jqGrid('setRowData', ids[i], { detailMsg: detailBtn, operation: operateBtn });
				});
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
	            root : "applyMoneyList",
	            page : "pageInfo.page",
	            records : "pageInfo.record",
	            total : "pageInfo.totalPage",
	            sidx : "pageInfo.sidx",
	            sord : "pageInfo.sord",
	            userdata : "",
	            repeatitems : false
	        }
	    });
	}
	
	/**
	 * 查看明细数据
	 */
	function queryAccountDetailData(rowId)
	{
		 var rowData = $applyMoneyAuditJqgridData.jqGrid('getRowData',rowId);
		 //业务流水
         var businessFlow = rowData.applyFlowNo;
         // 用户ID
         var userID = rowData.userId;
   		//window.open("../../pay/applyAudit/queryAccoutDetailData?businessFlow="+businessFlow+"&userID="+userID);
   		var url ="../../pay/applyAudit/queryAccoutDetailData?businessFlow="+businessFlow+"&userID="+userID;
   		$('#detailFrame').attr('src',url);
   		$("#detail_modal").modal("show");
	}
	
	/**
	 * 单行审核
	 */
	function sigleRowAudit(rowId, ele)
	{
		//屏蔽按钮
		CommonHandlePreventMoreClickButton.handlePreventMoreClick(ele, ele.getAttribute("id"));
		
		//审核状态（通过/驳回）
		 var auditState = ele.getAttribute('passValue');
		 var rowData = $applyMoneyAuditJqgridData.jqGrid('getRowData',rowId);
		 //业务流水
         var businessFlow = rowData.applyFlowNo;
         //userid
         var userID = rowData.userId;
         //提现账户
         var applyAccount = rowData.account;
         //支付渠道类型
         var paygateType = rowData.paygateType;
         //提现金额
         var drawMoney = rowData.applyMoney;
         //申请日期
         var beginApplyDate = rowData.beginApplyDate;
         
         $.ajax({
   			url: "../../pay/applyAudit/updateAuditStatus",
   			type: "post",
   			async: false,
   			dataType: "text",
   			data:  {
   				"businessFlow":businessFlow,
   				"auditState":auditState,
   				"userID":userID,
   				"applyAccount":applyAccount,
   				"paygateType":paygateType,
   				"drawMoney":drawMoney,
   				"beginApplyDate":beginApplyDate,
   				"token":$("#token_hidden").val()
   			}
   		}).done(function(data) {
   			//单次操作成功
   			if ("true" == data)
			{
   				jAlert("审核已完成!", "提示");
			}
   			//重复操作
   			else if("req_again")
			{
   				jAlert("请不要重复操作!", "提示");
			}
   			//单次操作失败
   			else 
			{
				jAlert("审核失败!", "出错");
			}
   			
   			//生成新的token
   			makeToken();
   			
   			$applyMoneyAuditJqgridData.jqGrid().trigger("reloadGrid");
   		})
	}
	
	/**
	 * 批量审核通过
	 */
	function batchAuditPass(objThis)
	{
		//判断是否选择数据
		if (!isChecked()){
			jAlert("请选中一行!", "提示");
			return;
		}
		
		//定义操作结果标示
		var resultFlag = false;
		
		// 获取选中的所有行的id集合,rowIds是一个数组(如：1,2,3)
		var rowIds  = $applyMoneyAuditJqgridData.jqGrid('getGridParam','selarrrow'); 
		
		if(0 == rowIds.length){
			jAlert("没有可审核的数据!", "提示");
			return;
		}
			
		//屏蔽按钮
		CommonHandlePreventMoreClickButton.handlePreventMoreClick(objThis, "auditPass_btn");
		
		// 行数据
		var rowData;
		
		//审核结果标示
		var reviewResultFlag;
		
		//index:索引 rowId:数据
		 $.each(rowIds, function (index, rowId) {  
			 // 获得所选择行数据信息
	         rowData = $applyMoneyAuditJqgridData.jqGrid('getRowData', rowId);
	         
	         //业务流水
	         var businessFlow = rowData.applyFlowNo;
	         //userid
	         var userID = rowData.userId;
	         //提现账户
	         var applyAccount = rowData.account;
	         //支付渠道类型
	         var paygateType = rowData.paygateType;
	         //提现金额
	         var drawMoney = rowData.applyMoney;
	         //申请日期
	         var beginApplyDate = rowData.beginApplyDate;
	         
	    	 $.ajax({
	 			url: "../../pay/applyAudit/updateAuditStatus",
	 			type: "post",
	 			async: false,
	 			dataType: "text",
	   			data:  {
	   				"businessFlow" : businessFlow,
	   				"auditState" : "PASS",
	   				"userID" : userID,
	   				"applyAccount" : applyAccount,
	   				"paygateType" : paygateType,
	   				"drawMoney" : drawMoney,
	   				"beginApplyDate" : beginApplyDate,
					"token" : $("#token_hidden").val()
	   			}
	 		}).done(function(data) {
	 			if("true" == data){
	 				reviewResultFlag = true;
	 			}else if("false" == data){
	 				reviewResultFlag = false;
	 				jAlert("程序出现异常!", "出错");
	 			}
	 		}).fail(function(){
	 			reviewResultFlag = false;
	 			jAlert("程序出现异常!", "出错");
	 		});
	 		
	    	 //审核到某一条申请时,程序出现异常,流程返回
	    	 if(false == reviewResultFlag){
	    		 return false;
	    	 }
	    	 
	 		//生成token
			makeToken();
		 		
		});
		
		//审核成功完成
		if(true == reviewResultFlag){
			jAlert("审核已完成!", "提示");
		}
		 
		$applyMoneyAuditJqgridData.jqGrid().trigger("reloadGrid");
	}
	
	/**
	 * 搜索提现申请记录
	 */
	function searchApplyMoneyRecord()
	{
		var postData = $applyMoneyAuditJqgridData.jqGrid("getGridParam", "postData");
		// 将form表单数据序列化为数组
		$.each($("#applyMoney_search_form").serializeArray(), function(i, n){
			var name = n.name;
			var value = n.value;
			if(value == undefined){
				postData[name] = "";
			}else{
				postData[name] = value;
			}
		});
		$applyMoneyAuditJqgridData.jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	//重置选择条件
	function clearAtSearch(){
		//初始化查询表单
		$("#applyMoney_search_form").resetForm();
		
		//清空查询条件，重置列表
		ApplyMoneyAudit.searchApplyMoneyRecord();
	}
	
	/**
	 * 提现申请时间
	 */
	function bindApplyDate()
	{
		CommonDateTimePickerBind.bindDateTimePicker("applyStartDate");
		CommonDateTimePickerBind.bindDateTimePicker("applyEndDate");
	}
	
	/**
	 * 初始化页面数据
	 */
	function init()
	{
		//生成token
		makeToken();
		
		//绑定申请日期
		bindApplyDate();
		loadApplyMoneyAuditDataGrid();
	}
	
	module.init = init;
	module.makeToken = makeToken;
	module.queryAccountDetailData = queryAccountDetailData;
	module.clearAtSearch = clearAtSearch;
	module.sigleRowAudit = sigleRowAudit;
	module.batchAuditPass = batchAuditPass;
	module.searchApplyMoneyRecord = searchApplyMoneyRecord;
	
	return module;
	
})($, window.ApplyMoneyAudit || {});

/**
 * 页面初始化（入口）
 */
$(function() {
	ApplyMoneyAudit.init();
	
	// 绑定审核按钮
	$("#auditPass_btn").on("click", function() {
		ApplyMoneyAudit.batchAuditPass(this);
    });
	// 绑定搜索事件
	$("#search_btn").on("click", function() {
		ApplyMoneyAudit.searchApplyMoneyRecord();
	});
	// 重置条件
	$("#reset_btn").on("click", function() {
		ApplyMoneyAudit.clearAtSearch();
	});
	
	$("#detail_modal").modal({ 
	    backdrop: false,
		backdrop: "static",
		keyboard:true,
		show:false
	});
});