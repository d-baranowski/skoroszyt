package pl.sati.pojos;

import pl.sati.beans.Entry;
import pl.sati.beans.Person;

import java.sql.Date;

public class PersonEntry {
    public Person person;
    public Entry entry;

    public boolean hasEntry() {
        return entry != null;
    }

    public boolean hasPerson() {
        return person != null;
    }

    public long getPersonId() {
        return person != null ? person.getId() : null;
    }

    public long getEntryId() {
        return entry != null ? entry.getId() : null;
    }

    public Date getDate() {
        return entry != null ? entry.getDate() : null;
    }

    public String getTimeFrom() {
        return entry != null ? entry.getTimeFrom() : null;
    }

    public String getTimeTo() {
        return entry != null ? entry.getTimeTo() : null;
    }

    public boolean isPassed() {
        return entry != null ? entry.isPassed() : null;
    }

    public String getReason() {
        return entry != null ? entry.getReason() : null;
    }

    public double getPenaltyOrBonus() {
        return entry != null ? entry.getPenaltyOrBonus() : null;
    }

    public Person getOwner() {
        return entry != null ? entry.getOwner() : null;
    }

    public String getFirstName() {
        return person != null ? person.getFirstName() : null;
    }

    public String getLastName() {
        return person != null ? person.getLastName() : null;
    }

    public PersonEntry(Person person, Entry entry) {
        this.person = person;
        this.entry = entry;
    }
}
