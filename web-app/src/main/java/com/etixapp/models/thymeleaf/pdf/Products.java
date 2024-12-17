package com.etixapp.models.thymeleaf.pdf;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	String pos;
	String referenzen;
	String beschreibung;

	String nettopreis;
	String menge;
	String einheit;

	String steuersatz;
	String nettobetrag;

}
