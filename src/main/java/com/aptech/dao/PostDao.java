package com.aptech.dao;

import com.aptech.database.util.ConnectDB;
import com.aptech.models.Category;
import com.aptech.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao {
    public static List<Post> all() {
        List<Post> posts = new ArrayList<>();
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM posts";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Post post = new Post(result.getInt("id"), result.getString("title"), result.getString("content"), result.getString("image_path"), result.getInt("category_id"), result.getString("created_at"), result.getString("updated_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

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

    public static boolean store(Post post) {
        boolean status = false;
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO posts (title,content,image_path,category_id,created_at) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImagePath());
            ps.setInt(4, post.getCategoryId());
            ps.setString(5, timeStamp);
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

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
}
