package sample;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Properties");

        button = new Button();
        button.setText("Button1");

        //Bind examples
        /*
        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");


        Person person1 = new Person();
        person1.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + person1.firstNameProperty());
            System.out.println("getFirstName(): " + person1.getFirstName());
        });

        //button EventHandler using Lambda expression
        button.setOnAction(e -> {
            person1.setFirstName("New name");
        });

        */

        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel,secondLabel);
        bottomText.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        secondLabel.textProperty().bind(userInput.textProperty());
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(button,userInput,bottomText);

        Scene scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }


}
