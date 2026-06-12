package student;

public class Queen extends Figure {
    public Queen(boolean black) {
        super(black);
    }
    public Queen (boolean black , Position position) {
        super(black , position);
    }
    @Override
    public String getLabel () {
        return "Königin";
    }
    @Override
    public char getSymbol () {
        return this.isBlack() ? '♛' : '♕' ;
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
        int row_diff = Math.abs(currentRow - targetRow);
        int col_diff = Math.abs(currentCol - targetCol);

        return (currentCol == targetCol || currentRow == targetRow || col_diff == row_diff);
    }
}

