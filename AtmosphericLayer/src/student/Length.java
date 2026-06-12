package student;

public class Length implements Comparable<Length> {
    private double value;
    private LengthUnit unit;

    public Length() {
        this.value = 0.0d;
        this.unit = LengthUnit.METER;
    }

    public Length(double value) {

        this.value = value;
        this.unit = LengthUnit.METER;
    }

    public Length(LengthUnit unit, double value) {
        if (unit == null) {
            throw new IllegalArgumentException("Die Längeneinheit soll nicht null sein.\n");
        }
        this.value = value;
        this.unit = unit;
    }

    public LengthUnit getUnit() {
        return this.unit;
    }

    public void setUnit(LengthUnit unit) {
        if (unit != null) {
            this.unit = unit;
        } else {
            throw new IllegalArgumentException("Die unit soll nicht null sein.");
        }
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.ENGLISH, "%.4f %s", value, unit);
    }

    public double getValueIn(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Die unit soll nict null sein.");
        }
        double targetUnitInMeters = targetUnit.getInMeters();
        double currentUnitInMeters = this.unit.getInMeters();
        return this.value * (currentUnitInMeters / targetUnitInMeters);
    }
    @Override
    public int compareTo(Length other) {
        double currentValueInMeters = this.getValue() * this.unit.getInMeters();
        double otherValueInMeters = other.getValue() * other.unit.getInMeters();
        return Double.compare(currentValueInMeters, otherValueInMeters);
    }
    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Length)) {return false;}
        Length object = (Length) obj;
        double currentValueInMeters = this.getValue() * this.unit.getInMeters();
        double otherValueInMeters = object.getValue() * object.unit.getInMeters();
        return Double.compare(otherValueInMeters,currentValueInMeters)==0;
    }
}
