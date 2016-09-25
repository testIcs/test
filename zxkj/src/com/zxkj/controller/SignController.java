package com.zxkj.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zxkj.common.FileTypeConst;
import com.zxkj.model.FileInfo;
import com.zxkj.model.User;
import com.zxkj.service.IFile;
import com.zxkj.service.IUser;
import com.zxkj.service.IUserFingerPrint;
import com.zxkj.util.ZWUtils;
import com.zxkj.vo.UserFingerPrintVO;

@Scope("prototype")
@Controller
@RequestMapping("/sign")
public class SignController 
{
	private static final Logger LOG = LoggerFactory.getLogger(SignController.class);
	
	@Resource
	private IUser userService; 
	
	@Resource
	private IFile fileService;
	
	@Resource
	private IUserFingerPrint userFingerPrint;
	
	@Resource
	private IUserFingerPrint ufpService;
	
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toUserNotePage.do", method = RequestMethod.GET)
	public String toUserNotePage(ModelMap modelMap){
		return "sign_manage/user_note";
	}
	
	/**
	 * @param modelMap 返回到人脸识别页面
	 * @return String 人脸识别页面
	 */
	@RequestMapping(value = "/toFaceRecPage.do", method = RequestMethod.GET)
	public String toFaceRecPage(ModelMap modelMap)
	{
		return "sign_manage/face_rec";
	}

	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toFingerEnterPage.do", method = RequestMethod.GET)
	public String toFingerEnterPage(ModelMap modelMap)
	{
		return "sign_manage/finger_enter";
	}
	
	private FileInfo packageFileInfo(Integer userId, String filePath)
	{
		FileInfo fileInfo = new FileInfo();
		String fileName = "fingerprint_" + userId + "_01.bmp";
		String fileSaveName = fileName + String.valueOf(System.currentTimeMillis());
		fileInfo.setName(fileName);
		fileInfo.setSaveName(fileSaveName);
		fileInfo.setSaveUrl(filePath);
		fileInfo.setSaveTime(new Date(System.currentTimeMillis()));
		fileInfo.setType(FileTypeConst.ZHI_WEN_FILE_TYPE);
		return fileInfo;
	}
	
	private UserFingerPrintVO packageUFPVO(Integer userId, Integer fileId)
	{
		UserFingerPrintVO ufpVO = new UserFingerPrintVO();
		ufpVO.setUserId(userId);
		ufpVO.setFingerPrintId(fileId);
		ufpVO.setAddTime(new Date(System.currentTimeMillis()));
		return ufpVO;
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 * @throws IOException 
	 */
	@RequestMapping(value = "/gainZWInfo.do", method = RequestMethod.POST)
	public void gainZWInfo(HttpServletRequest request, HttpServletResponse response) 
			throws IOException
	{
		HttpSession hs = request.getSession();
		String pjtPath = hs.getServletContext().getRealPath("");
		pjtPath = pjtPath.replace("\\", "/");
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");
		
		User userSession = (User) hs.getAttribute("user"); 
		User userDB = userService.findUserByUser(userSession);
		Integer userId = userDB.getUserId();
		// UserFingerPrintVO ufpVODB = ufpService.findUFPByUserId(userId);
		
		// 获得文件保存路径
		String filePath = pjtPath + "/zhi_wen_images/fingerprint_" + userId + "_01.bmp";
		// 生成指纹文件
		ZWUtils.makeZWImg(filePath);
		// 保存指纹文件信息
		Integer fileId = fileService.saveFileInfo(packageFileInfo(userId, filePath));
		// 保存用户文件信息
		ufpService.saveUFPVO(packageUFPVO(userId, fileId));
		
		response.getWriter().write("../zhi_wen_images/fingerprint_" + userId + "_01.bmp");
		
		// 还没有录指纹
//		if(null == ufpVODB)
//		{
//			// 获得文件保存路径
//			String filePath = pjtPath + "/zhi_wen_images/fingerprint_" + userId + "_01.bmp";
//			// 生成指纹文件
//			ZWUtils.makeZWImg(filePath);
//			// 保存指纹文件信息
//			Integer fileId = fileService.saveFileInfo(packageFileInfo(userId, filePath));
//			// 保存用户文件信息
//			ufpService.saveUFPVO(packageUFPVO(userId, fileId));
//		}
		// 已经录指纹
		/*else 
		{ 
			// 临时方案,已经录了指纹 就跳转
			response.getWriter().write("1");
			
			// 正规方案
			// 获取最新录的指纹和数据库中保存的指纹进行信息对比,指纹匹配再跳转页面
		}*/
	}
	
	@RequestMapping(value = "/toContractPage.do", method = RequestMethod.GET)
	public String toContractPage() throws IOException
	{
		return "sign_manage/contract";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toContractComparison.do", method = RequestMethod.GET)
	public String toContractComparison(ModelMap modelMap)
	{
		return "sign_manage/contract_comparison";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toSignFinish.do", method = RequestMethod.GET)
	public String toSignFinish(ModelMap modelMap)
	{
		return "sign_manage/sign_finish";
	}
}