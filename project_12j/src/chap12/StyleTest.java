package chap12;
// Listing 12-1: Style test

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StyleTest extends Application {

    Label label;
    Button button;
    String[] styles = { null,
            "-fx-font: bold 12pt serif;",
            "-fx-text-fill: red;",
            "-fx-text-alignment: right;",
            "-fx-padding: 10;",
            "-fx-border-color: green;",
            "-fx-border-color: green;\n-fx-border-width: 3;",
            "-fx-border-color: green;\n-fx-border-width: 3;\n-fx-border-radius: 20;",
            "-fx-background-color: yellow;",
            "-fx-background-color: yellow;\n-fx-background-radius: 20;",
            "-fx-background-image: url(\"check.png\");\n" +
                    "-fx-font: bold 12pt sans-serif;\n-fx-wrap-text: true;",
    };
    int current = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create the label and button
        label = new Label();
        button = new Button("Next Stryle");
        button.setOnAction(e -> nextStyle());
        nextStyle();

        // Show Layout
        VBox vbox = new VBox(10, label, button);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Style test");
        primaryStage.show();
    }

    public void nextStyle() {
        label.setText("This label is using the following style\n" +
                styles[current]);
        button.setStyle(styles[current]);
        label.setStyle(styles[current]);
        current = (current + 1) % styles.length;
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--CSSTest");
    }

}
