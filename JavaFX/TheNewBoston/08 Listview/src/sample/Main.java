package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setTitle("Listview");
        button = new Button();
        button.setText("Click me!");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man","Titanic","Contact","Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //button EventHandler using Lambda expression
        button.setOnAction(e -> buttonClicked());




        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);

        scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }

    private void buttonClicked(){
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String m: movies){
            message += m + "\n";
        }
        System.out.println(message);
    }

}