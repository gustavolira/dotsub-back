package com.dotsub.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void shouldUploadFile() throws Exception {
		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Dotsub".getBytes());
		
        this.mvc.perform(multipart("/api/upload").file(multipartFile))
        .andExpect(status().isOk()).andExpect(content().string("File uploaded successfully"));
		
	}
	
	@Test
	public void shouldUploadFileAndReturn() throws Exception {
		MockMultipartFile multipartFile = new MockMultipartFile("file", "",
                "text/plain", "".getBytes());
		
        this.mvc.perform(multipart("/api/upload").file(multipartFile))
        .andExpect(status().isBadRequest()).andReturn();
        
		
	}

}
