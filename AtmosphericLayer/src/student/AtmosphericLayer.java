package student;

public enum AtmosphericLayer {
    TROPO("Troposphäre","Troposphere",new Length(LengthUnit.METER,0.0)),
    STRATO("Stratosphäre","Stratosphere", new Length(LengthUnit.METER,15000)),
    MESO("Mesosphäre","Mesosphere",new Length(LengthUnit.METER,50000)),
    THERMO("Thermosphäre","Thermosphere",new Length(LengthUnit.METER,80000)),
    EXO("Exosphäre","Exosphere",new Length(LengthUnit.METER,500000));

    private final String germanName;
    private final String englishName ;
    private final Length startAltitude;

    AtmosphericLayer (String germanName,String englishName , Length startAltitude) {
        this.germanName = germanName;
        this.englishName = englishName;
        this.startAltitude = startAltitude;
    }
    public String getGerman () {
        return germanName;
    }
    public String getEnglish () {
        return englishName;
    }
    public Length getStartAltitude () {
        return startAltitude;
    }
    @Override
    public String toString () {
        return String.format("%s über %.4f m",germanName,startAltitude.getValue());
    }
}
