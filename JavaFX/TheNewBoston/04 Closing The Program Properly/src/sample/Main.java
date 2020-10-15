package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProram();
        });
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setTitle("Hello Sky");
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();

        primaryStage.setTitle("Closing the Program Properly");
        button = new Button();
        button.setText("Close Program");
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
        button.setOnAction(e -> closeProram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout , 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void closeProram(){
        Boolean answer = ConfirmBox.display("Close Program?","Are you sure you want to exit?");
        if(answer){
            System.out.println("Program will close!");
            window.close();
        }else{
            System.out.println("Program will NOT close!");
        }
    }


}
