package assignment2;

import java.util.Scanner;
public class Game {
    private boolean test;
    private GameConfiguration conf;
    private SecretCodeGenerator gen;
    private Scanner scan;
    public boolean playAgain;

    //constructor
    public Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator generator){
        //game constructor
        this.test = isTesting;
        this.conf = config;
        this.gen = generator;
        scan = new Scanner(System.in);
        this.playAgain = true;
    }

    //main game logic here
    public void runGame(){
        if (this.test) {
            //print the testing stuff
            System.out.println("testingmode");
        }
     //main logic
    }

    //prompt user to play the game again and return the boolean whether they want to
    public void playAgain(){
        boolean invalid = true;
        while(invalid) {
            System.out.println("Do you want to play a new game?(Y/N): ");
            char response = scan.next().charAt(0);
            if (response != 'Y' && response != 'N') {
                System.out.println("Please input either Y or N only.");
            } else if(response == 'Y') {
                this.playAgain = true;
                invalid = false;
            } else if(response == 'N'){
                this.playAgain = false;
                invalid = false;
            }
        }
    }
}
