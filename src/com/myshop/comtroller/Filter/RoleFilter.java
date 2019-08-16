package com.myshop.comtroller.Filter;

import com.myshop.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy() {
        System.out.println("Role销毁方法");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Role过滤方法");
        HttpServletRequest request= (HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;
        String jsp = request.getRequestURI();
        String action = request.getParameter("action");
        Admin admin = (Admin)request.getSession().getAttribute("admin");

        if ( 1==1 ||jsp.endsWith("login.jsp") ||action.equals("findAllUser") ){
            chain.doFilter(req, resp);
        }else {
            response.getWriter().write("权限不足<a href='login.jsp'>返回登录页</a>");
        }


    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Role过滤方法");
    }

}
