package com.company.test.main;

import com.company.constant.GameConstants;
import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import com.company.main.GamePlay;

import com.company.scene.BadWolf;
import com.company.scene.PlanetOfTheDeath;
import com.company.scene.SceneContext;
import com.company.scene.ThePandorica;
import com.company.util.scanner.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import java.lang.reflect.Field;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 *
 * @author fustdag <br>
 *         <b>Test Game Play Class</b>
 */
public class TestGamePlay {

    @Rule
    public final TextFromStandardInputStream systemInMockFirstCase
            = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void startGameCreateHeroAndSaveGameAction(){
        exit.expectSystemExitWithStatus(0);
        //Answer For Create Hero Action
        systemInMockFirstCase.provideLines("N","Fatih","1","1");
            GamePlay gamePlay = new GamePlay();
            gamePlay.startGame();

    }

    @Test
    public void startGameCreateHeroAndExloreGameAction(){
        exit.expectSystemExitWithStatus(0);
        //Answer For Create Hero Action
        systemInMockFirstCase.provideLines("N","Fatih","1","2",
                                 GameConstants.ANSWER_OF_BADWOLF,
                                 "2",GameConstants.ANSWER_OF_PANDORICA,
                                 "2",GameConstants.ANSWER_OF_DEATHPLANET);
        GamePlay gamePlay = new GamePlay();
        gamePlay.startGame();

    }

    @Test
    public void startGameCreateHeroAndExloreInvalidAction(){
        exit.expectSystemExitWithStatus(0);
        systemInMockFirstCase.provideLines("N","Fatih","1","4","quit");
        GamePlay gamePlay = new GamePlay();
        gamePlay.startGame();

    }

    @Test
    public void TestSuccessContextBadWolf(){
        //Correct Answer To Mysteries
        systemInMockFirstCase.provideLines(GameConstants.ANSWER_OF_BADWOLF,GameConstants.ANSWER_OF_DEATHPLANET,GameConstants.ANSWER_OF_PANDORICA);
        Hero hero;
        HeroFactory heroFactory = (HeroFactory) FactoryProvider.getFactory(GameConstants.HERO);
        //BadWolf
        hero =heroFactory.create("fatih", HeroPersonality.COMMANDER.name());
        SceneContext badWolfContexr = new SceneContext(new BadWolf(), AlienRace.DALEK,30);
        Hero heroUpdated = badWolfContexr.explore(hero);
        Assert.assertEquals(hero.getName(),heroUpdated.getName());
        Assert.assertEquals(heroUpdated.getExperience(),Integer.valueOf(30));

        //Death Of Planet
        hero =heroFactory.create("fatih", HeroPersonality.COMMANDER.name());
        SceneContext deathPlanetContext = new SceneContext(new PlanetOfTheDeath(),AlienRace.DALEK,50);
        Hero heroDeathPlanetUpdated = deathPlanetContext.explore(hero);
        Assert.assertEquals(hero.getName(),heroDeathPlanetUpdated.getName());
        Assert.assertEquals(heroDeathPlanetUpdated.getExperience(),Integer.valueOf(50));

        //Pandorica
        hero =heroFactory.create("fatih", HeroPersonality.COMMANDER.name());
        SceneContext pandoricaContext = new SceneContext(new ThePandorica(),AlienRace.DALEK,50);
        Hero heroPandoricaUpdated = pandoricaContext.explore(hero);
        Assert.assertEquals(hero.getName(),heroPandoricaUpdated.getName());
        Assert.assertEquals(heroPandoricaUpdated.getExperience(),Integer.valueOf(50));

    }

    @Before
    public void resetMySingleton() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field instance = Input.class.getDeclaredField("referenceToSingleInputObject");
        instance.setAccessible(true);
        instance.set(null, null);
    }


}
