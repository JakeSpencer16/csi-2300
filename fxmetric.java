
package real_java_fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class fxmetric extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Input box
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number");

        // Unit Selection
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("pounds", "mph", "seconds", "joules");
        unitComboBox.setValue("pounds"); // Set a default value

        // Conversion Button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> {
            try {
                double num = Double.parseDouble(inputField.getText());
                String unit = unitComboBox.getValue();

                double result = 0;
                String resultUnit = ""; // this part of adding the new unit took foreverrr
                switch (unit) {
                    case "pounds":
                        result = num * 453;
                        resultUnit = "grams";
                        break;
                    case "mph":
                        result = num * 1.60943;
                        resultUnit = "km/h";
                        break;
                    case "seconds":
                        result = num / 60;
                        resultUnit = "minutes";
                        break;
                    case "joules":
                        result = num / 4.184;
                        resultUnit = "calories";
                        break;
                    default:
                        break;
                }

                // Display Result
                Label resultLabel = new Label("Result: " + result + " " + resultUnit);
                resultLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

                // box settings
                VBox resultDialog = new VBox(10, resultLabel);
                resultDialog.setAlignment(Pos.CENTER);
                resultDialog.setPadding(new Insets(20));
                Scene resultScene = new Scene(resultDialog, 250, 100);
                Stage resultStage = new Stage();
                resultStage.setTitle("Conversion Result");
                resultStage.setScene(resultScene);
                resultStage.show();

            } 
            
            catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid number input. Please enter a valid number.");
            }
        });

        // Layout for boxes
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(new Label("Number:"), 0, 0);
        gridPane.add(inputField, 1, 0);
        gridPane.add(new Label("Unit:"), 0, 1);
        gridPane.add(unitComboBox, 1, 1);
        gridPane.add(convertButton, 1, 2);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}