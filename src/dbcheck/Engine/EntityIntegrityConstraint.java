/*
 * EntityIntegrityConstraint.java
 *
 * Created on April 23, 2007, 9:39 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class EntityIntegrityConstraint implements IConstraint {
    
    /** Creates a new instance of EntityIntegrityConstraint */
    public EntityIntegrityConstraint(String p_Metadata) {
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
        return "Entity Integrity Constraint";
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
    private String m_Table;
    private java.util.Vector<String> m_Attribute;    
    private String m_Query = null;
}
