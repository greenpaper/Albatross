package com.example.albatross;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static void main(String[] args){
        Connection c = null;
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");

        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened  database successfully");
    }

}
