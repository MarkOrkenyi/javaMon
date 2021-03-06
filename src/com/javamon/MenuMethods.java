package com.javamon;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMethods {
    public static String loggedUser = "";
    public static boolean gameRunning = false;
    public static Integer earnedPoints = 0;

    public static void startGame() {
        System.out.println(loggedUser);
        if (loggedUser.isEmpty()) {
            System.out.println("Register and/or log in first");
        } else {
            Menu.correctData = true;
            GameTimer.startTimer();
            System.out.println("The game has begun!");
            System.out.println("You win and lose 1 point for every correct and incorrect answer respectively");
            System.out.println("Enter 1 if the phrase is a Pokemon or 2 if it's a Java expression");
            while (gameRunning) {
                ArrayList randomPhraseData = Queries.getRandomPhrase();
                String randomPhrase = String.format("What is %s", randomPhraseData.get(0));
                int correctAnswer;
                if (randomPhraseData.get(1).equals("pokemon")) {
                    correctAnswer = 1;
                } else {
                    correctAnswer = 2;
                }

                Scanner userResponse = new Scanner(System.in);
                System.out.println("**" + randomPhrase + "**\n");
                System.out.println("1: Pokemon, 2: Java expression");
                int userAnswer = userResponse.nextInt();
                if(userAnswer == 1 || userAnswer == 2) {
                    if (userAnswer == correctAnswer) {
                        earnedPoints++;
                        System.out.println("CORRECT! \n");
                    } else {
                        earnedPoints--;
                        System.out.println("INCORRECT!\n");
                    }
                }else {
                    System.out.println("Enter 1 or 2");
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
        if (myScore.get(0).equals("No user logged in!")) {
            System.out.println("You have to log in first to check your score!");
        } else {
            System.out.println("Your total points: " + myScore.get(0));
        }
    }

    public static void registration() {
        System.out.print("Enter username: ");
        Scanner regInput = new Scanner(System.in);
        String un;
        String pw;
        un = regInput.nextLine();
        if ((un.length() < 6)) {
            System.out.println("At least 6 character long! Please try again!");
            registration();
        }
        if (un.equals(Queries.checkAccountExist(un))) {
            System.out.println("Already exist!!");
            registration();
        }
        System.out.print("Enter password: ");
        pw = regInput.nextLine();
        if ((pw.length() < 6)) {
            System.out.println("At least 6 character long! Please try again!");
            registration();
        }
        Hash hashPw = new Hash();
        String hashedPassW = hashPw.HashPass(pw);
        Queries.registerAccount(un, hashedPassW);
        System.out.println("Account " + un + " created!");
        Menu.printMenu();
    }

    public static void login() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String loginNameInput = userInput.nextLine();
        System.out.print("Enter your password: ");
        String passwordInput = userInput.nextLine();
        Boolean loginSuccess = Queries.checkLoginData(loginNameInput, passwordInput);
        if (loginSuccess) {
            loggedUser = loginNameInput;
        } else {
            System.out.println("Wrong username or password! Try again!");
        }
    }
}
