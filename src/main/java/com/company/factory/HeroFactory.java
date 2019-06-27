package com.company.factory;

import com.company.entities.Hero;
import com.company.entities.HeroPersonality;

import static com.company.constant.GameConstants.ANGRY_HERO_STRENGTH;
import static com.company.constant.GameConstants.COMMANDER_HERO_STRENGTH;
import static com.company.constant.GameConstants.DEBATER_HERO_STRENGTH;
import static com.company.constant.GameConstants.HERO_EXPERIENCE;
import static com.company.constant.GameConstants.HERO_HEALTH;

/**
 *
 * @author fustdag <br>
 *         <b>Hero Create Factory</b>
 *
 */
public class HeroFactory implements AbstractFactory<Hero>{


    /**
     *  <b>Hero create method</b>
     * @param name name of the character to create
     * @param type enum type of the character to create
     * @return Alien
     */
    @Override
    public Hero create(String name, String type) {
        Hero hero = new Hero();
        hero.setName(name);
        HeroPersonality heroPersonality = HeroPersonality.valueOf(type);
        hero.setHeroType(heroPersonality);
        setAttributes(hero);
        return hero;
    }

    /**
     *  <b>Set Attributes of Hero entity</b>
     * @param hero parameter refer to Hero type
     *
     *
     */
    private void setAttributes(Hero hero) {
        if (hero.getHeroType().compareTo(HeroPersonality.ANGRY) == 0) {
            hero.setStrength(ANGRY_HERO_STRENGTH);
        }else if (hero.getHeroType().compareTo(HeroPersonality.COMMANDER) == 0)  {
            hero.setStrength(COMMANDER_HERO_STRENGTH);
        }else if (hero.getHeroType().compareTo(HeroPersonality.DEBATER) == 0) {
            hero.setStrength(DEBATER_HERO_STRENGTH);
        }
            hero.setHealth(HERO_HEALTH);
            hero.setExperience(HERO_EXPERIENCE);
    }

}
