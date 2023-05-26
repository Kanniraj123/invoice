package com.invoice.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.repository.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
    private InvoiceRepository invoiceRepository;
	

    public TenderDetails getTenderDetailsByCustId(Long customer_id) {
        if(invoiceRepository.findById(customer_id).get() != null) {
        	return invoiceRepository.findById(customer_id).get().getInvoice_data().getTenderDetails();
        }
        return null;
    }


	public Long getInvoiceId(Long customer_id) {
		if(invoiceRepository.findById(customer_id).get() != null) {
			return invoiceRepository.findById(customer_id).get().getInvoice_id();
		}
		return null;
	}
	
	
}

