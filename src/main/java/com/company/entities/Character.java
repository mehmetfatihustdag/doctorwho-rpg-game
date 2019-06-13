package com.company.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fustdag <br>
 *         <b> Character Class having character details </b>
 *
 *
 */
abstract  class Character implements Serializable {

    private static final long serialVersionUID = 2932263705495960407L;
    private String name;
    private Integer health;
    private Integer strength;


    Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getHealth() {
        return health;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     * Character Equals on the basis of name
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Character) {
                Character obChar = (Character) obj;
                return this.getName().equals(obChar.getName());
            } else
                return false;
        } else
            return false;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }


    /**
     * toString() method of Character class
     */
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                '}';
    }
}
