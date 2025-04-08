package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsGUI extends JFrame {

    public InstructionsGUI() {
        setTitle("Instructions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Important for proper closing
        setSize(600, 450); // Adjusted size for better fit
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Prevent resizing

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(104, 50, 19));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.white);
        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Padding

        JLabel titleLabel = new JLabel("How to Play");
        titleLabel.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 40f));
        titleLabel.setForeground(Color.black);
        titlePanel.add(titleLabel);

        JTextPane instructionsLabel = new JTextPane();
        instructionsLabel.setText(getInstructionsText());
        instructionsLabel.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 24f));
        instructionsLabel.setBackground(new Color(104, 50, 19));
        instructionsLabel.setForeground(Color.WHITE);
        instructionsLabel.setEditable(false);
        instructionsLabel.setFocusable(false);

        // Style the text within the JTextPane
        StyledDocument doc = instructionsLabel.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT); // Left alignment
        StyleConstants.setLeftIndent(style, 15);
        StyleConstants.setRightIndent(style, 15);
        doc.setParagraphAttributes(0, doc.getLength(), style, false);

        JScrollPane scrollPane = new JScrollPane(instructionsLabel); // Add scrolling
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(182, 159, 11), 5));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(104, 50, 19));

        JButton okButton = new JButton("Ok");
        okButton.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 24));
        okButton.setForeground(new Color(104, 50, 19));
        okButton.setBackground(Color.white);
        okButton.setFocusable(false);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Use dispose() to close the frame
            }
        });
        buttonPanel.add(okButton);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private String getInstructionsText() {
        return "Welcome to the 2D Java Game!\n\n" +
                "**Controls:**\n\n" +
                "- **Movement:** Use the W, A, S, D keys to move the player.\n" +
                "- **Interaction:** Press the Enter key to interact with NPCs and objects.\n" +
                "- **Instructions:** Press the 'I' key to open these instructions.\n" +
                "- **Bug:** If character continues moving to a certain direction, press the key again.\n\n" +

                "**Objective:**\n\n" +
                "Explore the world, interact with characters, and discover items!\n\n" +
                "**Tips:**\n\n" +
                "- Pay attention to dialogue from NPCs.\n" +
                "- Some objects can be picked up and used.\n" +
                "- Be careful, the world can be dangerous!";
    }
}