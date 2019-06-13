package com.company.main;

import com.company.scene.Launcher;

/**
 *
 * @author fustdag <br>
 *         <b>com.company.main.Main class of the application</b>
 *
 *
 */
public class Main  {

    /**
     * com.company.main.Main method Entry Point
     *
     * @param args
     *            Any Arguments
     *
     */
    public static void main(String[] args) {
        Launcher.splashScreen();
        GamePlay game = new GamePlay();
        game.startGame();
    }


}
