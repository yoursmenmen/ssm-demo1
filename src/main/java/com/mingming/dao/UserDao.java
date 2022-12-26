package com.mingming.dao;

import com.mingming.pojo.User;
import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户刀
 *
 * @author h
 * @date 2022/08/12
 */
public interface UserDao {
    /**
     * 保存
     *
     * @param user 用户
     */
    @Insert("insert into test1.t2 values(#{id}, #{username}, #{password}, #{province}, #{authority})")
    public void save(User user);


    /**
     * 更新
     *
     * @param user 用户
     * @return boolean
     */
    @Update("update test1.t2 set username=#{username}, password=#{password}, province=#{province} ,authority=#{authority} where id=#{id}")
    public boolean update(User user);

    /**
     * 删除
     *
     * @param id id
     */
    @Delete("delete from test1.t2 where id=#{id}")
    public void delete(int id);

    /**
     * 得到所有
     *
     * @return {@link List}<{@link User}>
     */
    @Select("select * from test1.t2")
    public List<User> getAll();

    /**
     * 通过id
     *
     * @param id id
     * @return {@link User}
     */
    @Select("select * from test1.t2 where id=#{id}")
    public User getById(int id);

    /**
     * 获得省
     *
     * @param id id
     * @return {@link String}
     */
    @Select("select province from test1.t2 where id=#{id}")
    public String getProvince(int id);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    @Select("select * from test1.t2 where username=#{username} and password=#{password}")
    public User login(@Param("username") String username, @Param("password") String password);


    /**
     * 选择用户名
     *
     * @param username 用户名
     * @return boolean
     */
    @Select("select * from test1.t2 where username=#{username}")
    public User selectByUsername(String username);


}
