/*
 * DBInstanceTest.java
 * JUnit based test
 *
 * Created on April 21, 2007, 10:54 PM
 */

package dbcheck.Engine;

import junit.framework.*;
import com.sun.corba.se.impl.util.SUNVMCID;
import java.io.*;
import java.sql.*;
import javax.sql.*;
import org.omg.CORBA.COMM_FAILURE;

/**
 *
 * @author amudi
 */
public class DBInstanceTest extends TestCase {
    
    public DBInstanceTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of connect method, of class dbcheck.Engine.DBInstance.
     */
    public void testConnect() {
        System.out.println("Connect");
        
        DBInstance instance = new DBInstance("Common/dbconfig.conf");
        
        boolean expResult = true;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
