package com.myshop.Dao.Impl;

import com.myshop.Dao.AdminUserDao;
import com.myshop.entity.User;
import com.myshop.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminUserDaoImpl implements AdminUserDao {


    private QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public List<User> findAllUser() throws SQLException {
      String sql = "select * from user where is_delete=1";
        List<User> list = runner.query(sql, new BeanListHandler<>(User.class));
        return list;
    }

    @Override
    public User findUserOne(Integer id) throws SQLException {
        String sql = "select * from user where u_id=?";
        User user = runner.query(sql, new BeanHandler<>(User.class), id);
        return user;
    }

    @Override
    public Integer deleteUser(Integer id) throws SQLException {
        String sql = "update user set is_delete=0 where u_id =?";
        int i = runner.update(sql,id);
        return i;
    }
    @Override
    public Integer updateUser(User user) throws SQLException {
        String sql= "update user set u_username=?,u_password=?,u_telephone=?,u_address=? where u_id=?";
        int i = runner.update(sql, new Object[]{
                user.getU_username(),
                user.getU_password(),
                user.getU_telephone(),
                user.getU_address(),
                user.getU_id()
        });
        return i;
    }
}
