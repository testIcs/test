/**
 * 1.消息发送
 * 2.人员选择
 */
window.MessageMemberPreList = (function($, module) {

	//筛选人员
	var dialog = $("#person_fond_div");
	
	//人员id
	var userId;
	
	//复选框的值
	var chk_value =[]; 
	
	//定义form表单validate验证全局变量
	var msgFormV;
	
	var dlg_msg_center;
	
	/**
	 * 绑定每周能投入的时间下拉选择框
	 */
	function bindWeekTimeSelect() {
		var url = _baseUrl + "/commonData/findWeekTime.action";
		var errorMsg = "get weekTime is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"week_time", null, null, errorMsg);
	}
	
	/**
	 * 绑定专业领域下拉选择框
	 */
	function bindTestTypeSelect() {
		var url = _baseUrl + "/commonData/findTestType.action";
		var errorMsg = "get testType is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"test_type", null, null, errorMsg);
	}

	/**
	 * 绑定应用领域下拉选择框
	 */
	function bindApplicationTypeSelect() {
		var url = _baseUrl + "/commonData/findApplicationType.action";
		var errorMsg = "get applicationType is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"application_type", null, null, errorMsg);
	}

	/**
	 * 绑定测试类型和技能下拉选择框
	 */
	function bindTestTypeSkillSelect() {
		var url = _baseUrl + "/commonData/findTestType.action";
		var errorMsg = "get testTypeSkill is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"test_type_skills", null, null, errorMsg);
	}

	/**
	 * 绑定省份下拉框
	 */
	function bindProvince() {
		var url = _baseUrl + "/commonData/findProvince.action";
		var errorMsg = "get bind province select fail!";
		CommonAjaxHandle.bindSelectOptionData(url,"province_id", null, null, errorMsg);
	}
	
	/**
	 * 绑定测试环境下拉框
	 */
	function bindSystemTypeSelect() {
		var url = _baseUrl + "/commonData/findSystemType.action";
		var errorMsg = "get bined bench type select fail!";
		CommonAjaxHandle.bindSelectOptionData(url, "system_type", null, null, errorMsg);
	}
	
	/**
	 * 绑定移动终端品牌下拉框
	 */
	function bindPhoneBrandSelect() {
		var url = _baseUrl + "/commonData/findPhoneBrand.action";
		var errorMsg = "get phone brand selet fail!";
		CommonAjaxHandle.bindSelectOptionData(url, "phone_brand_id", null, null, errorMsg);
	}
	
	/**
	 * 测试技能与测试等级文本框联动
	 */
	function changeTypeSkillsAndSkillsLevel() {
		var selectHtml = "";
		
		//测试技能已选择固定值
		if (0 != $("#test_type_skills").val()) {
			selectHtml = "<option value='1'>专家</option>" +
				"<option value='2'>熟练</option>" +
				"<option value='3'>一般</option>" +
				"<option value='4'>了解</option>" +
				"<option value='5'>无经验</option>";
		}
		//测试技能为默认值
		else if (0 == $("#test_type_skills").val()) {
			selectHtml = "<option value='0'>请先选择测试技能</option>"; 
		}
		
		//绑定技能等级选项
		$("#skills_level").empty().append(selectHtml);
	}
	
	/**
	 * 筛选人员按钮绑定事件
	 */
	function popMemberScreenPage(){
		dialog.css("display", "block");
		dlg_msg_center = dialog.dialog({
				resizable: false,
				height: "700",
				width: "1250",
				modal: true,
				collapsible: true, 
				minimizable: true, 
				maximizable: true,
				close : function(event, ui) {
					//销毁弹出框资源
					dlg_msg_center.dialog("destroy");
					history.go(0);
				}
		});
	}
	
	/**
	 * 验证
	 */
	function validateInit(){
		msgFormV = $("#message_form").validate({
			rules: {
				"mSendInfo.messageTitle": {
					required: true,
					maxlength: 20,
					HTMLSpecialCharacterCheck:true
				},
				"mSendInfo.messageContent": {
					required: true,
					maxlength: 200,
					HTMLSpecialCharacterCheck:true
				},
				"mSendInfo.persom": {
					required: true
				},
				"mSendInfo.messageType": {
					required: true
				}
			},
			messages: {
				"mSendInfo.messageTitle": {
					required: "标题不能为空",
					maxlength : "标题最大长度为20个字符"
				},
				"mSendInfo.messageContent": {
					required: "内容不能为空",
					maxlength: "内容最大长度为200个字符"
				},
				"mSendInfo.persom": {
					required: "收件人不能为空"
				},
				"mSendInfo.messageType": {
					required: "发送类型不能为空"
				}
			},
			errorPlacement : function(error, element) {
				element.parent().find(".font03").empty().append(error);
			},
			success: function(label){
				$(label).parent().parent().find(".font03").empty();
			}
		});
	} 
	
	
	
	/**
	 * 加载团队人员列表Grid
	 */
	function loadTeamScreeningGrid() {
		var projectId = $("#hidden_project_id").val();
		var data = {"team.projectId":$("#hidden_project_id").val(),"team.memberType":2};
		$("#msg_center_jqgrid_data").jqGrid({
			url : _baseUrl + "/teamOperate/showTestUserList.action",
			mtype : "post",
			datatype : "json",
	        postData : {"user.projectId" : projectId},
			height : "auto",
			width : 1190,
			colNames : ["ID", "帐号","姓名","手机", "每周时间", "专业领域",  "应用领域", "所处地区", "测试环境", "终端类型"],
	        colModel : [ {
				name : "id",
				index : "id",
				width : 100,
				align : "center",
				sortable : false,
				hidden : true
			}, {
	            name : "userName",
	            index : "userName",
	            width : 100,
	            align : "center",
	            sortable : false
	        },  {
	            name : "realName",
	            index : "realName",
	            width : 100,
	            align : "center",
	            sortable : false
	        },  {
	            name : "phoneNo",
	            index : "phoneNo",
	            width : 100,
	            align : "center",
	            sortable : false
	        }, {
	        	name : "weekTime",
	        	index : "weekTime",
	        	width : 100,
	        	align : "center",
	        	sortable : false
	        }, {
	        	name : "testType",
	        	index : "testType",
	        	width : 150,
	        	align : "center",
	        	sortable : false
	        }, {
	            name : "applicationType",
	            index : "applicationType",
	            width : 100,
	            align : "center",
	            sortable : false
	        }, {
	            name : "province",
	            index : "province",
	            width : 100,
	            align : "center",
	            sortable : false
	        }, {
	            name : "systemType",
	            index : "systemType",
	            width : 100,
	            align : "center",
	            sortable : false
	        }, {
	            name : "phoneBrand",
	            index : "phoneBrand",
	            width : 80,
	            align : "center",
	            sortable : false
	        } ],
			multiselect : true,
			rowNum : 15,
			rowList : [15, 30, 45],
			recordpos : 'right',
			viewrecords : true,
			pgbuttons : true,
			pginput : true,
			gridComplete : function() {
				
			},
			onSelectRow : function(rowid, status) {
			},
			prmNames : {
				search : "pageInfo.search",
				page : "pageInfo.page",
				rows : "pageInfo.rows",
				sidx : "pageInfo.sidx",
				sord : "pageInfo.sord",
				nd : "pageInfo.nd"
			},
			jsonReader : {
				root : "userList",
				page : "pageInfo.page",
				records : "pageInfo.record",
				total : "pageInfo.totalPage",
				sidx : "pageInfo.sidx",
				sord : "pageInfo.sord",
				userdata : "",
				repeatitems : false
			},
			pager : '#msg_center_grid_pager'
		});
	}
	
	/**
	 * 人员搜索
	 */ 
	function searchTeamScreening() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#msg_center_jqgrid_data").jqGrid("getGridParam", "postData");
		$.each($("#msg_center_search_form").serializeArray(), function(i, n){
			var name = n.name;
			var value = n.value;
			if(value == undefined){
				postData[name] = "";
			}else{
				postData[name] = value;
			}
		});
		
		$("#msg_center_jqgrid_data").jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
		CommonHandleButton.deactiveButton("batch_delete");
	}

	/**
	 * 添加人员
	 */ 
	function addPerson() {
		var idStr = $("#user_id").val();
		var userNameStr= $("#person_receive").val();
		var ids = $("#msg_center_jqgrid_data").jqGrid('getGridParam', 'selarrrow');
		var aid = $("#user_id").val().split(",");
		var span_length = $("#tag").children("span").length;
		if(span_length + ids.length < 21 ){
			$.each(ids, function(i, n) {
				var rowData = eval($("#msg_center_jqgrid_data").jqGrid('getRowData', n));
				var userName = rowData["userName"];
				var id = rowData["id"];
				userNameStr += userName;
				userNameStr += "; ";
				idStr += ids[i];
				idStr += ",";
			});
			$("#user_id").attr("value",idStr);
			$("#user_name").attr("value",userNameStr);
			$("#user_true").attr("value",userNameStr);
			var astr = $("#user_name").val().split(";");
			for (var i = 0; i < astr.length; i++) {
				var array_element = astr[i];
				$("input[type='hidden'][name='tabinput']:last").val(array_element).trigger("blur").val("");
			}
			var aid1 = $("#user_id").val().split(",");
			for (var i = 0; i < aid1.length; i++) {
				$("#tag").children("span").eq(i).attr("value", aid1[i]);
			}
			
			//发送消息人员的id
			var aid1 = $("#user_id").val().split(",");
			//删除人员的id
			var delId = $("#delete").val().split(",");
			var tampArray= [];
			//数组去重
			tampArray = arrayTemp(aid1,delId);
//			$("#user_id").attr("value",tampArray);
			//给发送消息页面人员id赋值.
			for (var i = 0; i < tampArray.length; i++) {
				$("#tag").children("span").eq(i).attr("value", tampArray[i]);
			}
			//去掉删除人员id和选中人员重复的id
			var array1 = $("#delete").val().split(",");
			var array2 = ids;
			var array = "";
			for (var i = 0; i < array1.length ; i ++){
				for (var j = 0 ; j < array2.length ; j ++ ) {
					if (array1[i] == array2[j]) {
						break;
					} else if (array1[i] != array2[j]
						&& j == array2.length - 1) {
						if (array  == "") {
							array = array + array1[i];
						} else {
							array = array + "," + array1[i];
						}
					}
				}
			}
			$("#delete").val(array);
			
			$("#person_fond_div").dialog("destroy");
		}else{
			jAlertError("人员最多为20个!", "提示");
		}
	}

	//数组去重
	function arrayTemp(aid1,delId){
		var temp = []; //临时数组1  
	    var temparray = [];//临时数组2  
	    for (var i = 0; i < delId.length; i++) {  
	        temp[delId[i]] = true;
	    };  
	    for (var i = 0; i < aid1.length; i++) {  
	        if (!temp[aid1[i]]) {  
	            temparray.push(aid1[i]); 
	        } ;  
	    };
	    return temparray;
	}
	
	/**
	 * 判断复选框是否选中
	 */
	function checkbox(){
		var flg = true;
		var str = document.getElementsByName("box");
		var objarray = str.length;
		var chestr="";
		for (i = 0; i < objarray; i++){
		  if(str[i].checked == true){
			  chestr+=str[i].value+",";
		  }
		}
		if(chestr == ""){
		  jAlertError("请先选择发送类型～！", "提示");
		  flg = false;
		}	
		return flg;
	}
		
	var flgo = 0;
	/**
	 * 判断发送人员是否超过20人
	 */
	function jqchk(){ //jquery获取复选框值 
		var astr = $("#user_name").val().split(";");
		if (astr.leng > 20) {
			flgo ++;
		}
		return flgo;
	}
	
	/**
	 * 屏蔽消息发送按钮 
	 */
	function disableMsgSendButton(url, objThis){
		//根据请求不同,屏蔽不同按钮
		var startP = url.lastIndexOf("/");
		var endP = url.lastIndexOf(".");
		var reqStr = url.substring(startP+1, endP);
		if("sendMessage" == reqStr){
			//按钮置灰,防止多次重复操作
			CommonHandlePreventMoreClickButton.handlePreventMoreClick(objThis, "send_massage");
		}
	}
	
	/**
	 * 发送消息
	 */
	function sendMassage(url,objThis){
		//判断是否选择收件人
		if(checkbox()){
			//判断是否选择收件人
			if(0 < $("#tag").children("span").length){
				//form表单验证
				if($("#message_form").valid()){
					
					//屏蔽消息发送按钮
					disableMsgSendButton(url,objThis);
					
					$.ajax({
						url : _baseUrl + "/message/sendMessage.action",
						type : "post",
						dataType : "json",
						data : $("#message_form").serialize()
					}).done(function(data){
						setTimeout(function(){
							jAlert("发送成功!", "消息发送");
						}, 5000);
					}).fail(function(){
						setTimeout(function(){
							jAlertError("发送失败!","消息发送");
						}, 5000);
					});
					
				}else {
					//form表单再次验证
					msgFormV.form();
				}
			}else {
				jAlertError("请选择收件人!", "消息发送");
				return;
			}
		}else {
			return;
		}
	}
	
	/**
	 * 避免重复发送
	 */
	function sendMassageAgin(objThis) {
		var url = "/zxkj/zxkj/messgae/sendmessage";
		sendMassage(url, objThis);
	}
	
	function init() {
		bindWeekTimeSelect();
		bindTestTypeSelect();
		bindApplicationTypeSelect();
		bindTestTypeSkillSelect();
		bindProvince();
		bindSystemTypeSelect();
		bindPhoneBrandSelect();
		loadTeamScreeningGrid();
		validateInit();
	}

	module.init = init;
	module.disableMsgSendButton = disableMsgSendButton;
	module.sendMassageAgin = sendMassageAgin;
	module.popMemberScreenPage = popMemberScreenPage;
	module.searchTeamScreening = searchTeamScreening;
	module.addPerson = addPerson;
	module.arrayTemp = arrayTemp;
	module.sendMassage = sendMassage;
	module.checkbox = checkbox;
	module.jqchk = jqchk;
	module.changeTypeSkillsAndSkillsLevel = changeTypeSkillsAndSkillsLevel;
	
	return module;

})($,window.MessageMemberPreList || {});

$(function() {
	
	//调用模块的初始化方法
	MessageMemberPreList.init();
	
	//收件人按钮绑定时间
	$("#people_select_msg_center").on("click", function(){
		MessageMemberPreList.popMemberScreenPage();
	});
	
	// 测试技能和测试等级联动
	$("#test_type_skills").on("change", function() {
		MessageMemberPreList.changeTypeSkillsAndSkillsLevel();
	});
	
	// 检索测试人员
	$("#find_tester_msg_center").on("click", function() {
		MessageMemberPreList.searchTeamScreening();
	});
	
	// 加入人员
	$("#invitation_msg_center").on("click", function() {
		MessageMemberPreList.addPerson();
	});
	
	//绑定发送按钮
	$("#send_massage").on("click",function(){
		MessageMemberPreList.sendMassageAgin(this);
	});
	
	//返回消息发送页面
	$("#return_msg_center").on("click", function() {
		$(".ui-icon-closethick").trigger("click");
		history.go(0);
	});
	
	$("#tag").tabControl({maxTabCount:20,tabW:80},"");
	$("#getTab").click(function(){
		var v = $("#tag").getTabVals();
	});
	
});
