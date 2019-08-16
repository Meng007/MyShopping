<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/13
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <p>网上购物商城管理后台</p>
    <span><a href="#">退出登录</a></span>
</header>
<nav>
    <ul>
        <li>管理员：</li>
        <li>张给</li>
        <li><a href="#">修改个人信息</a></li>
        <li>日期:
            <font color="#000000">
                <script language="JavaScript">
                    tmpDate = new Date();
                    date = tmpDate.getDate();
                    month = tmpDate.getMonth() + 1;
                    year = tmpDate.getFullYear();
                    document.write(year);
                    document.write("年");
                    document.write(month);
                    document.write("月");
                    document.write(date);
                    document.write("日 ");

                    myArray = new Array(6);
                    myArray[0] = "星期日"
                    myArray[1] = "星期一"
                    myArray[2] = "星期二"
                    myArray[3] = "星期三"
                    myArray[4] = "星期四"
                    myArray[5] = "星期五"
                    myArray[6] = "星期六"
                    weekday = tmpDate.getDay();
                    if (weekday == 0 | weekday == 6) {
                        document.write(myArray[weekday])
                    } else {
                        document.write(myArray[weekday])
                    };
                </script>
            </font>
        </li>
    </ul>
</nav>