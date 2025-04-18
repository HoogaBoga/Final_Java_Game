package main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ItemDescriptionGUI extends JFrame{

    public ItemDescriptionGUI(String description, String itemName, BufferedImage image){

        setTitle("Item");
        setSize(606, 462);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        Image scaledImage = image.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);

        JPanel mainPanel = new JPanel();

        mainPanel.setSize(new Dimension(606, 462));
        mainPanel.setBackground(new Color(104, 50, 19));

        JPanel titlePanel = new JPanel();

        titlePanel.setBackground(Color.white);
        titlePanel.setBounds(0, 19, 606, 63);

        JLabel titleLabel = new JLabel(itemName);
        titleLabel.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 40f));
        titleLabel.setForeground(Color.black);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0)); // Top padding

        titlePanel.add(titleLabel);

        JTextPane descriptionLabel = new JTextPane();
        descriptionLabel.setText(description);
        descriptionLabel.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 24f));
        descriptionLabel.setBounds(160, 45, 355, 200);
        descriptionLabel.setBackground(new Color(104, 50, 19));
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setEditable(false);
        descriptionLabel.setFocusable(false);

        JLabel imagePanel = new JLabel(imageIcon);
        imagePanel.setBounds(55, 95, 80, 76);
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 253, 243), 5)); // White Border


        JPanel descriptionPanel = new JPanel(null);
        descriptionPanel.setBorder(BorderFactory.createLineBorder(new Color(182, 159, 11), 5)); // Gold border
        descriptionPanel.setBounds(36, 111, 531, 276);
        descriptionPanel.setBackground(new Color(104, 50, 19));
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(imagePanel);

        StyledDocument doc = descriptionLabel.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_JUSTIFIED);
        doc.setParagraphAttributes(0, doc.getLength(), style, false);
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_JUSTIFIED);
        StyleConstants.setLeftIndent(style, 15);  // Add left padding
        StyleConstants.setRightIndent(style, 15); // Add right padding
        StyleConstants.setSpaceAbove(style, 10);  // Add space above text
        StyleConstants.setSpaceBelow(style, 10);  // Add space below text
        doc.setParagraphAttributes(0, doc.getLength(), style, false);

        JButton okButton = new JButton("Ok");
        okButton.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard12-Regular.ttf", 24));
        okButton.setForeground(new Color(104, 50, 19));
        okButton.setBackground(Color.white);
        okButton.setBounds(501, 410, 82, 38);
        okButton.setFocusable(false);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(okButton).dispose();
            }
        });

        this.add(titlePanel);
        this.add(descriptionPanel);
        this.add(okButton);
        this.add(mainPanel);



        setVisible(true);
    }

}
