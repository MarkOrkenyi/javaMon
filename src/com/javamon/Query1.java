package com.javamon;

import java.sql.*;

class Query1 {

    static void Query1() {
        try {

            String url = "jdbc:postgresql://127.0.0.1/javamon";
            Connection conn = DriverManager.getConnection(url,"ketam","asdasd");

            // Connection conn = DriverManager.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT name FROM phrase WHERE id = 2");
            while ( rs.next() ) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
