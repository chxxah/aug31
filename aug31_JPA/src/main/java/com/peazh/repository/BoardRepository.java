package com.peazh.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.peazh.entity.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jboard);

	List<JBoard> findAll();

	JBoard findByBno(int bno);


}
