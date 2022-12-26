package com.mingming.service;

import com.mingming.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

/**
 * 用户服务
 *
 * @author h
 * @date 2022/08/12
 */
@Transactional(rollbackFor = {IOException.class})
public interface UserService {
    /**
     * 保存
     *
     * @param user 用户
     * @return boolean
     */
    public boolean save(User user);

    /**
     * 更新
     *
     * @param user 用户
     * @return boolean
     */
    public boolean update(User user);

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    public boolean delete(int id);

    /**
     * 得到所有
     *
     * @return {@link List}<{@link User}>
     */
    public List<User> getAll();

    /**
     * 通过id
     *
     * @param id id
     * @return {@link User}
     */
    public User getById(int id);


    /**
     * 获得省
     *
     * @param id id
     * @return {@link String}
     */
    public String getProvince(int id);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    public User login(String username, String password);


    /**
     * 选择用户名
     *
     * @param username 用户名
     * @return boolean
     */
    public User selectByUsername(String username);


}
