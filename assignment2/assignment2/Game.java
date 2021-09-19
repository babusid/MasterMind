package assignment2;

import java.util.Scanner;

//This class is meant to be the Game environment
//It will function as the "arena" for the player and computer classes
public class Game {
    private final boolean test;
    private final GameConfiguration conf;
    private final SecretCodeGenerator gen;

    private final Scanner scan;
    private String code;
    public boolean playAgain;


    //constructor
    public Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator generator){
        //game constructor
        this.test = isTesting;
        this.conf = config; //may not be needed, will delete if that's the case

        this.scan = new Scanner(System.in);
        this.playAgain = true;
        this.gen = generator;
        this.code = this.gen.getNewSecretCode();
    }

    //main game logic here
    public void runGame(){
        if (this.test) {
            //print the testing stuff
            System.out.println("testing mode");
        }
     //main logic
        System.out.println("debug run game");
        System.out.println("Testing:"+this.test);
        System.out.println(conf);
        System.out.println("code:"+this.code);


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
                this.code = this.gen.getNewSecretCode();
                invalid = false;
            } else {
                this.playAgain = false;
                invalid = false;
            }
        }
    }
}
