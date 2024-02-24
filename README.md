# Entity a JPA anotácie
## Generovanie entitnej triedy
`New/Other/Persistence Entity class...` vytvorí základ entitnej triedy. Všimnite si : <br><br>
`interface Serializable`<br>
kľúčový atribút s anotáciami `@Id` a `@GeneratedValue`<br>
metódy `equals` a `hash` - zaručujú, že dva inštancie s rovnakým kľúčom predstavujú tú istú
entitu (záznam) v relačnej databáze

## JPQL dotazy
### Použitie pomenovaného dotazu
```java
TypedQuery<Person> q = em.createNamedQuery("Person.findAll", Person.class);
List<Person> pl = q.getResultList();
for (Person p : pl) {
System.out.println(p.getName() + " narodeny=" + p.getBorn());
}
```
### Použitie pomenovaného dotazu s parametrami
```java
TypedQuery<Person> q1 = em.createNamedQuery("Person.findByName",Person.class);
q.setParameter("name", "Fero");
```
### Vytvorenie JPQL-dotazu na vyhľadanie osôb bez dátumu narodenia
```java
TypedQuery<Person> q2 = em.createQuery(
"select p from Person p where p.born is null", Person.class);
```
### Vytvorenie JPQL-dotazu na zistenie počtu osôb s platom menším ako 1000
```java
TypedQuery<Long> q3 = em.createQuery(
"select count(p) from Person p where p.salary < 1000", Long.class);
System.out.println("" + q3.getSingleResult());
```
