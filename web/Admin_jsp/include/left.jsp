<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/13
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="left">
    <ul>
        <li><a href="${pageContext.request.contextPath}/GoodsServlet?action=findGoods">商品管理</a></li>
        <li><a href="${pageContext.request.contextPath}/AdminUserServlet?action=findAllUser">用户管理</a></li>
        <li><a href="#">订单管理</a></li>
        <li><a href="#">公告管理</a></li>
        <li><a href="#">销售排行</a></li>
        <li><a href="#">问题反馈</a></li>
    </ul>
</div>
