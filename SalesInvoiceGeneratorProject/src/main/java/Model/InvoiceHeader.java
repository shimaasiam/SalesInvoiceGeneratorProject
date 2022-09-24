/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class InvoiceHeader {
    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }
    
    public Double getTotal(){
        double total =0.0;
        for (int i =0; i< lines.size(); i++){
            InvoiceLine line = lines.get(i);
            total += line.getInvoiceTotal();
        }
        return total;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    } 

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
     @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNum=" + invoiceNum + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }
}
