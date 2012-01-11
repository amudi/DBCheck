/*
 * DBInstance.java
 *
 * Created on April 17, 2007, 11:09 PM
 *
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public class DBInstance {
    
    /** Creates a new instance of DBInstance */
    public DBInstance(String p_ConfigFilename) {
        m_ConfigFilename = p_ConfigFilename;
    }
    
    public boolean connect() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  // Load JDBC Driver
            
            java.io.FileInputStream t_File = new java.io.FileInputStream(m_ConfigFilename);
            
            String t_ConnectionString = "";
            int t_Content = t_File.read();
            while (t_Content != -1) {
                t_ConnectionString += (char)t_Content;
                t_Content = t_File.read();
            }
            
            t_File.close();
            
            m_Connection = java.sql.DriverManager.getConnection(t_ConnectionString);
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public java.sql.ResultSet sendQuery(String p_Query) {
        java.sql.ResultSet t_ResultSet = null;
        
        try {
            java.sql.Statement t_Statement = m_Connection.createStatement();
            t_ResultSet = t_Statement.executeQuery(p_Query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return t_ResultSet;
    }
    
    private java.sql.Connection m_Connection;
    private String m_ConfigFilename;
}
