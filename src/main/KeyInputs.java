package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {
    
    public boolean upPress, downPress, leftPress, rightPress;
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int pressedCode = e.getKeyCode();

        if(pressedCode == KeyEvent.VK_W){
            upPress = true;
        }

        if(pressedCode == KeyEvent.VK_S){
            downPress = true;
        }

        if(pressedCode == KeyEvent.VK_A){
            leftPress = true;
        }

        if(pressedCode == KeyEvent.VK_D){
            rightPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int releasedCode = e.getKeyCode();

        if(releasedCode == KeyEvent.VK_W){
            upPress = false;
        }

        if(releasedCode == KeyEvent.VK_S){
            downPress = false;
        }

        if(releasedCode == KeyEvent.VK_A){
            leftPress = false;
        }

        if(releasedCode == KeyEvent.VK_D){
            rightPress = false;
        }
    }
}
