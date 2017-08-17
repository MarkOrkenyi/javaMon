package com.javamon;

import static com.javamon.BCrypt.*;

public class Hash {

    public static Boolean CheckHash(String candidate, String hashed) {
        if (checkpw(candidate, hashed)) {
            Menu.userLoggedInSuccess = true;
            System.out.println("Logged in successfully!");
            return true;
        } else
            System.out.println("Wrong username or password!");
            return false;
    }

    public String HashPass(String password) {
        return hashpw(password, gensalt(10));
    }

}
