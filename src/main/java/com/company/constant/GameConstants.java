package com.company.constant;

/**
 *
 * @author fustdag <br>
 *         <b>GameConstants class provide the constants for application</b>
 *
 */
public class GameConstants {

    private GameConstants() {

    }

    //Application Constants
    public static final String GAME_START = "Game has been started..." + System.lineSeparator() + "For quit:type (quit) ..";
    public static final String ASK_LOAD_GAME = "Do you want to load a game? (y/n) " +"For quit:type (quit) .." +System.lineSeparator() + ">";
    public static final String ASK_NAME ="Please, enter your name ...";
    public static final String ASK_PERSONALITY = "Now let's select what kind of personality you are..";
    public static final String QUIT = "quit";
    public static final String ACTION_CHOSE ="Action Choose : > ";
    public static final Integer REGENERATION_EXPERIENCE_THRESHOLD =40;
    public static final String FILE_PATH = "game.txt";

    //Scene Constants
    public static final String MYSTERY_OF_BADWOLF = " What is it that goes up, but never comes down?";
    public static final String ANSWER_OF_BADWOLF = "AGE";
    public static final Integer BADWOLD_EXPERIENCE_HIT = 20;
    public static final String MYSTERY_OF_PANDORICA = "Where pandorica is hidden ?";
    public static final String ANSWER_OF_PANDORICA = "STONHENGE";
    public static final Integer PANDORICA_EXPERIENCE_HIT = 30;
    public static final String MYSTERY_OF_DEATHPLANET ="Who discovered the Black Hole ?";
    public static final String ANSWER_OF_DEATHPLANET ="KARL";
    public static final Integer DEATH_PLANET_EXPERIENCE_HIT = 50;

    //Character Constants
    public static final Integer ANGRY_HERO_STRENGTH =60;
    public static final Integer COMMANDER_HERO_STRENGTH =90;
    public static final Integer DEBATER_HERO_STRENGTH =50;

    public static final Integer HERO_EXPERIENCE= 0;
    public static final Integer HERO_HEALTH= 100;

    public static final Integer DALEK_STRENGTH =40;
    public static final Integer DALEK_ATTACK  =25;

    public static final Integer CYBERMAN_STRENGTH =90;
    public static final Integer CYBERMAN_ATTACK  =40;

    public static final Integer DEMON_STRENGTH=90;
    public static final Integer DEMON_ATTACK  =30;

    public static final Integer ALIEN_HEALTH = 100;




}
