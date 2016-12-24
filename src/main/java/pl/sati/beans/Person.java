package pl.sati.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy="owner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Entry> entryList;

    // ... additional members, often include @OneToMany mappings
    protected Person() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }
}
