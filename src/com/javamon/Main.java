package com.javamon;

    public class Main {

    public static void main(String[] args) {

        Query1 selectq = new Query1();
        selectq.Query1();

        GameTimer timer = new GameTimer();
        timer.startTimer();

        Menu showMenu = new Menu();
        showMenu.printMenu();
    }
}
