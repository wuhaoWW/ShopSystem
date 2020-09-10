package com.wh.servlet;

import com.wh.entity.Provider;
import com.wh.services.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SupListServlet",urlPatterns = "/merchantsSelect")
public class SupListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String providerName = request.getParameter("providerName");
        String providerDesc = request.getParameter("providerDesc");
        Service service =new Service();
        List<Provider> providers = service.SupSelService(providerName, providerDesc);
        request.setAttribute("suppliers",providers);
        request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
