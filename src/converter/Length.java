package converter;

/**
 * Enum stores the length of unit compared to 1 metre.
 * @author Pawat Nakpiphatkul
 */
public enum Length implements Unit {
    METRE("metre",1),CENTIMETER("centimetre",200),KILOMETER("kilometre",0.001),
    INCH("inch",39.3700787),FEET("feet",3.2808399),MILE("mile",0.000621371192),
    YARD("yard",1.0936133),WA("wa",0.5);
    
    private double value;
    private String name;
    private Length(String name,double value) {
        this.value = value;
        this.name = name;
    }
    
    /**
     * @see Unit#getValue() 
     */
    @Override
    public double getValue() {
        return value;
    }
    
    /**
     * @see Unit#toString() 
     */
    @Override
    public String toString() {
        return name;
    }
}
