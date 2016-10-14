/**
 * 获取微信客户端openId
 * @returns {String}
 */
function getQueryString(name) {  
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");   
	var r = window.location.search.substr(1).match(reg);    
	if (r != null) return unescape(r[2]); return null;   
}
function trim(str) {  return str.replace(/(^\s+)|(\s+$)/g, "");}
function getOpenId()
{
	var openId="";
	var code = getQueryString("code");
	$.ajax({ 
		async: false,       
		url: "https://woowtest.jointforce.com/php/software/test.php", //这是我的服务端处理文件php的     
		type: "GET",       //下面几行是jsoup，如果去掉下面几行的注释，后端对应的返回结果也要去掉注释        
		data: {code:code}, //传递本页面获取的code到后台，以便后台获取openid      
		timeout: 5000,       
		success: function (result) { 
			openId = result;  
		},       
		error: function (jqXHR, textStatus, errorThrown) {
			openId = "";
		}   
	});
	return trim(openId);
}


