package pl.sati.beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="entry")
public class Entry {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column
    private String timeFrom;

    @Column
    private String timeTo;

    @Column
    private boolean passed;

    @Column
    private String reason;

    @Column
    private double penaltyOrBonus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="personId")
    private Person owner;

    // ... additional members, often include @OneToMany mappings
    protected Entry() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    private Entry(EntryBuilder entryBuilder) {
        this.date = entryBuilder.date;
        this.timeFrom = entryBuilder.timeFrom;
        this.timeTo = entryBuilder.timeTo;
        this.passed = entryBuilder.passed;
        this.reason = entryBuilder.reason;
        this.penaltyOrBonus = entryBuilder.penaltyOrBonus;
        this.owner = entryBuilder.owner;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public boolean isPassed() {
        return passed;
    }

    public String getReason() {
        return reason;
    }

    public double getPenaltyOrBonus() {
        return penaltyOrBonus;
    }

    public Person getOwner() {
        return owner;
    }

    public static class EntryBuilder {
        private boolean present;
        private Date date;
        private String timeFrom;
        private String timeTo;
        private boolean passed;
        private String reason;
        private double penaltyOrBonus;
        private Person owner;

        public EntryBuilder setOwner(Person owner) {
            this.owner = owner;
            return this;
        }

        public EntryBuilder setPenaltyOrBonus(double penaltyOrBonus) {
            this.penaltyOrBonus = penaltyOrBonus;
            return this;
        }

        public EntryBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public EntryBuilder setPresent(boolean present) {
            this.present = present;
            return this;
        }

        public EntryBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public EntryBuilder setTimeFrom(String timeFrom) {
            this.timeFrom = timeFrom;
            return this;
        }

        public EntryBuilder setTimeTo(String timeTo) {
            this.timeTo = timeTo;
            return this;
        }

        public EntryBuilder setPassed(boolean passed) {
            this.passed = passed;
            return this;
        }

        public Entry createEntry() {
            return new Entry(this);
        }
    }
}
