package Entities;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {

    GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solid = new Rectangle(0,0, 48, 48);
    public int solidDefaultX;
    public int solidDefaultY;
    public boolean collisionOn = false;
    public int actionLockCount = 0;
    String[] dialogues = new String[20];
    int dialogueIndex = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction(){

    }

    public void speak(){
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDia = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    public void update(){
        setAction();

        collisionOn = false;
        gp.collisionCheck.tileCheck(this);
        gp.collisionCheck.objectCheck(this, false);
        gp.collisionCheck.checkPlayer(this);

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

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.newTileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.newTileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.newTileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.newTileSize < gp.player.worldY + gp.player.screenY){

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


            g2.drawImage(image, screenX, screenY, gp.newTileSize, gp.newTileSize, null);
        }
    }

    public BufferedImage setup(String imageName){

        UtilityTool utilityTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imageName + ".png")));
            image = utilityTool.scaleImage(image, gp.newTileSize, gp.newTileSize);

        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        return image;
    }
}
