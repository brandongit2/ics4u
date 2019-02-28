import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        final int numSides = 6;
        Die die = new Die();
        die.setNumSides(numSides);
        
        double[] bias = new double[numSides];
        for (int i = 0; i < numSides; i++) {
            bias[i] = 1.0 / numSides;
        }
        try {
            die.setBias(bias);
        } catch (Exception err) {
            System.out.println("Invalid bias.");
            System.exit(1);
        }
        
        Scanner sc = new Scanner(System.in);
        
        System.out.format("Welcome to Blackjack!\nThis game is being played with a %d-sided die.\n\nIt's your turn!\n", numSides);
        
        int playerTotal = 0;
        int playerTurns = 1;
        gameLoop:
        while (playerTotal <= 21) {
            int roll1 = die.roll();
            int roll2 = die.roll();
            playerTotal += roll1 + roll2;
            System.out.format("\nRoll #%d:       %d, %d\nRolling total: %d\n", playerTurns, roll1, roll2, playerTotal);
            
            if (playerTotal > 21) break;
            
            while (true) {
                System.out.println("\nWould you like to roll again? (Y/N) ");
                String response = sc.nextLine();
                if (response.equals("y") || response.equals("Y")) {
                    break;
                } else if (response.equals("n") || response.equals("N")) {
                    break gameLoop;
                }
            }
            
            playerTurns++;
        }
        
        if (playerTotal > 21) {
            System.out.println("\nYou lose!");
            System.exit(0);
        }
        
        System.out.println("\nIt is now the computer's turn!");
        
        int compTotal = 0;
        int compTurns = 1;
        while (compTotal <= 21) {
            int roll1 = die.roll();
            int roll2 = die.roll();
            compTotal += roll1 + roll2;
            System.out.format("\nRoll #%d:       %d, %d\nRolling total: %d\n", compTurns, roll1, roll2, compTotal);
            
            if (compTotal > playerTotal) break;
            
            compTurns++;
        }
        
        if (compTotal > playerTotal && compTotal <= 21) {
            System.out.println("\nComputer wins!");
        } else {
            System.out.println("\nYou win!");
        }
    }
}
