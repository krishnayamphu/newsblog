package com.aptech;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.models.Category;
import com.aptech.models.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
     Category category=CategoryDao.getCategoryById(3);

        System.out.println(category.getName());
        System.out.println(category.getDescription());
    }
}
