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
}
