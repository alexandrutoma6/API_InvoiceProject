package com.alex.controller;

import com.alex.model.dto.InvoiceDto;
import com.alex.model.entity.Invoice;
import com.alex.model.mappers.InvoiceMapper;
import com.alex.service.InvoiceService;
import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    private final InvoiceService service;
    private final InvoiceMapper mapper;

    public InvoiceController(InvoiceService service, InvoiceMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<InvoiceDto> getInvoice() {
        return service.getAll().stream()
                .map(invoice -> mapper.toDto(invoice))
                .toList();
    }

    @PostMapping
    public Invoice addInvoice(@RequestBody InvoiceDto request) { return service.addInvoice(request);}


    @DeleteMapping("{invoiceId}")
    public List<InvoiceDto>  deleteInvoice(@PathVariable("invoiceId") Integer id){
        service.deleteInvoice(id);
        return service.getAll().stream()
                .map(invoice -> mapper.toDto(invoice))
                .toList();
    }

    @PutMapping("{invoiceId}")
    public Invoice updateInvoice(@PathVariable("invoiceId") Integer id,@RequestBody InvoiceDto updateRequest){
        return service.updateInvoice(updateRequest);
    }
}
