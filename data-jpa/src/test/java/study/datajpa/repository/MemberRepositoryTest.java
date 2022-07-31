package study.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.Dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.spliterator;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired TeamRepository teamRepository;
    @Autowired MemberJpaRepository memberJpaRepository;
    @Test
    public void testMember(){
        Member member = new Member("enzo");
        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId()).get();
        assertThat(findMember.getId()).isEqualTo(member.getId());

    }

    @Test
    public void findMemberDto(){
        Team team = new Team("teaA");
        teamRepository.save(team);

        Member m1 = new Member("AAA", 10);
        m1.setTeam(team);
        memberRepository.save(m1);

        List<MemberDto> memberDto = memberRepository.findMemberDto();
        for(MemberDto m : memberDto){
            System.out.println(m);
        }
    }
    @Test
    @DisplayName("colection binding test")
    void findByNames(){
        Member m1 = new Member("aaa", 12);
        Member m2 = new Member("bbb", 13);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
        for(Member m : result){
            System.out.println(m);
        }

    }

    @Test
    void paging(){
        memberRepository.save(new Member("member1", 1));
        memberRepository.save(new Member("member2", 1));
        memberRepository.save(new Member("member3", 12));
        memberRepository.save(new Member("member4", 14));
        memberRepository.save(new Member("member5", 1));
        memberRepository.save(new Member("member6", 1));


        int age = 1;
        int offset =0;
        int limit =3;
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "username"));

        List<Member>members = memberJpaRepository.findByPage(age, offset,limit);
        int cnt = (int) memberJpaRepository.totalCount(1);

        assertEquals(4, members.size());
        assertEquals(4, cnt);

    }



}