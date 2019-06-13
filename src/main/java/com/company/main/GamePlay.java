package com.company.main;

import com.company.command.Action;
import com.company.command.TypeAction;
import com.company.entities.Hero;
import com.company.entities.HeroPersonality;
import com.company.repository.GameRepository;
import com.company.services.HeroService;
import com.company.services.IHeroService;
import com.company.util.CommonUtil;
import com.company.util.scanner.Input;
import java.util.Arrays;

import java.util.Objects;

import static com.company.constant.GameConstants.ACTION_CHOSE;
import static com.company.constant.GameConstants.ASK_LOAD_GAME;
import static com.company.constant.GameConstants.ASK_NAME;
import static com.company.constant.GameConstants.ASK_PERSONALITY;
import static com.company.constant.GameConstants.FILE_PATH;
import static com.company.constant.GameConstants.GAME_START;
import static com.company.constant.GameConstants.QUIT;
import static com.company.util.SceneUtil.exitToGame;

/**
 *
 * @author fustdag <br>
 *         <b>com.company.main.GamePlay  class is the com.company.main.Main Starting Class. Starts com.company.main.GamePlay
 *         Environment</b>
 */
public class GamePlay {

    private Hero hero;
    private final IHeroService heroService;
    private final Input input;

    public GamePlay() {
        this.input = Input.getInstance();
        this.heroService = new HeroService(new GameRepository(FILE_PATH));
        this.hero = handleCharacter();
    }


    /**
     * <b> Load or Create Character (Hero)</b>
     * @return refer to created character
     *
     */
    private Hero handleCharacter(){
      Hero hero = null;
      while (hero==null) {
          String userInput =input.getString(ASK_LOAD_GAME);
          if("quit".equalsIgnoreCase(userInput)){
              exitToGame();
          }
          while(!Arrays.asList("y","n","Y","N").contains(userInput)){
              userInput = input.getString("Please type 'y'or 'n' or 'Y' or 'N'");
          }
          switch (userInput) {
              case "y":
              case "Y":
                  hero = loadHeroAction();
                  if(hero !=null)
                      System.out.println("Loaded Hero is : " + hero.toString());
                  break;
              case "N":
              case "n":
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

    /**
     * Starting point of the game
     *
     *
     */
    public void startGame(){
        String userInput = "";
        while(!userInput.equalsIgnoreCase(QUIT) ) {
            StringBuilder startGame = new StringBuilder();
            CommonUtil.load();
            startGame.append(GAME_START);
            startGame.append(System.lineSeparator());
            startGame.append(ACTION_CHOSE);
            for(Action action : Action.values()){
                if(action.getTypeAction() != TypeAction.INVALID_ACTION) {
                    startGame.append(System.lineSeparator());
                    startGame.append(action.getValue()).append(" - ").append(action.getTypeAction());
                }
            }
            startGame.append("> ");
            userInput = input.getString(startGame.toString());
            TypeAction action = CommonUtil.interpretActionInput((userInput));
            switch(action) {
                case SAVE_AND_QUIT:
                     heroService.saveGame(this.hero);
                     exitToGame();
                    break;
                case EXPLORE:
                     this.hero = heroService.explore(this.hero);
                     break;
                case QUIT :
                    exitToGame();
                    break;
                default:
                     System.out.println("Invalid Action");
                     exitToGame();
                     break;
                }
            }
            System.out.println("The Game has been ended!!!");
        }

}
