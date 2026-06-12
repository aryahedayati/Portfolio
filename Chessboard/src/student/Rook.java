package student;

public class Rook extends Figure {
    public Rook(boolean black) {
        super(black);
    }
    public Rook (boolean black , Position position) {
        super (black,position);
    }
    @Override
    public char getSymbol() {
        return this.isBlack() ? '♜' : '♖';
    }

    @Override
    public String getLabel () {
        return "Turm";
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
        // Rook moves in straight lines: either same row or same column
        return currentCol == targetCol || currentRow == targetRow;
    }
}