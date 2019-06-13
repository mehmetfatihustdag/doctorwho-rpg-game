package com.company.services;

import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
/**
 *
 * @author fustdag <br>
 *         <b>Interface of the Hero Service</b>
 */
public interface IHeroService {
    Hero createHero(String name, HeroPersonality heroType);
    Hero loadHero();
    void saveGame(Hero hero);
    Hero explore(Hero hero);

}
