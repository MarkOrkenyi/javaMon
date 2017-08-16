package com.javamon;

import java.util.Scanner;

public class Menu {

    public static void printMenu () {
        boolean incorrectData = true;

        while (incorrectData == true ) {
            String menuItem = "1.) Start game\n" +
                    "2.) High scores\n" +
                    "3.) Registration\n" +
                    "4.) User login\n" +
                    "0.) Exit game";
            System.out.println(menuItem);

            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a number: ");

            if (userInput.hasNextInt()) {
                int enteredNum = userInput.nextInt();
                if (enteredNum == 1) {
                    //starts game
                    incorrectData = false;
                    System.out.println("start");
                    GameTimer timer = new GameTimer();
                    timer.startTimer();

                } else if (enteredNum == 2) {
                    // shows high score
                    incorrectData = false;
                    System.out.println("highscore");
                } else if (enteredNum == 3) {
                    // user registration
                    incorrectData = false;
                    System.out.println("reg");
                } else if (enteredNum == 4) {
                    // user login
                    incorrectData = false;
                    System.out.print("login");
                } else if (enteredNum == 0) {
                    System.out.println("thanks for playing JavaMon");
                    System.exit(0);
                } else {
                    System.out.println("choose between 1, 2 or 3");
                }
            } else {
                System.out.println("not number, try again");
            }
        }
    }
}