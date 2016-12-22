package pl.sati.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sati.beans.Person;
import pl.sati.repos.PeopleRepository;

@Controller
@RequestMapping("/web/people")
public class PeopleController {

    private final PeopleRepository repository;

    @Autowired
    PeopleController(PeopleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        Iterable<Person> allPeople = repository.findAll();
        model.addAttribute("allPeople", allPeople);
        return "allPeople";
    }

}