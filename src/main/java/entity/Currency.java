package entity;

public class Currency {

    private String name;        /// Currency name
    private Double rateToUSD;   /// Exchange rate to USD
    private String abbreviation;/// Currency abbreviation (e.g., 1.0 for USD, 0.85 for EUR)

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
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

