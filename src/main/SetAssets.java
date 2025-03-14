package main;

import Objects.OBJ_Potion;
import Objects.OBJ_Sword;

public class SetAssets {

    GamePanel gamePanel;

    public SetAssets(GamePanel gamePanel){

        this.gamePanel = gamePanel;

    }

    public void setObjects() {

        gamePanel.object[0] = new OBJ_Potion();
        gamePanel.object[0].worldX = 4 * gamePanel.newTileSize;
        gamePanel.object[0].worldY = 10 * gamePanel.newTileSize;

        gamePanel.object[1] = new OBJ_Sword();
        gamePanel.object[1].worldX = 9 * gamePanel.newTileSize;
        gamePanel.object[1].worldY = 6 * gamePanel.newTileSize;


    }
}
