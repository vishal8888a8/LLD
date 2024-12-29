package SnakeAndLadder.Player;

public class Player {
    String name;
    int id;
    int pos;

    public Player(int id, String name, int pos) {
        this.id = id;
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    
}
