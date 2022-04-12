package com.aptech.dao;

import com.aptech.database.util.ConnectDB;
import com.aptech.models.Post;
import com.aptech.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    public static List<User> all() {
        /** show all users */
        List<User> users = new ArrayList<>();
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                User user = new User(result.getInt("id"), result.getString("name"), result.getString("username"), result.getString("password"), result.getString("email"), result.getString("created_at"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /** get post by id */
    public static Post getPostById(int id) {
        Post post = new Post();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM posts WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                post.setId(result.getInt("id"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                post.setImagePath(result.getString("image_path"));
                post.setCategoryId(result.getInt("category_id"));
                post.setCreatedAt(result.getString("created_at"));
                post.setUpdatedAt(result.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    /** store user */
    public static boolean store(User user) {
        boolean status = false;
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            String hashPassword=new DigestUtils("SHA3-256").digestAsHex(user.getPassword());
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO users (name,username,password,email,created_at) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, hashPassword);
            ps.setString(4, user.getEmail());
            ps.setString(5, timeStamp);
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    /** update post */
    public static boolean update(Post post) {
        boolean status = false;
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "UPDATE posts SET title=?, content=?,image_path=?,category_id=?, updated_at=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2,post.getContent());
            ps.setString(3,post.getImagePath());
            ps.setInt(4,post.getCategoryId());
            ps.setString(5, timeStamp);
            ps.setInt(6, post.getId());
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    /** delete post */
    public static boolean delete(int id) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM posts WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    /** login */
    public static boolean login(String username,String password) {
        boolean status=false;
        String hashPassword=new DigestUtils("SHA3-256").digestAsHex(password);

        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2,hashPassword);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
