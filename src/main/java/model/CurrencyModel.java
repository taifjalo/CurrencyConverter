package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {

    private List<Currency> currencyList = new ArrayList<>();

    public CurrencyModel() {
        // Adding some sample currencies to the list
        currencyList.add(new Currency("USD", "US Dollar", 1.0));
        currencyList.add(new Currency("EUR", "Euro", 0.85));
        currencyList.add(new Currency("GBP", "British Pound", 0.75));
        currencyList.add(new Currency("JPY", "Japanese Yen", 110.0));
        currencyList.add(new Currency("CAD", "Canadian Dollar", 1.25));
        currencyList.add(new Currency("CHF", "Swiss Franc", 0.92));
        currencyList.add(new Currency("AUD", "Australian Dollar", 1.35));
        currencyList.add(new Currency("CNY", "Chinese Yuan", 6.45));
        currencyList.add(new Currency("INR", "Indian Rupee", 74.0));
        currencyList.add(new Currency("MXN", "Mexican Peso", 20.0));
    }
    // Method to get the list of currencies
    public List<Currency> getCurrencyList() {
        return currencyList;
    }


}
