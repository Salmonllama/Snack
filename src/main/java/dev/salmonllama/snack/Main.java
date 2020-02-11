package dev.salmonllama.snack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    Button calcButton;
    TextField drinksField;
    TextField chipsField;

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/scenes/SnackScene.fxml"));
        Scene scene = new Scene(rootNode);

        calcButton = (Button) scene.lookup("#calcButton");
        drinksField = (TextField) scene.lookup("#drinksField");
        chipsField = (TextField) scene.lookup("#chipsField");

        calcButton.setOnAction(ae -> {
            Stage popup = showTotals();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.show();
        });

        stage.setTitle("ITP100 - W7 - Snack");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private boolean isValidInput() {
        String drinksAmount;
        String chipsAmount;
        try {
            drinksAmount = drinksField.getText();
            chipsAmount = chipsField.getText();
        } catch (NullPointerException npe) {
            return false;
        }

        return Calculator.isDouble(drinksAmount) && Calculator.isDouble(chipsAmount);
    }

    public Stage showTotals() {
        Stage stage = new Stage();
        VBox rootNode = new VBox();
        rootNode.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);

        Label errL = new Label();

        Label drinksCostL = new Label();
        Label chipsCostL = new Label();
        Label subtotalL = new Label();
        Label taxL = new Label();
        Label totalL = new Label();

        Button close = new Button("close");
        close.setOnAction(ae -> stage.close());

        if (!isValidInput()) {
            errL.setText("Your values are incorrect");
            rootNode.getChildren().addAll(errL, close);
            return stage;
        }

        double drinkAmt = Double.parseDouble(drinksField.getText());
        double chipsAmt = Double.parseDouble(chipsField.getText());

        double drinksCost = Calculator.drinksTotal(drinkAmt);
        double chipCost = Calculator.chipsTotal(chipsAmt);
        double subtotal = Calculator.subtotal(drinkAmt, chipsAmt);
        double tax = Calculator.calcTax(drinkAmt, chipsAmt);
        double total = Calculator.grandTotal(drinkAmt, chipsAmt);

        drinksCostL.setText(String.format("Cost of drinks: $%.2f", drinksCost));
        chipsCostL.setText(String.format("Cost of chips: $%.2f", chipCost));
        subtotalL.setText(String.format("Subtotal: $%.2f", subtotal));
        taxL.setText(String.format("Tax: $%.2f", tax));
        totalL.setText(String.format("Grand total: $%.2f", total));

        rootNode.getChildren().addAll(
                drinksCostL,
                chipsCostL,
                subtotalL,
                taxL,
                totalL,
                close
        );

        return stage;
    }
}
