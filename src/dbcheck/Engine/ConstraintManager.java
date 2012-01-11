/*
 * ConstraintManager.java
 *
 * Created on April 21, 2007, 11:16 PM
 *
 */

package dbcheck.Engine;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author amudi
 */
public class ConstraintManager {
    
    /** Creates a new instance of ConstraintManager */
    public ConstraintManager() {
        m_Constraints = new java.util.Hashtable<Integer, java.util.Hashtable<String, IConstraint>>();
    }
    
    public IConstraint getConstraint(int p_Type, String p_Id) throws Exception {
        if (!m_Constraints.contains(p_Type)) {
            throw new Exception("Cannot find the type in ConstraintManager");
        }
        
        return (IConstraint)((java.util.Hashtable)m_Constraints.get(p_Type)).get(p_Id);
    }
    
    public void insertConstraint(int p_Type, String p_Id, IConstraint p_Constraint) {
        if (!m_Constraints.containsKey(p_Type)) {
            java.util.Hashtable<String, IConstraint> t_Element = new java.util.Hashtable<String, IConstraint>();
            t_Element.put(p_Id, p_Constraint);
            m_Constraints.put(p_Type, t_Element);
        } else {
            java.util.Hashtable<String, IConstraint> t_Hashtable = m_Constraints.get(p_Type);
            t_Hashtable.put(p_Id, p_Constraint);
        }
    }
    
