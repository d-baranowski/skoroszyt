package pl.sati.beans;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="entry")
public class Entry {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private boolean present;

    @Column(nullable = false)
    private Date date;

    @Column
    private Time timeFrom;
    @Column
    private Time timeTo;

    @Column
    private boolean passed;
}
