package com.aptech.database.tables;
import com.aptech.database.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryTable {
    public static void create(){
         try {
             Connection con= ConnectDB.connect();
             String sql = "CREATE TABLE category (id int primary key auto_increment,name varchar(50) unique,description varchar(256) null,created_at timestamp null,updated_at timestamp null)";
             PreparedStatement ps = con.prepareStatement(sql);
             if(ps.executeUpdate()==0){
                 System.out.println("Category table crated");
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop(){
        try {
            Connection con=ConnectDB.connect();
            String sql = "DROP TABLE  IF EXISTS category";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            if(ps.executeUpdate()==0) {
                System.out.println("dropped category table.");
            }
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
