package student;

public class Figure {
    private boolean black ;
    private Position position;

    public Figure(boolean black) {           // die leehre Standardkonstruktor für die Evaluation
        this.black = black;
    }
    public String getLabel() {
        return "Unbekannte Figur";           //dummy methods for testing
    }
    public char getSymbol() {
        return '?';
    }
    public boolean isBlack () {
        return this.black;
    }
    public Figure (boolean black , Position position) {
        this.black = black;
        this.position = position;
    }
    public boolean canMoveTo (Position position , Position target) {

        if (position == null || target == null ) {
            throw new IllegalArgumentException("Position darf nicht null sein.");

        }
        if (position.equals(target)) {
            return false;
        }
        return false;           //default

    }
    public Position getPosition () {
        return this.position;
    }
    @Override
    public String toString () {
        String colorText = black ? "black" : "white";
        String typeText = switch (getLabel()) {
            case "Bauer" -> "Pawn";
            case "Springer" -> "Knight";
            case "Läufer" -> "Bishop";
            case "Turm" -> "Rook";
            case "Dame" -> "Queen";
            case "König" -> "King";
            default -> "Unknown piece";
        };
        return typeText + " (" + colorText + ")";
    }
}