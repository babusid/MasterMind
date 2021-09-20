/*
 * Mastermind
 * Jun 14, 2021
 */

package assignment2;


public class Driver {
    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.
        GameConfiguration conf = new GameConfiguration(10,new String[]{"Y","R","G","B"},5);
        SecretCodeGenerator gen = new SecretCodeGenerator(conf);
        Boolean test = Boolean.TRUE;
        start(test,conf,gen);
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        // TODO: complete this method
		// We will call this method from our JUnit test cases.

        Game currentGame = new Game(isTesting,config,generator);
        while(currentGame.playAgain) {
            currentGame.runGame();
            currentGame.playAgain();
        }
    }
}
