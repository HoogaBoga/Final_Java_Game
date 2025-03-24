package Entities;

import main.GamePanel;

import java.util.Random;


public class NPC_Blue extends Entity{
    public NPC_Blue(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 4;

        getImage();
        setDialogue();
    }

    public void getImage(){
        up1 = setup("/resources/blueHairNPC/backFaceGuy");
        up2 = setup("/resources/blueHairNPC/leftFootBack");
        up3 = setup("/resources/blueHairNPC/rightFootBack");
        down1 = setup("/resources/blueHairNPC/frontFaceGuy");
        down2 = setup("/resources/blueHairNPC/leftFootFront");
        down3 = setup("/resources/blueHairNPC/rightFootFront");
        right1 = setup("/resources/blueHairNPC/rightFaceGuy");
        right2 = setup("/resources/blueHairNPC/leftFootRight");
        right3 = setup("/resources/blueHairNPC/rightFootRight");
        left1 = setup("/resources/blueHairNPC/leftFaceGuy");
        left2 = setup("/resources/blueHairNPC/leftFootLeft");
        left3 = setup("/resources/blueHairNPC/rightFootLeft");
    }

    public void setDialogue(){
        dialogues[0] = "Hello! Welcome to the world of Kill or Be Killed! I am Stefen.";
        dialogues[1] = "You're probably wondering, 'wait a minute, I just got this guy's sword!'";
        dialogues[2] = "Well...I'm not really dead. I just accidentally dropped my sword and just found \nout about it now. But" +
                " it seems like you look good in it and you also don't have a \nweapon in this dangerous place! So I'll let you keep it." +
                " Consider it a welcoming \ngift! Toodaloo!";
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
        super.speak();
    }

}
