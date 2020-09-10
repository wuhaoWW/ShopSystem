package com.wh.servlet;

import com.wh.entity.User;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet",urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        long tel = Long.parseLong(request.getParameter("tel"));
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        User user=new User( id,  name,  sex,  age,  tel,  address,  role,  pwd);
        Service service=new Service();
        boolean b = service.AddUserService(user);

        if (b){
            //添加成功
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("userAdd.jsp").forward(request, response);
        }else{
            //添加失败
            request.setAttribute("msg","添加失败");
            request.getRequestDispatcher("userAdd.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
