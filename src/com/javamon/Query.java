package com.javamon;

import java.sql.*;
import java.util.ArrayList;

class Query {

    static ArrayList<String> Query(String sqlQuery, String columnName) {
        try {
            Personal userData = new Personal();
            String username = userData.getUsername();
            String password = userData.getPassword();
            String dbUrl = userData.getUrl();

            String url = dbUrl;
            Connection conn = DriverManager.getConnection(url,username,password
            );


            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(sqlQuery);
            ArrayList<String> results = new ArrayList<>();
            while ( rs.next() ) {
                String addToList = rs.getString(columnName);
                results.add(addToList);

            }
            conn.close();
            return results;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return null;
    }
}
