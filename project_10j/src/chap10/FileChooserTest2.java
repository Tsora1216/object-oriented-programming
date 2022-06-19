package chap10;
// Listing 10-7: FileChooser Test2

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserTest2 extends Application {

    Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        label = new Label("No file is open.");
        label.setPadding(new Insets(10));
        label.setWrapText(true);
        label.setStyle("-fx-font-family: monospace;");

        // Create the Button
        Button button = new Button("Open");
        button.setOnAction(e -> openFile());

        // Create the pane and show the stage
        BorderPane pane = new BorderPane(label);
        pane.setTop(button);
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Chooser test2");
        primaryStage.show();
    }

    public void openFile() {
        // Select the file
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files", "*.txt"),
                new FileChooser.ExtensionFilter("Java source files", "*.java"));
        File file = chooser.showOpenDialog(null);

        // Show the file information
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String msg = "";
                String line = br.readLine();
                while (line != null) {
                    msg += line + "\n";
                    line = br.readLine();
                }
                label.setText(msg);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--FileChooserTest2");
    }
}
