package student;

public class Pawn extends Figure {

    public Pawn(boolean black) {
        super(black);
    }
    public Pawn (boolean black , Position position) {
        super (black,position);
    }
    @Override
    public char getSymbol() {
        return this.isBlack() ? '♟': '♙' ;
    }

    @Override
    public String getLabel() {
        return "Bauer";
    }

    @Override
    public boolean canMoveTo (Position position,Position target) {
        if (position == null || target == null) {
            throw new IllegalArgumentException("Position darf nicht null sein.");
        }

        if (position.equals(target)) {
            return false;
        }

        int currentCol = position.getColumn();
        int currentRow = position.getRow();
        int targetCol = target.getColumn();
        int targetRow = target.getRow();

        if(currentCol != targetCol) {
            return false;
        }
        if (!this.isBlack()) {
            // White pawn moves "up" the board (row increases)
            if (currentRow == 1 && targetRow == 3) return true; // 2-step start
            if (targetRow == currentRow + 1) return true;
        }
        else {
            // Black pawn moves "down" the board (row decreases)
            if (currentRow == 6 && targetRow == 4) return true; // 2-step start
            if (targetRow == currentRow - 1) return true;       // normal step
        }
        return false;
    }
}