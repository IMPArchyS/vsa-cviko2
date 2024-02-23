package entities;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2024-02-23T21:50:10")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, LocalDateTime> born;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, Double> salary;
    public static volatile SingularAttribute<Person, Boolean> married;

}