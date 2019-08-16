package com.myshop.comtroller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet2",urlPatterns = "/UploadFile2")
public class UploadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            uploadFile(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void uploadFile(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        //1.创建磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.通过磁盘工厂创建上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3.解析上传请求
        List<FileItem> list = upload.parseRequest(request);

        //4.遍历请求集合
        for (FileItem file:list ) {
            //5.判断FileItem是否为普通文本字段
            if (!file.isFormField()){
                ServletContext context = request.getServletContext();
                String path = context.getRealPath("images");
                String s = UUID.randomUUID().toString();
                File pathName = new File(path);
                if (!pathName.exists()){
                    pathName.mkdir();
                }
                //6.通过FileItem对象获取输入流
                InputStream inp = file.getInputStream();
                //7.创建一个输出流对象
                FileOutputStream fos = new FileOutputStream(path+"\\"+s+"_"+file.getName());
                //8.进行读写操作
                IOUtils.copy(inp,fos);
                //9.关闭流
                inp.close();
                fos.close();
            }
        }

    }
}
