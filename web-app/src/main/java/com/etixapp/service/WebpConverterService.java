package com.etixapp.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebpConverterService {
	Logger logger = LoggerFactory.getLogger(WebpConverterService.class);

	public static final String WEBP_EXTENSION = ".webp";
	private static final Integer MAX_WIDTH = 1920;
	private static final Integer MAX_HEIGHT = 1080;
	private static final Integer QUALITY_CONVERSION = 80;

	@Value("${webpConverterExePath}")
	private String webpConverterExePath;

	public void convertImagesFromFolderToWebpAndResize(String filePath, String outputDirectory) {
		logger.info("Converting to webp: " + filePath + " outputFile: " + outputDirectory);
		File inputFile = new File(filePath);
		File outputDirectoryFile = new File(outputDirectory);
		if (!outputDirectoryFile.exists()) {
			outputDirectoryFile.mkdirs();
		}
		try {
			BufferedImage originalImage = ImageIO.read(inputFile);
			if (originalImage != null) {
				int originalWidth = originalImage.getWidth();
				int originalHeight = originalImage.getHeight();

				String webpPathFile = outputDirectoryFile.toString() + File.separator + getNameWithoutExtension(inputFile)
						+ WEBP_EXTENSION;
				if (MAX_WIDTH < originalWidth || MAX_HEIGHT < originalHeight) {
					double aspectRatio = (double) originalWidth / originalHeight;
					int targetWidth = originalWidth;
					int targetHeight = originalHeight;

					if (MAX_WIDTH < targetWidth) {
						targetWidth = MAX_WIDTH;
						targetHeight = (int) Math.ceil(targetWidth / aspectRatio);
					}
					if (MAX_HEIGHT < targetHeight) {
						targetHeight = MAX_HEIGHT;
						targetWidth = (int) Math.ceil(targetHeight * aspectRatio);
					}
					convertToWebpFile(inputFile.toString(), QUALITY_CONVERSION, webpPathFile, targetWidth,
							targetHeight);
				} else {
					convertToWebpFile(inputFile.toString(), QUALITY_CONVERSION, webpPathFile);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Converting finished successfuly!");
	}

	private void convertToWebpFile(String imageFilePath, int quality, String webpPathFile, Integer targetWidth,
			Integer targetHeight) throws IOException {
		CWebp cwebp = new CWebp(webpConverterExePath).quality(quality).input(imageFilePath)
				.resize(targetWidth, targetHeight).output(webpPathFile);
		cwebp.execute();
		File imageFile = new File(imageFilePath);
		imageFile.delete();
	}

	private void convertToWebpFile(String imageFilePath, int quality, String webpPathFile) throws IOException {
		CWebp cwebp = new CWebp(webpConverterExePath).quality(quality).input(imageFilePath).output(webpPathFile);
		cwebp.execute();
		File imageFile = new File(imageFilePath);
		imageFile.delete();
	}

	public String getNameWithoutExtension(File file) {
		return FilenameUtils.removeExtension(file.getName());
	}
}
