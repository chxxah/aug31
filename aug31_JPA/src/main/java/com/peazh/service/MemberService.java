package com.peazh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peazh.entity.Member;
import com.peazh.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	/* 	findAll()	전체 가져오기
	* 	findOne()	하나 가져오기
	 * 	save()		저장하기 / 수정하기
	 * 	count()		
	 * 	delete()	
	 * 
	 */
	public List<Member> findTop5ByOrderByMnoDesc() {
		return memberRepository.findTop5ByOrderByMnoDesc();
	}

	// findByMid는 where절로 mid를 기준으로 찾아달라는 말
	public Member findByMid(String mid) {
		return memberRepository.findByMid(mid);
	}

	public Member findByMidAndMpw(String mid, String mpw) {
		return memberRepository.findByMidAndMpw(mid, mpw);
	}

	public int count(Member member) {
		return memberRepository.count(member.getMid(), member.getMpw());
	}


}
