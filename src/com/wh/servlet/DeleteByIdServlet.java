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

@WebServlet(name = "DeleteByIdServlet",urlPatterns = "/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id1 = user.getId();

        Service service =new Service();
        boolean b = service.DeleteUserService(id);
        if(b){
            request.setAttribute("msg","删除成功");
            if (id1==id){
                    session.removeAttribute("user");
                    response.sendRedirect("login.jsp");
            }else{
                request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
            }

        }else{
            request.setAttribute("msg","未删除");
            request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
