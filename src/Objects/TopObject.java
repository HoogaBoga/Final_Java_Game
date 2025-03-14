package Objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TopObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public Rectangle solid = new Rectangle(0,0, 48, 48);
    public int solidDefaultX = 0;
    public int solidDefaultY = 0;
    
    public void draw(Graphics2D g2, GamePanel gamePanel){

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        if(worldX + gamePanel.newTileSize > gamePanel.player.worldX - gamePanel.player.screenX
                && worldX - gamePanel.newTileSize < gamePanel.player.worldX + gamePanel.player.screenX
                && worldY + gamePanel.newTileSize > gamePanel.player.worldY - gamePanel.player.screenY
                && worldY - gamePanel.newTileSize < gamePanel.player.worldY + gamePanel.player.screenY){

            g2.drawImage(image, screenX, screenY, gamePanel.newTileSize, gamePanel.newTileSize, null);
        }
        
    }
}
