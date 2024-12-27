package TicTacToe.utils;

import TicTacToe.models.PlayingPiece;

public class helper {

    public static boolean arePiecesEqual(PlayingPiece p1, PlayingPiece p2, PlayingPiece p3, PlayingPiece p4) {
        if ( p1 == null || p2 == null || p3 == null || p4 == null )
            return false;
        
        return p1.pieceType == p4.pieceType &&
                p2.pieceType == p4.pieceType &&
                p3.pieceType == p4.pieceType;
    }    
}
