package com.zxkj.filter;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.zxkj.util.UrlExpProcessor;

public class SessionFilter implements Filter
{

    /**
     * 需要排除的url
     */
    private static String EXCEPT_PATTERNS = "";

    /**
     * UrlExpProcessor
     */
    private static UrlExpProcessor urlExpProcessor;

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException
    {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String url = request.getRequestURL().toString();

        /**
         * 排除的url
         */
        if (isExcluded(url))
        {
            arg2.doFilter(request, response);
            return;
        }

        // 验证session中是否有user , 没有就跳转到登录页面
        User user = (User) request.getSession().getAttribute("user");
        String basePath = PropertiesConfig.getInstance().getProperty("base.url") + "/";
        if (user == null)
        {
            String requestType = request.getHeader("X-Requested-With");
            // 如果是ajax请求
            if ("XMLHttpRequest".equalsIgnoreCase(requestType))
            {
                response.setHeader("sessionstatus", "timeout");
                response.setHeader("loginPath", basePath + "jsp/loginphone.jsp");
                arg2.doFilter(arg0, arg1);
                return;
            }
            else
            {
                timeOut(response, basePath + "jsp/loginphone.jsp");
            }
        }
        else if (!checkRights(response, user, url))
        {
            // 如果没有权限
            response.sendRedirect(basePath + "jsp/forbidden.jsp");
        }
        else
        {
            arg2.doFilter(arg0, arg1);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        EXCEPT_PATTERNS += filterConfig.getInitParameter("_except_urlpattern");
    }

    /**
     * 是否排除url
     * 
     * @param url
     * @return
     */
    private boolean isExcluded(String url)
    {
        if (urlExpProcessor == null)
        {
            urlExpProcessor = new UrlExpProcessor(EXCEPT_PATTERNS);
        }
        return urlExpProcessor.match(url);
    }

    /**
     * session 失效跳转到登录页
     * 
     * @param response
     * @param loginUrl
     * @throws IOException
     */
    private void timeOut(HttpServletResponse response, String loginUrl) throws IOException
    {
        PrintWriter out = response.getWriter();
        out.append("<script type=\"text/javascript\">");
        out.append(" window.top.location.replace(\"" + loginUrl + "\")");
        out.append("</script>");
        out.flush();
        out.close();

    }

    /**
     * 权限检查，防止普通用户登录后访问后台页面
     * 
     * @param response
     * @param loginUrl
     */
    private boolean checkRights(HttpServletResponse response, User user, String url)
    {
        if (user.getRole().intValue() != -1 && url.contains("/admin/"))
        {
            return false;
        }
        return true;
    }
}
