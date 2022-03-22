package com.aptech.controllers.post;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.models.Category;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/posts")
public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> all= PostDao.all();
        request.setAttribute("posts",all);
        request.getRequestDispatcher("posts/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        PostDao.delete(id);
        response.sendRedirect("/newsblog/posts");
    }
}
