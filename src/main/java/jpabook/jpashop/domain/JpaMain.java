package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 저장
            Member member = new Member();
            member.setName("memberA");
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            em.persist(order);

            em.flush();
            em.clear();

            Order findOrder = em.find(Order.class, order.getId());
            Member member1 = findOrder.getMember();
            System.out.println(member1.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
