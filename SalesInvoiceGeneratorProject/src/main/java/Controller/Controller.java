/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HeaderTableModel;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.LineTableModel;
import View.SalesInvoiceGeneratorFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Controller implements ActionListener {

    public SalesInvoiceGeneratorFrame frame;

    public Controller(SalesInvoiceGeneratorFrame frame) {
        this.frame = frame;
    }
    InvoiceHeader inv = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed ");
        String command = e.getActionCommand();
        // switch of returned action event and calling methods upon it
        switch (command) {
            // in case returned event is for load file action, the app will call load method
            case "L": {
                try {
                    loadFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            // in case returned event is for save file action, the app will call save invoices method
            case "S": {
                try {
                    saveInvoicesToFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            // in case returned event is for create new invoice button action, the app will call create method
            case "C":
                createNewInvoiceRowInTable();
                break;
            // in case returned event is for delete invoice button action, the app will call delete method
            case "D":
                deleteInvoiceFromTable();
                break;
            // in case returned event is for add new item button action, the app will call add item method
            case "A":
                AddInvoiceItemRowInTable();
                break;
            // in case returned event is for save item button action, the app will call save item method
            case "I": {
                try {
                    saveInvoiceItemsToFile();
                } catch (IOException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }

    // method to load csv invoices header file and fill in invoices table
    public void loadFile() throws FileNotFoundException, ParseException {
        // open file chooser and choose file and get file path
        JFileChooser choose = new JFileChooser();
        var result = choose.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = choose.getSelectedFile().getPath();
            // scan the file with determined path and save it in array string
            try ( Scanner sc = new Scanner(new File(path))) {
                String[] array;
                frame.getInvoices().clear();
                // loop over the file and check if there is lines to read it
                while (sc.hasNextLine()) {
                    // read each line of the file scanner 
                    String line = sc.nextLine();
                    // slit the columns of the file with , and add it to array string
                    array = line.split(",");
                    // read the data from array string and add it to data object
                    for (int i = 0; i < array.length; i++) {
                        // fill in the class of invoices header 
                        String numString = array[0];
                        String dateString = array[1];
                        String nameString = array[2];
                        Date invDate = frame.sdf.parse(dateString);
                        int invNumber = Integer.parseInt(numString);
                        inv = new InvoiceHeader(invNumber, invDate, nameString);
                        invoiceItemsPopulate2(invNumber);
                    }
                    frame.getInvoices().add(inv);
                }
                frame.setHeaderTableModel(new HeaderTableModel(frame.getInvoices()));
            }
        }
    }

    // method to fill in invoice items table 
    public void invoiceItemsPopulate() throws FileNotFoundException {
        InvoiceLine invLine = null;
        String path = System.getProperty("user.dir") + "\\InvoiceLine.csv";
        // scan the file with determined path and save it in array string
        try ( Scanner sc = new Scanner(new File(path))) {
            String[] array;
            // clear the table before load data
            inv.getLines().clear();
            // scan the lines of items file and split columns with 
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                array = line.split(",");
                // check if the invoice number equal the invoice number in items table to fill in data of this invoice
                if (frame.getInvoiceNumLb().getText().equals(array[0])) {
                    for (int i = 0; i < array.length; i++) {
                        //    data[i] = array[i];
                        // fill in the class of invoices lines
                        int lineNumber = Integer.parseInt(array[0]);
                        String nameString = array[1];
                        Double linePrice = Double.parseDouble(array[2]);
                        int lineCount = Integer.parseInt(array[3]);
                        InvoiceHeader invoice = frame.getInvoiceByNum(lineNumber);
                        invLine = new InvoiceLine(invoice, nameString, linePrice, lineCount);
                    }
                    inv.getLines().add(invLine);
                }
            }
            frame.setLineTableModel(new LineTableModel(inv.getLines()));
        }
    }

    public void invoiceItems() throws FileNotFoundException {
//        inv.getLines().clear();
        InvoiceHeader selectedInvoice = null;
        int x = Integer.valueOf(frame.getInvoiceNumLb().getText());
        for (int i = 0; i < frame.getInvoices().size(); i++) {
            if (x == frame.getInvoices().get(i).getInvoiceNum()) {
                selectedInvoice = frame.getInvoices().get(i);
                break;
            }
        }
        frame.setLineTableModel(new LineTableModel(selectedInvoice.getLines()));
    }

    public void invoiceItemsPopulate2(int invoiceNo) throws FileNotFoundException {
        InvoiceLine invLine = null;
        String path = System.getProperty("user.dir") + "\\InvoiceLine.csv";
        // scan the file with determined path and save it in array string
        try ( Scanner sc = new Scanner(new File(path))) {
            String[] array;
            // scan the lines of items file and split columns with 
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                array = line.split(",");
                // check if the invoice number equal the invoice number in items table to fill in data of this invoice
                if (Integer.parseInt(array[0]) == invoiceNo) {
                    for (int i = 0; i < array.length; i++) {
                        //    data[i] = array[i];
                        // fill in the class of invoices lines
                        int lineNumber = Integer.parseInt(array[0]);
                        String nameString = array[1];
                        Double linePrice = Double.parseDouble(array[2]);
                        int lineCount = Integer.parseInt(array[3]);
                        InvoiceHeader invoice = frame.getInvoiceByNum(lineNumber);
                        invLine = new InvoiceLine(invoice, nameString, linePrice, lineCount);
                    }
                    inv.getLines().add(invLine);
                }
            }
            frame.setLineTableModel(new LineTableModel(inv.getLines()));
        }
    }

//    public void ShowInvoiceLines(InvoiceHeader Invoice) {
//        frame.setLineTableModel(new LineTableModel(Invoice.getLines()));
//
//    }
    // method to save invoices from table to csv file
    public void saveInvoicesToFile() throws FileNotFoundException, IOException {
        String path = System.getProperty("user.dir") + "\\InvoiceHeader.csv";
        String csv = "";
        // loop on every row and colum of invoices table and save in string variable 
        for (int i = 0; i < frame.headerTableModel.getRowCount(); i++) {
            for (int j = 0; j < frame.headerTableModel.getColumnCount(); j++) {
                csv += frame.headerTableModel.getValueAt(i, j).toString() + ",";
            }
            csv += "\n";
        }
        // create writer file and assign determined file path 
        FileWriter saveFile = new FileWriter(new File(path));
        // fill in object of the file with data string of csv saved in pervious loop
        saveFile.write(csv);
        // show information message with saving success
        frame.getMessagePane().showMessageDialog(frame, "File Saved successfully");
        // please open the file and check the saved data 
        saveFile.flush();
        saveFile.close();
    }

    // method to add new empty row in invoices table and user could fill in it manually
    public void createNewInvoiceRowInTable() {
        Date today = new Date();
        frame.getInvoices().add(new InvoiceHeader(0, today, ""));
        frame.setHeaderTableModel(new HeaderTableModel(frame.getInvoices()));

    }

    // method to delete selected row from invoices table and clear related labels and invoice items
    public void deleteInvoiceFromTable() {
        // check if the selected row has value
        int row = frame.getInvoicesTable().getSelectedRow();
        if (row != -1) {
            int num = Integer.parseInt(frame.getInvoicesTable().getValueAt(row, 0).toString());
            System.out.println("num is " + num);
            InvoiceHeader inv = frame.getInvoiceByNum(num);
            // remove the selected row from invoices table
            frame.getInvoices().remove(row);
            // clear invoice labels of the selected invoice row 
            frame.getInvoiceNumLb().setText("");
            frame.getInvoiceDateLb().setText("");
            frame.getCustomerNameLb().setText("");
            frame.getInvoiceTotalLb().setText("");
            frame.headerTableModel.fireTableDataChanged();
            // clear invoice items related to that invoice row   
            inv.getLines().clear();
            frame.setLineTableModel(new LineTableModel(inv.getLines()));
            // information message that deletion done
            frame.getMessagePane().showMessageDialog(frame, "Invoice Deleted Successfully");
        }
    }

    // method to add new empty invoice item in items table and user could enter manaully 
    public void AddInvoiceItemRowInTable() {
        InvoiceHeader selectedInvoice = null;
        int x = Integer.valueOf(frame.getInvoiceNumLb().getText());
        for (int i = 0; i < frame.getInvoices().size(); i++) {
            if (x == frame.getInvoices().get(i).getInvoiceNum()) {
                selectedInvoice = frame.getInvoices().get(i);
                break;
            }
        }
        selectedInvoice.getLines().add(new InvoiceLine(selectedInvoice, "", 0.0, 0));
        frame.setLineTableModel(new LineTableModel(selectedInvoice.getLines()));
    }

    //  method to save data from invoice items table to csv file
    public void saveInvoiceItemsToFile() throws IOException {
        String path = System.getProperty("user.dir") + "\\InvoiceItem.csv";
        String csv = "";
        // looping over rows and columns and save to string var
        for (int i = 0; i < frame.lineTableModel.getRowCount(); i++) {
            for (int j = 0; j < frame.lineTableModel.getColumnCount(); j++) {
                csv += frame.lineTableModel.getValueAt(i, j).toString() + ",";
            }
            csv += "\n";
        }
        // write data to file object 
        FileWriter saveFile = new FileWriter(new File(path));
        saveFile.write(csv);
        // information message with saving success
        frame.getMessagePane().showMessageDialog(frame, "File Saved successfully");
        // please open the save file and check the data saved 
        saveFile.flush();
        saveFile.close();
    }

    // method for selecting row of ivoices table and fill in invoices labels and items table
    public void selectRow() {
        // get the selected row listener event and check it is returning value
        frame.getInvoicesTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && frame.getInvoicesTable().getSelectedRow() != -1) {
                    // fill in invoice labels with data of the selected invoice row 
                    frame.getInvoiceNumLb().setText(frame.getInvoicesTable().getValueAt(frame.getInvoicesTable().getSelectedRow(), 0).toString());
                    frame.getInvoiceDateLb().setText(frame.getInvoicesTable().getValueAt(frame.getInvoicesTable().getSelectedRow(), 1).toString());
                    frame.getCustomerNameLb().setText(frame.getInvoicesTable().getValueAt(frame.getInvoicesTable().getSelectedRow(), 2).toString());
                    frame.getInvoiceTotalLb().setText(frame.getInvoicesTable().getValueAt(frame.getInvoicesTable().getSelectedRow(), 3).toString());
                    try {
                        // call the invoice items method to fill in items table for the selected invoice row
                      //  invoiceItemsPopulate();
                      invoiceItems();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }
}
