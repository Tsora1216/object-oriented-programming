// Exercise 13T: Rainfall Graph Tester
package ex13;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class RailfallGraphTester extends Application {

    RailfallGraph app;
    String appName = "RainfallGraph";
    int score = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s Test started\n", appName);
            app = new RailfallGraph();
            app.start(primaryStage);

            System.out.print("--- Checking Scene ... ");
            Scene scene = primaryStage.getScene();
            if (scene != null) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            System.out.print("--- Checking Pie title ... ");
            if (app.pieChart.getTitle() != null) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
            }

            System.out.printf("--- Checkin Pie data ...");
            ObservableList<PieChart.Data> pieList = app.pieChart.getData();
            if (pieList.size() == 12) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            System.out.printf("--- Checking 1st month ...");
            if (pieList.get(0).getName().contains("1")) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Filed");
                printScore();
                return;
            }

            System.out.printf("--- Checking 1st month value ...");
            if (pieList.get(0).getPieValue() == 43.5) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Filed");
                printScore();
                return;
            }

            System.out.print("--- Checking Bar Y label ... ");
            if (app.yAxis.getLabel() != null) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
            }

            System.out.printf("--- Checking Bar data ...");
            ObservableList<XYChart.Series<String, Number>> barList = app.barChart.getData();
            if (barList.size() == 1) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            System.out.printf("--- Checking Series[0] ...");
            ObservableList<XYChart.Data<String, Number>> series = barList.get(0).getData();
            if (series.size() == 12) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            System.out.printf("--- Checking 12th month ...");
            if (series.get(11).getXValue().contains("12")) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            System.out.printf("--- Checking 12th month value ...");
            if ((double) series.get(11).getYValue() == 116) {
                System.out.println("Success");
                score += 1;
            } else {
                System.out.println("Failed");
                printScore();
                return;
            }

            primaryStage.close();
            System.out.printf("%s Test completed\n", appName);
            printScore();
        } catch (Exception e) {
            printScore();
            e.printStackTrace();
        }
    }

    void printScore() {
        System.out.println(String.format("\n[[%s: {%s %s} SCORE:%d]]",
                appName, app.gakuban, app.yourname, score));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
