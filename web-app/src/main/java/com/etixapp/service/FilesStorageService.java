package com.etixapp.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.etixapp.utils.FilesUtils;
import com.etixapp.utils.ItemTypes;

@Service
public class FilesStorageService {

	Logger logger = LoggerFactory.getLogger(FilesStorageService.class);

	private Path root;

	@Value("${images.folder}")
	private String rootPath;
	//  = "C:\\D\\raiseAway\\raiseAway\\libs\\assets\\webps";

	@Autowired
	private WebpConverterService converterService;


	public void init() {
		try {
			this.root = Paths.get(rootPath);
			Files.createDirectories(root);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	public void save(MultipartFile file, Long associatedItemId, ItemTypes itemType) {
		try {
			logger.info("Save file with associated item id:" + associatedItemId + " item type: " + itemType.getType());
			String fileName = FilesUtils.decodeFileName( file.getOriginalFilename());
			Path updatedFilePath = getUpdatedFilePath(fileName, associatedItemId, itemType);
			Files.createDirectories(this.root.resolve(updatedFilePath).getParent());
			Path filePath = this.root.resolve(updatedFilePath);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			converterService.convertImagesFromFolderToWebpAndResize(filePath.toString(), filePath.getParent().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException("A file of that name already exists.");
			}

			throw new RuntimeException(e.getMessage());
		}
	}

	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				logger.error("Could not read the file: " + filename + " full path: " + file.toString());
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public boolean delete(String filename) {
		try {
			logger.info("Deleted file with name: " + filename);
			Path file = root.resolve(filename);
			return Files.deleteIfExists(file);
		} catch (IOException e) {
			logger.error("Error delete file with name: " + filename + " .Error:" +e.getMessage(), e);
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public void deleteAll() {
		logger.info("Delete all files!");
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 3).filter(path -> !path.startsWith(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Could not load the files!");
		}
	}

	public Path getUpdatedFilePath(String oldPath, Long id, ItemTypes itemType) {
		String[] subfolders = oldPath.split("/");
		String fileName = subfolders[subfolders.length - 1];
		return Paths.get(itemType.getFolderName(), id.toString(), fileName);
	}

	public String getDatabaseFilePath(String oldPath, Long id, ItemTypes itemType) {
		String[] subfolders = oldPath.split("/");
		String fileName = subfolders[subfolders.length - 1];
		fileName = FilenameUtils.removeExtension(fileName) + WebpConverterService.WEBP_EXTENSION;
		return String.join("/",itemType.getFolderName(), id.toString(), fileName);
	}

	public void deteleAllForItemType(Long id, ItemTypes itemType) throws IOException {
		FileSystemUtils.deleteRecursively(root.resolve(Paths.get(itemType.getFolderName(), id.toString())));
	}

}
