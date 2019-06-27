package com.company.test.factory;


import com.company.entities.Hero;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import org.junit.Before;
import org.junit.Test;

import static com.company.entities.CharacterType.HERO;
import static com.company.entities.HeroPersonality.ANGRY;
import static com.company.entities.HeroPersonality.COMMANDER;
import static com.company.entities.HeroPersonality.DEBATER;
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
        hero.setHeroType(COMMANDER);
        Hero heroToCreate = factory.create("Fatih", COMMANDER.name());
        assertEquals(hero,heroToCreate);
    }


    @Test
    public void testAlienSetAttributesForDalek() {
        Hero heroAngry = new Hero();
        heroAngry.setHeroType(ANGRY);
        heroAngry.setName("Angry");
        heroAngry.setStrength(60);
        heroAngry.setExperience(0);
        heroAngry.setHealth(100);
        Hero heroToCreate = factory.create("Angry", ANGRY.name());
        assertEquals(heroAngry,heroToCreate);

        Hero heroCommander = new Hero();
        heroCommander.setHeroType(COMMANDER);
        heroCommander.setName("Commander");
        heroCommander.setStrength(90);
        heroCommander.setExperience(0);
        heroCommander.setHealth(100);
        Hero heroCommanderToCreate = factory.create("Commander", COMMANDER.name());
        assertEquals(heroCommander,heroCommanderToCreate);

        Hero heroDebater = new Hero();
        heroDebater.setHeroType(DEBATER);
        heroDebater.setName("Debater");
        heroDebater.setStrength(50);
        heroDebater.setExperience(0);
        heroDebater.setHealth(100);
        Hero heroDebaterToCreate = factory.create("Debater", DEBATER.name());
        assertEquals(heroDebater,heroDebaterToCreate);
    }


    @Before
    public void setUp()  {
        factory =(HeroFactory) FactoryProvider.getFactory(HERO);
    }

}
