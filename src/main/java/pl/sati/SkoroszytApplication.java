package pl.sati;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sati.repos.PeopleRepository;

@SpringBootApplication
public class SkoroszytApplication {

    private static final Logger log = LoggerFactory.getLogger(SkoroszytApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SkoroszytApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PeopleRepository repository) {
        return (args) -> {
            // save a couple of customers
            /*repository.save(new Person("Jack", "Bauer"));
            repository.save(new Person("Chloe", "O'Brian"));
            repository.save(new Person("Kim", "Bauer"));
            repository.save(new Person("David", "Palmer"));
            repository.save(new Person("Michelle", "Dessler"));*/

            // fetch all customers
            /*log.info("Customers found with findAll():");
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
            log.info("");*/
        };
    }


}
