package com.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnector {

    static Connection con;

    public static Connection createConnection() {
        // Load driver;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           // create the connect
           String user = "root";
           String password ="353737";
           String url = "jdbc:mysql://localhost:3306/product";
           con = DriverManager.getConnection(url, user, password);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return con;
    }
}
