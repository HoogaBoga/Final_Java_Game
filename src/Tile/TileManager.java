package Tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager{

    GamePanel gp;
    public Tiles[] tile;
    public int[][] mapTileNumber;
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> collisionStatus = new ArrayList<>();

    public TileManager(GamePanel gp){

        this.gp = gp;

        InputStream is = getClass().getResourceAsStream("/resources/tileData2.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String line;

        try {
            while((line = bufferedReader.readLine()) != null){
                fileNames.add(line);
                collisionStatus.add(bufferedReader.readLine());
            }

            bufferedReader.close();
        } catch (IOException ie){
            ie.printStackTrace();
        }

        tile = new Tiles[fileNames.size()];
        getTileImage();

        is = getClass().getResourceAsStream("/resources/Map2.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(is));

        try {
            String line2 = bufferedReader.readLine();
            String maxTile[] = line2.split(" ");

            gp.maxWorldCol = maxTile.length;
            mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

            bufferedReader.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        loadMap("/resources/Map2.txt/");
    }

    public void getTileImage(){

        for(int i = 0; i < fileNames.size(); i++){
            String fileName;
            boolean collision;

            fileName = fileNames.get(i);

            if(collisionStatus.get(i).equals("true")){
                collision = true;
            }
            else{
                collision = false;
            }

            setup(i, fileName, collision);
        }
    }

    public void setup(int index, String imagePath, boolean collision){

        UtilityTool utilityTool = new UtilityTool();

        try{

            tile[index] = new Tiles();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/" + imagePath)));
            tile[index].image = utilityTool.scaleImage(tile[index].image, gp.newTileSize, gp.newTileSize);
            tile[index].collision = collision;

        } catch (IOException ie){
            ie.printStackTrace();
        }
    }

    public void loadMap(String file){

        try{
            InputStream is = getClass().getResourceAsStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol) {

                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;

                }

                if(col == gp.maxWorldCol){

                    col = 0;
                    row++;
                }


            }

            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
       

        while(worldCol < gp.maxWorldCol && worldRow  < gp.maxWorldRow){

            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gp.newTileSize;
            int worldY = worldRow * gp.newTileSize;

            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.newTileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.newTileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.newTileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.newTileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.newTileSize, gp.newTileSize, null);
            }


            worldCol++;
            

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow ++;
            }
        }
    }

}
