package com.myshop.comtroller;

import com.myshop.Dao.IAdminDao;
import com.myshop.Dao.Impl.AdminDaoImpl;
import com.myshop.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "admin",urlPatterns = "/adminServlet")
public class AdminServlet extends HttpServlet {
    IAdminDao dao = new AdminDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        switch (action){
            case "login":
                login(req,resp);

                break;
            case "":
                break;
                default:
                    System.out.println("6666");
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String codename = req.getParameter("codename");
        String password = req.getParameter("password");
        Admin admin = new Admin();
        admin.setA_name(codename);
        admin.setA_pass(password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
