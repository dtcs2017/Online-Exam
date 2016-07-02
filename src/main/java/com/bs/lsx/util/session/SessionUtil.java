package com.bs.lsx.util.session;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionUtil {
    /**
     * 获取session
     * 第二个参数(enforce)是否强制生成session(true|false)
     *
     * @param request
     * @param enforce
     * @return HttpSession
     */
    public static HttpSession getSessionByRequest(HttpServletRequest request, boolean enforce) {
        return request.getSession(enforce);
    }

    /**
     * 获取验证码
     *
     * @param request
     * @return
     */
    public static String getVerifycode(HttpServletRequest request) {
        HttpSession session = getSessionByRequest(request, false);
        String rand = (String) session.getAttribute("verifycode");
        return rand;
    }

    /**
     * 获取客户端ip
     *
     * @param request
     * @return String
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
    
    /**
     * 获取UUID
     */
    public static String getUUID() {
    	return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static Object getObject(HttpServletRequest request,String key) {
        return request.getSession().getAttribute(key);
    }
    
    public static void setObject(HttpServletRequest request,String key,Object value) {
        request.getSession().setAttribute(key,value);
    }
    
    
}
