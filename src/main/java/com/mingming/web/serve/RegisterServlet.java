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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author h
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        UserService service = context.getBean(UserService.class);
        // 获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取验证码的值
        String checkCode = request.getParameter("checkCode");
        // 获取程序生成的验证码
        HttpSession session = request.getSession();
        Object checkCodeGen = session.getAttribute("checkCodeGen");

        User checkUser = service.selectByUsername(username);

        // 判断验证码
        System.out.println(checkCode.equals(checkCodeGen));
        if(checkCode.equalsIgnoreCase((String) checkCodeGen)){
            if(checkUser == null && !("").equals(username) && !("").equals(password)){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                service.save(user);
                // 跳转登录页面
                request.setAttribute("login_err_msg", "注册成功请登录");
                request.getRequestDispatcher("/_login.jsp").forward(request, response);
            }else{
                request.setAttribute("register_msg", "用户民重复或格式有误，换一个");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
/*        if(b && !("").equals(username) && !("").equals(password)){
            // 跳转登录页面
            request.setAttribute("login_err_msg", "注册成功请登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            request.setAttribute("register_msg", "用户民重复，换一个");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
