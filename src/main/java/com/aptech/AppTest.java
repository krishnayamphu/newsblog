package com.aptech;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        CategoryDao.delete(3);
    }
}
