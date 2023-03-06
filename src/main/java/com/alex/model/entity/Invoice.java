package com.alex.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @SequenceGenerator(
            name = "invoice_id_sequence",
            sequenceName = "invoice_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_id_sequence"
    )
    private Integer id;
    private String companyName;
    private int cui;
    private double invoiceTotal;


    public Invoice(String companyName, int cui, double invoiceTotal) {
        this(null, companyName, cui, invoiceTotal);
    }

    public Invoice(Integer id, String companyName, int cui, double invoiceTotal) {
        this.id = id;
        this.companyName = companyName;
        this.cui = cui;
        this.invoiceTotal = invoiceTotal;
    }

    public Invoice() {
        this.id = id;
        this.companyName = companyName;
        this.cui = cui;
        this.invoiceTotal = invoiceTotal;
    }


    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCui() {
        return cui;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && cui == invoice.cui && Double.compare(invoice.invoiceTotal, invoiceTotal) == 0 && Objects.equals(companyName, invoice.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, cui, invoiceTotal);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", cui=" + cui +
                ", invoiceTotal=" + invoiceTotal +
                '}';
    }
}
