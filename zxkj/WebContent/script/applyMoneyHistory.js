$(function(){	
	CommonDateTimePickerBind.bindStartToEndDateTimePicker("applyStartDate","applyEndDate");
	var $applyHistoryJqgridData  = $('#applyHistory_jqgrid_data');
	var id ;	
	$applyHistoryJqgridData.jqGrid({
		url : "../pay/payHistory/showApplyMoneyHistory",
        datatype : "json",
        mtype : "post",       
        height : "auto",
        forceFit : true,
        rownumbers:true,
        width : 1288,
        colNames : ['序号', '提现流水号', '姓名', '支付渠道', '提现账号', '提现金额', '申请时间', '审核状态', '审核人', '审核时间'],
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
        }, {
            name : 'applyFlowNo',
            index : 'applyFlowNo',
            width : 150,
            align : "center",
        }, {
            name : 'realName',
            index : 'realName',
            width : 80,
            align : "center"            
        }, {
        	name : 'paygateName',
        	index : 'paygateName',
        	width : 80,
        	align : 'center'        	
        }, {
            name : 'account',
            index : 'account',
            width : 150,
            align : "center"
        },{
            name : 'applyMoney',
            index : 'applyMoney',
            width : 80,
            align : "center"
        }, {
            name : 'beginApplyDate',
            index : 'beginApplyDate',
            width : 120,
            align : "center"            
        }, {
            name : 'applyStatus',
            index : 'applyStatus',
            width : 80,
            align : "center",
            formatter:function(cellvalue, options, rowObject){            	
            	if(cellvalue == 0){
            		return "审核中";
            	}else if(cellvalue == 1){
            		return "审核通过"
            	}else if(cellvalue == 2){
            		return "审核驳回"
            	}
		     }
        }, {
            name : 'auditUser',
            index : 'auditUser',
            width : 80,
            align : "center"
        } , {
            name : 'auditDate',
            index : 'auditDate',
            width : 120,
            align : "center"           
        }],
        rowNum : 15,
        rowList : [ 15, 30, 45 ],
        pager : '#applyHistory_jqgrid_pager',
        recordpos : 'right',
        viewrecords : true,
        pgbuttons : true,
        pginput : true,
        gridComplete: function(){
        }, 
        prmNames : {
            //search : "pageInfo.search",
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
});

function queryData(){
	var applyStartDate = $('#applyStartDate').val();
	var applyEndDate = $('#applyEndDate').val();
	var realName = $('#realName').val();
	var account = $('#account').val();
	var postData = $("#applyHistory_jqgrid_data").jqGrid("getGridParam", "postData");
	postData['applyStartDate'] = applyStartDate;	
	postData['applyEndDate'] = applyEndDate;	
	postData['realName'] = realName;	
	postData['account'] = account;			
	$("#applyHistory_jqgrid_data").jqGrid('setGridParam', {			
		datatype : 'json',
		postData : postData, //发送数据  
		page : 1
	}).trigger("reloadGrid");
}

function resetData(){	
	$('#searchForm').resetForm();
	queryData();	
}
