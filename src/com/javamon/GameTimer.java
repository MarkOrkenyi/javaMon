package com.javamon;


import javax.swing.*;
import java.awt.event.ActionListener;


public class GameTimer {
    public static void startTimer() {
        int delay = 10000; //milliseconds
        int gameTime = delay / 1000;
        System.out.println();
        MenuMethods.gameRunning = true;
        System.out.println("Game time: " + gameTime + " seconds");
        ActionListener taskPerformer = evt -> {
            System.out.println("Outta' time");
            MenuMethods.gameRunning = false;
            String earnedPoints = String.format("Congrats, you earned %s points, it has been added to your high score", MenuMethods.earnedPoints);
            System.out.println(earnedPoints);
            Queries.updateUserScore();
            MenuMethods.userScore();
            System.exit(1);

        };
        Timer timer = new Timer(delay, taskPerformer);
        timer.setRepeats(false);
        timer.start();
    }
}
