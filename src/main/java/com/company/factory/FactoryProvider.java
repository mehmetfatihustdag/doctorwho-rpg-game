package com.company.factory;

import com.company.entities.CharacterType;

/**
 *
 * @author fustdag <br>
 *         <b>Factory Prociveder Class For Factories which extends from Abstract Factory</b>
 *
 */
public class FactoryProvider {

    /**
     *
     *
     * <b>Factory Provider method For Factories which extends from Abstract Factory</b>
     * @param characterType refer to type of factory
     */
    public static AbstractFactory getFactory(CharacterType characterType){
        switch (characterType){
            case HERO: return new HeroFactory();
            case ALIEN: return new AlienFactory();
            default: return null;
        }
    }
}
