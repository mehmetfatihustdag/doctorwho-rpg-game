package com.company.repository;

import com.company.entities.Hero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.company.constant.GameConstants.FILE_PATH;

/**
 *
 * @author fustdag <br>
 *         <b>File Operation Repository For Game</b>
 *
 */
public class GameRepository implements IGameRepository{

    String filePath ;
    
    public GameRepository(String filePath){
        this.filePath = filePath;
    }
    /**
     *
     * @author fustdag <br>
     *         <b>Save Game Method/b>
     * @param hero reference to be saved entity
     */
    @Override
    public void resumeGame(Hero hero) throws Exception  {
        try (FileOutputStream f = new FileOutputStream(new File(filePath));
             ObjectOutputStream o = new ObjectOutputStream(f)){
             o.writeObject(hero);
             System.out.println("The game has been saved! \n");
        }
    }

    /**
     *
     * @author fustdag <br>
     *         <b>Save Game Method/b>
     * @return  hero from file
     */
    @Override
    public Hero loadGame() throws Exception{
        Hero hero =null;
        try(FileInputStream fi = new FileInputStream(new File(filePath));
            ObjectInputStream oi = new ObjectInputStream(fi)) {
            while(true) {

                try {
                    hero =(Hero) oi.readObject();
                    System.out.println("Reading from file: " + hero);
                }
                catch (EOFException ex1) {
                    break; //EOF reached.
                }
                catch (IOException ex2) {
                }
            }
        }
        return hero;
    }

}
