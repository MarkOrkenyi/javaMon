package com.javamon;

import java.sql.*;
import java.util.ArrayList;

class UseDb {

    static ArrayList<String> runQuery(String sqlQuery, String columnName) {
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
            try {
                rs = stmt.executeQuery(sqlQuery);
                ArrayList<String> results = new ArrayList<>();
                while (rs.next()) {
                    String addToList = rs.getString(columnName);
                    results.add(addToList);

                }
                return results;
            } catch (SQLException e){
                if (e.getSQLState().equals("23505")) {
                    System.out.println("Username already taken, choose another one!");
                    MenuMethods.registration();
                }
            }
            finally {
                conn.close();
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return null;
    }
}
