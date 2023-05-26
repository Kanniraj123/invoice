package com.invoice.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.invoice.demo.controller.InvoiceController;
import com.invoice.demo.entity.Invoice;
import com.invoice.demo.entity.TenderDetails;
import com.invoice.demo.service.InvoiceService;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvoiceControllerTest {

	@Mock
	private InvoiceService invoiceService;

	@InjectMocks
	private InvoiceController invoiceController;

	public InvoiceControllerTest() {
	    MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetTenderDetailsByCustomerId() throws FileNotFoundException {
	    long customerId = 1;

	    // Create sample tender details
	    Map<Long, TenderDetails> expectedTenderDetails = new HashMap<>();
	    TenderDetails td = new TenderDetails(23.43,"cash");
	    expectedTenderDetails.put(54L,td);

	    // Mock the tenderService to return the expected tender details
	    when(invoiceService.getTenderDetailsByCustId(anyLong())).thenReturn(td);

	    // Call the controller method
	    Map<Long, TenderDetails> actualTenderDetails = invoiceController.getInvoices(customerId);

	    // Verify the result
	    assertEquals(expectedTenderDetails, actualTenderDetails);
	}
}
