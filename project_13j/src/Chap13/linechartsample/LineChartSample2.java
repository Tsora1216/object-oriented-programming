// Listing 13-3: LineChartSample2.java

package Chap13.linechartsample;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LineChartSample2 extends Application {

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

        // 最高気温データを作成
        XYChart.Series<String, Number> maxTempar = new XYChart.Series<>();
        maxTempar.setName("最高気温");
        for (DairyData d : list) {
            maxTempar.getData().add(new XYChart.Data<>(
                    d.getDayString(), d.maxTempar));
        }

        // 最低気温データを作成
        XYChart.Series<String, Number> minTempar = new XYChart.Series<>();
        minTempar.setName("最低気温");
        for (DairyData d : list) {
            minTempar.getData().add(new XYChart.Data<>(
                    d.getDayString(), d.minTempar));
        }

        // XY軸を作成
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("日");
        yAxis.setLabel("気温（°C）");

        // 折れ線グラフを作成
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(maxTempar);
        lineChart.getData().add(minTempar);
        lineChart.setCreateSymbols(false);
        lineChart.setTitle("東京 2022年6月");
        lineChart.setLegendSide(Side.TOP);

        // 折れ線グラフを表示
        StackPane stackPane = new StackPane(lineChart);
        Scene scene = new Scene(stackPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Line Chart Sample2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--LineChartSample2");
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
