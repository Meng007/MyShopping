package com.myshop.comtroller;

import com.myshop.Dao.AdminUserDao;
import com.myshop.Dao.Impl.AdminUserDaoImpl;
import com.myshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminUserServlet",urlPatterns = "/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
    AdminUserDao dao = new AdminUserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        switch (action){
            case "findAllUser":
                findAllUser(request,response);
                break;
            case "findUserOne":
                findUserOne(request,response);
                break;
            case "deleteUser":
                deleteUser(request,response);
                break;
            case "updateUser":
                updateUser(request,response);
                break;
                default:
                    break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i=0;
        try {
             i= dao.deleteUser(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0){
            request.getRequestDispatcher("/AdminUserServlet?action=findAllUser").forward(request,response);
        }else {
            response.getWriter().write("修改丢失 <a href='../../index.jsp'>返回管理员主页</a>");
        }

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String id = request.getParameter("id");
        Integer i=0;
        User user = new User(Integer.parseInt(id),username,password,telephone,address);
        try {
            i = dao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i>0){
            request.getRequestDispatcher("/AdminUserServlet?action=findAllUser").forward(request,response);
        }else {
            response.getWriter().write("修改丢失 <a href='../../index.jsp'>返回管理员主页</a>");
        }

    }

    private void findUserOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user=null;
        try {
             user = dao.findUserOne(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("Admin_jsp/updateUser.jsp").forward(request,response);
        }else {
            response.getWriter().write("数据丢失 <a href='../../index.jsp'>返回管理员主页</a>");
        }

    }

    private void findAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<User> users=null;
        try {
            users = dao.findAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users!=null){
            for (User u:users
                 ) {
                System.out.println(u);
            }
            request.setAttribute("users",users);
            request.getRequestDispatcher("/Admin_jsp/user.jsp").forward(request,response);
        }else {
            response.getWriter().write("暂时没有数据<a href='/Admin_jsp/index.jsp'>返回主页</a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
