package com.company;

import com.product.Product;
import com.product.ProductDao;

import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        while(true) {
          System.out.println("PRESS 1 to ADD Product");
          System.out.println("PRESS 2 to Delete Product");
          System.out.println("PRESS 3 to display Product");
          System.out.println("PRESS 4 to display Product by id");
          System.out.println("PRESS 5 to exit app");

          Scanner myObj = new Scanner(System.in);
          int c = myObj.nextInt();

          if(c == 1) {
              System.out.println("Enter product title :");
              String name = myObj.next();
              Date date = new Date();
              java.sql.Date d = new  java.sql.Date(date.getTime());
              Product product = new Product(name, d);
              System.out.println(product);
              boolean isSuccess = ProductDao.insertProductToDB(product);
              if(isSuccess) {
                  System.out.println("Product created successfully!");
              } else {
                  System.out.println("Please try again...");
              }
              // Add Product
          } else if(c == 2) {
              System.out.println("Enter product id to delete: ");
              int productId = myObj.nextInt();
              boolean isSuccess = ProductDao.deleteProductToDB(productId);
              if(isSuccess) {
                  System.out.println("Product deleted successfully!");
              } else {
                  System.out.println("Please try again...");
              }
              // Delete Product
          } else if(c == 3) {
              ProductDao.showAllProduct();
              // Display Product
          } else if(c ==4) {
              System.out.println("Enter product id to display: ");
              int productId = myObj.nextInt();
              ProductDao.showProductById(productId);
              break;
          } else if(c ==5){
              // exit;
              break;
          }
        }
    }
}
