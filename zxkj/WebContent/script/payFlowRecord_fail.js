$(function(){
	CommonDateTimePickerBind.bindStartToEndDateTimePicker("applyStartDate","applyEndDate");
	$("#modify_success_form").modal({ 
	    backdrop: false,
		backdrop: "static",
		keyboard:true,
		show:false
	});
	$('#payTime').datetimepicker({
	    format: 'Y-m-d H:i:s'
	});
	var $payRecordJqgridData  = $('#payRecord_jqgrid_data');	
	$payRecordJqgridData.jqGrid({
		url : "../pay/payHistory/showPayFlowRecord/2",
        datatype : "json",        
        mtype : "post",
        height : "auto",
        forceFit : true,
        rownumbers:true,
        width : 1288,
        colNames : ['no','userId', '业务流水号','姓名', '支付渠道', '提现账号','提现前余额', '提现金额', '申请时间','导出状态', '支付状态','备注','操作'],
        colModel : [ {
            name : 'id',
            index : 'id',
            width : 80,
            align : "center", 
            hidden: true
        }, {
            name : 'userId',
            index : 'id',
            width : 80,
            align : "userId", 
            hidden: true
        },{
            name : 'businessFlowNo',
            index : 'businessFlowNo',
            width : 120,
            align : "center",
        },{
            name : 'realName',
            index : 'realName',
            width : 50,
            align : "center",
        }, {
            name : 'paygateName',
            index : 'paygateName',
            width : 50,
            align : "center"           
        },{
            name : 'account',
            index : 'account',
            width : 120,
            align : "center"           
        },{
            name : 'beforePayMoney',
            index : 'beforePayMoney',
            width : 50,
            align : "center"
        }, {
            name : 'applyMoney',
            index : 'applyMoney',
            width : 50,
            align : "center"
        }, {
            name : 'beginApplyDate',
            index : 'beginApplyDate',
            width : 120,
            align : "center"            
        }, {
            name : 'exportFlag',
            index : 'exportFlag',
            width : 50,
            align : "center",
            formatter:function(cellvalue, options, rowObject){            	
            	if(cellvalue == 0){
            		return "未导出";
            	}else if(cellvalue == 1){
            		return "已导出";
            	}
		     }
        }, {
            name : 'payStatus',
            index : 'payStatus',
            width : 80,
            align : "center",
            formatter:function(cellvalue, options, rowObject){            	
            	if(cellvalue == 0){
            		return "待支付";
            	}else if(cellvalue == 1){
            		return "支付成功";
            	}else if(cellvalue == 2){
            		return "支付失败";
            	}
		     }
        }, {
            name : 'payRemark',
            index : 'payRemark',
            width : 120,
            align : "center"            
        }, {
        	name : 'opt',
            index : 'opt',
            width : 80,
            align : "center", 
        	formatter:function(cellvalue, options, rowObject){	
        		
        		var o = "<button onclick='markSuccess("+options.rowId+")'>成功</button>" +
        				"<button onclick='markClose("+options.rowId+")'>关闭</button>";
		        return o;
			}
        }],
        rowNum : 15,
        rowList : [ 15, 30, 45 ],
        pager : '#payRecord_jqgrid_pager',
        recordpos : 'right',
        viewrecords : true,
        pgbuttons : true,
        pginput : true,
        gridComplete: function(){
        }, 
        prmNames : {
            search : "search",
            page : "page",
            rows : "rows",
            sidx : "sidx",
            sord : "sord",
            nd : "nd"           
        },
        jsonReader : {
            root : "dataList",
            page : "pageInfo.page",
            records : "pageInfo.record",
            total : "pageInfo.totalPage",
            sidx : "pageInfo.sidx",
            sord : "pageInfo.sord",
            userdata : "",
            repeatitems : false,
        }
    });
})

