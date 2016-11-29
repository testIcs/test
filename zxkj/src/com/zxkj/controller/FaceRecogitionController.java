package com.zxkj.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/face")
public class FaceRecogitionController {
	private static final Logger LOG = LoggerFactory.getLogger(FaceRecogitionController.class);
	/**
	 * 人脸识别接口,调用服务端接口进行比对
	 * @param sourceImage 源图片地址
	 * @param compareImage 要比对图片的地址
	 * @return
	 */
	@RequestMapping(value="/compare.do",method = RequestMethod.POST)
	public @ResponseBody  Map<String, Object> compare(@RequestParam("compareImage") String compareImage){
		LOG.info("compare->compareImage{}",compareImage);
		HttpClientUtil client = HttpClientUtil.getInstance();
		client.parameter("sourceImage", "D:\\610302198304222016.jpg");
		client.parameter("compareImage", compareImage);
		String result = client.call("http://192.168.3.43:8080/zyxjServer/face/compare.do");
		
		JSONObject json = JSONObject.fromObject(result);
		Map<String, Object> map = new HashMap<String, Object>();
		String similarity = json.optString("similarity");
		if(!StringUtils.isEmpty(similarity)){
			BigDecimal baseSimilarity = new BigDecimal("0.700000");
			//大于70%,比对成功
			if(new BigDecimal(similarity).compareTo(baseSimilarity)>-1){
				map.put("result", "0");
			}else{
				map.put("result", "1");
			}
		}else{
			map.put("result", "1");
		}
		return map;
	}
	
	public static void main(String[] args) {
		BigDecimal baseSimilarity = new BigDecimal("0.700000");
		System.out.println();
	}
}
