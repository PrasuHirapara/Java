package Project.TicTacToe;

import java.io.Serializable;

public class Move implements Serializable {
    private static final long serialVersionUID = 1L;
    public int x;
    public int y;
    public char symbol;

    public Move(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Move{" + "x=" + x + ", y=" + y + ", symbol=" + symbol + '}';
    }
}
