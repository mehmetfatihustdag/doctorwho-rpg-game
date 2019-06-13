# Dr. Who RPG Game
Command Line RPG Game based on Dr.Who TV Series

# Installing & Running from source

A step by step series how to install the game
```
git clone https://github.com/mehmetfatihustdag/doctorwho-rpg-game
cd {project directory}
mvn install -DskipTests
cd target/classes
java com.company.main.Main


# Installing & Running from jar
cd target
java -jar gamechallenge-1.0.jar

```
# Running the tests
```
mvn test
```
# How to Play Game (Possible Scenarios)

CREATE USER
Hero creation, loading part
Wait for the story of the game 
After if you have hero , you can load
If you don't have , you can create


EXPLORE SCENE

Game consits of 3 sceneario , Bad Wolf, The Pandorica, and DeathPlanet .
These scenarios are inspired from the episodes of the Dr.Who.

Doctor who has mission to save the universe. However, he has to pass the stages by solving the mysterious question . 
If he can't solve , aliens will attack on him. 
Scenarios : 

1. If he solve the mystery (answering the correct answer to mystery) , he will increase the experience point.
2. If he can't solve the mystery (answering the wrong answer to mystery), he will loose the health point.(Alien attack)
3. If his health point less than zero, death process will start . 
4. If he has enough experience , he can be regenarated in the death process, otherwise he will die.
5. If he solve all the mysteries, he will reach the mission. 


SAVE GAME 

He can save and quit the game. User can continue the previous session of the game by reloading the hero


QUIT GAME
He can quit the game by typing the quit


ANSWERS OF QUESTIONS  : 
   1. What is it that goes up, but never comes down?" (AGE)
   2. Where pandorica is hidden ? (STONHENGE)
   3. Who discovered the Black Hole ? (KARL)

# Built With


- Java 8 - Primary Language
- Maven - Dependency Management
- JUnit 1.4, System-Rules 1.18 - Unit Tests
- Intellij Test Covarage Report -- Measuring Test Covarage :https://www.jetbrains.com/help/idea/viewing-code-coverage-results.html
Note : Application has %80 percent of line covarage, %92 percent of class covarage ,and %87 percent of method covarage

# Authors

Fatih Ustdag - fatihustdag@gmail.com


# Inspiration

Doctor Who chronicled the adventures of an eccentric time-traveling scientist from the remote planet Gallifrey, home of the Time Lords. 
The Doctor, a Time Lord himself, traveled through time and space in his unique craft, the TARDIS, an acronym for Time and Relative Dimensions in Space. 
With an interior larger than its exterior, the TARDIS could take on various shapes to blend into its environment. 
Although capable of whisking the Doctor and his passengers to any time and any place in the universe, the craft was frequently parked on Earth in the form of a blue police box. 
Whether in England or in the far reaches of space, the Doctor and his colleagues battled a multitude of evils, including robots, monsters, and a twisted Time Lord. 
Certain adversaries recurred throughout the series, notably the Daleks, genocidal aliens armoured in robotlike suits who sought the extermination of life-forms inferior to themselves.


# Reference

 https://www.britannica.com/topic/Doctor-Who