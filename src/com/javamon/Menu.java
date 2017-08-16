package com.javamon;

import java.sql.ResultSet;
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
                    GameTimer timer = new GameTimer();
                    timer.startTimer();

                } else if (enteredNum == 2) {
                    // shows high score
                    incorrectData = false;
                    System.out.println("highscore");
                } else if (enteredNum == 3) {
                    // user registration
                    incorrectData = false;
                    System.out.print("Enter username: ");
                    Scanner username = new Scanner(System.in);
                    String un = username.next();
                    System.out.print("Enter password: ");
                    Scanner password = new Scanner(System.in);
                    String pw = password.next();
                    Hash hashPw = new Hash();
                    String hashedPassW = hashPw.HashPass(pw);
                    Queries.registerAccount(un, hashedPassW);

                } else if (enteredNum == 4) {
                    // user login
                    incorrectData = false;
                    System.out.print("Enter your username: ");
                    Scanner logInUsername = new Scanner(System.in);
                    String loginName = logInUsername.next();
                    System.out.print("Enter your password: ");
                    Scanner loginPassword = new Scanner(System.in);
                    String loginPw = loginPassword.next();
                    Queries hashedPwFromDb = new Queries();
                    String pwFromDb = hashedPwFromDb.getPasswordHash(loginName);

                    Hash.CheckHash(loginPw, pwFromDb);


                } else if (enteredNum == 0) {
                    System.out.println("thanks for playing JavaMon");
                    System.exit(0);
                } else {
                    System.out.println("choose between 1, 2, 3, 4 or 0");
                }
            } else {
                System.out.println("not number, try again");
            }
        }
    }
}