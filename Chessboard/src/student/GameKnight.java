package student;

public class GameKnight extends Knight {
    private Chessboard board;
    public GameKnight (Chessboard board , boolean black) {
        super(black);
        this.board = board;
    }
    @Override
    public boolean canMoveTo (Position from , Position to) {
        int row_diff = Math.abs(from.getRow() - to.getRow());
        int col_diff = Math.abs(from.getColumn() - to.getColumn());

        if (!((row_diff==2 && col_diff ==1)||(row_diff ==1 && col_diff==2))) {
            return false;
        }
        Figure target = board.getFigureAt(to);
        if (target == null) return true;
        else if (target.isBlack() == this.isBlack()) {
            return false;
        }
        else {
            return true;
        }
    }
}