/**
 * 账户明细
 * @audor zhengjiaoguo love yangqianqian
 * @date 2015-07-16
 */
window.ApplyMoneyAccountDetail=(function($, module){
	
	var $currentDrawJqgridData  = $('#currentDraw_jqgrid_data');
	var $historyIncomeJqgridData  = $('#historyIncome_jqgrid_data');
	var $historyDrawJqgridData  = $('#historyDrawDetail_jqgrid_data');
	
	//加载本次提现明细数据
	function loadCurrentDrawDataGrid(){
		var userID = $('#userid').val();
		var businessFlowNo = $('#businessno').val();
		$currentDrawJqgridData.jqGrid({
			url : "../../pay/applyAudit/queryAccoutDetailDatas",
	        datatype : "json",
	    	postData:  {"businessFlow":businessFlowNo,"userID":userID},
	        mtype : "post",
	        height : "auto",
	        forceFit : true,
	        rownumbers:true,
	        width : 1100,
	        colNames : ['序号', '申请时间', '申请提现金额', '提现后余额', '历史总收益', '历史提现总额'],
	        colModel : [ {
	            name : 'id',
	            index : 'id',
	            width : 30,
	            align : "left", 
	            hidden: true,
	            formatter:function(cellvalue, options, rowObject){
	            	id = cellvalue;
		            return cellvalue;
		        }
	        },{
	            name : 'applyDate',
	            index : 'applyDate',
	            width : 100,
	            align : "center",
	            formatter:'date',
	        	formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
	        },{
	            name : 'thisDrawMoney',
	            index : 'thisDrawMoney',
	            width : 70,
	            align : "center"            
	        },{
	            name : 'surplusMoney',
	            index : 'surplusMoney',
	            width : 70,
	            align : "center"
	        }
	        /*,{
	            name : 'afterDrawMoney',
	            index : 'afterDrawMoney',
	            width : 70,
	            align : "center"
	        }*/
	        ,{
	        	name : 'historyIncomeMoney',
	        	index : 'historyIncomeMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'historyDrawMoney',
	        	index : 'historyDrawMoney',
	        	width : 70,
	        	align : 'center'
	        }],
	        rowNum : 10,
	        rowList : [ 10, 20, 30 ],
	        pager : '#accountDetail_jqgrid_pager',
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
	            root : "detailVO",
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
	
	//加载历史收益明细数据
	function loadHistoryIncomeDataGrid(){
		var userID = $('#userid').val();
		$historyIncomeJqgridData.jqGrid({
			url : "../../pay/applyAudit/queryHistoryIncomeDetail",
	        datatype : "json",
	    	postData:  {"userID":userID},
	        mtype : "post",
	        height : "auto",
	        forceFit : true,
	        rownumbers:true,
	        width : 1100,
	        colNames : ['编号', '时间', '名称', '用例收益', '缺陷收益', '奖金', '罚金', '摇大奖','砸蛋','红包', '小计'],
	        colModel : [{
	            name : 'code',
	            index : 'code',
	            width : 30,
	            align : "left"
	        },{
	            name : 'generateDate',
	            index : 'generateDate',
	            width : 100,
	            align : "center" ,
	            formatter:'date',
	        	formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
	        },{
	            name : 'prjName',
	            index : 'prjName',
	            width : 60,
	            align : "center"
	        },{
	        	name : 'testcaseMoney',
	        	index : 'testcaseMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'bugMoney',
	        	index : 'bugMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'bonusIncome',
	        	index : 'bonusIncome',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'fjMoney',
	        	index : 'fjMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'ydjMoney',
	        	index : 'ydjMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'zdMoney',
	        	index : 'zdMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'redBagMoney',
	        	index : 'redBagMoney',
	        	width : 70,
	        	align : 'center'
	        },{
	        	name : 'totalMoney',
	        	index : 'totalMoney',
	        	width : 70,
	        	align : 'center'
	        }],
	        //不分页的话，暂时先每页显示最多100条记录
	        rowNum : 100,
	        rowList : [ 10, 20, 30 ],
	        pager : '#accountDetail_jqgrid_pager',
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
	            root : "historyIncome",
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
	
	//加载历史提现记录
	function loadHistoryDrawDataGrid(){
		var userID = $('#userid').val();
		$historyDrawJqgridData.jqGrid({
			url : "../../pay/applyAudit/queryHistoryDrawMoney",
	        datatype : "json",
	    	postData:  {"userID":userID},
	        mtype : "post",
	        height : "auto",
	        forceFit : true,
	        rownumbers:true,
	        width : 1100,
	        colNames : ['序号', '申请时间', '提现前余额', '提现金额', '提现后余额', '付款状态', '付款时间'],
	        colModel : [ {
	            name : 'id',
	            index : 'id',
	            width : 30,
	            align : "left", 
	            hidden: true,
	            formatter:function(cellvalue, options, rowObject){
	            	id = cellvalue;
		            return cellvalue;
		        }
	        },{
	            name : 'applyDate',
	            index : 'applyDate',
	            width : 110,
	            align : "center",
	            formatter:'date',
	        	formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
	        },{
	            name : 'beforeDrawMoney',
	            index : 'beforeDrawMoney',
	            width : 70,
	            align : "center"            
	        },{
	            name : 'drawMoney',
	            index : 'drawMoney',
	            width : 70,
	            align : "center"
	        },{
	            name : 'afterDrawMoney',
	            index : 'afterDrawMoney',
	            width : 70,
	            align : "center"
	        },{
	        	name : 'payState',
	        	index : 'payState',
	        	width : 50,
	        	align : 'center',
	        	formatter:function(cellvalue, options, rowObject){  
	            	if(cellvalue == 1){
	            		return "支付成功";
	            	}else if(cellvalue == 3){
	            		return "支付失败已退回"
	            	}
			     }
	        },{
	        	name : 'payDate',
	        	index : 'payDate',
	        	width : 100,
	        	align : 'center',
	        	formatter:'date',
	        	formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
	        }],
	        //不分页的话，暂时先每页显示最多100条记录
	        rowNum : 100,
	        rowList : [ 10, 20, 30 ],
	        pager : '#accountDetail_jqgrid_pager',
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
	            root : "historyDraw",
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
	 * 初始化页面数据
	 */
	function init()
	{
		loadCurrentDrawDataGrid();
		loadHistoryIncomeDataGrid();
		loadHistoryDrawDataGrid();
	}
	module.init = init;
	return module;
})($, window.ApplyMoneyAccountDetail || {});

/**
 * 页面初始化（入口）
 */
(function() {
	ApplyMoneyAccountDetail.init();
})();