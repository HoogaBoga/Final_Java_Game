package main;

import javax.swing.*;

public class GUI extends JFrame {

    public GUI() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("2D Game");

        GamePanel gamePanel = new GamePanel();

        this.add(gamePanel);

        this.pack();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGameThread();


    }

}
