package com.alex.controller;

import com.alex.model.InvoiceFilter;
import com.alex.model.dto.InvoiceDto;
import com.alex.model.entity.Invoice;
import com.alex.model.mappers.InvoiceMapper;
import com.alex.service.InvoiceService;
import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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

   /* @GetMapping
    public List<InvoiceDto> getInvoice(InvoiceFilter invoiceFilter) {
        return service.getAll(invoiceFilter).stream()
                .map(mapper::toDto)
                .toList();
    }
    */

    @GetMapping
    public List<InvoiceDto> getInvoiceSorted() {
        return service.getAllSorted().stream()
                .map(invoice -> mapper.toDto(invoice))
                .toList();
    }

    @GetMapping("{invoiceId}")
    public Invoice getInvoiceById(@PathVariable("invoiceId") Integer id){
        return service.getById(id);
    }


    @PostMapping
    public Invoice addInvoice(@RequestBody InvoiceDto request) { return service.addInvoice(request);}


    @DeleteMapping("{invoiceId}")
    public List<InvoiceDto>  deleteInvoice(@PathVariable("invoiceId") Integer id){
        service.deleteInvoice(id);
        return service.getAllSorted().stream()
                .map(invoice -> mapper.toDto(invoice))
                .toList();
    }

    @DeleteMapping
    public String deleteAllInvoices(){
        service.deleteAllInvoices();
        return "ALL INVOICES DELETED";
    }

    @PutMapping("{invoiceId}")
    public Invoice updateInvoice(@PathVariable("invoiceId") Integer id,@RequestBody InvoiceDto updateRequest){
        return service.updateInvoice(updateRequest,id);
    }
}
