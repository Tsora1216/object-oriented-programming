// Listing 13-1: PieChartSample1.java

package Chap13.piechartsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartSample1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // データを準備
        PieChart.Data[] pieChartData = new PieChart.Data[5];
        pieChartData[0] = new PieChart.Data("Apples", 30);
        pieChartData[1] = new PieChart.Data("Oranges", 25);
        pieChartData[2] = new PieChart.Data("Pears", 22);
        pieChartData[3] = new PieChart.Data("Grapefruit", 13);
        pieChartData[4] = new PieChart.Data("Plums", 10);

        // 円グラフを作成
        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(pieChartData);
        pieChart.setTitle("Imported Fruits");
        pieChart.setClockwise(true);
        pieChart.setStartAngle(90);

        // 円グラフを表示
        StackPane stackPane = new StackPane(pieChart);
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Imported Fruits");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--PieChartSample1");
    }
}
