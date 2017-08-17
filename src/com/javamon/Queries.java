package com.javamon;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
        for (int i = 0; i < namesHighScoreFromDb.size(); i++) {
            scores.put(namesHighScoreFromDb.get(i), highScoreFromDb.get(i));
        }
        scores.forEach((key, value) -> {
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

    public static ArrayList<String> getRandomPhrase() {
        String nameQuery = "SELECT name, type FROM phrase  ORDER BY random() LIMIT 1;";
        ArrayList<String> randomPhrase = UseDb.runQuery(nameQuery, "name");

        String typeQuery = String.format("SELECT type FROM phrase WHERE name = '%s';", randomPhrase.get(0));
        ArrayList<String> phraseType = UseDb.runQuery(typeQuery, "type");

        ArrayList<String> phraseDatas = new ArrayList<>(2);
        phraseDatas.add(randomPhrase.get(0));
        phraseDatas.add(phraseType.get(0));

        return phraseDatas;
    }


    public static void updateUserScore() {
        String nameQuery = String.format("UPDATE users SET score = score+'%d' WHERE name = '%s';", MenuMethods.earnedPoints, MenuMethods.loggedUser);
        UseDb.runQuery(nameQuery, "score");
    }


    public static String checkAccountExist(String userName) {
        String query = String.format("SELECT name FROM users WHERE name = '%s';", userName);
        ArrayList<String> list_b = UseDb.runQuery(query, "name");
        try {
            if (list_b != null) {
                return list_b.get(0);
            }
        } catch (IndexOutOfBoundsException e) {
            return "error";
        }
        return "success";
    }

    public static ArrayList getScoreOfLoggedUser() {
        String query = String.format("SELECT score FROM users WHERE name = '%s';", MenuMethods.loggedUser);
        ArrayList<String> myScore = UseDb.runQuery(query, "score");
        return myScore;
    }
}
