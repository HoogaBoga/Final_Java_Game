package main;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[30];

    public Sound(){

        soundURL[0] = getClass().getResource("/resources/Sounds/1-05. Vaniville Town.wav");
        soundURL[1] = getClass().getResource("/resources/Sounds/item-found.wav");
        soundURL[2] = getClass().getResource("/resources/Sounds/potionPickup.wav");
    }

    public void setFile(int i){

        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void playMusic(){

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-30.0f);
        clip.start();
    }

    public void playMusicSFX(int soundIndex, Runnable onComplete) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL[soundIndex]);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream); //

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();

                    if (onComplete != null) {
                            onComplete.run(); // Resume background music
                        }
                    }
                });

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f);
                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void loopMusic(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopMusic(){

        clip.stop();
    }
}
