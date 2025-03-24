package main;

import Entities.*;
import Objects.OBJ_Potion;
import Objects.OBJ_Sword;

public class SetAssets {

    GamePanel gamePanel;

    public SetAssets(GamePanel gamePanel){

        this.gamePanel = gamePanel;

    }

    public void setObjects() {

        gamePanel.object[0] = new OBJ_Potion(gamePanel);
        gamePanel.object[0].worldX = 4 * gamePanel.newTileSize;
        gamePanel.object[0].worldY = 10 * gamePanel.newTileSize;

        gamePanel.object[1] = new OBJ_Sword(gamePanel);
        gamePanel.object[1].worldX = 9 * gamePanel.newTileSize;
        gamePanel.object[1].worldY = 6 * gamePanel.newTileSize;

        gamePanel.object[2] = new OBJ_Potion(gamePanel);
        gamePanel.object[2].worldX = 2* gamePanel.newTileSize;
        gamePanel.object[2].worldY = 24*gamePanel.newTileSize;

        gamePanel.object[3] = new OBJ_Potion(gamePanel);
        gamePanel.object[3].worldX = 47* gamePanel.newTileSize;
        gamePanel.object[3].worldY = 47*gamePanel.newTileSize;

        gamePanel.object[4] = new OBJ_Potion(gamePanel);
        gamePanel.object[4].worldX = 47* gamePanel.newTileSize;
        gamePanel.object[4].worldY = 40*gamePanel.newTileSize;

        gamePanel.object[5] = new OBJ_Potion(gamePanel);
        gamePanel.object[5].worldX = 43* gamePanel.newTileSize;
        gamePanel.object[5].worldY = 31*gamePanel.newTileSize;


    }

    public void setNPC(){

        gamePanel.npc[0] = new NPC_Blue(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.newTileSize*9;
        gamePanel.npc[0].worldY = gamePanel.newTileSize*4;

        gamePanel.npc[1] = new NPC_Boss(gamePanel);
        gamePanel.npc[1].worldX = gamePanel.newTileSize*47;
        gamePanel.npc[1].worldY = gamePanel.newTileSize*23;

        gamePanel.npc[2] = new NPC_1(gamePanel);
        gamePanel.npc[2].worldX = gamePanel.newTileSize;
        gamePanel.npc[2].worldY = gamePanel.newTileSize*46;

        gamePanel.npc[3] = new NPC_2(gamePanel);
        gamePanel.npc[3].worldX = gamePanel.newTileSize*37;
        gamePanel.npc[3].worldY = gamePanel.newTileSize*47;

        gamePanel.npc[4] = new NPC_3(gamePanel);
        gamePanel.npc[4].worldX = gamePanel.newTileSize*44;
        gamePanel.npc[4].worldY = gamePanel.newTileSize*34;

        gamePanel.npc[5] = new NPC_4(gamePanel);
        gamePanel.npc[5].worldX = gamePanel.newTileSize*27;
        gamePanel.npc[5].worldY = gamePanel.newTileSize*3;

        gamePanel.npc[6] = new NPC_5(gamePanel);
        gamePanel.npc[6].worldX = gamePanel.newTileSize*47;
        gamePanel.npc[6].worldY = gamePanel.newTileSize*9;

    }
}
