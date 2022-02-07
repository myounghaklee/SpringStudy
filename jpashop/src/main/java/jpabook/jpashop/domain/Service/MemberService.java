package jpabook.jpashop.domain.Service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    /*
    회원가입
     */
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //exception
    }

    //전체회원 조회
}
