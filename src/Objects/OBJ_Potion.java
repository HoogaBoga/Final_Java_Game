package Objects;

import com.badlogic.gdx.Game;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Potion extends TopObject{

    public OBJ_Potion(GamePanel gp){
        name = "Blood of the Monarch Xavier";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Objects/RedPotion.png")));
            utilityTool.scaleImage(image, gp.newTileSize, gp.newTileSize);

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
