package com.company.entities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.constant.GameConstants.REGENERATION_EXPERIENCE_THRESHOLD;

/**
 *
 * @author fustdag <br>
 *         <b>Hero entity class</b>
 *
 */
public class Hero extends Character implements BattleParticipant {

    private HeroPersonality heroType;
    private Integer experience;
    private List<Item> items = Arrays.stream(Item.values()).collect(Collectors.toList());

    public Hero(){

    }

    public HeroPersonality getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroPersonality heroType) {
        this.heroType = heroType;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "heroType=" + heroType +
                ", experience=" + experience +
                ", items=" + items +
                "} " + super.toString();
    }

    @Override
    public void receiveAttack(int amountOfDamage) {
        if (amountOfDamage > 0 && isAlive()) {
            Integer newHealthPoint = getHealth() - amountOfDamage;
            this.setHealth(newHealthPoint);

        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }


    @Override
    public void regenerate() {
                this.setExperience(0);
                this.setHealth(100);

        }

    @Override
    public boolean isRegenerationPossible(){
        return getExperience()>REGENERATION_EXPERIENCE_THRESHOLD;
    }

}
