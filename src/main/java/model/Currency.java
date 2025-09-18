package model;

public class Currency {

    private String name;        /// Currency name
    private Double rateToUSD;   /// Exchange rate to USD
    private String abbreviation;/// Currency abbreviation (e.g., 1.0 for USD, 0.85 for EUR)

    Currency(String name, Double rateToUSD, String abbreviation) {
        this.name = name;
        this.rateToUSD = rateToUSD;
        this.abbreviation = abbreviation;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Double getRateToUSD() {
        return rateToUSD;
    }

    public String getAbbreviation() {
        return abbreviation;
    }


    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}

