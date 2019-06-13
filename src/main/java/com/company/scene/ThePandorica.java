package com.company.scene;

import com.company.entities.Alien;
import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.entities.Item;
import com.company.util.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constant.GameConstants.ANSWER_OF_PANDORICA;
import static com.company.constant.GameConstants.MYSTERY_OF_PANDORICA;

/**
 *
 * @author fustdag <br>
 *         <b>Refer to ThePandorica Scene</b>
 */
public class ThePandorica implements Scene {

    public ThePandorica(){
        System.out.println();
        System.out.println("-----------------------------------Story Of the Pandorica---------------------------------------------");
        System.out.println();
        System.out.println("Come on, look at me! No plan, no backup, no weapons worth a damn, oh, and something else I don't have: anything to lose! ");
        CommonUtil.loadStory();
        System.out.println("So, if you're sitting up there in your silly little space ships with all your silly little guns, and you've got any plans on taking the Pandorica tonight, just remember who's standing in your way! ");
        CommonUtil.loadStory();
        System.out.println("/nRemember every black day I ever stopped you, and then, *and then*, do the smart thing! \n");
        CommonUtil.load();
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
        System.out.println("Hey Doctor, Let's save Pandorica from Aliens");
        System.out.println("Ready !!! ");
        String answer = input.getString(MYSTERY_OF_PANDORICA);
        return answer.equalsIgnoreCase(ANSWER_OF_PANDORICA);
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
        List<Item> updatedItems = hero.getItems().stream().filter(item-> !item.name().equals(Item.KEY_OF_PANDORICA.name())).collect(Collectors.toList());
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
        Alien alien = createAlien("FIGO", alienRace.name());
        System.out.println(alien.getAlienRace().name() + " is attacked");
        return alien.getAttack();
    }
}
