package Model;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ApproveColumnRenderer extends DefaultTableCellRenderer {
    private static final int APPROVE_COLUMN = 4; // Assuming the "approve" column is the 3rd column (index 2)

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == APPROVE_COLUMN && "APPROVED".equalsIgnoreCase(value.toString())) {
            component.setBackground(Color.GREEN);
        } else if(column == APPROVE_COLUMN && "REJECTED".equalsIgnoreCase(value.toString())) {
            component.setBackground(Color.RED);
        }else{
            component.setBackground(Color.YELLOW);
        }
        return component;
    }
}