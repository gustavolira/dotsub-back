package com.dotsub.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotsub.test.entity.FileEntity;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FileEntityRepositoryTest {
	
	@Autowired
	private FileEntityRepository repository;
	
	@Test
	public void shouldSaveFileEntity() {
		FileEntity entity = new FileEntity("myfile.txt", "Dotsub project".getBytes());
		repository.save(entity);
		
		List<FileEntity> finded = repository.findByTitle("myfile.txt");
		
		assertThat(finded.get(0).getTitle()).isEqualTo("myfile.txt");
	}

}
