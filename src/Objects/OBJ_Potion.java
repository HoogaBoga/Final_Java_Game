package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Potion extends TopObject{

    public OBJ_Potion(){
        name = "Potion";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Objects/RedPotion.png")));
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
