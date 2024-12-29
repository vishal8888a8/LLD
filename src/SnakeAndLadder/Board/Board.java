package SnakeAndLadder.Board;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    int size;
    Piece[][] board;

    public Board(int size, int ladders, int snakes ) {
        this.size = size;
        initializeBoard(size);
        addLadders(ladders);
        addSnakes(snakes);
    }

    //TODO:- to avoid loops
    private void initializeBoard(int size) {
        board = new Piece[size][size];
        int position = 1;
        for ( int i = 0 ; i < size ; i++ ) {
            for ( int j = 0 ; j < size ; j++ ) {
                Jump jump = new Jump(position, position);
                board[i][j] = new Piece(position, jump);
                position++;
            }
        }
    }

    private void addLadders(int ladders) {
        System.out.println("ladders \n");
        while (ladders != 0) {
            int start = ThreadLocalRandom.current().nextInt(1,size*size);
            int end = ThreadLocalRandom.current().nextInt(1,size*size);
            if ( end <= start )
                continue;
            Jump jump = new Jump(start, end);
            Piece piece = findPieceByPosition(start);
            piece.setJump(jump);
            ladders--;
            System.out.println(jump.toString());
        }
    }

    private void addSnakes(int snakes) {
        System.out.println("\nSnakes \n");
        while (snakes != 0) {
            int start = ThreadLocalRandom.current().nextInt(1,size*size+1);
            int end = ThreadLocalRandom.current().nextInt(1,size*size+1);
            if ( end >= start )
                continue;
            Piece piece = findPieceByPosition(start);

            if ( piece.jump.getEnd() != piece.jump.getStart() ) // a ladder is already there
                continue;
            Jump jump = new Jump(start, end);
            piece.setJump(jump);;
            snakes--;
            System.out.println(jump.toString());
        }
    }

    public Piece findPieceByPosition(int start) {
        return board[(start-1)/size][(start-1)%size];
    }
}
