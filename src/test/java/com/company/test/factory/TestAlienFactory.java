package com.company.test.factory;

import com.company.constant.GameConstants;
import com.company.entities.Alien;
import com.company.entities.AlienRace;
import com.company.factory.AlienFactory;
import com.company.factory.FactoryProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author fustdag <br>
 *         <b>Test Alien Factory Class</b>
 */
public class TestAlienFactory {

    AlienFactory factory;

    @Test
    public void testAlienCreateFactory() {
        Alien alien = new Alien();
        alien.setName("Dalek");
        alien.setAlienRace(AlienRace.DALEK);
        Alien alienToCreate = factory.create("Dalek",AlienRace.DALEK.name());
        assertEquals(alien,alienToCreate);
    }


    @Test
    public void testAlienSetAttributesForDalek() {
        Alien alienDalek = new Alien();
        alienDalek.setAlienRace(AlienRace.DALEK);
        alienDalek.setName("Dalek");
        alienDalek.setStrength(40);
        alienDalek.setAttack(25);
        alienDalek.setHealth(100);
        Alien alienToCreate = factory.create("Dalek",AlienRace.DALEK.name());
        assertEquals(alienDalek,alienToCreate);

        Alien alienCyberMan = new Alien();
        alienCyberMan.setAlienRace(AlienRace.CYBERMEN);
        alienCyberMan.setName("Cyberman");
        alienCyberMan.setStrength(90);
        alienCyberMan.setAttack(30);
        alienCyberMan.setHealth(100);
        Alien alienCyberManToCreate = factory.create("Cyberman",AlienRace.CYBERMEN.name());
        assertEquals(alienCyberMan,alienCyberManToCreate);


        Alien alienDemon = new Alien();
        alienDemon.setAlienRace(AlienRace.DEMON);
        alienDemon.setName("Demon");
        alienDemon.setStrength(90);
        alienDemon.setAttack(40);
        alienDemon.setHealth(100);
        Alien alienDemonToCreate = factory.create("Demon",AlienRace.DEMON.name());
        assertEquals(alienDemon,alienDemonToCreate);
    }



    @Before
    public void setUp()  {
        factory =(AlienFactory) FactoryProvider.getFactory(GameConstants.ALIEN);
    }
}
