package com.aptech.database.tables;
import com.aptech.database.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTable{
    public static void create(){
         try {
             Connection con= ConnectDB.connect();
             String sql = "CREATE TABLE Users (id int primary key auto_increment,name varchar(50),username varchar(255) unique not null,password varchar(255), email varchar(255) unique not null, created_at timestamp null)";
             PreparedStatement ps = con.prepareStatement(sql);
             if(ps.executeUpdate()==0){
                 System.out.println("Users table crated");
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop(){
        try {
            Connection con=ConnectDB.connect();
            String sql = "DROP TABLE  IF EXISTS users";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            if(ps.executeUpdate()==0) {
                System.out.println("dropped users table.");
            }
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
