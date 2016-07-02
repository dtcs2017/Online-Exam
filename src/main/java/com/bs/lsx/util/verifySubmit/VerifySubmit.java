package com.bs.lsx.util.verifySubmit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bs.lsx.util.session.SessionUtil;

import java.util.UUID;

public class VerifySubmit {
    /**
     * 设置提交标识
     *
     * @param request
     * @return 提交标识
     */
    public static void setToken(HttpServletRequest request) {
        String token = UUID.randomUUID().toString();
        HttpSession session = SessionUtil.getSessionByRequest(request, false);
        session.setAttribute("token", token);
    }

    /**
     * 获取并判断提交标识
     *
     * @param request
     * @param token   提交标识
     * @return
     */
    public static boolean compareToken(HttpServletRequest request, String token) {
        boolean flag = true;
        HttpSession session = SessionUtil.getSessionByRequest(request, false);
        String stoken = (String) session.getAttribute("token");
        if (stoken == null || stoken.equals("")) {
            flag = false;
        } else {
            if (!token.equals(stoken)) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 清除token
     *
     * @param request
     */
    public static void removeToken(HttpServletRequest request) {
        HttpSession session = SessionUtil.getSessionByRequest(request, false);
        session.removeAttribute("token");
    }
}
