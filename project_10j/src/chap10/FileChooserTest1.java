package chap10;
// Listing 10-6: FileChooser Test1

import java.io.File;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserTest1 extends Application {

    Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        label = new Label("No file is open.");
        label.setPadding(new Insets(10));
        label.setWrapText(true);

        // Create the Button
        Button button = new Button("Open");
        button.setOnAction(e -> openFile());

        // Create the pane and show the stage
        BorderPane pane = new BorderPane(label);
        BorderPane.setAlignment(label, Pos.TOP_LEFT);
        pane.setTop(button);
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Chooser test1");
        primaryStage.show();
    }

    public void openFile() {
        // Select the file
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files", "*.txt"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        File file = chooser.showOpenDialog(null);

        // Get the file information
        if (file != null) {
            String msg = "*** File information ***";
            msg += "\nisFile: " + file.isFile();
            msg += "\ngetName: " + file.getName();
            msg += "\ngetParent: " + file.getParent();
            msg += "\nlastModified: " + new Date(file.lastModified());
            msg += "\nlength: " + file.length();
            msg += "\ntoString: " + file.toString();
            label.setText(msg);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--FileChooserTest1");
    }
}
