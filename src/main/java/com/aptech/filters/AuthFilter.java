package com.aptech.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns = {"/dashboard","/posts","/post-create","/category","/category-create"})
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpSession session=req.getSession();
        if(session!=null){
            String user=(String)session.getAttribute("user");
            if(user!=null){
                chain.doFilter(request, response);
            }else{
                HttpServletResponse rep=(HttpServletResponse) response;
                rep.sendRedirect("login");
            }
        }

    }
}
