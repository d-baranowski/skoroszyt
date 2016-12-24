package pl.sati;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sati.beans.Entry;
import pl.sati.beans.Person;
import pl.sati.repos.EntryRepository;
import pl.sati.repos.PeopleRepository;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class SkoroszytApplication {

    private static final Logger log = LoggerFactory.getLogger(SkoroszytApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SkoroszytApplication.class, args);
    }

/*    @Bean
    public CommandLineRunner demo(EntryRepository entryRepository,
                                  PeopleRepository peopleRepository) {
        return (args) -> {

            Person zajebisty = peopleRepository.save(new Person("Jan","Kowalski"));
            Person chujowy = peopleRepository.save(new Person("Jaroslaw","Kaczynski"));

            Entry dobry = entryRepository.save(new Entry.EntryBuilder()
                    .setDate(new Date(2016, 12, 21))
                    .setPassed(true)
                    .setPresent(true)
                    .setTimeFrom(new Time(9, 0, 0))
                    .setTimeTo(new Time(17, 0, 0))
                    .setOwner(zajebisty)
                    .setPenaltyOrBonus(100.00)
                    .createEntry());

            Entry zly = entryRepository.save(new Entry.EntryBuilder()
                    .setDate(new Date(2016, 12, 21))
                    .setPassed(false)
                    .setPresent(false)
                    .setOwner(chujowy)
                    .setPenaltyOrBonus(-1000000000)
                    .createEntry());

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Person customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Person customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Person bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }*/


}
