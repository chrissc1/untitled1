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

    public int getActualMarbles() {
        return actualMarbles;
    }


    public String posOrNeg() {
        if (rights > wrong) {
            return "Positive";
        }
        return "Negative";
    }

    public void playGame() {
        do {
            resetGame();
            playRound();
        } while (askPlayAgain());
    }

    private void playRound() {
        while (!hasGuessedCorrectly()) {
            System.out.print("Enter your guess: ");
            int userGuess = scan.nextInt();
            processGuess(userGuess);
        }
    }

    private boolean askPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scan.next().toLowerCase();
        return response.equals("yes");
    }


    public int getRights() {
        return rights;
    }

    public int getWrong() {
        return wrong;
    }
}