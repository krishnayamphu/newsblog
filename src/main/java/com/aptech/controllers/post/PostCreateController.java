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

@WebServlet("/post-create")
public class PostCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories=CategoryDao.all();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("posts/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String image=request.getParameter("image");
        int category=Integer.parseInt(request.getParameter("category"));

        Post post=new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImagePath(image);
        post.setCategoryId(category);
        PostDao.store(post);
        response.sendRedirect("posts");
    }
}
