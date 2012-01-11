/*
 * ConstraintManagerTest.java
 * JUnit based test
 *
 * Created on April 23, 2007, 11:34 AM
 */

package dbcheck.Engine;

import junit.framework.*;
import java.io.FileNotFoundException;

/**
 *
 * @author amudi
 */
public class ConstraintManagerTest extends TestCase {
    
    public ConstraintManagerTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of getConstraint method, of class dbcheck.Engine.ConstraintManager.
     */
    public void testGetConstraint() throws Exception {
        System.out.println("getConstraint");
        
        int p_Type = 0;
        String p_Id = "";
        ConstraintManager instance = new ConstraintManager();
        
        IConstraint expResult = null;
        IConstraint result = instance.getConstraint(p_Type, p_Id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertConstraint method, of class dbcheck.Engine.ConstraintManager.
     */
    public void testInsertConstraint() {
        System.out.println("insertConstraint");
        
        int p_Type = 0;
        String p_Id = "";
        IConstraint p_Constraint = null;
        ConstraintManager instance = new ConstraintManager();
        
        instance.insertConstraint(p_Type, p_Id, p_Constraint);
    }

    /**
     * Test of generateConstraintsFromFile method, of class dbcheck.Engine.ConstraintManager.
     */
    public void testGenerateConstraintsFromFile() {
        System.out.println("generateConstraintsFromFile");
        
        String p_Filename = "Common/metadatalist.conf";
        ConstraintManager instance = new ConstraintManager();
        
        instance.generateConstraintsFromFile(p_Filename);
    }
    
}
