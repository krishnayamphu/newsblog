package com.aptech.database.tables;
import com.aptech.database.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostsTable {
    public static void create(){
         try {
             Connection con= ConnectDB.connect();
             String sql = "CREATE TABLE posts (id int primary key auto_increment,title varchar(256) unique not null , content text null, image_path varchar(256), category_id int null, created_at timestamp null,updated_at timestamp null)";
             PreparedStatement ps = con.prepareStatement(sql);
             if(ps.executeUpdate()==0){
                 System.out.println("Posts table created");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop(){
        try {
            Connection con=ConnectDB.connect();
            String sql = "DROP TABLE  IF EXISTS posts";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            if(ps.executeUpdate()==0) {
                System.out.println("dropped posts table.");
            }
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
