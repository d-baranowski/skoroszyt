package pl.sati.pojos;

import pl.sati.beans.Person;

public class PersonSummary {
    private Person person;
    private int absenceOfToksCount;
    private int absenceFromWorkCount;
    private int hourSum;
    private double penaltyAndBonusSum;

    public PersonSummary(Person person, int absenceOfToksCount, int absenceFromWorkCount, double penaltyAndBonusSum, int hourSum) {
        this.person = person;
        this.absenceOfToksCount = absenceOfToksCount;
        this.absenceFromWorkCount = absenceFromWorkCount;
        this.penaltyAndBonusSum = penaltyAndBonusSum;
        this.hourSum = hourSum;
    }

    public int getHourSum() {
        return hourSum;
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
