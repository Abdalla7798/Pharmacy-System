/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JTable;
import pharmacysystem.Tool;

/**
 *
 * @author hp-
 */
public class PharmacyManager extends Pharmacist{
    
    public void add(User employee) {
        String strInsert = "insert into user values ("+ employee.getUserID() + ",'" + employee.getUserName() + "', " + "PASSWORD('" + employee.getPassword() +"'),'" + employee.getName() + "','" +employee.getAddress() + "','" + employee.getPhone() + "','" + employee.getType() + "', null,0, null,0)";
        boolean isAdd = DB.db.runNonQuery(strInsert);
        if (isAdd){
            Tool.msgBox("Employee Is Added...");
        }
    }
    
    public void delete(User employee) {
        String delete = "delete from user" + " where userid = " + employee.getUserID();
        boolean isDeleted = DB.db.runNonQuery(delete);
        if (isDeleted){
            Tool.msgBox("Employee Is Deleted...");
        }
    }
    
    public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("user", "userid");
        return Auto;
    }
    
}
