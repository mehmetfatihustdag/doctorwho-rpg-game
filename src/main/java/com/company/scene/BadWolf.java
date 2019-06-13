package com.company.scene;

import com.company.entities.Alien;
import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.entities.Item;
import com.company.util.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constant.GameConstants.ANSWER_OF_BADWOLF;
import static com.company.constant.GameConstants.MYSTERY_OF_BADWOLF;

/**
 *
 * @author fustdag <br>
 *         <b>Refer to BadWolf Scene</b>
 */
public class BadWolf implements Scene {


    public BadWolf(){
        System.out.println();
        System.out.println("-----------------------------------Story Of the BadWolf---------------------------------------------");
        System.out.println();
        System.out.println(" I’m going to rescue her! I’m going to save Rose Tyler from the middle of the Dalek fleet, and then ");
        CommonUtil.loadStory();
        System.out.println("  I’m going to save the Earth, and then, just to finish off, I’m going to wipe every last stinking Dalek out of the sky! ");
        System.out.println();
        System.out.println();
        CommonUtil.load();
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
        String answer = input.getString(MYSTERY_OF_BADWOLF);
        return answer.equalsIgnoreCase(ANSWER_OF_BADWOLF);
    }

    /**
     *
     * @author fustdag <br>
     *         <b>Improve Experience</b>
     * @return Hero
     */
    @Override
    public Hero improveExperience(final Hero hero,Integer hitPoint) {
        Hero updatedHero = Scene.super.improveExperience(hero,hitPoint);
        List<Item> updatedItems = hero.getItems().stream().filter(item-> !item.name().equals(Item.KEY_OF_BADWOLF.name())).collect(Collectors.toList());
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
    public Integer alienAttack(final AlienRace alienRace) {
        Alien alien = createAlien("ALEX", alienRace.name());
        System.out.println(alien.getAlienRace().name() + " is attacked");
        return alien.getAttack();
    }
}
