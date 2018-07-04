package com.dotsub.test.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dotsub.test.exception.EmptyFileException;
import com.dotsub.test.service.UploadService;

@RestController
public class UploadController {

	Logger LOGGER = Logger.getLogger(UploadController.class.getName());

	@Autowired
	private UploadService service;

	/**
	 * Upload and save a new file entity
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws EmptyFileException
	 */
	@PostMapping(consumes = { "multipart/mixed", "multipart/form-data" }, value = "/api/upload")
	ResponseEntity<Object> methodName(@RequestPart(value = "file") MultipartFile file) throws IOException, EmptyFileException {

		if (file.isEmpty()) {
			throw new EmptyFileException();
		}

		service.upload(file);
		return ResponseEntity.ok("File uploaded successfully");
	}
}