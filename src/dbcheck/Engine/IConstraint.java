/*
 * IConstraint.java
 *
 * Created on April 21, 2007, 11:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dbcheck.Engine;

/**
 *
 * @author amudi
 */
public interface IConstraint {
    public void parseMetadata();
    public String getQuery();
    public String getId();
    public String getType();
    public boolean checkToDB(DBInstance p_DBInstance);
    public boolean isViolated();
    public Report generateReport();
}
