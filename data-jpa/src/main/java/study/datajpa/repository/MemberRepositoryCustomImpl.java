package study.datajpa.repository;

import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{
    private final  EntityManager em;

    public MemberRepositoryCustomImpl(EntityManager em){
        this.em = em;;
    }
    @Override
    public List<Member> findMemberCustom() {
        return null;
    }
}
