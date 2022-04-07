package com.aptech.controllers.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category-edit")
public class CategoryEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Category category=CategoryDao.getCategoryById(id);
        request.setAttribute("category",category);
        request.getRequestDispatcher("category/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        Category category=new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        CategoryDao.update(category);
        response.sendRedirect("category");
    }
}
