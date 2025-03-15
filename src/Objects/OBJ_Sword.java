package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Sword extends TopObject{

    public OBJ_Sword(){
        name = "Holy Sword of Stefen";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Objects/Sword.png")));
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
