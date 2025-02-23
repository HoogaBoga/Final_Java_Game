import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    //Screen Settings
    final int originTileSize = 16; // 16x16 tiles
    final int scale = 3;

    final int newTileSize = originTileSize * scale; // 48x48 tiles
    final int maxScreenCol = 20;
    final int maxScreenRow = 15;
    final int screenWidth = newTileSize * maxScreenCol; // 960 pixels
    final int screenHeight = newTileSize * maxScreenRow; // 720 pixels

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
    }

}
