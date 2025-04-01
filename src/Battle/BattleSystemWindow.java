package Battle;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class BattleSystemWindow {

    public static void startBattle(Runnable onBattleEnd){
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();

        configuration.setTitle("Battle Start!");
        configuration.setWindowedMode(800, 600);

        new Lwjgl3Application(new BattleGame(onBattleEnd), configuration);
    }
}
