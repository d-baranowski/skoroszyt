package pl.sati.pojos;

import pl.sati.beans.Person;

public class PersonSummary {
    private Person person;
    private int absenceOfToksCount;
    private int absenceFromWorkCount;
    private Duration durationWorked;
    private double penaltyAndBonusSum;

    public PersonSummary(Person person, int absenceOfToksCount, int absenceFromWorkCount, Duration durationWorked, int minutesWorked, double penaltyAndBonusSum) {
        this.person = person;
        this.absenceOfToksCount = absenceOfToksCount;
        this.absenceFromWorkCount = absenceFromWorkCount;
        this.durationWorked = durationWorked;
        this.penaltyAndBonusSum = penaltyAndBonusSum;
    }

    public Duration getDurationWorked() {
        return durationWorked;
    }

    public String getDurationBreakdown(){
        return durationWorked != null ? durationWorked.getDurationBreakdown() : "";
    }

    public String getFirstName() {
        return person.getFirstName();
    }

    public String getLastName() {
        return person.getLastName();
    }

    public int getAbsenceOfToksCount() {
        return absenceOfToksCount;
    }

    public int getAbsenceFromWorkCount() {
        return absenceFromWorkCount;
    }

    public double getPenaltyAndBonusSum() {
        return penaltyAndBonusSum;
    }
}
