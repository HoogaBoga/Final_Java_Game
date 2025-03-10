package Entities;

import main.GamePanel;
import main.KeyInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyInputs keyPut;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyInputs keyPut){

        this.gamePanel = gamePanel;
        this.keyPut = keyPut;

        screenX = gamePanel.screenWidth/2 - (gamePanel.newTileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.newTileSize/2);

        solid = new Rectangle(8, 16, 32, 32);

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

        try{

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/faceUp.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkUpLeft.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkUpRight.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/faceFront.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkFrontLeft.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkFrontRight.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/faceRight.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkRightLeft.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkRightRight.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/faceLeft.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkLeftLeft.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/walkLeftRight.png")));

        } catch (IOException ie){
            ie.printStackTrace();
        }
    }
    
    public void update(){

        if(keyPut.upPress || keyPut.downPress || keyPut.leftPress || keyPut.rightPress){

            if(keyPut.upPress){
                direction = "up";
            }

            else if(keyPut.downPress){
                direction = "down";
            }

            else if(keyPut.rightPress){
                direction = "right";
            }

            else if(keyPut.leftPress){
                direction = "left";
            }

            collisionOn = false;
            gamePanel.collisionCheck.tileCheck(this);

            if(!collisionOn){
                switch (direction){
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

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }

                else if(spriteNum == 2){
                    spriteNum = 3;
                }

                else if(spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

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

    g2.drawImage(image, screenX, screenY, gamePanel.newTileSize, gamePanel.newTileSize, null);
    }
}
