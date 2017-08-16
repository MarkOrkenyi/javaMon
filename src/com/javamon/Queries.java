package com.javamon;

public class Queries {
    public static void registerAccount(String username, String password) {
        String query = String.format("INSERT INTO users(name, password, score) VALUES ('%s', '%s', 0);",username,password);
        Query.Query(query);
    }
    public static void getHighscore() {
        Query.Query("SELECT name, score FROM users ORDER BY score DESC LIMIT 10;");
    }
    public static void updateScore(String username) {
        String query = String.format("UPDATE users SET score = score + 1 WHERE name = '%s';",username);
        Query.Query(query);
    }
    public static void getPasswordHash(String userId) {
        String query = String.format("SELECT password FROM users WHERE id = '%s';",userId);
        Query.Query(query);
    }
    public static void getPokemon() {
        Query.Query("SELECT name FROM phrase WHERE type = 'pokemon' ORDER BY random() LIMIT 1");
    }
    public static void getJavaclass() {
        Query.Query("SELECT name FROM phrase WHERE type = 'java' ORDER BY random() LIMIT 1");
    }

}
