package com.javamon;

import java.util.Scanner;

public class Menu {

    public static void printMenu () {
        String menuItem = "1.) Start game\n" +
                "2.) High scores\n" +
                "3.) Registration";
        System.out.println(menuItem);

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a number: ");

        if (userInput.hasNextInt()) {
            int enteredNum = userInput.nextInt();
            if (enteredNum != 1 || enteredNum != 2 || enteredNum != 3) {
                System.out.println("1,2 or 3");
            } else if (enteredNum == 1) {
                // game start
            } else if (enteredNum == 2) {
                // show high scores
            } else if (enteredNum == 3) {
                //registration form
            }
        } else {
            System.out.println("not number");
        }
    }
}
