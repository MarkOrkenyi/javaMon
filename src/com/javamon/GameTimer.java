package com.javamon;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.event.*;
public class GameTimer {
    public static void startTimer(){
        int delay = 10000; //milliseconds
        int gametime = delay/30000;
        MenuMethods.gameRunning = true;
        System.out.println("Game time: " + gametime + " seconds");
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Outta' time");
                MenuMethods.gameRunning = false;
                String earnedPoints = String.format("Congrats, you earned %s points, it has been added to your high score", MenuMethods.earnedPoints);
                System.out.println(earnedPoints);
                Queries.updateUserScore();
                System.exit(1);

            }
        };
        Timer timer = new Timer(delay ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
    }
}
