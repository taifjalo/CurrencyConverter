package controller;

import javafx.scene.control.Alert;
import model.Currency;

public class CurrencyController {

    public double convert(double amount, Currency source, Currency target) {
        if (source != null || target != null) {
            // Conversion logic using exchange rates
            return amount * (target.getRateToUSD() / source.getRateToUSD());
        } else {
            throw new IllegalArgumentException("Please select both currencies.");
        }
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Conversion Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
