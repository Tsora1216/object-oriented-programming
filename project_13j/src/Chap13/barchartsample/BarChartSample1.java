// Listing 13-5: BarChartSample1.java

package Chap13.barchartsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BarChartSample1 extends Application {

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";

    @Override
    public void start(Stage primaryStage) {
        // データを準備
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data<>(austria, 25601.34));
        series1.getData().add(new XYChart.Data<>(brazil, 20148.82));
        series1.getData().add(new XYChart.Data<>(france, 10000));
        series1.getData().add(new XYChart.Data<>(italy, 35407.15));
        series1.getData().add(new XYChart.Data<>(usa, 12000));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data<>(austria, 57401.85));
        series2.getData().add(new XYChart.Data<>(brazil, 41941.19));
        series2.getData().add(new XYChart.Data<>(france, 45263.37));
        series2.getData().add(new XYChart.Data<>(italy, 117320.16));
        series2.getData().add(new XYChart.Data<>(usa, 14845.27));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data<>(austria, 45000.65));
        series3.getData().add(new XYChart.Data<>(brazil, 44835.76));
        series3.getData().add(new XYChart.Data<>(france, 18722.18));
        series3.getData().add(new XYChart.Data<>(italy, 17557.31));
        series3.getData().add(new XYChart.Data<>(usa, 92633.68));

        // XY軸を作成
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Country");
        yAxis.setLabel("Value");

        // 棒グラフを作成
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.setTitle("Country Summary");

        // 棒グラフを表示
        StackPane stackPane = new StackPane(barChart);
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bar Chart Sample1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--BarChartSample1");
    }
}
