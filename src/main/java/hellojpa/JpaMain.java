package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory db = Persistence.createEntityManagerFactory("ex1-hello");
        EntityManager dbManager = db.createEntityManager();

        EntityTransaction tx = dbManager.getTransaction();
        // 트랜잭션의 시작
        tx.begin();
        try {
            Member user = new Member();
            user.setId(1L);
            user.setName("haryu");

            Member user1 = new Member();
            user1.setId(2L);
            user1.setName("2");

            Member user2 = new Member();
            user2.setId(3L);
            user2.setName("haryu");

            dbManager.persist(user);
            dbManager.persist(user1);
            dbManager.persist(user2);

            // 성공적인 트랜잭션 이후 이를 커밋하여 트랜잭션을 종료한다.
            tx.commit();
        } catch (Exception e) {
            // 보통은 이런 식으로 에러 대응이 필요하다.
            System.out.println("문제로 롤백 함 : " + e.getMessage());
            tx.rollback();
        }
        tx.begin();

        Member findedMember = dbManager.find(Member.class, 1L);
        System.out.println("객체 찾기 : "+ findedMember.getIdAndName());

        List<Member> datas = dbManager.createQuery("select m from Member as m ", Member.class)
                .getResultList();

        for (Member member : datas) {
            System.out.println(member.getIdAndName());
        }


        tx.commit();

        dbManager.close();
        db.close();
    }
}
