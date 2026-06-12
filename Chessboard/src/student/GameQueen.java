package student;

public class GameQueen extends Queen {
    private Chessboard board;
    public GameQueen (Chessboard board , boolean black) {
        super(black);
        this.board = board;
    }
    @Override
    public boolean canMoveTo (Position from , Position to) {
        int col_diff = Math.abs(from.getColumn() - to.getColumn());
        int row_diff = Math.abs(from.getRow() - to.getRow() );
        boolean isStraight = ( col_diff == 0 || row_diff == 0 );
        boolean isDiagonal = ( col_diff == row_diff );
        if (!isDiagonal && !isStraight) return false;
        Position[] inbetween = board.getFieldsBetween(from,to);
        for (Position p : inbetween) {
            Figure target = board.getFigureAt(p);
            if ( target != null ) return false;
        }
        Figure target = board.getFigureAt(to);
        if (target == null) return true;
        else if (target.isBlack() != this.isBlack()) return true;
        else return false;
    }
}