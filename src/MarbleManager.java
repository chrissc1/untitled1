import java.util.Random;

public class MarbleManager {
    private int actualMarbles;
    private boolean hasGuessedCorrectly;

    public MarbleManager() {
        Random random = new Random();
        this.actualMarbles = random.nextInt(100) + 1;
        this.hasGuessedCorrectly = false;
    }

    public void processGuess(int userGuess) {
        if (userGuess < actualMarbles) {
            System.out.println("Too low! Try again.");
        } else if (userGuess > actualMarbles) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Congratulations! You guessed the correct number of marbles: " + actualMarbles);
            hasGuessedCorrectly = true;
        }
    }

    public boolean hasGuessedCorrectly() {
        return hasGuessedCorrectly;
    }
}