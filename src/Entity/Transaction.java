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
public class Transaction {
    
    private int TranID;
    private int userID;
    private String CustomerName;
    private String CustomerPhone;
    private double TotalPrice;
    private String Time;

    public int getTranID() {
        return TranID;
    }

    public void setTranID(int TranID) {
        this.TranID = TranID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    
    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    public void add() {
        String strInsert = "insert into transaction values (" + TranID + "," + userID + ",'" +CustomerName + "','" + CustomerPhone + "'," +TotalPrice +",'" + Time + "')";
        boolean isAdd = DB.db.runNonQuery(strInsert);
        if (isAdd){
            //Tool.doneTone();
            Tool.msgBox("Transaction Is Added...");
        }
    }
    
   public void getAllRows(JTable table) {
        DB.db.fillToJTable("transaction", table);
    } 
   
   public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("transaction", "tranid");
        return Auto;
    }

 
}
