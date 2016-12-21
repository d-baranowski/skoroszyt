package pl.sati.repos;

import org.springframework.data.repository.CrudRepository;
import pl.sati.beans.Person;

import java.util.List;

public interface PeopleRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
}
