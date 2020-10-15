package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    Scene scene;
    Button button;
    ChoiceBox<String> choiceBox;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setTitle("ChoiceBox");
        button = new Button();
        button.setText("Click me!");

        choiceBox = new ChoiceBox<>();
        //getItem returns the observableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        //Add multiple Items
        choiceBox.getItems().addAll("Meatballs", "Ham", "Bacon");
        //Set Default value
        choiceBox.setValue("Apples");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "Saint Vincent",
                "Blackhat"
        );

        comboBox.setPromptText("What is you favorite movie?");
        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));
        comboBox.setEditable(true);

        //button EventHandler using Lambda expression
        button.setOnAction(e -> printMovie());

        //Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> System.out.println("Changing from " + oldValue + " to " + newValue)
        );


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, button, new Label("    ") ,choiceBox);

        scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }

    private void printMovie(){
        System.out.println(comboBox.getValue());
    }

}
