package assignment2;

import java.util.Scanner;

//This class is meant to be the Game environment
//It will function as the "arena" for the player and computer classes
public class Game {
    private final boolean test;
    private final SecretCodeGenerator gen;
    private final GameConfiguration config;

    private final Scanner scan; //scanner object
    public boolean playAgain; //boolean controlling repeated playing
    private final Player player; //player object
    private Computer computer; //computer object
    private String code; //the code we pass to the computer
    private Integer guesses; //how many guesses the player gets

    //constructor
    public Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator generator){
        //game constructor
        this.test = isTesting;
        this.gen = generator;
        this.config = config;

        this.scan = new Scanner(System.in);
        this.playAgain = true;
        this.player = new Player(this.scan);
        this.code = this.gen.getNewSecretCode();
        this.computer = new Computer(this.code);
        this.guesses = this.config.guessNumber;
    }

    //main game logic here
    public void runGame(){
        if (this.test) {
            //print the testing stuff
            System.out.println("testing mode");
        }

    //DEBUG
        System.out.println("debug run game");
        System.out.println("Testing:"+this.test);
        System.out.println("Code: "+this.code);
        this.gen.printConfig();
    //END DEBUG




        while(this.guesses>0){
            String guess = player.Guess();

            //History command shouldn't affect guess total
            if(guess.equals("HISTORY")){
                this.guesses++;
            }

            //evaluate all valid guesses that come in, if we get a true (correct response) break loop
            if(computer.guessEvaluate(guess)){
                break;
            }
            //deduct guesses
            guesses--;
            System.out.println("You have "+guesses+" guess(es) left.");
        }
        if(this.guesses>0){
            //Win case
            System.out.println("You win!");
        }
        //Loss case
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
                this.guesses = this.config.guessNumber;
                this.computer = new Computer(this.gen.getNewSecretCode());
                invalid = false;
            } else {
                this.playAgain = false;
                invalid = false;
            }
        }
    }
}
