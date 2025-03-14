package main;

import Objects.OBJ_Potion;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gamePanel;
    Font arial_35;
    BufferedImage potionImage;
    public boolean messageOn = false;
    public String message = "";
    int messageTimer = 0;

    public UI(GamePanel gamePanel){

        this.gamePanel = gamePanel;

        arial_35 = new Font("Arial", Font.PLAIN, 35);
        OBJ_Potion potion = new OBJ_Potion();
        potionImage = potion.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        g2.setFont(arial_35);
        g2.setColor(Color.white);
        g2.drawImage(potionImage, gamePanel.newTileSize/2, gamePanel.newTileSize/2, gamePanel.newTileSize, gamePanel.newTileSize, null);
        g2.drawString("x " + gamePanel.player.hasPotions, 65, 65);

        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(20f));
            g2.drawString(message, gamePanel.newTileSize/2, gamePanel.newTileSize*10);

            messageTimer++;

            if(messageTimer > 120){
                messageTimer = 0;
                messageOn = false;
            }
        }
    }

}
