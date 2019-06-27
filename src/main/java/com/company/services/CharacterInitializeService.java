package com.company.services;


import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.util.CommonUtil;
import com.company.util.scanner.Input;

import java.util.Arrays;
import java.util.Objects;

import static com.company.constant.GameConstants.ASK_LOAD_GAME;
import static com.company.constant.GameConstants.ASK_NAME;
import static com.company.constant.GameConstants.ASK_PERSONALITY;
import static com.company.constant.GameConstants.QUIT;
import static com.company.util.SceneUtil.exitToGame;

public class CharacterInitializeService implements ICharacterInitializeService {
    private Input input;
    private IHeroService heroService;

    public CharacterInitializeService(Input input, IHeroService heroService){
        this.input = input;
        this.heroService = heroService;
    }

    /**
     * <b> Load or Create Character (Hero)</b>
     * @return refer to created character
     *
     */
    public Hero handleCharacter(){
        Hero hero = null;
        while (hero==null) {
            String userInput =input.getString(ASK_LOAD_GAME);
            if(QUIT.equalsIgnoreCase(userInput)){
                exitToGame();
            }
            while(!Arrays.asList("y","n","Y","N").contains(userInput)){
                userInput = input.getString("Please type 'y'or 'n' or 'Y' or 'N'");
            }
            switch (userInput.toUpperCase()) {
                case "Y":
                    hero = loadHeroAction();
                    if(hero !=null)
                        System.out.println("Loaded Hero is : " + hero.toString());
                    break;
                case "N":
                    hero = createHeroAction();
                    break;
                default:
                    break;
            }
        }
        return hero;
    }

    /**
     * <b>Load Hero action</b>
     * @return Loaded Hero
     *
     */
    private Hero loadHeroAction(){
        return heroService.loadHero();
    }

    /**
     * <b>Create Hero action</b>
     * @return Created Hero
     *
     */
    private Hero createHeroAction()  {
        System.out.println("Please, let's create the Next Doctor Who...");
        String name = "";
        HeroPersonality heroPersonality ;
        while (true) {
            if (CommonUtil.isEmpty(name)) {
                name = input.getString(ASK_NAME);
                if (!CommonUtil.validateInput(name)) {
                    name = null;
                    continue;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.lineSeparator());
            sb.append(name).append(" ");
            sb.append(ASK_PERSONALITY);
            sb.append(System.lineSeparator());
            for(HeroPersonality personality: HeroPersonality.values()) {

                sb.append(personality.getValue()).append(" - ").append(personality.getDescription());
                sb.append(System.lineSeparator());
            }
            sb.append("> ");
            String personality = this.input.getString(sb.toString());
            if (CommonUtil.validateInput(personality)) {
                HeroPersonality chosenPersonality = validatePersonality(personality);
                if (!Objects.isNull(chosenPersonality)) {
                    heroPersonality = chosenPersonality;
                    break;
                }
            }
        }
        return heroService.createHero(name,heroPersonality);
    }

    /**
     *  validatePersonality Function
     * @return HeroPersonality
     * @param  personality refers enum string of hero personality
     *
     */
    private HeroPersonality validatePersonality(String personality) {
        if (HeroPersonality.ANGRY.getValue().toString().equals(personality)) {
            return HeroPersonality.ANGRY;
        } else if (HeroPersonality.COMMANDER.getValue().toString().equals(personality)) {
            return HeroPersonality.COMMANDER;
        } else if (HeroPersonality.DEBATER.getValue().toString().equals(personality)) {
            return HeroPersonality.DEBATER;
        } else {
            System.out.println("Invalid Information!");
            return null;
        }

    }








}
