package com.alex.model.mappers;

import com.alex.model.dto.InvoiceDto;
import com.alex.model.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {
    public Invoice toDataBase(InvoiceDto source){
        return new Invoice(source.id(), source.companyName(),source.cui(), source.invoiceTotal());
    }

    public InvoiceDto toDto(Invoice source){
        return new InvoiceDto(source.getId(), source.getCompanyName(),source.getCui(), source.getInvoiceTotal());
    }
}
