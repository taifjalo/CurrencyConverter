package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {

    private List<Currency> currencyList = new ArrayList<>();

    public CurrencyModel() {
        // Adding some sample currencies to the list
        currencyList.add(new Currency("US Dollar", 1.0, "USD"));
        currencyList.add(new Currency("Euro", 0.85, "EUR"));
        currencyList.add(new Currency("British Pound", 0.75, "GBP"));
        currencyList.add(new Currency("Japanese Yen", 110.0, "JPY"));
        currencyList.add(new Currency("Canadian Dollar", 1.25, "CAD"));
        currencyList.add(new Currency("Swiss Franc", 0.92, "CHF"));
        currencyList.add(new Currency("Australian Dollar", 1.35, "AUD"));
        currencyList.add(new Currency("Chinese Yuan", 6.45, "CNY"));
        currencyList.add(new Currency("Indian Rupee", 74.0, "INR"));
        currencyList.add(new Currency("Mexican Peso", 20.0, "MXN"));
    }
    // Method to get the list of currencies
    public List<Currency> getCurrencyList() {
        return currencyList;
    }


}
