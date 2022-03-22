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
       Post post=new Post();
       post.setTitle("hello world");
       post.setContent("testing content");
       post.setImagePath("pic.jpg");
       post.setCategoryId(1);
        PostDao.store(post);
    }
}
