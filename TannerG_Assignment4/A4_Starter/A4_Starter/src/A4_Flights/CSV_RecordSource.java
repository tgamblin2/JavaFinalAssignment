package A4_Flights;

public interface CSV_RecordSource {
    /** 
     * return the specified field, as an integer
     * @param iField
     * @return integer value
     */
    public int getInteger(int iField);
    
    /** 
     * return the specified field, as an double
     * @param iField
     * @return double value
     */
    public double getDouble(int iField);
    
    /** 
     * return the specified field, as an string
     * @param iField
     * @return String value
     */
    public String getString(int iField);
    
    /**
     * @return true is any parse errors were detected in this record
     */
    public boolean errorsDetected();
}
