package student;

public class Knight extends Figure {
    public Knight(boolean black) {
        super(black);
    }
    public Knight (boolean black,Position position) {
        super(black,position);
    }
    @Override
    public String getLabel () {
        return "Ritter";
    }
    @Override
    public char getSymbol () {
        return this.isBlack() ? '♞' : '♘' ;
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
        int col_diff = Math.abs(currentCol - targetCol);
        int row_diff = Math.abs(currentRow - targetRow);
        return (col_diff == 2 && row_diff == 1) || (col_diff == 1 && row_diff == 2);
    }
}