package com.company.entities;

/**
 *
 * @author fustdag <br>
 *         <b>Alien Entity class</b>
 *
 */
public class Alien extends Character  {

    private AlienRace alienRace;
    private Integer attack;

    public Alien() {

    }

    public AlienRace getAlienRace() {
        return alienRace;
    }

    public void setAlienRace(AlienRace monsterRace) {
        this.alienRace = monsterRace;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienRace=" + alienRace +
                ", attack=" + attack +
                "} " + super.toString();
    }
}
