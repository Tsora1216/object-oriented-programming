// Exercise 12T: AlphabetApp Tester
package ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlphabetAppTester extends Application {

    AlphabetApp app;
    String appName = "AlphabetApp";
    int score = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s Test started\n", appName);
            app = new AlphabetApp();
            app.start(primaryStage);

            Scene scene = findScene(primaryStage);
            if (scene != null) {
                score += 1;
            } else {
                printScore();
                return;
            }

            app.startGame();

            String[] kw = { "radius", "bold", "serif", "gold" };
            String style = app.buttons[0].getStyle();
            System.out.print("--- Checking Button ... ");
            if (style != null && !style.isEmpty()) {
                System.out.println("Success");
                score += 1;
                for (String k : kw) {
                    System.out.printf("--- Checking %s ... ", k);
                    if (style.contains(k)) {
                        System.out.println("Success");
                        score += 1;
                    } else
                        System.out.println("Failed");
                }
            } else
                System.out.println("Failed");

            for (int i = 1; i < 3; i++) {
                String next = app.alphabets.get(0);
                for (Button btn : app.buttons) {
                    if (!btn.isDisable() && btn.getText() != null
                            && btn.getText() == next) {
                        System.out.printf("--- Click %s ... ", next);
                        btn.fire();
                        if (btn.isDisable()) {
                            System.out.println("Success");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }

                        System.out.printf("--- Checking ArrayList ... ");
                        if (app.alphabets.size() == 16 - i) {
                            System.out.println("Success");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }

                        System.out.printf("--- Checking Remainings ... ");
                        if (Integer.toString(16 - i).equals(app.labelRemain.getText())) {
                            System.out.println("Success");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }
                        break;
                    }
                }
            }

            for (int i = 1; i < 2; i++) {
                String next = app.alphabets.get(0);
                for (Button btn : app.buttons) {
                    if (!btn.isDisable() && btn.getText() != null
                            && btn.getText() != next) {
                        System.out.printf("--- Click %s ... ", btn.getText());
                        btn.fire();
                        if (!btn.isDisable()) {
                            System.out.println("Success");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }

                        System.out.printf("--- Checking ArrayList ... ");
                        if (app.alphabets.size() == 14) {
                            System.out.println("Success");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }

                        System.out.printf("--- Checking Mistakes ... ");
                        if (Integer.toString(i).equals(app.labelMistake.getText())) {
                            System.out.println("Suucess");
                            score += 1;
                        } else {
                            System.out.printf("Failed\n");
                            printScore();
                            return;
                        }
                        break;
                    }
                }
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
                appName, app.gakuban, app.yourname, score * 10 / 15));
    }

    public static Scene findScene(Stage stage) {
        System.out.print("--- Starting Scene ... ");
        Scene scene = stage.getScene();
        if (scene != null) {
            System.out.println("Success");
            return scene;
        } else {
            System.out.println("Failed");
            return null;
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
