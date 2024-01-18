import java.util.Random;
import java.util.Scanner;

public class MarbleManager {
    private int actualMarbles;
    private boolean hasGuessedCorrectly;

    private int rights;

    private int wrong;

    private Scanner scan;

    public MarbleManager() {
        scan = new Scanner(System.in);
        rights = 0;
        resetGame();
    }


    public void processGuess(int userGuess) {
        if (userGuess < actualMarbles) {
            wrong++;
            System.out.println("Too low! Try again.");
        } else if (userGuess > actualMarbles) {
            wrong++;
            System.out.println("Too high! Try again.");
        } else {
            rights++;
            System.out.println("Congratulations! You guessed the correct number of marbles: " + actualMarbles);
            hasGuessedCorrectly = true;
        }
    }

    public boolean hasGuessedCorrectly() {
        return hasGuessedCorrectly;
    }

    public void resetGame() {
        Random random = new Random();
        this.actualMarbles = random.nextInt(100) + 1;
        this.hasGuessedCorrectly = false;
    }


    public String posOrNeg() {
        if (rights > wrong) {
            return "Positive";
        }
        return "Negative";
    }

    public int getRights() {
        return rights;
    }

    public int getWrong() {
        return wrong;
    }
}