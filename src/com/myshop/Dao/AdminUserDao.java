package com.myshop.Dao;

import com.myshop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminUserDao {
    //查询所有用户
    List<User> findAllUser() throws SQLException;
    //通过id查询单个用户
    User findUserOne(Integer id) throws SQLException;
    //删除用户
    Integer deleteUser(Integer id) throws SQLException;
    //修改用户信息
    Integer updateUser(User user) throws SQLException;
}
