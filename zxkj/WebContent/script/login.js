$(function(){
		/**
		登陆用户密码
		**/
		$('#tester_login_submit').click(function(){
			var username = document.getElementById('userName').value;
			var pass = document.getElementById('password').value;
			
			if('null' == username || "" == username || 'null' == pass || "" == pass)
			{
				$('#check').html("<font color='red'><b>用户名或密码为空</b></font>");
				return;
			}
			var key = '123!@#Qaz';
			var password = encryptByDES(pass, key); 
			$.ajax( {    
				url:'/zxkj/zxkj/user/login',// 跳转到 action        
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					userName:username,
					password:password
				},
				headers:[{"Access-Control-Allow-Origin":"localhost,127.0.0.1"}],
				success:function(data) {    
					if("0" == data.status){    
						 window.location.href='jsp/home.jsp';
					}else{    
						$('#check').html("<font color='red'><b>用户名或密码错误</b></font>");    
					}
				 }
				
			});
			
		});
});

function request(paras)
{ 
	var url = location.href; 
	var paraString = url.substring(url.indexOf("?")+1,url.length).split("&"); 
	var paraObj = {} 
	for (i=0; j=paraString[i]; i++){ 
		paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
	} 
	var returnValue = paraObj[paras.toLowerCase()]; 
	if(typeof(returnValue)=="undefined"){ 
		return ""; 
	}else{ 
		return returnValue; 
	} 
}




//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  


function encryptByDES(message, key) {

    var keyHex = CryptoJS.enc.Utf8.parse(key);

    var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });

    return encrypted.toString();
}
 
/**
 * Decrypt ciphertext by DES in ECB mode and Pkcs7 padding scheme
 * 
 * @param  {String} ciphertext(base64 string)
 * @param  {String} key
 * @return {String} plaintext
 *
 * @author Sun
 * @version 2013-5-15
 */
function decryptByDES(ciphertext, key) {
    var keyHex = CryptoJS.enc.Utf8.parse(key);
 
    var decrypted = CryptoJS.DES.decrypt({
        ciphertext: CryptoJS.enc.Base64.parse(ciphertext)
    }, keyHex, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });
 
    return decrypted.toString(CryptoJS.enc.Utf8);
}

