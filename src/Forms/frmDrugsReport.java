/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entity.DrugsReport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pharmacysystem.Tool;
import pharmacysystem.Tool.Table;

/**
 *
 * @author hp-
 */
public class frmDrugsReport extends javax.swing.JFrame {

    /**
     * Creates new form frmDrugsReport
     */
    int uID;
    String Uname;
    String type;
    
    public frmDrugsReport(int userID, String username, String type) {
        initComponents();
        this.uID = userID;
        this.Uname = username;
        this.type = type;
    }

    private frmDrugsReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new controls.JMyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrugReports = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxReports = new controls.JMyCombBox();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblDrugReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "DrugCode", "DrugName", "Price", "Amount", "SideEffect", "Comapany", "ExpireDate", "DrugTime", "ReportTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrugReports.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDrugReports);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Drugs Report");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbxReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxReportsActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel10.setText("Reports:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel10)
                                .addGap(46, 46, 46)
                                .addComponent(cbxReports, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 695, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(491, 491, 491))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(543, 543, 543))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DrugsReport DReport = new DrugsReport();
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Tool.openForm(new frmDrug_TranReport(this.uID, this.Uname, this.type));
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbxReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxReportsActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model =(DefaultTableModel)tblDrugReports.getModel();
        model.setNumRows(0);
        String report = cbxReports.getSelectedItem().toString();
        int reportID = Integer.parseInt(report.replaceAll("[^0-9]", ""));
        Table t = DB.db.getTableData("select * from drugreport where reportid = " + reportID);
        
        for (int i = 0 ; i < t.Items.length ; i++){
           model.addRow(new Object[]{t.Items[i][0], t.Items[i][1], t.Items[i][2], t.Items[i][3], 
               t.Items[i][4], t.Items[i][5], t.Items[i][6], t.Items[i][7], t.Items[i][8], t.Items[i][9]}); 
        }
        
        
    }//GEN-LAST:event_cbxReportsActionPerformed
    private static long getDateDiff(String start_date, String end_date, TimeUnit timeUnit) throws ParseException {
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
         Date d1 = sdf.parse(start_date); 
         Date d2 = sdf.parse(end_date);
         long diffInMillies = d2.getTime() - d1.getTime();
         
         return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

//        try {
//            
//        int start = 0;
//        int firstID = 0;
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
//        String Cpoint1 = " 08:00:00";
//        String Cpoint2 = " 17:00:00";
//        
//        String str = "select time from user where userid = 1";
//        Table t = DB.db.getTableData(str);
//        
//        String refTime = (String)t.Items[0][0]; // 2021-01-01 00:00:00
//        Date ref = f.parse(refTime);
//        Date d = new Date();
//        String currentTime = f.format(d);
//        
//        long noOfHours = getDateDiff(refTime, currentTime, TimeUnit.HOURS);
//                   
//        for (int i = 0 ; i < noOfHours; i++){
//            ref.setHours(ref.getHours()+1);
//            if (ref.getHours() == 8){
//                String sql = "select * from drug where time <= '" + f1.format(ref) + Cpoint1 + "'";
//                Table t1 = DB.db.getTableData(sql);
//                if (t1.Items.length != 0){
//                   String autonum = DReport.getAutoNumber();
//                   DReport.setReportID(Integer.parseInt(autonum));
//                   DReport.setTime(f1.format(ref) + Cpoint1);
//                   DReport.addDrugReport(sql);
//                   
//                   String strUpdate = "update user set " + "time = '" + f.format(ref) +"' where userid = 1";
//                   DB.db.runNonQuery(strUpdate);
//                   
//                   if (start == 0){
//                      firstID =  Integer.parseInt(autonum);
//                      start = 1;
//                   }
//                   
//                }    
//            }
//            else if (ref.getHours() == 17){
//                String sqlstr = "select * from drug where time <= '" + f1.format(ref) + Cpoint2 + "'";
//                Table t2 = DB.db.getTableData(sqlstr);
//                if (t2.Items.length != 0){
//                   String autonum = DReport.getAutoNumber();
//                   DReport.setReportID(Integer.parseInt(autonum));
//                   DReport.setTime(f1.format(ref) + Cpoint2);
//                   DReport.addDrugReport(sqlstr);
//                   
//                   String strUpdate = "update user set " + "time = '" + f.format(ref) +"' where userid = 1";
//                   DB.db.runNonQuery(strUpdate);
//                   
//                   if (start == 0){
//                      firstID =  Integer.parseInt(autonum);
//                      start = 1;
//                   }
//                }
//            }
//        }
//          
//        DB.db.fillComb("drugreport", "reportid", cbxReports);
//        if (start != 0){
//          cbxReports.setSelectedItem("Report " + firstID);  
//        }
//
//        } catch (ParseException ex) {
//            Tool.msgBox(ex.getMessage());
//        }
        DB.db.fillComb("drugreport", "reportid", cbxReports);
        String str = "select firstdrug from user where userid = 1";
        Table tb = DB.db.getTableData(str);
        int reportid = Integer.parseInt((String)tb.Items[0][0]);
        if (reportid != 0){
           cbxReports.setSelectedItem("Report " + reportid);
           String strUpdate = "update user set " + "firstdrug = 0 where userid = 1";
           DB.db.runNonQuery(strUpdate);
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDrugsReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDrugsReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDrugsReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDrugsReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDrugsReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private controls.JMyButton btnBack;
    private controls.JMyCombBox cbxReports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDrugReports;
    // End of variables declaration//GEN-END:variables
}