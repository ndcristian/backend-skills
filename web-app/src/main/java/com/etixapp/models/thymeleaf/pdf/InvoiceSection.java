package com.etixapp.models.thymeleaf.pdf;

import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class InvoiceSection {
	String title;
	List<List<String>> data;
}
