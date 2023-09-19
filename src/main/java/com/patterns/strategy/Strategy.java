package com.patterns.strategy;

import javax.swing.JFrame;

import com.patterns.strategy.gui.SortingFrame;

/**
 *
 * @author Luan Nadaletti
 */
public class Strategy {

    /**
     * The main entry point of the application.
     *
     * @param args Command line arguments. Not used in this application.
     */
    public static void main(String[] args) {
        JFrame frame = new SortingFrame();
        frame.setVisible(true);
    }

}
