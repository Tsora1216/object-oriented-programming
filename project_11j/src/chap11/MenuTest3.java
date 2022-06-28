package chap11;
// Listing 11-3: Menu test3

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label message = new Label("No menu is selected.");

        // Create the Edit menu
        Menu menuEdit = new Menu("編集(_E)");
        MenuItem itemCut = new MenuItem("切り取り(_T)");
        itemCut.setOnAction(e
                -> message.setText("編集(_E) / 切り取り(_T) is selected."));
        MenuItem itemCopy = new MenuItem("コピー(_C)");
        itemCopy.setOnAction(e
                -> message.setText("編集(_E) / コピー(_C) is selected."));
        Menu menuPaste = new Menu("貼り付け(_P)");
        MenuItem itemPaste1 = new MenuItem("テキスト");
        itemPaste1.setOnAction(e
                -> message.setText("編集(_E) / 貼り付け(_P) / テキスト is selected."));
        MenuItem itemPaste2 = new MenuItem("画像");
        itemPaste2.setOnAction(e
                -> message.setText("編集(_E) / 貼り付け(_P) / 画像 is selected."));
        menuPaste.getItems().addAll(itemPaste1, itemPaste2);
        menuEdit.getItems().addAll(itemCut, itemCopy, menuPaste);

        // Create the Other menus
        Menu menuFile = new Menu("ファイル(_F)");
        MenuItem itemExit = new MenuItem("終了(_X)");
        itemExit.setOnAction(e -> primaryStage.close());
        menuFile.getItems().add(itemExit);
        Menu menuView = new Menu("表示(_V)");
        Menu menuHelp = new Menu("ヘルプ(_H)");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(message);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("Menu test3");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MenuTest3");
    }

}
