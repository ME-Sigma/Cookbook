package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Menues");

        //File Menu
        Menu fileMenu = new Menu("_File");                                  // "_" creates a shortcut for the user to select the menu pressing Alt + the underlined letter

        //File Menu Items
        MenuItem newFileMenuItem = new MenuItem("New...");                  // "..." means, a new window will open if clicked
        newFileMenuItem.setOnAction(e -> System.out.println("TODO: A new window should open!"));
        fileMenu.getItems().add(newFileMenuItem);

        MenuItem openFileMenuItem = new MenuItem("Open...");                  // "..." means, a new window will open if clicked
        openFileMenuItem.setOnAction(e -> System.out.println("TODO: A new window should open!"));
        fileMenu.getItems().add(openFileMenuItem);

        MenuItem saveFileMenuItem = new MenuItem("Save...");                  // "..." means, a new window will open if clicked
        saveFileMenuItem.setOnAction(e -> System.out.println("TODO: A new window should open!"));
        fileMenu.getItems().add(saveFileMenuItem);

        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem settingsMenuItem = new MenuItem("Settings...");                  // "..." means, a new window will open if clicked
        settingsMenuItem.setOnAction(e -> System.out.println("TODO: A new window should open!"));
        fileMenu.getItems().add(settingsMenuItem);

        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem exitMenuItem = new MenuItem("Exit...");                  // Nothing (no dots) mean, that no new window, etc will open
        exitMenuItem.setOnAction(e -> System.out.println("TODO: Exit program"));
        fileMenu.getItems().add(exitMenuItem);


        //Edit Menu
        Menu editMenu = new Menu("_Edit");                                // "_" creates a shortcut for the user to select the menu pressing Alt + the underlined letter

        //Edit Menu Items
        MenuItem editMenuItem = new MenuItem("Edit...");                  // "..." means, a new window will open if clicked
        editMenuItem.setOnAction(e -> System.out.println("TODO: A new window should open!"));
        editMenu.getItems().add(editMenuItem);

        MenuItem cutMenuItem = new MenuItem("Cut");
        cutMenuItem.setOnAction(e -> System.out.println("This option should be greyed out and not clickable!"));
        cutMenuItem.setDisable(true);                                        //MenuItem is disabled
        editMenu.getItems().add(cutMenuItem);



        //Help Menu
        Menu helpMenu = new Menu("_Help");                                // "_" creates a shortcut for the user to select the menu pressing Alt + the underlined letter

        //Help Menu Items
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line numbers");
        });
        helpMenu.getItems().add(showLines);

        CheckMenuItem autoSave = new CheckMenuItem("Autosave");
        autoSave.setOnAction(e -> {
            if(autoSave.isSelected())
                System.out.println("Autosave enabled");
            else
                System.out.println("Autosave disabled");
        });
        helpMenu.getItems().add(autoSave);
        autoSave.setSelected(true);


        //RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        easy.setToggleGroup(difficultyToggle);
        RadioMenuItem medium = new RadioMenuItem("Medium");
        medium.setToggleGroup(difficultyToggle);
        RadioMenuItem hard = new RadioMenuItem("Hard");
        hard.setToggleGroup(difficultyToggle);
        difficultyMenu.getItems().addAll(easy,medium,hard);
        medium.setSelected(true);


        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu,difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout , 400, 300);
        window.setScene(scene);
        window.show();


    }


}
