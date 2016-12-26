package pl.sati.makers;

import pl.sati.beans.Entry;
import pl.sati.beans.Person;
import pl.sati.pojos.Duration;
import pl.sati.pojos.PersonSummary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonSummaryMaker {
    private Map<Person,List<Entry>> personEntriesMap;

    public PersonSummaryMaker(List<Entry> entries){
        personEntriesMap = new HashMap<>();
        for (Entry entry: entries) {
            if (!personEntriesMap.containsKey(entry.getOwner())) {
                ArrayList<Entry> newList = new ArrayList<>();
                newList.add(entry);
                personEntriesMap.put(entry.getOwner(), newList);
            } else {
                List<Entry> personEntries = personEntriesMap.get(entry.getOwner());
                personEntries.add(entry);
            }
        }
    }

    public List<PersonSummary> getAllPeopleSummeries() {
        List<PersonSummary> summaries = new ArrayList<>();

        for (Person key : personEntriesMap.keySet()) {
            Duration hoursWokredSum = new Duration();
            int minutesWorkedSum = 0;
            int lackOfTok = 0;
            int absence = 0;
            double penaltyAndBonusSum = 0.00;

            for (Entry entry : personEntriesMap.get(key)) {
                if(entry.getReason().equals("Brak Obecnosci")) {
                    absence++;
                }
                if(entry.getReason().equals("Brak Toka")) {
                    lackOfTok++;
                }
                penaltyAndBonusSum+= entry.getPenaltyOrBonus();

                if (entry.getTimeFrom() != null && entry.getTimeTo() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    try {
                        Date from = sdf.parse(entry.getTimeFrom());
                        Date to = sdf.parse(entry.getTimeTo());

                        hoursWokredSum.add(new Duration(from.getTime(), to.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            summaries.add(new PersonSummary(key,lackOfTok, absence,hoursWokredSum, minutesWorkedSum, penaltyAndBonusSum));
        }

        return summaries;
    }
}
