package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("MyTitle");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label label_username = new Label("Username");
        Label label_password = new Label("Password");

        TextField text_username = new TextField("Username");
        TextField text_password = new TextField();
        text_password.setPromptText("password");

        Button button_signin = new Button("Sign In");
        button_signin.setOnAction(e -> {
            System.out.println("Username: " + text_username.getText());
            System.out.println("Password: " + text_password.getText());
            System.out.println();
        });

        GridPane.setConstraints(label_username,0,0);
        GridPane.setConstraints(label_password,0,1);
        GridPane.setConstraints(text_username,1,0);
        GridPane.setConstraints(text_password,1,1);
        GridPane.setConstraints(button_signin,1,2);

        grid.getChildren().addAll(label_username,label_password,text_username,text_password,button_signin);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }


}
