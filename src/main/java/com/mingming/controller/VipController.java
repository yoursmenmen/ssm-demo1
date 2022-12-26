package com.mingming.controller;

import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author h
 */
@RestController
@RequestMapping("/vips")
public class VipController {

    @Autowired
    private UserService service;

    // 特殊

    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = service.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

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

    // 特殊

    @GetMapping("/{id}")
    public Result getById(@PathVariable int id) {
        User user = service.getById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试";
        return new Result(code, user, msg);
    }

    // 特殊

    @GetMapping
    public Result getAll() {
        List<User> users = service.getAll();
        Integer code = users != null ? Code.GET_OK : Code.GET_ERR;
        String msg = users != null ? "" : "数据查询失败，请重试";
        return new Result(code, users, msg);
    }

    @GetMapping("/gp/{id}")
    public Result getProvince(@PathVariable int id) {
        String province = service.getProvince(id);
        Integer code = province != null ? Code.GET_OK : Code.GET_ERR;
        String msg = province != null ? "" : "数据查询失败，请重试";
        return new Result(code, province, msg);
    }
}
