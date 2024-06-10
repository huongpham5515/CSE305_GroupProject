package Form;

import Model.Duty;
import Model.Model_Card;
import Model.Place;
import Model.Salary;
import Model.StatusType;
import Model.User;
import Swing.ScrollBar;
import Utils.UserDAO;
import java.awt.Color;
import java.text.ParseException;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Home extends javax.swing.JPanel {

    private User user;
    private Map<String, List<Duty>> listDuty = UserDAO.readDutyList();

    public int countApp;
    public final int maxNumofWork = 24;
    public final int maxAvailableLeave = 3;
    public int remain;
    public int fined = 0;

    public void setLeavetaken(int countApprove) {
        this.countApp = countApprove;

        Salary salary = new Salary();
        remain = maxAvailableLeave - countApp;
        if (remain < 0) {
            remain = countApp - maxAvailableLeave;
            fined = salary.getSalaryOneDay() * remain;
        }

        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/icons8-holiday-40.png")), "Number of Leaves Taken", String.valueOf(countApp)));
    }

    public void setValue(User User) throws ParseException {
        this.user = User;
    }

    public Home() throws ParseException {
        initComponents();

        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

    }

    public void refreshUI() throws ParseException {
        table.setRowCount(0);
        listDuty = UserDAO.readDutyList();
        dataTable(listDuty);
    }

    public void dataTable(Map<String, List<Duty>> listRequest) throws ParseException {
        int work = 0;
        int count = 0;
        for (Map.Entry<String, List<Duty>> entry : listDuty.entrySet()) {
            String userName = entry.getKey();
            if (userName.equals(user.getID())) {
                List<Duty> userDuties = entry.getValue();
                int i = 0;
                for (Duty duty : userDuties) {
                    LocalDate now = LocalDate.now();
                    Month month = now.getMonth();
                    LocalTime time = LocalTime.now();
                    LocalTime starttime = duty.getStartTime();
                    LocalTime endtime = duty.getEndTime();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String startFormat = starttime.format(formatter);
                    String endFormat = endtime.format(formatter);
                    LocalDate sevenDaysFromNow = now.plusDays(7);
                    if (duty.getDate().isEqual(now) && !(duty.getPlace().equals(Place.Null)) || duty.getDate().isAfter(now) && duty.getDate().isBefore(sevenDaysFromNow) && !(duty.getPlace().equals(Place.Null))) {
                        if (!duty.getPlace().equals(Place.LEAVE)) {
                            i++;
                            table.addRow(new Object[]{duty.getDate().toString(), duty.getPlace().toString(), startFormat, endFormat, null});

                        }

                    } else if ((duty.getDate().isAfter(now)) && !(duty.getPlace().equals(Place.Null))) {
                        if (!duty.getPlace().equals(Place.LEAVE)) {
                            table.addRow(new Object[]{duty.getDate().toString(), duty.getPlace().toString(), startFormat, endFormat, null});
                            i++;
                        }
                    }
                    if (duty.getDate().getMonth().equals(month)) {
                        if (!(duty.getPlace().equals(Place.Null))) {
                            if (!duty.getPlace().equals(Place.LEAVE)) {
                                work++;
                            }
                        }
                    }
//                    if (duty.getDate().isEqual(now) && time.isAfter(endtime) && !(duty.getPlace().equals(Place.Null))) {
//                        if (!duty.getPlace().equals(Place.LEAVE)) {
//                            work++;
//                        }
//                    }
                    if (i == 7) {
                        break;
                    }

                }

            }
        }

        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/2.png")), "Task done", Integer.toString(work)));
        Salary salary = new Salary();
        if (work == maxNumofWork) {
            if (salary.getBasicSalary() - fined < 0) {
                card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/icons8-salary-40.png")), "Salary of this Month", "$" + "0"));
            } else {
                card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/icons8-salary-40.png")), "Salary of this Month", "$" + Integer.toString(salary.getBasicSalary() - fined)));
            }
        } else {
            if (salary.getSalaryOneDay() * work - fined < 0) {
                card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/icons8-salary-40.png")), "Salary of this Month", "$" + "0"));
            } else {
                card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/icons8-salary-40.png")), "Salary of this Month", "$" + Integer.toString(salary.getSalaryOneDay() * work - fined)));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new Swing.Card();
        card2 = new Swing.Card();
        card3 = new Swing.Card();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new Swing.Table();

        setBackground(new java.awt.Color(215, 244, 255));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(0, 120, 168));
        card1.setColor2(new java.awt.Color(1, 93, 130));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(0, 159, 178));
        card2.setColor2(new java.awt.Color(10, 143, 159));
        card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2MouseClicked(evt);
            }
        });
        panel.add(card2);

        card3.setColor1(new java.awt.Color(240, 128, 43));
        card3.setColor2(new java.awt.Color(221, 106, 18));
        panel.add(card3);

        jPanel1.setBackground(new java.awt.Color(14, 140, 127));
        jPanel1.setForeground(new java.awt.Color(14, 140, 127));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROUTINE");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Place", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked

    }//GEN-LAST:event_card2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Card card1;
    private Swing.Card card2;
    private Swing.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JScrollPane spTable;
    private Swing.Table table;
    // End of variables declaration//GEN-END:variables
}
