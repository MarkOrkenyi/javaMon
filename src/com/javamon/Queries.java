package com.javamon;

import java.util.ArrayList;

public class Queries {
    public static void registerAccount(String username, String password) {
        String query = String.format("INSERT INTO users(name, password, score) VALUES ('%s', '%s', 0);",username,password);
        Query.Query(query, "name");
    }
    public static void getHighscore() {
        Query.Query("SELECT name FROM users ORDER BY score DESC LIMIT 10;", "name");
        Query.Query("SELECT score FROM users ORDER BY score DESC LIMIT 10;", "score");
    }
    public static void updateScore(String username) {
        String query = String.format("UPDATE users SET score = score + 1 WHERE name = '%s';",username);
        Query.Query(query, "name");
    }
    public static String getPasswordHash(String userName) {
        String query = String.format("SELECT password FROM users WHERE name = '%s';",userName);
        ArrayList<String> list_a = Query.Query(query, "password");
        return list_a.get(0);
    }
    public static void getPokemon() {
        Query.Query("SELECT name FROM phrase WHERE type = 'pokemon' ORDER BY random() LIMIT 1", "name");
    }
    public static void getJavaclass() {
        Query.Query("SELECT name FROM phrase WHERE type = 'java' ORDER BY random() LIMIT 1", "name");
    }

}
