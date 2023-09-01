package com.peazh.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class JBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	
	//최대 15자까지 설정
	@Column(length = 10)
	private String btitle;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String bcontent;
	
	// 마지막 수정시간으로 바꿔주기
	@LastModifiedDate
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime bdate;
	
	//멤버의 사람이 게시판에 여러개의 글을 쓸 수 있다는 뜻 = ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mno")
	private Member member;

}
