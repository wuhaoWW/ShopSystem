package com.wh.servlet;

import com.wh.entity.Check;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCheckServlet",urlPatterns = "/InsertServlet")
public class AddCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        long number = Long.parseLong(request.getParameter("number"));
        double money = Double.parseDouble(request.getParameter("money"));
        String notice = request.getParameter("notice");
        String supname = request.getParameter("supname");
        String paymoney = request.getParameter("paymoney");
        String date = request.getParameter("time");
        Check check=new Check(name,number,money,paymoney,supname,notice,date);
        Service service =new Service();
        int i = service.AddCheckService(check);
        if (i!=0){
            //新增成功
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
        }else{
            //添加失败
            request.setAttribute("msg","添加失败");
            request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
