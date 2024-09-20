package com.etixapp.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import com.etixapp.controller.FilesController;

public class FilesUtils {
	public static final String PATH_SEPARATOR = "/";

	public static final String getFileDownloadPath() {
		String url = MvcUriComponentsBuilder
				.fromMethodName(FilesController.class, "getFile", "").build().toString();

		return StringUtils.substringBeforeLast(url, PATH_SEPARATOR) + PATH_SEPARATOR;
	}

	public static final String decodeFileName(String encodedFileName) throws UnsupportedEncodingException {
		return URLDecoder.decode(encodedFileName, "UTF-8");
	}

	public static String encodeFileName(String fileName) throws UnsupportedEncodingException {
		return URLEncoder.encode(fileName, "UTF-8") ;
	}
}
