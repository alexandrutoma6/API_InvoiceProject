package com.alex.service;

import com.alex.exceptions.NotFoundException;
import com.alex.exceptions.ValidationException;
import com.alex.model.dto.InvoiceDto;
import com.alex.model.entity.Invoice;
import com.alex.repository.InvoiceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) { this.invoiceRepository = invoiceRepository;}

    public List<Invoice> getAll() { return invoiceRepository.findAll();}

    public Invoice addInvoice(InvoiceDto request) {
        validateInvoice(request);
        return invoiceRepository.save(new Invoice(request.companyName(), request.cui(), request.invoiceTotal()));
    }

    private void validateInvoice(@NotNull InvoiceDto request) {
        if(request.companyName() == null || request.companyName().isBlank() || request.companyName().length() < 2){
            throw new ValidationException("Please provide company name");
        }
    }

    private void notFoundInvoice(Integer id) {
        if(!invoiceRepository.existsById(id))
            throw new NotFoundException("The invoice with id " + id +"does not exist");
    }

    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice updateInvoice(InvoiceDto updateRequest) {
        //notFoundInvoice(updateRequest.id());
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(updateRequest.id());
        Invoice modifyInvoice = optionalInvoice.get();
        modifyInvoice.setCompanyName(updateRequest.companyName());
        modifyInvoice.setCui(updateRequest.cui());
        modifyInvoice.setInvoiceTotal(updateRequest.invoiceTotal());
        return invoiceRepository.save(modifyInvoice);
    }
}
