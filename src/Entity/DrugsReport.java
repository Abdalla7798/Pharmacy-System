/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import pharmacysystem.Tool.Table;

/**
 *
 * @author hp-
 */public class DrugsReport extends Report{
    
    public void addDrugReport(String select) {
        
        //String select = "select * from drug";
        Table val = DB.db.getTableData(select);// unique number
        
        int rows = val.Items.length;

        for (int i = 0; i < rows; i++){
            
           int DrugCode = Integer.parseInt((String)val.Items[i][0]);
           String DrugName = (String)val.Items[i][1];
           double Price = Double.parseDouble((String)val.Items[i][2]);
           int Amount = Integer.parseInt((String)val.Items[i][3]);
           String SideEffect = (String)val.Items[i][4];
           String Man_Company = (String)val.Items[i][5];
           String ExpireDate = (String)val.Items[i][6];
           String DrugTime = (String)val.Items[i][7];
           
           String strInsert = "insert into drugreport values ("+ ReportID + ","+ DrugCode + ",'" + DrugName + "'," +Price + "," + Amount + ",'" +SideEffect + "','" + Man_Company + "','" + ExpireDate + "','" + DrugTime+ "','"+ Time +"')";
           DB.db.runNonQuery(strInsert);
        }
    }
    
    public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("drugreport", "reportid");
        return Auto;
    }
}
