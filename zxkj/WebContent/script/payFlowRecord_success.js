$(function(){	
	CommonDateTimePickerBind.bindStartToEndDateTimePicker("payStartDate","payEndDate");
	var $payRecordJqgridData  = $('#payRecord_jqgrid_data');
	var id ;
	$payRecordJqgridData.jqGrid({
		url : "../pay/payHistory/showPayFlowRecord/1",
        datatype : "json",
        mtype : "post",
        height : "auto",
        forceFit : true,
        rownumbers:true,
        width : 1400,
        colNames : ['序号', '业务流水号','姓名','支付渠道','提现账号','提现金额','申请时间', '支付状态', '支付流水', '支付时间', '支付账号', '支付金额','备注'],
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
            name : 'businessFlowNo',
            index : 'businessFlowNo',
            width : 120,
            align : "center",
        }, {
            name : 'realName',
            index : 'realName',
            width : 50,
            align : "center",
        }, {
            name : 'paygateName',
            index : 'paygateName',
            width : 50,
            align : "center",
        },{
            name : 'account',
            index : 'account',
            width : 100,
            align : "center"           
        },{
            name : 'applyMoney',
            index : 'applyMoney',
            width : 50,
            align : "center"
        }, {
            name : 'beginApplyDate',
            index : 'beginApplyDate',
            width : 100,
            align : "center"            
        }, {
            name : 'payStatus',
            index : 'payStatus',
            width : 50,
            align : "center",
            formatter:function(cellvalue, options, rowObject){            	
            	if(cellvalue == 0){
            		return "待支付";
            	}else if(cellvalue == 1){
            		return "支付成功";
            	}else if(cellvalue == 2){
            		return "支付失败";
            	}else if(cellvalue == 3){
            		return "支付关闭";
            	}
		     }
        }, {
        	name : 'thirdOrderNo',
        	index : 'thirdOrderNo',
        	width : 80,
        	align : 'center'
        	
        }, {
            name : 'payTime',
            index : 'payTime',
            width : 120,
            align : "center"
        },{
            name : 'payAccount',
            index : 'payAccount',
            width : 120,
            align : "center"            
        }, {
            name : 'payMoney',
            index : 'payMoney',
            width : 50,
            align : "center",            
        }, {
            name : 'payRemark',
            index : 'payRemark',
            width : 120,
            align : "center",            
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
})

function queryData(){
	var payStartDate = $('#payStartDate').val();
	var payEndDate = $('#payEndDate').val();
	var realName = $('#realName').val();
	var account = $('#account').val();
	var postData = $("#payRecord_jqgrid_data").jqGrid("getGridParam", "postData");
	postData['payStartDate'] = payStartDate;	
	postData['payEndDate'] = payEndDate;	
	postData['realName'] = realName;	
	postData['account'] = account;			
	$("#payRecord_jqgrid_data").jqGrid('setGridParam', {			
		datatype : 'json',
		postData : postData, //发送数据  
		page : 1
	}).trigger("reloadGrid");
}

function resetData(){	
	$('#searchForm').resetForm();
	queryData();	
}