package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    Button button;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setTitle("Treeview");
        button = new Button();
        button.setText("Click me!");
        //button EventHandler using Lambda expression
        button.setOnAction(e -> {
            System.out.println("This is an Event handled by a lambda expression");
            System.out.println("And this is a lambda expression with multiple lines");
        });

        TreeItem<String> root, branch1, branch2;

        //root
        root = new TreeItem<>();
        root.setExpanded(true);

        //branch1
        branch1 = makeBranch("Fruits", root);
        makeBranch("Apple", branch1);
        makeBranch("Pear", branch1);
        makeBranch("Peach",branch1 );

        //branch2
        branch2 = makeBranch("Vegetable",root);
        makeBranch("Cauliflower", branch2);
        makeBranch("Broccoli", branch2);


        //create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue!=null)
                System.out.println(newValue.getValue());
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(tree,button);

        Scene scene = new Scene(layout , 300, 250);
        window.setScene(scene);
        window.show();


    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<String>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;

    }

}
