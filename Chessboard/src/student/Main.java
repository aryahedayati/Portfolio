package student;

import java.util.Scanner;
public class Main {
    public static void main (String[] args) {

        Chessboard board = new Chessboard();  // uses your reset() in constructor
        Scanner scanner = new Scanner(System.in);
        boolean isWhiteTurn = true; // Weiß beginnt

        while (true) {
            board.print(); // Schachbrett anzeigen
            System.out.println("Am Zug: " + (isWhiteTurn ? "Weiß" : "Schwarz"));
            System.out.print("Zug eingeben (z.B. d2 d4) oder 'q' zum Beenden: ");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Spiel beendet.");
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2 || parts[0].length() != 2 || parts[1].length() != 2) {
                System.out.println("Ungültiges Format. Bitte benutze z.B. d2 d4.");
                continue;
            }

            Position from = parsePosition(parts[0]);
            Position to = parsePosition(parts[1]);

            if (from == null || to == null) {
                System.out.println("Ungültige Eingabe. Bitte gültige Positionen eingeben.");
                continue;
            }

            Figure movingFigure = board.getFigureAt(from);
            if (movingFigure == null) {
                System.out.println("Kein Stein auf Feld " + parts[0]);
                continue;
            }

            // Falsche Farbe?
            if (movingFigure.isBlack() == isWhiteTurn) {
                System.out.println("Falsche Farbe am Zug!");
                continue;
            }

            boolean moved = board.move(from, to);
            if (!moved) {
                System.out.println("Ungültiger Zug.");
            } else {
                isWhiteTurn = !isWhiteTurn; // Spielerwechsel
            }
        }

        scanner.close();
    }

    public static Position parsePosition(String input) {
        if (input.length() != 2) return null;

        char colChar = Character.toLowerCase(input.charAt(0));
        char rowChar = input.charAt(1);

        int col = colChar - 'a'; // 'a' → 0
        int row = Character.getNumericValue(rowChar) - 1; // '1' → 0

        if (col < 0 || col > 7 || row < 0 || row > 7) return null;

        return new Position(col, row);
    }
}