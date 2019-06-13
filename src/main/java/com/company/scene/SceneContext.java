package com.company.scene;

import com.company.entities.AlienRace;
import com.company.entities.Hero;
import com.company.util.CommonUtil;

import static com.company.util.SceneUtil.exitToGame;
import static com.company.util.SceneUtil.gameOver;
import static com.company.util.SceneUtil.isMissionCompleted;

/**
 *
 * @author fustdag <br>
 *         <b>Strategy Pattern Context For Scene</b></b>
 */

public class SceneContext {
    private final Scene scene;
    private final AlienRace alienRace;
    private final Integer experiencePoint;

    public SceneContext(Scene scene, AlienRace
            alienRace,Integer experiencePoint){
        this.scene = scene;
        this.alienRace = alienRace;
        this.experiencePoint = experiencePoint;
    }

    /**
     *
     * <b>Hero explore the game</b>
     * @param hero Hero to explore the scene
     * @return refers to Hero which is updated Hero entity after explore action
     */
    public Hero explore(Hero hero) {
        while (true) {
            CommonUtil.load();
            System.out.println("Aliens Attack Start");
            Integer damageHit = scene.alienAttack(alienRace);
            boolean isMysterySolved = scene.solveMystery();
            if (isMysterySolved) {
                hero = scene.improveExperience(hero,experiencePoint);
                if(isMissionCompleted(hero)){
                    exitToGame();
                }
                break;
            }else {
                CommonUtil.load();
                System.out.println("Wrong answer");
                hero.receiveAttack(damageHit);
                if(!hero.isAlive()) {
                    CommonUtil.loadStory();
                    System.out.println("Doctor, you are dying !!!. Let's check whether the regeneration is possible !!!");
                    CommonUtil.loadStory();
                    if (hero.isRegenerationPossible()) {
                        System.out.println("Regeneration started");
                        hero.regenerate();
                    } else {
                        System.out.println("Regeneration is not possible" );
                        gameOver();
                    }
                }
            }
        }
        return hero;
    }




}
