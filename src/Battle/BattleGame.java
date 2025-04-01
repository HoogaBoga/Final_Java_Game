package Battle;

import com.badlogic.gdx.ApplicationAdapter;

public class BattleGame extends ApplicationAdapter {

    private final Runnable onBattleEnd;

    public BattleGame(Runnable onBattleEnd) {
        this.onBattleEnd = onBattleEnd;
    }

    @Override
    public void create() {
        // Initialize battle logic and UI
    }

    @Override
    public void render() {
        // Render the battle
        // Handle inputs and update battle logic
    }

    public void endBattle() {
        // Call this when the battle ends
        onBattleEnd.run();
        // Exit the battle window
        System.exit(0);
    }
}
