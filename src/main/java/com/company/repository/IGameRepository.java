package com.company.repository;

import com.company.entities.Hero;

/**
 *
 * @author fustdag <br>
 *         <b>File Operation Interface for service For Game</b>
 *
 */
public interface IGameRepository {

     void resumeGame(Hero hero) throws Exception;
     Hero loadGame() throws Exception;
}
