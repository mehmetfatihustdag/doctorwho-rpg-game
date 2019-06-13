package com.company.entities;

/**
 *
 * @author fustdag <br>
 *         <b>Hero Personality Enums</b>
 *
 */
public enum HeroPersonality {

    ANGRY(1,"Angry"),
    COMMANDER(2,"Commander"),
    DEBATER(3,"Debater");

    private final Integer value;
    private final String description;

    HeroPersonality(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }

}
