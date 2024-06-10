/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Model.Duty;
import Model.Place;
import Model.Request;
import Model.SalaryAdmin;
import Model.SalaryInfomation;
import Model.User;
import Utils.RequestDAO;
import Utils.UserDAO;
import Utils.User_Manager;
import View.ViewRequest;
import com.raven.model.StatusType;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author RAVEN
 */
public class Form_3 extends javax.swing.JPanel {

    private List<SalaryInfomation> listSalary = new ArrayList<>();

    /**
     * Creates new form Form_1
     */
    public Form_3() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        List<User> listStaff = User_Manager.getListStaff();
        Map<String, List<Duty>> mapDuty = UserDAO.readDutyList();
        Map<String, List<Request>> mapRequest = RequestDAO.readRequestListAsChar();
        for (User user : listStaff) {
            int countPresent = 0;
            int countLeave = 0;
            int maxLeave = 3;
            List<Duty> staffdutyList = mapDuty.get(user.getID());
            for (Duty duty : staffdutyList) {
                if (duty.getDate().getMonth().equals(LocalDate.now().getMonth())) {
                    if (duty.getPlace() != Place.Null) {
                        if (duty.getPlace() != Place.LEAVE) {
                            countPresent++;
                            System.out.println("di lam");
                        } else {
                            countLeave++;
                            System.out.println("nghi lam");
                        }
                    } else {
                        System.out.println("chua co viec");
                    }

                }
            }
            System.out.println("count leave " + countLeave);
            System.out.println("max - leave " + (maxLeave - countLeave));
            int salary = countPresent * SalaryAdmin.getSalaryOneday() - Math.abs(maxLeave - countLeave) * SalaryAdmin.getSalaryOneday();

            this.table.addRow(new Object[]{user.getID(), user.getName(), countLeave, salary});
            this.listSalary.add(new SalaryInfomation(user.getID(), user.getName(), countLeave, salary));

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/budget.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("SALARY STATISTIC");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        spTable.setBorder(null);

        table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Number of leave days", "Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 890, 420));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-export-64.png"))); // NOI18N
        jButton1.setText("EXPORT");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//        // TODO add your handling code here:
//        if (evt.getClickCount() == 2) {
//            int selectedRow = table.getSelectedRow();
//            Object cellValue = table.getValueAt(selectedRow, 0); // Assuming the first column index is 0
//            if (cellValue != null) {
//                ViewRequest editFrame = new ViewRequest();
//                editFrame.setValue(cellValue.toString());
//                editFrame.setVisible(true);
//            }
//        }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserDAO.saveSalaryListAsChar(this.listSalary, LocalDate.now().getMonthValue());

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane spTable;
    private com.raven.swing.Table table;
    // End of variables declaration//GEN-END:variables
}