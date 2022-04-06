package com.aptech.controllers;

import com.aptech.javamail.JavaMailGmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contact.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from="yamphukrishna7@gmail.com";
        String password="Aptechkrishna7";
        String to="krishnayamphu@gmail.com";
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        String subject=request.getParameter("subject");
        String msg=request.getParameter("msg");

        String message="Name: "+name+"\n"+email+"\n"+mobile+"\n"+msg;

        JavaMailGmail.send(from,password,to,subject,message);
        response.sendRedirect("contact");
    }
}
