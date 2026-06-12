package student;

public class King extends Figure {
    public King(boolean black) {
        super(black);
    }
    public King (boolean black , Position position) {
        super(black , position);
    }
    @Override
    public String getLabel () {
        return "König";
    }
    @Override
    public char getSymbol () {
        return isBlack() ? '♚' : '♔' ;
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

        return (row_diff <= 1 && col_diff >= 1 );

    }
}

