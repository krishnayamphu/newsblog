package com.aptech.dao;

import com.aptech.database.util.ConnectDB;
import com.aptech.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryDao {
    public static List<Category> all() {
        List<Category> categories =new ArrayList<>();
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM category";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet result=ps.executeQuery();
            while(result.next()){
                Category category=new Category(result.getInt("id"),result.getString("name"),result.getString("created_at"),result.getString("updated_at"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    public static Category getCategoryById(int id){
    Category category=new Category();
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM category WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet result=ps.executeQuery();
            while(result.next()){
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                category.setCreatedAt(result.getString("created_at"));
                category.setUpdatedAt(result.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return category;
    }
    public static boolean store(Category category) {
        boolean status = false;
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO category (name,created_at) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, timeStamp);
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public static boolean update(Category category) {
        boolean status = false;
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "UPDATE category SET name=?, updated_at=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, timeStamp);
            ps.setInt(3,category.getId());
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public static boolean delete(int id){
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM category WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate()==1){
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
