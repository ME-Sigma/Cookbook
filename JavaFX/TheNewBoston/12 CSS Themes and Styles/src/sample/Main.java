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

    int style = 0;
    Scene scene;
    Stage window;
    Button button_changeTheme;

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
        label_username.setStyle("-fx-text-fill: #ab4642"); //this is an inline Style (overwrites CSS Styles)
        Label label_password = new Label("Password");
        label_password.setId("bold-label");                 //Style via ID

        TextField text_username = new TextField("Username");
        TextField text_password = new TextField();
        text_password.setPromptText("password");

        Button button_signin = new Button("Sign In");
        button_signin.getStyleClass().add("button-blue");
        button_signin.setOnAction(e -> {
            System.out.println("Username: " + text_username.getText());
            System.out.println("Password: " + text_password.getText());
            System.out.println();
        });


        button_changeTheme = new Button("Change Theme");
        button_changeTheme.setOnAction(e -> changeThemes());


        GridPane.setConstraints(label_username,0,0);
        GridPane.setConstraints(label_password,0,1);
        GridPane.setConstraints(text_username,1,0);
        GridPane.setConstraints(text_password,1,1);
        GridPane.setConstraints(button_signin,1,2);
        GridPane.setConstraints(button_changeTheme,1,3);

        grid.getChildren().addAll(label_username,label_password,text_username,text_password,button_signin,button_changeTheme);

        scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();


    }

    private void changeThemes(){
        switch (style){
            case 0:
                setUserAgentStylesheet(STYLESHEET_CASPIAN);
                button_changeTheme.setText("Change Theme [" + style + "]");
                style = 1;
                break;
            case 1:
                //Custom Style
                scene.getStylesheets().add("CustomTheme1.css");
                button_changeTheme.setText("Change Theme [" + style + "]");
                style = 2;
                break;
            default:
                setUserAgentStylesheet(STYLESHEET_MODENA);
                button_changeTheme.setText("Change Theme [" + style + "]");
                style = 0;
        }
    }

}
