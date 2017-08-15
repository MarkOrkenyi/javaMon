package com.javamon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection connection = new DatabaseConnection();
        connection.DatabaseConnection();
        System.out.println("Welcome to JavaMon! \n I bet you don't know if it's a pokemon or not");
        System.out.println("Type in your username here: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Type in your password in here: ");
        String password = sc.nextLine();
        System.out.println("Your acc: " + username + " and your pw is: " + password);
        System.out.println("Type 1 to start the game");
        int gameStart = sc.nextInt();
        if(gameStart == 1) {
            System.out.println("The game has started");
        } else {
            System.out.println("Next time type 1 to start idiot");
        }

    }
}
