//Listing 13-4: ScatterChartSample1.java

package Chap13.scatterchartsample;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScatterChartSample1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // データを準備
        ArrayList<DairyData> list = new ArrayList<>();
        list.add(new DairyData(1, 27.1, 17.3));
        list.add(new DairyData(2, 28.1, 17.6));
        list.add(new DairyData(3, 27.2, 17.3));
        list.add(new DairyData(4, 25.6, 15.8));
        list.add(new DairyData(5, 26.2, 18.2));
        list.add(new DairyData(6, 18.4, 15.7));
        list.add(new DairyData(7, 19.8, 15.3));
        list.add(new DairyData(8, 20.5, 14.7));
        list.add(new DairyData(9, 24.7, 15.9));
        list.add(new DairyData(10, 25.2, 18.0));
        list.add(new DairyData(11, 25.4, 19.4));
        list.add(new DairyData(12, 26.6, 18.0));
        list.add(new DairyData(13, 27.4, 17.0));
        list.add(new DairyData(14, 18.6, 15.4));
        list.add(new DairyData(15, 18.7, 15.1));
        list.add(new DairyData(16, 24.1, 17.3));
        list.add(new DairyData(17, 28.0, 19.1));
        list.add(new DairyData(18, 25.9, 19.9));
        list.add(new DairyData(19, 28.9, 19.5));
        list.add(new DairyData(20, 30.3, 21.4));
        list.add(new DairyData(21, 30.1, 22.2));
        list.add(new DairyData(22, 28.6, 21.4));
        list.add(new DairyData(23, 26.2, 21.6));
        list.add(new DairyData(24, 32.6, 22.9));
        list.add(new DairyData(25, 35.4, 25.9));
        list.add(new DairyData(26, 36.2, 25.7));
        list.add(new DairyData(27, 35.7, 24.1));
        list.add(new DairyData(28, 35.1, 24.8));
        list.add(new DairyData(29, 35.4, 25.3));
        list.add(new DairyData(30, 36.4, 25.3));

        // 気温データを作成
        XYChart.Series<Number, Number> MinMaxTemp = new XYChart.Series<>();
        MinMaxTemp.setName("2022年6月");
        for (DairyData d : list) {
            MinMaxTemp.getData().add(new XYChart.Data<>(
                    d.minTempar, d.maxTempar));
        }

        // XY軸を作成
        NumberAxis xAxis = new NumberAxis(10, 30, 1);
        NumberAxis yAxis = new NumberAxis(10, 40, 1);
        xAxis.setLabel("最低気温（°C）");
        yAxis.setLabel("最高気温（°C）");

        // 散布図グラフを作成
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.getData().add(MinMaxTemp);
        scatterChart.setTitle("東京 気温");
        scatterChart.setLegendSide(Side.TOP);

        // 散布図グラフを表示
        StackPane stackPane = new StackPane(scatterChart);
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scatter Chart Sample1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ScatterChartSample1");
    }
}

class DairyData {

    public int day;
    public double maxTempar;
    public double minTempar;

    public DairyData(int day, double maxTempar, double minTempar) {
        this.day = day;
        this.maxTempar = maxTempar;
        this.minTempar = minTempar;
    }

    public String getDayString() {
        return Integer.toString(day);
    }

    @Override
    public String toString() {
        return String.format("(%d, %f, %f)", day, maxTempar, minTempar);
    }
}
