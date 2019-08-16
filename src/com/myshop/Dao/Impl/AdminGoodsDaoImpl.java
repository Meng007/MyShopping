package com.myshop.Dao.Impl;

import com.myshop.Dao.IAdminGoodsDao;
import com.myshop.entity.Goods;
import com.myshop.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminGoodsDaoImpl implements IAdminGoodsDao {
    QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public Integer addGoods(Goods goods) throws SQLException {
        String sql = "insert into goods (g_name,introduce,price,number) values(?,?,?,?)";
        int i = runner.update(sql, goods.getG_name(), goods.getIntroduce(), goods.getPrice(), goods.getNumber());
        return i;
    }

    @Override
    public Integer deleteGoods(Integer id) throws SQLException {
        String sql = "update goods set is_delete = 0 where g_id = ?";
        int i = runner.update(sql,id);
        return i;
    }

    @Override
    public List<Goods> findAllGoods() throws SQLException {
        String sql = "select * from goods where is_delete=1";
        List<Goods> list = runner.query(sql, new BeanListHandler<>(Goods.class));
        return list;
    }

    @Override
    public Integer updataGoods(Goods goods) throws SQLException {
        String sql = "update goods set g_name=?,introduce=?,price=?,number=? where g_id=?";
        int i = runner.update(sql,new Object[]{
                goods.getG_name(),
                goods.getIntroduce(),
                goods.getPrice(),
                goods.getNumber(),
                goods.getG_id()
        });
        return i;
    }

    @Override
    public Goods findOneGoods(Integer id) throws SQLException {
        String sql = "select * from goods where g_id = ?";
        Goods goods = runner.query(sql, new BeanHandler<>(Goods.class),id);
        return goods;
    }
}
