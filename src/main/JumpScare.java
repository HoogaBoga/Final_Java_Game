package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class JumpScare extends JFrame {
    public JumpScare() {
        setTitle("Background Panel Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setSize(800, 600);

        // Create a custom panel with a background image
        JPanel backgroundPanel = new JPanel() {
            private final Image backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/PrincessScare.jpg"))).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image to fill the panel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set layout and add content if needed
        backgroundPanel.setLayout(null);

        JButton endGameButton = new JButton("End Game");

        endGameButton.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 24));
        endGameButton.setForeground(new Color(104, 50, 19));
        endGameButton.setBackground(Color.white);
        endGameButton.setBounds(600,500, 150, 38);
        endGameButton.setFocusable(false);
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        backgroundPanel.add(endGameButton);

        setUndecorated(true);
        add(backgroundPanel);
        setVisible(true);
        

        setLocationRelativeTo(null);
    }
}
