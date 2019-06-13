package com.company.services;

import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.entities.Item;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import com.company.repository.IGameRepository;
import com.company.constant.GameConstants;
import com.company.scene.BadWolf;
import com.company.scene.PlanetOfTheDeath;
import com.company.scene.SceneContext;
import com.company.scene.ThePandorica;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author fustdag <br>
 *         <b>Implementation of the Hero Service</b>
 */

public class HeroService implements IHeroService {

    private final IGameRepository gameRepository;

    public HeroService(IGameRepository gameRepository){
       this.gameRepository = gameRepository;
    }

    /**
     *
     * @author fustdag <br>
     *         <b>Create Hero</b>
     * @return Hero
     * @param name : String
     * @param heroType : HeroPersonality Name
     */
    @Override
     public Hero createHero(String name, HeroPersonality heroType)  {
        HeroFactory heroFactory= (HeroFactory)FactoryProvider.getFactory(GameConstants.HERO);
        return heroFactory.create(name,heroType.name());
    }
    /**
     *
     * @author fustdag <br>
     *         <b>Solve Mystery</b>
     * @return boolean
     */
    @Override
    public Hero loadHero(){
        try {
            return gameRepository.loadGame();
        } catch (Exception e) {
            System.out.println("Doctor could not be loaded");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     *
     * @author fustdag <br>
     *         <b>Solve Mystery</b>
     * @param hero: Refer to Hero
     */
    @Override
    public void saveGame(Hero hero) {
        try {
            gameRepository.resumeGame(hero);
        } catch (Exception e) {
            System.out.print("Game can not be resumed!!!");
        }
    }


    /**
     *
     * @author fustdag <br>
     *         <b>Explore Service</b>
     * @param  hero refers to Hero
     * @return  return is Hero
     */
    @Override
    public Hero explore(Hero hero) {
        SceneContext sceneContext = null;
        List<Item> listItemKey = hero.getItems().stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (listItemKey.contains(Item.KEY_OF_BADWOLF)) {
            sceneContext = new SceneContext(new BadWolf(), AlienRace.DALEK,GameConstants.BADWOLD_EXPERIENCE_HIT);
        }else if (listItemKey.contains(Item.KEY_OF_PANDORICA)) {
            sceneContext = new SceneContext(new ThePandorica(),AlienRace.CYBERMEN,GameConstants.PANDORICA_EXPERIENCE_HIT);
        }else if  (listItemKey.contains(Item.KEY_OF_PLANETOFDEATH)){
            sceneContext = new SceneContext(new PlanetOfTheDeath(),AlienRace.DEMON, GameConstants.DEATH_PLANET_EXPERIENCE_HIT);
        }
        if (sceneContext != null) {
            hero =sceneContext.explore(hero);
        }
        System.out.println("Hero information :  " + hero.toString());
        return hero;
    }


}
