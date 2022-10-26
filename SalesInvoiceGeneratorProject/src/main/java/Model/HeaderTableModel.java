/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.SalesInvoiceGeneratorFrame;
import java.awt.Component;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class HeaderTableModel extends AbstractTableModel {

    String[] columns = {"Num", "Date", "Customer Name", "Invoice Total"};
    ArrayList<InvoiceHeader> headers;

    public HeaderTableModel(ArrayList<InvoiceHeader> header) {
        this.headers = header;
    }

    @Override
    public int getRowCount() {
        return headers.size();
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
        InvoiceHeader header = headers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return header.getInvoiceNum();
            case 1:
                return SalesInvoiceGeneratorFrame.sdf.format(header.getInvoiceDate());
            case 2:
                return header.getCustomerName();
            case 3:
                return header.getTotal();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        InvoiceHeader header = headers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                header.setInvoiceNum(Integer.parseInt(String.valueOf(aValue)));
                break;
            case 1: 
                  try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US).withResolverStyle(ResolverStyle.SMART);
                var cal = dateFormatter.parse(aValue.toString());
                header.setInvoiceDate(SalesInvoiceGeneratorFrame.sdf.parse(String.valueOf(aValue)));
            } catch (DateTimeException cc) {
                javax.swing.JOptionPane messagePane = new javax.swing.JOptionPane();
                Component _SalesInvoiceGeneratorFrame = null;
                messagePane.showMessageDialog(_SalesInvoiceGeneratorFrame, "Invalid Date Value Format ");
                header.setInvoiceDate(new Date());
            } catch (ParseException ex) {
                Logger.getLogger(HeaderTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 2:
                header.setCustomerName(String.valueOf(aValue));
                break;
        }
        fireTableRowsUpdated(rowIndex, columnIndex);
    }

}
