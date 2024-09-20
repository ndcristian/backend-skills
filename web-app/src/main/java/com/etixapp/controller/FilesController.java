package com.etixapp.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.etixapp.models.FileInfo;
import com.etixapp.service.FilesStorageService;
import com.etixapp.utils.FilesUtils;
import com.etixapp.utils.ItemTypes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@RequestMapping(path = "api/files")
public class FilesController {
	Logger logger = LoggerFactory.getLogger(FilesController.class);

	@Autowired
	FilesStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("associatedItemId") Long associatedItemId, @RequestParam("itemType") String itemType,
			HttpServletRequest request) {
		logger.info("Remote ip address: " + request.getRemoteAddr());
		String message = "";
		try {
			ItemTypes itemTypes = ItemTypes.findValueByType(itemType);
			storageService.save(file, associatedItemId, itemTypes);
			logger.info("User: " + request.getRemoteUser() + " successfully uploaded the file "
					+ file.getOriginalFilename());
			//			message = "uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			logger.info(
					"User: " + request.getRemoteUser() + " failed uploaded the file: " + file.getOriginalFilename());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile",
					path.getFileName().toString()).build().toString();

			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/files/**")
	public ResponseEntity<Resource> getFile(HttpServletRequest request) throws UnsupportedEncodingException {
		String fileName = new AntPathMatcher().extractPathWithinPattern(
				request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString(),
				request.getRequestURI());

		fileName = FilesUtils.decodeFileName(fileName);
		Resource file = storageService.load(fileName);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS))
				.body(file);
	}

	@DeleteMapping("/files/{filename:.+}")
	public ResponseEntity<String> deleteFile(@PathVariable String filename, HttpServletRequest request) {
		logger.info("Remote ip address: " + request.getRemoteAddr());

		String message = "";

		try {
			boolean existed = storageService.delete(filename);

			if (existed) {
				message = "Delete the file successfully: " + filename;
				logger.info("User: " + request.getRemoteUser() + " successfully deleted the file " + filename);
				return ResponseEntity.status(HttpStatus.OK).body(message);
			}

			message = "The file does not exist!";
			logger.info("User: " + request.getRemoteUser() + " no file to delete: " + filename);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info("User: " + request.getRemoteUser() + " Could not delete the file: " + filename + ". Error: "
					+ e.getMessage());
			message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}
}
