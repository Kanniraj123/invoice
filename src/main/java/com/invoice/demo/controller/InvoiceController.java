package com.invoice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.demo.entity.Invoice;
import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.service.InvoiceService;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	// Handle the object creation to spring boot container
	@Autowired
	private InvoiceService service;

	@GetMapping("/customer/{customerId}")
	public Map<Long, TenderDetails> getInvoices(@PathVariable long customerId) throws FileNotFoundException {
		// Perform logic to retrieve invoices and tender types based on the customer ID
		Map<Long, TenderDetails> invoiceMap = new HashMap<>();
		//retriving inid 
		Long inid = service.getInvoiceId(customerId);
		
		//retirving tender details
		TenderDetails td = service.getTenderDetailsByCustId(customerId);

		if (inid == null && td == null)
			throw new FileNotFoundException();
		// frame a response in hashmap
		invoiceMap.put(inid, td);
		
		return invoiceMap;
	}
}
