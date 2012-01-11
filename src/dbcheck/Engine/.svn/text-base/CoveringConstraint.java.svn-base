/*
 * CoveringConstraint.java
 *
 * Created on April 23, 2007, 9:07 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class CoveringConstraint implements IConstraint {
    
    /** Creates a new instance of CoveringConstraint */
    public CoveringConstraint(String p_Metadata) {
        m_Metadata = p_Metadata;
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
        return "Covering Constraint";
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
    
    private String m_Metadata;
    private String m_Id;
    private int m_AttributesCount;
    private java.util.Vector<String> m_Tables;
    private java.util.Vector<String> m_Attributes;
    private String m_Query = null;
}
