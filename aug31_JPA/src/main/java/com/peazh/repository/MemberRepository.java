package com.peazh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.peazh.entity.Member;

public interface MemberRepository extends Repository<Member, Long> {

	List<Member> findAll();

	void save(Member member);
	
	Member findByMid(String string);//id가 들어오면 해당 사용자의 정보 찾아오기

	List<Member> findTop5ByOrderByMnoDesc();
	
	//jsql
	// 추가 적으로 쿼리를 적어줄 수 있음
	// ?1 첫번째 파라미터, ?2 두번째 파라미터 라는 뜻, nativeQuery 내가 정의한 거 쓰겠습니다.
	@Query(value = "SELECT count(*) FROM jmember j WHERE j.mid=?1 AND j.mpw=?2", nativeQuery = true)
	int count(String mid, String mpw);

	Member findByMidAndMpw(String mid, String mpw);// mid,mpw값이 들어오면(로그인하면) 사용자의 정보 찾아오기 

}
