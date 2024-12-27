package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import TicTacToe.models.Board;
import TicTacToe.models.Player;
import TicTacToe.models.PlayingPiece;
import TicTacToe.models.PlayingPieceX;
import TicTacToe.utils.Pair;
import TicTacToe.utils.helper;
import TicTacToe.models.PlayingPieceO;


public class TicTacToe {

    private Board board;
    private Deque<Player> players;

    public TicTacToe() {

        // Game initialization
        board = new Board(3);
        players = new LinkedList<>();

        PlayingPieceX playingPieceX = new PlayingPieceX();
        Player player1 = new Player("Player 1",playingPieceX);

        PlayingPieceO playingPieceO = new PlayingPieceO();
        Player player2 = new Player("Player 2",playingPieceO);

        players.add(player1);
        players.add(player2);
    }

    public String startGame() {
        Boolean isTie = false;
        Scanner scanner = new Scanner(System.in);

        while (!isTie) {

            board.printBoard();

            List<Pair<Integer,Integer>> emptyCellsList = board.getAllFreeCells();
            if ( emptyCellsList.isEmpty() ) {
                isTie = true;
                continue;
            }

            Player player = players.removeFirst();
            System.out.println("Hello "+player.name+" input row and column");
            String input = scanner.nextLine();
            input = input.strip();

            Integer row = Character.getNumericValue(input.charAt(0));
            Integer col = Character.getNumericValue(input.charAt(2));

            // scanner.close();

            Boolean isValidCell = board.addPiece(row, col, player.playingPiece);
            if ( !isValidCell ) {
                System.out.println("Uh oh! wrong cell.");
                players.addFirst(player);
                continue;
            }

            Boolean isPlayerWinner = isWinner(row,col,player.playingPiece);
            if ( isPlayerWinner ) {
                scanner.close();
                board.printBoard();
                return player.name;
            }

            players.addLast(player);

        }
        scanner.close();
        board.printBoard();
        return "Game is Tie";

    }

    public Boolean isWinner(int row, int col, PlayingPiece playingPiece) {
        Boolean isRow = false, isCol = false, isDiag = false, isAntiDiag = false;
        PlayingPiece[][] boardArray = board.getBoardArray();

        //row
        isRow = helper.arePiecesEqual(boardArray[row][0], boardArray[row][1], boardArray[row][2], playingPiece);

        //col
        isCol = helper.arePiecesEqual(boardArray[0][col], boardArray[1][col], boardArray[2][col], playingPiece);

        //diag
        isDiag = helper.arePiecesEqual(boardArray[0][0], boardArray[1][1], boardArray[2][2], playingPiece);

        //antiDiag
        isAntiDiag = helper.arePiecesEqual(boardArray[2][0], boardArray[1][1], boardArray[0][2], playingPiece);

        return isAntiDiag || isDiag || isRow || isCol;

    }
    
}
