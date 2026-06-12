package student;

public class GameRook extends Rook {
    private Chessboard board;
    public GameRook(Chessboard board , boolean black) {
        super(black);
        this.board = board;

    }
    @Override
    public boolean canMoveTo (Position from , Position to) {
        Position [] inBetween = board.getFieldsBetween(from , to);
        for (Position p : inBetween) {
            Figure target = board.getFigureAt(p);
            if (target != null) {
                return false;
            }
        }
        Figure target = board.getFigureAt(to);
        if (target == null) {
            return true;
        }
        else if (target.isBlack() != this.isBlack()) {
            return true;
        }
        else {
            return false;
        }
    }
}