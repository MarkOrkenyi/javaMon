package com.javamon;

import java.util.Scanner;

public class Menu {

    public static void printMenu () {
        String menuItem = "1.) Start game\n" +
                "2.) High scores\n" +
                "3.) Registration\n" +
                "4.) User login";
        System.out.println(menuItem);

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a number: ");

        if (userInput.hasNextInt()) {
            int enteredNum = userInput.nextInt();
            if (enteredNum == 1) {
                //starts the game
                System.out.println("start");
            } else if (enteredNum == 2) {
                // shows high score
                System.out.println("highscore");
            } else if (enteredNum == 3) {
                // user registration
                System.out.println("reg");
            } else if (enteredNum == 4){
                // user login
                System.out.print("login");
            } else {
                System.out.println("choose between 1, 2 or 3");
            }
        } else {
            System.out.println("not number");
        }
    }
}