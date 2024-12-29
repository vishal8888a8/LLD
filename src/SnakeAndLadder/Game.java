package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

import SnakeAndLadder.Board.Board;
import SnakeAndLadder.Board.Jump;
import SnakeAndLadder.Board.Piece;
import SnakeAndLadder.Dice.Dice;
import SnakeAndLadder.Player.Player;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;
    int boardSize;

    public Game(int boardSize, int snakes, int ladders, int countOfDice, int numberOfPlayers) {
        board = new Board(boardSize, ladders, snakes);
        dice = new Dice(countOfDice);
        players = new LinkedList<>();
        for ( int i = 1; i <= numberOfPlayers; i++ ) {
            Player player = new Player(i, "Player "+i, 1);
            players.addLast(player);
        }
        this.boardSize = boardSize;
    }

    public String playAndGetWinner() {
        String winner = null;

        while (winner == null ) {
            Player currentPlayer = players.removeFirst();
            int diceRoll = dice.rollTheDice();
            int finalPosition = diceRoll+currentPlayer.getPos();

            System.out.println(currentPlayer.getName()+" rolled the dice = "+ diceRoll + " and jumped from "+ currentPlayer.getPos() + " to " + finalPosition);

            if ( finalPosition <= boardSize*boardSize ) {
                Piece piece = board.findPieceByPosition(finalPosition);
                Jump currentJump = piece.getJump();

                if ( currentJump.getStart() == currentJump.getEnd() ) {
                    System.out.println("He landed at a normal position!");
                }
                else if ( currentJump.getStart() > currentJump.getEnd() ){
                    System.out.println("He got bitten by a snake!");
                    finalPosition = currentJump.getEnd();
                }
                else {
                    System.out.println("He lander on a stair!");
                    finalPosition = currentJump.getEnd();
                }
            }

            currentPlayer.setPos(finalPosition);
            System.out.println("He is now at " + finalPosition);
            if ( finalPosition > boardSize*boardSize )
                winner = currentPlayer.getName();
                
            players.addLast(currentPlayer);
        }

        return winner;
    }

}
