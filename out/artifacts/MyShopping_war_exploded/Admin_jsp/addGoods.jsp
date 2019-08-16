<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/15
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加|商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin_jsp/css/admin.css"/>
    <style type="text/css">
        #nav{
            height: 60px;
            width: auto;
            border: chartreuse 1px solid;
            position: relative;
            position: relative;
        }
        input[type=button]{
            height: 40px;
            width: 60px;
            border: 2px indianred solid;
            border-radius: 5px;
        }
        input[type=button]:hover{
            background-color: lightcoral;
        }
        ul li{
            list-style-type: none;
            float: left;
            margin-left:10px ;
        }
        #fl{
            float: left;
            position: absolute;
            right: 100px;
            bottom: 10px;
        }
        #nav #fl input[type=text]{
            height: 40PX;
            width: 200px;
            font-size: 20px;
            line-height: 20px;
            border-radius: 5px;
        }
        #nav #fl input[type=submit]{
            height: 40PX;
            width: 40px;
            border-radius: 5px;
        }
        table{
            margin: 20px auto;

        }
        table tr td{
            text-align: center;

        }
        #addgoods{
            display: none;
            border: 1px solid red;
            text-align: center;
        }
        #addgoods input[type=text]{
            height: 20PX;
            width: 150px;
            font-size: 20px;
            line-height: 20px;
            border-radius: 5px;
            margin-top: 8px;
        }
        #addgoods input[type=submit]{
            height: 20PX;
            width: 40px;
            border-radius: 5px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<%@ include file="include/head.jsp"%>
<div id="main">
    <%@ include file="include/left.jsp"%>
    <div id="right">
        <div id="nav">
            <span>添加|商品</span>
            <ul>
                <li><input type="button" value="添加" id="add" onclick="add()"></li>
                <li><input type="button" value="删除" id="delete"></li>
                <li><input type="button" value="修改" id="up"></li>
            </ul>
            <form action="" method="post" id="fl">
                <input type="text" name="keyword" maxlength="6">
                <input type="submit" value="搜索">
            </form>
        </div>
        <div id="show">
            <table border="1" cellspacing="0" cellpadding="5">
                <thead>
                    <th>全选<br/><input type="checkbox" id="all" value="全选"></th>
                    <th>编号</th>
                    <th>名称</th>
                    <th>介绍</th>
                    <th>价格</th>
                    <th>库存</th>
                </thead>
                <tbody>
                <c:forEach items="${goods}" var="g">
                <tr>
                    <td><input type="checkbox" name="ch"></td>
                    <td>${g.g_id}</td>
                    <td>${g.g_name}</td>
                    <td>${g.introduce}</td>
                    <td>${g.price}</td>
                    <td>${g.number}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="addgoods">
            <form action="" method="post" enctype="multipart/form-data">
                <lable>名称</lable>
                <input type="text" name="g_name"><br/>
                <lable>价格</lable>
                <input type="text" name="price"><br/>
                <lable>数量</lable>
                <input type="text" name="number"><br/>
                <lable>描述</lable><br/>
                <textarea name="introduce" rows="5" cols="20"></textarea><br/>

                <input type="file" name="file" value="图片"><br/>
                <input type="submit" value="提交"/>

            </form>
        </div>
    </div>
</div>
<%@ include file="include/footer.jsp"%>
<script type="text/javascript" src="Admin_jsp/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function add() {
        $("#show").css("display","none");
        $("#addgoods").css("display","block")
    }
</script>
</body>
</html>