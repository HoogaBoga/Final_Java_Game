package main;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyInputs implements KeyListener {
    
    public boolean upPress, downPress, leftPress, rightPress, enterPressed;
    public GamePanel gp;

    //DEBUG
    public boolean checkDrawTime = false;
    private boolean instructionsOpen = false;

    public KeyInputs(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int pressedCode = e.getKeyCode();

        if(gp.gameState == gp.playState){
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

            if(pressedCode == KeyEvent.VK_P){
                gp.gameState = gp.pauseState;
            }
            if(pressedCode == KeyEvent.VK_ENTER){
                enterPressed = true;
            }

            if(pressedCode == KeyEvent.VK_T){
                if(!checkDrawTime){
                    checkDrawTime = true;
                }

                else {
                    checkDrawTime = false;
                }
            }

            if (pressedCode == KeyEvent.VK_I && !instructionsOpen) {
                new InstructionsGUI();
                instructionsOpen = true;
            }
        }

        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            if(pressedCode == KeyEvent.VK_P){
                gp.gameState = gp.playState;
            }
        }

        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState){
            if(pressedCode == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState;
            }
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

        if (releasedCode == KeyEvent.VK_I) {
            instructionsOpen = false;
        }
    }
}
