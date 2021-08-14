/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JTable;


public class Transaction_Druges {
    
    private int TranID;
    private int DrugCode;
    private String DrugName;
    private int Amount;

    
    public int getTranID() {
        return TranID;
    }

    public void setTranID(int TranID) {
        this.TranID = TranID;
    }

    public int getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(int DrugCode) {
        this.DrugCode = DrugCode;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
    public void add() {
        String strInsert = "insert into transaction_druges values ("+ TranID + "," + DrugCode +",'" + DrugName+ "'," + Amount +")";
        boolean isAdd = DB.db.runNonQuery(strInsert);
        if (isAdd){
            //Tools.msgBox("Phone Is Added...");
        }
    }
    
    public void getAllRows(JTable table) {
        String strSelect = "select drugname , amount from transaction_druges where tranid =  " + TranID;
        DB.db.fillToJTable(strSelect , table);
    }

}
