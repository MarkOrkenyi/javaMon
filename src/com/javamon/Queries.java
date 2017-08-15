package com.javamon;

public class Queries {
    public static void registerAccount(String username, String password) {
        Query.Query("INSERT INTO users(name, password, score) VALUES (?, ?, 0);");
        
    }

}
