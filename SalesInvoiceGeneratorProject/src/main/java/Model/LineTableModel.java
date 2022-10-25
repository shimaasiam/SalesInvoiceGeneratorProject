/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class LineTableModel extends AbstractTableModel {

    String[] columns = {"Item Name", "Price", "Count", "Total"};
    ArrayList<InvoiceLine> lines;

    public LineTableModel(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return line.getItemName();
            case 1:
                return line.getItemPrice();
            case 2:
                return line.getCount();
            case 3:
                return line.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);
        switch (columnIndex) {
            case 0:
                line.setItemName(String.valueOf(aValue));
                break;
            case 1:
                line.setItemPrice(Double.valueOf(String.valueOf(aValue)));
                break;
            case 2:
                line.setCount(Integer.parseInt(String.valueOf(aValue)));
                break;
        }
        fireTableRowsUpdated(rowIndex, columnIndex);
    }

}
