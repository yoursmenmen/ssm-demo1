package com.mingming.controller;

import com.mingming.controller.Code;
import com.mingming.controller.Result;
import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author h
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/reg")
    public Result register(@RequestParam User user) {
        User checkUser = service.selectByUsername(user.getUsername());
        if(checkUser!=null){
            return new Result(Code.SAVE_ERR, null, "用户名已存在");
        }else{
            boolean flag = service.save(user);
            return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "注册成功" : "注册失败");
        }
    }

    @PostMapping()
    public Result login(@RequestBody User user){
        System.out.println(user);
        User loginUser = service.login(user.getUsername(), user.getPassword());
        return new Result(loginUser != null ? Code.LOGIN_OK : Code.LOGIN_ERR, loginUser, loginUser != null ? "登录成功" : "登录失败");
    }

}
