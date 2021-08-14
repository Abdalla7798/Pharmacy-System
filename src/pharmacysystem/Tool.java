/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author hp-
 */
public class Tool {
    
    public static void msgBox (String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static boolean confirmMsg(String message){
      //ImageIcon icon = new ImageIcon(Tool.class.getResource("emp1.png"));
      int msgC = JOptionPane.showConfirmDialog(null, message, "Select an Option", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
        if (msgC == JOptionPane.YES_OPTION){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void openForm(JFrame form){
        
        try{
          form.setLocationRelativeTo(null);
          Image img = ImageIO.read(Tool.class.getResource("pharm.png"));
          form.setIconImage(img);
          form.setTitle("Pharmacy Management System");
          form.setDefaultCloseOperation(2);
          form.getContentPane().setBackground(Color.WHITE);
          form.setVisible(true);
          
        }catch(Exception ex){
           msgBox(ex.getMessage()); 
        }        
    }
    
    public class Table {
        
        public int columns;
        public Object[][] Items;
        
        public Table (int columns){
            this.columns = columns;
            Items =new Object[0][columns];
        }
        
        public void addNewRow (Object row []){
           Object TempItems [][] = Items;
           Items = new Object[Items.length+1][columns];
           for (int x=0 ; x< TempItems.length ; x++){
               Items[x]=TempItems[x];
           }
           Items[Items.length-1]=row;
           
        }
    }
    
    public static void clearText (Container form){
        for(Component c : form.getComponents()){
            if (c instanceof JTextField){
                JTextField txt = (JTextField)c;
                txt.setText("");
            }
            else if (c instanceof Container){
                clearText((Container) c);
            }
        }
    }
}
