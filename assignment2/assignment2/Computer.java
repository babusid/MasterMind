package assignment2;


import java.util.ArrayList;
import java.lang.Character;

//this object does the secret code evaluation and feedback generation
//also holds the history of all the guesses that are passed into it
public class Computer {
    private final FormattedGuess answer; //the response that is completely correct
    private final ArrayList<FormattedGuess> evalGuesses = new ArrayList<>(); //all the guesses after they've been evaluated
    private final GameConfiguration config;
    public Computer(String code, GameConfiguration config){
        this.answer = new FormattedGuess(code.length(),0,code);
        this.config = config;
    }

    //false if wrong answer, true if correct answer
    public boolean guessEvaluate(String guess){
        if(guess.equals("HISTORY")){
            for (FormattedGuess evalGuess : evalGuesses) {
                System.out.println(evalGuess);
            }
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
        System.out.println(UserGuess);
        evalGuesses.add(UserGuess);
        return UserGuess.equals(answer);
    }

    //valid guess evaluation
    public boolean validGuess(String guess){
        if(guess.equals("HISTORY")){
            return true;
        }
        String possibleColors = convertStringArray(config.colors);
        if(guess.length()!=answer.length()){ //wrong length
            return false;
        }
        for(int i = 0;i<guess.length();i++){
            if(!Character.isLetter(guess.charAt(i))){
                return false;
            }
            if(!Character.isUpperCase(guess.charAt(i))){ //lowercase
                return false;
            }
            if(possibleColors.indexOf(guess.charAt(i))==-1){ //some color is not in the given color array
                return false;
            }
        }
        return true;
    }

    public FormattedGuess getAnswer(){
        return this.answer;
    }

    private String convertStringArray(String[] array){
        StringBuilder retVal = new StringBuilder();
        for (String s : array) {
            retVal.append(s);
        }
        return retVal.toString();
    }

}

