package com.javamon;

import java.util.Scanner;

public class MenuMethods {

    public static void startGame() {

        if (Menu.userLoggedInSuccess) {
            System.out.println("Register and/or log in first");
        } else {
            Menu.correctData = true;
            GameTimer timer = new GameTimer();
            timer.startTimer();
        }
    }

    public static void highScores() {
        Queries.getHighScore();
        Menu.printMenu();

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
        Menu.correctData = true;

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
        }

    }
}
