package com.zxkj.controller;

import java.io.IOException;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.common.FileTypeConst;
import com.zxkj.model.FileInfo;
import com.zxkj.service.IFile;
import com.zxkj.service.IUser;
import com.zxkj.service.IUserFingerPrint;
import com.zxkj.util.FileUtil;
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
	 * @param modelMap 
	 * @return String 
	 */
	@RequestMapping(value = "/toUserNotePage.do", method = RequestMethod.GET)
	public String toUserNotePage(ModelMap modelMap){
		return "sign_manage/user_note";
	}
	
	/**
	 * @param modelMap 
	 * @return String 
	 */
	@RequestMapping(value = "/toFaceRecPage.do", method = RequestMethod.GET)
	public String toFaceRecPage(ModelMap modelMap)
	{
		return "sign_manage/face_rec";
	}

	/**
	 * @param modelMap 
	 * @return String 
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
	
	private String gainPjtPath(HttpServletRequest request)
	{
		HttpSession hs = request.getSession();
		String pjtPath = hs.getServletContext().getRealPath("");
		pjtPath = pjtPath.replace("\\", "/");
		return pjtPath;
	}
	
	/**
	 * 生成一个文件夹 
	 */
	private String makeFolder(HttpServletRequest request)
	{
		String folderPath = gainPjtPath(request) + "/zhi_wen_images/" + System.currentTimeMillis();
		FileUtil.makeFolderByPath(folderPath);
		return folderPath;
	}
	
	/**
	 * @param modelMap 
	 * @return String 
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/startSignFinger.do", method = RequestMethod.GET)
	public String startSignFinger(HttpServletRequest request, ModelMap modelMap) 
			throws IOException
	{
		String folderPath = makeFolder(request);
		// 
		Integer startFlag = ZWUtils.makeZWImg(folderPath);
		
		return folderPath + "--" + startFlag;
	}
	
	@ResponseBody
	@RequestMapping(value = "/judgeFingerExist.do", method = RequestMethod.GET)
	public String judgeFingerExist(@RequestParam("folderPath") String folderPath)
	{
		return FileUtil.judgeFileExist(folderPath) + "";
	}
	
	@RequestMapping(value = "/toContractPage.do", method = RequestMethod.GET)
	public String toContractPage() throws IOException
	{
		return "sign_manage/contract";
	}
	
	/**
	 * @param modelMap 
	 * @return String 
	 */
	@RequestMapping(value = "/toContractComparison.do", method = RequestMethod.GET)
	public String toContractComparison(ModelMap modelMap)
	{
		return "sign_manage/contract_comparison";
	}
	
	/**
	 * @param modelMap 
	 * @return String 
	 */
	@RequestMapping(value = "/toSignFinish.do", method = RequestMethod.GET)
	public String toSignFinish(ModelMap modelMap)
	{
		return "sign_manage/sign_finish";
	}
}