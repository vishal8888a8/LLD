# TicTacToe

## Objects
- Pieces ( of type X, O , etc.. )
- Board N x M
- Players List

## Relationships

- PlayingPiece     ------is a---> PieceX, PieceO
- Player      -----has a----> Piece
- Board     ----has a----> Players, Piece
- Game     -----has a---> board, Playing piece
