<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/13
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户|管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin_jsp/css/admin.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin_jsp/css/user.css"/>
</head>
<body>
<%@ include file="include/head.jsp"%>
<div id="main">
    <%@ include file="include/left.jsp"%>
    <div id="right">
        <div id="serach">
            <span>用户管理</span>
            <input type="button" value="删除" onclick="CommentAll()">
            <form action="" method="post" id="fl">
                <input type="text" name="keyword" maxlength="6">
                <input type="submit" value="搜索">
            </form>

        </div>
        <div id="user">
            <table border="1" cellpadding="10" cellspacing="0">
                <thead>
                    <th>全选<br/>
                        <input type="checkbox" id="checks" onclick="checkAll()">
                    </th>
                    <th>用户编号</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>操作</th>
                </thead>
                <tbody>
                   <c:forEach items="${users}" var="u">
                    <tr>
                        <td><input type="checkbox" name="ch"></td>
                        <td>${u.u_id}</td>
                        <td>${u.u_username}</td>
                        <td>${u.u_password}</td>
                        <td>${u.u_telephone}</td>
                        <td>${u.u_address}</td>
                        <td><a href="${pageContext.request.contextPath}/AdminUserServlet?action=findUserOne&id=${u.u_id}">编辑</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/AdminUserServlet?action=deleteUser&id=${u.u_id}">删除</a></td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<%@ include file="include/footer.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin_jsp/js/user.js">
</script>
<script type="text/javascript">
</script>
</body>
</html>