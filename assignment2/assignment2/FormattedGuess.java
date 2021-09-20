package assignment2;

public class FormattedGuess extends Response {
    public String guess;

    public FormattedGuess(int b, int w, String userGuess) {
        super(b, w);
        this.guess = userGuess;
    }

    @Override
    public String toString(){
        return (guess + " -> " + b + "b_" + w + "w");
    }

    public int length(){return guess.length();}
}
