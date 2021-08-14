/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import pharmacysystem.Tool;

/**
 *
 * @author hp-
 */
public class TransactionsReport extends Report{
    
    public void addTransReport(String select) {
        
        //String select = "select * from drug";
        Tool.Table val = DB.db.getTableData(select);// unique number
        
        int rows = val.Items.length;

        for (int i = 0; i < rows; i++){
            
           int transid = Integer.parseInt((String)val.Items[i][0]);
           int userid = Integer.parseInt((String)val.Items[i][1]);
           String Custname = (String)val.Items[i][2];
           String Custphone = (String)val.Items[i][3];
           double TotalPrice = Double.parseDouble((String)val.Items[i][4]);
           String TranTime = (String)val.Items[i][5];
           
           String strInsert = "insert into transactionreport values ("+ ReportID + ","+ transid + "," + userid + ",'" + Custname + "','" + Custphone + "'," + TotalPrice+ ",'" + TranTime + "','"+ Time +"')";
           DB.db.runNonQuery(strInsert);
        }
    }
    
    public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("transactionreport", "reportid");
        return Auto;
    }
    
}
