package com.peazh.web.repository;

import org.springframework.data.repository.Repository;

import com.peazh.web.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jboard);

}
