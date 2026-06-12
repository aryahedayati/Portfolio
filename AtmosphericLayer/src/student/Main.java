package student;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Eingabe einer Höhe (<Wert> <Einheit>): ");
        String userInput = input.nextLine();

        String userInputTrimmed = userInput.trim();
        String[] userInputSplitted = userInputTrimmed.split("\\s+");
        if (userInputSplitted.length !=2) {
            throw new IllegalArgumentException("Bitte geben Sie eine Höhe im Format <Zahl> <Einheit> ein, z. B. '1000 m'.");
        }
        int wert = Integer.valueOf(userInputSplitted[0]);
        String einheit = userInputSplitted[1];
        if (einheit == null) {
            einheit = LengthUnit.METER.getSymbol();
        }
        boolean found = false;                                  // boolean flag
        for (LengthUnit u : LengthUnit.values()) {
            String symbol = u.getSymbol();
            if (symbol.equals(einheit)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Die gegebene LengthUnit ist nicht gültig !");
        }
        Length userLength = new Length(LengthUnit.fromSymbol(einheit),(double) wert);  //turns einheit to Length so that we can convert wert into meters
        double wertInMeters = wert * userLength.getUnit().getInMeters();
        String maxAtmosphereLayer = null;
        for (AtmosphericLayer a : AtmosphericLayer.values()) {
            if (wertInMeters >= a.getStartAltitude().getValue()) {
                maxAtmosphereLayer = a.getGerman();
            }
        }
        if (maxAtmosphereLayer != null) {
            System.out.printf("Mit einer Höhe von %d %s befinden Sie sich in der %s", wert, einheit,maxAtmosphereLayer);
        }
        else {
            System.out.println("Die gegebene Höhe befindet sich unterhalb der Troposphäre.");
        }
    }
}
