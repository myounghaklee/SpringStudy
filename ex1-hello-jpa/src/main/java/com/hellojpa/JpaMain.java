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

//            Member findMember = em.find(Member.class, 1L);
            List<Member> memberList = em.createQuery("select m from Member as m", Member.class).getResultList();
            for(Member m : memberList){
                System.out.println("findMember : " + m.getName());
            }

//            Member m = new Member();
//            m.setId(1L);
//            m.setName("hak");

//            em.persist(m);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
