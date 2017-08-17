package com.javamon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Queries {
    public static String registerAccount(String username, String password) {
        String query = String.format("INSERT INTO users(name, password, score) VALUES ('%s', '%s', 0);",username,password);
        UseDb.runQuery(query, "name");
        return "success";
    }
    /*public static TreeMap getHighscore() {
        Map<String, Integer> usersScores = new TreeMap<>();
        String name;
        int score;
        String query = String.format("SELECT name FROM users ORDER BY score DESC LIMIT 10;");
        ArrayList<String> scoreName = UseDb.runQuery(query, "password");
        String query2 = String.format("SELECT score FROM users ORDER BY score DESC LIMIT 10;");
        ArrayList<Integer> scores = UseDb.runQuery(query2, "score");
        return "seggem";
    }*/
    public static void updateScore(String username) {
        String query = String.format("UPDATE users SET score = score + 1 WHERE name = '%s';",username);
        UseDb.runQuery(query, "name");
    }
    public static String getPasswordHash(String userName) {
        String query = String.format("SELECT password FROM users WHERE name = '%s';",userName);
        ArrayList<String> list_a = UseDb.runQuery(query, "password");
        try {
            if (list_a.size() > 0) {
                return list_a.get(0);
            } else {
                return "Login failed";
            }
        } catch(IllegalArgumentException e) {
            MenuMethods.login();
            return "login failed";
        }

    }

    public static String checkUserExist(String userName) {
        String query = String.format("SELECT name FROM users WHERE name = '%s';",userName);
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
