/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.RequestDAO;
import Utils.User_Manager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class RequestTableModel extends AbstractTableModel {

    public RequestTableModel() {
    }

    private User user;
    private Map<String, List<Request>> requestMap = new HashMap<>();
    private List<Request> listRequest;

    public void setValue(String userID) {
        this.user = User_Manager.findUser_byID(userID);
        this.requestMap = RequestDAO.readRequestListAsChar();
        System.out.println("ID find" + userID);
        this.listRequest = this.requestMap.get(userID);
        for (Map.Entry<String, List<Request>> entry : requestMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        LocalDate now = LocalDate.now();
        listRequest.sort((a, b) -> {
            return a.getDateFrom().compareTo(b.getDateFrom());
        });

        for (Request request : listRequest) {
            Object[] row = new Object[]{};
            if (request.getStatus() == StatusType.APPROVED) {
                row = new Object[]{request.getDateFrom(), request.getDateTo(), request.getRequest(), request.getReason(), com.raven.model.StatusType.APPROVED};
            } else if (request.getStatus() == StatusType.PENDING) {
                row = new Object[]{request.getDateFrom(), request.getDateTo(), request.getRequest(), request.getReason(), com.raven.model.StatusType.PENDING};
            } else {
                row = new Object[]{request.getDateFrom(), request.getDateTo(), request.getRequest(), request.getReason(), com.raven.model.StatusType.REJECT};
            }
            listRow.add(row);
        }

    }

    private List<Object[]> listRow = new ArrayList<Object[]>();
    private String[] columnHeader = {"Date From", "Date To", "Request Type", "Reason", "Status"};
    private static final int Status_Column = 4; // Assuming the "approve" column is the 3rd column (index 

//     @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        if (column == APPROVE_COLUMN && "approve".equalsIgnoreCase(value.toString())) {
//            component.setBackground(Color.GREEN);
//        } else {
//            component.setBackground(table.getBackground());
//        }
//        return component;
//    }
    @Override
    public int getRowCount() {
        return this.listRow.size();
    }

    @Override
    public int getColumnCount() {
        return this.listRow.get(0).length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.listRow.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return this.columnHeader[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.listRow.get(0)[columnIndex].getClass();
    }

    public Duty getUserAtRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < this.user.getDutyList().size()) {
            return this.user.getDutyList().get(rowIndex);
        }
        return null;
    }
}
