package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {

    private int screenBoundsX, screenBoundsY;

    StackPane pane;
    private Menu mainMenu;


    @Override
    public void start(Stage primaryStage) throws Exception{

/*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Vocabulary Trainer");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
 */


        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        screenBoundsX = (int) primaryScreenBounds.getWidth();
        screenBoundsY = (int) primaryScreenBounds.getHeight();
        //screenBoundsX = 800;
        //screenBoundsY = 600;
        System.out.println(screenBoundsX + "," + screenBoundsY);

        pane = new StackPane();
        pane.setPrefSize(screenBoundsX,screenBoundsY);
        //pane.prefHeightProperty().bind(pane.widthProperty());

        InputStream is = Files.newInputStream(Paths.get("res/images/MenuBackground.jpg"));
        Image img = new Image(is);
        is.close();

        MenuButton b = new MenuButton("name");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(screenBoundsX);
        imgView.setFitHeight(screenBoundsY);

        // Bind the Background image to the Window size
        imgView.fitHeightProperty().bind(pane.heightProperty());
        imgView.fitWidthProperty().bind(pane.widthProperty());

        System.out.println(pane.heightProperty() + "," + pane.widthProperty());

        mainMenu = new Menu();

        pane.getChildren().addAll(imgView, mainMenu);

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(e -> {
            if(e.getCode()== KeyCode.ESCAPE){
                if(!mainMenu.isVisible()){
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    mainMenu.setVisible(true);
                    ft.play();
                }else{
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), mainMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> mainMenu.setVisible(false));
                    ft.play();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class Menu extends Parent {
        public Menu(){
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            final int offset = 400;

            menu1.setTranslateX(offset);

            MenuButton btnResume = new MenuButton("RESUME");
            btnResume.setOnMouseClicked(e -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5),this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> this.setVisible(false));
                ft.play();
            });

            MenuButton btnOptions = new MenuButton("OPTIONS");
            btnOptions.setOnMouseClicked(e -> {
                getChildren().addAll(menu1);
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu0);
                tt.setToX(menu0.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5),menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });

            });

            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(e -> {
                System.exit(0);
            });

            MenuButton btnSound = new MenuButton("Screen size");
            btnSound.setOnMouseClicked(e -> {
            });

            MenuButton btnVideo = new MenuButton("VIDEO");
            btnVideo.setOnMouseClicked(e -> {
            });

            MenuButton btnBack = new MenuButton("BACK");
            btnBack.setOnMouseClicked(e -> {
                getChildren().addAll(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu1);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5),menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });

            });

            menu0.getChildren().addAll(btnResume,btnOptions,btnExit);
            menu1.getChildren().addAll(btnSound,btnVideo, btnBack);

            Rectangle bg = new Rectangle(screenBoundsX,screenBoundsY);
            //bg.heightProperty().bind(pane.heightProperty());
            //bg.widthProperty().bind(pane.widthProperty());
            bg.setFill(Color.GRAY);
            bg.setOpacity(0.4);

            getChildren().addAll(bg,menu0);
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
