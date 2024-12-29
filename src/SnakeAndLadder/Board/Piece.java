package SnakeAndLadder.Board;

public class Piece {

    int position;
    Jump jump;
    
    public Piece(int position, Jump jump) {
        this.position = position;
        this.jump = jump;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
 
}
