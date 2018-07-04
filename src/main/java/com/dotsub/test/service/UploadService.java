package com.dotsub.test.service;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dotsub.test.controller.UploadController;
import com.dotsub.test.entity.FileEntity;
import com.dotsub.test.repository.FileEntityRepository;

@Service
public class UploadService {

	Logger LOGGER = Logger.getLogger(UploadController.class.getName());

	@Value("${storage}")
	private String storage;

	@Autowired
	private FileEntityRepository repository;

	/**
	 * Save a new file into database and store the file at directory configured at application.properties
	 * @param multipartFile
	 * @throws IOException
	 */
	public void upload(MultipartFile multipartFile) throws IOException {
		FileEntity fileEntity;
		fileEntity = new FileEntity(multipartFile.getOriginalFilename(), multipartFile.getBytes());
		repository.save(fileEntity);

		File newFile = new File(storage+"/"+multipartFile.getOriginalFilename());
		multipartFile.transferTo(newFile);

	}

}
