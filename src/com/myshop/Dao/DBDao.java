package com.myshop.Dao;

import com.myshop.entity.User;
import com.myshop.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DBDao {
    public List<User> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql="select * from user";
        List<User> list = (List<User>) runner.query(sql, new BeanListHandler<>(User.class));
        return list;
    }
}
