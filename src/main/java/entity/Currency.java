package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @Column(name = "abbreviation")
    private String abbreviation;/// Currency abbreviation (e.g., 1.0 for USD, 0.85 for EUR)


    @Column(name = "name")
    private String name;        /// Currency name

    @Column(name = "rateToUSD")
    private Double rateToUSD;   /// Exchange rate to USD

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public Currency() {} // an empty Constructor for the Hibernate to be able to make new object

    // Getters and setters
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRateToUSD() {
        return rateToUSD;
    }

    public void setRateToUSD(Double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
