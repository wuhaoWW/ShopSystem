package com.wh.servlet;

import com.wh.entity.Check;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Bill_List_Servlet" , urlPatterns = "/findAllCheckByTag")
public class Bill_List_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String paymoney = request.getParameter("paymoney");
        Service service=new Service();
        List<Check> checks = service.checkService(name, paymoney);
        request.setAttribute("list",checks);
        request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
