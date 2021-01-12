package com.example.labcollection;

import java.sql.*;
import java.util.Scanner;

public class Db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dictionary";

    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
            
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the word: ");
            String name = scanner.nextLine();
            sql = "SELECT * FROM words WHERE " + name;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String meaning = rs.getString("meaning");
                if (meaning != null) {
                    System.out.println("Meaning of " + name + " : " + meaning);
                } else {
                    System.out.println("Word Not Found");
                }
            } else {
                System.out.println("Word Not Found");
            }
            rs.close();
            stmt.close();
            conn.close();
    }
}
