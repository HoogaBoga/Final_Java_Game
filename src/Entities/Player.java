package Entities;

import Battle.BattleSystemWindow;
import main.GamePanel;
import main.ItemDescriptionGUI;
import main.KeyInputs;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyInputs keyPut;

    public final int screenX;
    public final int screenY;

    public int hasPotions = 0;
    int hasSword = 0;


    public Player(GamePanel gamePanel, KeyInputs keyPut){

        super(gamePanel);

        this.gamePanel = gamePanel;
        this.keyPut = keyPut;

        screenX = gamePanel.screenWidth/2 - (gamePanel.newTileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.newTileSize/2);

        solid = new Rectangle(8, 16, 24, 24);

        solidDefaultX = solid.x;
        solidDefaultY = solid.y;

        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
    
        worldX = 0;
        worldY = gamePanel.newTileSize * 2;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        up1 = setup("/resources/faceUp");
        up2 = setup("/resources/walkUpLeft");
        up3 = setup("/resources/walkUpRight");
        down1 = setup("/resources/faceFront");
        down2 = setup("/resources/walkFrontLeft");
        down3 = setup("/resources/walkFrontRight");
        right1 = setup("/resources/faceRight");
        right2 = setup("/resources/walkRightLeft");
        right3 = setup("/resources/walkRightRight");
        left1 = setup("/resources/faceLeft");
        left2 = setup("/resources/walkLeftLeft");
        left3 = setup("/resources/walkLeftRight");

    }


    public void update() {

        boolean isMoving = keyPut.upPress || keyPut.downPress || keyPut.leftPress || keyPut.rightPress;

        if (isMoving || keyPut.enterPressed) {

            if (isMoving) {
                if (keyPut.upPress) {
                    direction = "up";
                } else if (keyPut.downPress) {
                    direction = "down";
                } else if (keyPut.rightPress) {
                    direction = "right";
                } else if (keyPut.leftPress) {
                    direction = "left";
                }
            }

            collisionOn = false;
            if (isMoving) {
                gamePanel.collisionCheck.tileCheck(this);
            }

            int objectIndex = gamePanel.collisionCheck.objectCheck(this, true);
            pickUpObject(objectIndex);

            int npcIndex = gamePanel.collisionCheck.entityCheck(this, gamePanel.npc);

            // Move only if a directional key is pressed AND movement is allowed
            if (isMoving && !collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            interactNPC(npcIndex);

            if (gamePanel.gameState == gamePanel.dialogueState) {
                gamePanel.keyPut.enterPressed = false;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void pickUpObject(int index){

        if(index != 999){

            String objectName = gamePanel.object[index].name;

            if(!gamePanel.pickedUpItems.contains(objectName)){
                gamePanel.pickedUpItems.add(objectName);

                new ItemDescriptionGUI(getItemDescription(objectName), objectName, gamePanel.object[index].image);
            }

            switch (objectName){
                case "Blood of the Monarch Xavier":
                    gamePanel.stopMusic();
                    gamePanel.playSoundFX(2);
                    gamePanel.ui.showMessage("You got a potion!");
                    hasPotions++;
                    gamePanel.object[index] = null;
                    break;
                case "Holy Sword of Stefen":
                    gamePanel.stopMusic();
                    gamePanel.playSoundFX(1);
                    gamePanel.ui.showMessage("You got the Holy Sword of Stefen!");
                    hasSword++;
                    gamePanel.object[index] = null;
                    break;
            }
        }
    }

    public void interactNPC(int index){
        if(index != 999){
            if(gamePanel.keyPut.enterPressed){
                gamePanel.gameState = gamePanel.dialogueState;
                gamePanel.npc[index].speak();
            }
            gamePanel.keyPut.enterPressed = false;
        }

    }

    public String getItemDescription(String objectName){
        return switch (objectName) {
            case "Blood of the Monarch Xavier" ->
                    "Taken from the blood of the hand from the fallen knight, Monarch Xavier, it contains the magic that brings life back to those who dare drinks of it." +
                            " A healing potion that heals 100% of the player's HP.";

            case "Holy Sword of Stefen" -> "Taken from the lifeless corpse of the God of War, Stefen. " +
                    "The Holy Sword is a powerful weapon that can slice through anything, be it an enemy or an object standing in your way to victory!";

            default -> "A mysterious Item";
        };
    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }

                if(spriteNum == 2){
                    image = up2;
                }

                if(spriteNum == 3){
                    image = up3;
                }
                break;

            case "down":
                if(spriteNum == 1){
                    image = down1;
                }

                if(spriteNum == 2){
                    image = down2;
                }

                if(spriteNum == 3){
                    image = down3;
                }
                break;

            case "left":
                if(spriteNum == 1){
                    image = left1;
                }

                if(spriteNum == 2){
                    image = left2;
                }

                if(spriteNum == 3){
                    image = left3;
                }
                break;

            case "right":
                if(spriteNum == 1){
                    image = right1;
                }

                if(spriteNum == 2){
                    image = right2;
                }

                if(spriteNum == 3){
                    image = right3;
                }
                break;
        }

    g2.drawImage(image, screenX, screenY, null);
    }
}
