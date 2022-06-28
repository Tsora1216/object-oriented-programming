package chap11;
// Listing 11-5: Menu test5

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label message = new Label("Right click, please!");

        // Create the Context menu
        ContextMenu menuContext = new ContextMenu();
        MenuItem itemCut = new MenuItem("切り取り");
        itemCut.setOnAction(e
                -> message.setText("右クリック / 切り取り is selected."));
        MenuItem itemCopy = new MenuItem("コピー");
        itemCopy.setOnAction(e
                -> message.setText("右クリック / コピー is selected."));
        Menu menuPaste = new Menu("貼り付け");
        MenuItem itemPaste1 = new MenuItem("テキスト");
        itemPaste1.setOnAction(e
                -> message.setText("右クリック / 貼り付け / テキスト is selected."));
        MenuItem itemPaste2 = new MenuItem("画像");
        itemPaste2.setOnAction(e
                -> message.setText("右クリック / 貼り付け / 画像 is selected."));
        menuPaste.getItems().addAll(itemPaste1, itemPaste2);
        menuContext.getItems().addAll(itemCut, itemCopy, menuPaste);
        message.setContextMenu(menuContext);

        // Create the Other menus
        Menu menuFile = new Menu("ファイル(_F)");
        MenuItem itemExit = new MenuItem("終了(_X)");
        itemExit.setOnAction(e -> primaryStage.close());
        menuFile.getItems().add(itemExit);
        Menu menuEdit = new Menu("編集(_E)");
        Menu menuView = new Menu("表示(_V)");
        Menu menuHelp = new Menu("ヘルプ(_H)");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(message);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("Menu test5");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MenuTest5");
    }

}
