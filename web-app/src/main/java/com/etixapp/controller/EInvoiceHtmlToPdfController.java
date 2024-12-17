package com.etixapp.controller;

import static lombok.AccessLevel.PRIVATE;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etixapp.models.thymeleaf.pdf.InvoiceExtendedDto;
import com.etixapp.service.HtmlToPdfService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/manage")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EInvoiceHtmlToPdfController {

	@Autowired
	HtmlToPdfService service;

	@PostMapping(value = "/generate-pdf")
	@Operation(summary = "Generate E-Invoice HTML to PDF")
	ResponseEntity<Resource> generatePDF(@RequestBody InvoiceExtendedDto invoiceRequest) throws IOException {
		log.info("Method generatePDF()");
		return service.generatePdfFromHtml(invoiceRequest);
	}
}
