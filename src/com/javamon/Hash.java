package com.javamon;

import static com.javamon.BCrypt.*;

public class Hash {

    public String HashPass (String password) {
        return hashpw(password, gensalt(10));
    }

    public static void CheckHash (String candidate, String hashed) {
        if (checkpw(candidate, hashed)) {
            Menu.userLoggedInSuccess = true;
            System.out.println("Logged in successfully!");
        } else
            System.out.println("Wrong username or password!");
    }

}
