package com.javamon;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Queries {
    public static String registerAccount(String username, String password) {
        String query = String.format("INSERT INTO users(name, password, score) VALUES ('%s', '%s', 0);", username, password);
        UseDb.runQuery(query, "name");
        return "success";
    }

    public static LinkedHashMap getHighScore() {
        ArrayList namesHighScoreFromDb;
        ArrayList highScoreFromDb;
        LinkedHashMap scores = new LinkedHashMap();

        String query = "SELECT name FROM users ORDER BY score DESC LIMIT 10;";
        namesHighScoreFromDb = UseDb.runQuery(query, "name");
        String query2 = "SELECT score FROM users ORDER BY score DESC LIMIT 10";
        highScoreFromDb = UseDb.runQuery(query2, "score");
        for (int i=0; i<namesHighScoreFromDb.size(); i++) {
                scores.put(namesHighScoreFromDb.get(i), highScoreFromDb.get(i));
        }
        scores.forEach((key,value) -> {
                    System.out.println(key + " : " + value + "\n");
                });


        return scores;
    }

    public static void updateScore(String username) {
        String query = String.format("UPDATE users SET score = score + 1 WHERE name = '%s';", username);
        UseDb.runQuery(query, "name");
    }

    public static String getPasswordHash(String userName) {
        String query = String.format("SELECT password FROM users WHERE name = '%s';", userName);
        ArrayList<String> list_a = UseDb.runQuery(query, "password");
        try {
            if (list_a.size() > 0) {
                return list_a.get(0);
            } else {
                return "Login failed";
            }
        } catch (IllegalArgumentException e) {
            MenuMethods.login();
            return "login failed";
        }

    }

    public static String checkUserExist(String userName) {
        String query = String.format("SELECT name FROM users WHERE name = '%s';", userName);
        ArrayList<String> list_b = UseDb.runQuery(query, "name");
        try {
            return list_b.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Enter your password: ");
            Scanner fakeInput = new Scanner(System.in);
            String fakeData = fakeInput.next();
            System.out.println("Invalid username or password");
            MenuMethods.login();
            return "error";
        }
    }

    public static void getPokemon() {
        UseDb.runQuery("SELECT name FROM phrase WHERE type = 'pokemon' ORDER BY random() LIMIT 1", "name");
    }

    public static void getJavaclass() {
        UseDb.runQuery("SELECT name FROM phrase WHERE type = 'java' ORDER BY random() LIMIT 1", "name");
    }

}
