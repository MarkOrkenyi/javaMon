package com.javamon;

public class Queries {
    public static void registerAccount(String username, String password) {
        String query = String.format("INSERT INTO users(name, password, score) VALUES ('%s', '%s', 0);",username,password);
        Query.Query(query);
        
    }

}
