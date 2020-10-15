package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private int screenBoundsX, screenBoundsY;
    StackPane pane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenBoundsX = (int) primaryScreenBounds.getWidth();
        screenBoundsY = (int) primaryScreenBounds.getHeight();
        //screenBoundsX = 800;
        //screenBoundsY = 600;
        System.out.println(screenBoundsX + "," + screenBoundsY);

        Scene scene = new MainMenuScene(pane);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
