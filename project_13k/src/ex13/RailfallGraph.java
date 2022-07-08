// Exercise 13: Rainfall Graph
package ex13;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RailfallGraph extends Application {

    public PieChart pieChart = new PieChart();
    public CategoryAxis xAxis = new CategoryAxis();
    public NumberAxis yAxis = new NumberAxis();
    public BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    public static double[] data = { // 2021年1月～12月
            43.5, 88.5, 173, 156, 99.5, 168.5, 310, 382.5, 222.5, 199.5, 93, 116 };

    public static String gakuban = "20EC070"; // 学籍番号を入力すること
    public static String yourname = "高矢空"; // 氏名を入力すること

    @Override
    public void start(Stage primaryStage) {
        makePieChart(); // 課題13-1
        makeBarChart(); // 課題13-2

        // Showing the Charts
        HBox hbox = new HBox(10, pieChart, barChart);
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Railfall Graph");
        primaryStage.show();
    }

    void makePieChart() {
        // 課題 13-1 のコード
        PieChart.Data[] pieChartData = new PieChart.Data[12];
        for (int i = 0; i < 12; i++) {
            pieChartData[i] = new PieChart.Data(i + 1 + "月", data[i]);
        }

        pieChart.getData().addAll(pieChartData);
        pieChart.setLegendSide(Side.RIGHT);
        pieChart.setTitle("2021年東京");
        pieChart.setClockwise(true);
        pieChart.setStartAngle(90);
    }

    void makeBarChart() {
        // 課題 13-2 のコード
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2021年東京");
        for (int i = 0; i < 12; i++) {
            series.getData().add(new XYChart.Data<>(i + 1 + "月", data[i]));
        }

        yAxis.setLabel("降水量（mm）");

        barChart.getData().add(series);
        barChart.setLegendSide(Side.TOP);
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--RailfallGraph");
    }
}