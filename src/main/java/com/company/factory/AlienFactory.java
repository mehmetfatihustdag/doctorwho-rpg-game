package com.company.factory;

import com.company.entities.Alien;
import com.company.entities.AlienRace;

import static com.company.constant.GameConstants.ALIEN_HEALTH;
import static com.company.constant.GameConstants.CYBERMAN_ATTACK;
import static com.company.constant.GameConstants.CYBERMAN_STRENGTH;
import static com.company.constant.GameConstants.DALEK_ATTACK;
import static com.company.constant.GameConstants.DALEK_STRENGTH;
import static com.company.constant.GameConstants.DEMON_ATTACK;
import static com.company.constant.GameConstants.DEMON_STRENGTH;

/**
 *
 * @author fustdag <br>
 *         <b>Alien Create Factory</b>
 *
 */
public class AlienFactory implements AbstractFactory<Alien> {


    /**
     *  <b>Hero create method</b>
     * @param name name of the character to create
     * @param type enum type of the character to create
     * @return Alien
     *
     */
    @Override
    public Alien create(String name,String type) {
        Alien alien = new Alien();
        AlienRace alienRace = AlienRace.valueOf(type);
        alien.setAlienRace(alienRace);
        alien.setName(name);
        setAttributes(alien);
        return alien;
    }

    /**
     *  <b>Set Attributes of Alien entity</b>
     * @param alien parameter refer to Alien type
     *
     *
     */
    private void setAttributes(Alien alien) {
        if (alien.getAlienRace().compareTo(AlienRace.DALEK) == 0) {
            alien.setStrength(DALEK_STRENGTH);
            alien.setAttack(DALEK_ATTACK);
        }else if (alien.getAlienRace().compareTo(AlienRace.CYBERMEN) == 0)  {
            alien.setStrength(CYBERMAN_STRENGTH);
            alien.setAttack(CYBERMAN_ATTACK);

        }else if (alien.getAlienRace().compareTo(AlienRace.DEMON) == 0) {
            alien.setStrength(DEMON_STRENGTH);
            alien.setAttack(DEMON_ATTACK);
        }
        alien.setHealth(ALIEN_HEALTH);
    }

}
