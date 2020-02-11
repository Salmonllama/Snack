package dev.salmonllama.snack.scenes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }
}
