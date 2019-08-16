<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/8/13
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      #img{
        height: 200px;
        width: 200px;
        border:1px solid darkcyan ;
      }
    </style>
  </head>
  <body>
  <form action="UploadFile2" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="chooseImage" width="200px"><br/>
    <div id="img"></div>
<%--    <img id="cropedBigImg" value='custom' title="自定义背景">--%>
    <input type="submit" value="上传">
  </form>
  <script type="text/javascript" src="Admin_jsp/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
    $('#chooseImage').on('change', function () {
      $(".cropedBigImg").remove();
      var filePath = $(this).val(), //获取到input的value，里面是文件的路径
         fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
         src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
         // 检查是否是图片
      if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
          error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
              return;
           }
      $("#img").html("<img src='' id='cropedBigImg' height='200px' width='200px'/>")
      $('#cropedBigImg').attr('src', src);
    });
  </script>
  <%-- 1234567890 --%>
  </body>
</html>
