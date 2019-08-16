<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/14
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin_jsp/css/admin.css"/>
    <style type="text/css">
        #up_user{
            width: 30%;
            height: 40%;
            border: burlywood 1px solid;
            text-align: center;
            margin: 50px auto;
        }
        #up_user form{
            text-align: center;
            margin-top: 10px;
        }
        #up_user form input[type=text]{
            height: 30px;
            width: 200px;
            font-size: 20px;
            line-height: 20px;
            border-radius: 10px;
            margin-top: 5px;
        }
        #up_user form input[type=submit]{
            height: 24px;
            width: auto;
            border-radius: 5px;
            margin-top: 4px;
        }
    </style>
</head>
<body>
<%@ include file="include/head.jsp"%>
<div id="main">
    <%@ include file="include/left.jsp"%>
    <div id="right">
        <div id="up_user">
        <form action="${pageContext.request.contextPath}/AdminUserServlet" method="post">
            <input type="hidden" name="action" value="updateUser">
            <input type="hidden" name="id"  value="${user.u_id}">
            <lable>用户名：</lable>
            <input type="text" value="${user.u_username}" name="username"><br/>
            <lable>密码：</lable>
            <input type="text" value="${user.u_password}" name="password"><br/>
            <lable>电话：</lable>
            <input type="text" value="${user.u_telephone}" name="telephone"><br/>
            <lable>地址：</lable>
            <input type="text" value="${user.u_address}" name="address"><br/>
            <input type="submit" value="提交">
        </form>
        </div>
    </div>
</div>
<%@ include file="include/footer.jsp"%>
</body>
</html>