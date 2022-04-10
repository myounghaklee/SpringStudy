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

            Movie movie = new Movie();
            movie.setDirector("AAAA");
            movie.setActor("BBBB");
            movie.setName("야차");
            movie.setPrice(10000);
            em.persist(movie);

            //조회준비
            em.flush();
            em.clear();
            //조회
            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("-======findMovie : " + findMovie);
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
