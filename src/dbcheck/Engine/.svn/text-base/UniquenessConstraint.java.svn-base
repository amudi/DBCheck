/*
 * UniquenessConstraint.java
 *
 * Created on April 23, 2007, 9:44 AM
 *
 */

package dbcheck.Engine;

import java.util.Iterator;

/**
 *
 * @author amudi
 */
public class UniquenessConstraint implements IConstraint {
    
    /** Creates a new instance of UniquenessConstraint */
    public UniquenessConstraint(String p_Filename) {
        m_Metadata = p_Filename;
    }
    
    public void parseMetadata() {
        try {
            String[] t_Element = m_Metadata.split(";");
            m_Id = t_Element[0];
            m_Table = t_Element[1];
            String[] t_Attr = t_Element[2].split(",");
            for (int i = 0; i < t_Attr.length; ++i) {
                m_Attribute.add(t_Attr[i]);
            }
            
            // build query
            StringBuilder t_Str = new StringBuilder();
            t_Str.append("SELECT t1.");
            t_Str.append(m_Attribute.elementAt(0));
            for (int i = 1; i < m_Attribute.size(); ++i) {
                t_Str.append(", t1.");
                t_Str.append(m_Attribute.elementAt(i));
                t_Str.append(" ");
            }
            t_Str.append(", COUNT(*) AS Jumlah ");
            t_Str.append("FROM ");
            t_Str.append(m_Table);
            t_Str.append(" AS t1 ");
            t_Str.append("GROUP BY t1.");
            t_Str.append(m_Attribute.elementAt(0));
            for (int i = 1; i < m_Attribute.size(); ++i) {
                t_Str.append(", t1.");
                t_Str.append(m_Attribute.elementAt(i));
                t_Str.append(" ");
            }
            t_Str.append("HAVING Jumlah > 1");
            
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
        return "Uniqueness Constraint";
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
