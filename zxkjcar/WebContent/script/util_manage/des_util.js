/**
 * 公共加密解密方法
 */
window.DesUtilModule = (function($, module) {
	
	/**
	 * 加密 
	 */
	function encryptByDES(message, key) {
	    return String(CryptoJS.DES.encrypt(message, 
	    				CryptoJS.enc.Utf8.parse(key), 
	    				{
	        				mode: CryptoJS.mode.ECB,
	        				padding: CryptoJS.pad.Pkcs7
	    				}
	    			)
	    		);
	}
	 
	/**
	 * Decrypt ciphertext by DES in ECB mode and Pkcs7 padding scheme
	 * 
	 * @param  {String} ciphertext(base64 string)
	 * @param  {String} key
	 * @return {String} plaintext
	 */
	function decryptByDES(ciphertext, key) {
	    return CryptoJS.DES.decrypt(
				{
					ciphertext: CryptoJS.enc.Base64.parse(ciphertext)
				}, 
				CryptoJS.enc.Utf8.parse(key), 
				{
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				}
			).toString(CryptoJS.enc.Utf8);
	}

	module.encryptByDES = encryptByDES;
	module.decryptByDES = decryptByDES;
	
	return module;
	
})($, window.DesUtilModule || {})

