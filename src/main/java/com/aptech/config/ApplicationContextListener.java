package com.aptech.config;

import com.aptech.database.tables.CategoryTable;
import com.aptech.database.tables.PostsTable;
import com.aptech.database.tables.UserTable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application started");
        ServletContext context= sce.getServletContext();
        String path=context.getContextPath();
        context.setAttribute("path",path);
        System.out.println(path);
        UserTable.create();
        CategoryTable.create();
        PostsTable.create();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        CategoryTable.drop();
//        PostsTable.drop();
    }
}