    public void generateConstraintsFromFile(String p_Filename) {
        try {
            java.io.BufferedReader t_Br = new java.io.BufferedReader(new java.io.FileReader(p_Filename));
            String t_CurrentLine = null;
            
            while ((t_CurrentLine = t_Br.readLine()) != null) {
                
                int t_ConstraintId = Integer.parseInt(t_CurrentLine.substring(0, t_CurrentLine.indexOf(",")));
                String t_Filename = t_CurrentLine.substring(t_CurrentLine.indexOf(",") + 1, t_CurrentLine.length());
                System.out.println("Constraint ID: " + t_ConstraintId);
                
                if (t_ConstraintId == 11) {
                    String t_MetadataQuery = null;
                    String t_FilenameQ = t_Filename.substring(0, t_Filename.indexOf(","));
                    System.out.println("Query Filename: " + t_FilenameQ);
                    java.io.BufferedReader t_BrQ = new java.io.BufferedReader(new java.io.FileReader(t_FilenameQ));
                    GCQueries t_GCQ = new GCQueries();
                    
                    while ((t_MetadataQuery = t_BrQ.readLine()) != null) {
                        if (t_MetadataQuery.startsWith("#")) {
                            continue;
                        }
                        String t_Elmt[] = t_MetadataQuery.split(";");
                        t_GCQ.insertElement(t_Elmt);
                    }
                    t_BrQ.close();
                    
                    String t_MetadataParameter = null;
                    String t_FilenameP = t_Filename.substring(t_Filename.indexOf(",") + 1, t_Filename.length());
                    System.out.println("Parameter Filename: " + t_FilenameP);
                    java.io.BufferedReader t_BrP = new java.io.BufferedReader(new java.io.FileReader(t_FilenameP));
                    GCParameters t_GCP = new GCParameters();
                    
                    while ((t_MetadataParameter = t_BrP.readLine()) != null) {
                        if (t_MetadataParameter.startsWith("#")) {
                            continue;
                        }
                        String t_Elmt[] = t_MetadataParameter.split(";");
                        t_GCP.insertElement(t_Elmt);
                    }
                    t_BrP.close();
                    
                    // create Constraint instances
                    // untuk setiap elemen t_GCP, cari query-nya di t_GCQ, buat objek GeneralConstraintnya, dan ganti variabel2nya
                    java.util.Iterator t_ParamVars = t_GCP.getVariables().entrySet().iterator();
                    while (t_ParamVars.hasNext()) {                        
                        // get parameters from metadata parameter file
                        String[] t_ParamVal = null;
                        
                        java.util.Map.Entry<String, java.util.Hashtable<String, String[]>> t_Entry = (java.util.Map.Entry<String, java.util.Hashtable<String, String[]>>)t_ParamVars.next();
                        //System.out.println(t_Entry.toString());
                        String t_Id = t_Entry.getKey();
                        
                        java.util.Map<String, String[]> t_TempMap = (t_Entry.getValue());
                        java.util.Iterator t_TempItr = t_TempMap.entrySet().iterator();
                        while (t_TempItr.hasNext()) {
                            java.util.Map.Entry<String, String[]> t_InnerEntry = (java.util.Map.Entry<String, String[]>)t_TempItr.next();
                            int t_NoParam = Integer.parseInt(t_InnerEntry.getKey());
                            t_ParamVal = t_InnerEntry.getValue();
                        }
                        
                        // get name and query from metadata query file
                        String[] t_QElmt = t_GCQ.getQueries().get(t_GCP.getParametersId().get(t_Id));
                        String t_Name = t_QElmt[0];
                        String t_Query = t_QElmt[1];
                    }
                }
                else {
                    System.out.println("Constraint Filename: " + t_Filename);
                    m_Constraints.put(t_ConstraintId, new java.util.Hashtable<String, IConstraint>());

                    // load the constraints from file
                    java.io.BufferedReader t_Reader = new java.io.BufferedReader(new java.io.FileReader(t_Filename));
                    String t_CurrentMetadata = null;
                    while ((t_CurrentMetadata = t_Reader.readLine()) != null) {
                        if  (t_CurrentMetadata.startsWith("#")) {
                            continue;
                        }
                        IConstraint t_NewConstraint = null;
                        String t_MetadataString = t_CurrentMetadata;
                        switch (t_ConstraintId) {
                            case 1: t_NewConstraint = new FDConstraint(t_MetadataString);
                                    break;

                            case 2: t_NewConstraint = new UniquenessConstraint(t_MetadataString);
                                    break;

                            case 3: t_NewConstraint = new NotNullConstraint(t_MetadataString);
                                    break;

                            case 4: t_NewConstraint = new EntityIntegrityConstraint(t_MetadataString);
                                    break;

                            case 5: t_NewConstraint = new DomainValueConstraint(t_MetadataString);
                                    break;

                            case 6: t_NewConstraint = new CardinalityConstraint(t_MetadataString);
                                    break;

                            case 7: t_NewConstraint = new ParticipationConstraint(t_MetadataString);
                                    break;

                            case 8: t_NewConstraint = new InclusionConstraint(t_MetadataString);
                                    break;

                            case 9: t_NewConstraint = new CoveringConstraint(t_MetadataString);
                                    break;

                            case 10: t_NewConstraint = new ReferentialConstraint(t_MetadataString);
                                     break;
                        }
                        t_NewConstraint.parseMetadata();
                        insertConstraint(t_ConstraintId, t_NewConstraint.getId(), t_NewConstraint);
                    }
                    t_Reader.close();
                }
            }
            t_Br.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }        
    }
    
    public java.util.Vector<Report> checkAllConstraints(DBInstance p_DBInstance) {
        java.util.Vector<Report> t_ReportResult = new java.util.Vector<Report>();
        java.util.Enumeration t_ConstraintEnum = m_Constraints.keys();
        
        while (t_ConstraintEnum.hasMoreElements()) {
            
            int t_Elmt = (Integer)t_ConstraintEnum.nextElement();
            java.util.Hashtable t_Constraints = (java.util.Hashtable)m_Constraints.get(t_Elmt);
            java.util.Enumeration t_Const = t_Constraints.keys();
            
            while (t_Const.hasMoreElements()) {
                
                String t_Id = (String)t_Const.nextElement();
                IConstraint t_Instance = (IConstraint)t_Constraints.get(t_Id);
                
                if (!t_Instance.checkToDB(p_DBInstance)) {
                    t_ReportResult.add(t_Instance.generateReport());
                }
            }
        }
        
        return t_ReportResult;
    }
    
    private java.util.Hashtable<Integer, java.util.Hashtable<String, IConstraint>> m_Constraints;
}
