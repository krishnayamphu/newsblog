package com.aptech.controllers;

import com.aptech.dao.PostDao;
import com.aptech.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> all= PostDao.all();
        request.setAttribute("posts",all);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}
