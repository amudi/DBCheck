/*
 * GeneralConstraint.java
 *
 * Created on April 23, 2007, 9:47 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class GeneralConstraint implements IConstraint {
    
    /** Creates a new instance of GeneralConstraint */
    public GeneralConstraint(String p_Id, String p_Name, String p_Query, String[] p_ParametersValues) {
        m_Id = p_Id;
        m_Name = p_Name;
        m_Query = p_Query;
        m_ParametersValues = p_ParametersValues;
    }
    
    public void parseMetadata() {
        
    }
    
    public String getQuery() {
        if (m_Query == null)
            this.parseMetadata();
        return m_Query;
    }
    
    public String getId() {
        return m_Id;
    }
    
    public String getType() {
        return "General Constraint";
    }
    
    public boolean checkToDB(DBInstance p_DBInstance) {
        return true;
    }
    
    public boolean isViolated() {
        return false;
    }
    
    public Report generateReport() {
        return new Report();
    }
    
    private String m_Id;
    private String m_Name;
    private String m_ParametersValues[];
    private String m_Query = null;
}
