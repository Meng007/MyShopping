package com.myshop.comtroller;

import com.myshop.Dao.IAdminGoodsDao;
import com.myshop.Dao.Impl.AdminGoodsDaoImpl;
import com.myshop.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GoodsServlet",urlPatterns = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    IAdminGoodsDao dao = new AdminGoodsDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "findGoods":
                try {
                    findGoods(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "findOneGoods":
                try {
                    findOneGoods(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteGoods":

                break;
        }
    }

    private void findOneGoods(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Goods goods = dao.findOneGoods(Integer.parseInt(id));
        if (goods!=null) {
            request.setAttribute("goods", goods);
            request.getRequestDispatcher("/").forward(request, response);
        }else {
            response.getWriter().write("修改丢失 <a href='../../index.jsp'>返回管理员主页</a>");
        }
    }

    private void findGoods(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Goods> list = dao.findAllGoods();
        if (list!=null){
            request.setAttribute("goods",list);
            request.getRequestDispatcher("/Admin_jsp/addGoods.jsp").forward(request,response);
        }else {
            response.getWriter().write("修改丢失 <a href='../../index.jsp'>返回管理员主页</a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
