package Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
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

        tile = new Tiles[40];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/resources/Map2.txt/");
    }

    public void getTileImage(){

        try {

            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/FarmLand_Tile.png")));
            //farm land tiles

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Grass_Middle.png")));
            tile[1].collision = true;
            //grass

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/House.png")));
            tile[2].collision = true;
            //house tiles

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Middle.png")));
            //path

            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_BotLeft.png")));
            tile[4].collision = true;
            //path with lower left grass

            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_BotMid.png"))); //
            //path with lower mid-grass

            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_BotRight.png")));
            tile[6].collision = true;
            //path with lower right grass

            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_MidLeft.png")));
            tile[9].collision = true;
            //path with middle left grass

            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_MidRight.png")));
            //path with mid-right grass

            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_Step1.png")));
            //path with dark

            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_UpperLeft.png")));
            //path with upper left grass

            tile[17] = new Tiles();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_UpperMid.png")));
            //path with upper middle grass

            tile[18] = new Tiles();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Path_Tile_UpperRight.png")));

            //path with upper right grass

            tile[19] = new Tiles();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Tree.png")));
            tile[19].collision = true;
            //Tree tile

            tile[20] = new Tiles();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Wall.png")));
            tile[20].collision = true;
            //Wall tile

            tile[21] = new Tiles();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Middle.png")));
            tile[21].collision = true;
            //Water tile

            tile[22] = new Tiles();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_BotLeft.png")));
            tile[22].collision = true;
            //Water bottom left

            tile[23] = new Tiles();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_BotMid.png")));
            tile[23].collision = true;
            //Water bottom mid

            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_BotRight.png")));
            tile[24].collision = true;
            //Water bottom right

            tile[25] = new Tiles();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_BottomLeft.png")));
            tile[25].collision = true;
            //Water with grass bot left

            tile[26] = new Tiles();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_BottomRight.png")));
            tile[26].collision = true;
            //Water with grass bot right

            tile[27] = new Tiles();
            tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_MidLeft.png")));
            tile[27].collision = true;
            //Water mid left

            tile[28] = new Tiles();
            tile[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_MidRight.png")));
            tile[28].collision = true;
            //Water mid right

            tile[29] = new Tiles();
            tile[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_Step1.png")));
            tile[29].collision = true;
            //Water with black 1

            tile[30] = new Tiles();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_Step2.png")));
            tile[30].collision = true;
            //Water with black 2

            tile[31] = new Tiles();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_Step3.png")));
            tile[31].collision = true;
            //Water with black 3

            tile[32] = new Tiles();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_TopLeft.png")));
            tile[32].collision = true;
            //water top left grass

            tile[33] = new Tiles();
            tile[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_TopRight.png")));
            tile[33].collision = true;
            //water top right grass

            tile[34] = new Tiles();
            tile[34].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_UpperLeft.png")));
            tile[34].collision = true;
            //house tiles

            tile[35] = new Tiles();
            tile[35].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_UpperMid.png")));
            tile[35].collision = true;

            tile[36] = new Tiles();
            tile[36].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles2/Water_Tile_UpperRight.png")));
            tile[36].collision = true;

        } catch (IOException ioe){
            ioe.printStackTrace();
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
