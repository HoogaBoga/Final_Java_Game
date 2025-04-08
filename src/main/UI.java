package main;

import Objects.OBJ_Potion;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;

    Font arial_35;
    BufferedImage potionImage;
    public boolean messageOn = false;
    public String message = "";
    int messageTimer = 0;
    public String currentDia = "";

    public UI(GamePanel gamePanel){

        this.gamePanel = gamePanel;

        arial_35 = new Font("Arial", Font.PLAIN, 35);
        OBJ_Potion potion = new OBJ_Potion(gamePanel);
        potionImage = potion.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;
        g2.setFont(arial_35);
        g2.setColor(Color.white);
        g2.drawImage(potionImage, gamePanel.newTileSize/2, gamePanel.newTileSize/2, gamePanel.newTileSize, gamePanel.newTileSize, null);
        g2.drawString("x " + gamePanel.player.hasPotions, 65, 65);
        g2.drawString("Press I for Instructions" ,35, 110);

        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(20f));
            g2.drawString(message, gamePanel.newTileSize/2, gamePanel.newTileSize*10);

            messageTimer++;

            if(messageTimer > 120){
                messageTimer = 0;
                messageOn = false;
            }
        }

        // PLAY STATE
        if(gamePanel.gameState == gamePanel.playState){

        }

        //PAUSE STATE
        if(gamePanel.gameState == gamePanel.pauseState){
            drawPause();
        }

        //DIALOGUE STATE
        if(gamePanel.gameState == gamePanel.dialogueState){
            drawDialogueScreen();
        }

        if(gamePanel.gameState == gamePanel.battleState){

        }
    }

    public void drawPause(){

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f));
        String text = "PAUSED";
        int x = getXForText(text);
        int y = gamePanel.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen(){
        int x = gamePanel.newTileSize*2;
        int height = gamePanel.newTileSize*4;
        int y = gamePanel.screenHeight - height - (gamePanel.newTileSize/2);
        int width = gamePanel.screenWidth - (gamePanel.newTileSize*4);


        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20f));
        x += gamePanel.newTileSize;
        y += gamePanel.newTileSize;

        for(String line : currentDia.split("\n")){
            g2.drawString(line, x, y);
            y += 30;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color color = new Color(0,0,0, 210);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXForText(String text){

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gamePanel.screenWidth/2 - length/2;

        return x;
    }

}
