package jpaBook.jpashop;

import jpaBook.jpashop.domain.Member;
import jpaBook.jpashop.domain.Order;
import jpaBook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            List<Member> result = em.createQuery("select m From Member m where m.name like '%kim%'", Member.class)
                    .getResultList();

            for(Member m : result){
                System.out.println("member = "  + m);
            }
            tx.commit();
        }catch (Exception e ){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
