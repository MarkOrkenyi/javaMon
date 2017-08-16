package com.javamon;

import static com.javamon.BCrypt.*;

public class Hash {

    public String HashPass (String password) {
        String asd = hashpw(password, gensalt(10));
        return asd;
    }

    public void CheckHash (String candidate, String hashed) {
        if (checkpw(candidate, hashed)) {
            System.out.println("It matches");
        } else
            System.out.println("It does not match LOL");
    }

}
