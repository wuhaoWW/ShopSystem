package com.wh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginOutServlet",urlPatterns = "/LoginOut")
public class loginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();//防止创建session
        if(session==null){
            response.sendRedirect("login.jsp");
            return;
        }else{
        session.invalidate();
        response.sendRedirect("login.jsp");
        }
 }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
