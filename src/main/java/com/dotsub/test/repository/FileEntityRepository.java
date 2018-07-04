package com.dotsub.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dotsub.test.entity.FileEntity;

public interface FileEntityRepository extends CrudRepository<FileEntity, Integer> {
	
	public List<FileEntity> findByTitle(String title);

}
