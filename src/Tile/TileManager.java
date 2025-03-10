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

        tile = new Tiles[35];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/resources/Map.txt/");
    }

    public void getTileImage(){

        try {

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/001.png")));
            tile[1].collision = true;
            //grass tiles

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/002.png")));
            tile[2].collision = true;
            //grass with black tiles

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/003.png")));
            //path tiles

            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/004.png")));
            //path with upper left grass

            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/005.png")));
            //path with upper middle grass

            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/006.png"))); //
            //path with upper right grass

            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/007.png")));
            //path with middle left grass

            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/008.png")));
            //path with middle right grass

            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/009.png")));
            //path with bottom left grass

            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/010.png")));
            //path with bottom middle grass

            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/011.png")));
            //path with bottom right grass

            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/016.png")));
            tile[16].collision = true;
            //tree tiles

            tile[18] = new Tiles();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/018.png")));
            tile[18].collision = true;
            //plain water tile

            tile[19] = new Tiles();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/019.png")));
            tile[19].collision = true;
            //water tile with waves

            tile[20] = new Tiles();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/020.png")));
            tile[20].collision = true;
            //top left water with grass

            tile[21] = new Tiles();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/021.png")));
            tile[21].collision = true;
            //top middle water with grass

            tile[22] = new Tiles();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/022.png")));
            tile[22].collision = true;
            //top right water with grass

            tile[23] = new Tiles();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/023.png")));
            tile[23].collision = true;
            //middle left water with grass

            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/024.png")));
            tile[24].collision = true;
            //middle right water with grass

            tile[25] = new Tiles();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/025.png")));
            tile[25].collision = true;
            //bottom left water with grass

            tile[26] = new Tiles();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/026.png")));
            tile[26].collision = true;

            //bottom middle water with grass

            tile[27] = new Tiles();
            tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/027.png")));
            tile[27].collision = true;
            //bottom right water with grass

            tile[28] = new Tiles();
            tile[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/028.png")));
            tile[28].collision = true;
            //top left water with grass in middle

            tile[29] = new Tiles();
            tile[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/029.png")));
            tile[29].collision = true;
            //top right water with grass in middle

            tile[30] = new Tiles();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/030.png")));
            tile[30].collision = true;
            //bottom left water with grass in middle

            tile[31] = new Tiles();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/031.png")));
            tile[31].collision = true;
            //bottom right water with grass in middle

            tile[32] = new Tiles();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/032.png")));
            tile[32].collision = true;
            //rock tiles

            tile[33] = new Tiles();
            tile[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Tiles/033.png")));
            tile[33].collision = true;
            //house tiles

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
