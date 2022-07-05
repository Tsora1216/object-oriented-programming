package chap12;
// Listing 12-4: Style Inheritance Test

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StyleInheritanceTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");

        // Create the Menu
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        button3.setStyle("-fx-background-radius: 50%;" +
                "-fx-text-fill: red;");

        // Create the TextField
        TextField tf1 = new TextField("TextField1");
        TextField tf2 = new TextField("TextField2");
        TextField tf3 = new TextField("TextField3");
        tf3.setStyle("-fx-alignment: bottom-right;");

        // Create the VBox
        VBox vbox1 = new VBox(10, label1, button1, tf1);
        VBox vbox2 = new VBox(10, label2, button2, tf2);
        vbox2.setStyle("-fx-font: italic 14pt serif;" +
                "-fx-border-color: black;" +
                "-fx-border-insets: 10px;");
        VBox vbox3 = new VBox(10, label3, button3, tf3);

        // Create the root and show the stage
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-font: bold 18pt sans-serif;");
        pane.setTop(vbox1);
        pane.setCenter(vbox2);
        pane.setBottom(vbox3);
        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Style Inheritance Test;");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--StyleInheritanceTest");
    }
}
