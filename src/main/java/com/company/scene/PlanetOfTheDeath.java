package com.company.scene;

import com.company.entities.Alien;
import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.entities.Item;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constant.GameConstants.ANSWER_OF_DEATHPLANET;
import static com.company.constant.GameConstants.MYSTERY_OF_DEATHPLANET;

/**
 *
 * @author fustdag <br>
 *         <b>Refer to PlanetOfTheDeath Scene</b>
 */
public class PlanetOfTheDeath implements Scene {

    public PlanetOfTheDeath(){
        System.out.println();
        System.out.println("-----------------------------------Story Of the Planet Of the Death---------------------------------------------");
        System.out.println();
        System.out.println("When a London bus takes a detour to an alien world, the Tenth Doctor must join forces with the extraordinary Lady Christina. But the mysterious planet holds terrifying secrets and time is running out as the deadly Swarm gets closer...");
        System.out.println();
        System.out.println();

    }
    /**
     *
     * @author fustdag <br>
     *         <b>Solve Mystery</b>
     * @return boolean
     */
    @Override
    public boolean solveMystery() {
        System.out.println("Hey Doctor, Let's destroy some dalek");
        System.out.println("Ready !!! ");
        String answer = input.getString(MYSTERY_OF_DEATHPLANET);
        return answer.equalsIgnoreCase(ANSWER_OF_DEATHPLANET);
    }
    /**
     *
     * @author fustdag <br>
     *         <b>Improve Experience</b>
     * @return Hero
     */
    @Override
    public Hero improveExperience(Hero hero,Integer hitPoint) {
        Hero updatedHero = Scene.super.improveExperience(hero,hitPoint);
        List<Item> updatedItems = hero.getItems().stream().filter(item-> !item.name().equals(Item.KEY_OF_PLANETOFDEATH.name())).collect(Collectors.toList());
        updatedHero.setItems(updatedItems);
        return updatedHero;
    }
    /**
     *
     * @author fustdag <br>
     *         <b>Alien attack/b>
     * @return Integer which refers to damagePoint Hit from enemy
     */
    @Override
    public Integer alienAttack(AlienRace alienRace) {
        Alien alien = createAlien("HAGI", alienRace.name());
        System.out.println(alien.getAlienRace().name() + " is attacked");
        return alien.getAttack();
    }


}
