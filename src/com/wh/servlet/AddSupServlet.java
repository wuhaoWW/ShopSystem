package com.wh.servlet;

import com.wh.entity.Provider;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddSupServlet",urlPatterns = "/addSupplier")
public class AddSupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String supname = request.getParameter("supname");
        String supnotice = request.getParameter("supnotice");
        String name = request.getParameter("name");
        long suptel = Long.parseLong(request.getParameter("suptel"));
        String supaddress = request.getParameter("supaddress");
        String email = request.getParameter("email");

        Provider provider =new Provider(supname,supnotice,name,suptel,supaddress,email);
        System.out.println(provider.toString());
        Service service =new Service();
        int i = service.AddSupService(provider);
        if(i !=0){
            request.setAttribute("msg","供货商添加成功");
            request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
        }else{
            request.setAttribute("msg","供货商添加失败");
            request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
