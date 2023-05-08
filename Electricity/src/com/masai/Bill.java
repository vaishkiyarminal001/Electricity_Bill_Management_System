package com.masai;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String consumerUsername;
    private LocalDate dateGenerated;
    private double amount;
    private double adjustment;
    private double amountPaid;
    private LocalDate datePaid;
    private BillStatus status;

    public Bill(String consumerUsername, double amount, double adjustment) {
        this.id = UUID.randomUUID().toString();
        this.consumerUsername = consumerUsername;
        this.dateGenerated = LocalDate.now();
        this.amount = amount;
        this.adjustment = adjustment;
        this.amountPaid = 0;
        this.datePaid = null;
        this.status = BillStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "ID: " + id + "\n" +
                "Consumer Username: " + consumerUsername + "\n" +
                "Date Generated: " + dateGenerated.format(formatter) + "\n" +
                "Amount: " + amount + "\n" +
                "Adjustment: " + adjustment + "\n" +
                "Amount Paid: " + amountPaid + "\n" +
                "Date Paid: " + (datePaid != null ? datePaid.format(formatter) : "Not paid yet") + "\n" +
                "Status: " + status.toString() + "\n";
    }
}

