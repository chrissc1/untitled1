import java.util.Scanner;

public class GameEngine {
    private MarbleManager marbleManager;
    private Scanner scanner;

    public GameEngine() {
        this.marbleManager = new MarbleManager();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Marble Guessing Game!");
        System.out.println("I have a random number of marbles. Can you guess how many?");

        while (!marbleManager.hasGuessedCorrectly()) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            marbleManager.processGuess(userGuess);
        }

        scanner.close();
    }
}