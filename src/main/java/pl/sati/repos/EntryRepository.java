package pl.sati.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.sati.beans.Entry;
import pl.sati.beans.Person;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource
public interface EntryRepository extends CrudRepository<Entry, Long> {
    // Enabling ignoring case for all suitable properties
    Entry findByOwnerAndDate(Person owner,Date date);

    List<Entry> findByDateBetween(Date start, Date end);
}
