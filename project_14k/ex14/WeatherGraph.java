// レポート第3回: Weather Graph Application
package ex14;

import javafx.application.Application;
import javafx.stage.Stage;

public class WeatherGraph extends Application {

    public static String gakuban = "20EC000"; // 学籍番号を入力すること
    public static String yourname = "千住旭"; // 氏名を入力すること

    @Override
    public void start(Stage primaryStage) {
        // プログラムを作成

        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了 " + gakuban + " " + yourname);
    }

}

/* 考察 -- 調査したこと、工夫したこと、確認したことを記述




 */