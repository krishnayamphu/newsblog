package com.aptech.controllers.user.auth;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.UserDao;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users/auth/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        if (password.equals(cpassword)) {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            UserDao.store(user);
            response.sendRedirect("login");
        } else {
            request.setAttribute("err", "Confirm password do not match");
            request.getRequestDispatcher("users/auth/register.jsp").include(request, response);
        }
    }
}
