/*
 * NotNullConstraint.java
 *
 * Created on April 21, 2007, 11:11 PM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class NotNullConstraint implements IConstraint {
    
    /** Creates a new instance of NotNullConstraint */
    public NotNullConstraint(String p_Metadata) {
        m_Metadata = p_Metadata;
    }
    
    public void parseMetadata() {
        try {
            String[] t_Element = m_Metadata.split(";");
            m_Id = t_Element[0];
            m_Table = t_Element[1];
            m_Attribute = t_Element[2];
            
            // build query
            StringBuilder t_Str = new StringBuilder();
            t_Str.append("SELECT * FROM ");
            t_Str.append(m_Table);
            t_Str.append(" AS t1 WHERE t1.");
            t_Str.append(m_Attribute);
            t_Str.append(" IS NULL");
            
            m_Query = t_Str.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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
        return "Not-Null Constraint";
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
    private String m_Table;
    private String m_Attribute;
    private String m_Query = null;
}
