package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.Dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserNameAndAgeGreaterThan(String username, int age);
    List<Member>findTop3HelloBy();
    List<Member> findByusername(@Param("username") String username);

    @Query("select m from Member m where m.username =: username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    //@query dto조회
    @Query("select m.username from Member m")
    List<Member> findUsernameList();

    @Query("select new study.datajpa.Dto.MemberDto (m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

}
