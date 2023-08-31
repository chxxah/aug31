package com.peazh.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	
	//최대 15자까지 설정
	@Column(length = 10)
	private String btitle;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String bcontent;
	
	@Column(columnDefinition = "TIMESTAMP")
	private String bdate;
	
	private String mname;

}
