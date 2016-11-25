package com.zxkj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.util.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 *
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
	public Map<String, Object> uploadImage(String imageData){
		imageData = imageData.substring("data:image/png;base64,".length());
		HttpClientUtil client = HttpClientUtil.getInstance();
		client.parameter("imageData", imageData);
		String result = client.call("http://192.168.3.43:8080/zyxjServer/file/toUpLoadFile.do");
		
		JSONObject json = JSONObject.fromObject(result);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", json.optString("result"));
		map.put("filePath", json.optString("filePath"));
		return map;
	}
}
