package com.xdpiqbx.db;

import com.xdpiqbx.common.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database INSTANCE;
    private static Connection connection;
    private Database(){ }
    public static Database getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
    public Connection getConnection(){
        try{
            return DriverManager.getConnection(Helper.env("DB_URL"));
        }catch (SQLException e){
            throw new RuntimeException("No connection!");
        }
    }
}
