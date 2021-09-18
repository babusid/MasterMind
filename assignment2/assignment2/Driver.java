/*
 * Mastermind
 * Jun 14, 2021
 */

package assignment2;

public class Driver {
    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        // TODO: complete this method
		// We will call this method from our JUnit test cases.

        //the current game being played
        Game currentGame = new Game(isTesting,config,generator);
        while(currentGame.playAgain) {
            currentGame.runGame(); //start the game
            //once the game finishes prompt if they want to playagain;
            currentGame.playAgain();
        }
    }
}
