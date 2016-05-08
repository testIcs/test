package com.zxkj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxkj.model.User;
import com.zxkj.util.PropertiesConfig;


public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;	
		HttpServletResponse response = (HttpServletResponse) arg1;
		//获取根目录(/LightTowerPay)
		//String path = request.getContextPath();
		//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String basePath = PropertiesConfig.getInstance().getProperty("base.url") +"/";
		String url=request.getRequestURL().toString();
		//如果是登录页面, 过滤验证
		if(url.indexOf("paylogin.jsp")>0){
			arg2.doFilter(arg0,arg1);			
		}else{
			//验证session中是否有user , 没有就跳转到登录页面
			User user = (User) request.getSession().getAttribute("user");
			if(user==null){
				response.sendRedirect(basePath+"paylogin.jsp");				
			}else{
				arg2.doFilter(arg0,arg1);
			}	
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
