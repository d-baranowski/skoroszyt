package pl.sati.beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String fistName;
    @Column(nullable = false)
    private String lastName;

    // ... additional members, often include @OneToMany mappings
    protected Person() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public Person(String firstName, String lastName) {
        this.fistName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }
}
