package com.alex.model;

public record InvoiceFilter(
        String companyName,
        String cui,
        Double minAmount,
        Double maxAmount) {
}