package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author h
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String province = request.getParameter("province");
        String authority = request.getParameter("authority");

        List<User> users = service.getAll();
        boolean idFlag = false;
        boolean usernameFlag = false;
        for (User user : users) {
            if (Integer.parseInt(id) == user.getId()) {
                idFlag = true;
                break;
            }
            if (username.equals(user.getUsername())) {
                usernameFlag = true;
            }
        }

        if (!idFlag) {
            if (!usernameFlag) {
                if (password.length() >= 6 && password.length() < 18) {
                    if(password.equals(rePassword)){
                        User user = new User();
                        user.setId(Integer.parseInt(id));
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setProvince(province);
                        user.setAuthority(authority);
                        service.save(user);
                        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
                    }else{
                        request.setAttribute("addRePassword_err_msg", "两次密码不一致，请仔细检查");
                        request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
                    }
                }else{
                    request.setAttribute("addPassword_err_msg", "密码长度不对，请换一个");
                    request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("addUsername_err_msg", "用户名重复，请换一个");
                request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("addId_err_msg", "id重复，请换一个");
            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
