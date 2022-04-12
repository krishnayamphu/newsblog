package com.aptech;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.dao.UserDao;
import com.aptech.models.Category;
import com.aptech.models.Post;
import com.aptech.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
       String username="admin";
       String password="a1";

       if(UserDao.login(username,password)){
           System.out.println("welcome");
       }else {
           System.out.println("Invalid username or password");
       }
    }
}
