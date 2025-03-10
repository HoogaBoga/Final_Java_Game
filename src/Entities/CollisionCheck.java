package Entities;

import main.GamePanel;

public class CollisionCheck {

    GamePanel gp;

    public CollisionCheck(GamePanel gp){

        this.gp = gp;
    }

    public void tileCheck(Entity entity){

        int playerLeftWorldX = entity.worldX + entity.solid.x;
        int playerRightWorldX = entity.worldX + entity.solid.x + entity.solid.width;
        int playerTopWorldY = entity.worldY + entity.solid.y;
        int playerBottomWorldY = entity.worldY + entity.solid.y + entity.solid.height;

        int playerLeftCol = playerLeftWorldX/gp.newTileSize;
        int playerRightCol = playerRightWorldX/gp.newTileSize;
        int playerTopRow = playerTopWorldY/gp.newTileSize;
        int playerBottomRow = playerBottomWorldY/gp.newTileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction){

            case "up":
                playerTopRow = (playerTopWorldY - entity.speed)/gp.newTileSize;
                tileNum1 = gp.tileManager.mapTileNumber[playerLeftCol][playerTopRow];
                tileNum2 = gp.tileManager.mapTileNumber[playerRightCol][playerTopRow];

                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                playerBottomRow = (playerBottomWorldY - entity.speed)/gp.newTileSize;
                tileNum1 = gp.tileManager.mapTileNumber[playerLeftCol][playerBottomRow];
                tileNum2 = gp.tileManager.mapTileNumber[playerRightCol][playerBottomRow];

                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                playerLeftCol = (playerLeftWorldX - entity.speed)/gp.newTileSize;
                tileNum1 = gp.tileManager.mapTileNumber[playerLeftCol][playerTopRow];
                tileNum2 = gp.tileManager.mapTileNumber[playerLeftCol][playerBottomRow];

                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                playerRightCol = (playerRightWorldX - entity.speed)/gp.newTileSize;
                tileNum1 = gp.tileManager.mapTileNumber[playerRightCol][playerTopRow];
                tileNum2 = gp.tileManager.mapTileNumber[playerRightCol][playerBottomRow];

                if(gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
