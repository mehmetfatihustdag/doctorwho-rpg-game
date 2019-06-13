package com.company.scene;

import com.company.util.CommonUtil;
import com.company.util.GameIntroductionUtil;

import static com.company.util.ASCIIArtUtil.printAsci;

public class Launcher {

    private Launcher(){

    }

    /**
     * First Part of the screen
     */
    public static void splashScreen() {
        printAsci("Dr. Who");
        showStory();

    }


    /**
     * Displays Story of the Game
     */
    private static void showStory() {
        try {
            for (String outputString : GameIntroductionUtil.GAME_STORY) {
                CommonUtil.loadStory();
                System.out.println(outputString);
            }
            Thread.sleep(2000);
        } catch (Exception e) {
           System.out.println("Problem occurs with game");
        }
    }

}
