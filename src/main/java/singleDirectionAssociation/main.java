package singleDirectionAssociation;

import hellojpa.MemberOld;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory db = Persistence.createEntityManagerFactory("ex1-hello");
        EntityManager dbManager = db.createEntityManager();

        EntityTransaction tx = dbManager.getTransaction();
        // 트랜잭션의 시작
        tx.begin();
        try {

            Team team = new Team();
            team.setName("TeamA");
            dbManager.persist(team);

            Member member = new Member();
            member.setUsername("user1");
//            member.setTeamId(team.getId());
            member.setTeam(team);
            dbManager.persist(member);

            System.out.println(member.getTeam());

            tx.commit();
        } catch (Exception e) {
            // 보통은 이런 식으로 에러 대응이 필요하다.
            System.out.println("문제로 롤백 함 : " + e.getMessage());
            tx.rollback();
        }
        tx.begin();

        tx.commit();
        dbManager.close();
        db.close();
    }
}
