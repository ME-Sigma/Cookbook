package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message){
        Stage window = new Stage();

        //Blocks user interaction with other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);

        Label label1 = new Label();
        label1.setText(message);
        Button b_Close = new Button("Close the window");
        b_Close.setOnAction(e -> window.close());

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1,b_Close);
        layout1.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout1);
        window.setScene(scene1);
        window.showAndWait();

    }

}
