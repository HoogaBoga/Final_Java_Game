package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemDescriptionGUI extends JFrame{

    public ItemDescriptionGUI(String description, String itemName, ImageIcon image){

        setTitle("Item");
        setSize(606, 462);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();

        mainPanel.setSize(new Dimension(606, 462));
        mainPanel.setBackground(new Color(104, 50, 19));

        JPanel titlePanel = new JPanel();

        titlePanel.setBackground(Color.white);
        titlePanel.setBounds(0, 19, 606, 63);

        JLabel titleLabel = new JLabel(itemName);
        titleLabel.setFont(FontLoader.loadFontFromResource("/resources/fonts/Jacquard 12-Regular.ttf", 40f));



        this.add(titlePanel);
        this.add(mainPanel);


        setVisible(true);
    }

    public static void main(String[] args){
        ImageIcon image = new ImageIcon("/resources/Objects/Sword.png");


        new ItemDescriptionGUI("Yuh", "yes", image);
    }

}
