package student;

public class Position {
    private int column;
    private int row;
    public Position (int column , int row) {
        if (row < 0 || row > 7 || column < 0 || column > 7) {
            throw new IllegalArgumentException ("Ungültige Position . ");
        }
        this.row = row;
        this.column = column;

    }

    public Position (String notation) {
        if (notation == null || notation.length() != 2) {
            throw new IllegalArgumentException("Ungültige Notation.");
        }
        int row_number = Character.getNumericValue(notation.charAt(1));
        char col_char = notation.charAt(0);

        if (row_number < 1 || row_number > 8 || col_char < 'a' || col_char > 'h') {
            throw new IllegalArgumentException ("Ungültige Position . ");
        }

        this.row = row_number - 1;
        this.column = col_char - 'a';

    }

    public int getColumn () {
        return this.column;
    }
    public int getRow () {
        return this.row;
    }
    @Override
    public String toString () {
        char char_col = (char) ('a' + this.column);
        int int_row = this.row +1;
        return "" + char_col + int_row;
    }
    @Override
    public boolean equals (Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj==null || this.getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return this.row == other.row && this.column == other.column;
    }
}