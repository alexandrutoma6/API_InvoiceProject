package com.alex.model.dto;

public record InvoiceDto(
        Integer id,
        String companyName,
        int cui,
        double invoiceTotal
) {
}
