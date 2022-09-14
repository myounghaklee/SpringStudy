package study.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.dto.MemberDto;
import study.querydsl.dto.QMemberDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {
    @Autowired
    EntityManager em;

    EntityManagerFactory emf;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    void startJPQL() {
        //member1 찾기
        Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();
        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void startQuerydsl() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QMember m = new QMember("m");

        Member findMember = queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void startQuerydsl_v2() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void resultFetch() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> fetch = queryFactory
                .selectFrom(member)
                .fetch();
        Member fetchOne = queryFactory
                .selectFrom(member)
                .fetchOne();
        Member fetchFirst = queryFactory
                .selectFrom(member)
                .fetchFirst();
        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();

        results.getTotal();
        List<Member> content = results.getResults();

        //아래 두개로 페이징 처리
        results.getOffset();
        results.getLimit();

    }

    /*
    회원 정렬 순서
    1. 회원 나이 낼림차순
    2. 회원 이름 올림차순
    2에서 회원 이름이 없으면 마지막에 출력( nulls last)
     */
    @Test
    void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("memeber5", 100));
        em.persist(new Member("memeber6", 100));

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        //when
        Member mem5 = result.get(1);

        //then
        assertThat(mem5.getUsername()).isEqualTo("member5");

    }

    @Test
    void paging1() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QueryResults<Member> resutl = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetchResults();

        assertThat(resutl.getTotal()).isEqualTo(4);
    }

    /*
    teamA에 속한 모든 회원 조회
     */
    @Test
    void join() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");

    }

    @Test
    void leftJoin() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .leftJoin(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");

    }

    /*
    연관 관계 없을때 join_theta
    회원의 이름이 팀 이름과 같은 회원 조회
     */
    @Test
    void theta_Join() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .leftJoin(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");

    }

    /**
     * 회원과 팀을 조인하면서 팀이름이 teamA인 팀만 조인, 회원은 모두조회
     * JPQL : select m, t from Member m left join m.team t on t.name ='teamA'
     */

    @Test
    public void join_on_filtering() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> result = queryFactory.select(member, team)
                .from(member)
                .leftJoin(member.team, team).on(team.name.eq("teamA"))
                .fetch();

        for (Tuple t : result) {
            System.out.println("result : " + t);
        }
    }

    /**
     * 연관관계 없는 엔티티 외부조인
     * 예) 회원의 이름과 팀의 이름이 같은 대상 외부조인
     * JPQL : select m, t from member m left join team t on m.username = t.name
     * SQL : select m.*, t.* from member m left join Team t on m.username = t.name
     *
     * @throws Exception
     */
    @Test
    void join_on_no_relation() throws Exception {
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();

        for (Tuple t : result) {
            System.out.println("tuple : " + t);
        }
    }

    /**
     * 페치조인 미적용 테스트 코드
     * 지연로딩으로 member, team sql 쿼리가 가각 실행 되는 코드
     */
    @Test
    void fetchJoinNo() throws Exception{
        em.flush();
        em.clear();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loadded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loadded).as("패치조인 미적용").isFalse();
    }

    @Test
    void fetchJoinUse() throws Exception{
        em.flush();
        em.clear();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        Member findMember = queryFactory
                .selectFrom(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loadded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loadded).as("패치조인 미적용").isFalse();
    }

    /**
     * 나이가 가장 많은 회원 조회
     */
    @Test
    void subQuery(){
        QMember memberSub = new QMember("memberSub");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        JPAExpressions
                                .select(memberSub.age.max())
                                .from(memberSub)
                ))
                .fetch();
        assertThat(result).extracting("age").containsExactly(40);
    }

    /**
     * 나이가 평균인 회원 조회
     */
    @Test
    void subQueryGoe(){
        QMember memberSub = new QMember("memberSub");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub)
                ))
                .fetch();
        assertThat(result).extracting("age").containsExactly(30,40);
    }

    /**
     * 나이가 20-40 사이인 회원 조회
     */
    @Test
    void subQueryIn(){
        QMember memberSub = new QMember("memberSub");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.in(
                        JPAExpressions
                                .select(memberSub.age)
                                .from(memberSub)
                                .where(memberSub.age.gt(10))
                ))
                .fetch();
        assertThat(result).extracting("age").containsExactly(20,30,40);
    }

    /**
     * case 문 사용하여 조회
     */
    @Test
    void simpleCaseQuery(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<String> result = queryFactory
                .select(member.age
                        .when(10).then("열살")
                        .when(20).then("스무살")
                        .when(30).then("늙")
                        .otherwise("더 늙ㅠㅠㅠ"))
                .from(member)
                .fetch();
    }

    @Test
    void complexCaseQuery(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<String> resutl = queryFactory
                .select(new CaseBuilder()
                        .when(member.age.between(0,20)).then("0-20살")
                        .otherwise("늙~~~~!!"))
                .from(member)
                .fetch();

    }

    /**
     * 문자 더하기
     */
    @Test
    void concatQuery(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        //{userName}_{age}
        List<String> result = queryFactory
                .select(member.username.concat("_").concat(member.age.stringValue()))
                .from(member)
                .fetch();
        for(String s : result ){
            System.out.println("s = " + s);
        }
    }

    @Test
    void simpleProjection(){
        List<String> result = queryFactory.select(member.username)
                .from(member)
                .fetch();

        //Member 객체 타입도 한개의 프로젝션이라고 한다
        List<Member> resultMember = queryFactory.select(member)
                .from(member)
                .fetch();

        for(Member s : resultMember){
            System.out.println("s = : "+ s);
        }
    }

    @Test
    void tupleProjection(){
        List<Tuple> result = queryFactory.select(member.username, member.age)
                .from(member)
                .fetch();

        for(Tuple t : result){
            String username =  t.get(member.username);
            Integer age = t.get(member.age);
            System.out.println("name = : "+ username + " age : = " + age);
        }
    }
    @Test
    void findDtoByJPQL(){
        List<MemberDto> result = em.createQuery("select new study.querydsl.dto.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                .getResultList();
        System.out.println(result);
    }
    @Test
    void findDtoBySetter(){
        List<MemberDto> result = queryFactory
                .select(Projections.bean(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();
        for(MemberDto dto : result){
            System.out.println(" dto : " + dto);
        }
    }

    @Test
    void findDtoByField(){
        List<MemberDto> result = queryFactory
                .select(Projections.fields(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();
        for(MemberDto dto : result){
            System.out.println(" dto : " + dto);
        }
    }

    @Test
    void findDtoByConstructor(){
        List<MemberDto> result = queryFactory
                .select(Projections.constructor(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();
        for(MemberDto dto : result){
            System.out.println(" dto : " + dto);
        }
    }

    @Test
    void findDtoByQueryProjectino(){
        List<MemberDto> result = queryFactory
                .select(new QMemberDto(member.username, member.age))
                .from(member)
                .fetch();
    }

    @Test
    void dynamicQuery_BooleanBuilder(){
        String usernameParam = "member1";
        Integer ageParam = 10;
        List<Member> result = searchMember1(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember1(String usernameCond, Integer ageCond) {
        BooleanBuilder builder = new BooleanBuilder();
        if(usernameCond != null){
            builder.and(member.username.eq(usernameCond));
        }

        if(ageCond != null){
            builder.and(member.age.eq(ageCond));
        }
        return queryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();
    }

    @Test
    void dynamicQuery_WhereParam(){
        String usernameParam = "member1";
        Integer ageParam = 10;
        List<Member> result = searchMember2(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember2(String usernameParam, Integer ageParam) {
        return queryFactory
                .selectFrom(member)
                .where(usernameEq(usernameParam), ageEq(ageParam))
                .fetch();

    }

    private Predicate usernameEq(String usernameParam) {
        if(usernameParam==null)
            return null;
        return member.username
                .eq(usernameParam);
    }

    private Predicate ageEq(Integer ageParam) {
        if(ageParam == null)return null;
        return member.age
                .eq(ageParam);
    }


}
