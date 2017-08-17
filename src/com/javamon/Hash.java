package com.javamon;

import static com.javamon.BCrypt.*;

public class Hash {

    public static String HashPass (String password) {
        return hashpw(password, gensalt(10));
    }

    public static Boolean CheckHash (String candidate, String hashed) {
        if (checkpw(candidate, hashed)) {
            Menu.userLoggedInSuccess = true;
            System.out.println("Logged in successfully!");
            return true;
        } else
            System.out.println("Wrong username or password!");
            return false;
    }

}
