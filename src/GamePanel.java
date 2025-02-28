import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originTileSize = 16; // 16x16 tiles
    final int scale = 3;

    final int newTileSize = originTileSize * scale; // 48x48 tiles
    final int maxScreenCol = 20;
    final int maxScreenRow = 15;
    final int screenWidth = newTileSize * maxScreenCol; // 960 pixels
    final int screenHeight = newTileSize * maxScreenRow; // 720 pixels

    KeyInputs keyPut = new KeyInputs();
    Thread gameThread;

    //Player initial Position
    int initPlayerPosX = 100;
    int initPlayerPosY = 100;

    //Player Speed
    int playerSpeed = 4;

    //Frames Per Second Restriction
    int fps = 60;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
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

        if(keyPut.upPress){
            initPlayerPosY -= playerSpeed;
        }

        else if(keyPut.downPress){
            initPlayerPosY += playerSpeed;
        }

        else if(keyPut.rightPress){
            initPlayerPosX += playerSpeed;
        }

        else if(keyPut.leftPress){
            initPlayerPosX -= playerSpeed;
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);

        g2.fillRect(initPlayerPosX, initPlayerPosY, newTileSize, newTileSize);

        g2.dispose();
    }
}
