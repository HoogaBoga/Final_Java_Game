package main;

import Entities.CollisionCheck;
import Entities.Entity;
import Entities.Player;
import Objects.TopObject;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originTileSize = 16; // 16x16 tiles
    final int scale = 3;


    public final int newTileSize = originTileSize * scale;// 48x48 tiles

    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = newTileSize * maxScreenCol; // 960 pixels
    public final int screenHeight = newTileSize * maxScreenRow;// 720 pixels

    public int maxWorldCol = 50;
    public int maxWorldRow = 50;

    public HashSet<String> pickedUpItems = new HashSet<>();

    Sound sound = new Sound();
    Sound soundFX = new Sound();
    public KeyInputs keyPut = new KeyInputs(this);
    Thread gameThread;
    public UI ui = new UI(this);
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public Player player = new Player(this, keyPut);
    public TileManager tileManager = new TileManager(this);
    public TopObject[] object = new TopObject[10];
    public Entity[] npc = new Entity[10];

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int battleState = 4;

    public SetAssets setAssets = new SetAssets(this);


    //Frames Per Second Restriction
    int fps = 60;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyPut);
        this.setFocusable(true);
    }

    public void gameSetup() {

        setAssets.setObjects();
        setAssets.setNPC();
        playMusic(0);
        gameState = playState;

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

        if(gameState == playState){
            player.update();
        }

        if(gameState == pauseState){
            //wa
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //DEBUG
        long drawStart = 0;

        if(keyPut.checkDrawTime){
            drawStart = System.nanoTime();
        }

        tileManager.draw(g2);

        for (TopObject topObject : object) {
            if (topObject != null) {
                topObject.draw(g2, this);
            }
        }

        for (Entity entity : npc) {
            if (entity != null) {
                entity.draw(g2);
            }
        }

        player.draw(g2);
        ui.draw(g2);

        if(keyPut.checkDrawTime){
            long drawEnd = System.nanoTime();
            long passedTime = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passedTime, 10, 400);
            System.out.println("Draw Time: " + passedTime);
        }


        g2.dispose();
    }

    public void playMusic(int i){


        sound.setFile(i);
        sound.playMusic();
        sound.loopMusic();

    }

    public void stopMusic(){
        sound.stopMusic();
    }

    public void playSoundFX(int i){
        soundFX.setFile(i);
        soundFX.playMusicSFX(i, () -> this.playMusic(0));
    }
}
