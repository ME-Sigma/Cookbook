package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
        window.setTitle("Checkbox Example");

        //Labels
        Label label = new Label("Order Your Sandwich!");

        //Buttons
        button = new Button();
        button.setText("Order Now!");

        //Checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        box1.setSelected(true);
        CheckBox box2 = new CheckBox("Tuna");
        CheckBox box3 = new CheckBox("Egg");



        //button EventHandler using Lambda expression
        button.setOnAction(e -> handleOptions(box1,box2,box3));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label, box1, box2, box3, button);

        Scene scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }

    //Handel CheckBox options
    private void handleOptions(CheckBox box1,CheckBox box2,CheckBox box3){
        System.out.println("You ordered a sandwich with:");
        if(box1.isSelected()){System.out.println("Bacon");}
        if(box2.isSelected()){System.out.println("Tuna");}
        if(box3.isSelected()){System.out.println("Egg");}
        System.out.println();
    }

}
