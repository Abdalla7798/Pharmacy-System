/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Forms.frmLogin;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pharmacysystem.Tool;
import pharmacysystem.Tool.Table;


public class db {
    
    private static String url ="";
    public static String DBName = "pharmacysystem";
    private static Connection con ;
    
    private static void setURL (){
        url = "jdbc:mysql://localhost:3306/"+DBName+"?useUnicode=true&characterEncoding=UTF-8";// reach DB and make it support Arabic
    }
    
    private static void setConnection (){  //connect java with DB 
        
        try {
            setURL();
            con = DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
              Window win[] = Window.getWindows();
              if (win[0] instanceof frmLogin){
              Tool.msgBox("Usernmae Or Password Incorrect...");
              }
              else {
              Tool.msgBox(ex.getMessage());
              }
          }    
    }
    
    public static boolean runNonQuery (String sqlStatment){ // run without query like insert , update, delete
        
        try {
            
            setConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqlStatment);
            con.close();
            return true;
        }
        catch(SQLException ex){
            Tool.msgBox(ex.getMessage());
            return false;
        }
    }
    
    public static String getAutoNumber(String tableName, String columnName){
        
       try{
           setConnection();
           Statement stmt = con.createStatement();
           String strAuto = "select max("+columnName+")+1 as autoNum"+" from "+ tableName;
           stmt.executeQuery(strAuto);
           String Num="";
           while (stmt.getResultSet().next()){
              Num = stmt.getResultSet().getString("autoNum");
           }
           con.close();
           
           if(Num == null || "".equals(Num)){
                 return "1"; 
              } 
              else {
                  return Num;
              }
       } 
       catch(SQLException ex){
           Tool.msgBox(ex.getMessage());
           return "0";
       }
    }
    
    
    public static Table getTableData(String statement){
        Tool t =new Tool();
        try {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs=stmt.executeQuery(statement);
            ResultSetMetaData rsmd =rs.getMetaData();
            int c =rsmd.getColumnCount();
            
            Table table = t.new Table(c);
            while (rs.next()){
                Object row[] =new Object[c];
                for(int i =0 ; i < c ; i++){
                    row[i]=rs.getString(i+1);//(i+1) no.of column
                }
                table.addNewRow(row);
            }
            con.close();
            return table;
        }
        catch (SQLException ex){
            Tool.msgBox(ex.getMessage());
            return t.new Table(0);
        }
    }
    
   public static void fillToJTable(String tableNameOrSelectStatement , JTable table){
        try{
            
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String strSelect;
            if (tableNameOrSelectStatement.length() < 6){
                strSelect = "select * from "+tableNameOrSelectStatement;
            }
            else{
                String SPart = tableNameOrSelectStatement.substring(0, 7).toLowerCase() ;
            
                if ("select ".equals(SPart)){
                    strSelect = tableNameOrSelectStatement;
                }
                else {
                    strSelect = "select * from "+tableNameOrSelectStatement;
                }
            }
            
            rs = stmt.executeQuery(strSelect);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            
            Vector row = new Vector();
            model.setRowCount(0);
                
            while (rs.next()){
                row = new Vector(c);
                for (int i = 1 ; i <= c;i++){
                    row.add(rs.getString(i));
                }
                model.addRow(row);            
            }
            
            if (table.getColumnCount()!=c){
                Tool.msgBox("JTable Columns Not Equal To Query Columns Count\nJTable Columns Count Is: "+table.getColumnCount()+"\nQuery Colmuns Count Is: "+c);
            }
            con.close();
        }
        catch (SQLException ex){
            Tool.msgBox(ex.getMessage());
        }
    } 
      
   public static void fillComb(String tableName, String columnName , JComboBox combo){
     
        try {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs ;
            String strSelect;
            if(tableName.equals("drugreport") || tableName.equals("transactionreport") || tableName.equals("alert")){
               strSelect = "select "+columnName + " from "+ tableName + " GROUP BY " + columnName;    
            }
            else{
                
               strSelect = "select "+columnName + " from "+ tableName;
            }    
            
            rs=stmt.executeQuery(strSelect);
            // get the number of row
            rs.last(); //point cursor to the last row
            int c = rs.getRow();// get the current row
            rs.beforeFirst(); //put the cursor at the original location 

            String values []= new String [c];
            int i =0;
            
            if (tableName.equals("drugreport") || tableName.equals("transactionreport")){
               while (rs.next()){// pass all the result rows
                values[i]= "Report " + rs.getString(1); // 1 is the column index
                i++;
               } 
            }
            else if(tableName.equals("alert")){
               while (rs.next()){// pass all the result rows
                values[i]= "Alert " + rs.getString(1); // 1 is the column index
                i++;
               } 
            }
            else{
                while (rs.next()){// pass all the result rows
                values[i]=rs.getString(1); // 1 is the column index
                i++;
                }
            }
            
            con.close();
            combo.setModel(new DefaultComboBoxModel(values));
                       
        }
        catch(SQLException ex ){
            Tool.msgBox(ex.getMessage());
        }
    }
   
}
