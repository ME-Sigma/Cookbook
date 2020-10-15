package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        window.setTitle("MyTitle");
        button = new Button();
        button.setText("Button1");
        //button EventHandler using an inner class
        /*
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("I am an anonymous inner class!");
            }
        });
         */
        //button EventHandler using Lambda expression
        button.setOnAction(e -> {
            System.out.println("This is an Event handled by a lambda expression");
            System.out.println("And this is a lambda expression with multiple lines");
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(button);

        Scene scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }


}
