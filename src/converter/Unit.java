package converter;

/**
 * Interface for all unit for converter to recognize.
 * @author Pawat Nakpiphatkul
 */
public interface Unit {
    /**
     * Get the value of selected unit.
     * @return value of selected unit.
     */
    public double getValue();
    
    /**
     * Get the name of unit.
     * @return name of unit.
     */
    public String toString();
}
