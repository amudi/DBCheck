/*
 * Main.java
 *
 * Created on April 17, 2007, 10:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dbcheck;

import dbcheck.Engine.*;
import dbcheck.GUI.*;

/**
 *
 * @author amudi
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBInstance t_Instance = new DBInstance("Common/dbconfig.conf");
        
        String p_Filename = "Common/metadatalist.conf";
        ConstraintManager instance = new ConstraintManager();
        
        instance.generateConstraintsFromFile(p_Filename);
    }
    
}
