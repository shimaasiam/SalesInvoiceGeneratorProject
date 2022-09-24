/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
public class SalesInvoiceGeneratorFrame extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form SalesInvoiceGeneratorFrame
     */
    public SalesInvoiceGeneratorFrame() throws FileNotFoundException {
        initComponents(); // to initiate the Frame components 
        // listener to load file menuitem in the menu and set action to it
        loadMenuItem.addActionListener(this);
        loadMenuItem.setActionCommand("L");
        // listener to save file menuitem in the menu and set action to it
        saveMenuItem.addActionListener((ActionListener) this);
        saveMenuItem.setActionCommand("S");
        // calling method listener to select invoices table row and fill invoice labels
        selectRow();
        // listener to create new invoice button and set action to it
        createInvoiceBtn.addActionListener(this);
        createInvoiceBtn.setActionCommand("C");
        // listener to delete invoice button and set action to it
        deleteInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn.setActionCommand("D");
        // listener to add invoice item button and set action to it
        addItemBtn.addActionListener(this);
        addItemBtn.setActionCommand("A");
        // listener to save invoice item button and set action to it
        saveItemBtn.addActionListener(this);
        saveItemBtn.setActionCommand("I");

    }

    /**
     * r
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messagePane = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceNumLb = new javax.swing.JLabel();
        invoiceDateLb = new javax.swing.JLabel();
        customerNameLb = new javax.swing.JLabel();
        invoiceTotalLb = new javax.swing.JLabel();
        invoicesTableLabel = new javax.swing.JLabel();
        itemTableLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        createInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn = new javax.swing.JButton();
        saveItemBtn = new javax.swing.JButton();
        cancelChangesItemsBtn = new javax.swing.JButton();
        addItemBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Number", "Date", "Customer Name"
            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        invoiceNumLb.setText(".");

        invoiceDateLb.setText(".");

        customerNameLb.setText(".");

        invoiceTotalLb.setText(".");

        invoicesTableLabel.setText("Invoices Table");

        itemTableLabel.setText("Invoice Items");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Number", "Item Name", "Price", "Count"
            }
        ));
        jScrollPane2.setViewportView(itemsTable);

        createInvoiceBtn.setLabel("Create New Invoice");

        deleteInvoiceBtn.setLabel("Delete Invoice");

        saveItemBtn.setText(" Save Item");
        saveItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemBtnActionPerformed(evt);
            }
        });

        cancelChangesItemsBtn.setText("Cancel");

        addItemBtn.setText("Add Item");

        FileMenu.setText("File");

        loadMenuItem.setText("Load File");
        FileMenu.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        FileMenu.add(saveMenuItem);

        jMenuBar1.add(FileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoiceNumLb)
                                            .addComponent(invoiceDateLb)
                                            .addComponent(customerNameLb)
                                            .addComponent(invoiceTotalLb)))
                                    .addComponent(itemTableLabel)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(invoicesTableLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(createInvoiceBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteInvoiceBtn)
                        .addGap(134, 134, 134)
                        .addComponent(addItemBtn)
                        .addGap(34, 34, 34)
                        .addComponent(saveItemBtn)
                        .addGap(38, 38, 38)
                        .addComponent(cancelChangesItemsBtn)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoicesTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invoiceNumLb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDateLb)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerNameLb)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceTotalLb)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemTableLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteInvoiceBtn)
                    .addComponent(createInvoiceBtn)
                    .addComponent(cancelChangesItemsBtn)
                    .addComponent(addItemBtn)
                    .addComponent(saveItemBtn))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        saveItemBtn.getAccessibleContext().setAccessibleName("Save Item");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveItemBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // initate the app and load the frame form
                    new SalesInvoiceGeneratorFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton cancelChangesItemsBtn;
    private javax.swing.JButton createInvoiceBtn;
    private javax.swing.JLabel customerNameLb;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JLabel invoiceDateLb;
    private javax.swing.JLabel invoiceNumLb;
    private javax.swing.JLabel invoiceTotalLb;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel invoicesTableLabel;
    private javax.swing.JLabel itemTableLabel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JOptionPane messagePane;
    private javax.swing.JButton saveItemBtn;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    // action listener method
    @Override
    public void actionPerformed(ActionEvent e) {
        // switch of returned action event and calling methods upon it
        switch (e.getActionCommand()) {
            // in case returned event is for load file action, the app will call load method
            case "L": {
                try {
                    loadFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
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
    public void loadFile() throws FileNotFoundException {
        // open file chooser and choose file and get file path
        JFileChooser choose = new JFileChooser();
        var result = choose.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = choose.getSelectedFile().getPath();
            // scan the file with determined path and save it in array string
            try ( Scanner sc = new Scanner(new File(path))) {
                String[] array;
                // get the invoices table model 
                DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
                // loop over the file and check if there is lines to read it
                while (sc.hasNextLine()) {
                    // read each line of the file scanner 
                    String line = sc.nextLine();
                    // slit the columns of the file with , and add it to array string
                    array = line.split(",");
                    Object[] data = new Object[array.length];
                    // read the data from array string and add it to data object
                    for (int i = 0; i < array.length; i++) {
                        data[i] = array[i];
                    }
                    // fill in the invoices table row with data from file as per table model 
                    model.addRow(data);
                }
            }
        }
    }

    // method for selecting row of ivoices table and fill in invoices labels and items table
    public void selectRow() {
        // get the selected row listener event and check it is returning value
        invoicesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && invoicesTable.getSelectedRow() != -1) {
                    // fill in invoice labels with data of the selected invoice row 
                    invoiceNumLb.setText(invoicesTable.getValueAt(invoicesTable.getSelectedRow(), 0).toString());
                    invoiceDateLb.setText(invoicesTable.getValueAt(invoicesTable.getSelectedRow(), 1).toString());
                    customerNameLb.setText(invoicesTable.getValueAt(invoicesTable.getSelectedRow(), 2).toString());
                    try {
                        // call the invoice items method to fill in items table for the selected invoice row
                        invoiceItemsPopulate();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    // method to fill in invoice items table 
    public void invoiceItemsPopulate() throws FileNotFoundException {
        String path = System.getProperty("user.dir")+"\\InvoiceLine.csv";
        System.out.println(path);
        // scan the file with determined path and save it in array string
        try ( Scanner sc = new Scanner(new File(path))) {
            String[] array;
            // get the invoice items table model
            DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
            // clear the table before load data
            model.setRowCount(0);
            // scan the lines of items file and split columns with ,
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                array = line.split(",");
                Object[] data = new Object[array.length];
                // check if the invoice number equal the invoice number in items table to fill in data of this invoice
                if (invoiceNumLb.getText().equals(array[0])) {
                    for (int i = 0; i < array.length; i++) {
                        data[i] = array[i];
                    }
                    model.addRow(data);
                }
            }
        }
    }

    // method to add new empty row in invoices table and user could fill in it manually
    public void createNewInvoiceRowInTable() {
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
        model.addRow(new Object[]{"", "", ""});
    }

    // method to delete selected row from invoices table and clear related labels and invoice items
    public void deleteInvoiceFromTable() {
        // get model of invoices table
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
        // get model of invoice items table
        DefaultTableModel itemsModel = (DefaultTableModel) itemsTable.getModel();
        // check if the selected row has value
        if (invoicesTable.getSelectedRow() != -1) {
            // remove the selected row from invoices table
            model.removeRow(invoicesTable.getSelectedRow());
            // clear invoice labels of the selected invoice row 
            invoiceNumLb.setText("");
            invoiceDateLb.setText("");
            customerNameLb.setText("");
            // clear invoice items related to that invoice row
            itemsModel.setRowCount(0);
            // information message that deletion done
            messagePane.showMessageDialog(this, "Invoice Deleted Successfully");
        }
    }

    // method to save invoices from table to csv file
    public void saveInvoicesToFile() throws FileNotFoundException, IOException {
        String path = System.getProperty("user.dir")+"\\InvoiceHeader.csv";
        System.out.println(path);
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
        String csv = "";
        // loop on every row and colum of invoices table and save in string variable 
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                csv += model.getValueAt(i, j).toString() + ",";
            }
            csv += "\n";
        }
        // create writer file and assign determined file path 
        FileWriter saveFile = new FileWriter(new File(path));
        // fill in object of the file with data string of csv saved in pervious loop
        saveFile.write(csv);
        // show information message with saving success
        messagePane.showMessageDialog(this, "File Saved successfully");
        // please open the file and check the saved data 
        saveFile.flush();
        saveFile.close();
    }

    // method to add new empty invoice item in items table and user could enter manaully 
    public void AddInvoiceItemRowInTable() {
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        model.addRow(new Object[]{"", "", ""});
    }

    //  method to save data from invoice items table to csv file
    public void saveInvoiceItemsToFile() throws IOException {
        String path = System.getProperty("user.dir")+"\\InvoiceItem.csv";
        System.out.println(path);
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        String csv = "";
        // looping over rows and columns and save to string var
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                csv += model.getValueAt(i, j).toString() + ",";
            }
            csv += "\n";
        }
        // write data to file object 
        FileWriter saveFile = new FileWriter(new File(path));
        saveFile.write(csv);
        // information message with saving success
        messagePane.showMessageDialog(this, "File Saved successfully");
        // please open the save file and check the data saved 
        saveFile.flush();
        saveFile.close();
    }

}
