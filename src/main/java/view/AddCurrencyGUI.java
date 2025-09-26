package view;

import dao.CurrencyDao;
import entity.Currency;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddCurrencyGUI extends Stage {

    public AddCurrencyGUI(CurrencyDao currencyDao) {
        setTitle("Add New Currency");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label lblAbbr = new Label("Abbreviation:");
        TextField tfAbbr = new TextField();

        Label lblName = new Label("Name:");
        TextField tfName = new TextField();

        Label lblRate = new Label("Rate to USD:");
        TextField tfRate = new TextField();

        Button btnSave = new Button("Save");

        grid.add(lblAbbr, 0, 0);
        grid.add(tfAbbr, 1, 0);
        grid.add(lblName, 0, 1);
        grid.add(tfName, 1, 1);
        grid.add(lblRate, 0, 2);
        grid.add(tfRate, 1, 2);
        grid.add(btnSave, 1, 3);

        btnSave.setOnAction(e -> {
            try {
                String abbr = tfAbbr.getText().trim();
                String name = tfName.getText().trim();
                double rate = Double.parseDouble(tfRate.getText().trim());

                if (abbr.isEmpty() || name.isEmpty()) {
                    showAlert("Error", "Please fill all fields.");
                    return;
                }

                Currency newCurrency = new Currency(abbr, name, rate);
                currencyDao.addOne(newCurrency);

                showAlert("Success", "Currency added successfully!");
                close(); // close window
            } catch (NumberFormatException ex) {
                showAlert("Error", "Rate must be a number.");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        setScene(scene);
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
