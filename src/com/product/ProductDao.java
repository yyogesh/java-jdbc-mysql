package com.product;

import java.sql.*;

public class ProductDao {
    public static boolean insertProductToDB(Product product) {
        // jdbc
        boolean isSuccess = false;
       try {
          Connection con = MySqlDBConnector.createConnection();
          String query = "insert into product(title, registed_date) values(?,?)";
           PreparedStatement preparedStatement = con.prepareStatement(query);
           preparedStatement.setString(1, product.getTitle());
           preparedStatement.setDate(2, (Date) product.getRegisted_date());

           preparedStatement.executeUpdate();
           isSuccess = true;

       } catch (Exception e) {
           e.printStackTrace();
       }
       return isSuccess;
    }

    public static boolean deleteProductToDB(int productId) {
        // jdbc
        boolean isSuccess = false;
        try {
            Connection con = MySqlDBConnector.createConnection();
            String query = "delete from product where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, productId);

            preparedStatement.executeUpdate();
            isSuccess = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public static void showAllProduct() {
        // jdbc
        try {
            Connection con = MySqlDBConnector.createConnection();
            String query = "select * from product;";
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Date : " + date);
                System.out.println("*******************************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showProductById(int productId) {
        // jdbc
        try {
            Connection con = MySqlDBConnector.createConnection();
            String query = "select * from product where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Date : " + date);
                System.out.println("*******************************");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
