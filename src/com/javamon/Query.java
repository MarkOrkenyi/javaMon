package com.javamon;

import java.sql.*;

class Query {

    static void Query(String sqlQuery) {
        try {
            Personal userData = new Personal();
            String username = userData.getUsername();
            String password = userData.getPassword();
            String dbUrl = userData.getUrl();

            String url = dbUrl;
            Connection conn = DriverManager.getConnection(url,username,password
            );




            // Connection conn = DriverManager.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(sqlQuery);
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
