package com.aptech.config;

import com.aptech.database.tables.CategoryTable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application started");
//        CategoryTable.create();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
