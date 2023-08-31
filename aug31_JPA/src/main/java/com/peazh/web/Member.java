package com.peazh.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="jmember") //데이터베이스에서 이름을 members라고 해줬는데 클래스 이름이 member일 때 이렇게 명시해줌
public class Member {
	
	
	
	@Id//primary키라는 뜻
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
	private int mno;
	
	//길이 지정
	@Column(length = 10)
	private String mname;
	
	//데이터 베이스에서는 mid라고 부르지만 여기선 id로 부를게요라는 뜻
	@Column(unique = true)
	private String mid;
	
	//컬럼 종류 명시
	@Column(columnDefinition = "TEXT")
	private String mpw;
	
	@Column(columnDefinition = "TIMESTAMP")
	private String mjoindate;
	
	
	
}
