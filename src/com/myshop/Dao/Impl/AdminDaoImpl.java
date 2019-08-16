package com.myshop.Dao.Impl;

import com.myshop.Dao.IAdminDao;
import com.myshop.entity.Admin;
import com.myshop.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDaoImpl implements IAdminDao {
    QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public Admin findOneAdmin(Admin admin) throws SQLException {
        String sql ="select * from admin where a_username=? and a_password";
        Admin query = runner.query(sql, new BeanHandler<>(Admin.class), new Object[]{
                admin.getA_name(),admin.getA_pass()
        });
        return query;
    }
}
