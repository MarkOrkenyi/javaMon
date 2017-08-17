package com.javamon;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMethods {
    public static String loggedUser ="";
    public static boolean gameRunning = false;
    public static Integer earnedPoints = 0;

    public static void startGame() {
        System.out.println(loggedUser);
        if (loggedUser.length() == 0) {
            System.out.println("Register and/or log in first");
        } else {
            Menu.correctData = true;
            GameTimer timer = new GameTimer();
            timer.startTimer();
            System.out.println("The game has begun!");
            System.out.println("You win and lose 1 point for every correct and incorrect answer respectively");
            System.out.println("Enter 1 if the said Phrase is a pokemon or 2 if it's a Java expression");
            while (gameRunning) {
                ArrayList randomPhraseData = Queries.getRandomPhrase();
                String randomPhrase = String.format("What is %s", randomPhraseData.get(0));
                Integer correctAnswer;
                if (randomPhraseData.get(1) == "Pokemon") {
                    correctAnswer = 1;
                } else {
                    correctAnswer = 2;
                }

                Scanner userResponse = new Scanner(System.in);
                System.out.println("**" + randomPhrase + "**\n");
                System.out.println("1: Pokemon, 2: Java expression");
                int userAnswer = userResponse.nextInt();
                if (userAnswer == correctAnswer) {
                    earnedPoints++;
                    String roundWon = String.format("Congrats, you earned a point, in this seasson so far you earned %s points!\n", earnedPoints);
                    System.out.println(roundWon);
                } else {
                    earnedPoints--;
                    String roundLost = String.format("Sadly your answer was incorrect, in this session so far you earned %s points!\n", earnedPoints);
                    System.out.println(roundLost);
                }
            }

        }
    }

    public static void highScores() {
        Queries.getHighScore();
        Menu.printMenu();
    }

    public static void userScore() {
        ArrayList myScore = Queries.getScoreOfLoggedUser();
        System.out.println("Your total points: " + myScore.get(0));
    }

    public static void registration() {
        Menu.correctData = true;
        System.out.print("Enter username: ");
        Scanner username = new Scanner(System.in);
        String un = username.next();
        System.out.print("Enter password: ");
        Scanner password = new Scanner(System.in);
        String pw = password.next();
        Hash hashPw = new Hash();
        String hashedPassW = hashPw.HashPass(pw);
        Queries.registerAccount(un, hashedPassW);
    }

    public static void login() {

        System.out.print("Enter your username: ");
        Scanner logInUsername = new Scanner(System.in);
        String loginName = logInUsername.next();
        String userExist = Queries.checkUserExist(loginName);
        if (userExist != "error"){
            System.out.print("Enter your password: ");
            Scanner loginPassword = new Scanner(System.in);
            String loginPw = loginPassword.next();
            Queries hashedPwFromDb = new Queries();
            String pwFromDb = hashedPwFromDb.getPasswordHash(loginName);
            Hash.CheckHash(loginPw, pwFromDb);
        } else {
            login();
        }
        if (Menu.userLoggedInSuccess) {
            String LoggedInUserName = loginName;
            System.out.println(LoggedInUserName + " logged in");
            loggedUser = LoggedInUserName;
        }
        Menu.printMenu();

    }
}
