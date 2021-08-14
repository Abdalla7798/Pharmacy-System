/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import pharmacysystem.Tool;
import javax.swing.JTable;

public class Drug {
    
    private int DrugCode;
    private String DrugName;
    private double Price;
    private int Amount;
    private String SideEffect;
    private String Man_Company;
    private String ExpireDate;
    private String Time;

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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getSideEffect() {
        return SideEffect;
    }

    public void setSideEffect(String SideEffect) {
        this.SideEffect = SideEffect;
    }

    public String getMan_Company() {
        return Man_Company;
    }

    public void setMan_Company(String Man_Company) {
        this.Man_Company = Man_Company;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }
    
    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    public void add() {
        String strInsert = "insert into drug values ("+ DrugCode + ",'" + DrugName + "'," +Price + ",'" + Amount + "','" +SideEffect + "','" + Man_Company + "','" + ExpireDate + "','"+ Time +"')";
        boolean isAdd = DB.db.runNonQuery(strInsert);
        if (isAdd){
            //Tool.doneTone();
            Tool.msgBox("Drug Is Added...");
        }
    }
    
    public void update() {
        String strUpdate = "update drug set " + "drugname = '" + DrugName + "', price = " + Price + ", amount = " + Amount + ", sideeffect = '" + SideEffect + "' , mancompany = '" + Man_Company + "' , expiredate = '" + ExpireDate + "', time = '" + Time + "' where drugcode = " + DrugCode ;
        boolean isUpdate = DB.db.runNonQuery(strUpdate);
        if (isUpdate){
            //Tool.doneTone();
            Tool.msgBox("Drug Is Update...");
        }
    }
    
    public void getAllRows(JTable table) {
        DB.db.fillToJTable("drug", table);
    }
    
    public String getAutoNumber() {
        String Auto = DB.db.getAutoNumber("drug", "drugcode");
        return Auto;
    }
    
    public void getCustomRows(String statement, JTable table) {
     DB.db.fillToJTable(statement, table);
    }
    
    public String getValueByName(String name) {
        String select = "select drugcode from drug " + "where drugname = '" + name + "'";
        String val = (String)DB.db.getTableData(select).Items[0][0];// unique number
        return val;
    }

    
}
