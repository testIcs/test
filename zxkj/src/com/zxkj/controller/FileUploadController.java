package com.zxkj.controller;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件上传控制器
 * @author liulong
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	/**
	 * 上传图片
	 * @param imageData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadImage.do", method = RequestMethod.POST)
	public JSONObject uploadImage(String imageData){
		Base64 base64 = new Base64();
		//base64 decode image
		byte[] b = base64.decode(imageData.substring("data:image/png;base64,".length()).getBytes());
		String fileName = String.valueOf(System.currentTimeMillis());
		//image path
		String filePath = "d:" + File.separator + fileName + ".png";
		//write image
		File file = new File(filePath);
		
		JSONObject json = new JSONObject();
		try {
			FileUtils.writeByteArrayToFile(file, b);
			
			json.put("result", "0");
		} catch (IOException e) {
			json.put("result", "1");
		}
		
		return json;
	}
}
