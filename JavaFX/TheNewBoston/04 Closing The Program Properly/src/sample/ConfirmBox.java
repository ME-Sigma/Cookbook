package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        //Blocks user interaction with other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);
        Label label1 = new Label();
        label1.setText(message);
        Button b_Yes = new Button("Yes");
        b_Yes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        Button b_No = new Button("No");
        b_No.setOnAction(e -> {
            answer = false;
            window.close();
        });



        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1,b_Yes,b_No);
        layout1.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout1);
        window.setScene(scene1);
        window.showAndWait();

        return answer;
    }

}
