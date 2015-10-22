package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by 1002016 on 2015. 10. 22..
 */
public class HelloJpa {
    public static void main(String[] args) {
        System.out.println(11);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void logic(EntityManager em) {
//        Member guest1 = makeMember();
//        em.persist(guest1);
//
//        Member persistGuest1 = em.find(Member.class, guest1.getId());
//
//        System.out.println(String.format("%s 회원 영속화, 영속화 %s", guest1.getUserName(), guest1 == persistGuest1));
//
//        Restaurant restaurant1 = makeRestaurant();
//        em.persist(restaurant1);
//
//        Restaurant persistRestaurant1 = em.find(Restaurant.class, restaurant1.getId());
//
//        System.out.println(String.format("%s 식당 영속화, 영속화 %s", restaurant1.getName(), restaurant1 == persistRestaurant1));

        Reservation reservation = new Reservation();
        reservation.setDate(new Date());

        em.persist(reservation);

        Member guest1 = makeMember();
        guest1.setReservation(reservation);

        em.persist(guest1);
    }

    private static Restaurant makeRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setMaxNumberOfPeople(10);
        restaurant.setName("이가네양꼬치");
        return restaurant;
    }

    private static Member makeMember() {
        Member member = new Member();
        member.setUserName("김회련");
        member.setTel("01046940233");
        return member;
    }
}
