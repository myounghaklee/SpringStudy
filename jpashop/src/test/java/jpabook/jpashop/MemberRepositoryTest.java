package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
//    @Autowired MemberRepository mr;
//
//
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember() throws Exception{
//        //given
//        Member m = new Member();
//        m.setUsername("memberA");
//        //when
//        Long savaId = mr.save(m);
//        Member findMember = mr.find(savaId);
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(m.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(m.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(m);
//    }

}