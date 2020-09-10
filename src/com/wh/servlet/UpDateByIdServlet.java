package com.wh.servlet;

import com.mysql.cj.Session;
import com.wh.entity.User;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpDateByIdServlet",urlPatterns = "/UpDateUser")
public class UpDateByIdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html; charset=UTF-8");
                int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        long tel = Long.parseLong(request.getParameter("tel"));
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        User user=new User(id,name,sex,age,tel,address,role);
        System.out.println(user.toString());
        Service service=new Service();

           int  b = service.UpDateService(user);
        if(b!=0){
            request.setAttribute("msg","修改成功");
            HttpSession session = request.getSession();
            session.removeAttribute("Admin");
            request.getRequestDispatcher("userAdmin.jsp").forward(request, response);

        }else{
            request.setAttribute("msg","未修改成功");
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
