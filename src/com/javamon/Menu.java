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
        } else {
            System.out.println("not number");
        }
    }
}