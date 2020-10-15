package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    Button button1, button2;
    TableView<Products> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        window.setTitle("MyTitle");
        //Add button
        button1 = new Button();
        button1.setText("Add");
        //Delete button
        button2 = new Button();
        button2.setText("Delete");

        //Name column
        TableColumn<Products, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //Price column
        TableColumn<Products, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //Quantity column
        TableColumn<Products, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(50);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Inputs
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(200);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        quantityInput  = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(50);


        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);


        //button EventHandler using Lambda expression
        button1.setOnAction(e -> {
            addToList(nameInput.getText(),priceInput.getText(),quantityInput.getText());
        });

        button2.setOnAction(e -> {
            deleteFromList();
        });


        HBox hBox_inputs = new HBox();
        hBox_inputs.setPadding(new Insets(10,0,0,0));
        hBox_inputs.setSpacing(10);
        hBox_inputs.getChildren().addAll(nameInput,priceInput,quantityInput);
        HBox hBox_buttons = new HBox();
        hBox_buttons.setPadding(new Insets(10,10,10,0));
        hBox_buttons.setSpacing(10);
        hBox_buttons.getChildren().addAll(button1,button2);

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(table,hBox_inputs,hBox_buttons);

        Scene scene = new Scene(layout , 500, 300);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Products> getProduct(){
        ObservableList<Products> products = FXCollections.observableArrayList();
        products.add(new Products("Laptop", 894.00,20));
        products.add(new Products("Headphone", 40.00,48));
        products.add(new Products("Beer", 1.00,50));
        products.add(new Products("Cup", 4.99,200));
        products.add(new Products("Girlfriend", 99999.00,1));
        return products;
    }

    public void addToList(String name, String price, String quantity){
        Products product = new Products();
        product.setName(name);
        //TODO: Try-catch to catch wrong inputs
        product.setPrice(Double.parseDouble(price));
        product.setQuantity(Integer.parseInt(quantity));
        table.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteFromList(){
        ObservableList<Products> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

}
