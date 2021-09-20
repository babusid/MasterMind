package assignment2;

import java.text.Format;
import java.util.ArrayList;

//this object does the secret code evaluation and feedback generation
//also holds the history of all the guesses that are passed into it
public class Computer {
    private final FormattedGuess answer; //the response that is completely correct
    private final ArrayList<String> evalGuesses = new ArrayList<>(); //all the guesses after they've been evaluated

    public Computer(String code){
        this.answer = new FormattedGuess(code.length(),0,code);
    }

    public boolean guessEvaluate(String guess){ //make it return a boolean on whether they have gotten it right.
        if(guess.equals("HISTORY")){
            //run the history routine
            System.out.println("history command");
            System.out.println(evalGuesses);
            return false;
        }else if(guess.equals("TRUECOM")){
            return true;
        }
        System.out.println("not history command");
        evalGuesses.add(guess);
        return false;
    }

}

class FormattedGuess extends Response{
    public String guess;
    public FormattedGuess(int b, int w, String userGuess){
        super(b,w);
        this.guess = userGuess;
    }

    //generate String
    public String feedbackStringGenerate(){
        return (guess + " -> "+b+"b_"+w+"w");
    }
}