package com.javamon;

import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {

    public static boolean userLoggedInSuccess = false;
    public static boolean correctData = false;

    public static void printMenu() {

        while (correctData == false ) {
            String menuItem = "1.) Start game\n" +
                    "2.) Login\n" +
                    "3.) Registration\n" +
                    "4.) Top 10 scores\n" +
                    "5.) My score \n" +
                    "0.) Exit game";
            System.out.println(menuItem);

            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a number: ");

            if (userInput.hasNextInt()) {
                int enteredNum = userInput.nextInt();
                if (enteredNum == 1) {
                    //starts game
                    MenuMethods.startGame();
                } else if (enteredNum == 4) {
                    // shows high score
                    MenuMethods.highScores();
                } else if (enteredNum == 3) {
                    // user registration
                    MenuMethods.registration();
                } else if (enteredNum == 2) {
                    // user login
                    MenuMethods.login();
                } else if (enteredNum == 0) {
                    System.out.println("thanks for playing JavaMon");
                    System.exit(0);
                } else if (enteredNum == 5) {
                    MenuMethods.userScore();
                } else {
                    System.out.println("choose between 1, 2, 3, 4 or 0");
                }
            } else {
                System.out.println("not number, try again");
            }
        }
    }
}