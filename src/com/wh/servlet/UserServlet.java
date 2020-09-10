package com.wh.servlet;

import com.wh.Dao.Dao;
import com.wh.entity.PageBean;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        int nowPage = Integer.parseInt(request.getParameter("nowPage")==null || request.getParameter("nowPage")==""? "1":request.getParameter("nowPage"));
        PageBean pageBean=new PageBean();
        Service service=new Service();
        int total = service.UserCountService(name);
        pageBean.setTotal(total);
        pageBean.setNowPage(nowPage);
        List<User> list = service.UserService(name,pageBean);
        request.setAttribute("userList",list);
        request.setAttribute("nowPage",pageBean.getNowPage());
        request.setAttribute("total",pageBean.getTotal());
        request.setAttribute("pageCount",pageBean.getPageCount());
        request.getRequestDispatcher("userAdmin.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
