package com.company.test.service;

import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.repository.GameRepository;
import com.company.repository.IGameRepository;
import com.company.services.HeroService;
import com.company.services.IHeroService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
/**
 *
 * @author fustdag <br>
 *         <b>Test Game Service Class</b>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGameService {

    IGameRepository gameRepository;
    Hero hero;
    IHeroService heroService;


    @Test
    public void testACreateHero(){
        try {
            hero =heroService.createHero("fatih", HeroPersonality.DEBATER);
            Assert.assertNotNull(hero);
            Assert.assertEquals(hero.getName(),"fatih");
            Assert.assertEquals(HeroPersonality.DEBATER,hero.getHeroType());
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            Assert.fail("Failed");
        }
    }

    @Test
    public void testBSaveGame(){
       try {
           hero.setExperience(40);
           heroService.saveGame(hero);
       }catch (Exception ex){
           Assert.fail("Failed");
       }
    }

    @Test
    public void testCLoadGame(){
        try {
            Hero hero =heroService.loadHero();
            Assert.assertNotNull(hero);
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());

            Assert.fail("Failed");
        }
    }


    @Before
    public  void setUp(){
        gameRepository = new GameRepository("gametest.txt");
        hero = new Hero();
        heroService = new HeroService(gameRepository);
    }

}
