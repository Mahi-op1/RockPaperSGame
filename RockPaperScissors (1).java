import java.util.Scanner;

public class RockPaperScissors {

    enum Move {
        ROCK, PAPER, SCISSORS;

        public String compareMoves(Move opponentMove) {
            if (this == opponentMove) {
                return "It's a tie!";
            }
            switch (this) {
                case ROCK:
                    return (opponentMove == SCISSORS) ? "You win!" : "Computer wins!";
                case PAPER:
                    return (opponentMove == ROCK) ? "You win!" : "Computer wins!";
                case SCISSORS:
                    return (opponentMove == PAPER) ? "You win!" : "Computer wins!";
            }
            return "Invalid move.";
        }

        public static Move fromChar(char c) {
            switch (c) {
                case 'R': return ROCK;
                case 'P': return PAPER;
                case 'S': return SCISSORS;
                default: throw new IllegalArgumentException("Invalid move. Enter R, P, or S.");
            }
        }

        public static Move getRandomMove() {
            int randomMove = (int) (Math.random() * 3);
            return values()[randomMove];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter R for Rock, P for Paper, or S for Scissors: ");
            char userChar = sc.next().toUpperCase().charAt(0);
            Move userMove = Move.fromChar(userChar);
            Move computerMove = Move.getRandomMove();

            System.out.println("Your move: " + userMove);
            System.out.println("Computer's move: " + computerMove);
            System.out.println(userMove.compareMoves(computerMove));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
