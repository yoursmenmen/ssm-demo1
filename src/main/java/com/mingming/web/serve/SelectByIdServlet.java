package com.mingming.web.serve;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);
        // 接收id
        String id = request.getParameter("id");
        // 查询
        User user = service.getById(Integer.parseInt(id));
        // 存储到request域中
        request.setAttribute("user", user);
        // 转发到对应的jsp页面
        request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
