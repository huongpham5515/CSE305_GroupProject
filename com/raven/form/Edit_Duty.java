/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import Model.Duty;
import Model.Place;
import Model.User;
import Utils.UserDAO;
import Utils.User_Manager;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Edit_Duty extends javax.swing.JFrame {
    
    private String Date;
    private Place place;
    private User user;

    /**
     * Creates new form Edit_Duty
     */
    public void setValue(String Date, String startTime, String endTime, String place, User user) {
        this.Date = Date;
        this.user = user;
        this.Date_tf.setText(this.Date);
        this.starttime_tf.setText(startTime);
        this.endtime_tf.setText(endTime);
        this.place = UserDAO.getPlaceFromString(place);
        
    }
    
    public Edit_Duty() {
        initComponents();
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.Date_tf.setText(this.Date);
        this.Date_tf.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        Date_label = new javax.swing.JLabel();
        Place_label = new javax.swing.JLabel();
        Starttime_label = new javax.swing.JLabel();
        Endtime_label = new javax.swing.JLabel();
        Date_tf = new javax.swing.JTextField();
        starttime_tf = new javax.swing.JTextField();
        endtime_tf = new javax.swing.JTextField();
        place_cbbox = new javax.swing.JComboBox<>();
        add_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        close_btn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 200, 3));
        setPreferredSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 51));
        title.setText("EDIT STAFF DUTY");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        Date_label.setText("Date");
        getContentPane().add(Date_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 80, 34, -1));

        Place_label.setText("Place");
        getContentPane().add(Place_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 136, 34, -1));

        Starttime_label.setText("Start Time");
        getContentPane().add(Starttime_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 196, 178, -1));

        Endtime_label.setText("End Time");
        getContentPane().add(Endtime_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 253, 178, -1));
        getContentPane().add(Date_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 107, 178, -1));
        getContentPane().add(starttime_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 222, 178, -1));
        getContentPane().add(endtime_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 280, 178, -1));

        place_cbbox.setBackground(new java.awt.Color(0, 0, 51));
        place_cbbox.setForeground(new java.awt.Color(255, 255, 255));
        place_cbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "Canteen", "Maingate", "Subgate", "Block1", "Block2", "Block3", "Parking lot" }));
        getContentPane().add(place_cbbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 163, 178, -1));

        add_Button.setBackground(new java.awt.Color(0, 0, 51));
        add_Button.setForeground(new java.awt.Color(255, 255, 255));
        add_Button.setText("ADD");
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/save.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 50, 50));

        close_btn.setBackground(new java.awt.Color(0, 204, 204));
        close_btn.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        close_btn.setForeground(new java.awt.Color(0, 0, 0));
        close_btn.setText("CLOSE");
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        getContentPane().add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        // TODO add your handling code here:
        LocalDate date = LocalDate.parse(this.Date_tf.getText());
        Place place = UserDAO.getPlaceFromString(place_cbbox.getSelectedItem().toString());
        LocalTime startTime = LocalTime.parse(starttime_tf.getText());
        LocalTime endTime = LocalTime.parse(endtime_tf.getText());
        Duty newDuty = new Duty(date, place, startTime, endTime);
        boolean add = User_Manager.editDuty(this.user, newDuty);
        if (add == true) {
            JOptionPane.showMessageDialog(null, "Adding Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Adding UN.Successfully", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        Date_tf.setText("");
        starttime_tf.setText("");
        endtime_tf.setText("");
    }//GEN-LAST:event_add_ButtonActionPerformed

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Duty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Duty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Duty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Duty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Duty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date_label;
    private javax.swing.JTextField Date_tf;
    private javax.swing.JLabel Endtime_label;
    private javax.swing.JLabel Place_label;
    private javax.swing.JLabel Starttime_label;
    private javax.swing.JButton add_Button;
    private javax.swing.JButton close_btn;
    private javax.swing.JTextField endtime_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> place_cbbox;
    private javax.swing.JTextField starttime_tf;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
