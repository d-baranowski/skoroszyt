package pl.sati.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.sati.beans.Person;

import java.util.List;

@RepositoryRestResource
public interface PeopleRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
}
