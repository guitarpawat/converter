package converter;

/**
 * Class that bridge between CovvertUI and Length.
 * @author Pawat Nakpiphatkul
 */
public class UnitConverter {
    /**
     * Convert the unit.
     * @param amount is the length of the input unit.
     * @param from is the input unit.
     * @param to is the output unit.
     * @return the length of the output unit.
     */
    public double convert(double amount,Unit from,Unit to) {
        return amount/from.getValue()*to.getValue();
    }
    
    /**
     * Get the all Units from length.
     * @return all Units from length.
     */
    public Unit[] getUnits() {
        return Length.values();
    }
}