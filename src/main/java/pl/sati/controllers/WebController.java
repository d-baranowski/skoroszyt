package pl.sati.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sati.beans.Person;
import pl.sati.pojos.PersonEntry;
import pl.sati.repos.EntryRepository;
import pl.sati.repos.PeopleRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private final PeopleRepository peopleRepository;
    private final EntryRepository entryRepository;

    @Autowired
    WebController(PeopleRepository peopleRepository,
                  EntryRepository entryRepository) {
        this.peopleRepository = peopleRepository;
        this.entryRepository = entryRepository;
    }

    @RequestMapping("/people")
    public String all(Model model) {
        Iterable<Person> allPeople = peopleRepository.findAll();
        model.addAttribute("allPeople", allPeople);
        return "allPeople";
    }

    @RequestMapping("/entries/{date}")
    public String entries(Model model,@PathVariable String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = sdf.parse(date);

        setupEntries(parsedDate.getTime(), model);

        return "entries";
    }

    @RequestMapping("/entries")
    public String entries(Model model) {
        long now = System.currentTimeMillis();

        setupEntries(now, model);

        return "entries";
    }

    private void setupEntries(long timestamp, Model model) {
        Date date = new Date(timestamp);

        Iterable<Person> allPeople = peopleRepository.findAll();
        List<PersonEntry> allEntries = new ArrayList<>();

        for (Person p : allPeople) {
            allEntries.add(new PersonEntry(p, entryRepository.findByOwnerAndDate(p,date)));
        }

        model.addAttribute("date",date);
        model.addAttribute("allEntries",allEntries);
    }
}