package assignment2;

import java.text.Format;
import java.util.ArrayList;

//this object does the secret code evaluation and feedback generation
//also holds the history of all the guesses that are passed into it
public class Computer {
    private final FormattedGuess answer; //the response that is completely correct
    private final ArrayList<FormattedGuess> evalGuesses = new ArrayList<>(); //all the guesses after they've been evaluated

    public Computer(String code){
        this.answer = new FormattedGuess(code.length(),0,code);
    }

    //false if wrong answer, true if correct answer
    public boolean guessEvaluate(String guess){
        if(guess.equals("HISTORY")){
            System.out.println("history command");
            System.out.println(evalGuesses);
            return false;
        }

        //colored peg generation
        int b=0;
        int w=0;
        StringBuilder codeCopy = new StringBuilder(answer.guess);
        StringBuilder guessCopy = new StringBuilder(guess);
        for(int i = 0;i<codeCopy.length();i++){
            if(codeCopy.charAt(i)==guessCopy.charAt(i)) {
                b++;
                codeCopy.deleteCharAt(i);
                guessCopy.deleteCharAt(i);
                i--;
            }
        }
        for(int i = 0;i<codeCopy.length();i++){
            for(int j = 0;j<codeCopy.length();j++){
                if(codeCopy.charAt(i)==guessCopy.charAt(j)){
                    w++;
                    codeCopy.deleteCharAt(i);
                    guessCopy.deleteCharAt(j);
                    i--;
                    break;
                }
            }
        }


        FormattedGuess UserGuess = new FormattedGuess(b,w,guess);
        evalGuesses.add(UserGuess);
        if(UserGuess.equals(answer)){
            return true;
        }
        return false;
    }
}

