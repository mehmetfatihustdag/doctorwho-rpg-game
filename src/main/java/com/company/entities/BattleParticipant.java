package com.company.entities;

/**
 *
 * @author fustdag <br>
 *         <b>Pattle Participant Interface</b>
 *
 */
interface BattleParticipant {


    /**
     *
     * Receive Attack from enemy
     *@param amountOfDamage reference to damage hit from the enemy
     *
     */

    void receiveAttack(int amountOfDamage);

    /**
     *
     * Check participant is alive or not
     *@return boolean
     *
     */
    boolean isAlive();

    /**
     *
     * Regenerate action of battle participant
     *
     */
    void regenerate();

    /**
     *
     * Check Whether Regeneration Possible or Not
     *@return boolean
     */
    boolean isRegenerationPossible();
}
