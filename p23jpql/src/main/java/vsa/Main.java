package vsa;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Person> q = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> pl = q.getResultList();
        for (Person p : pl) {
            System.out.println(p.getName() + " zenaty=" + p.getMarried() + " narodeny=" + p.getBorn());
        }

        TypedQuery<Person> q1 = em.createNamedQuery("Person.findByName", Person.class);
        q1.setParameter("name", "Fero");
        for (Person p : q1.getResultList()) {
            System.out.println(p.getName() + " zenaty=" + p.getMarried() + " narodeny=" + p.getBorn());
        }

        TypedQuery<Person> q2 = em.createQuery("select p from Person p where p.born is null", Person.class);
        q2.getResultList().forEach(p -> {
            System.out.println(p.getName() + " zenaty=" + p.getMarried() + " narodeny=" + p.getBorn());
        });

        TypedQuery<Long> q3 = em.createQuery("select count(p) from Person p where p.salary < 1000", Long.class);
        System.out.println("" + q3.getSingleResult());
        
        // CV2-3
        System.out.println("\nCV2-3:");
        System.out.println("=========");
        TypedQuery<Person> q4 = em.createQuery("select p from Person p", Person.class);
        em.getTransaction().begin();
        for (Person p : q4.getResultList()) {
            System.out.println("old salary for " + p.getName() + " = " + p.getSalary());
            p.setSalary(p.getSalary() + 100);
            System.out.println("new salary for " + p.getName() + " = " + p.getSalary() + "\n");
        }
        em.getTransaction().commit();
        System.out.println("=========");
        TypedQuery<String> q5 = em.createQuery("select p.name from Person p where p.salary < 1000", String.class);
        System.out.println("plat menej ako 1000:");
        for (String s : q5.getResultList()) {
            System.out.println(s);
        }
        System.out.println("=========");
        TypedQuery<Double> q6 = em.createQuery("select sum(p.salary) from Person p", Double.class);
        System.out.println("celkova suma:\n" + q6.getSingleResult());
        em.close();
    }
    
}
