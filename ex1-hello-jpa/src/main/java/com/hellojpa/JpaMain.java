package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //프로젝트당 하나만
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //ㅈㅓ장
            Team t = new Team();
            t.setName("teamA");
            em.persist(t);

            Member m = new Member();
            m.setName("member1");
            m.setTeam(t);
            em.persist(m);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, m.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for(Member m1 : members){
                System.out.println("m1 =  : " + m1.getName());
            }
            //Team findTeam = findMember.getTeam();

            tx.commit(); //commit시점에 DB저장됨
            System.out.println("-------------");
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
