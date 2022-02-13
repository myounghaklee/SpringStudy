package jpabook.jpashop.domain.Service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("Lee");

        Long saveId = memberService.join(member);

        assertEquals(member, memberRepository.fineOne(saveId));

    }


    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외()throws Exception{
        Member mr1 = new Member();
        mr1.setName("Lee1");
        Member mr2 = new Member();
        mr1.setName("Lee1");

        memberService.join(mr1);
        memberService.join(mr2); //예외 발생해야됨.
        fail("예외가 발생해야 한다.");
    }


}