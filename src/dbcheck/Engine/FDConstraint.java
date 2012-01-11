/*
 * FDConstraint.java
 *
 * Created on April 23, 2007, 9:41 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class FDConstraint implements IConstraint {
    
    /** Creates a new instance of FDConstraint */
    public FDConstraint(String p_Metadata) {
        m_Metadata = p_Metadata;
        m_LHS = new java.util.Vector<String>();
        m_RHS = new java.util.Vector<String>();
    }
    
    public void parseMetadata() {
        try {
            String[] t_Element = m_Metadata.split(";");
            m_Id = t_Element[0];
            m_Table = t_Element[1];
            String[] t_LHS = t_Element[2].split(",");
            for (int i = 0; i < t_LHS.length; ++i) {
                m_LHS.add(t_LHS[i]);
            }
            
            String[] t_RHS = t_Element[3].split(",");
            for (int i = 0; i < t_RHS.length; ++i) {
                m_RHS.add(t_RHS[i]);
            }
            
            // build query
            StringBuilder t_Str = new StringBuilder();
            t_Str.append("SELECT t1.* FROM ");
            t_Str.append(m_Table);
            t_Str.append(" AS t1 INNER JOIN (SELECT t2.");
            t_Str.append(m_LHS.elementAt(0));
            for (int i = 1; i < m_LHS.size(); ++i) {
                
            }
            
            m_Query = t_Str.toString();            
        } catch (Exception ex) {
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
        return "FD Constraint";
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
    private java.util.Vector<String> m_LHS;
    private java.util.Vector<String> m_RHS;
    private String m_Query = null;
}
