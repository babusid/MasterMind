package assignment2;
import java.util.Scanner;

//This class will be the home of the players actions
public class Player {
    private final Scanner scan;
    public Player(Scanner scanner){
        this.scan = scanner;
    }
    public String Guess(){
        System.out.println("Enter Guess:");
        return scan.next();
    }

}
