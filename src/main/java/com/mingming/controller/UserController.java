package com.mingming.controller;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author h
 * @date 2022/08/12
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = service.update(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = service.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }



    @GetMapping("/gp/{id}")
    public Result getProvince(@PathVariable int id) {
        String province = service.getProvince(id);
        Integer code = province != null ? Code.GET_OK : Code.GET_ERR;
        String msg = province != null ? "" : "数据查询失败，请重试";
        return new Result(code, province, msg);
    }
}
