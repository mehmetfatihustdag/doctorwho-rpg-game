package com.company.scene;

import com.company.entities.AlienRace;
import com.company.entities.CharacterType;
import com.company.entities.Hero;
import com.company.entities.Alien;
import com.company.factory.AbstractFactory;
import com.company.factory.FactoryProvider;
import com.company.util.scanner.Input;

import java.util.Objects;

/**
 *
 * @author fustdag <br>
 *         <b>Interface of the Scene</b>
 */
public interface Scene {
    Input input = Input.getInstance();

    boolean solveMystery();

    default Hero improveExperience(Hero hero, Integer hitPoint) {
        System.out.println("Experience increased with " + hitPoint + " points");
        Integer newExperience = hero.getExperience() + hitPoint;
        hero.setExperience(newExperience);
        return hero;
    }

    Integer alienAttack(AlienRace alienRace);

    default Alien createAlien(String name, String alienRace) {
        AbstractFactory abstractFactory = FactoryProvider.getFactory(CharacterType.ALIEN);
        return (Alien) Objects.requireNonNull(abstractFactory).create(name, alienRace);
    }

}
