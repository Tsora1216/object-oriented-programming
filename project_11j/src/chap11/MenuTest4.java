package chap11;
// Listing 11-4: Menu test4

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest4 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label message = new Label("No menu is selected.");

        // Create the View menu
        Menu menuView = new Menu("表示(_V)");
        CheckMenuItem checkTool = new CheckMenuItem("ツールバー(_T)");
        checkTool.setOnAction(e -> message.setText(
                "表示(_V) / ツールバー(_T) = " + checkTool.isSelected()));
        CheckMenuItem checkStatus = new CheckMenuItem("ステータスバー(_S)");
        checkStatus.setOnAction(e -> message.setText(
                "表示(_V) / ステータスバー(_S) = " + checkStatus.isSelected()));
        SeparatorMenuItem separator = new SeparatorMenuItem();
        
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioClassic = new RadioMenuItem("クラシック(_C)");
        radioClassic.setOnAction(e -> message.setText(
                "表示(_V) / クラシック(_C) = " + radioClassic.isSelected()));
        radioClassic.setToggleGroup(toggleGroup);
        RadioMenuItem radioModern = new RadioMenuItem("モダン(_M)");
        radioModern.setOnAction(e -> message.setText(
                "表示(_V) / モダン(_M) = " + radioModern.isSelected()));
        radioModern.setToggleGroup(toggleGroup);
        radioModern.setSelected(true);
        menuView.getItems().addAll(checkTool, checkStatus, separator,
                radioClassic, radioModern);

        // Create the Other menus
        Menu menuFile = new Menu("ファイル(_F)");
        MenuItem itemExit = new MenuItem("終了(_X)");
        itemExit.setOnAction(e -> primaryStage.close());
        menuFile.getItems().add(itemExit);
        Menu menuEdit = new Menu("編集(_E)");
        Menu menuHelp = new Menu("ヘルプ(_H)");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(message);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("Menu test4");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MenuTest4");
    }
    
}
--- Selecting Initial state ... Success
--- Selecting 前年 ... Success
--- Selecting 前月 ... Failed cause 西暦2022年5月28日(土) ?
--- Selecting 前日 ... Failed cause 西暦2022年6月27日(月) ?
--- Selecting 翌年 ... Failed cause 西暦2023年6月28日(水) ?
--- Selecting 翌月 ... Failed cause 西暦2022年7月28日(木) ?
--- Selecting 翌日 ... Failed cause 西暦2022年6月29日(水) ?
--- Selecting 翌日 ... Success
--- Selecting 今日 ... Success