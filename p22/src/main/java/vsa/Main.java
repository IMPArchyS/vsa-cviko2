package vsa;

import entities.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        Person p;
        p = new Person();
        p.setName("Fero");
        //p.setBorn(new Date()); // Date
        //p.setBorn(LocalDate.now()); // LocalDate
        p.setBorn(LocalDateTime.now()); // LocalDateTime
        p.setMarried(false);
        p.setSalary(800.0);
        persist(p);

        p = new Person();
        p.setName("Eva");
        //p.setBorn(toDate(1997, 3, 10)); // Date 
        //p.setBorn(LocalDate.of(1997, 3, 10)); // LocalDate
        p.setBorn(LocalDateTime.of(1997, 3, 10, 12, 23, 20)); // LocalDateTime
        p.setMarried(true);
        p.setSalary(1200.0);
        persist(p);

        p = new Person();
        p.setName("Adam");
        persist(p);
    }

    private static Date toDate(int y, int m, int d) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, m, d, 0, 0, 0);
        return calendar.getTime();
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
