package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

import TicTacToe.utils.Pair;

public class Board {
    
    public int size;
    public PlayingPiece[][] boardArray;

    public PlayingPiece[][] getBoardArray() {
        return boardArray;
    }

    public Board(int size) {
        this.size = size;
        boardArray = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if ( row >= size || column >= size || boardArray[row][column] != null ) {
            return false;
        } 
        else {
            boardArray[row][column] = playingPiece;
            return true;
        }
    }

    public List<Pair<Integer,Integer>> getAllFreeCells() {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for ( int i = 0 ; i < size ; i++ ) {
            for ( int j = 0 ; j < size ; j++ ) {
                if ( boardArray[i][j] == null )
                    list.add(new Pair<>(i,j));
            }
        }
        return list;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print(" | ");
            for (int j = 0; j < size; j++) {
                if (boardArray[i][j] != null) {
                   System.out.print(boardArray[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
