import java.util.Scanner;

public class GameEngine {
    private MarbleManager marbleManager;
    private Scanner scanner;

    private String name;

    public GameEngine(String name) {
        this.name = name;
        this.marbleManager = new MarbleManager();
        this.scanner = new Scanner(System.in);
    }


    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            displayRules();
            while (!marbleManager.hasGuessedCorrectly()) {
                System.out.print("Enter your guess: ");
                int userGuess = getUserInput();
                marbleManager.processGuess(userGuess);
            }

            System.out.println("Do you want to play again? y / n");
            playAgain = scanner.next().equalsIgnoreCase("y");

            if (playAgain) {
                marbleManager.resetGame();
            }
        }
    }

    public void displayRules() {
        System.out.println("Welcome " + name + " to the Marble Guessing Game!");
        System.out.println("I have a random number of marbles. Can you guess how many?");
    }

    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
