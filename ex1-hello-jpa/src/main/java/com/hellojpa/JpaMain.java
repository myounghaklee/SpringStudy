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
           Member m = new Member();
           m.setName("MEMBER1");
           em.persist(m);

           Team t = new Team();
           t.setName("TEAMa");
           t.getMembers().add(m);
           em.persist(t);
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
