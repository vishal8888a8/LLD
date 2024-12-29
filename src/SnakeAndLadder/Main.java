package SnakeAndLadder;

public class Main {
    public static void main(String[] args) {

        // Configurable game properties
        int boardSize = 6;
        int snake = 6;
        int ladders = 6;
        int countOfDice = 1;
        int numberOfPlayers = 2;

        Game game = new Game(boardSize, snake, ladders, countOfDice, numberOfPlayers);
        System.out.println("\n **********GAME STARTED********** \n");
        System.out.println("Winner is "+game.playAndGetWinner());
        System.out.println("\n **********GAME ENDED********** \n");
    }
}
