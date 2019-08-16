package com.myshop.Dao;

import com.myshop.entity.Admin;
import com.myshop.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IAdminGoodsDao {

    //管理员添加商品
    Integer addGoods(Goods goods) throws SQLException;
    //删除删除商品
    Integer deleteGoods(Integer id) throws SQLException;
    //查看商品
    List<Goods> findAllGoods() throws SQLException;
    //修改商品信息
    Integer updataGoods(Goods goods) throws SQLException;
    //查找一个商品
    Goods findOneGoods(Integer id) throws SQLException;
}
