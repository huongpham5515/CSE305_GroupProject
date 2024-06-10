/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form;

import Model.*;
import Utils.*;
import com.raven.datechooser.*;
import java.io.FileNotFoundException;
import java.time.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Form_Request extends javax.swing.JPanel {

    /**
     * Creates new form Form_2
     */
    public User user;
    private Map<String, List<Request>> listRequest = RequestDAO.readRequestListAsChar();
    public final int maxleaAv = 3;
    public int countApproved;

    public void setValue(User User) {
        this.user = User;
    }

    public void setNumApproved(int numApp) {
        this.countApproved = numApp;
    }

    public Form_Request() {
        initComponents();
        startDate.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    startDate.hidePopup();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startDate = new com.raven.datechooser.DateChooser();
        endDate = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder2 = new Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtstartDate = new Model.TFUse();
        txtendDate = new Model.TFUse();
        txtreason = new Model.TFUse();
        jLabel10 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        buttonEnd = new javax.swing.JButton();
        cbLeave = new javax.swing.JCheckBox();
        cbOverduties = new javax.swing.JCheckBox();
        resetBtn = new javax.swing.JButton();
        applyBtn = new javax.swing.JButton();

        startDate.setDateFormat("yyyy-MM-dd");
        startDate.setTextRefernce(txtstartDate);
        startDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startDateMouseClicked(evt);
            }
        });

        endDate.setDateFormat("yyyy-MM-dd");
        endDate.setTextRefernce(txtendDate);

        setBackground(new java.awt.Color(215, 244, 255));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUEST APPLICATION");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-application-20.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("End Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Start Date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Type of Request");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Reason");

        txtstartDate.setBackground(new java.awt.Color(208, 232, 247));
        txtstartDate.setForeground(new java.awt.Color(51, 51, 51));

        txtendDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtendDateActionPerformed(evt);
            }
        });

        txtreason.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtreason.setToolTipText("");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/requestIcon.png"))); // NOI18N

        buttonStart.setBackground(new java.awt.Color(234, 247, 253));
        buttonStart.setForeground(new java.awt.Color(51, 51, 51));
        buttonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-calendar-20.png"))); // NOI18N
        buttonStart.setBorder(null);
        buttonStart.setOpaque(true);
        buttonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonStartMouseClicked(evt);
            }
        });
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonEnd.setBackground(new java.awt.Color(234, 247, 253));
        buttonEnd.setForeground(new java.awt.Color(51, 51, 51));
        buttonEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-calendar-20.png"))); // NOI18N
        buttonEnd.setBorder(null);
        buttonEnd.setOpaque(true);
        buttonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEndActionPerformed(evt);
            }
        });

        cbLeave.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbLeave);
        cbLeave.setForeground(new java.awt.Color(51, 51, 51));
        cbLeave.setText("Leave");
        cbLeave.setBorder(null);
        cbLeave.setOpaque(true);
        cbLeave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbLeaveMouseClicked(evt);
            }
        });
        cbLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLeaveActionPerformed(evt);
            }
        });

        cbOverduties.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbOverduties);
        cbOverduties.setForeground(new java.awt.Color(51, 51, 51));
        cbOverduties.setText("Overduties");
        cbOverduties.setBorder(null);
        cbOverduties.setOpaque(true);
        cbOverduties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbOverdutiesMouseClicked(evt);
            }
        });
        cbOverduties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOverdutiesActionPerformed(evt);
            }
        });

        resetBtn.setBackground(new java.awt.Color(255, 255, 255));
        resetBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(76, 182, 208));
        resetBtn.setText("Reset");
        resetBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 182, 208), 3, true));
        resetBtn.setOpaque(true);
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        applyBtn.setBackground(new java.awt.Color(208, 232, 247));
        applyBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        applyBtn.setForeground(java.awt.Color.black);
        applyBtn.setText("Apply");
        applyBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(208, 232, 247), 3, true));
        applyBtn.setOpaque(true);
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtreason, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbLeave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbOverduties))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtendDate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtstartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtendDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLeave)
                            .addComponent(cbOverduties))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addComponent(txtreason, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtendDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtendDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtendDateActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        // TODO add your handling code here:
        startDate.showPopup();
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEndActionPerformed
        // TODO add your handling code here:
        endDate.showPopup();
    }//GEN-LAST:event_buttonEndActionPerformed

    private void cbLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLeaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLeaveActionPerformed

    private void cbOverdutiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOverdutiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOverdutiesActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        txtstartDate.setText(LocalDate.now().plusDays(1).toString());
        txtendDate.setText(LocalDate.now().plusDays(1).toString());
        cbLeave.setSelected(false);
        cbOverduties.setSelected(false);
        txtreason.setText("");
    }//GEN-LAST:event_resetBtnActionPerformed

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed

        try {
            String startdate = txtstartDate.getText();
            String enddate = txtendDate.getText();
            System.out.println(startdate);
            LocalDate start = LocalDate.parse(startdate);
            LocalDate end = LocalDate.parse(enddate);
            String reason = txtreason.getText();
            RequestType requestType = null;
            if (!check(start, end)) {
                JOptionPane.showMessageDialog(this, "You already have request this day", "Message", JOptionPane.ERROR_MESSAGE);
            } else if ((startdate.equals("")) || (enddate.equals(""))) {
                JOptionPane.showMessageDialog(this, "Choose your day", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (start.isBefore(LocalDate.now()) || start.isEqual(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "Start date cannot be before today or today", "Message", JOptionPane.ERROR_MESSAGE);
                txtstartDate.setText(LocalDate.now().toString());
            } else if (end.isBefore(start)) {
                JOptionPane.showMessageDialog(this, "End date cannot be before the start date", "Message", JOptionPane.ERROR_MESSAGE);
                txtendDate.setText(txtstartDate.getText());
            } else if (!cbLeave.isSelected() && !cbOverduties.isSelected()) {
                JOptionPane.showMessageDialog(this, "Choose your request type", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (reason.equals("")) {
                JOptionPane.showMessageDialog(this, "Please type your reason", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (cbOverduties.isSelected() && start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                JOptionPane.showMessageDialog(this, "The date you choose is not sunday, please choose again", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                if (cbLeave.isSelected()) {
                    requestType = RequestType.LEAVE;

                } else if (cbOverduties.isSelected()) {
                    requestType = RequestType.OVERDUTIES;
                }
                Request requestForm = new Request(start, end, requestType, reason);
//                if (start.getMonth().equals(end.getMonth()) && start.getMonth().equals(LocalDate.now().getMonth())) {
//                    if (countApproved >= maxleaAv && cbLeave.isSelected()) {
//                        requestForm.setStatus(StatusType.REJECTED);
//                    } else {
//                        requestForm.setStatus(StatusType.PENDING);
//                    }
//                } else {
                requestForm.setStatus(StatusType.PENDING);
//                }
                User_Manager.addRequest(user.getID(), requestForm);
                RequestDAO.saveRequestListAsChar(User_Manager.getListRequest());
                JOptionPane.showMessageDialog(this, "Send Request Successfull", "Message", JOptionPane.INFORMATION_MESSAGE);
                txtstartDate.setText(LocalDate.now().plusDays(1).toString());
                txtendDate.setText(LocalDate.now().plusDays(1).toString());
                cbLeave.setSelected(false);
                cbOverduties.setSelected(false);
                txtendDate.setEditable(true);
                buttonEnd.setEnabled(true);
                txtreason.setText("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Form_Request.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_applyBtnActionPerformed

    private void cbOverdutiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbOverdutiesMouseClicked
        String startdate = txtstartDate.getText();
        txtendDate.setText(startdate);
        txtendDate.setEnabled(false);
        txtendDate.setEditable(false);
        buttonEnd.setEnabled(false);
        endDate.setEnabled(false);
    }//GEN-LAST:event_cbOverdutiesMouseClicked
    public boolean check(LocalDate start, LocalDate end) {
        List<Request> list = listRequest.get(user.getID());
        for (Request request : list) {
            if (start.equals(request.getDateFrom()) || start.equals(request.getDateTo()) || end.equals(request.getDateTo())
                    || end.equals(request.getDateFrom())) {

                return false;
            }
        }
        return true;
    }
    private void buttonStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStartMouseClicked

    }//GEN-LAST:event_buttonStartMouseClicked

    private void startDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateMouseClicked

    }//GEN-LAST:event_startDateMouseClicked

    private void cbLeaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbLeaveMouseClicked
        // TODO add your handling code here:
        buttonEnd.setEnabled(true);
    }//GEN-LAST:event_cbLeaveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton buttonEnd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonStart;
    private javax.swing.JCheckBox cbLeave;
    private javax.swing.JCheckBox cbOverduties;
    private com.raven.datechooser.DateChooser endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private Swing.PanelBorder panelBorder2;
    private javax.swing.JButton resetBtn;
    private com.raven.datechooser.DateChooser startDate;
    private Model.TFUse txtendDate;
    private Model.TFUse txtreason;
    private Model.TFUse txtstartDate;
    // End of variables declaration//GEN-END:variables
}
