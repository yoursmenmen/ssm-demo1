package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        String remember = request.getParameter("remember");
        // 调用service查询
        User user = service.login(username, password);
        if (user != null) {
            // 登陆成功， 跳转到查询所有，由于没有数据共享，所以使用重定向即可
            // 判断用户是否记住
            if ("1".equals(remember)) {
                // 用户勾选复选框
                Cookie cUsername = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);

                // 设置存活时间
                cUsername.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);

                //发送cookie
                response.addCookie(cUsername);
                response.addCookie(cPassword);

            }

            // 将登陆成功的user存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/index.jsp");

        } else {
            // 登陆失败
            // 存储错误信息
            request.setAttribute("login_err_msg", "别瞎几把填");
            request.getRequestDispatcher("/_login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
