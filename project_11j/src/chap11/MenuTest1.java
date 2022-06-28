package chap11;
// Listing 11-1: Menu test1

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label message = new Label("No menu is selected.");

        // Create the File menu
        Menu menuFile = new Menu("File");
        MenuItem itemOpen = new MenuItem("Open");
        itemOpen.setOnAction(e -> message.setText("File/Open is selected."));
        MenuItem itemClose = new MenuItem("Close");
        itemClose.setOnAction(e -> message.setText("File/Close is selected."));
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnAction(e -> primaryStage.close());
        menuFile.getItems().addAll(itemOpen, itemClose, itemExit);

        // Create the other menus
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuHelp = new Menu("Help");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(message);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.setTitle("Menu test1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MenuTest1");
    }

}