function queryData(){
	var applyStartDate = $('#applyStartDate').val();
	var applyEndDate = $('#applyEndDate').val();
	var realName = $('#realName').val();
	var account = $('#account').val();
	var exportFlag = $('#exportFlag').val();
	var postData = $("#payRecord_jqgrid_data").jqGrid("getGridParam", "postData");
	postData['applyStartDate'] = applyStartDate;	
	postData['applyEndDate'] = applyEndDate;	
	postData['realName'] = realName;	
	postData['account'] = account;	
	postData['exportFlag'] = exportFlag;	
	$("#payRecord_jqgrid_data").jqGrid('setGridParam', {			
		datatype : 'json',
		postData : postData, //发送数据  
		page : 1
	}).trigger("reloadGrid");
}
	
function markSuccess(rowid){	
	var $payRecordJqgridData  = $('#payRecord_jqgrid_data');
	var row = $payRecordJqgridData.jqGrid("getRowData",rowid);	
	$('#id_success').val(row.id);
	$('#businessFlowNo_success').val(row.businessFlowNo);	
	$('#payStatus_success').val(1);
	$('#applyMoney').val(row.applyMoney);
	$('#payMoney').val(row.applyMoney);	//支付金额默认等于提现金额
	$('#userId_success').val(row.userId);
	$('#beforePayMoney').val(row.beforePayMoney);
	$("#modify_success_form").modal("show");
}
function markClose(rowid){	
	var $payRecordJqgridData  = $('#payRecord_jqgrid_data');
	var row = $payRecordJqgridData.jqGrid("getRowData",rowid);	
	$('#id_close').val(row.id);
	$('#businessFlowNo_close').val(row.businessFlowNo);	
	$('#payStatus_close').val(3);	
	$('#userId_close').val(row.userId);	
	$("#modify_close_form").modal("show");
}

function savePayFlowStatus(type){
	if(type=='success'){
		var id= $('#id_success').val();
		var applyMoney = $('#applyMoney').val();		
		var payStatus= '1';
		var thirdOrderNo= $('#thirdOrderNo').val();
		var payAccount= $('#payAccount').val();
		var payMoney= $('#payMoney').val();	
		var payTime= $('#payTime').val();
		var userId = $('#userId_success').val();	
		var beforePayMoney = $('#beforePayMoney').val();
	}else if(type=='close'){
		var id= $('#id_close').val();		
		var payStatus= '3';
		var userId= $('#userId_close').val();
		var remark = $('#remark').val();
		if(remark.length>30){
			jAlert("关闭原因不能超过30个字符!","提示");
			return;
		}
	}
	$.ajax({
		url : '../pay/payHistory/modifyPayFlowRecord',
		type : "post",
		dataType : "json",
		data : {
			id:id,
			applyMoney:applyMoney,			
			payStatus:payStatus,
			thirdOrderNo:thirdOrderNo,
			payAccount:payAccount,
			payMoney:payMoney,
			payTime:payTime	,
			userId:userId,
			beforePayMoney:beforePayMoney,
			remark:remark
		}
	}).done(function(data){	
		if(data){
			jAlert("更新成功!","提示");
		}else{
			jAlert("更新异常!","提示");
		}		
		cancelPayFlowStatus();
		var $payRecordJqgridData  = $('#payRecord_jqgrid_data');
		$payRecordJqgridData.trigger("reloadGrid");		
	}).fail(function(){
		//jAlertError("系统异常","提示");
	});
}

function cancelPayFlowStatus(){
	$("#modify_success_form").modal("hide");	
	$("#modify_close_form").modal("hide");
}

function exportData(){
	var applyStartDate = $('#applyStartDate').val();
	var applyEndDate = $('#applyEndDate').val();
	var realName = $('#realName').val();
	var account = $('#account').val();
	var exportFlag = $('#exportFlag').val();
	$.ajax({
		url : '../pay/payHistory/exportPayFlowRecord/2',
		type : "post",
		dataType : "json",
		data : {
			applyStartDate:applyStartDate,
			applyEndDate:applyEndDate,			
			realName:realName,
			account:account,
			exportFlag:exportFlag
		}
	}).done(function(data){		
		if(data.flag=='noReord'){
			jAlert("没有数据可以导出!","提示");
		}else{			
			window.location.href="../pay/payHistory/downloadFile?filePath="+data.savePath;
		}
	}).fail(function(){
		//jAlertError("系统异常","提示");
	});
}

function resetData(){	
	$('#searchForm').resetForm();
	queryData();	
}

