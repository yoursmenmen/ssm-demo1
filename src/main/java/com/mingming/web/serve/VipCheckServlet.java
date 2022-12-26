package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author h
 */
@WebServlet("/vipCheckServlet")
public class VipCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        UserService service = context.getBean(UserService.class);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user.getId() == 1){
            List<User> users = service.getAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/userList.jsp").forward(request, response);
        }else{
            request.setAttribute("check_msg","check()");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
