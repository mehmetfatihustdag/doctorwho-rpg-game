package com.company.factory;

import com.company.constant.GameConstants;

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
     * @param choice refer to type of factory
     */
    public static AbstractFactory getFactory(String choice){
        if(GameConstants.HERO.equalsIgnoreCase(choice)){
            return new HeroFactory();
        }
        else if(GameConstants.ALIEN.equalsIgnoreCase(choice)){
            return new AlienFactory();
        }
        return null;
    }
}
