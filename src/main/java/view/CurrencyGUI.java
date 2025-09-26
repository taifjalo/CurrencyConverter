package view;

import controller.CurrencyController;
import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyGUI extends Application {

    private CurrencyDao currencyDao = new CurrencyDao();
    private CurrencyController controller = new CurrencyController();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        // Labels
        Label instructions = new Label("Enter amount, select currencies, then press Convert.");
        Label amountLabel = new Label("Amount:");
        Label sourceLabel = new Label("From:");
        Label targetLabel = new Label("To:");
        Label resultLabel = new Label("Result:");

        // Text fields
        TextField amountField = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Choice boxes
        ChoiceBox<Currency> sourceBox = new ChoiceBox<>();
        ChoiceBox<Currency> targetBox = new ChoiceBox<>();

        // Load currencies from database
        List<Currency> currencyList = currencyDao.findAll();
        if (currencyList.isEmpty()) {
            controller.showError("No currencies found in the database!");
        } else {
            sourceBox.getItems().addAll(currencyList);
            targetBox.getItems().addAll(currencyList);
        }

        // Button
        Button convertButton = new Button("Convert");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(instructions, 0, 0, 2, 1);
        grid.add(amountLabel, 0, 1);
        grid.add(amountField, 1, 1);
        grid.add(sourceLabel, 0, 2);
        grid.add(sourceBox, 1, 2);
        grid.add(targetLabel, 0, 3);
        grid.add(targetBox, 1, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(resultField, 1, 4);
        grid.add(convertButton, 1, 5);

        // Event handling
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency source = sourceBox.getValue();
                Currency target = targetBox.getValue();
                double result = controller.convert(amount, source, target);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                controller.showError("Please enter a valid numeric amount.");
            } catch (Exception ex) {
                controller.showError(ex.getMessage());
            }
        });

        // Add this after convertButton
        Button btnAddCurrency = new Button("Add Currency");
        btnAddCurrency.setOnAction(e -> {
            AddCurrencyGUI addView = new AddCurrencyGUI(currencyDao);
            addView.showAndWait();
            // After closing the add window, refresh the list
            sourceBox.getItems().setAll(currencyDao.findAll());
            targetBox.getItems().setAll(currencyDao.findAll());
        });


        grid.add(btnAddCurrency, 1, 6);

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();








    }



    public static void main(String[] args) {
        launch();
    }
}
