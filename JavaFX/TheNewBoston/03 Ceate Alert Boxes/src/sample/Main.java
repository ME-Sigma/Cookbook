package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button1;
    Label label1;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Creative Title here");

        label1 = new Label();
        label1.setText("Default text");

        //AlertBox
        /*
        //button1 = new Button("Click me!");
        //button1.setOnAction(e -> AlertBox.display("AlertBoxTitle","message"));
         */

        //ConfirmBox
        button1 = new Button("Click me!");
        button1.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of Window","Are you sure?");
            if(result){
                label1.setText("True");
            }else{
                label1.setText("False");
            }
        });

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label1,button1);

        //StackPane layout = new StackPane();
        //layout.getChildren().addAll(new Rectangle(100,100, Color.BLUE), new Label("Go!"));

        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();

    }



}
