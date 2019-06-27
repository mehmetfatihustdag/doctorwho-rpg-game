package com.company.main;

import com.company.command.Action;
import com.company.command.TypeAction;
import com.company.entities.Hero;
import com.company.repository.GameRepository;
import com.company.services.CharacterInitializeService;
import com.company.services.HeroService;
import com.company.services.ICharacterInitializeService;
import com.company.services.IHeroService;
import com.company.util.CommonUtil;
import com.company.util.scanner.Input;
import static com.company.constant.GameConstants.ACTION_CHOSE;
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
    private final IHeroService heroService;
    private final Input input;
    private final ICharacterInitializeService characterInitializeService;

    public GamePlay() {
        this.input = Input.getInstance();
        this.heroService = new HeroService(new GameRepository(FILE_PATH));
        this.characterInitializeService = new CharacterInitializeService(input,heroService);
    }

    /**
     * Starting point of the game
     *
     *
     */
    public void startGame(){
        Hero hero = characterInitializeService.handleCharacter();
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
                     heroService.saveGame(hero);
                     exitToGame();
                    break;
                case EXPLORE:
                     heroService.explore(hero);
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
