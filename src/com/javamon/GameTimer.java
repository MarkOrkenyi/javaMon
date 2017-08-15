package com.javamon;
import javax.swing.*;
import java.awt.event.*;
public class GameTimer {
    public static void startTimer(){
        int delay = 1000; //milliseconds
        int gametime = delay/1000;
        System.out.println("Game time: " + gametime + " seconds");
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Outta' time");
            }
        };
        Timer timer = new Timer(delay ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
    }
}
