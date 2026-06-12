package student;

public enum LengthUnit {
    METER(1.0,"m"),
    INCH(0.0254,"\""),
    FEET(0.3048,"ft"),
    NAUTICAL_MILE(1852.0,"NM");

    private final double value;
    private final String symbol;

    LengthUnit(double value , String symbol){
        this.value = value;
        this.symbol = symbol;
    }
    public String getSymbol () {
        return this.symbol;

    }
    public double getInMeters () {
        return this.value;
    }
    @Override
    public String toString() {
        return symbol ;
    }
    public static LengthUnit fromSymbol (String symbol) {
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit == null) {
                return null;
            }
            if (unit.getSymbol().equalsIgnoreCase(symbol)) {
                return unit;
            }
        }
        return null;
    }

}