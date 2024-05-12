package jpql;

import jakarta.persistence.*;

import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory db = Persistence.createEntityManagerFactory("ex1-hello");
        EntityManager em = db.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        // 트랜잭션의 시작
        tx.begin();
        try {
            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(10);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(13);
            em.persist(member2);

            em.flush();

            String query = "select concat(m.username, '(', m.age, ')') from Member m";
            List<String> result = em.createQuery(query, String.class).getResultList();
            for (String str : result) {
                System.out.println(str);
            }

            tx.commit();
        } catch (Exception e) {
            // 보통은 이런 식으로 에러 대응이 필요하다.
            System.out.println("문제로 롤백 함 : " + e.getMessage());
            tx.rollback();
        }
        em.close();
        db.close();
    }
}
