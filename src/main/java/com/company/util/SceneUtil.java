package com.company.util;


import com.company.entities.Hero;

import java.io.FileOutputStream;
import java.io.IOException;

public class SceneUtil {


    public static void gameOver(){
        System.out.println("com.company.main.GamePlay Over !!!");
        exitToGame();
    }

    public static boolean isMissionCompleted(final Hero hero){
        if(hero.getItems().isEmpty()) {
            CommonUtil.loadStory();
            System.out.println("Congratulation Doctor, you reached the mission Doctor");
            CommonUtil.load();
            System.out.println(hero.getName() + " reached the Point : " + hero.getExperience());
            return true;
        }
        return false;
    }

    public static void exitToGame(){
        System.out.println("See you later");
        System.exit(0);
    }

}
