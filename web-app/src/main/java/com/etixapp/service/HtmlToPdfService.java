package com.etixapp.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.etixapp.models.thymeleaf.pdf.InvoiceExtendedDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HtmlToPdfService {

	//https://www.baeldung.com/thymeleaf-generate-pdf

	public String parseThymeleafTemplate(InvoiceExtendedDto data) {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);

		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("to", "Baeldung");
		context.setVariable("sections", data.getSections());
		context.setVariable("tableData", data.getTable());

		return templateEngine.process("templates/template", context);
	}

	public ResponseEntity<Resource> generatePdfFromHtml(InvoiceExtendedDto data) throws IOException {

		String html = parseThymeleafTemplate(data);
		saveHtmlFile("web-app/src/main/resources/test/test.html", html);

		String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
		OutputStream outputStream = new FileOutputStream(outputFolder);

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html, "file:web-app/src/main/resources/static/css");
		renderer.layout();
		renderer.createPDF(outputStream, true, 1);

		outputStream.close();

		InputStream inputStream = new FileInputStream(outputFolder);

		MultipartFile multipartFile = new MockMultipartFile("thymeleaf.pdf", "thymeleaf.pdf", "application/pdf",
				inputStream);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
		headers.setContentDispositionFormData("attachment", multipartFile.getName());
		return ResponseEntity.ok().headers(headers).body(multipartFile.getResource());
	}

	public static void saveHtmlFile(String filePath, String content) {
		File file = new File(filePath);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(content);
			System.out.println("HTML file saved successfully.");
		} catch (IOException e) {
			System.err.println("Error saving HTML file: " + e.getMessage());
		}
	}

}
