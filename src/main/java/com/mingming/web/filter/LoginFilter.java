package com.mingming.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author h
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        // 判断资源是否与登录相关
        String[] urls = {
                "/login.jsp",
                "/imgs/",
                "/css/",
                "/loginServlet",
                "/register.jsp",
                "/registerServlet",
                "/checkCodeServlet"
        };
        // 获取访问路径
        String url = req.getRequestURL().toString();

        for (String s : urls) {
            if(url.contains(s)){
                chain.doFilter(request, response);
                return ;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("login_err_msg", "你还没登陆傻鸟");
            req.getRequestDispatcher("/_login.jsp").forward(req, response);
        }


    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }


}