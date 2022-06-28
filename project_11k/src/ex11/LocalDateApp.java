// Exercise 11: Local Date App
package ex11;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LocalDateApp extends Application {

    public static String gakuban = "20EC070"; // 学籍番号を入力すること
    public static String yourname = "高矢空"; // 氏名を入力すること

    LocalDate date = LocalDate.now();
    MenuBar menuBar = new MenuBar();
    ContextMenu menuContext = new ContextMenu();
    Label label = new Label();
    Stage stage;
    boolean isWareki;

    // 西暦または和暦で日付を表示する
    public void showDate() {
        DateTimeFormatter df;
        if (isWareki)
            df = DateTimeFormatter.ofPattern("Gy年M月d日(E)").withChronology(JapaneseChronology.INSTANCE);
        else
            df = DateTimeFormatter.ofPattern("Gy年M月d日(E)");
        label.setText(df.format(date));
    }

    // メニューバーを作成する
    public void createMenuBar() {
        // 課題11-1のコードを記述
        //ファイル
        Menu menuFile = new Menu("ファイル");
        MenuItem itemtoday = new MenuItem("今日");
        itemtoday.setOnAction(e -> {date=LocalDate.now();showDate();});
        MenuItem itemClose = new MenuItem("終了");
        itemClose.setOnAction(e -> stage.close());
        menuFile.getItems().addAll(itemtoday, itemClose);
        
        //過去
        Menu menupast = new Menu("過去");
        MenuItem itemly = new MenuItem("前年");
        itemly.setOnAction(e -> {date=date.minusYears(1);showDate();});
        MenuItem itemlm = new MenuItem("前月");
        itemlm.setOnAction(e -> {date=date.minusMonths(1);showDate();});
        MenuItem itemld = new MenuItem("前日");
        itemld.setOnAction(e -> {date=date.minusDays(1);showDate();});
        menupast.getItems().addAll(itemly, itemlm,itemld);
        
        //過去
        Menu menufuture = new Menu("未来");
        MenuItem itemny = new MenuItem("翌年");
        itemny.setOnAction(e -> {date=date.plusYears(1);showDate();});
        MenuItem itemnm = new MenuItem("翌月");
        itemnm.setOnAction(e -> {date=date.plusMonths(1);showDate();});
        MenuItem itemnd = new MenuItem("翌日");
        itemnd.setOnAction(e -> {date=date.plusDays(1);showDate();});
        menufuture.getItems().addAll(itemny, itemnm,itemnd);
        
        menuBar.getMenus().addAll(menuFile,menupast,menufuture);
    }

    // コンテキストメニューを作成する
    public void createContextMenu() {
        // 課題11-2のコードを記述
    	MenuItem itemseireki = new MenuItem("西暦");
        itemseireki.setOnAction(e->{isWareki= false;showDate();});
        MenuItem itemwareki = new MenuItem("和暦");
        itemwareki.setOnAction(e->{isWareki= true;showDate();});
        
        menuContext.getItems().addAll(itemseireki,itemwareki);
        label.setContextMenu(menuContext);
    }

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;   // プライマリステージの参照
        createMenuBar();        // メニューバーの作成
        createContextMenu();    // コンテキストメニューの作成

        // Set everything and show on the stage
        label.setFont(new Font(24));
        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);
        pane.setCenter(label);
        showDate();
        primaryStage.setScene(new Scene(pane, 400, 100));
        primaryStage.setTitle("Local Date App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--LocalDateApp");
    }
}
