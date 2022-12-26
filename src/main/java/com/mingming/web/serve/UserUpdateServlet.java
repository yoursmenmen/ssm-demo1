package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import com.mysql.cj.util.DnsSrv;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String province = request.getParameter("province");
        String authority = request.getParameter("authority");

        User user = new User();

        System.out.println(id);

        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setProvince(province);
        user.setAuthority(authority);

        service.update(user);

        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
