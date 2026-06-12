package student;

import java.util.ArrayList;

public class Chessboard
{
    //für die Ausgabe (Methode print) genutzt
    private static char[] columnChars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    /**
     * Das Array repräsentiert die einzelnen Spielfelder, auf denen sich jeweils eine Spielfigur befinden kann.
     * Wenn ein Spielfeld leer ist, ist der entspr. Wert im Array null, andernfalls enthält es ein Objekt einer Subklasse von Figure.
     */
    private Figure[][] board = new Figure[8][8];

    /**
     * Die Methode versetzt das Schachbrett in den Anfangszustand.
     */
    public void reset()
    {
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                board[c][r] = null;
            }
        }
        board[0][0] = new GameRook(this, false);
        board[1][0] = new GameKnight(this, false);
        board[2][0] = new GameBishop(this, false);
        board[3][0] = new GameQueen(this, false);
        board[4][0] = new GameKing(this, false);
        board[5][0] = new GameBishop(this, false);
        board[6][0] = new GameKnight(this, false);
        board[7][0] = new GameRook(this, false);

        board[0][7] = new GameRook(this, true);
        board[1][7] = new GameKnight(this, true);
        board[2][7] = new GameBishop(this, true);
        board[3][7] = new GameQueen(this, true);
        board[4][7] = new GameKing(this, true);
        board[5][7] = new GameBishop(this, true);
        board[6][7] = new GameKnight(this, true);
        board[7][7] = new GameRook(this, true);

        for (int c = 0; c < 8; c++)
        {
            board[c][1] = new GamePawn(this, false);
            board[c][6] = new GamePawn(this, true);
        }
    }

    /**
     * Ausgabe des Schachbretts mitsamt aller Spielfiguren auf der Kommandozeile
     */
    public void print()
    {
        for (int r = 0; r < 9; r++)
        {
            for (int c = 0; c < 9; c++)
            {
                if (r == 0)
                {
                    if (c == 0)
                    {
                        System.out.print("  ");
                    }
                    else
                    {
                        System.out.print(columnChars[c - 1] + " ");
                    }
                }
                else
                {
                    if (c == 0)
                    {
                        System.out.print((9 - r) + " ");
                    }
                    else
                    {
                        int colIndex = c - 1;
                        int rowIndex = 7 - (r - 1);
                        Figure fig = board[colIndex][rowIndex];
                        char emptySymbol = (colIndex + rowIndex) % 2 == 0 ? '☒' : '☐';
                        System.out.print((fig == null ? emptySymbol : fig.getSymbol()) + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Die Methode dient dazu, eine Spiefigur von der Startposition (erster Parameter) zur Zielposition
     * (zweiter Parameter) zu bewegen. Eventuell wird dabei eine gegnerische Spielfigur geschlagen und
     * vom Schachbrett genommen. Die Methode gibt einen Wahrheitswert zurück, ob der Spielzug möglich war.
     * Um das zu entscheiden, wird die Methode canMoveTo an dem Figure-Objekt aufgerufen, das bewegt werden soll.
     *
     * @param from Startposition
     * @param to   Zielposition
     * @return true, falls der Spielzug möglich war
     */
    public boolean move(Position from, Position to)
    {
        if (from == null || to == null)
        {
            throw new IllegalArgumentException("Position from or to must not be null");
        }

        Figure fromFig = board[from.getColumn()][from.getRow()];
        if (fromFig == null)
        {
            return false;
        }

        if (fromFig.canMoveTo(from, to))
        {
            Figure toFig = board[to.getColumn()][to.getRow()];
            board[from.getColumn()][from.getRow()] = null;
            board[to.getColumn()][to.getRow()] = fromFig;

            if (toFig != null)
            {
                System.out.println(fromFig + " schlägt " + toFig + " auf " + to);
            }
            return true;
        }
        return false;
    }

    /**
     * Die Methode dient dazu, alle Spielfelder zu ermitteln, die sich auf direktem Weg (vertikal, horizontal oder diagonal)
     * zwischen der Startposition (erster Parameter) und der Zielposition (zweiter Parameter) befinden.
     * Die Spielfelder werden als Array vom Typ Position zurückgegeben und enthalten die Start- und Endposition nicht.
     *
     * @param start Startposition
     * @param end   Endposition
     * @return Spielfelder zwischen Start- und Endposition
     */
    public Position[] getFieldsBetween(Position start, Position end)
    {
        int colDir = end.getColumn() - start.getColumn();
        if (colDir != 0)
        {
            colDir = colDir / Math.abs(colDir);
        }

        int rowDir = end.getRow() - start.getRow();
        if (rowDir != 0)
        {
            rowDir = rowDir / Math.abs(rowDir);
        }

        int col = start.getColumn() + colDir;
        int row = start.getRow() + rowDir;

        ArrayList<Position> fields = new ArrayList<>();
        while (col != end.getColumn() || row != end.getRow())
        {
            fields.add(new Position(col, row));
            col += colDir;
            row += rowDir;
        }

        return fields.toArray(new Position[0]);
    }

    public ChessBoard () {
        reset();
    }
    public Figure getFigureAt (Position position) {
        if (position == null) return false;
        return board[position.getColumn][position.getRow];

    }
    public boolean isFreeBetween (Position from , Position to) {
        Position[] inbetween = board.getFieldsBetween(from,to);
        for (Position p : inbetween) {
            Figure target = board.getFigureAt(p);
            if (target != null) {
                return true;
            }
        }
        return true;
    }
}
