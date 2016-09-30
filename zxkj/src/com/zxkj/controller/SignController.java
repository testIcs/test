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
	 * @param modelMap 杩斿洖鍒扮绾︽ā鍧�-鐢ㄦ埛椤荤煡椤甸潰
	 * @return String 棣栭〉鍚嶇О
	 */
	@RequestMapping(value = "/toUserNotePage.do", method = RequestMethod.GET)
	public String toUserNotePage(ModelMap modelMap){
		return "sign_manage/user_note";
	}
	
	/**
	 * @param modelMap 杩斿洖鍒颁汉鑴歌瘑鍒〉闈�
	 * @return String 浜鸿劯璇嗗埆椤甸潰
	 */
	@RequestMapping(value = "/toFaceRecPage.do", method = RequestMethod.GET)
	public String toFaceRecPage(ModelMap modelMap)
	{
		return "sign_manage/face_rec";
	}

	/**
	 * @param modelMap 杩斿洖鍒扮绾︽ā鍧�-鐢ㄦ埛椤荤煡椤甸潰
	 * @return String 棣栭〉鍚嶇О
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
	 * @param modelMap 杩斿洖鍒扮绾︽ā鍧�-鐢ㄦ埛椤荤煡椤甸潰
	 * @return String 棣栭〉鍚嶇О
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
		Integer userId =1; //userDB.getUserId();
		// UserFingerPrintVO ufpVODB = ufpService.findUFPByUserId(userId);
		
		// 鑾峰緱鏂囦欢淇濆瓨璺緞
		String filePath = pjtPath + "/zhi_wen_images/fingerprint_" + userId + "_01.bmp";
		// 鐢熸垚鎸囩汗鏂囦欢
		ZWUtils.makeZWImg(filePath);
		// 淇濆瓨鎸囩汗鏂囦欢淇℃伅
		Integer fileId = fileService.saveFileInfo(packageFileInfo(userId, filePath));
		// 淇濆瓨鐢ㄦ埛鏂囦欢淇℃伅
		ufpService.saveUFPVO(packageUFPVO(userId, fileId));
		
		response.getWriter().write("../zhi_wen_images/fingerprint_" + userId + "_01.bmp");
		
		// 杩樻病鏈夊綍鎸囩汗
//		if(null == ufpVODB)
//		{
//			// 鑾峰緱鏂囦欢淇濆瓨璺緞
//			String filePath = pjtPath + "/zhi_wen_images/fingerprint_" + userId + "_01.bmp";
//			// 鐢熸垚鎸囩汗鏂囦欢
//			ZWUtils.makeZWImg(filePath);
//			// 淇濆瓨鎸囩汗鏂囦欢淇℃伅
//			Integer fileId = fileService.saveFileInfo(packageFileInfo(userId, filePath));
//			// 淇濆瓨鐢ㄦ埛鏂囦欢淇℃伅
//			ufpService.saveUFPVO(packageUFPVO(userId, fileId));
//		}
		// 宸茬粡褰曟寚绾�
		/*else 
		{ 
			// 涓存椂鏂规,宸茬粡褰曚簡鎸囩汗 灏辫烦杞�
			response.getWriter().write("1");
			
			// 姝ｈ鏂规
			// 鑾峰彇鏈�鏂板綍鐨勬寚绾瑰拰鏁版嵁搴撲腑淇濆瓨鐨勬寚绾硅繘琛屼俊鎭姣�,鎸囩汗鍖归厤鍐嶈烦杞〉闈�
		}*/
	}
	
	@RequestMapping(value = "/toContractPage.do", method = RequestMethod.GET)
	public String toContractPage() throws IOException
	{
		return "sign_manage/contract";
	}
	
	/**
	 * @param modelMap 杩斿洖鍒扮绾︽ā鍧�-鐢ㄦ埛椤荤煡椤甸潰
	 * @return String 棣栭〉鍚嶇О
	 */
	@RequestMapping(value = "/toContractComparison.do", method = RequestMethod.GET)
	public String toContractComparison(ModelMap modelMap)
	{
		return "sign_manage/contract_comparison";
	}
	
	/**
	 * @param modelMap 杩斿洖鍒扮绾︽ā鍧�-鐢ㄦ埛椤荤煡椤甸潰
	 * @return String 棣栭〉鍚嶇О
	 */
	@RequestMapping(value = "/toSignFinish.do", method = RequestMethod.GET)
	public String toSignFinish(ModelMap modelMap)
	{
		return "sign_manage/sign_finish";
	}
}