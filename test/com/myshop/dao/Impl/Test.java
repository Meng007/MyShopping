package com.myshop.dao.Impl;

import com.myshop.Dao.AdminUserDao;
import com.myshop.Dao.Impl.AdminGoodsDaoImpl;
import com.myshop.Dao.Impl.AdminUserDaoImpl;
import com.myshop.entity.Goods;
import com.myshop.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Test {
   @org.junit.Test
    public void testAdd(){
        AdminGoodsDaoImpl dao = new AdminGoodsDaoImpl();
        Goods goods = new Goods();
        goods.setG_name("西瓜");
        goods.setPrice(50.00);
        goods.setNumber(20);
        goods.setIntroduce("好成绩考核得分回复对方的");
        Integer i=0;
        try {
            i= dao.addGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0){
            System.out.println("666");
        }else {
            System.out.println("1111");
        }

    }
    @org.junit.Test
    public void update(){
        AdminGoodsDaoImpl dao = new AdminGoodsDaoImpl();
        Goods goods = new Goods();
        goods.setG_id(2);
        goods.setG_name("辣条");
        goods.setPrice(15.2);
        goods.setNumber(20);
        goods.setIntroduce("布拉不好吃");
        Integer i = 0;
        try {
             i= dao.updataGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0){
            System.out.println("6666");
        }else {
            System.out.println("1111111");
        }
    }
@org.junit.Test
    public void testFind(){
        AdminGoodsDaoImpl dao = new AdminGoodsDaoImpl();
        try {
            Goods goods = dao.findOneGoods(2);
            System.out.println(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public  void testUserAll() throws SQLException {
        AdminUserDao pao = new AdminUserDaoImpl();
        List<User> user = pao.findAllUser();
        for (User u:user
             ) {
            System.out.println(u);
        }
    }



}
