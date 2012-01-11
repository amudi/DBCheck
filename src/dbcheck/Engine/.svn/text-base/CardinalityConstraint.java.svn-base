/*
 * CardinalityConstraint.java
 *
 * Created on April 23, 2007, 9:32 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class CardinalityConstraint implements IConstraint {
    
    /** Creates a new instance of CardinalityConstraint */
    public CardinalityConstraint(String p_Metadata) {
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
        return "Cardinality Constraint";
    }
    
    public boolean checkToDB(DBInstance p_DBInstance) {
        if ((p_DBInstance.sendQuery(this.getQuery())) == null)
            return true;
        else
            return false;
    }
    
    public boolean isViolated() {
        return false;
    }
    
    public Report generateReport() {
        return new Report();
    }
    
    private String m_Metadata;
    private String m_Id;
    private String m_Table1;
    private String m_Attribute1;
    private String m_Table2;
    private String m_Attribute2;
    private String m_Cardinality;
    private String m_Query = null;
}
