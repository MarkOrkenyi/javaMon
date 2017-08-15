package com.javamon;

public class Personal {
    String username = "exworm";
    String password = "fanatic99";
    String url = "jdbc:postgresql://127.0.0.1/javamon";
    public void Personal() {

    this.password = password;
    this.url = url;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getUrl() {
        return this.url;
    }


}
