package practice_3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory db = Persistence.createEntityManagerFactory("ex1-hello");
        EntityManager dbManager = db.createEntityManager();

        EntityTransaction tx = dbManager.getTransaction();
        // 트랜잭션의 시작
        tx.begin();
        try {


            tx.commit();
        } catch (Exception e) {
            // 보통은 이런 식으로 에러 대응이 필요하다.
            System.out.println("문제로 롤백 함 : " + e.getMessage());
            tx.rollback();
        }
        dbManager.close();
        db.close();
    }
}
