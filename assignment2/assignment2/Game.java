package assignment2;

public class Game {
    private boolean test;

    public Game(boolean isTesting){
        //game constructor
        this.test = isTesting;
    }
    public void runGame(){
        if(!this.test){
            runner(); //non-test = just run the game
        } else {
            //print the testing stuff
            System.out.println("testingmode");
            runner();
        }
    }
    private void runner(){
        return;
    }
}
