package dev.salmonllama.snack.scenes;

import dev.salmonllama.snack.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SnackController implements Initializable {
    @FXML
    private Label pricesLabel;

    @FXML
    private Label drinksLabel;

    @FXML
    private TextField drinksField;

    @FXML
    private Label chipsLabel;

    @FXML
    private TextField chipsField;

    @FXML
    private Button calcButton;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        String prices = String.format("Drinks are %.2f each. Chips are %.2f each.", Constants.DRINK_PRICE, Constants.CHIP_PRICE);
        pricesLabel.setText(prices);
    }
}
