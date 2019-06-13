package com.company.test.factory;

import com.company.constant.GameConstants;

import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author fustdag <br>
 *         <b>Test Hero Factory Class</b>
 */
public class TestHeroFactory {

    HeroFactory factory;

    @Test
    public void testAlienCreateFactory() {
        Hero hero = new Hero();
        hero.setName("Fatih");
        hero.setHeroType(HeroPersonality.COMMANDER);
        Hero heroToCreate = factory.create("Fatih",HeroPersonality.COMMANDER.name());
        assertEquals(hero,heroToCreate);
    }


    @Test
    public void testAlienSetAttributesForDalek() {
        Hero heroAngry = new Hero();
        heroAngry.setHeroType(HeroPersonality.ANGRY);
        heroAngry.setName("Angry");
        heroAngry.setStrength(60);
        heroAngry.setExperience(0);
        heroAngry.setHealth(100);
        Hero heroToCreate = factory.create("Angry",HeroPersonality.ANGRY.name());
        assertEquals(heroAngry,heroToCreate);

        Hero heroCommander = new Hero();
        heroCommander.setHeroType(HeroPersonality.COMMANDER);
        heroCommander.setName("Commander");
        heroCommander.setStrength(90);
        heroCommander.setExperience(0);
        heroCommander.setHealth(100);
        Hero heroCommanderToCreate = factory.create("Commander",HeroPersonality.COMMANDER.name());
        assertEquals(heroCommander,heroCommanderToCreate);

        Hero heroDebater = new Hero();
        heroDebater.setHeroType(HeroPersonality.DEBATER);
        heroDebater.setName("Debater");
        heroDebater.setStrength(50);
        heroDebater.setExperience(0);
        heroDebater.setHealth(100);
        Hero heroDebaterToCreate = factory.create("Debater",HeroPersonality.DEBATER.name());
        assertEquals(heroDebater,heroDebaterToCreate);
    }


    @Before
    public void setUp()  {
        factory =(HeroFactory) FactoryProvider.getFactory(GameConstants.HERO);
    }

}
