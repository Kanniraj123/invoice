package com.invoice.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.invoice.demo.entity.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, Long> {
}
