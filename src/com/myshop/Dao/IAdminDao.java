package com.myshop.Dao;

import com.myshop.entity.Admin;

import java.sql.SQLException;

public interface IAdminDao {
    //登录
    Admin findOneAdmin(Admin admin) throws SQLException;
    //
}
