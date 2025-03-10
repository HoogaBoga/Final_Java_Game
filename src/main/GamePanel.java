package main;

import Entities.CollisionCheck;
import Entities.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originTileSize = 16; // 16x16 tiles
    final int scale = 3;

    public final int newTileSize = originTileSize * scale; // 48x48 tiles
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = newTileSize * maxScreenCol; // 960 pixels
    public final int screenHeight = newTileSize * maxScreenRow;// 720 pixels

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = newTileSize * maxWorldCol;
    public final int worldHeight = newTileSize*maxWorldRow;


    KeyInputs keyPut = new KeyInputs();
    Thread gameThread;
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public Player player = new Player(this, keyPut);
    public TileManager tileManager = new TileManager(this);

    //Frames Per Second Restriction
    int fps = 60;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyPut);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /fps;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;

        //Display FPS
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}
