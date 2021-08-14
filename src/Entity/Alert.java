/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JComboBox;
import pharmacysystem.Tool;

/**
 *
 * @author hp-
 */
public class Alert {
    
    private int AlertID;

    public int getAlertID() {
        return AlertID;
    }

    public void setAlertID(int AlertID) {
        this.AlertID = AlertID;
    }
    
    public void addAlert(JComboBox combo) {
        
        String select = "select * from drug where amount = 0";
        Tool.Table val = DB.db.getTableData(select);

        int rows = val.Items.length;
        int start = 0;

        for (int i = 0; i < rows; i++){
            
           int DrugCode = Integer.parseInt((String)val.Items[i][0]);
           String DrugName = (String)val.Items[i][1];
           int Amount = Integer.parseInt((String)val.Items[i][3]);
           start = 1;

           String strInsert = "insert into alert values ("+ AlertID + ","+ DrugCode + ",'" + DrugName + "'," + Amount + ")";
           DB.db.runNonQuery(strInsert);
        }
        
        DB.db.fillComb("alert", "alertid", combo);
        if (start != 0){
          combo.setSelectedItem("Alert " + AlertID);
        }
    
    }
    
    public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("alert", "alertid");
        return Auto;
    }
    
}
