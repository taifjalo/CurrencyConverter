package controller;

import dao.CurrencyDao;
import entity.Currency;
import javafx.scene.control.Alert;

public class CurrencyController {

    private CurrencyDao dao = new CurrencyDao();

    public double convert(double amount, Currency source, Currency target) {
        if (source == null || target == null) return -1;

        double sourceRate = dao.findOne(source.getAbbreviation()).getRateToUSD();
        double targetRate = dao.findOne(target.getAbbreviation()).getRateToUSD();

        if (sourceRate <= 0 || targetRate <= 0) return -1;

        return amount * (targetRate / sourceRate);
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
