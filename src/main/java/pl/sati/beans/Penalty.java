package pl.sati.beans;


import javax.persistence.*;

@Entity
@Table(name="entry")
public class Penalty {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String reason;

    @Column(nullable = false, precision=10, scale=2)
    private double ammount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="entryId")
    private Entry owner;

    // ... additional members, often include @OneToMany mappings
    protected Penalty() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public Long getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public double getAmmount() {
        return ammount;
    }

    public Entry getOwner() {
        return owner;
    }

    private Penalty(PenaltyBuilder builder) {
        this.reason = builder.reason;
        this.ammount = builder.ammount;
        this.owner = builder.owner;
    }


    public class PenaltyBuilder {
        private String reason;
        private double ammount;
        private Entry owner;

        public PenaltyBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public PenaltyBuilder setAmmount(double ammount) {
            this.ammount = ammount;
            return this;
        }

        public PenaltyBuilder setOwner(Entry owner) {
            this.owner = owner;
            return this;
        }

        public Penalty createPenalty() {
            return new Penalty(this);
        }
    }
}

