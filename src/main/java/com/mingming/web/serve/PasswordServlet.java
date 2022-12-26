package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

/**
 * @author h
 */
@WebServlet("/passwordServlet")
public class PasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String reNewPassword = request.getParameter("reNewPassword");


        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(oldPassword.equals(user.getPassword())){
            if(Objects.equals(newPassword, reNewPassword) && !("").equals(newPassword)){
                user.setPassword(newPassword);
                service.update(user);
                request.setAttribute("login_err_msg", "修改成功,请重新登陆");
                request.getRequestDispatcher("/_login.jsp").forward(request, response);
            }else{
                request.setAttribute("password_msg", "修改失败,两次输入密码不同");
                request.getRequestDispatcher("/password.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("password_msg", "修改失败，原密码输入错误");
            request.getRequestDispatcher("/password.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
