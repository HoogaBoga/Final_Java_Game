package Entities;

import main.JumpScare;
import main.GamePanel;

import java.util.Random;


public class NPC_Boss extends Entity{

    public boolean dialogueFinished = false;

    public NPC_Boss(GamePanel gp) {
        super(gp);

        direction = "left";
        speed = 4;

        getImage();
        setDialogue();
    }

    public void getImage(){
        up1 = setup("/resources/girlNPC/girlBackFace");
        up2 = setup("/resources/girlNPC/girlLeftFootBack");
        up3 = setup("/resources/girlNPC/girlRightFootBack");
        down1 = setup("/resources/girlNPC/girlFrontFace");
        down2 = setup("/resources/girlNPC/girlLeftFootFront");
        down3 = setup("/resources/girlNPC/girlRightFootFront");
        right1 = setup("/resources/girlNPC/girlRightFace");
        right2 = setup("/resources/girlNPC/girlLeftFootRight");
        right3 = setup("/resources/girlNPC/girlRightFootRight");
        left1 = setup("/resources/girlNPC/girlLeftFace");
        left2 = setup("/resources/girlNPC/girlLeftFootLeft");
        left3 = setup("/resources/girlNPC/girlRightFootLeft");
    }

    public void setDialogue(){
        dialogues[0] = "Welcome young traveller...";
        dialogues[1] = "I am the Wicked Witch of the East! Princess!!!";
        dialogues[2] = "You have done well surviving this far to face me... however, we won't be able to \nfight yet." +
                "There is no battle system set, so instead I will scare you now!";
    }

    @Override
    public void setAction(){

        actionLockCount++;

        if(actionLockCount == 120){
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if(i <= 25){
                direction = "up";
            }

            if(i > 25 && i <= 50){
                direction = "down";
            }

            if(i > 50 && i <= 75){
                direction = "left";
            }

            if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCount = 0;
        }


    }

    @Override
    public void speak() {
        if (!dialogueFinished) {
            super.speak(); // Show the next dialogue
            if (dialogueIndex > 2) {
                dialogueFinished = true; // Set the flag when dialogues are finished
            }
        } else {
            // Open the frame when Enter is pressed again
            if (gp.keyPut.enterPressed) {
                new JumpScare(); // Open the frame
                gp.playSoundFX(3);
                dialogueFinished = false; // Reset flag if needed
            }
        }
    }

}
