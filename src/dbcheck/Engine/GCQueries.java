/*
 * GCQueries.java
 *
 * Created on April 24, 2007, 6:42 AM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class GCQueries {
    
    /** Creates a new instance of GCQueries */
    public GCQueries() {
        m_Queries = new java.util.Hashtable<String, String[]>();
    }
    
    public void insertElement(String p_Elements[]) throws Exception {
        String t_String[] = new String[2];
        t_String[0] = p_Elements[1];
        t_String[1] = p_Elements[2];
        
        if (!m_Queries.containsKey(p_Elements[0])) {
            m_Queries.put(p_Elements[0], t_String);
        } else {
            throw new Exception("Elements already exists");
        }
    }

    public java.util.Hashtable<String, String[]> getQueries() {
        return m_Queries;
    }

    public void setQueries(java.util.Hashtable<String, String[]> p_Queries) {
        this.m_Queries = p_Queries;
    }
    
    /** consist of ID|String[2] */
    private java.util.Hashtable<String, String[]> m_Queries;
}
