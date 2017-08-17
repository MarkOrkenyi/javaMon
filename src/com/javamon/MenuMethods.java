package com.javamon;

import java.util.Objects;
import java.util.Scanner;

public class MenuMethods {

    public static void startGame() {

        if (Menu.userLoggedInSuccess) {
            System.out.println("Register and/or log in first");
        } else {
            Menu.correctData = true;
            GameTimer.startTimer();
        }
    }

    public static void highScores() {
        Menu.correctData = true;
        System.out.println("highscore");
    }

    public static void registration() {
        Menu.correctData = true;
        System.out.print("Enter username: ");
        Scanner username = new Scanner(System.in);
        String un = username.nextLine();
        System.out.print("Enter password: ");
        Scanner password = new Scanner(System.in);
        String pw = password.nextLine();
        Hash hashPw = new Hash();
        String hashedPassW = hashPw.HashPass(pw);
        Queries.registerAccount(un, hashedPassW);
    }

    public static void login() {
        Menu.correctData = true;

        System.out.print("Enter your username: ");
        Scanner logInUsername = new Scanner(System.in);
        String loginName = logInUsername.nextLine();
        String userExist = Queries.checkUserExist(loginName);
        if (!Objects.equals(userExist, "error")){
            System.out.print("Enter your password: ");
            Scanner loginPassword = new Scanner(System.in);

            String loginPw = loginPassword.nextLine();
            String pwFromDb = Queries.getPasswordHash(loginName);
            Hash.CheckHash(loginPw, pwFromDb);
        } else {
            login();
        }
        if (Menu.userLoggedInSuccess) {
            System.out.printf("Logged in as %s%n", loginName);
            Menu.correctData = false;
            Menu.printMenu();
        }

    }
}
