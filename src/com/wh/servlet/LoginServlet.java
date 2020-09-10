package com.wh.servlet;

import com.wh.Dao.Dao;
import com.wh.entity.User;
import com.wh.services.Service;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet" ,urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("name");
        String password = request.getParameter("pwd");
       Service  service=new Service();
        User user = service.loginservice(username, password);
        if(user!=null){
            //成功
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("admin_index.jsp").forward(request, response);
        }else{
            //失败
            request.setAttribute("msg","用户名或者密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
