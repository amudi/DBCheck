/*
 * GCParameters.java
 *
 * Created on April 24, 2007, 6:43 AM
 *
 */

package dbcheck.Engine;

import java.util.Hashtable;

/**
 *
 * @author amudi
 */
public class GCParameters {
    
    /** Creates a new instance of GCParameters */
    public GCParameters() {
        m_ParametersId = new java.util.Hashtable<String, String>();
        m_Variables = new java.util.Hashtable<String, java.util.Hashtable<String, String[]>>();
    }
    
    public void insertElement(String p_Elements[]) {
        if (!m_ParametersId.containsKey(p_Elements[0])) {
            m_ParametersId.put(p_Elements[0], p_Elements[1]);
        }
        
        
        java.util.Hashtable<String, String[]> t_Ht = new java.util.Hashtable<String, String[]>();
        String t_Var[] = new String[2];
        t_Var[0] = p_Elements[3];
        t_Var[1] = p_Elements[4];
        t_Ht.put(p_Elements[2], t_Var);
        
        if (!m_Variables.containsKey(p_Elements[0])) {
            m_Variables.put(p_Elements[0], t_Ht);
        } else {
            (m_Variables.get(p_Elements[0])).put(p_Elements[2], t_Var);
        }
    }

    public java.util.Hashtable<String, String> getParametersId() {
        return m_ParametersId;
    }

    public void setParametersId(java.util.Hashtable<String, String> p_ParametersId) {
        this.m_ParametersId = p_ParametersId;
    }

    public java.util.Hashtable<String, java.util.Hashtable<String, String[]>> getVariables() {
        return m_Variables;
    }

    public void setVariables(java.util.Hashtable<String, java.util.Hashtable<String, String[]>> p_Variables) {
        this.m_Variables = p_Variables;
    }
    
    /** consist of ID|Tipe */
    private java.util.Hashtable<String, String> m_ParametersId;
    
    /** consist of ID|Hashtable<No. Parameter|Hashtable<Variabel|Nilai>> */
    private java.util.Hashtable<String, java.util.Hashtable<String, String[]>> m_Variables;
}
